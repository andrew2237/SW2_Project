package mamgment;

import java.sql.*;

public class Assignment {

    public static String AssignmentName;
    public static String AssignmentDate;
    public static String AssignmentType;
    public static int CourseId;
    public static int Deletechoice;
    public static int Updatechoice;

    AssignmentInput input = new AssignmentInput();
    
    private AssignmentDatabaseManager AssignmentDB;

    public Assignment(AssignmentDatabaseManager AssignmentDB) {
        this.AssignmentDB = AssignmentDB;
        this.AssignmentDB.AssignmentConnectDB();
    }

    public void AssignmentsShowAll() {
        this.AssignmentDB.ShowAllAssignments();
    }

    public void AssignmentInsert() {
        CourseId = input.InputID();
        AssignmentName = input.InputName();
        AssignmentDate = input.InputDate();
        AssignmentType = input.InputType();

        this.AssignmentDB.insertAssignment_ToDatabase(CourseId, AssignmentName, AssignmentDate, AssignmentType);
    }

    public void AssignmentSearch() {
        AssignmentName = input.InputName();

        this.AssignmentDB.returnSearchResult_FromDatabase(AssignmentName);
    }

    public void AssignmentDelete() {
        Deletechoice = input.InputDeleteOptions();

        switch (Deletechoice) {
            case 1:
                this.AssignmentDB.deleteAll();
                break;
            case 2:
                AssignmentSearch();
                this.AssignmentDB.deleteByName();
                break;
            default:
                System.out.println("invalid choice");
        }
    }

    public void AssignmentUpdate() {

        AssignmentSearch();

        do {

            Updatechoice = input.InputUpdateOptions();

            switch (Updatechoice) {
                case 1:
                    updateAll();
                    break;
                case 2:
                    updateName();
                    break;
                case 3:
                    updateAssignmentDate();
                    break;
                case 4:
                    updateType();
                    break;
                case 5:
                    System.out.println("Assignment Data Updated");
                    break;
                default:
                    System.out.println("invalid value");
            }
        } while (Updatechoice != 5);
    }

    private void updateAll() {
        AssignmentName = input.InputName();
        AssignmentDate = input.InputDate();
        AssignmentType = input.InputType();

        this.AssignmentDB.UpdateAllQuery_Database(AssignmentName, AssignmentDate, AssignmentType);
    }

    private void updateName() {
        AssignmentName = input.InputName();
        this.AssignmentDB.UpdateNameQuery_Database(AssignmentName);
    }

    private void updateAssignmentDate() {
        AssignmentDate = input.InputDate();
        this.AssignmentDB.UpdateAssignmentDateQuery_Database(AssignmentDate);
    }

    private void updateType() {
        AssignmentType = input.InputType();
        this.AssignmentDB.UpdateTypeQuery_Database(AssignmentType);
    }

}

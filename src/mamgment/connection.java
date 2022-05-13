package mamgment;

import java.util.*;

public class connection {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --------------------------------------
        CourseDatabaseManager CourseDB = new CourseDatabaseManager();
        Course crs = new Course(CourseDB);
        ExamDataBaseManager ExamDB = new ExamDataBaseManager();
        Exam ex = new Exam(ExamDB);
        UserDataBaseManager UserDB = new UserDataBaseManager();
        Users usr = new Users(UserDB);
        AssignmentDatabaseManager AssignmentDB = new AssignmentDatabaseManager();
        Assignment ass = new Assignment(AssignmentDB);

        // --------------------------------------
        int mch;
        do {
            if (usr == null) {
                break;
            }
            int cho1;
            System.out.println(" 1- Exam module \n 2- Course module "
                    + "\n 3- Users module \n 4-Exit");
            cho1 = input.nextInt();
            switch (cho1) {
                case 1: // ------ EXAM MODULE ------
                    int choice;

                    do {
                        System.out.println("What do you need to do\n 1-insert\n 2-edit\n 3-search\n "
                                + "4-delete\n 5-exit");
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                ex.insertExam();
                                break;
                            case 2:
                                ex.ExamUpdate();
                                break;
                            case 3:
                                ex.ExamSearch();
                                break;
                            case 4:
                                ex.ExamDelete();
                                break;
                            case 5:
                                System.out.println("Bye!");
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    } while (choice != 5);
                    break;

                case 2: // ------ COURSE MODULE ------
                    int c;
                    do {
                        System.out.println("1- Course \n 2- Assignment \n 3- Generate reports \n 4-Exit");

                        c = input.nextInt();
                        switch (c) {
                            case 1:
                                int ch;
                                do {
                                    System.out.println("What do you want to do \n 1- Add Course \n 2-Delete Course"
                                            + "\n 3- Update Course \n 4-Exit");
                                    ch = input.nextInt();
                                    switch (ch) {
                                        case 1:
                                            crs.insert();
                                            break;
                                        case 2:
                                            crs.delete();
                                            break;
                                        case 3:
                                            crs.update();
                                            break;
                                        case 4:
                                            System.out.println("Exit");
                                            break;
                                        default:
                                            System.out.println("invalid value");
                                    }
                                } while (ch != 4);
                                break;

                            case 2:
                                int ch1;
                                do {
                                    System.out.println("What do you want to do \n 1- Add Assignment \n 2-Delete Assignment"
                                            + "\n 3- Update Assignment \n 4-Exit");
                                    ch1 = input.nextInt();
                                    switch (ch1) {
                                        case 1:
                                            ass.AssignmentInsert();
                                            break;
                                        case 2:
                                            ass.AssignmentDelete();
                                            break;
                                        case 3:
                                            ass.AssignmentUpdate();
                                            break;
                                        case 4:
                                            System.out.println("Exit");
                                            break;
                                        default:
                                            System.out.println("invalid value");
                                    }
                                } while (ch1 != 4);
                                break;

                            case 3:
                                System.out.println("Report about how students doing in each course");
                                crs.showAll();
                                ass.AssignmentsShowAll();
                                break;

                            case 4:
                                System.out.println("Exit");
                                break;
                        }

                    } while (c != 4);
                    break;

                case 3: // ------ USER MODULE ------
                    int ch1;
                    do {
                        System.out.println(" 1-Insert student \n 2-Insert teacher \n 3-Student Search"
                                + "\n 4- Teacher Search \n 5- Update Student \n 6- Update Teacher \n 7-Delete Student By ID\n 8-Delete Teacher By ID \n9-Delete all Student\n "
                                + "10-Delete all Teacher\n 11-Insert Student privrllige\n 12-Insert Teacher privrllige\n13-Delete privrllige\n 14-Block acces Student\n15-Block acces Teacher\n 16-Exit");
                        ch1 = input.nextInt();
                        switch (ch1) {
                            case 1:
                                usr.StudentInsert();
                                break;
                            case 2:
                                usr.TeacherInsert();
                                break;
                            case 3:
                                usr.studentsearch();
                                break;
                            case 4:
                                usr.teachersearch();
                                break;
                            case 5:
                                usr.update_st();
                                break;
                            case 6:
                                usr.update_te();
                                break;
                            case 7:
                                usr.deletestudentbyid();
                                break;
                            case 8:
                                usr.deleteteacherbyid();
                                break;
                            case 9:
                                usr.deletestudentsall();
                                break;
                            case 10:
                                usr.deleteteachersall();
                                break;
                            case 11:
                                usr.insertprivrlligestudent();
                                break;
                            case 12:
                                usr.insertprivrlligeteacher();
                                break;
                            case 13:
                                usr.deleteprivilege();
                                break;
                            case 14:
                                usr.blockaccessstudent();
                                break;
                            case 15:
                                usr.blockaccessteacher();
                                break;
                            case 16:
                                System.out.println("BYE!");
                                break;
                            default:
                                System.out.println("invalid value");
                        }
                    } while (ch1 != 16);
                    break;

                case 4:
                case 6:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("1-Choose another operation \n2-Exit");
            mch = input.nextInt();
        } while (mch == 1);

    }

}

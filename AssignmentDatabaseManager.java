package mamgment;

import java.sql.*;
import static mamgment.Assignment.*;

public class AssignmentDatabaseManager implements IAssignmentDB{

    public String query;
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/PL2";
    public static final String USER = "root";
    public static final String PASSWORD = "khaled1234";
    public static Connection con;
    public static Statement stmt;

    /**
     *
     */
    @Override
    public void AssignmentConnectDB() {
        con = null;
        stmt = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (con != null) {
                System.out.println("Connected");
            }
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Not Connected");
        }
    }

    @Override
    public void insertAssignment_ToDatabase(int CourseId, String AssignmentName, String AssignmentDate, String AssignmentType) {
        try {
            query = "INSERT INTO assignments (CourseId, AssignmentName, AssignmentDate,AssignmentType)"
                    + "VALUES ('" + CourseId + "','" + AssignmentName + "','" + AssignmentDate + "','" + AssignmentType + "')";

            stmt.executeUpdate(query);
            System.out.println("Data Inserted");
        } catch (Exception e) {
            System.out.println("Data not inserted");
        }
    }

    @Override
    public void returnSearchResult_FromDatabase(String AssignmentName) {
        try {
            query = "SELECT * FROM assignments WHERE AssignmentName= '" + AssignmentName + "'";
            ResultSet r = stmt.executeQuery(query);
            while (r.next()) {
                AssignmentName = r.getString("AssignmentName");
                AssignmentDate = r.getString("AssignmentDate");
                AssignmentType = r.getString("AssignmentType");
                System.out.println(AssignmentName + " - " + AssignmentDate + " - " + AssignmentType);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            query = "DELETE FROM assignments";
            stmt.executeUpdate(query);
            System.out.println("all assignments is deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteByName() {/*8yrt esmha changed the name from DeleteByID to deleteByName*/

        try {
            query = "DELETE FROM assignments WHERE AssignmentName = '" + AssignmentName + "'";
            stmt.executeUpdate(query);
            System.out.println("Assignment data deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void UpdateAllQuery_Database(String AssignmentName, String AssignmentDate, String AssignmentType) {
        try {
            query = "UPDATE assignments SET AssignmentName='" + AssignmentName + "',AssignmentDate= '" + AssignmentDate + "' ,AssignmentType='" + AssignmentType + "'"
                    + " WHERE AssignmentName='" + AssignmentName + "'";
            stmt.executeUpdate(query);
            System.out.println("Updated");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void UpdateNameQuery_Database(String AssignmentName) {
        try {

            query = "UPDATE assignments SET AssignmentName='" + AssignmentName + "'"
                    + " WHERE AssignmentName='" + AssignmentName + "'";
            stmt.executeUpdate(query);
            System.out.println("Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void UpdateAssignmentDateQuery_Database(String AssignmentDate) {
        try {
            query = "UPDATE assignments SET AssignmentDate= '" + AssignmentDate + "'"
                    + " WHERE AssignmentName='" + AssignmentName + "'";
            stmt.executeUpdate(query);
            System.out.println("Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void UpdateTypeQuery_Database(String Type) {
        try {
            query = "UPDATE assignments SET AssignmentType='" + AssignmentType + "'"
                    + " WHERE AssignmentName='" + AssignmentName + "'";
            stmt.executeUpdate(query);
            System.out.println("Updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void ShowAllAssignments() {
        try {
            query = "SELECT * FROM assignments";
            ResultSet r = stmt.executeQuery(query);
            System.out.println("--------------------------------");
            System.out.println("      Assignment     ");
            while (r.next()) {
                AssignmentName = r.getString("AssignmentName");
                AssignmentDate = r.getString("AssignmentDate");
                AssignmentType = r.getString("AssignmentType");

                System.out.println(AssignmentName + " - " + AssignmentDate + " - " + AssignmentType);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

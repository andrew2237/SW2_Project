package mamgment;

import java.sql.*;

public class ExamDataBaseManager implements IExamDB {

    private String query;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/manngment";
    private final String USER = "root";
    private final String PASSWORD = "1234";
    private Connection con;
    private Statement stmt;

    @Override
    public void ExamConnectDB() {
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
    public void insertExam_ToDatabase(int C_ID, int num_done, int num_exam, int total) {
        try {
            query = "INSERT INTO `exam`(C_ID, num_done, num_exam, total)" + " VALUES ('" + C_ID + "','" + num_done + "','" + num_exam + "','" + total + "')";
            stmt.executeUpdate(query);
            System.out.println("Data is inserted");
        } catch (Exception e) {
            System.out.println("no");
        }
    }

    @Override
    public void showAllExams(int C_ID, int num_done, int num_exam, int total) {
        try {
            query = "SELECT * FROM `exam`";
            ResultSet r = stmt.executeQuery(query);
            while (r.next()) {
                C_ID = r.getInt("courseId");
                num_done = r.getInt("num_done");
                num_exam = r.getInt("num_exam");
                total = r.getInt("total");
                System.out.println(C_ID + num_done + " - " + num_exam + " - " + total + " - ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void returnSearchResult_FromDatabase(int C_ID, int num_done, int num_exam, int total) {
        try {
            query = "SELECT * FROM `exam` WHERE C_ID='" + C_ID + "' ";
            ResultSet r = stmt.executeQuery(query);
            while (r.next()) {
                C_ID = r.getInt("C_ID");
                num_done = r.getInt("num_done");
                num_exam = r.getInt("num_exam");
                total = r.getInt("total");
                System.out.println(C_ID + num_done + " - " + num_exam + " - " + total + " - ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void UpdateAllQuery_Database(int C_ID, int num_done, int num_exam, int total) {
        try {
            query = "UPDATE `exam` SET`num_done`='" + num_done + "',`num_exam`='" + num_exam + "',`total`='" + total + "' WHERE courseId='" + C_ID + "' ";
            stmt.executeUpdate(query);
            System.out.println("Data is updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateBytotalQuery(int C_ID, int total) {
        try {

            query = "UPDATE `exam` SET`total`='" + total + "' WHERE courseId='" + C_ID + "' ";
            stmt.executeUpdate(query);
            System.out.println("Data is updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void updateBynum_ExamQuery(int C_ID, int num_exam) {
        try {
            query = "UPDATE `exam` SET`num_exam`='" + num_exam + "' WHERE courseId='" + C_ID + "' ";
            stmt.executeUpdate(query);
            System.out.println("Data is updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateByNumOfStudentTestedQuery(int C_ID, int num_done) {
        try {
            query = "UPDATE `exam` SET`num_done`='" + num_done + "' WHERE courseId='" + C_ID + "' ";
            stmt.executeUpdate(query);
            System.out.println("Data is updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            query = "DELETE FROM `exam`";
            stmt.executeUpdate(query);
            System.out.println("all data is deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(int C_ID) {
        try {
            query = "DELETE FROM `exam` WHERE courseID='" + C_ID + "'";
            stmt.executeUpdate(query);
            System.out.println("deleted by id");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

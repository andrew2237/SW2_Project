/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mamgment;

import java.sql.*;

/**
 *
 * @author beshoy
 */
public class UserDataBaseManager implements IUserDB {

    public static String query;
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/manngment";
    private final String USER = "root";
    private final String PASSWORD = "1234";
    public static Connection con;
    public static Statement stmt;

    @Override
    public void UserConnectDB() {
        con = null;
        stmt = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (con != null) {
                System.out.println("connected");
            }
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Not Connected");

        }
    }

    @Override
    public void insertStudent_ToDatabase(String Fname, String Lname, String email, int c_id) {
        try {
            query = "INSERT INTO `user_st`(id,Fname,Lname,email,c_id,grade) "
                    + "VALUES (null,'" + Fname + "','" + Lname + "','" + email + "','" + c_id + "','0')";
            stmt.executeUpdate(query);
            System.out.println("inserted");
        } catch (Exception e) {
            System.out.println("not inserted");
        }
    }

    @Override
    public void insertTeacher_ToDatabase(String Fname, String Lname, String email, int c_id) {
        try {
            query = "INSERT INTO `user_te`(id,Fname,Lname,email,c_id) "
                    + "VALUES (null,'" + Fname + "','" + Lname + "','" + email + "','" + c_id + "')";
            stmt.executeUpdate(query);
            System.out.println("inserted");
        } catch (Exception e) {
            System.out.println("not inserted");
        }
    }

    @Override
    public void returnStudentSearchResult_FromDatabase(int id, String Fname, String Lname, String email, int c_id, int grade) {
        try {
            query = "SELECT * FROM `user_st` WHERE id='" + id + "'";
            ResultSet r = stmt.executeQuery(query);
            while (r.next()) {
                id = r.getInt("id");
                Fname = r.getString("Fname");
                Lname = r.getString("Lname");
                email = r.getString("email");
                c_id = r.getInt("c_id");
                grade = r.getInt("grade");
                System.out.println(id + "/" + Fname + "/" + Lname + "/" + email + "/" + c_id + "/" + grade + "");
            }
        } catch (Exception e) {
            System.out.println("not inserted");
        }
    }

    @Override
    public void returnTeacherSearchResult_FromDatabase(int id, String Fname, String Lname, String email, int c_id) {
        try {
            query = "SELECT * FROM `user_te` WHERE id='" + id + "'";
            ResultSet r = stmt.executeQuery(query);
            while (r.next()) {
                id = r.getInt("id");
                Fname = r.getString("Fname");
                Lname = r.getString("Lname");
                email = r.getString("email");
                c_id = r.getInt("c_id");
                System.out.println(id + "/" + Fname + "/" + Lname + "/" + email + "/" + c_id + "");
            }
        } catch (Exception e) {
            System.out.println("not inserted");
        }
    }

    @Override
    public void UpdateStudent_Database(int id, String Fname, String Lname, String email, int c_id, int grade) {
        try {
            query = "UPDATE `user_st` SET id='" + id + "' , Fname='" + Fname + "' ,Lname='" + Lname + "' , email='" + email + "'  , c_id='" + c_id + "' , grade= '" + grade + "' WHERE id='" + id + "' ";

            stmt.executeUpdate(query);
            System.out.println("Updated");
        } catch (Exception e) {
            System.out.println("not Updated");

        }

    }

    @Override
    public void Updateteacher_Database(int id, String Fname, String Lname, String email, int c_id) {
        try {
            query = "UPDATE `user_te` SET id='" + id + "' , Fname='" + Fname + "' ,Lname='" + Lname + "' , email='" + email + "'  , c_id='" + c_id + "'WHERE id='" + id + "' ";
            stmt.executeUpdate(query);
            System.out.println("Updated");
        } catch (Exception e) {
            System.out.println("not Updated");

        }
    }

    @Override
    public void deletestudentsall() {
        try {
            query = "DELETE FROM `user_st`";
            stmt.executeUpdate(query);
            System.out.println("all data deleted");
        } catch (Exception e) {
            System.out.println("not deleted");
        }
    }

    @Override
    public void deleteteachersall() {
        try {
            query = "DELETE FROM `user_te` ";
            stmt.executeUpdate(query);
            System.out.println("all data deleted");
        } catch (Exception e) {
            System.out.println("not deleted");
        }
    }

    @Override
    public void deletestudentbyid(int id) {

        try {
            query = "DELETE FROM `user_st` WHERE id='" + id + "' ";
            stmt.executeUpdate(query);
            System.out.println("Student data deleted");
        } catch (Exception e) {
            System.out.println("not deleted");
        }
    }

    @Override
    public void deleteteacherbyid(int id) {

        try {
            query = "DELETE FROM `user_te` WHERE id='" + id + "'";
            stmt.executeUpdate(query);
            System.out.println("teacher data deleted");
        } catch (Exception e) {
            System.out.println("not deleted");
        }
    }

    @Override
    public void insertprivrlligestudent(int id, int c_id, String typee) {
        try {
            query = "INSERT INTO `privilege`(`id`,`c_id`,`type`, `update_lect`, `add_assig`, `update_assig`, `submit_assig`, `can_view`) VALUES (null,'" + c_id + "','" + typee + "','0','0','0','1','0')";
            stmt.executeUpdate(query);
            System.out.println("inserted");
        } catch (Exception e) {
            System.out.println("not inserted");
        }
    }

    @Override
    public void insertprivrlligeteacher(int id, int c_id, String typee) {

        try {
            query = "INSERT INTO `privilege`(`id`,`c_id`,`type`, `update_lect`, `add_assig`, `update_assig`, `submit_assig`, `can_view`) VALUES (null,'" + c_id + "','" + typee + "','1','1','1','0','1')";
            stmt.executeUpdate(query);
            System.out.println("inserted");
        } catch (Exception e) {
            System.out.println("not inserted");
        }
    }

    @Override
    public void deleteprivilege() {

        try {
            query = "DELETE FROM `privilege`";
            stmt.executeUpdate(query);
            System.out.println("all data deleted");
        } catch (Exception e) {
            System.out.println("not deleted");
        }
    }

    @Override
    public void blockaccessstudent(int id, String typee) {
        try {
            query = "INSERT INTO `privilege`(`id`, `type`, `update_lect`, `add_assig`, `update_assig`, `submit_assig`, `can_view`) VALUES (null,'" + typee + "','0','0','0','0','0')";
            stmt.executeUpdate(query);
            System.out.println("All featuers blocked");
        } catch (Exception e) {
            System.out.println("not inserted");
        }

    }

    @Override
    public void blockaccessteacher(int id, String typee) {
        try {
            query = "INSERT INTO `privilege`(`id`, `type`, `update_lect`, `add_assig`, `update_assig`, `submit_assig`, `can_view`) VALUES (null,'" + typee + "','0','0','0','0','0')";
            stmt.executeUpdate(query);
            System.out.println("All featuers blocked");
        } catch (Exception e) {
            System.out.println("not inserted");
        }

    }
}

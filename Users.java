package mamgment;

import java.sql.*;
import java.util.*;

public class Users {

    Scanner input = new Scanner(System.in);
    private String Fname, query, Lectuers, Assigment;
    private String Lname;
    private String email,typee;
    private int id;
    private int grade;
    private int type;
    private int c_id;
    final String DRIVER = "com.mysql.jdbc.Driver";
    final String URL = "jdbc:mysql://localhost/manngment";
    final String USER = "root";
    final String PASSWORD = "khaled1234";
    Connection con;
    Statement stmt;
    //final String USER = "root";
    //final String PASSWORD = "andrewsaed";
    Users() {
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

    public void insert() {

        int t;
        System.out.println("Please enter your type(1 or 2)");
        t = input.nextInt();

        switch (t) {
            case 1:
                System.out.println("Please enter user Fname and Sname");
                Fname = input.next();
                Lname = input.next();
                System.out.println("Please enter user email");
                email = input.next();
                System.out.println("Please enter user class id");
                c_id = input.nextInt();
                try {
                    query = "INSERT INTO `user_st`(id,Fname,Lname,email,c_id,grade) "
                            + "VALUES (null,'" + Fname + "','" + Lname + "','" + email + "','" + c_id + "','0')";
                    stmt.executeUpdate(query);
                    System.out.println("inserted");
                } catch (Exception e) {
                    System.out.println("not inserted");
                }
                break;

            case 2:
                System.out.println("Please enter user Fname and Sname");
                Fname = input.next();
                Lname = input.next();
                System.out.println("Please enter user email");
                email = input.next();
                System.out.println("Please enter user class id");
                c_id = input.nextInt();
                try {
                    query = "INSERT INTO `user_te`(id,Fname,Lname,email,c_id) "
                            + "VALUES (null,'" + Fname + "','" + Lname + "','" + email + "','" + c_id + "')";
                    stmt.executeUpdate(query);
                    System.out.println("inserted");
                } catch (Exception e) {
                    System.out.println("not inserted");
                }
                break;

        }
    }

    public void search() {

        int t;
        System.out.println("Please enter your type(1 or 2)");
        t = input.nextInt();
        switch (t) {
            case 1:
                System.out.println("Please enter student id");
                id = input.nextInt();
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
                break;
            case 2:
                System.out.println("Please enter teacher id");
                id = input.nextInt();
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
                break;

        }
    }

    public void update_st() {
        search();
        int t;
        System.out.println("update your Data");
        
                System.out.println("Please enter new student Fname and Sname");
                Fname = input.next();
                Lname = input.next();
                System.out.println("Please enter new student email");
                email = input.next();
                System.out.println("Please enter new student class id");
                c_id = input.nextInt();
                try {
                        query = "UPDATE `user_st` SET id='" + id + "' , Fname='" + Fname + "' ,Lname='" + Lname + "' , email='" + email + "'  , c_id='" + c_id + "' , grade= '" + grade + "' WHERE id='"+id+"' ";

                    stmt.executeUpdate(query);
                    System.out.println("Updated");
                } catch (Exception e) {
                    System.out.println("not Updated");
          
        }
    }
    
     public void update_te(){
          search();
           System.out.println("update your Data");
      System.out.println("Please enter new teacher Fname and Sname");
                Fname = input.next();
                Lname = input.next();
                System.out.println("Please enter new teacher email");
                email = input.next();
                System.out.println("Please enter new teacher class id");
                c_id = input.nextInt();
                try {
                    query = "UPDATE `user_te` SET id='" + id + "' , Fname='" + Fname + "' ,Lname='" + Lname + "' , email='" + email + "'  , c_id='" + c_id + "'WHERE id='"+id+"' ";
                    stmt.executeUpdate(query);
                    System.out.println("Updated");
                } catch (Exception e) {
                    System.out.println("not Updated");
     
     
     }
     }

    public void delete() {
        int t;
        System.out.println("please choose to delete by 1-delete all or 2-delete by id");
        t = input.nextInt();
        switch (t) {
            case 1:
                deleteAll();
                break;
            case 2:
                deleteById();
                break;
        }
    }

    public void deleteAll() {
        int t;
        System.out.println("Please enter your type(1 or 2)");
        t = input.nextInt();
        switch (t) {
            case 1:
                try {
                query = "DELETE FROM `user_st`";
                stmt.executeUpdate(query);
                System.out.println("all data deleted");
            } catch (Exception e) {
                System.out.println("not deleted");
            }
            break;
            case 2:
                try {
                query = "DELETE FROM `user_te` ";
                stmt.executeUpdate(query);
                System.out.println("all data deleted");
            } catch (Exception e) {
                System.out.println("not deleted");
            }
            break;

        }
    }

    public void deleteById() {
        int t;
        System.out.println("Please enter your type(1 or 2)");
        t = input.nextInt();
        switch (t) {
            case 1:
                System.out.println("Please enter student id");
                id = input.nextInt();
                try {
                    query = "DELETE FROM `user_st` WHERE id='" + id + "' ";
                    stmt.executeUpdate(query);
                    System.out.println("Student data deleted");
                } catch (Exception e) {
                    System.out.println("not deleted");
                }
                break;
            case 2:
                System.out.println("Please enter teacher id");
                id = input.nextInt();
                try {
                    query = "DELETE FROM `user_te` WHERE id='" + id + "'";
                    stmt.executeUpdate(query);
                    System.out.println("teacher data deleted");
                } catch (Exception e) {
                    System.out.println("not deleted");
                }
                break;

        }
    }

    public void insertprivrllige() {

               int t;
        System.out.println("Please enter your type(1 or 2)");
        t = input.nextInt();

        switch (t) {
            case 1:
                c_id=input.nextInt();
                typee = "Student";
                
                
                try {
                    query = "INSERT INTO `privilege`(`id`,`c_id`,`type`, `update_lect`, `add_assig`, `update_assig`, `submit_assig`, `can_view`) VALUES (null,'"+c_id+"','"+typee+"','0','0','0','1','0')";
                    stmt.executeUpdate(query);
                    System.out.println("inserted");
                } catch (Exception e) {
                    System.out.println("not inserted");
                }
                  
                break;
                
                
                case 2:
                 id=input.nextInt();
                typee = "Teacher";
                
                
                try {
                    query = "INSERT INTO `privilege`(`id`, `type`, `update_lect`, `add_assig`, `update_assig`, `submit_assig`, `can_view`) VALUES ('"+id+"','"+typee+"','1','1','1','0','1')";
                   stmt.executeUpdate(query);
                    System.out.println("inserted");
                } catch (Exception e) {
                    System.out.println("not inserted");
                }
                break;


        }
    }
    
    public void deleteprivilege() {
        
                try {
                query = "DELETE FROM `privilege`";
                stmt.executeUpdate(query);
                System.out.println("all data deleted");
            } catch (Exception e) {
                System.out.println("not deleted");
            }
           
           

        }
    
    
    public void blockAccess() {
               int t;
        System.out.println("Please enter your type(1 or 2)");
        t =input.nextInt();

        switch (t) {
             
         case 1:
                try {
                    query = "INSERT INTO `privilege`(`id`, `type`, `update_lect`, `add_assig`, `update_assig`, `submit_assig`, `can_view`) VALUES (null,'"+typee+"','0','0','0','0','0')";
                    stmt.executeUpdate(query);
                    System.out.println("All featuers blocked");
                } catch (Exception e) {
                    System.out.println("not inserted");
                }

                break;
                case 2:
                try {
                    query = "INSERT INTO `privilege`(`id`, `type`, `update_lect`, `add_assig`, `update_assig`, `submit_assig`, `can_view`) VALUES (null,'"+typee+"','0','0','0','0','0')";
                    stmt.executeUpdate(query);
                    System.out.println("All featuers blocked");
                } catch (Exception e) {
                    System.out.println("not inserted");
                }
                break;

    }
    }
}


package mamgment;

import java.sql.*;
import java.util.*;

public class Course {
    Scanner input = new Scanner(System.in);
    private int id;
    private String name;
    private String Date;
    private int num_student;
    private int num_lect;
    private String query;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/PL2";
    private final String USER = "root";
    private final String PASSWORD = "khaled1234";
    private Connection con;
    private Statement stmt ;
    
    Course(){
        con = null;
        stmt = null;
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if(con!=null)
                System.out.println("Connected");
            stmt = con.createStatement();
        }
        catch(Exception e){
            System.out.println("Not Connected");            
        }
    } 
         
        public void insert(){
             
            System.out.println("Please enter course name :");
            name = input.next();
            System.out.println("Please enter course date : ");
            Date = input.next();
            System.out.println("Please enter number of the student :");
            num_student = input.nextInt();
            System.out.println("Please enter number of the lecture :");
            num_lect = input.nextInt();
             
             try{
                query = "INSERT INTO courses (id, Name,Date,num_student,num_lect)" +
                        "VALUES (null ,'"+name+"','"+Date+"','"+num_student+"','"+num_lect+"')";
    
                stmt.executeUpdate(query);
                System.out.println("Data Inserted");
            }
            catch(Exception e){
                System.out.println("Data not inserted");
            }
        }
         
        public void search(){
            System.out.println("Please enter course id");
            id = input.nextInt();
             
            try{
                query = "SELECT * FROM courses WHERE id= '"+id+"'";
                ResultSet r = stmt.executeQuery(query);
                while(r.next()){
                    id = r.getInt("id");
                    name = r.getString("name");
                    Date = r.getString("Date");
                    num_student = r.getInt("num_student");
                    num_lect = r.getInt("num_lect");
                    System.out.println(id + "-" + name + "-" +Date + "-" + num_student + "-" + num_lect );               
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
         
        public void delete(){
            int ch;
            System.out.println("1- Delete all courses \n 2- Delete by ID");
            ch = input.nextInt();
            switch(ch){
                case 1 : deleteAll();
                break;
                case 2 : DeleteByID();
                break;
                default : System.out.println("invalid choice");
            }
         }
         
        public void deleteAll(){
            try{
                query = "DELETE FROM courses";
                stmt.executeUpdate(query);
                System.out.println("all data is deleted");
            }
            catch(Exception e){
                System.out.println(e);             }
            }
         
        public void DeleteByID(){
            search();
            try{
                query = "DELETE FROM courses WHERE id = '"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Course data deleted");
            }
            catch(Exception e){
                System.out.println(e);            
            }
        }
         
        public void update(){
             search();
             int ch;
             do{
                System.out.println("What do you want to update /n 1- Update ALL /n 2- Name /n 3- Date "
                    + "/n 4- Number of Student /n 5- Number of Lectures /n 6- No one");
                ch = input.nextInt();
                switch(ch){
                case 1 : updateAll(); break;
                case 2 : updateName(); break;
                case 3 : updateDate(); break;
                case 4 : updateNumOfStudents(); break;
                case 5 : updateNumOfLect(); break;
                case 6 : System.out.println("Course Data Updated"); break;
                default : System.out.println("invalid value");
             }
             }while(ch!=6);
        }
         
         public void updateAll(){
            try{
                System.out.println("Please enter new course name :");
                name = input.next();
                System.out.println("Please enter new course date : ");
                Date = input.next();
                System.out.println("Please enter new number of the student :");
                num_student = input.nextInt(); 
                System.out.println("Please enter new number of the lecture :");
                num_lect = input.nextInt();
                query = "UPDATE courses SET name='"+name+ "',Date= '"+Date+"' ,num_student='"+num_student+"'"
                        + " ,num_lect='"+num_lect+"'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
            }
  
         }
         
         public void updateName(){
             try{
                System.out.println("Please enter new course name :");
                name = input.next();
                query = "UPDATE courses SET name='"+name+ "'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
         
         public void updateDate(){
             try{
                System.out.println("Please enter new course date : ");
                Date = input.next();
                query = "UPDATE courses SET Date= '"+Date+"'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
         
         public void updateNumOfStudents(){
             try{
                System.out.println("Please enter new number of the student :");
                num_student = input.nextInt(); 
                query = "UPDATE courses SET num_student='"+num_student+"'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
         
         public void updateNumOfLect(){
             try{
                System.out.println("Please enter new number of the lecture :");
                num_lect = input.nextInt();
                query = "UPDATE courses SET num_lect='"+num_lect+"'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
          public void showAll(){
        
        try{
            query = "SELECT * FROM courses";
            ResultSet r = stmt.executeQuery(query);
            System.out.println("      Course     ");
            while(r.next()){
                id = r.getInt("id");
                name = r.getString("name");
                Date = r.getString("Date");
                num_student = r.getInt("num_student");
                num_lect= r.getInt("num_lect");
                
                System.out.println(id + " - " + name + " - " + Date + " - "
                + num_student + " - " + num_lect);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}

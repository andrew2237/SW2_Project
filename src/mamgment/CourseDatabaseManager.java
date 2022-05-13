/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mamgment;


import java.sql.*;

/**
 *
 * @author Tarook
 */
public class CourseDatabaseManager implements ICourseDB {
 
     private String query;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/manngment";
    private final String USER = "root";
    private final String PASSWORD = "1234";
    private Connection con;
    private Statement stmt ;
    
     @Override
    public void CourseConnectDB(){
    
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
    
     @Override
    public void insertCourse_ToDatabase(String name,String Date,int num_student , int num_lect){
    
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
    
    
     @Override
    public void returnSearchResult_FromDatabase(int id,String name,String Date,int num_student , int num_lect){
    
    
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
    
     @Override
     public void deleteAll(){
            try{
                query = "DELETE FROM courses";
                stmt.executeUpdate(query);
                System.out.println("all data is deleted");
            }
            catch(Exception e){
                System.out.println(e);             }
            }
         
     @Override
        public void DeleteByID(int id){
            try{
                query = "DELETE FROM courses WHERE id = '"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Course data deleted");
            }
            catch(Exception e){
                System.out.println(e);            
            }
        }
     @Override
        public void updateAll(int id,String name,String Date,int num_student , int num_lect){
         try{
                
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
        
        
     @Override
        public void updateName(int id,String name){
             try{
                
                query = "UPDATE courses SET name='"+name+ "'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
         
     @Override
     public void updateDate(int id,String Date){
             try{
                query = "UPDATE courses SET Date= '"+Date+"'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
     
     
     @Override
     public void updateNumOfStudents(int id,int num_student){
     
           try{
               
                query = "UPDATE courses SET num_student='"+num_student+"'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
     }
     
     @Override
         public void updateNumOfLect(int id, int num_lect){
         
          try{

                query = "UPDATE courses SET num_lect='"+num_lect+"'"
                        + " WHERE id='"+id+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
         
         }
         
         
     @Override
          public void showAll(int id,String name,String Date,int num_student , int num_lect){
        
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

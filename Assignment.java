package mamgment;

import java.sql.*;
import java.util.Scanner;

public class Assignment {
    Scanner input = new Scanner(System.in);
    private String ass_name; 
    private String Date;
    private String type;
    private int C_ID;
    private String query;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/PL2";
    private final String USER = "root";
    private final String PASSWORD = "khaled1234";
    private Connection con;
    private Statement stmt ;
    
    
    Assignment(){
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
             System.out.println("Please enter id of the coures");
             C_ID=input.nextInt();
            System.out.println("Please enter assignment name :");
            ass_name = input.next();
            System.out.println("Please enter assignment date : ");
            Date = input.next();
            System.out.println("Please enter assignment type :");
            type = input.next();
          
             try{
                query = "INSERT INTO assignments (C_ID,ass_name, Date,type)" +
                        "VALUES ('"+C_ID+"','"+ass_name+"','"+Date+"','"+type+"')";
    
                stmt.executeUpdate(query);
                System.out.println("Data Inserted");
            }
            catch(Exception e){
                System.out.println("Data not inserted");
            }
        }
    
    public void search(){
            System.out.println("Please enter assignment name");
            ass_name = input.next();
             
            try{
                query = "SELECT * FROM assignments WHERE ass_name= '"+ass_name+"'";
                ResultSet r = stmt.executeQuery(query);
                while(r.next()){
                    ass_name = r.getString("ass_name");
                    Date = r.getString("Date");
                    type = r.getString("type");
                    System.out.println(ass_name + "-" +Date + "-" + type  );               
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
    }
    
        public void delete(){
            int ch;
            System.out.println("1- Delete all assignments \n 2- Delete by Name");
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
                query = "DELETE FROM assignments";
                stmt.executeUpdate(query);
                System.out.println("all assignments is deleted");
            }
            catch(Exception e){
                System.out.println(e);             }
            }
         
        public void DeleteByID(){
            search();
            try{
                query = "DELETE FROM assignments WHERE ass_name = '"+ass_name+"'";
                stmt.executeUpdate(query);
                System.out.println("Assignment data deleted");
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
                    + "/n 4- Type /n 5-No one");
                ch = input.nextInt();
                switch(ch){
                case 1 : updateAll(); break;
                case 2 : updateName(); break;
                case 3 : updateDate(); break;
                case 4 : updateType(); break;
                case 5 : System.out.println("Assignment Data Updated"); break;
                default : System.out.println("invalid value");
             }
             }while(ch!=5);
        }
         
         public void updateAll(){
            try{
                System.out.println("Please enter new assignment name :");
                ass_name = input.next();
                System.out.println("Please enter new course date : ");
                Date = input.next();
                System.out.println("Please enter new type :");
                type = input.next(); 
                query = "UPDATE assignments SET ass_name='"+ass_name+ "',Date= '"+Date+"' ,type='"+type+"'"
                        + " WHERE ass_name='"+ass_name+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
            }
  
         }
         
         public void updateName(){
             try{
                System.out.println("Please enter new assignment name :");
                ass_name = input.next();
                query = "UPDATE assignments SET ass_name='"+ass_name+ "'"
                        + " WHERE ass_name='"+ass_name+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
         
         public void updateDate(){
             try{
                System.out.println("Please enter new assignment date : ");
                Date = input.next();
                query = "UPDATE assignments SET Date= '"+Date+"'"
                        + " WHERE ass_name='"+ass_name+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
         
         public void updateType(){
             try{
                System.out.println("Please enter new type :");
                type = input.next(); 
                query = "UPDATE assignments SET type='"+type+"'"
                        + " WHERE ass_name='"+ass_name+"'";
                stmt.executeUpdate(query);
                System.out.println("Updated");               
            }
            catch(Exception e){
                System.out.println(e);
         }
    }
         public void showAll(){
        
        try{
            query = "SELECT * FROM assignments";
            ResultSet r = stmt.executeQuery(query);
            System.out.println("--------------------------------");
                System.out.println("      Assignment     ");
            while(r.next()){
                ass_name = r.getString("ass_name");
                Date = r.getString("Date");
                type = r.getString("type");
                
                System.out.println(ass_name + " - " + Date + " - " + type );
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    } 

    

}

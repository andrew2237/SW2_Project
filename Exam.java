package mamgment;

import java.sql.*;
import java.util.Scanner;

public class Exam {
    Scanner input = new Scanner(System.in);
    private int C_ID;
    private int num_done;
    private int num_EXAM;
    private int total;
    private String query;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/PL2";
    private final String USER = "root";
    private final String PASSWORD = "khaled1234";
    private Connection con;
    private Statement stmt;
    Exam(){
        con=null;
        stmt=null;
        try {
            Class.forName(DRIVER);
             con=DriverManager.getConnection(URL,USER,PASSWORD);
             if (con!=null) {
                 System.out.println("Connected");
            }
             stmt=con.createStatement();
        } catch (Exception e) {
            System.out.println("Not Connected");
        }
    }
     public int correct(String Name,int id){
        num_done++;
        System.out.printf("the question:\n1: 1+2=....\na]3\tb]7"
                + " \n\n2: 4+5=...\na]8\tb]9 \n\n3: 9+0=....\na]10\tb]9 \n\n4: 2+2=...\na]4\tb]0\n\n");
      char[] answers = new char[4];
      for(int i=0;i<4;i++){
          String s=input.next();
          char x=Character.toUpperCase(s.charAt(0));
          answers[i]=x;
      }
    char[] keys = {'A', 'B', 'B', 'A'};
    int correctCount = 0;
    for (int i = 0; i < answers.length; i++) {
        if (answers[i] == keys[i])
          correctCount++;
    }
        System.out.println("your grade is "+correctCount);
        state(correctCount, total);
        return correctCount;
  }
     
     public void state(int v,int total){
        if(v==total)
            System.out.println("\ncongratulation you get A");
        else if(v<total&&v>total/1.5)
            System.out.println("\nyou get B");
        else if(v<total&&v>total/2)
            System.out.println("\nyou get C");
        else
            System.out.println("\nyou get D");
    }
    public void insert(){
        System.out.println("Please enter ID you want to insert to it");
        C_ID=input.nextInt();
        System.out.print("Please enter number of students that are tested:");
        num_done=input.nextInt();
        System.out.print("Please enter number of exam:");
        num_EXAM= input.nextInt();
        System.out.print("Please enter total of exam:");
        total= input.nextInt();
        try {
            query = "INSERT INTO `exam`(C_ID, num_done, num_EXAM, total)"+ " VALUES ('"+C_ID+"','"+num_done+"','"+num_EXAM+"','"+total+"')";
            stmt.executeUpdate(query);
            System.out.println("Data is inserted");
        } catch (Exception e) {
            System.out.println("no");
        }
    }
    public void showAll(){
        try {
            query="SELECT * FROM `exam`";
            ResultSet r = stmt.executeQuery(query);
            while (r.next()) {
                C_ID=r.getInt("C_ID");
                num_done=r.getInt("num_done");
                num_EXAM=r.getInt("num_EXAM");
                total=r.getInt("total");
                System.out.println(C_ID +num_done+ " - " +num_EXAM+ " - " +total+" - ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void search(){
        System.out.println("Enter student id");
        C_ID=input.nextInt();
        try {
            query="SELECT * FROM `exam` WHERE C_ID='"+C_ID+"' ";
            ResultSet r = stmt.executeQuery(query);
            while (r.next()) {
                C_ID=r.getInt("C_ID");
                num_done=r.getInt("num_done");
                num_EXAM=r.getInt("num_EXAM");
                total=r.getInt("total");
                System.out.println(C_ID +num_done+ " - " +num_EXAM+ " - " +total+" - ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void update(){
        search();
        System.out.println("What do you want tto update\n 1- num_done\n 2- num_EXAM\n 3- total\n 4- all");
        int choice=input.nextInt();
        switch(choice){
            case 1:updateByNumDone(); break;
            case 2:updateByNumExam(); break;
            case 3:updateByTotal();break;
            case 4:updateAll();break;
            default:System.out.println("Invalid choice");
        }
    }
    public void updateByNumDone(){
        try {
            System.out.print("Please enter new number of students that are tested:");
            num_done = input.nextInt();
            query = "UPDATE `exam` SET`num_done`='"+num_done+"' WHERE C_ID='"+C_ID+"' ";
            stmt.executeUpdate(query);
            System.out.println("Data is updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateByNumExam(){
        try {
            System.out.print("Please enter new number of exam:");
            num_EXAM = input.nextInt();
            query = "UPDATE `exam` SET`num_EXAM`='"+num_EXAM+"' WHERE C_ID='"+C_ID+"' ";
            stmt.executeUpdate(query);
            System.out.println("Data is updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateByTotal(){
        try {
            System.out.print("Please enter new total of exam:");
            total = input.nextInt();
            query = "UPDATE `exam` SET`total`='"+total+"' WHERE C_ID='"+C_ID+"' WHERE C_ID='"+C_ID+"' ";
            stmt.executeUpdate(query);
            System.out.println("Data is updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateAll(){
        
        try {
            System.out.print("Please enter new number of students that are tested:");
            num_done = input.nextInt();
            System.out.print("Please enter new number of exam:");
            num_EXAM = input.nextInt();
            System.out.print("Please enter new total of exam:");
            total = input.nextInt();
            query = "UPDATE `exam` SET`num_done`='"+num_done+"',`num_EXAM`='"+num_EXAM+"',`total`='"+total+"' WHERE C_ID='"+C_ID+"' ";
            stmt.executeUpdate(query);
            System.out.println("Data is updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete(){
        int choice;
        System.out.println("What do you need? \n 1-del all students  2- del by id");
        choice=input.nextInt();
        switch(choice){
            case 1:deleteAll();
            break;
            case 2:deleteById();
            break;
            default:System.out.println("Invalid choice");
        }
    }
    public void deleteAll(){
        try {
            query="DELETE FROM `exam`";
            stmt.executeUpdate(query);
            System.out.println("all data is deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteById(){
        search();;
        try {
            query="DELETE FROM `exam` WHERE C_ID='"+C_ID+"'";
            stmt.executeUpdate(query);
            System.out.println("deleted by id");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

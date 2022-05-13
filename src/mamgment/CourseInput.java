/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mamgment;

import java.util.Scanner;
import static mamgment.Course.*;

/**
 *
 * @author Tarook
 */
public class CourseInput implements ICourseInput{
     Scanner input = new Scanner(System.in);
     
     @Override
     public String InputName (){
        System.out.println("Please enter course name :");
        name = input.next();
        return name;
    }
     
     @Override
    public String InputDate (){
    
      System.out.println("Please enter course date : ");
            Date = input.next();
            return Date;
    }
     
     @Override
     public int NumOfStudent (){
     
                 System.out.println("Please enter number of the student :");
            num_student = input.nextInt();
            return num_student;
     }
     
     @Override
       public int NumOfLec (){
       
       System.out.println("Please enter number of the lecture :");
            num_lect = input.nextInt();
            return num_lect;
       }
      
        @Override
               public int InputID(){
            System.out.println("Please enter course id");
            id = input.nextInt();
            return id;
             

        }
               
                   @Override
    public int InputDeleteOptions() {
        System.out.println("1- Delete all courses \n 2- Delete by ID");
        Deletechoice = input.nextInt();
        return Deletechoice;
    }

    @Override
    public int InputUpdateOptions() {
        System.out.println("What do you want to update /n 1- Update ALL /n 2- Name /n 3- Date "
                    + "/n 4- Number of Student /n 5- Number of Lectures /n 6- No one");
        Updatechoice = input.nextInt();
        return Updatechoice;
    }

  
}

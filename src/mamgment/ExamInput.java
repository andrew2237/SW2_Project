package mamgment;

import java.util.Scanner;
import static mamgment.Exam.*;

public class ExamInput implements IExamInput {

    Scanner input = new Scanner(System.in);

    @Override
    public int InputID() {
        System.out.println("Please enter id of the course : ");
        C_ID = input.nextInt();
        return C_ID;
    }

    @Override
    public int InputNumOfStudentTested() {
        System.out.println("Please enter Number of Students are tested : ");
        num_done = input.nextInt();
        return num_done;
    }

    @Override
    public int InputNumOfExam() {
        System.out.println("Please enter Number of Exams : ");
        num_Exam = input.nextInt();
        return num_Exam;
    }

    @Override
    public int InputTotalGrades() {
        System.out.println("Please enter Total of Grades : ");
        total = input.nextInt();
        return total;
    }
    
    @Override
    public String InputAnswer(){
        System.out.printf("the question:\n 1) 1+2=....\n a]3\t b]7"
                + " \n\n 2) 4+5=...\n a]8\t b]9 \n\n 3) 9+0=....\n a]10\t b]9 \n\n 4) 2+2=...\n a]4\t b]0\n\n");
        choice = input.next();
        return choice;
    }

    @Override
    public int InputDeleteOptions() {
        System.out.println("1- Delete all Exams \n 2- Delete by ID");
        Deletechoice = input.nextInt();
        return Deletechoice;
    }

    @Override
    public int InputUpdateOptions() {
        System.out.println("What do you want to update /n 1- Update By Number Of Student are Tested /n 2- Update By number Of Exam /n 3- Update By total of Grades "
                + "/n 4- Update All /n 5-Nothing");
        Updatechoice = input.nextInt();
        return Updatechoice;
    }

}

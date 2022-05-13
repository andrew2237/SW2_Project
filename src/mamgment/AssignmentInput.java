
package mamgment;

import java.util.Scanner;
import static mamgment.Assignment.*;


public class AssignmentInput implements IInputManager {
 Scanner input = new Scanner(System.in);

    @Override
    public int InputID() {
        System.out.println("Please enter id of the course : ");
        CourseId = input.nextInt();
        return CourseId;
    }

    @Override
    public String InputName() {
        System.out.println("Please enter assignment name : ");
        AssignmentName = input.next();
        return AssignmentName;
    }

    @Override
    public String InputDate() {
        System.out.println("Please enter assignment date : ");
        AssignmentDate = input.next();
        return AssignmentDate;
    }

    @Override
    public String InputType() {
        System.out.println("Please enter assignment type :");
        AssignmentType = input.next();
        return AssignmentType;
    }

    @Override
    public int InputDeleteOptions() {
        System.out.println("1- Delete all assignments \n 2- Delete by Name");
        Deletechoice = input.nextInt();
        return Deletechoice;
    }

    @Override
    public int InputUpdateOptions() {
        System.out.println("What do you want to update /n 1- Update ALL /n 2- Assignment Name /n 3- Assignment Date "
                + "/n 4-Assignment Type /n 5-Nothing");
        Updatechoice = input.nextInt();
        return Updatechoice;
    }
}
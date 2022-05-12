/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mamgment;

import static mamgment.Users.*;
import java.util.Scanner;

/**
 *
 * @author beshoy
 */
public class UsersInput implements IUsersInput {

    Scanner input = new Scanner(System.in);

    @Override
    public int InputStudentID() {
        System.out.println("Please enter student id");
        id = input.nextInt();
        return id;
    }

    @Override
    public int InputTeacherID() {
        System.out.println("Please enter teacher id");
        id = input.nextInt();
        return id;
    }

    @Override
    public String InputStudentFirstName() {
        System.out.println("Please enter user Fname");
        Fname = input.next();
        return Fname;
    }

    @Override
    public String InputteacherFirstName() {
        System.out.println("Please enter user Fname");
        Fname = input.next();
        return Fname;
    }

    @Override
    public String InputStudentLastName() {
        System.out.println("Please enter user lname");
        Lname = input.next();
        return Lname;
    }

    @Override
    public String InputteacherLastName() {
        System.out.println("Please enter user lname");
        Lname = input.next();
        return Lname;
    }

    @Override
    public String Inputteacheremail() {
        System.out.println("Please enter user email");
        email = input.next();
        return email;

    }

    @Override
    public String Inputstudentemail() {
        System.out.println("Please enter user email");
        email = input.next();
        return email;

    }

    @Override
    public int Inputteacherclassid() {
        System.out.println("Please enter user class id");
        c_id = input.nextInt();
        return c_id;

    }

    @Override
    public int Inputstudentclassid() {
        System.out.println("Please enter user class id");
        c_id = input.nextInt();
        return c_id;

    }
}

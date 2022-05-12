package mamgment;

import java.util.*;

public class Users {

    Scanner input = new Scanner(System.in);
    public static String Fname;
    public static String Lname;
    public static String email;
    public static String typee;
    public static int id;
    public static int grade;
    public static int c_id;

    UsersInput inputData = new UsersInput();
    private final UserDataBaseManager UsersDB;

    public Users(UserDataBaseManager UsersDB) {
        this.UsersDB = UsersDB;
        this.UsersDB.UserConnectDB();
    }

    public void StudentInsert() {
        Fname = inputData.InputStudentFirstName();
        Lname = inputData.InputStudentLastName();
        email = inputData.Inputstudentemail();
        c_id = inputData.Inputstudentclassid();

        this.UsersDB.insertStudent_ToDatabase(Fname, Lname, email, c_id);

    }

    public void TeacherInsert() {
        Fname = inputData.InputteacherFirstName();
        Lname = inputData.InputteacherLastName();
        email = inputData.Inputteacheremail();
        c_id = inputData.Inputteacherclassid();

        this.UsersDB.insertTeacher_ToDatabase(Fname, Lname, email, c_id);

    }

    public void studentsearch() {
        id = inputData.InputStudentID();

        this.UsersDB.returnStudentSearchResult_FromDatabase(id, Fname, Lname, email, c_id, grade);

    }

    public void teachersearch() {
        id = inputData.InputTeacherID();

        this.UsersDB.returnTeacherSearchResult_FromDatabase(id, Fname, Lname, email, c_id);

    }

    public void update_st() {
        studentsearch();
        System.out.println("update your Data");

        Fname = inputData.InputStudentFirstName();
        Lname = inputData.InputStudentLastName();
        email = inputData.Inputstudentemail();
        c_id = inputData.Inputstudentclassid();

        this.UsersDB.UpdateStudent_Database(id, Fname, Lname, email, c_id, grade);

    }

    public void update_te() {
        teachersearch();
        System.out.println("update your Data");
        System.out.println("Please enter new teacher Fname and Sname");
        Fname = inputData.InputteacherFirstName();
        Lname = inputData.InputteacherLastName();
        email = inputData.Inputteacheremail();
        c_id = inputData.Inputteacherclassid();

        this.UsersDB.Updateteacher_Database(id, Fname, Lname, email, c_id);

    }

    public void deletestudentsall() {
        this.UsersDB.deletestudentsall();

    }

    public void deleteteachersall() {
        this.UsersDB.deleteteachersall();

    }

    public void deletestudentbyid() {
        id = inputData.InputStudentID();
        this.UsersDB.deletestudentbyid(id);

    }

    public void deleteteacherbyid() {
        id = inputData.InputTeacherID();
        this.UsersDB.deleteteacherbyid(id);

    }

    public void insertprivrlligestudent() {
        c_id = input.nextInt();
        typee = "Student";
        this.UsersDB.insertprivrlligestudent(id, c_id, typee);

    }

    public void insertprivrlligeteacher() {
        c_id = input.nextInt();
        typee = "teacher";
        this.UsersDB.insertprivrlligeteacher(id, c_id, typee);

    }

    public void deleteprivilege() {
        this.UsersDB.deleteprivilege();

    }

    public void blockaccessstudent() {
        this.UsersDB.blockaccessstudent(id, typee);

    }

    public void blockaccessteacher() {

        this.UsersDB.blockaccessteacher(id, typee);

    }

}

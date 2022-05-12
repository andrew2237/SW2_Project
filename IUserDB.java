/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mamgment;

/**
 *
 * @author beshoy
 */
public interface IUserDB {
    public void UserConnectDB();
    public void insertStudent_ToDatabase(String Fname,String Lname,String email,int c_id);
    public void insertTeacher_ToDatabase(String Fname,String Lname,String email,int c_id);
    public void returnStudentSearchResult_FromDatabase(int id,String Fname,String Lname,String email,int c_id,int grade);
    public void returnTeacherSearchResult_FromDatabase(int id,String Fname,String Lname,String email,int c_id);
    public void UpdateStudent_Database(int id,String Fname,String Lname,String email,int c_id,int grade);
     public void Updateteacher_Database(int id,String Fname,String Lname,String email,int c_id);
     public void deletestudentsall();
     public void deleteteachersall();
      public void deletestudentbyid(int id);
      public void deleteteacherbyid(int id);
       public void insertprivrlligestudent(int id,int c_id,String typee);
        public void insertprivrlligeteacher(int id,int c_id,String typee);
        public void deleteprivilege();
        public void blockaccessstudent(int id,String typee);
        public void blockaccessteacher(int id,String typee);
        

    
}

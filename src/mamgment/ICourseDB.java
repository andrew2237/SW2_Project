/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mamgment;

/**
 *
 * @author Tarook
 */
public interface ICourseDB {
    public void CourseConnectDB();
    public void insertCourse_ToDatabase(String name,String Date,int num_student , int num_lect);
     public void returnSearchResult_FromDatabase(int id,String name,String Date,int num_student , int num_lect);
     public void deleteAll();
      public void DeleteByID(int id);
       public void updateAll(int id,String name,String Date,int num_student , int num_lect);
       public void updateName(int id,String name);
        public void updateDate(int id,String Date);
        public void updateNumOfStudents(int id,int num_student);
        public void updateNumOfLect(int id, int num_lect);
         public void showAll(int id,String name,String Date,int num_student , int num_lect);
         
    
}

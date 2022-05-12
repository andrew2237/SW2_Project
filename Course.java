package mamgment;

import java.util.*;

public class Course {
    Scanner input = new Scanner(System.in);
    public static int id;
    public static String name;
    public static String Date;
    public static int num_student;
    public static int num_lect;
    public static int Deletechoice;
    public static int Updatechoice;

   
    
    CourseInput inputData = new CourseInput();
    private final CourseDatabaseManager CourseDB;

    public Course(CourseDatabaseManager CourseDB) {
        this.CourseDB = CourseDB;
        this.CourseDB.CourseConnectDB();
        
    }

   
         
        public void insert(){
            name = inputData.InputName();

            Date = inputData.InputDate();
            
            num_student = inputData.NumOfStudent();
            num_lect = inputData.NumOfLec();
             
          
        this.CourseDB.insertCourse_ToDatabase(name, Date, num_student ,  num_lect);

            

        }
         
        public void search(){

           id = inputData.InputID();
           
            this.CourseDB.returnSearchResult_FromDatabase(id,name, Date, num_student ,  num_lect);


        }
         
        public void delete(){
         Deletechoice = inputData.InputDeleteOptions();

            switch(Deletechoice){
                case 1 :this.CourseDB.deleteAll();
                break;
                case 2 :this.CourseDB.DeleteByID(id);
                break;
                default : System.out.println("invalid choice");
            }
            
            
         }
         
       
        public void update(){
             search();
             do{
                            Updatechoice = inputData.InputUpdateOptions();

                switch(Updatechoice){
                case 1 : updateAll(); break;
                case 2 : updateName(); break;
                case 3 : updateDate(); break;
                case 4 : updateNumOfStudents(); break;
                case 5 : updateNumOfLect(); break;
                case 6 : System.out.println("Course Data Updated"); break;
                default : System.out.println("invalid value");
             }
             }while(Updatechoice!=6);
        }
         
         public void updateAll(){
             name = inputData.InputName();

            Date = inputData.InputDate();
            
            num_student = inputData.NumOfStudent();
            num_lect = inputData.NumOfLec();
           
              this.CourseDB.updateAll(id,name, Date, num_student ,  num_lect);

         }
         
         public void updateName(){
                name = inputData.InputName();
                this.CourseDB.updateName(id,name);

    }
         
         public void updateDate(){
                Date = inputData.InputDate();
                                this.CourseDB.updateDate(id,Date);

    }
         
         public void updateNumOfStudents(){
              num_student = inputData.NumOfStudent();
             this.CourseDB.updateNumOfStudents(id,num_student);
           
    }
         
         public void updateNumOfLect(){
             
            num_lect = inputData.NumOfLec();
             this.CourseDB.updateNumOfLect(id, num_lect);
            
    }
          public void showAll(){
              this.CourseDB.showAll(id,name, Date, num_student ,  num_lect);
    }

}

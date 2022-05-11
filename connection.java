package mamgment;
import java.util.*;
public class connection {

    
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
        
    // --------------------------------------
        Course crs = new Course();
        Exam ex = new Exam();
        Assignment ass = new Assignment();
        Users usr = new Users();
    // --------------------------------------
       
        int mch;
        do{
            if(usr.con==null){
                break;
            }
            int cho1;
            System.out.println(" 1- Exam module \n 2- Course module "
                    + "\n 3- Users module \n 4-Exit");
            cho1 = input.nextInt();
            switch(cho1){
                case 1: // ------ EXAM MODULE ------
                    int choice,y;
                    String s;
                    do {            
                        System.out.println("What do you need to do\n 1-insert\n 2-edit\n 3-search\n "
                                + "4-delete\n 5-show all\n 6-exit");
                        choice=input.nextInt();
                        switch(choice){
                            case 1:ex.insert();
                            System.out.println("Enter the name of course and id");
                                s=input.next();
                                y = input.nextInt();
                                y=ex.correct(s, 1);  
                            break;
                            case 2: ex.update();break;
                            case 3: ex.search();break;
                            case 4: ex.delete();break;
                            case 5: ex.showAll();break;
                            case 6: System.out.println("Bye!"); break;
                            default:System.out.println("Invalid choice");
                        }
                    }while (choice!=6);
                    break;
                    
                case 2: // ------ COURSE MODULE ------
                    int c;
                    do{
                     System.out.println("1- Course \n 2- Assignment \n 3- Generate reports \n 4-Exit");

                     c = input.nextInt();
                     switch(c){
                         case 1: 
                             int ch;
                              do{
                             System.out.println("What do you want to do \n 1- Add Course \n 2-Delete Course"
                                 + "\n 3- Update Course \n 4-Exit");
                             ch = input.nextInt();
                             switch(ch){
                             case 1 : crs.insert(); break;
                             case 2 : crs.delete(); break;
                             case 3 : crs.update(); break;
                             case 4 : System.out.println("Exit"); break;
                             default : System.out.println("invalid value");
                          }
                          }while(ch!=4);
                              break;

                        case 2:
                             int ch1;
                             do{
                             System.out.println("What do you want to do \n 1- Add Assignment \n 2-Delete Assignment"
                                 + "\n 3- Update Assignment \n 4-Exit");
                             ch1 = input.nextInt();
                             switch(ch1){
                             case 1 : ass.insert(); break;
                             case 2 : ass.delete(); break;
                             case 3 : ass.update(); break;
                             case 4 : System.out.println("Exit"); break;
                             default : System.out.println("invalid value");
                            } 
                            }while(ch1!=4);
                            break;
                         
                        case 3 :
                            System.out.println("Report about how students doing in each course");
                            crs.showAll();
                            ass.showAll();
                            break;
                            
                        case 4 :
                            System.out.println("Exit");
                            break;
                     }

                 }while(c!=4);
                    break;
                    
                case 3: // ------ USER MODULE ------
                    int ch1;
                             do{
                             System.out.println(" 1-Insert \n 2-Search"
                                 + "\n 3- Update users \n 4-Delete\n 5-Delete all\n "
                                     + "6-Delete by ID\n 7-Insert privrllige\n 8-Delete privrllige\n 9-Block acces\n 10-Exit");
                             ch1 = input.nextInt();
                             switch(ch1){
                             case 1 : usr.insert(); break;
                             case 2 : usr.search(); break;
                             case 3 : usr.update_st();break;
                             case 4 : usr.delete(); break;
                             case 5 : usr.deleteAll(); break;
                             case 6 : usr.deleteById(); break;
                             case 7 : usr.insertprivrllige();break;
                             case 8 : usr.deleteprivilege(); break;
                             case 9 : usr.blockAccess(); break;
                             case 10 : System.out.println("BYE!"); break;
                             default : System.out.println("invalid value");
                            } 
                            }while(ch1!=10);
                    break;
                    
                case 4:
                    case 6: System.out.println("Bye!"); 
                    break;
                
                default:System.out.println("Invalid choice");
              }
            System.out.println("1-Choose another operation \n2-Exit");
            mch=input.nextInt();
                 }while(mch==1);
         
    }
 
}

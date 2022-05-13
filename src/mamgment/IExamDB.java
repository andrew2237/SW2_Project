package mamgment;

public interface IExamDB {
    
    public void ExamConnectDB();
    
    public void insertExam_ToDatabase(int C_ID, int num_done, int num_Exam, int total);
    
    public void showAllExams(int C_ID, int num_done, int num_Exam, int total);
    
    public void returnSearchResult_FromDatabase(int C_ID, int num_done, int num_Exam, int total); 
    
    public void UpdateAllQuery_Database(int C_ID,int num_done, int num_Exam, int total);
    
    public void updateBytotalQuery(int C_ID, int total);
    
    public void updateBynum_ExamQuery(int C_ID, int num_Exam);

    public void updateByNumOfStudentTestedQuery(int C_ID,int num_done);
        
    public void deleteAll();

    public void deleteById(int C_ID);
    
    
    
}

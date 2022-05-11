package mamgment;

/**
 *
 * @author varin
 */
public interface IAssignmentDB {

    public void AssignmentConnectDB();

    public void insertAssignment_ToDatabase(int CourseId, String AssignmentName, String AssignmentDate, String AssignmentType);

    public void returnSearchResult_FromDatabase(String AssignmentName);

    public void deleteAll();
    
    public void deleteByName();

    public void UpdateAllQuery_Database(String AssignmentName, String AssignmentDate, String AssignmentType);
   
    public void UpdateNameQuery_Database(String AssignmentName);
    
    public void UpdateAssignmentDateQuery_Database(String AssignmentDate);
    
    public void UpdateTypeQuery_Database(String Type);

    public void ShowAllAssignments();
}

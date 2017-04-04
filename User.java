package Project;
import java.util.*;
import Project.*;


/**
 * A class that can add and remove schools from a user's list
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class User extends Account{
  
/**
 * a set of saved schools
 */
  Set<String> savedSchools;
  private UserFuncController uFuncController;
  
  /**
   * Constructs a user object who can save schools. Also creates the set of savedSchools
   * 
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username, username of the user
   * @param password the password of the user
   */
  public User(String first, String last, String username, String password)
  {
    super(first,last,username,password,'u', 'y');
    uFuncController = new UserFuncController();
  }
  
  public User(){
	  uFuncController = new UserFuncController();
  }
  
  /** 
   * Gets the user's saved schools
   * @return list of saved schools
   * 
   * Double check to see where we used this
   */
  public ArrayList<String> getSavedSchools(String user)
  {
    return uFuncController.getUserSchools(user);
  }
  
  /**
   * Adds a new university to the user's saved school list
   * @param school: the university being added
   * @return true if university was added
   */
  public boolean addNewUniversity(String user, String school)
  {
    return uFuncController.saveSchool(user, school);
  }
  /**
   * Removes a university from the user's saved school list
   * @param school: the university being removed
   * @return true if the university was removed
   */
  public boolean removeSchool(String user, String school)
  {
    return uFuncController.removeSchool(user, school);
    }
  
  
  /**
   * Deactivates the user
   */
  public void deactivate()
  {
    super.setStatus('n');
  }
  
}
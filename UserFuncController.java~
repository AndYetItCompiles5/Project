package Project;
import java.util.*;
import Project.*;

/**
 * A class that runs the options that the user can select
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class UserFuncController{
  
  private DBController dbController;
  
  public UserFuncController()
  {
    
  }
  
  /**
   * Edits the user with the given information
   * @param first:the user's first name
   * @param last: the user's last name
   * @param password: the user's password
   * @return true if the user was edited
   */
  
  public String editUser(String username, String firstName, String lastName, String password,char type, char status)
  {
        return dbController.editAccount(username,firstName,lastName,password,type,status);
  }
  
  /**
   * Lets the user view their saved schools
   * @return the set of saved schools
   */
  
  public Set<String> viewSchools()
  {
    return null; 
  }
  
  /**
   * Removes a university from the student's saved schools
   * @param school: the university being removed
   * @return true if university was removed
   */
  public int removeSchool(String user, String school)
  {
    return dbController.removeSchool(user, school); 
  }
  
  /**
   * Saves the selected university to the user's list of universities
   * @param school: the university being saved
   * @return true if university was saved
   */
  
  public int saveSchool(String user, String school)
  {
    return dbController.saveSchool(user, school); 
  }
  
  
  /**
   * Lets the user confirm their selection
   * @return error message
   */
  
  public String confirm()
  {
    return "Are you sure?";
  }
  
  /**
   * Gives the user an error if they try saving an already saved school
   * @return error message
   */
  
  public String AlreadySavedError()
  {
    return "School was already saved"; 
  }
}
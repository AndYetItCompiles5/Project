import java.util.*;
import Project230.*;


   /**
   * A class that can add and remove schools from a user's list
   * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
   * @version 2/22/17
   */

public class User extends Account{
 
  Set<String> savedSchools;

  public User(String first, String last, String username, String password, char type, boolean status)
  {
    super(first,last,username,password,type,status);
    HashSet<String> savedSchools = new HashSet<String>();
  }
  /**
   * Gets the user's saved schools
   * @return list of saved schools
   */
  public HashSet<String> getSavedSchools()
  {
   return null; 
  }
  /**
   * Adds a new university to the user's saved school list
   * @param school: the university being added
   * @return true if university was added
   */
  public boolean addNewUniversity(University school)
  {
   return false; 
  }
  /**
   * Removes a university from the user's saved school list
   * @param school: the university being removed
   * @return true if the university was removed
   */
  public boolean removeSchool(University school)
  {
   return false; 
  }
  /**
   * Deactivates the user
   */
  public void deactivate()
  {
    
  }
  
}
package Project;
import java.util.*;
import Project.*;


/**
 * A class that can add and remove schools from a user's list
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class User extends Account{
  
  Set<String> savedSchools;
  
  public User(String first, String last, String username, String password)
  {
    super(first,last,username,password,'u');
    HashSet<String> savedSchools = new HashSet<String>();
  }
  
  /**
   * Gets the user's saved schools
   * @return list of saved schools
   */
  public Set<String> getSavedSchools()
  {
    return savedSchools; 
  }
  
  /**
   * Adds a new university to the user's saved school list
   * @param school: the university being added
   * @return true if university was added
   */
  public boolean addNewUniversity(University school)
  {
    if(savedSchools.contains(school.getName())){
      return false; 
    }
    else{
      savedSchools.add(school.getName());
      return true;
    }
  }
  /**
   * Removes a university from the user's saved school list
   * @param school: the university being removed
   * @return true if the university was removed
   */
  public boolean removeSchool(University school)
  {
    if(savedSchools.contains(school.getName())){
      savedSchools.remove(school.getName());
      return true;
    }
    else{
      return false;
    }
    
  }
  /**
   * Deactivates the user
   */
  public void deactivate()
  {
    super.setStatus('n');
  }
  
}
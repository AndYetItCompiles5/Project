<<<<<<< HEAD
import java.util.*;
import Project230.*;

/**
 * UserUI
 * @authors: Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/25/2017
 */
public class UserUI{
  
  /**
   * UserUI constructor
   */
  public UserUI(){
    
=======
package Project;
import java.util.*;
import Project.*;

/**
 * UserUI
 * @author Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/25/2017
 */
public class UserUI{
  /**
   * Creates an instance of the Database Library
   */
  private DBController dbController;

  /**
   * Creates an instance of the UserFuncController
   */
  private UserFuncController uFuncController;

  /**
   * Creates an instance of the SearchController
   */
  private SearchController searchController;

  /**
   *Default constuctor
   */
  public UserUI(){
    dbController = new DBController();
    searchController = new SearchController();
    uFuncController = new UserFuncController();
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * View school information
   *
<<<<<<< HEAD
   * @param University object school
   * 
   * @return the schools info
   */
  public University viewSchoolInfo(University school){
    return school;
=======
   * @param name of school
   * 
   * @return the schools info
   */
  public University viewSchoolInfo(String name){
    return dbController.getUniversity(name);
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * save the school to the user                                      
   *
<<<<<<< HEAD
   * @param University object school
   */
  public void saveSchool(University school){
    
=======
   * @param user: the user's username
   * @param school: the school being added
   * 
   * @return a boolean if the school was successfully saved
   */
  public boolean saveSchool(String user, String school)
  {
    return uFuncController.saveSchool(user,school);
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * remove school from the users list 
<<<<<<< HEAD
   */
  public void removeSchool(){
    
  }
  
  /**
   * view a list of univerities the user has saved
   *
   * @param University object school
   * 
   * @return school
   */
  public Set<String> viewSavedSchools(University school){
    return null;
=======
   * 
   * @param user:the user of the school being removed
   * @param school: the school being removed
   * 
   * @return a boolean if it was saved 
   */
  public boolean removeSchool(String user, String school){
    return uFuncController.removeSchool(user, school);
  }
  
  /**
   * view a list of universities the user has saved
   *
   * @param user: the user's username 
   * 
   * @return ArrayList of saved schools
   */
  public ArrayList<String> viewSavedSchools(String user)
  {
    return dbController.getUserSavedSchools(user);
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * An admin can create an account 
   *
   * @param name the name of the University
   * @param state the state the University is located int
   * @param location can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or -1 if unknown
   * @param control can be one of the following: PRIVATE, STATE, CITY, or -1 if unknown
<<<<<<< HEAD
   * @param numStudents number of students enrolled in the University
   * @param perFemale percentage of enrolled students that are females (between 0 and 100)
   * @param satVerbal average SAT verbal score for enrolled students(between 0 and 800)
   * @param satMath average SAT math score for enrolled students(between 0 and 800)
   * @param expenses annual expenses or tuition to attend the school
   * @param perFA percentage of enrolled students receiving financial aid
   * @param numAppicants total number of applicants that apply to the school anually
   * @param perAdmitted percent of applicants that get admitted
   * @param perEnrolled percent of applicants that decide to enroll
   * @param academicScale integer between 1 and 5 indicating the academic scale of the University
   * @param socialScale integer between 1 and 5 indicating the quality of social life at the University
   * @param lifeScale integer between 1 and 5 indicating the quality of life at the University
   * @param emphases up to five areas of study the University excels at (all Strings)
   */
  public void search(String name, String state, String location, String control, int numStudents,
                     double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                     int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                     int socialScale, int lifeScale, ArrayList<String> emphases){
    
  }
  
  /**
   * displays results
   *
   * @param a set of string called list
   * 
   * @return list
   */
  public String displayResults(Set<String> list){
    return "";
  }
  
  /**
   * show univserities
   *
   * @param University object school
   * 
   * @return the school
   */
  public String showSchools(University school){
    return ""; 
  }
  
  /**
   * The user can edit their acccount
   * 
   * @return true if they made any changes else return false
   */
  public boolean editAccount(){
    return false; 
  }
  
  /**
   * confirmation message
   * 
   * @return a comfirmation message
   */
  public String confirm(){
    return "confirm"; 
  }
  
  /**
   *  display University
   *
   *@param University object school
   * 
   * @return 
   */
  public String displayUniversity(University school){
    return ""; 
  }
  
  /**
   * Already saved error message when the user tries to save the same school twice
   * 
   * @return "Universities already saved"
   */
  public String alreadySavedError(){
    return "already saved Error"; 
  }
  
  /**
   * Is the user sure they want to make those changes? confirmation message
   * 
   * @return a confirmation message
   */
  public String confirmationMessage(){
    return "confirmation Message"; 
  }
  
  /**
   *confirmation message to change
   */
  public String confirmChange(){
    return "are you sure?"; 
=======
   * @param numStudentsLow user search input of minimum number of students
   * @param numStudentsHigh user search input of maximum number of students
   * @param perFemaleLow user search input of minimum female percentage
   * @param perFemaleHigh user search input of maximum female percentage
   * @param satVerbalLow user search input of minimum SAT Verbal score
   * @param satVerbalHigh user search input of maximum SAT Verbal score
   * @param satMathLow user search input of minimum SAT Math score
   * @param satMathHigh user search input of minimum SAT Math score
   * @param expensesLow user search input of minimum expenses
   * @param expensesHigh user search input of maximum expenses
   * @param perFALow user search input of minimum Financial Aid percentage
   * @param perFAHigh user search input of maximum Financial Aid percentage
   * @param numApplicantsLow user search input of minimum number of applicants
   * @param numApplicantsHigh user search input of maximum number of applicants
   * @param perAdmittedLow user search input of minimum number of admitted
   * @param perAdmittedHigh user search input of maximum number of admitted
   * @param perEnrolledLow user search input of minimum number of enrolled
   * @param perEnrolledHigh user search input of maximum number of enrolled
   * @param academicScaleLow user search input of minimum academic scale number
   * @param academicScaleHigh user search input of maximum academic scale number
   * @param socialScaleLow user search input of minimum social scale number
   * @param socialScaleHigh user search input of maximimum social scale number
   * @param lifeScaleLow user search input of minimum life scale number
   * @param lifeScaleHigh user search input of maximum life scale number
   * @param emphases up to five areas of study the University excels at (all Strings)
   */
  public HashSet<String> search(String name, String state, String location, String control, int numStudentsLow,
                     int numStudentsHigh, double perFemaleLow, double perFemaleHigh, int satVerbalLow, int satVerbalHigh,
                     int satMathLow, int satMathHigh, int expensesLow, int expensesHigh, double perFALow, double perFAHigh,
                     int numApplicantsLow, int numApplicantsHigh, double perAdmittedLow, double perAdmittedHigh, double perEnrolledLow, double perEnrolledHigh,
                     int academicScaleLow, int academicScaleHigh, int socialScaleLow, int socialScaleHigh, int lifeScaleLow, int lifeScaleHigh, ArrayList<String> emphases){
    
    return searchController.search(name, state, location, control, numStudentsLow,numStudentsHigh, perFemaleLow,perFemaleHigh, satVerbalLow,satVerbalHigh,
                                   satMathLow,satMathHigh,expensesLow,expensesHigh,
                                   perFALow,perFAHigh, numApplicantsLow,numApplicantsHigh, perAdmittedLow,perAdmittedHigh,perEnrolledLow,perEnrolledHigh,
                                   academicScaleLow,academicScaleHigh,socialScaleLow,socialScaleHigh, lifeScaleLow,lifeScaleHigh,
                                   emphases);
  }
   
  /**
   * The user can edit their acccount
   * 
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username the username of user
   * @param password the password of the user
   * @param type U for user, A for admin
   * @param status if the account is active or not
   * 
   * @return boolean if the account is edited
   */
  public boolean editAccount(String first,String last, String username, String password, char type, char status){
    return dbController.editAccount(first,last,username,password,type,status);
  } 
  
  /**
   * Find schools which are similar to the one that the user is viewing
   * @param name of the university you want to find simular schools too
   * @return an arraylist of 5 most similar schools
   */
  public ArrayList<String> findRecommendations(String name){
   return searchController.findRecommendations(name);
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
}
package Project;
import java.util.*;
import Project.*;

/**
 * UserUI
 * @authors: Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
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
   * Creates an instance of the AccountController
   */
  private AccountController aController;

  /**
   * UserUI constructor
   *Default constuctor
   */
  public UserUI(){
    dbController = new DBController();
    searchController = new SearchController();
    uFuncController = new UserFuncController();
  }
  
  /**
   * View school information
   *
   * @param name of school
   * 
   * @return the schools info
   */
  public University viewSchoolInfo(String name){
    return dbController.getUniversity(name);
  }
  
  /**
   * save the school to the user                                      
   *
   * @param user 
   * @param school
   * 
   * @returns an int. -1 if not saved. 
   */
  public String saveSchool(String user, String school)
  {
    return uFuncController.saveSchool(user,school);
  }
  
  /**
   * remove school from the users list 
   * 
   * @param user 
   * @param school
   * 
   * @returns an int. -1 if not saved. 
   */
  public int removeSchool(String user, String school){
    return uFuncController.removeSchool(user, school);
  }
  
  /**
   * view a list of univerities the user has saved
   *
   * @param user
   * 
   * @return ArrayList of saved schools
   */
  public ArrayList<String> viewSavedSchools(String user)
  {
    return dbController.getUserSavedSchools(user);
  }
  
  /**
   * An admin can create an account 
   *
   * @param name the name of the University
   * @param state the state the University is located int
   * @param location can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or -1 if unknown
   * @param control can be one of the following: PRIVATE, STATE, CITY, or -1 if unknown
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
   * @param numAppicantsLow user search input of minimum number of applicants
   * @param numAppicantsHigh user search input of maximum number of applicants
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
   * displays results. Do we need these?
   *
   * @param list a set of string called list
   * 
   * @return a message
   */
  public String displayResults(Set<String> list){
    return "";
  }
  
  /**
   * show universities
   *
   * @param University object school
   * 
   * @return a message
   */
  public String showSchools(University school){
    return ""; 
  }
  
  /**
   * The user can edit their acccount
   * 
   * @param first the first name of the user
   * @param last the last name of the user
   * @param password the password of the user
   * @param type U for user, A for admin
   * @param status if the account is active or not
   * @param account the Account object of the user
   * 
   * @return string
   */
  public String editAccount(String first,String last, String username, String password, char type, char status){
    return dbController.editAccount(first,last,username,password,type,status);
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
  }
}
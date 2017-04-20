import java.util.*;
<<<<<<< HEAD
import Project230.*;

/**
 * AdminFuncController
 * @authors: Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/25/2017
 */
public class AdminFuncController {
  
  /**
   * Constructor
   * 
   */
  public AdminFuncController(){
    
  }
  
  /**
   * An admin can create an account 
   *
   * @param user
   * 
   * @return true if added else return false
   */
  public boolean addAccount(Account user){
    return true;
  }
  
  /**
   * An Admin can add a new school to the list of schools in the DB
   * 
   * @return true if school is added else return false
   */
  public boolean addSchool(University school){
    return true;
  }
  
  /**
   *An Admin can edit a University from the BD 
=======
import Project.*;

/**
 * AdminFuncController
 * @author Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/25/2017
 */
public class AdminFuncController {
  /**
   * instance of DBController
   */
  private DBController dbController;
  /**
   * instance of UniversityController
   */
  private UniversityController uController;
  /**
   * instance of AccountController
   */
  private AccountController aController;
  
  /**
   * creates the instance of each controller
   */
  public AdminFuncController(){
    dbController = new DBController();
    aController = new AccountController();
    uController = new UniversityController();
  }
  
  /**
   * Creates an account 
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username the username of the user
   * @param password for the account
   * @param type the type of user
   * @return Whether the account was successfully created, an error if not
   */
	  public String addAccount(String first, String last, String username, String password, char type)
	  {
	  return dbController.addAccount(first,last,username,password,type);
	  }
  
  /**
   * Edits the University
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
   * 
   * @param name the name of the University
   * @param state the state the University is located int
   * @param location can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or -1 if unknown
   * @param control can be one of the following: PRIVATE, STATE, CITY, or -1 if unknown
   * @param numStudents number of students enrolled in the University
   * @param perFemale percentage of enrolled students that are females (between 0 and 100)
   * @param satVerbal average SAT verbal score for enrolled students(between 0 and 800)
   * @param satMath average SAT math score for enrolled students(between 0 and 800)
   * @param expenses annual expenses or tuition to attend the school
   * @param perFA percentage of enrolled students receiving financial aid
<<<<<<< HEAD
   * @param numAppicants total number of applicants that apply to the school anually
=======
   * @param numApplicants total number of applicants that apply to the school anually
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
   * @param perAdmitted percent of applicants that get admitted
   * @param perEnrolled percent of applicants that decide to enroll
   * @param academicScale integer between 1 and 5 indicating the academic scale of the University
   * @param socialScale integer between 1 and 5 indicating the quality of social life at the University
   * @param lifeScale integer between 1 and 5 indicating the quality of life at the University
   * @param emphases up to five areas of study the University excels at (all Strings)
   * 
<<<<<<< HEAD
   * @return true if school was successfully editted else return false
   */
  public boolean editUniversity(String name, String state, String location, String control, int numStudents,
                                double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                                int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                                int socialScale, int lifeScale, ArrayList<String> emphases){
    return true; 
=======
   * @return Whether the university was successfully edited, error if not successful
   */
  public boolean editUniversity(String name, String state, String location, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                               int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                               int socialScale, int lifeScale, ArrayList<String> emphases){
    return uController.editUniversity(name,state,location,control,numStudents,perFemale,satVerbal,satMath,
                                      expenses,perFA,numApplicants,perAdmitted,perEnrolled,academicScale,
                                      socialScale,lifeScale,emphases);
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * The admin can view a list Users
   * 
<<<<<<< HEAD
   * @returns a set of accounts from the BD
   */
  public Set<String> viewUsers(){
    return null;
  }
  
  /**
   *Displays the info of the account 
   * 
   * @param first the first name of the user
   * @param last the last name of the user
   * @param password the password of the user
   * @param type U for user, A for admin
   * @param status true if active, false if deactivated
   * @param account the Account object of the user
   * 
   * @return the details of the account
   */
  public String displayInfo(String first, String last, String username, String password, char type, boolean status){
    return null; 
=======
   * @return a 2-d array of of strings from the database
   */
  public String[][] viewUsers(){
   return dbController.getAllUsers();
  }
  
  /**
   * Displays the info of the account 
   * 
   * @param username the username of the account we need information from
   * 
   * @throws IllegalArgumentException if the username does not exist
   * @return an ArrayList of all the account details
   */
  public ArrayList<String> displayInfo(String username)
  {
	  if(dbController.isUsernameTaken(username)){
		  Account account = dbController.getAccount(username);
    
		  ArrayList<String> accountInfo = new ArrayList<String>();
    
		  accountInfo.add(account.getFirstName());
		  accountInfo.add(account.getLastName());
		  accountInfo.add(account.getUsername());
		  accountInfo.add(account.getPassword());
		  accountInfo.add(account.getType() + "");
		  accountInfo.add(account.getStatus() + "");
    
		  return accountInfo;
	  }
	  else{
		  throw new IllegalArgumentException("Username does not exist");
	  }
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * An Admin can edit an account.
   * 
   * @param first the first name of the user
   * @param last the last name of the user
<<<<<<< HEAD
   * @param password the password of the user
   * @param type U for user, A for admin
   * @param status true if active, false if deactivated
   * @param account the Account object of the user
   * 
   * @return true of the account was editted successifully else return false
   */
  public boolean editAccount(Account account, String first, String last, String password, char type, boolean status){
    return true; 
  }
  
  /**
   * a confirmation Message
   * 
   * @return a confirmation Message 
   */
  public String confirmationMessage(){
    return null; 
  }
  
  /**
   * resets the field to their default settings 
   */
  public void resetFields(){
  }
  
  /**
   * A no name error
   * 
   * @return a noNameError 
   */
  public String noNameError(){
    return null; 
  }
  
  /**
   * displays the name of the University
   * 
   * @param name name of the University
   * 
   * @return name of the University
   */
  public String displayUnversity(String name){
    return name;
  }
  
  /**
   * An empty field error. 
   * 
   * @return please enter something 
   */
  public String emptyFieldError(){
    return "Please enter something";
  }
=======
   * @param username the username of the user
   * @param password the password of the user
   * @param type U for user, A for admin
   * @param status true if active, false if deactivated
   * 
   * @return whether the account was successfully edited, error if not
   */
  public boolean editAccount(String first, String last, String username, String password, char type, char status){
    return aController.editAccount(first,last,username,password,type,status);
  }
  
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  
  /**
   * shows a list of Universities
   * 
   * @return a list of Universities
   */
  public ArrayList<String> viewUniversities(){
<<<<<<< HEAD
    return null; 
  }
  
}




=======
    return dbController.getAllUniversities();
    
  }
}
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb

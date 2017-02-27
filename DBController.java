import java.util.*;
import Project230.*;

/**
 * DB controller
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class DBController
{
  
  /**
   * Constructor if needed
   */
  public DBController()
  {
    
  }
  
  /**
   * Returns the user to themselves when they are logging in/editing their profile
   * @returns the User object to the current User
   */
  public User getUser()
  {
    return null;
  }
  
  /**
   * Method that takes a University as a parameter and returns that same University
   * @param school the school to be retrieved
   * @returns the University that the account is looking for
   */
  public University getUnivesity(University school)
  {
    return null;
  }
  
  /**
   * Method that takes a Universty object and edits it's info in the database
   * @param school the school to be edited
   * @returns true if the University has been successfully edited
   */
  public boolean editUniversity(University school)
  {
    return false;
  }
  
  /**
   * Method to add a a new University object to the database
   * @param school the new University object to be added to the database
   * @returns true if the school has been added successfully
   */
  public boolean addUniversity(University school) //changed from addSchool()
  {
    return false;
  }
  
  /**
   * Method that checks is a username already exists
   * @param username the username being searched for
   * @returns true if the username already exists
   */
  public boolean isUsername(String username)
  {
    return false;
  }
  
  /**
   * Gets the password from a specified Account object
   * @param user the Account object the password is being retrieved from
   * @returns a String(the password)
   */
  public String getPassword(Account user)
  {
    return "";
  }
  
  /**
   * Gets the status from a specified Account object
   * @param user the Account object the status is being pulled from
   * @returns true if the account is active
   */
  public boolean getStatus(Account user)
  {
    return false;
  }
  
  /**
   * Get the type of a specified Account object
   * @param user the Account object the type is being pulled from
   * @returns A if admin, U is user
   */
  public char getType(Account user)
  {
    return 'a';
  }
  
  /**
   * Returns an Account object based off of a username
   * @param username the username being used to search for the account
   * @returns an the account based off the username
   */
  public Account getAccount(String username)
  {
    return null;
  }
  
  /**
   * Returns a string stating that the login info was incorrect
   * @returns a message saying some part of login info is wrong
   */
  public String wrongLoginInfoError()
  {
    return "Wrong login info";
  }
  
  /**
   * Returns a string stating that the account is currently deactivated
   * @returns a string stating that the account is currently deactivated
   */
  public String deactivateError()
  {
    return "That account is currently deactivated.";
  }
  
  /**
   * Returns a Set of all the University objects in the database
   * @returns a Set of all the University objects in the database
   */
  public Set<University> getAllUniversities() // change return type to Set<University> in class diagram
  {
    return null;
  }
  
  /**
   * Returns a Set of all the University objects that match the search criteria in the database
   * @param name the name of the University
   * @param state the state where you can find the University
   * @param location urban, suburban or rural
   * @param sontrol private, public or other
   * @param numStudents the number of students enrolled
   * @param perFemale the percent of the school that is female
   * @param satVerbal average SAT Verbal score
   * @param satMath   average SAT Math score
   * @param expenses how much money it costs to go there
   * @param perFA percent on Financial Aid
   * @param numApplicants number of students who applied to the school this year
   * @param perAdmitted percent of applicants admitted annually
   * @param perEnrolled percent of students enrolled at the school
   * @param academicScale 1-5 scale on the quality of academics
   * @param socialScale   1-5 scale on the quality of social opportunities
   * @param lifeScale     1-5 scale on the quality of life at the university
   * @param emphases      a set of areas of academic emphasis the school has
   * @returns a Set of all the University objects that match the search criteria in the database
   */
  public Set<University> search(String name, String state, String location, String control, int numStudents,
                                double perFemale, int satVerbal, int satMath, int expenses, double perFA, int numApplicants,
                                double perAdmitted, double perEnrolled, int academicScale, int socialScale, int lifeScale,
                                ArrayList<String> emphases)
  {
    return null;
  }
  
  /**
   * Displays the Set of University objects
   * @param setOfSchools the set of University objects 
   * @returns the Set of University objects
   */
  public Set<University> displayResults(Set<String> setOfSchools)
  {
    return null;
  }
  
  /**
   * Confirms stuff -----
   */
  public void confirm()
  {
    
  }
  
  /**
   * Takes a University object and displays it's name
   * @param school the University whose name is to be displayed
   * @returns the name of school
   */
  public String displayUniversity(University school)
  {
    return ""; 
  }
  
  /**
   * Finds whether or not the schools has been saved
   * @param school the University we want to save to the database
   * @returns true if the school has been saved
   */
  public boolean isSchoolSaved(University school)
  {
    return false;
  }
  
  /**
   * Returns a message letting the admin know that the school already exists
   * @returns a String that the school is already in the database
   */
  public String alreadySavedError()
  {
    return "School has already been saved to the database.";
  }
  
  /**
   * returns a set of all the users in the database
   * @return a set of all the users in the database
   */
  public Set<User> getAllUsers()
  {
    return null;
  }
  
  /**
   * Add an account to the database
   * @param account the account to be added to the database
   * @returns true if successfully added to the database
   */
  public boolean addAccount(Account account)
  {
    return false;
  }
  
  /**
   * Checks whether or not the username has been taken
   * @param username the username we want to check if it currently exists
   * @return true if the username is already taken
   */
  public boolean isUsernameTaken(String username)
  {
    return false;
  }
  
  /**
   * Displays an error message saying that the username has already been taken
   * @returns a string stating that the username has already been taken
   */
  public String userAlreadyTakenError()
  {
    return "That username has already been taken."; 
  }
  
  /**
   * The user is missing some type of  information(username, password, type, etc.)
   * @returns a message letting the user know all required information must be filled in
   */
  public String userNotCompleteError()
  {
    return "Please fill in all required information.";
  }
  
  /**
   * Method to edit an existing user
   * @param first the first name of the user
   * @param last the last name of the user
   * @param password the password of the user
   * @param type U for user, A for admin
   * @param status true if active, false if deactivated
   * @param account the Account object of the user
   * @returns true if the user was successfully edited
   */
  public boolean editUser(String first, String last, String password, char type, boolean status, Account account)
  {
    return false;
  }
  
  /**
   * Message displayed when asking if the user wants to confirm something
   * @returns a message asking a user if they are sure they want to do something
   */
  public String confirmationMessage()
  {
    return "";
  }
  
  /**
   * Checks to see if an Account is deactivated
   * @param account the Account to be checked
   * @returns true if account is deactivated
   */
  public boolean isDeactivated(Account account)
  {
    return false;
  }
  
  /**
   * Deactivates a given Account
   * @param account the account to be deactivated
   * @returns true if successfully deactivated
   */
  public boolean deactivateUser(Account account)
  {
    return false;
  }
  
  /**
   * Error message stating that Account is already deactivated
   * @returns a message stating that the Account is already deactivated
   */
  public String alreadyDeactivatedError()
  {
    return "Account is already deactivated.";
  }
}
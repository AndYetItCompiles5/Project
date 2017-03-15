package Project;
import java.util.*;
import dblibrary.project.csci230.UniversityDBLibrary;
import java.lang.*;

/**
 * DB controller
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class DBController
{
  
  private UniversityDBLibrary dataBase = new UniversityDBLibrary("andyic","andyic","csci230");
  private UniversityController uController = new UniversityController();
  /**
   * Constructor if needed
   */
  public DBController()
  {
    
  }
  
  /**
   * Returns the user to themselves when they are logging in/editing their profile
   * 
   * @returns the User object to the current User
   */
  public ArrayList getUser(String username)
  {
    ArrayList userInfo = new ArrayList();
    String[][] users = dataBase.user_getUsers();
    for(int i = 0; i < users.length;i++){
      if(users[i][2].equals(username))
      {
        userInfo.add(users[i][2].toString());
        userInfo.add(users[i][3].toString());
        userInfo.add(users[i][4].charAt(0));
        userInfo.add(users[i][5].charAt(0));
      }
    }
    return userInfo;
  }
  
  /**
   * Method that takes a University as a parameter and returns that same University
   * @param school the school to be retrieved
   * @returns the University that the account is looking for
   */
  public ArrayList getUniversity(String name)
  {
    String[][] universities = dataBase.university_getUniversities();
    ArrayList result = new ArrayList();
    for(int i=0;i<universities.length;i++){
      if(universities[i][0].equals(name)){
        for(int j=0;j<universities[i].length;j++){
          result.add(universities[i][j]);
        }
      }
    }
    return result;
  }
//change return type to Set<University> in class diagram
  /**
   * Method that takes a Universty object and edits it's info in the database
   * @param school the school to be edited
   * @returns true if the University has been successfully edited
   */
  public String editUniversity(String name, String state, String loc, String control, int numStudents,
                                double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                                int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                                int socialScale, int lifeScale, ArrayList<String> emphases)
  {
    dataBase.university_editUniversity(name,state,loc,control,numStudents,perFemale,satVerbal,satMath,expenses,perFA,
                                       numApplicants,perAdmitted,perEnrolled,academicScale,socialScale,lifeScale);
    return "Are you sure you want to make these changes?";
  }
  
  /**
   * Method to add a a new University object to the database
   * @param school the new University object to be added to the database
   * @returns true if the school has been added successfully
   */
  public String addUniversity(String name, String state, String loc, String control, int numStudents,
                              double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                              int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                              int socialScale, int lifeScale, ArrayList<String> emphases)
  {
    if(isSchoolSaved(name)){
      return alreadySavedError();
      
    }
    else{
      dataBase.university_addUniversity(name,state, loc, control, numStudents,
                                        perFemale, satVerbal, satMath, expenses, perFA,
                                        numApplicants, perAdmitted, perEnrolled, academicScale,
                                        socialScale, lifeScale);
      return "Save Successful!";
    }
  }
  
  /**
   * 
   */
  public int saveSchool(String user, String school)
  {
    String[][] namesWithSchools = dataBase.user_getUsernamesWithSavedSchools();
    
    for(int i = 0; i < namesWithSchools.length; i++)
    {
      if(namesWithSchools[i][0].equals(user))
      {
        for(int j = 0; j < namesWithSchools[i].length; j++)
        {
          if(namesWithSchools[i][j].equals(school))
          {
            return -1;
          }
        }
      }
    }
    
    return dataBase.user_saveSchool(user, school);
  }
  
  /**
   * This methods gets the user's saved schools from the db
   * @param user
   * @returns a array of user's saved schools
   */
  public ArrayList<String> getUserSavedSchools(String user)
  {
    ArrayList<String> listSchools = new ArrayList<String>();
    String[][] namesWithSchools = dataBase.user_getUsernamesWithSavedSchools();
    
    for(int i = 0; i < namesWithSchools.length; i++)
    {
      if(namesWithSchools[i][0].equals(user))
      {
        for(int j = 0; j < namesWithSchools[i].length; j++)
        {
          listSchools.add(namesWithSchools[i][j]);
        }
      }
    }
    
    return listSchools;
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
  public String[][] getAllUniversities() 
  {
    return dataBase.university_getUniversities();
  }
  
  /**
   * Returns a Set of all the University objects that match the search criteria in the database
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
                                int academicScaleLow, int academicScaleHigh, int socialScaleLow, int socialScaleHigh, int lifeScaleLow, int lifeScaleHigh, ArrayList<String> emphases)
  {
    String[][] schoolList = dataBase.university_getUniversities();
    String[][] emphasesList = dataBase.university_getNamesWithEmphases();
    HashSet<String> answer = new HashSet<String>();
    for(int i=0;i<schoolList.length;i++){
      if(schoolList[i][0].toLowerCase().contains(name.toLowerCase()) && (schoolList[i][1].toLowerCase().contains(state.toLowerCase()) || schoolList[i][1].equals("-1")) 
           && (schoolList[i][2].toLowerCase().contains(location.toLowerCase()) ||schoolList[i][2].equals("-1")) && (schoolList[i][3].toLowerCase().contains(control.toLowerCase())||
                                                                                                                    schoolList[i][3].equals("-1"))){
        
        if((isWithinRange(numStudentsLow,numStudentsHigh,schoolList[i][4]) || (numStudentsLow==0 && numStudentsHigh==0)) && (isWithinRange(perFemaleLow,perFemaleHigh,schoolList[i][5]) ||
                                                                                                                             (perFemaleLow==0 && perFemaleHigh==0)) && (isWithinRange(satVerbalLow,satVerbalHigh,schoolList[i][6])|| (satVerbalLow==0 && satVerbalHigh==0)) && (isWithinRange(satMathLow,satMathHigh,schoolList[i][7])||
                                                                                                                                                                                                                                                                                (satMathLow==0 && satMathHigh==0)) && (isWithinRange(expensesLow,expensesHigh,schoolList[i][8])|| (expensesLow==0 && expensesHigh==0)) && (isWithinRange(perFALow,perFAHigh,schoolList[i][9])||
                                                                                                                                                                                                                                                                                                                                                                                                                           (perFALow==0 && perFAHigh==0)) && (isWithinRange(numApplicantsLow,numApplicantsHigh,schoolList[i][10])|| (numApplicantsLow==0 && numApplicantsHigh==0)) &&
           (isWithinRange(perAdmittedLow,perAdmittedHigh,schoolList[i][11])|| (perAdmittedLow==0 && perAdmittedHigh==0)) && (isWithinRange(perEnrolledLow,perEnrolledHigh,schoolList[i][12])||
                                                                                                                             (perEnrolledLow==0 && perEnrolledHigh==0)) && (isWithinRange(academicScaleLow,academicScaleHigh,schoolList[i][13])|| (academicScaleLow==0 && academicScaleHigh==0)) &&
           (isWithinRange(socialScaleLow,socialScaleHigh,schoolList[i][14])|| (socialScaleLow==0 && socialScaleHigh==0)) && (isWithinRange(lifeScaleLow,lifeScaleHigh,schoolList[i][15])|| (lifeScaleLow==0 && lifeScaleHigh==0))){
          for(int k=0;k<emphasesList.length;k++){
            if(schoolList[k][0].toLowerCase().contains(name.toLowerCase())){
              if(emphases.contains(schoolList[k][1])){
                answer.add(schoolList[k][0]);
              }
            }
          } 
        }
      }
    }
    return answer;
  }
  
  public boolean isWithinRange(double low, double high, String actual){
    double newActual = Double.parseDouble(actual);
    if(newActual>=low && newActual<=high){
      return true; 
    }
    else{
      return false; 
    }
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
  
  public int removeSchool(String user, String school)
  {
    return dataBase.user_removeSchool(user, school);
  }
  
  /**
   * Finds whether or not the schools has been saved
   * @param school the University we want to save to the database
   * @returns true if the school has been saved
   */
  public boolean isSchoolSaved(String name)
  {
    String[][] universityList = dataBase.university_getUniversities();
    for(int i = 0; i<universityList.length;i++){
      if(universityList[i][0].equals(name)){
        return true;
      }
    }
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
  public ArrayList getAllUsers()
  {
    String[][] users = dataBase.user_getUsers();
    ArrayList result = new ArrayList();
    for(int i=0;i< users.length;i++){
      for(int j=0;j<users[i].length;j++){
        result.add(users[i][j]);
      }
    }
    return result;
  }
  
  /**
   * Add an account to the database
   * @param account the account to be added to the database
   * @returns true if successfully added to the database
   */
  public String addAccount(String first, String last, String username, String password, char type)
  {
    boolean taken = isUsernameTaken(username);
    if(!taken){
      dataBase.user_addUser(first,last,username,password,type);
      return "Addition Successful!";
    }
    else{
      return userAlreadyTakenError();
    }
  }
  
  /**
   * Checks whether or not the username has been taken
   * @param username the username we want to check if it currently exists
   * @return true if the username is already taken
   */
  public boolean isUsernameTaken(String username)
  {
    String[][] userList = dataBase.user_getUsers();
    for(int i = 0; i<userList.length;i++){
      if(userList[i][2].equals(username)){
        return true;
      }
    }
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
  public int editAccount(String first, String last, String username, String password, char type, char status)
  {
    return dataBase.user_editUser(username,first,last,password,type,status);
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
  public boolean isDeactivated(String username)
  {
    String[][] userList = dataBase.user_getUsers();
    for(int i = 0; i<userList.length;i++){
      if(userList[i][2].equals(username)){
        if(userList[i][5].equals('n')){
          return true;
        }
      }
    }
    return false;
    
  }
  
  /**
   * Deactivates a given Account
   * @param account the account to be deactivated
   * @returns true if successfully deactivated
   */
  public String deactivateUser(String first, String last, String username, String password, char type)
  {
    if(isDeactivated(username)){
      return alreadyDeactivatedError();
    }
    else{
      dataBase.user_editUser(username,first,last,password,type,'n');
      return "Deactivation Successful!";
    }
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
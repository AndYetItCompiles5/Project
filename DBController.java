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
  /**
   * Creates an instance of the Database Library
   */
  private UniversityDBLibrary dataBase = new UniversityDBLibrary("andyic","andyic","csci230");
  
  /**
   * Creates an instance of UniversityController
   */
  private UniversityController uController = new UniversityController();

  /**
   * Returns an account
   * 
   * @param username:the username of the account that is being found
   * 
   * @returns the Account object associated with the username
   */
  public Account getAccount(String username)
  {
    String first = "";
    String last = "";
    String password = "";
    char type = 'z';
    char status = 'z';
    
    String[][] users = dataBase.user_getUsers();
    
    for(int i = 0; i < users.length;i++){
      if(users[i][2].equals(username))
      {
        first = users[i][0].toString();
        last = users[i][1].toString();
        password = users[i][3].toString();
        type = users[i][4].charAt(0);
        status = users[i][5].charAt(0);
      }
    }
    
    Account account = new Account(first, last, username, password, type, status);
    
    return account;
  }
  
  /**
   * Finds a university that matches the given name
   * @param name:the school name that is being found
   * @returns an university object
   */
  public University getUniversity(String name)
  {
    String state =  "";  
    String loc = "";  
    String control = "";   
    int numStudents = 0;
    double perFemale = 0; 
    int satVerbal = 0;
    int satMath = 0;
    int expenses = 0;
    double perFA = 0;
    int numApplicants = 0;
    double perAdmitted = 0;
    double perEnrolled = 0;
    int academicScale = 0;
    int socialScale = 0;
    int lifeScale = 0; 
    ArrayList<String> emp = new ArrayList<String>();;
    
    String[][] universities = dataBase.university_getUniversities();
    
    for(int i=0;i<universities.length;i++){
      if(universities[i][0].equals(name)){
        name = universities[i][0];
        state = universities[i][1];
        loc = universities[i][2];
        control = universities[i][3];
        numStudents = Integer.parseInt(universities[i][4]);
        perFemale = Double.parseDouble(universities[i][5]);  
        satVerbal = Integer.parseInt(universities[i][6]);
        satMath = Integer.parseInt(universities[i][7]);
        expenses = Integer.parseInt(universities[i][8]);
        perFA = Double.parseDouble(universities[i][9]);
        numApplicants = Integer.parseInt(universities[i][10]);
        perAdmitted = Double.parseDouble(universities[i][11]);
        perEnrolled = Double.parseDouble(universities[i][12]);
        academicScale = Integer.parseInt(universities[i][13]);
        socialScale = Integer.parseInt(universities[i][14]);
        lifeScale = Integer.parseInt(universities[i][15]);
      }
      else{
        return null;
      }
    }
    University university = new University(name,state,loc,control,numStudents,perFemale, satVerbal,
                                           satMath,expenses, perFA,numApplicants,perAdmitted,perEnrolled,
                                           academicScale,socialScale,lifeScale,emp);
    return university;
  }
  
  /**
   * Edits a given university with the specified parameters unless they are null/0
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
   * @param numAppicantds total number of applicants that apply to the school anually
   * @param perAdmitted percent of applicants that get admitted
   * @param perEnrolled percent of applicants that decide to enroll
   * @param academicScale integer between 1 and 5 indicating the academic scale of the University
   * @param socialScale integer between 1 and 5 indicating the quality of social life at the University
   * @param lifeScale integer between 1 and 5 indicating the quality of life at the University
   * @param emphases up to five areas of study the University excels at (all Strings)
   * @returns a success message
   */
  public String editUniversity(String name, String state, String location, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                               int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                               int socialScale, int lifeScale, ArrayList<String> emphases)
  {
    
    String[][] universities = dataBase.university_getUniversities();
    for(int i=0;i<universities.length;i++){
      if(universities[i][0].equals(name)){
        dataBase.university_editUniversity(name,state,location,control,numStudents,perFemale,satVerbal,satMath,expenses,perFA,
                                           numApplicants,perAdmitted,perEnrolled,academicScale,socialScale,lifeScale);
              return "Changes successful";
      }      
    }
    return "Universities doesnt exist";
  }
  
  /**
   * Method to add a a new University object to the database
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
   * @param numAppicantds total number of applicants that apply to the school anually
   * @param perAdmitted percent of applicants that get admitted
   * @param perEnrolled percent of applicants that decide to enroll
   * @param academicScale integer between 1 and 5 indicating the academic scale of the University
   * @param socialScale integer between 1 and 5 indicating the quality of social life at the University
   * @param lifeScale integer between 1 and 5 indicating the quality of life at the University
   * @param emphases up to five areas of study the University excels at (all Strings)
   * @returns success message if the school has been added successfully
   */
  public String addUniversity(String name, String state, String location, String control, int numStudents,
                              double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                              int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                              int socialScale, int lifeScale, ArrayList<String> emphases)
  {
    if(isSchoolSaved(name)){
      return alreadySavedError();
      
    }
    else{
      dataBase.university_addUniversity(name,state, location, control, numStudents,
                                        perFemale, satVerbal, satMath, expenses, perFA,
                                        numApplicants, perAdmitted, perEnrolled, academicScale,
                                        socialScale, lifeScale);
      return name + " was added successfully";
    }
  }
  
  /**
   * Saves a school to the user's list of saved schools
   * @param user:the username of the user where the school is being added to
   * @param school: the school name of the school being added
   * @return an int
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
   * This methods gets the user's saved schools from the DB
   * @param user:the username of the user where the saved schools are being obtained from
   * @returns an array of the user's saved schools
   */
  public ArrayList<University> getUserSavedSchools(String user)
  {
    ArrayList<University> listSchools = new ArrayList<University>();
    String[][] namesWithSchools = dataBase.user_getUsernamesWithSavedSchools();
    
    for(int i = 0; i < namesWithSchools.length; i++)
    {
      if(namesWithSchools[i][0].equals(user))
      {
        for(int j = 0; j < namesWithSchools[i].length; j++)
        {
          //listSchools.add(namesWithSchools[i][j]);
          listSchools.add(getUniversity(namesWithSchools[i][0]));
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
    String[][] usernameList = dataBase.user_getUsers();
    for(int i = 0; i<usernameList.length;i++){
      if(usernameList[i][2].equals(username)){
        return true;
      }
    }
    return false;
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
   * @return a hashset of the found schools
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
  
  /**
   * Checks if the school's actual data is within the range of the low and high that the user searched for
   * @param low: the low bound the user inputted
   * @param high: the high bound the user inputted
   * @param actual: the concrete number of the school
   * @return true if the actual is between the low and the high
   * 
   */
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
   * Confirmation message
   * @return string asking if the user is sure about their decision
   */
  public String confirm()
  {
    return "Are you sure?";
  }
  
  /**
   * Removes the specified school from the user's list
   * @param user: the username of the user where the school is being deleted from
   * @param school: the school name that is being removed
   * @return an integer
   * 
   */
  public int removeSchool(String user, String school)
  {
    return dataBase.user_removeSchool(user, school);
  }
  
  /**
   * Finds whether or not the schools has been saved
   * @param name the university name that is being saved
   * @returns true if the school has already been saved
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
   * Returns an ArrayList of all the users(admin and regular users) in the database
   * 
   * @return a set of all the users in the database
   */
  public ArrayList<Account> getAllUsers()
  {
    String[][] users = dataBase.user_getUsers();
    Account account;
    ArrayList<Account> result = new ArrayList<Account>();
    
    for(int i=0;i< users.length;i++)
    {
      account = getAccount(users[i][2]);
      result.add(account);
    }
    
    return result;
  }
  
  /**
   * Add an account to the database
   * @param first:the first name of the user being added
   * @param last: the last name of the user being added
   * @param username: the username of the user being added
   * @param password: the password of the user being added
   * @param type: boolean of the user's activation or deactivation
   * @returns confirmation message if successfully added to the database
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
   * @param first: the first name of the user
   * @param last: the last name of the user
   * @param username: the username of the user
   * @param password the password of the user
   * @param type: U for user, A for admin
   * @param status: true if active, false if deactive
   * @returns true if the user was successfully edited
   */
  public String editAccount(String first, String last, String username, String password, char type, char status)
  {
    dataBase.user_editUser(username,first,last,password,type,status);
    return "Edit Successful!";
  }
  
  /**
   * Message displayed when asking if the user wants to confirm something
   * @returns a message asking a user if they are sure they want to do something
   */
  public String confirmationMessage()
  {
    return "Are you sure?";
  }
  
  /**
   * Checks to see if an Account is deactivated
   * @param username: the username of the user that the admin is checking
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
   * 
   * @param username: the username of the user
   * 
   * @returns confirmation message if the user was deactivated or not
   */
  public String deactivateUser(String username)
  {
    if(isDeactivated(username))
    {
      return alreadyDeactivatedError();
    }
    
    else
    {
      Account account = getAccount(username);
      
      String first = account.getFirstName();
      String last  = account.getLastName();
      String password = account.getPassword();
      char type = account.getType();
      
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
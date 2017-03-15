package Project;
import java.util.*;
import Project.*;

/**
 * AdminUI
 * @authors: Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/25/2017
 */
public class AdminUI{
  private AdminFuncController aFuncController;
  private AccountController aController;
  private UniversityController uController;
 /// change return type to Set<University> in class diagram
   /* An AdminUI constructor
   */
  public AdminUI(){
    aFuncController = new AdminFuncController();
    aController = new AccountController();
    uController = new UniversityController();

  }
  
  /**
   * view a set of Universities
   * 
   * @return a set of Univserities
   */
  public String[][] viewUniversities(){
    return aFuncController.viewUniversities();
  }
  
  /**
   * An admin can edit Universities
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
   * @param numAppicants total number of applicants that apply to the school anually
   * @param perAdmitted percent of applicants that get admitted
   * @param perEnrolled percent of applicants that decide to enroll
   * @param academicScale integer between 1 and 5 indicating the academic scale of the University
   * @param socialScale integer between 1 and 5 indicating the quality of social life at the University
   * @param lifeScale integer between 1 and 5 indicating the quality of life at the University
   * @param emphases up to five areas of study the University excels at (all Strings)
   * 
   * @return true if the University was added else return false
   */
  public String addUniversity(String name, String state, String location, String control, int numStudents,
                                double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                                int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                                int socialScale, int lifeScale, ArrayList<String> emphases){

    return uController.addUniversity(name,state, location, control, numStudents,
                                perFemale, satVerbal, satMath, expenses, perFA,
                                numApplicants, perAdmitted, perEnrolled, academicScale,
                                socialScale, lifeScale, emphases);
  }
  
  /**
   * An admin edits the Universities
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
   * @param numAppicants total number of applicants that apply to the school anually
   * @param perAdmitted percent of applicants that get admitted
   * @param perEnrolled percent of applicants that decide to enroll
   * @param academicScale integer between 1 and 5 indicating the academic scale of the University
   * @param socialScale integer between 1 and 5 indicating the quality of social life at the University
   * @param lifeScale integer between 1 and 5 indicating the quality of life at the University
   * @param emphases up to five areas of study the University excels at (all Strings)
   */
  public String editUniversity(String name, String state, String location, String control, int numStudents,
           double perFemale, int satVerbal, int satMath, int expenses, double perFA,
           int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
           int socialScale, int lifeScale, ArrayList<String> emphases){
    
        return aFuncController.editUniversity(name,state, location, control, numStudents,
                                perFemale, satVerbal, satMath, expenses, perFA,
                                numApplicants, perAdmitted, perEnrolled, academicScale,
                                socialScale, lifeScale, emphases);
  }
  
  /**
   * View all users
   */
  public ArrayList viewUsers(){
    return aFuncController.viewUsers();
  }
  
  /**
   * An admin can edit any account
   *
   * @param Account object user
   * 
   * @return true if edited else return false
   */
  public String editAccount(String first, String last,String username, String password, char type, char status){
    return aFuncController.editAccount(first,last,username,password,type, status); 
  }
  
  /**
   * An admin can deactivate a user
   *
   * @param Account object user
   */
  public void deactivateUser(String first, String last, String username, String password, char type){
    aController.deactivateUser(first, last, username, password, type);
  }
  
  /**
   * Display the account information
   *
   * @param
   * @param
   * @param
   * @param
   * @param
   * @param
   * 
   * @returns the info of the user
   */
  public ArrayList<String> displayInfo(String first, String last, String username, String password, char type, char status){
    return aFuncController.displayInfo(first,last,username,password,type,status);
  }
  
  /**
   * An admin can create an account 
   *
   * @param
   * @param
   * @param
   * @param
   * @param
   * @param
   * 
   * @return true if added else return false
   */
  public String addAccount(String first, String last, String username, String password, char type){
    return aFuncController.addAccount(first,last,username,password,type);
  }
  
  /**
   * userNotComplete error
   * 
   * @return an error message
   */
  public String userNotCompleteError(){
    return "something"; 
  }
  
  /**
   * confirmation Messgae
   * 
   * @return a conformation message
   */
  public String confirmationMessage(){
    return "something"; 
  }
  
  /**
   * A confirm change
   * 
   * @return true if change is confirmed else return false
   */
  public String confirmChange(){
    return "Are you sure?"; 
  }
  
  /**
   * An empty field error
   * 
   * @return a error message
   */
  public String emptyFieldError(){
    return "error"; 
  }
  
  /**
   * A account is already deactivated
   * 
   * @return "The account is already deactivated"
   */
  public String alreadyDeactivatedError(){
    return "The account is already deactivated"; 
  }
  
  /**
   * No name error. No user with that given name
   * 
   * @return "no name error"
   */
  public String noNameError(){
    return "no name error"; 
  }                                               
}
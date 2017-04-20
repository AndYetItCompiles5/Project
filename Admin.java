<<<<<<< HEAD
import java.util.*;
import Project230.*;

/**
 * Admin
 * @authors: Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
=======
package Project;
import java.util.*;
import Project.*;

/**
 * Admin
 * @author Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
 * @version 2/25/2017
 */

public class Admin extends Account{
<<<<<<< HEAD
   
  /**
   *Constructor 
   */
  public Admin(String first, String last, String username, String password, char type, boolean status)
  {
    super(first,last,username,password,type,status);
  }
  
  /**
   * Edit a University
   * 
   * @return true if the University was edited else return false
   */
  public boolean editUniversity(University school){
    return false;
  }
  
  /**
   * add an University to the database
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
  public boolean addUniversity(String name, String state, String location, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                               int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                               int socialScale, int lifeScale, ArrayList<String> emphases){
    return false; 
  }
  
  /**
   * add an Account to the database
   * 
   * @return true if the account was added else return false
   */
  public boolean addAccount(String first, String last, String username, String password, char type, Boolean Status){
    return false;
  }
  
  /**
   * edit an Account in the database
   * 
   * @return true if the account was edited else return false
   */
  public boolean editAccount(Account account){
    return false; 
=======
  
  /**
   * Default constructor
   * @param first the first name of the Admin
   * @param last the last name of the Admin
   * @param username of the Admin
   * @param password the password of the admin
   */
  public Admin(String first, String last, String username, String password)
  {
    super(first,last,username,password,'a','y');
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
}

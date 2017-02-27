import java.util.*;
import Project230.*;

/**
 * A controller class that lets the user search for universities with their provided information
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class SearchController{
 
  public SearchController()
  {
    
  }
  /**
   * Searches for schools with the provided information
   * @param name the name of the University
   * @param state the state the University is located int
   * @param loc can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or -1 if unknown
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
   * @return set of schools that match the search criteria
   */
  public Set<String> search(String name, String state, String loc, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                               int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                               int socialScale, int lifeScale, ArrayList<String> emphases)
  {
    return null;
  }
  /**
   * Gets any recommended schools
   * @param name the name of the University
   * @param state the state the University is located int
   * @param loc can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or -1 if unknown
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
   * @return set of recommended schools
   */
  public Set<String> findReccomendations(String name, String state, String loc, String control, int numStudents,
                               double perFemale, int satVerbal, int satMath, int expenses, double perFA,
                               int numApplicants, double perAdmitted, double perEnrolled, int academicScale,
                               int socialScale, int lifeScale, ArrayList<String> emphases)
  {
    return null;
  }
  /**
   * Displays the search results
   * @param list: the list of universities that will be displayed
   * @return the set of universities being displayed
   * 
   */
  public Set<String> displayResults(Set<String> list)
  {
    return null;
  }
  /**
   * Resets the search fields
   * 
   */
  public void resetFields()
  {
    
  }
}
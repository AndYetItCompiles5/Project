package Project;
import java.util.*;
import dblibrary.project.csci230.UniversityDBLibrary;
import Project.*;

/**
 * A controller class that lets the user search for universities with their provided information
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class SearchController
{
  /**
   * Creates an instance of the Database Library
   */
  private DBController dbController;

  /**
   * Default constructor. Initialized the DB Controller.
   */
  public SearchController()
  {
    dbController = new DBController();
  }
  
  /**
   * Searches for schools with the provided information
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
   * @return hashset of the schools that were found
   */
  public HashSet<String> search(String name, String state, String location, String control, int numStudentsLow,
                     int numStudentsHigh, double perFemaleLow, double perFemaleHigh, int satVerbalLow, int satVerbalHigh,
                     int satMathLow, int satMathHigh, int expensesLow, int expensesHigh, double perFALow, double perFAHigh,
                     int numApplicantsLow, int numApplicantsHigh, double perAdmittedLow, double perAdmittedHigh, double perEnrolledLow, double perEnrolledHigh,
                     int academicScaleLow, int academicScaleHigh, int socialScaleLow, int socialScaleHigh, int lifeScaleLow, int lifeScaleHigh, ArrayList<String> emphases)
  {
    return dbController.search(name, state, location, control, numStudentsLow,numStudentsHigh, perFemaleLow,perFemaleHigh, satVerbalLow,satVerbalHigh,
                                   satMathLow,satMathHigh,expensesLow,expensesHigh,
                                   perFALow,perFAHigh, numApplicantsLow,numApplicantsHigh, perAdmittedLow,perAdmittedHigh,perEnrolledLow,perEnrolledHigh,
                                   academicScaleLow,academicScaleHigh,socialScaleLow,socialScaleHigh, lifeScaleLow,lifeScaleHigh,
                                   emphases);
  }
  
  /**
   * Gets any recommended schools
   * @param name the name of the University
   * 
   * @return ArrayList of recommended schools
   */
  public ArrayList<String> findRecommendations(String name)
  {
   return dbController.findRecommendations(name);
  }

}
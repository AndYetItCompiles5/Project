package Project;
import java.util.*;
import java.lang.*;
import Project.*;
/**
 * University Objects that represent schools in the database
 * @authors: Nathan Hansen, Zak Luetmer, Colton Alseth, TJ Schmitz
 * @version 2/22/2017
 */
public class University{
  //name of the University
  private String name;
  //state the University is located in
  private String state;
  //can be one of the following: SUBURBAN, URBAN, SMALL-CITY, or -1 if unknown
  private String location;
  //can be one of the following: PRIVATE, STATE, CITY, or -1 if unknown
  private String control;
  //number of students enrolled in the University
  private int numberOfStudents;
  //percentage of enrolled students that are females (between 0 and 100)
  private double percentFemale;
  //average SAT verbal score for enrolled students(between 0 and 800)
  private int satVerbal;
  //average SAT math score for enrolled students(between 0 and 800)
  private int satMath;
  //annual expenses or tuition to attend the school
  private int expenses;
  //percentage of enrolled students receiving financial aid
  private double percentFA;
  //total number of applicants that apply to the school anually
  private int numApplicants;
  //percent of applicants that get admitted
  private double percentAdmitted;
  //percent of applicants that decide to enroll
  private double percentEnrolled;
  //integer between 1 and 5 indicating the academic scale of the University
  private int academicScale;
  //integer between 1 and 5 indicating the quality of social life at the University
  private int socialScale;
  //integer between 1 and 5 indicating the quality of life at the University
  private int lifeScale;
  //up to five areas of study the University excels at (all Strings)
  private ArrayList<String> emphases;
  
  /**
   * Contructor to create a University object. Name must be filled in
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
   * @param emp up to five areas of study the University excels at (all Strings)
   * @throws IllegalArgumentException if name is not given
   */
  public University(String name, String state, String location, String control, int numStudents, double perFemale, 
                    int satVerbal, int satMath, int expenses, double perFA, int numApplicants, double perAdmitted,
                    double perEnrolled, int academicScale, int socialScale, int lifeScale, ArrayList<String> emp){
    if(name.equals("")||name==null)
      throw new IllegalArgumentException("Name of the university is required");
    else{
      this.name=name;
      this.state=state;
      this.location=location;
      this.control=control;
      this.numberOfStudents=numStudents;
      this.percentFemale=perFemale;
      this.satVerbal=satVerbal;
      this.satMath=satMath;
      this.expenses=expenses;
      this.percentFA=perFA;
      this.numApplicants=numApplicants;
      this.percentAdmitted=perAdmitted;
      this.percentEnrolled=perEnrolled;
      this.academicScale=academicScale;
      this.socialScale=socialScale;
      this.lifeScale=lifeScale;
      this.emphases=emp;
    }
  }
  
  public University(String name){
    this.name=name;
    this.state=null;
    this.location=null;
    this.control=null;
    this.numberOfStudents=0;
    this.percentFemale=0;
    this.satVerbal=0;
    this.satMath=0;
    this.expenses=0;
    this.percentFA=0;
    this.numApplicants=0;
    this.percentAdmitted=0;
    this.percentEnrolled=0;
    this.academicScale=0;
    this.socialScale=0;
    this.lifeScale=0;
    this.emphases=null;
  }
  
  /**
   * get the name of the University
   * @return the name of the University
   */
  public String getName(){
    return name;
  }
  
  /**
   * get the state the University is in
   * @return the state the University is in
   */
  public String getState(){
    return state;
  }
  
  /**
   * sets the state the University is in
   * @param state the state the University is in
   */
  public void setState(String state)
  {
    this.state=state;
  }
  
  /**
   * get the location of the University
   * @return the location of the University
   */
  public String getLocation()
  {
    return location;
  }
  
  /**
   * set the location of the University
   * @param location the location of the University
   * @throws IllegalArgumentException if location is not SUBURBAN, URBAN, SMALL-CITY, or -1
   */
  public void setLocation(String location){
    if(location.equals("SUBURBAN")||location.equals("URBAN")||location.equals("SMALL-CITY")||location.equals("-1"))
      this.location=location;
    else
      throw new IllegalArgumentException("location must be SUBURBAN, URBAN, SMALL-CITY, or -1");
  }
  
  /**
   * get the control of the University
   * @return the control of the University
   */
  public String getControl(){
    return control;
  }
  
  /**
   * set the control of the University
   * @param control the control of the University
   * @throws IllegalArgumentException if control is not PRIVATE, STATE, CITY, or -1
   */
  public void setControl(String control){
    if(control.equals("PRIVATE")||control.equals("STATE")||control.equals("CITY")||control.equals("-1"))
      this.control=control;
    else
      throw new IllegalArgumentException("control must be PRIVATE, STATE, CITY, or -1");
  }
  
  /**
   * gets the number of students enrolled at the University
   * @return the number of students enrolled at the University
   */
  public int getNumStudents(){
    return numberOfStudents;
  }
  
  /**
   * sets the number of students enrolled at the University
   * @param num the number of students enrolled at the University
   */
  public void setNumStudents(int num){
    this.numberOfStudents=num;
  }
  
  /**
   * gets the percent of enrolled students who are female
   * @return the percent of enrolled students who are female
   */
  public double getPercentFemale(){
    return percentFemale;
  }
  
  /**
   * sets the percent of enrolled students who are female
   * @param per the percent of enrolled students who are female
   * @throws IllegalArgumentException if per is <0 or >100
   */
  public void setPercentFemale(int per){
    if(per<0||per>100)
      throw new IllegalArgumentException("percent must be greater than zero and less than 100");
    else
      this .percentFemale=per;
  }
  
  /**
   * gets the average SAT verbal score for enrolled students
   * @return the average SAT verbal score for enrolled students
   */
  public int getSatVerbal(){
    return satVerbal;
  }
  
  /**
   * sets the average SAT verbal score for enrolled students
   * @param score the average SAT verbal score for enrolled students
   * @throws IllegalArgumentException if score is not between 0 and 800
   */
  public void setSatVerbal(int score){
    if(score<0||score>800)
      throw new IllegalArgumentException("Score must be between 0 and 800");
    else
      this.satVerbal=score;
  }
  
  /**
   * gets the average SAT math score for enrolled students
   * @return the average SAT math score for enrolled students
   */
  public int getSatMath(){
    return satMath;
  }
  
  /**
   * sets the average SAT math score for enrolled students
   * @param score the average SAT math score for enrolled students
   * @throws IllegalArgumentException if score is not between 0 and 800
   */
  public void setSatMath(int score){
    if(score<0||score>800)
      throw new IllegalArgumentException("Score must be between 0 and 800");
    else
      this.satMath=score;
  }
  
  /**
   * gets the annual expenses or tuition to attend the University
   * @return the annual expenses or tuition to attend the University
   */
  public int getExpenses(){
    return expenses;
  }
  
  /**
   * sets the annual expesnes or tuition to attend the University
   * @param expense the annual expenses or tuition to attend the University
   */
  public void setExpenses(int expense){
    this.expenses=expense;
  }
  
  /**
   * gets the percent of enrolled students receiving financial aid
   * @return the percent of enrolled students receiving financial aid
   */
  public double getFinancialAid(){
    return percentFA;
  }
  
  /**
   * set the percent of enrolled students receiving financial aid
   * @param percent the percent of enrolled students receiving financial aid
   * @throws IllegalArgumentException if percent <0 or >100
   */
  public void setFinancialAid(double percent){
    if(percent<0||percent>100)
      throw new IllegalArgumentException("percent must be greater than 0 and less than 100");
    else
      this.percentFA=percent;
  }
  
  /**
   * gets the number of applicant that apply to the school annually
   * @return the number of applicants that apply to the school annually
   */
  public int getNumApplicants(){
    return numApplicants;
  }
  
  /**
   * set the number of applicants that apply to the school annually
   * @param num the number of applicants that apply to the school annually
   */
  public void setNumApplicants(int num){
    this.numApplicants=num;
  }
  
  /**
   * gets the percent of applicants that get admitted
   * @return the percent of applicants that get admitted
   */
  public double getPercentAdmitted(){
    return percentAdmitted;
  }
  
  /**
   * set the percent of applicants that get admitted
   * @param per the percent of applicants that get admitted
   * @throw IllegalArgumentException if per is <0 or >100
   */
  public void setPercentAdmitted(double per){
    if(per<0||per>100)
      throw new IllegalArgumentException("percent must be greater than 0 and less than 100");
    else
      this.percentAdmitted=per;
  }
  
  /**
   * get the percent of applicants that decide to enroll
   * @return the percent of applicants that decide to enroll
   */
  public double getPercentEnrolled(){
    return percentEnrolled;
  }
  
  /**
   * set the percent of applicants that decide to enroll
   * @param per the percent of applicants that decide to enroll
   * @throw IllegalArgumentException if per is <0 or >100
   */
  public void setPercentEnrolled(double per){
    if(per<0||per>100)
      throw new IllegalArgumentException("percent must be greater than 0 and less than 100");
    else
      this.percentEnrolled=per;
  }
  
  /**
   * get the academic scale of the University
   * @return the academic scale of the University
   */
  public int getAcademicScale(){
    return academicScale;
  }
  
  /**
   * set the academic scale of the University
   * @param scale the academic scale of the University
   * @throws IllegalArgumentException if scale is not between 1 and 5
   */
  public void setAcademicScale(int scale){
    if(scale<1||scale>5)
      throw new IllegalArgumentException("scale must be between 1 and 5");
    else
      this.academicScale=scale;
  }
  
  /**
   * get the social scale of the University
   * @return the social scale of the University
   */
  public int getSocialScale(){
    return socialScale;
  }
  
  /**
   * set the social scale of the University
   * @param scale the social scale of the University
   * @throws IllegalArgumentException if scale is not between 1 and 5
   */
  public void setSocialscale(int scale){
    if(scale<1||scale>5)
      throw new IllegalArgumentException("scale must be between 1 and 5");
    else
      this.socialScale=scale;
  }
  
  /**
   * get the life scale of the University
   * @return the life scale of the University
   */
  public int getLifeScale(){
    return lifeScale;
  }
  
  /**
   * set the life scale of the University
   * @param scale the life scale of University
   * @throws IllegalArgumentException if scale is not between 1 and 5
   */
  public void setLifeScale(int scale){
    if(scale<1||scale>5)
      throw new IllegalArgumentException("scale must be between 1 and 5");
    else
      this.lifeScale=scale;
  }
  
  /**
   * gets the emphases of the University
   * @return the emphases of the University
   */
  public ArrayList<String> getEmphases(){
    return emphases;
  }
  
  /**
   * set the emphases of the University
   * @param emphases the emphases of the University
   */
  public void setEmphases(ArrayList<String> emphases){
    this.emphases=emphases;
  }
}


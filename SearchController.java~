package Project;
import java.util.*;
import Project.*;

/**
 * A controller class that lets the user search for universities with their provided information
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class SearchController{
  
  /**
   * Creates an instance of the Database Library
   */
  private DBController dbController;
  
  /**
   * Default constuctor. Initialized the DB Controller.
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
   * @return hashset of the schools that were found
   */
  public HashSet<String> search(String name, String state, String location, String control, int numStudentsLow,
                     int numStudentsHigh, double perFemaleLow, double perFemaleHigh, int satVerbalLow, int satVerbalHigh,
                     int satMathLow, int satMathHigh, int expensesLow, int expensesHigh, double perFALow, double perFAHigh,
                     int numApplicantsLow, int numApplicantsHigh, double perAdmittedLow, double perAdmittedHigh, double perEnrolledLow, double perEnrolledHigh,
                     int academicScaleLow, int academicScaleHigh, int socialScaleLow, int socialScaleHigh, int lifeScaleLow, int lifeScaleHigh, ArrayList<String> emphases){
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
  public ArrayList<University> findReccomendations(String name)
  {
	 String[][] rec = dbController.getAllUniversities();
	 Object[][] values = new Object[rec.length][];
	 ArrayList<University> topFive = new ArrayList<University>();
	 
	 University currentUniversity = dbController.getUniversity(name);
    
    String loc = currentUniversity.getLocation(); //1
    String state = currentUniversity.getState(); //2
    String control = currentUniversity.getControl(); //3
    int numStudents = currentUniversity.getNumStudents(); //4
    double percentFemale = currentUniversity.getPercentFemale(); //5
    int satVerbal = currentUniversity.getSatVerbal(); //6
    int satMath = currentUniversity.getSatMath(); //7
    int expenses = currentUniversity.getExpenses(); //8
    double perFA = currentUniversity.getFinancialAid(); //9
    int numApplicants = currentUniversity.getNumApplicants(); //10
    double perAdmitted = currentUniversity.getPercentAdmitted(); //11
    double perEnrolled = currentUniversity.getPercentEnrolled(); //12
    int academicScale = currentUniversity.getAcademicScale(); //13
    int socialScale = currentUniversity.getSocialScale(); //14
    int lifeScale = currentUniversity.getLifeScale(); //15
    ArrayList<String> emp = currentUniversity.getEmphases(); //16
    
    
	int maxNumStudents = 0,maxSatVerbal=0,maxSatMath=0,maxExpenses=0,maxNumApplicants=0,maxAcademicScale=5, maxSocialScale=5,maxLifeScale=5;
	double minPercentFemale, maxPercentFemale=0, minPerFA, maxPerFA=0, minPerAdmitted, maxPerAdmitted=0, minPerEnrolled, maxPerEnrolled=0;
	
	int minNumStudents,minSatVerbal,minSatMath, minExpenses, minNumApplicants, minAcademicScale = 1, minSocialScale = 1, minLifeScale = 1;
	minPerEnrolled=minPerAdmitted=minPerFA=minPercentFemale=minNumStudents=minSatVerbal=minSatMath =minExpenses=minNumApplicants = 999999999;
    
	//getting maxs and mins
    for(int i = 0; i < rec.length; i++){
    	for(int j = 4; j < rec[i].length;j++){
    		
    		switch(j)
    		{
    			//numStudents
    			case 4:
    				if(Integer.parseInt(rec[i][j]) > maxNumStudents)
    				{
    					maxNumStudents = Integer.parseInt(rec[i][j]);
    				}
    				else if(Integer.parseInt(rec[i][j]) < minNumStudents)
    				{
    					minNumStudents = Integer.parseInt(rec[i][j]);
    				}
    				break;
    			//percentFemale
    			case 5:
    				if(Double.parseDouble(rec[i][j]) > maxPercentFemale)
    				{
    					maxPercentFemale = Double.parseDouble(rec[i][j]);
    				}
    				else if(Double.parseDouble(rec[i][j]) < minPercentFemale)
    				{
    					minPercentFemale = Double.parseDouble(rec[i][j]);
    				}
    				break;
    			//satVerbal
    			case 6:
    				if(Integer.parseInt(rec[i][j]) > maxSatVerbal)
    				{
    					maxSatVerbal = Integer.parseInt(rec[i][j]);
    				}
    				else if(Integer.parseInt(rec[i][j]) < minSatVerbal)
    				{
    					minSatVerbal = Integer.parseInt(rec[i][j]);
    				}
    				break;
    			//satMath
    			case 7:
    				if(Integer.parseInt(rec[i][j]) > maxSatMath)
    				{
    					maxSatMath = Integer.parseInt(rec[i][j]);
    				}
    				else if(Integer.parseInt(rec[i][j]) < minSatMath)
    				{
    					minSatMath = Integer.parseInt(rec[i][j]);
    				}
    				break;
    			//expenses
    			case 8:
    				if(Integer.parseInt(rec[i][j]) > maxExpenses)
    				{
    					maxExpenses = Integer.parseInt(rec[i][j]);
    				}
    				else if(Integer.parseInt(rec[i][j]) < minExpenses)
    				{
    					minExpenses = Integer.parseInt(rec[i][j]);
    				}
    				break;
    			//perFA
    			case 9:
    				if(Integer.parseInt(rec[i][j]) > maxPerFA)
    				{
    					maxPerFA = Double.parseDouble(rec[i][j]);
    				}
    				else if(Integer.parseInt(rec[i][j]) < minPerFA)
    				{
    					minPerFA = Double.parseDouble(rec[i][j]);
    				}
    				break;
    			//numApplicants
    			case 10:
    				if(Integer.parseInt(rec[i][j]) > maxNumApplicants)
    				{
    					maxNumApplicants = Integer.parseInt(rec[i][j]);
    				}
    				else if(Integer.parseInt(rec[i][j]) < minNumApplicants)
    				{
    					minNumApplicants = Integer.parseInt(rec[i][j]);
    				}
    				break;
    			//percentAdmitted
    			case 11:
    				if(Double.parseDouble(rec[i][j]) > maxPerAdmitted)
    				{
    					maxPerAdmitted = Integer.parseInt(rec[i][j]);
    				}
    				else if(Double.parseDouble(rec[i][j]) < minPerAdmitted)
    				{
    					minPerAdmitted = Integer.parseInt(rec[i][j]);
    				}
    				break;
    			//percentEnrolled
    			case 12:
    				if(Double.parseDouble(rec[i][j]) > maxPerEnrolled)
    				{
    					maxPerEnrolled = Integer.parseInt(rec[i][j]);
    				}
    				else if(Double.parseDouble(rec[i][j]) < minPerEnrolled)
    				{
    					minPerEnrolled = Integer.parseInt(rec[i][j]);
    				}
    				break;
    		}
    		
    	}
    }
	
	
    for(int i = 0; i < rec.length; i++)
    {
    	//don't compare the university to itself
    	if(!name.equals(rec[i][0]))
    	{
    		double value = 0;
    		
    		University comparedUniversity = new University(rec[i][0]);
    		
    		//compare location
    		value += (loc.equals(comparedUniversity.getLocation()) || comparedUniversity.getLocation() == null) ? 0 : 1;
    		
    		//compare state
    		value += (state.equals(comparedUniversity.getState()) || comparedUniversity.getState() == null) ? 0 : 1;
    		
    		//compare control
    		value += (control.equals(comparedUniversity.getControl()) || comparedUniversity.getControl() == null) ? 0 : 1;
    		
    		//compare numStudents
    		value += comparedUniversity.getNumStudents() == 0 ? 0 : Math.abs((numStudents-comparedUniversity.getNumStudents()) / (maxNumStudents-minNumStudents));
    		
    		//compare percentFemale
    		value += comparedUniversity.getPercentFemale() == 0 ? 0 : Math.abs((percentFemale-comparedUniversity.getPercentFemale()) / (maxPercentFemale-minPercentFemale));
    		
    		//compare satVerbal
    		value += comparedUniversity.getSatVerbal() == 0 ? 0 : Math.abs((satVerbal-comparedUniversity.getSatVerbal()) / (maxSatVerbal-minSatVerbal));
    		
    		//compare satMath
    		value += comparedUniversity.getSatMath() == 0 ? 0 : Math.abs((satMath-comparedUniversity.getSatMath()) / (maxSatMath-minSatMath));
    		
    		//compare expenses
    		value += comparedUniversity.getExpenses() == 0 ? 0 : Math.abs((expenses-comparedUniversity.getExpenses()) / (maxExpenses-minExpenses));
    		
    		//compare perFA
    		value += comparedUniversity.getFinancialAid() == 0 ? 0 : Math.abs((perFA-comparedUniversity.getFinancialAid()) / (maxPerFA-minPerFA));
    		
    		//compare numApplicants
    		value += comparedUniversity.getNumApplicants() == 0 ? 0 : Math.abs((numApplicants-comparedUniversity.getNumApplicants()) / (maxNumApplicants-minNumApplicants));
    		
    		//compare perAdmitted
    		value += comparedUniversity.getPercentAdmitted() == 0 ? 0 : Math.abs((perAdmitted-comparedUniversity.getPercentAdmitted()) / (maxPerAdmitted-minPerAdmitted));
    		
    		//compare perEnrolled
    		value += comparedUniversity.getPercentEnrolled() == 0 ? 0 : Math.abs((perEnrolled-comparedUniversity.getPercentEnrolled()) / (maxPerEnrolled-minPerEnrolled));
    		
    		//compare academicScale
    		value += comparedUniversity.getAcademicScale() == 0 ? 0 : Math.abs((academicScale-comparedUniversity.getAcademicScale()) / (4));
    		
    		//compare socialScale
    		value += comparedUniversity.getSocialScale() == 0 ? 0 : Math.abs((socialScale-comparedUniversity.getSocialScale()) / (4));
    		
    		//compare lifeScale
    		value += comparedUniversity.getLifeScale() == 0 ? 0 : Math.abs((lifeScale-comparedUniversity.getLifeScale()) / (4));
    		
    		//compare emphases

    		values[i][0] = comparedUniversity.getName();
    		values[i][1] = value;
        }
    	
    	
    }
  //get top 5 from the map and put them into an ArrayList: return the arraylist
    for(int i = 0; i < values.length - 1; i++)
    {
    	for(int j = i+1; j < values.length; j++)
    	{
    		if((double)values[i][1] > (double)values[j][1])
    		{
    			double tempValue = (double)values[i][1];
    			String tempName = (String)values[i][0];
    			
    			values[i][1] = values[j][0];
    			values[j][1] = tempValue;
    			values[i][0] = values[j][1];
    			values[j][0] = tempName;
    		}
    	}
    }
    
    for(int i = 0; i < 5; i++)
    {
    	topFive.add(dbController.getUniversity((String)values[i][0]));
    }
    
    return topFive;
  }

}
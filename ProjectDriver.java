package Project;
import java.util.*;

import Project.*;

public class ProjectDriver {
	private UserUI userUI;
	private AdminUI adminUI;
	private LoginUI loginUI;
	private AccountController aController;
	
	public ProjectDriver(){
		userUI = new UserUI();
		adminUI = new AdminUI();
		loginUI = new LoginUI();
		//aController = new AccountController();
				
	}
	
	public void run(){
		//Adds 3 Accounts
		adminUI.addAccount("Zak", "Luetmer", "zakluetmer", "password", 'u');
		adminUI.addAccount("Nathan", "Hansen", "nhansen", "password", 'a');
		adminUI.addAccount("Colton","Alseth","calseth","password",'a');
		
		//Checks if the added accounts are in the database and checks for errors
		
		System.out.println("zakluetmer, nhansen, and calseth should be in the database: "+Arrays.deepToString(adminUI.viewUsers()));
		System.out.println("Should return 'username taken' error: " + adminUI.addAccount("Taken","User","zakluetmer","password",'u'));
		System.out.println("Should return 'Fill in all information' error: " +adminUI.addAccount("Not","Complete","","",'u'));
		
		//Checks for a successful deactivation and deactivation error
		
		System.out.println("Colton Alseth should be deactivated" + Arrays.deepToString(adminUI.viewUsers()));
		System.out.println("Should return 'account already deactivated' error: " + adminUI.deactivateUser("calseth"));
		
		//Tests login and errors involving the login process
		
		System.out.println("Should return 'User deactivated' error: "+loginUI.Login("calseth", "password"));
		System.out.println("Should return 'Wrong login info' error: "+loginUI.Login("wrong", "info"));
		System.out.println("Should return 'Successful login': " + loginUI.Login("zakluetmer", "password"));
		
		//Checks if editing an account works and checks for errors
		adminUI.editAccount("NotColton","Alseth","calseth","password",'a','n');
		System.out.println("Should change Colton's name to 'NotColton': "+ Arrays.deepToString(adminUI.viewUsers()));
		System.out.println("Should return an empty field error: " +adminUI.editAccount("Colton","Alseth","calseth","",'a','n'));
		
		//Checks the display information method
		
		System.out.println("Should display Zak's info: " + adminUI.displayInfo("zakluetmer"));
		
		//Creates school "SJU"
		
		ArrayList<String> emphasis = new ArrayList<String>();
		emphasis.add("Science");
		emphasis.add("Math");
		System.out.println(emphasis);
		System.out.println("Output depends on if the program has been run before: "+ adminUI.addUniversity("CSB", "Minnesota", "RURAL", "PRIVATE", 4000, 50.0, 500, 500, 50000, 91.0, 2000, 65.0, 50.0, 4, 4, 1,emphasis));
		System.out.println("Should return a missing name error: "+ adminUI.addUniversity("", "Minnesota", "RURAL", "PRIVATE", 4000, 50.0, 500, 500, 50000, 91.0, 2000, 65.0, 50.0, 4, 4, 1,emphasis));
		
		//Edits SJU
		
	    adminUI.editUniversity("SJU", "Minnesota", "URBAN", "PRIVATE", 4000, 50.0, 500, 500, 50000, 91.0, 2000, 65.0, 50.0, 4, 4, 1,emphasis);
	    System.out.println("Should change SJU from 'RURAL' to 'URBAN': " + adminUI.displayUniversity("SJU"));
	    
		//Displays all universities including the newly added SJU
		
		System.out.println("Displays universities: " + adminUI.viewUniversities());
		
		//Tries to add an already added university and returns an error message
		
		System.out.println("Should return 'aready saved' error: "+adminUI.addUniversity("QUEENS", "Minnesota", "RURAL", "PRIVATE", 4000, 50.0, 500, 500, 50000, 91.0, 2000, 65.0, 50.0, 4, 4,0, emphasis));
		
		//Saves Queens and Adelphi to user's list, output changes depending on if the program has been run before and views saved schools
		
		System.out.println("Output depends on if the program has been run before: "+userUI.saveSchool("zakluetmer","QUEENS"));
		System.out.println("Output depends on if the program has been run before: "+userUI.saveSchool("zakluetmer","ADELPHI"));
		System.out.println("Should return that ADELPHI and QUEENS has been saved by Zak: "+userUI.viewSavedSchools("zakluetmer"));
		
		//Remoevs school from user's list
		
		userUI.removeSchool("zakluetmer", "ADELPHI");
		System.out.println("Should return that ADELPHI has been removed: "+userUI.viewSavedSchools("zakluetmer"));
		
		//Displays CSB specifically
		System.out.println(adminUI.displayUniversity("CSB"));
		
		//Searches for "College" using the search function and views results
		System.out.println("Should return all schools with 'College' in their name: " + userUI.search("College", "", "", "", 0, 0, 0.0, 0.0, 0, 0, 0, 0, 0, 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0, 0, 0, 0, 0, null));
	
	}
	
	
	public static void main (String args[]){
		ProjectDriver driver = new ProjectDriver();
		driver.run();
	}
}

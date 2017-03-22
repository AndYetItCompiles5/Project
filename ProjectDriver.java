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
		aController = new AccountController();
				
	}
	
	public void run(){
		
		adminUI.addAccount("Zak", "Luetmer", "zakluetmer", "password", 'u');
		adminUI.addAccount("Nathan", "Hansen", "nhansen", "password", 'a');
		adminUI.addAccount("Colton","Alseth","calseth","password",'a');
		System.out.println("zakluetmer, nhansen, and calseth should be in the database: "+Arrays.deepToString(adminUI.viewUsers()));
		System.out.println("Should return 'username taken' error: " + adminUI.addAccount("Taken","User","zakluetmer","password",'u'));
		System.out.println("Should return 'Fill in all information' error: " +adminUI.addAccount("Not","Complete","","",'u'));
		
		System.out.println("Colton Alseth should be deactivated" + Arrays.deepToString(adminUI.viewUsers()));
		System.out.println("Should return 'account already deactivated' error: " + adminUI.deactivateUser("calseth"));
		
		System.out.println("Should return 'User deactivated' error: "+loginUI.Login("calseth", "password"));
		System.out.println("Should return 'Wrong login info' error: "+loginUI.Login("wrong", "info"));
		System.out.println("Should return 'Successful login': " + loginUI.Login("zakluetmer", "password"));
		
		adminUI.editAccount("NotColton","Alseth","calseth","password",'a','n');
		System.out.println("Should change Colton's name to 'NotColton': "+ Arrays.deepToString(adminUI.viewUsers()));
		
		System.out.println("Should display Zak's info: " + adminUI.displayInfo("zakluetmer"));
		
		ArrayList<String> emphasis = new ArrayList<String>();
		emphasis.add("Science");
		System.out.println("Output depends on if the program has been run before: "+ adminUI.addUniversity("SJU", "Minnesota", "RURAL", "PRIVATE", 4000, 50.0, 500, 500, 50000, 91.0, 2000, 65.0, 50.0, 4, 4, 1,emphasis));
		
		System.out.println("Displays universities: " + adminUI.viewUniversities());
		
		System.out.println("Should return 'aready saved' error: "+adminUI.addUniversity("QUEENS", "Minnesota", "RURAL", "PRIVATE", 4000, 50.0, 500, 500, 50000, 91.0, 2000, 65.0, 50.0, 4, 4,0, emphasis));
		
		System.out.println("Output depends on if the program has been run before: "+userUI.saveSchool("zakluetmer","QUEENS"));
		System.out.println("Output depends on if the program has been run before: "+userUI.saveSchool("zakluetmer","ADELPHI"));
		System.out.println("Should return that ADELPHI and QUEENS has been saved by Zak: "+userUI.viewSavedSchools("zakluetmer"));
		System.out.println("Removes 'Queens' from the list");
		
		System.out.println(adminUI.displayUniversity("SJU") + "___________________________doesnt show empathies");
		
		
	}
	
	
	public static void main (String args[]){
		ProjectDriver driver = new ProjectDriver();
		driver.run();
	}
}

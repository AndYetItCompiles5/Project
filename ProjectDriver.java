package Project;
import java.util.*;

import Project.*;

public class ProjectDriver {
	private UserUI userUI;
	private AdminUI adminUI;
	private LoginUI loginUI;
	
	public ProjectDriver(){
		userUI = new UserUI();
		adminUI = new AdminUI();
		loginUI = new LoginUI();
				
	}
	
	public void run(){
		adminUI.addAccount("Zak", "Luetmer", "zakluetmer", "password", 'u');
		adminUI.addAccount("Nathan", "Hansen", "nhansen", "password", 'a');
		adminUI.addAccount("Colton","Alseth","calaseth","password",'a');
		System.out.println("Should return list of users: "+ adminUI.viewUsers());
		System.out.println("Should return 'username taken' error: " + adminUI.addAccount("Taken","User","zakluetmer","password",'u'));
		System.out.println("Should return 'Fill in all information' error: " +adminUI.addAccount("Not","Complete","","",'u'));
		
		adminUI.deactivateUser("Colton", "Alseth", "calaseth", "password", 'a');
		System.out.println("Colton Alseth should be deactivated" + adminUI.viewUsers());
		System.out.println("Should return 'account already deactivated' error: " + adminUI.deactivateUser("Colton", "Alseth", "calaseth", "password", 'a'));
		
		//System.out.println("Should return 'Successful login': " + loginUI.Login("zakluetmer", "password"));
		//System.out.println("Should return 'User deactivated' error: "+loginUI.Login("calaseth", "password"));
		//System.out.println("Should return 'Wrong login info' error: "+loginUI.Login("wrong", "info"));
		
		adminUI.editAccount("NotColton","Alseth","calaseth","password",'a','n');
		System.out.println("Should change Colton's name to 'NotColton': "+ adminUI.viewUsers());
		
		System.out.println("Should display Zak's info: " + adminUI.displayInfo("Zak", "Luetmer", "zakluetmer", "password", 'u', 'Y'));
		
		//ArrayList<String> emphasis = new ArrayList<String>();
		//emphasis.add("Science");
		System.out.println(adminUI.addUniversity("Saint John's University", "Minnesota", "RURAL", "PRIVATE", 4000, 50.0, 500, 500, 50000, 91.0, 2000, 65.0, 50.0, 4, 4, 1));
		
		System.out.println("Displays universities: " + adminUI.viewUniversities());
	}
	
	
	public static void main (String args[]){
		ProjectDriver driver = new ProjectDriver();
		driver.run();
	}
}

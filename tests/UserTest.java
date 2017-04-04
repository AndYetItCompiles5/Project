package Project.tests;
import Project.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	 private User user;
	 private DBController dbController;
	@Before
	public void init(){
		  dbController = new DBController();
		  dbController.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'U', 'Y');
		  user = new User("Zak","Luetmer","zakluetmer","password");
		  user.addNewUniversity("zakluetmer", "ADELPHI");
		  user.removeSchool("zakluetmer", "ADELPHI");
		  
	}

	@Test
	public void testGetSavedSchools() {
		user.addNewUniversity("zakluetmer","ADEPHI");
		assertTrue(user.getSavedSchools("zakluetmer").contains("ADELPHI"));
	}

	@Test
	public void testAddNewUniversity() {
		assertTrue(user.addNewUniversity("zakluetmer","QUEENS"));
		}
	
	@Test
	public void testAddNewUniversityFail() {
		user.addNewUniversity("zakluetmer","QUEENS");
		assertFalse(user.addNewUniversity("zakluetmer","QUEENS"));
		}

	//@Test
	//public void testRemoveSchool() {
	////	dbController.saveSchool("calseth", "QUEENS");
	//	dbController.removeSchool("calseth", "QUEENS");
	//	ArrayList<String> temp = dbController.getUserSavedSchools("zakluetmer");
	//	assertTrue(!temp.get(0).equals("QUEENS"));
	//}

}

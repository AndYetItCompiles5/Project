package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Project.AdminUI;
import Project.LoginUI;
import Project.UserUI;
import Project.DBController;

public class UserFuncControllerTest {
	private UserUI userUI;
	private AdminUI adminUI;
	private LoginUI loginUI;
	private DBController dbcontroller;
	private ArrayList<String> temp;
	  
	@Before
	public void init(){
		  UserUI userUI = new UserUI();
		  AdminUI adminUI = new AdminUI();
		  LoginUI loginUI = new LoginUI();
		  DBController dbcontroller = new DBController();
		  adminUI.addAccount("Bill",  "Smith", "bsmith", "1234567890", 'u');
		  ArrayList<String> temp = new ArrayList<String>();
	}
	
	//@Test
	//public void testUserFuncController() {
	//	fail("Not yet implemented");
	//}

	//@Test
	//public void testEditUser() {
	//	fail("Not yet implemented");
	//}

	@Test
	public void testRemoveSchool() {
		dbcontroller.saveSchool("zakluetmer", "QUEENS");
		dbcontroller.removeSchool("zakluetmer", "QUEENS");
		ArrayList<String> temp = dbcontroller.getUserSavedSchools("zakluetmer");
		assertFalse(dbcontroller.isSchoolSaved("QUEENS"));
	}

	//@Test
	//public void testSaveSchool() {
	//	fail("Not yet implemented");
	//}


}

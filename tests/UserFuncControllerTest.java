package Project.tests;

import static org.junit.Assert.*;

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
	  
	@Before
	public void init(){
		  UserUI userUI = new UserUI();
		  AdminUI adminUI = new AdminUI();
		  LoginUI loginUI = new LoginUI();
		  DBController dbcontroller = new DBController();
		  adminUI.addAccount("Bill",  "Smith", "bsmith", "1234567890", 'u');
	}
	
	@Test
	public void testUserFuncController() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfirm() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlreadySavedError() {
		fail("Not yet implemented");
	}

}

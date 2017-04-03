package Project.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import Project.*;


public class UserFuncControllerTest {
 private UserUI userUI;
 private AdminUI adminUI;
 private LoginUI loginUI;
 private DBController dbcontroller;
 private UserFuncController uFuncController;
   
 @Before
 public void init(){
    userUI = new UserUI();
    adminUI = new AdminUI();
    loginUI = new LoginUI();
    dbcontroller = new DBController();
    uFuncController = new UserFuncController();
    adminUI.addAccount("Bill",  "Smith", "bsmith", "1234567890", 'u');
    
    //need to remove a school from the user before we can test the saveSchool method
    dbcontroller.removeSchool("zakluetmer", "_TESTSCHOOL");
 }
 
 
 @Test
 public void testUserFuncController() {
  fail("Not yet implemented");
 } 

 
 @Test
 public void testEditUser()
 {
   assertTrue("Account cannot have a blank 'username' field", 
              dbcontroller.editAccount("Zak", "Luetmer", "","password",'u','Y').equals("Missing username, password, or type"));
   assertTrue("Account cannot have a blank 'password' field", 
              dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","",'u','Y').equals("Missing username, password, or type"));
   assertTrue("Account cannot have a blank 'type' field", 
              dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","password",' ','Y').equals("Missing username, password, or type"));
   assertTrue("Account's password was changed succesfully", 
              dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","password1",'u','Y').equals("Edit Successful!"));
   assertTrue("Account's first name was changed succesfully", 
              dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer","password",'u','Y').equals("Edit Successful!"));
   assertTrue("Account's last name was changed succesfully", 
              dbcontroller.editAccount("Zak", "Litmer", "zakluetmer","password",'u','Y').equals("Edit Successful!"));
 } 

 
 @Test
 public void testRemoveSchool() {
  fail("Not yet implemented");
 } 

 @Test
 public void testSaveSchool() 
 {
  assertTrue("The school was successfully saved to the user's list of saved schools.", 
             dbcontroller.saveSchool("zakluetmer","_TESTSCHOOL").equals("School Saved!"));
  assertTrue("The school has laready been saved to the user's profile", 
             dbcontroller.saveSchool("zakluetmer","_TESTSCHOOL").equals("School has already been saved to the user's list!"));
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

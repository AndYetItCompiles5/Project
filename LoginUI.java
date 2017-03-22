package Project;
import java.util.*;
import Project.*;

/**
 * This class passes the login information to the account controller
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class LoginUI
{
  /**
   * Creates an instance of the AccountController
   */
 private AccountController aController;
 
 private String loggedIn;
 
  /**
   * Default constuctor. Initialized the AccountController
   */
  public LoginUI(){
    aController = new AccountController();
  }
  /**
   * Logs the user in with the specified username and password
   * @param username: the Username of the person logging in
   * @param password: the Password of the person logging in
   */
  public String Login(String username, String password)
  {
    String result = aController.login(username,password);
    loggedIn = username;
    return result;
  }
  /**
   * Displays an error if the user enters the wrong login informaion
   * @return error message
   */
  public String wrongLoginInfoError()
  {
    return ("Wrong login information:Please try again");
  }
  /**
   * Displays an error if the account being accessed is deactivated
   * @return error message
   */
  public String deactivateError()
  {
    return ("User deactivated, please contact an administrator"); 
  }
  /**
   * Logs the user out
   * 
   */
  public void logout(){
   aController.logout(); 
  }
  
  public String getLoggedIn(){
	  return loggedIn;
  }
}
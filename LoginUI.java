<<<<<<< HEAD
import java.util.*;
import Project230.*;
=======
package Project;
import java.util.*;
import Project.*;
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb

/**
 * This class passes the login information to the account controller
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

<<<<<<< HEAD
public class LoginUI{
  
  public LoginUI(){
    
=======
public class LoginUI
{
  /**
   * Creates an instance of the AccountController
   */
 private AccountController aController;
 
 /**
  * creates a string for loggedIn
  */
 private String loggedIn;
 
  /**
   * Initialized the AccountController
   */
  public LoginUI(){
    aController = new AccountController();
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  /**
   * Logs the user in with the specified username and password
   * @param username: the Username of the person logging in
   * @param password: the Password of the person logging in
<<<<<<< HEAD
   */
  public void Login(String username, String password)
  {
    
  }
  /**
   * Displays an error if the user enters the wrong login informaion
   * @return error message
   */
  public String wrongLoginInfoError()
  {
   return ("Wrong login information:Please try again");
=======
   * 
   * @return a boolean if an account is logged in
   */
  public boolean Login(String username, String password)
  {
    boolean result = aController.login(username,password);
    loggedIn = username;
    return result;
  }
  /**
   * Displays an error if the user enters the wrong login information
   * @return error message. Cause by wrong log in information
   */
  public String wrongLoginInfoError()
  {
    return ("Wrong login information:Please try again");
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  /**
   * Displays an error if the account being accessed is deactivated
   * @return error message
   */
  public String deactivateError()
  {
<<<<<<< HEAD
   return ("User deactivated, please contact an administrator"); 
  }
}
=======
    return ("User deactivated, please contact an administrator"); 
  }
  /**
   * Logs the user out 
   */
  public void logout(){
   aController.logout(); 
  }
  /**
   * gets loggedIn
   * 
   * @return a string if an account is logged in
   */
  public String getLoggedIn(){
   return loggedIn;
  }
}
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb

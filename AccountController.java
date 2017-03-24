package Project;
import java.util.*;
import Project.*;

/**
 * Gives the user/admin multiple options on what they can do with their accounts or other accounts
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class AccountController{
  /**
   * Who is logged into the system
   */
  private String loggedIn;
  /**
   * creates an instance of a DBController
   */
  private DBController dbController;
  /**
   * default empty constructor
   */
  public AccountController()
  {
    dbController = new DBController();
  }
  
  /**
   * Logs the user in with the specified username and password
   * 
   * @param username: the Username of the person logging in
   * @param password: the Password of the person logging in
   * 
   * @return confirmation that login was successful or error depending on what went wrong
   */
  public String login(String username, String password)
  {

    Account account = dbController.getAccount(username);
    
    String username1 = account.getUsername();
    String password1 = account.getPassword();
    char   type      = account.getType();
    char   status    = account.getStatus();
    
    if(!password1.equals(password) || !username1.equals(username))
    {
      return wrongLoginInfoError();
    }
    
    if(status == 'n')
    {
      return deactivateError();
    }
    
    setLoggedIn(username);
    
    return "Successful login!";
  }
  
  
  /**
   * Logout whoever is logged in
   */
  public void logout()
  {
    loggedIn=null; 
  }
  
  /**
   * Sets the account given as logged in
   * @param username: the account that will be set as logged in
   */
  public void setLoggedIn(String username)
  {
    loggedIn = username;
  }
  
  /**
   * Gives an error if the login info was wrong
   * @return error message
   */
  public String wrongLoginInfoError()
  {
    return ("Wrong login information:Please try again"); 
  }
  /**
   * Gives an error if the account is deactivated
   * @return error message
   */
  public String deactivateError()
  {
    return ("Account is deactivated, please contact an administrator"); 
  }
  /**
   * Edits the user with the given information
   * @param first:the user's first name
   * @param last: the user's last name
   * @param password: the user's password
   * @return Whether the user was successfuly logged in
   */
  public String editUser(String first, String last, String password)
  {
    return dbController.editAccount(first,last,loggedIn,password,'u','y');
  }
  
  /**
   * Gives a message asking the user to confirm their changes
   * @return confirmation message
   */
  public String confirm()
  {
    return ("Are you sure?"); 
  }
  /**
   * Edits any account with the given information
   * @param first:the user's first name
   * @param last: the user's last name
   * @param username: the user's username
   * @param password: the user's password
   * @param type: the type of the account
   * @param status: the status of the account
   * @return whether the account was successfuly edited or an error if not
   */
  public String editAccount(String first, String last, String username, String password, char type, char status)
  {
    return dbController.editAccount(first,last,username,password,type,status); 
  }
  
  /**
   * Gives an error saying the account is already deactivated
   * @return error message
   */
  public String alreadyDeactivatedError()
  {
    return ("User is already deactivated"); 
  }
  
  /**
   * Deactivates a user by setting status to 'n'
   * 
   * @param username the username of the user
   * 
   * @return whether the user was deactivated or if there was an error
   */
  public String deactivateUser(String username)
  {
    return dbController.deactivateUser(username);
  }
  
  /**
   * Returns who is logged on
   * @return the username of the user logged on
   */
  public String getLoggedIn(){
	  return loggedIn;
  }
 }


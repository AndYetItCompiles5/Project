<<<<<<< HEAD
import java.util.*;
import Project230.*;
=======
package Project;
import java.util.*;
import Project.*;
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb

/**
 * Gives the user/admin multiple options on what they can do with their accounts or other accounts
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class AccountController{
<<<<<<< HEAD
  
  public AccountController(){
    
    
  }
  /**
   * Logs the user in with the specified username and password
   * @param username: the Username of the person logging in
   * @param password: the Password of the person logging in
   * @return true if the user was able to login successfully
   */
  public boolean login(String username, String password)
  {
   return false; 
  }
  /**
   * Logs the user out with the specified username and password
   * @param account: the account of the user logging out
   * @return true if the user was able to logout successfully
   */
  public boolean logout(Account account)
  {
   return false; 
  }
  /**
   * Lets the admin add a new account
   * @param account: the account that will be added
   * @return true if the account was added
   */
  public boolean addAccount(Account account)
  {
   return false; 
  }
  /**
   * Logs the person in as an admin
   */
  public void aLogin()
  {
    
  }
  /**
   * Logs the person in as a user
   */
  public void uLogin()
  {
    
  }
  /**
   * Sets the account given as logged in
   * @param account: the account that will be set as logged in
   */
  public void setLoggedIn(Account account)
  {
    
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
=======
  /**
   * Who is logged into the system
   */
  private String loggedIn;
  /**
   * creates an instance of a DBController
   */
  private DBController dbController;
  /**
   * default creates a db object
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
   * @throws IllegalArgumentException if username/password is incorrect
   * @throws IllegalArgumentException if account is deactivated
   * @return boolean for if the user successfully logged in
   */
  public boolean login(String username, String password)
  {

    Account account = dbController.getAccount(username);
    
    String username1 = account.getUsername();
    String password1 = account.getPassword();
    char   type      = account.getType();
    char   status    = account.getStatus();
    
    if(!password1.equals(password) || !username1.equals(username))
    {
     throw new IllegalArgumentException("Username/password Incorrect");
    }
    
    if(status == 'n'|| status=='N')
    {
     throw new IllegalArgumentException("Account is deactivated");
    }
    
    setLoggedIn(username);
    
    return true;
  }
  
  
  /**
   * Logout whoever is logged in
   * @throws NullPointerException if nobody is logged in
   * @return whoever is logged in
   */
  public String logout()
  {
    if(loggedIn==null || loggedIn.equals("")){
     throw new NullPointerException("Nobody is logged in");
    }
    loggedIn="";
    return loggedIn;
  }
  
  /**
   * Sets the account given as logged in
   * @param username: the account that will be set as logged in
   */
  public void setLoggedIn(String username)
  {
    loggedIn = username;
  }
  
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  /**
   * Edits the user with the given information
   * @param first:the user's first name
   * @param last: the user's last name
   * @param password: the user's password
<<<<<<< HEAD
   * @return true if the user was edited
   */
  public boolean editUser(String first, String last, String password)
  {
   return false; 
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
   * @param account: the account being edited
   * @param first:the user's first name
   * @param last: the user's last name
   * @param password: the user's password
   * @param type: the type of the account
   * @param status: the status of the account
   * @return true if the account was edited successfully
   * 
   */
  public boolean editAccount(Account account, String first, String last, String password, char type, boolean status)
  {
    return false; 
  }
  /**
   * Gives a message asking the user to confirm their changes
   * @return confirmation message
   */
  public String confirmationMessage()
  {
   return ("Are you sure?"); 
  }
  /**
   * Gives an error saying the account is already deactivated
   * @return error message
   */
  public String alreadyDeactivatedError()
  {
   return ("User is already deactivated"); 
  }
}
=======
   * @return Whether the user was successfully edited
   */
  public boolean editUser(String first, String last, String password)
  {
    return dbController.editAccount(first,last,loggedIn,password,'u','y');
  }
  
  /**
   * Edits any account with the given information
   * @param first:the user's first name
   * @param last: the user's last name
   * @param username: the user's username
   * @param password: the user's password
   * @param type: the type of the account
   * @param status: the status of the account
   * @return whether the account was successfully edited
   */
  public boolean editAccount(String first, String last, String username, String password, char type, char status)
  {
    return dbController.editAccount(first,last,username,password,type,status); 
  }
  
  /**
   * Deactivates a user by setting status to 'n'
   * 
   * @param username the username of the user
   * 
   * @return whether the user was deactivated or if there was an error
   */
  public boolean deactivateUser(String username)
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

>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb

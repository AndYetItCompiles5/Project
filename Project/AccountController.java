import java.util.*;
import Project230.*;

/**
 * Gives the user/admin multiple options on what they can do with their accounts or other accounts
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class AccountController{
  
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
  /**
   * Edits the user with the given information
   * @param first:the user's first name
   * @param last: the user's last name
   * @param password: the user's password
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
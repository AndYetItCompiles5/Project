package Project;
import java.util.*;
import Project.*;

/**
 * Gives the user/admin multiple options on what they can do with their accounts or other accounts
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
 */

public class AccountController{

  private String loggedIn = null;

  private DBController dbController;
  /**
   * default empty constructor
   */
  public AccountController(){
    loggedIn=null;
    dbController = new DBController();
  }
  
  /**
   * Logs the user in with the specified username and password
   * @param username: the Username of the person logging in
   * @param password: the Password of the person logging in
   * @return true if the user was able to login successfully
   */
  public String login(String username, String password)
  {
   ArrayList user = new ArrayList();
   user = dbController.getUser(username);
   Object loginName = user.get(0);
   String loginName1 = loginName.toString();
   Object loginPass = user.get(1);
   String loginPass1 = loginName.toString();
   Object type = user.get(2);
   char type1 = type.toString().charAt(0);
   Object status = user.get(3);
   char status1 = status.toString().charAt(0);
   if(!loginPass1.equals(password)){
    return wrongLoginInfoError();
   }
   if(status1==('n')){
    return deactivateError();
   }
   setLoggedIn(username);
   return "Successful login!";
   }

  
  /**
   * Logs the user out with the specified username and password
   */
  public void logout()
  {
    loggedIn=null; 
  }

  /**
   * Sets the account given as logged in
   * @param account: the account that will be set as logged in
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
   * @return true if the user was edited
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
   * @param account: the account being edited
   * @param first:the user's first name
   * @param last: the user's last name
   * @param password: the user's password
   * @param type: the type of the account
   * @param status: the status of the account
   * @return true if the account was edited successfully
   * 
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
  
  public String deactivateUser(String first, String last, String username, String password, char type){

   return dbController.deactivateUser(first, last, username, password, type);

  }
}

package Project;
import java.util.*;
import Project.*;

/**
 * Super class Account that can either be an Admin or User
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 3/1/17
 */

public class Account{
  
  /**
   * First name of user
   */
  private String firstName;
  /**
   * Last name of user
   */
  private String lastName;
  /**
   * Username of user
   */
  private String username;
  /**
   * The password for the user
   */
  private String password;
  /**
   * type of the account 'a' for admin, 'u' for user
   */
  private char type;
  /**
   * status of the account (activated or deactivated) 'y' or 'n'
   */
  private char status;
  
  /**
   * Constructor for an Account
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username the username of the Account
   * @param password the passworld of the Account
   * @param type what type of Account this is 'a' for admin, 'u' for user
   */
  public Account(String first, String last, String username, String password, char type)
  {
    this.firstName = first;
    this.lastName = last;
    this.username = username;
    this.password = password;
    this.type = type;
    this.status = 'y';    
  }
  
  /**
   * Gets the first name of the account
   * @return the account's first name
   */
  public String getFirstName()
  {
    return firstName; 
  }
  
  /**
   * Sets the first name of the account
   * @param name: the first name being set
   */
  public void setFirstName(String name)
  {
    this.firstName=name;
  }
  
  /**
   * Gets the last name of the account
   * @return the account's last name
   */
  public String getLastName()
  {
    return lastName;
  }
  
  /**
   * Sets the last name of the account
   * @param name: the last name being set
   */
  public void setLastName(String name)
  {
    this.lastName=name;
  }
  
  /**
   * Gets the password of the account
   * @return the account's password
   */
  public String getPassword()
  {
    return password;
  }
  
  /**
   * Sets the password of the account
   * @param password: the password being set
   */
  public void setPassword(String password)
  {
    this.password=password;
  }
  
  /**
   * Gets the username of the account
   * @return the account's username
   */
  public String getUsername(String username)
  {
    return username; 
  }
  
  /**
   * Gets the type of the account
   * @return the account's type
   */
  public char getType()
  {
    return type; 
  }
  
  /**
   * Sets the type of the account
   * @param type: the type being set
   */
  public void setType(char type)
  {
    this.type=type;
  }
  
  /**
   * Gets the status of the account
   * @return the account's status
   */
  public char getStatus()
  {
    return status; 
  }
  
  /**
   * Sets the status of the account
   * @param status: the type being set
   */
  public void setStatus(char status)
  {
    this.status=status;
  }
}
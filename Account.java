<<<<<<< HEAD
import java.util.*;
import Project230.*;

/**
 * Account
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 2/22/17
=======
package Project;
import java.util.*;
import Project.*;

/**
 * Super class Account that can either be an Admin or User
 * @author Zak Luetmer, TJ Schmitz, Nathan Hansen, Colton Alseth
 * @version 3/1/17
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
 */

public class Account{
  
<<<<<<< HEAD
  //First name of user
  private String firstName;
  
  //Last name of user
  private String lastName;
  
  //Username of user
  private String username;
  
  //The password for the user
  private String password;
  
  //type of the account
  private char type;
  
  //status of the account
  private boolean status;
  
  public Account(String first, String last, String username, String password, char type, boolean status)
=======
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
  
  public Account(){
	  this.firstName = "";
	    this.lastName = "";
	    this.username = "";
	    this.password = "";
	    this.type = 'U';
		this.status='Y';
  }
  
  /**
   * Constructor for an Account
   * @param first the first name of the user
   * @param last the last name of the user
   * @param username the username of the Account
   * @param password the password of the Account
   * @param type what type of Account this is 'a' for admin, 'u' for user
   * @param status if the user/admin is activated or deactivated
   * @throws IllegalArgumentException if type is not 'a' or 'u'
   * @throws IllegalArgumentException if status is not 'Y' or 'n'
   */
  public Account(String first, String last, String username, String password, char type, char status)
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  {
    this.firstName = first;
    this.lastName = last;
    this.username = username;
    this.password = password;
<<<<<<< HEAD
    this.type = type;
    this.status = status;    
=======
    if(type=='a'||type=='A'||type=='U'||type=='u'){
    	this.type = type;
    }
    else{
    	throw new IllegalArgumentException("Type must be A,a,U,or u");
    }
    if(status=='Y'||status=='y'|| status=='N' || status=='n'){
		  this.status=status;
	    }
	else{
	    throw new IllegalArgumentException("Must set status to Y,y,N, or n");
	}  
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Gets the first name of the account
   * @return the account's first name
   */
<<<<<<< HEAD
  
  public String getFirstName()
  {
    return ""; 
  }
=======
  public String getFirstName()
  {
    return firstName; 
  }
  
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  /**
   * Sets the first name of the account
   * @param name: the first name being set
   */
  public void setFirstName(String name)
  {
<<<<<<< HEAD
    
=======
    this.firstName=name;
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Gets the last name of the account
   * @return the account's last name
   */
<<<<<<< HEAD
  
  public String getLastName()
  {
    return "";
=======
  public String getLastName()
  {
    return lastName;
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Sets the last name of the account
   * @param name: the last name being set
   */
<<<<<<< HEAD
  
  public void setLastName(String name)
  {
    
=======
  public void setLastName(String name)
  {
    this.lastName=name;
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Gets the password of the account
   * @return the account's password
   */
<<<<<<< HEAD
  
  public String getPassword()
  {
    return "";
=======
  public String getPassword()
  {
    return password;
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Sets the password of the account
   * @param password: the password being set
   */
<<<<<<< HEAD
  
  public void setPassword(String password)
  {
    
=======
  public void setPassword(String password)
  {
    this.password=password;
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Gets the username of the account
   * @return the account's username
   */
<<<<<<< HEAD
  
  public String getUsername(String username)
  {
    return ""; 
=======
  public String getUsername()
  {
    return username; 
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Gets the type of the account
   * @return the account's type
   */
<<<<<<< HEAD
  
  public char getType()
  {
    return 'a'; 
=======
  public char getType()
  {
    return type; 
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Sets the type of the account
   * @param type: the type being set
<<<<<<< HEAD
   */
  
  public void setType(char type)
  {
    
=======
   * @throws IllegalArgumentException if type != a or u
   */
  public void setType(char type)
  {
    if(type=='u'|| type=='a' ||type=='U'||type=='A'){
    	this.type=type;
    }
    else{
    	throw new IllegalArgumentException("Cannot set type to "+type);
    }
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Gets the status of the account
   * @return the account's status
   */
<<<<<<< HEAD
  
  public boolean getStatus()
  {
    return false; 
=======
  public char getStatus()
  {
    return status; 
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
  
  /**
   * Sets the status of the account
   * @param status: the type being set
   */
<<<<<<< HEAD
  
  public void setStatus(boolean status)
  {
    
=======
  public void setStatus(char status)
  {
	  if(status=='Y'|| type=='y' || type=='N' || type=='n'){
		  this.status=status;
	    }
	    else{
	    	throw new IllegalArgumentException("Cannot set status to "+status);
	    }
>>>>>>> c2f6581e9c9ac05ca7e938b7773cee6b7fa0f2cb
  }
}
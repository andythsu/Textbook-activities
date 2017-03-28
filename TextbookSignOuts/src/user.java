


public class user{
  String userName; //declare variables
  String password;
  boolean teacherStatus;
  boolean currentUser;
  public user (String newUserName, String newPassword, boolean newTeacherStatus) //constructor
  {
    userName=newUserName; //set variables
    password=newPassword;
    teacherStatus=newTeacherStatus;
  }
  public String getUserName() //get user name method
  {
    return userName; //return user name
  }
  public void setUserName(String nUserName) //set user name method
  {
    userName=nUserName; //set user name
  }
  public String getPassword() //get password method
  {
    return password; //return password
  }
  public void setPassword(String nPassword) //set password method
  {
    password=nPassword; //set password
  }
  public boolean getTeacherStatus() //get teacher method
  {
    return teacherStatus; //return teacher
  }
  public void setTeacherStatus(boolean nTeacherStatus) //set teacher method
  {
    teacherStatus=nTeacherStatus; //set teacher status
  }
  public boolean getCurrentStatus() //get current user method
  {
    return currentUser; //return current user
  }
  public void setCurrentStatus(boolean nCurrentStatus) //set current user method
  {
    currentUser=nCurrentStatus; //set user
  }
}

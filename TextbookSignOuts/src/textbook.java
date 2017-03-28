


/*
 * abstract class
 */

public abstract class textbook{
  int number; //declare number
  String condition,department,course; //declare textbook condition, department, and course
  public abstract int getNumber(); //get number abstract method
  public abstract void setNumber(int newnumber); //set number abstract method
  public abstract String getCondition(); //get condition abstract method
  public abstract void setCondition(String newcondition); //set condition abstract method
  public abstract String getCourse(); //get course abstract method
  public abstract void setCourse(String newcourse); //set course abstract method
  public abstract String getTeacher(); //get teacher abstract method
  public abstract String getUser(); //get user abstract method
  public abstract void setUser(String username); //set user abstract method
  public abstract void setTeacher(String teacher); //set teacher abstract method
  public abstract void setBorrowed(boolean isBorrowed);//set borrowed abstract method
  public abstract boolean getBorrowed(); //get borrowed abstract method
  
  
}
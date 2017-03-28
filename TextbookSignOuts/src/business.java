


import java.util.Comparator;

public class business extends textbook{ //business department
  String department; //declare variables
  String user;
  int studentnumber;
  String teacher;
  boolean isBorrowed = false;
  public business(int number, String condition, String course){ //constructor
    this.number = number; //set the variables
    this.condition = condition; 
    this.course = course;
    department = "Business";
  }
  public boolean getBorrowed(){ //get borrowed method
  return isBorrowed; //return status
 }
  public void setBorrowed(boolean isBorrowed){ //set borrowed method
   this.isBorrowed = isBorrowed; //overwrite borrowed
  }
   public void setUser(String nUser){ //set user
    this.user = nUser; //overwrite user
  } 

  public void setTeacher(String teacher){ //set teacher
    this.teacher = teacher; //overwrite teacher
  }
  
    public  String getTeacher(){ //get teacher
    return teacher; //return current teacher
  }

  public String getUser(){ //get user
    return user; //return current user
  }
  
  public  int getNumber(){ //get number
    return number; //return current number
  }
  public  void setNumber(int newnumber){ //set number
  }
  public  String getCondition(){
    return condition;
  }
  public  void setCondition(String newcondition){ //set condition
   this.condition = newcondition; //add condition
  }
  public  String getDepartment(){ //get department
    return department; //return department
  }
  
  public  String getCourse(){ //get course
    return course; //return course
  }
  public  void setCourse(String newcourse){
  }
  
  /* sorts arraylist */
  public static Comparator<business> CourseComparator = new Comparator<business>() { //compare two courses

  public int compare(business b1, business b2) { //compare two business objects
     String course1 = b1.getCourse().toUpperCase(); //get course 1
     String course2 = b2.getCourse().toUpperCase(); //get course 2

     //ascending order
     return course1.compareTo(course2); //return course in ascending order

     
     }};
} 

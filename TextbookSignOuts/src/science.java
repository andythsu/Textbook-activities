


import java.util.Comparator;

public class science extends textbook{ //science class
  String department; //declare all variables
  String user;
  int studentnumber;
  String teacher;
  boolean isBorrowed = false;
  public science(int number, String condition, String course){ //constructor
    this.number = number;
    this.condition = condition;
    this.course = course;
    department = "Science";
  }
  public boolean getBorrowed(){ //get borrow method
  return isBorrowed; //return borrow status
 }
  public void setBorrowed(boolean isBorrowed){ //set borrowed method
   this.isBorrowed = isBorrowed; //set borrowed
  }
   public void setUser(String nUser){ //set user method
    this.user = nUser; //set user
  }

  public void setTeacher(String teacher){ //set teacher method
    this.teacher = teacher; //set teacher
  }
  
    public  String getTeacher(){ //get teacher method
    return teacher; //return teacher
  }

  public String getUser(){ //get user method
    return user; //return user
  }

  public  int getNumber(){ //get number method
    return number; //return number
  }
  public  void setNumber(int newnumber){ //set number method
  }
  public  String getCondition(){ // get condition method
    return condition; //return condition
  }
  public  void setCondition(String newcondition){ //set condition method
   this.condition = newcondition; //set condition
  }
  public  String getDepartment(){ //get department method
    return department; //return department
  }
  
  public  String getCourse(){ //get course method
    return course; //return course
  }
  public  void setCourse(String newcourse){ //set course method
  }
   
  public static Comparator<science> CourseComparator = new Comparator<science>() { //comparator

  public int compare(science s1, science s2) { //compare
     String course1 = s1.getCourse().toUpperCase(); //compare science course 1
     String course2 = s2.getCourse().toUpperCase(); //compare science course 2

     //ascending order
     return course1.compareTo(course2); //return
     }};
} 

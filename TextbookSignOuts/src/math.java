


import java.util.Comparator;

public class math extends textbook{ //math class
  String department; //declare all variables
  String user;
  int studentnumber;
  String teacher;
  boolean isBorrowed = false;
  public math(int number, String condition, String course){ //constructor
    this.number = number; //set variables
    this.condition = condition;
    this.course = course;
    department = "Math";
  }
  public boolean getBorrowed(){ //get borrowed method
  return isBorrowed; //return borrowed
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
    return teacher; //get teacher
  }

  public String getUser(){ //get user method
    return user; //return user
  }
  
  public  int getNumber(){ //get number method
    return number; //return number
  }
  public  void setNumber(int newnumber){ //set number method
  }
  public  String getCondition(){ //get condition method
    return condition; //get condition
  }
  public  void setCondition(String newcondition){ //set condition method
   this.condition = newcondition; // set condition
  }
  public  String getDepartment(){  //get department method
    return department; //return department
  }
  
  public  String getCourse(){ //get course method
    return course; //return course
  }
  public  void setCourse(String newcourse){ //set course method
  }
  
  public static Comparator<math> CourseComparator = new Comparator<math>() { //comparator method

  public int compare(math m1, math m2) { 
     String course1 = m1.getCourse().toUpperCase(); //compare math course 1
     String course2 = m2.getCourse().toUpperCase(); //compare math course 2

     //ascending order
     return course1.compareTo(course2); //return 

     //descending order
     //return StudentName2.compareTo(StudentName1);
     }};
} 

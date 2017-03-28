


import java.util.Comparator;

public class english extends textbook{ //english class
	String department; //declare all variables
	String user;
	int studentnumber;
	String teacher;
	boolean isBorrowed = false;
	public english(int number, String condition, String course){ //constructor
		this.number = number; //set the variables
		this.condition = condition;
		this.course = course;
		department = "English";
	}
	public boolean getBorrowed(){ //get borrowed
		return isBorrowed; //return status
	}
	public void setBorrowed(boolean isBorrowed){ //set borrowed
		this.isBorrowed = isBorrowed; //return borrowed
	}
	public void setUser(String nUser){ //set user method
		this.user = nUser; //set user
	}

	public void setTeacher(String teacher){ //set teacher method
		this.teacher = teacher; //set teacher
	}

	public  String getTeacher(){ //get teacher method
		return teacher; //return current teacher
	}
	
	public String getUser(){ //get user method
		return user; //return user
	}

	public  int getNumber(){ //get number method
		return number; //return textbook number
	}
	public  void setNumber(int newnumber){ //set number method
	}
	public  String getCondition(){ //get textbook condition method
		return condition; //return condition
	}
	public  void setCondition(String newcondition){ //set textbook condition method
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

	public static Comparator<english> CourseComparator = new Comparator<english>() { //use comparator to sort arraylist

		public int compare(english e1, english e2) { //compare method 
			String course1 = e1.getCourse().toUpperCase(); //compare course 1
			String course2 = e2.getCourse().toUpperCase(); //compare course 2

			//ascending order
			return course1.compareTo(course2); //return


		}};
} 

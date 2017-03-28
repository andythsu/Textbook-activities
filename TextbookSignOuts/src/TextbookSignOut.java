


/* ISP
 * This is a program that allows teaching staff to store data about textbooks easily without the inconvenient use of paper.
 * Daniel Qi, Andy Su, Alan Tong
 * Wednesday, May 25, 2016
 */
import java.util.*;
import java.awt.*;                                                 //GUI package
import java.awt.event.*;                                           // action listener
import javax.swing.*;
import javax.imageio.*;
import javax.swing.border.*;
import java.io.*;
import java.io.File;
import java.io.IOException;

public class TextbookSignOut extends JFrame implements ActionListener{

	static ArrayList<math> Math = new ArrayList<math>(); //put math class to arraylist
	static ArrayList<science> Science = new ArrayList<science>(); //put science class to arraylist
	static ArrayList<business> Business = new ArrayList<business>(); //put business class to arraylist
	static ArrayList<english> English = new ArrayList<english>(); //put english class to arraylist
	static ArrayList<history> History = new ArrayList<history>(); //put history class to arraylist
	static ArrayList<user> userInfo = new ArrayList<user>(); //put user class to arraylist


	String condList[] = new String[]{"Perfect", "Good", "Okay", "Bad"};                             //combo box options
	String deptList[] = new String[]{"Business", "English", "History", "Math", "Science"};
	static String currentUser;

	JFrame mainFrame = new JFrame("Textbook Sign-outs PRO V1.0");                           //frames
	JFrame signOutFrame = new JFrame();
	JFrame searchFrame = new JFrame();
	JFrame returnFrame = new JFrame();
	JFrame stuRegisterFrame = new JFrame();
	JFrame teachRegisterFrame = new JFrame();
	JFrame showSearchFrame = new JFrame();

	JLabel mathLabel = new JLabel ("math");                                     //labels for subjects
	JLabel englishLabel = new JLabel ("english");
	JLabel scienceLabel = new JLabel ("science");
	JLabel historyLabel = new JLabel ("history");
	JLabel businessLabel = new JLabel ("business");

	JTabbedPane tabP = new JTabbedPane();                            //tabbed pane initializing

	JPanel mainPan = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel addingPan = new JPanel();
	JPanel srPan = new JPanel();
	JPanel sdPan = new JPanel();
	JPanel SignedOutPan = new JPanel();
	JPanel SignedOutPan1 = new JPanel();
	JPanel SignedOutButtonsPan = new JPanel();                     //initializing panels
	JPanel userPan = new JPanel();
	JPanel userButtonPan = new JPanel();
	JPanel welcomePan = new JPanel();
	JPanel registerStuPanel = new JPanel();
	JPanel registerStuButtonsPanel = new JPanel();
	JPanel registerTeachPanel = new JPanel();
	JPanel registerTeachButtonsPanel = new JPanel();

	JButton signOutButton = new JButton("Sign Out");                  //initializing buttons
	JButton searchButton = new JButton("");
	JButton returnButton = new JButton("Return");
	JButton deleteButton = new JButton("");
	JButton addButton = new JButton("Add");
	JButton clearButton = new JButton("Clear Fields");
	JButton doneButton = new JButton("Sign Out");
	JButton cancelButton = new JButton("Cancel");
	JButton confirmSearchButton = new JButton("Search");
	JButton cancelSearchButton = new JButton("Cancel");
	JButton confirmReturn = new JButton("return");
	JButton cancelReturn = new JButton("Cancel");
	JButton lostButton = new JButton("Lost");
	JButton newTeacherButton = new JButton("New Teacher");
	JButton newStudentButton = new JButton("New Student");
	JButton deleteUserButton = new JButton("Delete User");
	JButton confirmTeachRegisterButton = new JButton("Register New Teacher");
	JButton returnButton1 = new JButton("Return");
	JButton confirmStuRegisterButton = new JButton("Register New Student");
	JButton returnButton2 = new JButton("Return");

	JLabel deptLabel = new JLabel("Department: ");                            //initializing labels
	JLabel condLabel = new JLabel("Condition: ");
	JLabel numLabel = new JLabel("Textbook Number: ");
	//JLabel studNumLabel = new JLabel("Student Number: ");
	//JLabel gradeLabel = new JLabel("Grade: ");
	JLabel condLabel2 = new JLabel("Condition: ");
	JLabel teachLabel = new JLabel("Teacher Last Name: ");
	JLabel courseLabel = new JLabel("Subject: ");
	JLabel searchLabel = new JLabel("      format: department course                ");
	JLabel returnSubjectLabel = new JLabel("Subject");
	JLabel returnNumberLabel = new JLabel("Number");
	JLabel infoLabel = new JLabel();
	JLabel infoLabel2 = new JLabel();
	JLabel infoLabel3 = new JLabel();
	JLabel stuRegisterLabel = new JLabel("");
	JLabel teachRegisterLabel = new JLabel("");
	JLabel userNameLabel = new JLabel("  Username: ");
	JLabel passwordLabel = new JLabel("  Password: ");
	JLabel newUserNameLabel = new JLabel(" Username:");
	JLabel newPasswordLabel = new JLabel(" Password:");
	JLabel newPasswordLabel2 = new JLabel(" Confirm Password:  ");
	JLabel userNameLabelT = new JLabel("  Username: ");
	JLabel passwordLabelT = new JLabel("  Password: ");
	JLabel newUserNameLabelT = new JLabel(" Username:");
	JLabel newPasswordLabelT = new JLabel(" Password:");
	JLabel newPasswordLabel2T = new JLabel(" Confirm Password:  ");

	JTextField searchTF = new JTextField(10);                                 //initializing text fields
	//JTextField deptTF = new JTextField(10);
	JTextField courseTF = new JTextField(10);
	JTextField numTF = new JTextField(10);
	//JTextField studNumTF = new JTextField(10);
	//JTextField gradeTF = new JTextField(10);
	JTextField teachTF = new JTextField(10);    //could be drop down
	JTextField searchCourseTF = new JTextField(14);
	JTextField returnSubjectTF = new JTextField();
	JTextField returnNumberTF = new JTextField();
	JTextField newStuUserNameTF = new JTextField(10);
	JPasswordField newStuPasswordTF = new JPasswordField(10);
	JPasswordField newStuPasswordTF2 = new JPasswordField(10);
	JTextField newTeachUserNameTF = new JTextField(10);
	JPasswordField newTeachPasswordTF = new JPasswordField(10);
	JPasswordField newTeachPasswordTF2 = new JPasswordField(10);

	JComboBox condComboBox1 = new JComboBox(condList);                     //initialize combo boxes
	JComboBox condComboBox2 = new JComboBox(condList);
	JComboBox deptComboBox = new JComboBox(deptList);

	//GridLayout mainLayout = new GridLayout(1,0);
	GridLayout rightLayout = new GridLayout(2,1);                        //initialize layouts
	GridLayout addingLayout = new GridLayout(5,2);
	GridLayout signOutLayout = new GridLayout(5,2);
	GridLayout buttonsLayout = new GridLayout(2,1);
	GridLayout userButtonsLayout = new GridLayout(3,1);
	GridLayout welcomeLayout = new GridLayout(3,1);
	GridLayout infoLayout = new GridLayout(2,1);
	GridLayout registerLayout = new GridLayout(3,2);
	FlowLayout flowLayout = new FlowLayout();

	static DefaultListModel<String> listModel = new DefaultListModel<String>();       //initalizing Jlist for available textbooks
	JList<String> list = new JList<String> (listModel);
	JScrollPane listScroll = new JScrollPane(list);

	DefaultListModel<String> SignedOutListModel = new DefaultListModel<String>();     //initializing Jlist for signed out textbooks
	JList<String> SignedOutList = new JList<String>(SignedOutListModel);
	JScrollPane SignedOutListScroll = new JScrollPane(SignedOutList);

	DefaultListModel<String> userListModel = new DefaultListModel<String>();          //initializing Jlist for list of users
	JList<String> userList = new JList<String> (userListModel);
	JScrollPane userListScroll = new JScrollPane(userList);


	static Color Gray=new Color(192,192,192);
	static Color LightSlateGray=new Color(119,136,153);                  //declaring Colours
	static Color SlateGray=new Color(112,128,144);

	static boolean userNameTaken=false;                                 //delaring boolean for if userName is taken

	//-------------------------------------------GUI Constructor----------------------------------------------------------//
	public TextbookSignOut(){

		loadUserList();                                                  //load the users and add them
		addUsers();

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        //set if click on exit program terminates

		mainFrame.addWindowListener(new WindowAdapter(){ //add window listener
			@Override
			public void windowClosing(WindowEvent we){ //if window is closed
				save(); //save
				saveReturn(); //save return 
				saveUserList(); //save user list
			}
		});

		signOutFrame.setUndecorated(true);                //taking away default borders
		searchFrame.setUndecorated(true);
		returnFrame.setUndecorated(true);
		stuRegisterFrame.setUndecorated(true);
		teachRegisterFrame.setUndecorated(true);

		signOutFrame.getRootPane().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,SlateGray,LightSlateGray),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));    //making custom borders
		searchFrame.getRootPane().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,SlateGray,LightSlateGray),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		returnFrame.getRootPane().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,SlateGray,LightSlateGray),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		stuRegisterFrame.getRootPane().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,SlateGray,LightSlateGray),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		teachRegisterFrame.getRootPane().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,SlateGray,LightSlateGray),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));


		newStuPasswordTF.setEchoChar('*');       //hiding passwords
		newStuPasswordTF2.setEchoChar('*');
		newTeachPasswordTF.setEchoChar('*');
		newTeachPasswordTF2.setEchoChar('*');


		mainFrame.setResizable(false);         //all frames are not resizable
		signOutFrame.setResizable(false);
		searchFrame.setResizable(false);
		stuRegisterFrame.setResizable(false);
		teachRegisterFrame.setResizable(false);

		mainFrame.setVisible(true);               //main frame becomes visible

		mainPan.setLayout(new GridBagLayout());          //layouts
		addingPan.setLayout(addingLayout);
		signOutFrame.setLayout(signOutLayout);
		pan2.setLayout(rightLayout);
		sdPan.setLayout(buttonsLayout);
		searchFrame.setLayout(flowLayout);
		returnFrame.getContentPane().setLayout(null);
		userButtonPan.setLayout(userButtonsLayout);
		SignedOutButtonsPan.setLayout(buttonsLayout);
		SignedOutPan.setLayout(new GridBagLayout());
		welcomePan.setLayout(welcomeLayout);
		registerStuButtonsPanel.setLayout(buttonsLayout);
		registerStuPanel.setLayout(registerLayout);
		stuRegisterFrame.setLayout(new GridBagLayout());
		registerTeachButtonsPanel.setLayout(buttonsLayout);
		registerTeachPanel.setLayout(registerLayout);
		teachRegisterFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		list.setFixedCellHeight(30);                              //seting dimensions for available list 
		list.setVisibleRowCount(5);
		list.setFixedCellWidth(300);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //only one can be selected at a time

		SignedOutList.setFixedCellHeight(30);                              //seting dimensions for signed out list
		SignedOutList.setVisibleRowCount(5);
		SignedOutList.setFixedCellWidth(300);
		SignedOutList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		userList.setFixedCellHeight(30);                              //seting dimensions for user list 
		userList.setVisibleRowCount(5);
		userList.setFixedCellWidth(300);
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		pan1.add(listScroll, BorderLayout.CENTER);                    //adding Jlists
		SignedOutPan1.add(SignedOutListScroll,BorderLayout.CENTER);
		userPan.add(userListScroll,BorderLayout.CENTER);

		stuRegisterFrame.setBackground(Color.WHITE);                //make background white for frames
		teachRegisterFrame.setBackground(Color.WHITE);

		try {
			//Image img = ImageIO.read(getClass().getResource("search.png"));
			//Image img = ImageIO.read(getClass().getResource("search.png"));
			Image img=new ImageIcon("search.png").getImage();                //image for search button
			searchButton.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		}
		try {
			Image img=new ImageIcon("trash.jpg").getImage();                 //image for delete button
			deleteButton.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		}

		searchButton.setBackground(Color.WHITE);                    //make background white for buttons
		returnButton.setBackground(Color.WHITE);
		lostButton.setBackground(Color.WHITE);
		signOutButton.setBackground(Color.WHITE);
		deleteButton.setBackground(Color.WHITE);

		signOutButton.setToolTipText("Sign out selected textbook");  //tool tips for when cursor hovers
		returnButton.setToolTipText("Return selected textbook");
		searchButton.setToolTipText("Search for remaining textbooks");
		deleteButton.setToolTipText("Delete selected textbook from files");
		lostButton.setToolTipText("The textbook is lost");
		signOutButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		confirmStuRegisterButton.setToolTipText("Confirm registering new student user");
		returnButton1.setToolTipText("Return to textbook signout");
		confirmTeachRegisterButton.setToolTipText("Confirm registering new teacher/admin user");
		returnButton2.setToolTipText("Return to textbook signout");

		try {
			Image img = ImageIO.read(getClass().getResource("stuRegister.png"));
			stuRegisterLabel.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		}try {
			Image img = ImageIO.read(getClass().getResource("teachRegister.png"));
			teachRegisterLabel.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		}

		pan2.add(srPan);                            //adding onto pan2
		pan2.add(sdPan);

		mainPan.add(pan1, c);                         //adding onto mainPan
		mainPan.add(pan2);

		srPan.add(signOutButton);                      //adding onto sr- and sdPan
		sdPan.add(searchButton);
		sdPan.add(deleteButton);

		SignedOutPan.add(SignedOutPan1);                //adding onto SignedOutPan
		SignedOutPan1.add(SignedOutButtonsPan);
		SignedOutButtonsPan.add(returnButton);
		SignedOutButtonsPan.add(lostButton);

		addingPan.add(deptLabel);                        //adding onto  addingPan
		addingPan.add(deptComboBox);
		addingPan.add(courseLabel);
		addingPan.add(courseTF);
		addingPan.add(condLabel);
		addingPan.add(condComboBox1);
		addingPan.add(numLabel);
		addingPan.add(numTF);
		addingPan.add(addButton);
		addingPan.add(clearButton);

		//signOutFrame.add(studNumLabel);              //adding onto signOutFrame
		//signOutFrame.add(studNumTF);
		//signOutFrame.add(gradeLabel);
		//signOutFrame.add(gradeTF);
		signOutFrame.add(condLabel2);
		signOutFrame.add(condComboBox2);
		signOutFrame.add(teachLabel);
		signOutFrame.add(teachTF);
		signOutFrame.add(doneButton);
		signOutFrame.add(cancelButton);

		searchFrame.add(searchLabel);                           //adding onto searchFrame
		searchFrame.add(searchCourseTF);
		searchFrame.add(confirmSearchButton);
		searchFrame.add(cancelSearchButton);

		userButtonPan.add(newTeacherButton);                  //adding onto userButtonPan
		userButtonPan.add(newStudentButton);
		userButtonPan.add(deleteUserButton);
		userPan.add(userButtonPan);

		welcomePan.add(infoLabel);                           //adding onto welcomePan
		welcomePan.add(infoLabel2);
		welcomePan.add(infoLabel3);

		tabP.addTab("Welcome", welcomePan);                   //adding tabs to main frame
		tabP.addTab("Available", mainPan);
		tabP.addTab("Signed Out" , SignedOutPan);
		tabP.addTab("Add", addingPan);
		tabP.addTab("User List", userPan);

		registerStuPanel.add(newUserNameLabel);
		registerStuPanel.add(newStuUserNameTF);
		registerStuPanel.add(newPasswordLabel);
		registerStuPanel.add(newStuPasswordTF);
		registerStuPanel.add(newPasswordLabel2);
		registerStuPanel.add(newStuPasswordTF2);
		registerStuButtonsPanel.add(confirmStuRegisterButton);
		registerStuButtonsPanel.add(returnButton1);
		stuRegisterFrame.add(stuRegisterLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.gridwidth = 1;
		c.gridy = 1;
		stuRegisterFrame.add(registerStuPanel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.gridwidth = 3;
		c.gridy = 2;
		stuRegisterFrame.add(registerStuButtonsPanel, c);

		registerTeachPanel.add(newUserNameLabelT);
		registerTeachPanel.add(newTeachUserNameTF);
		registerTeachPanel.add(newPasswordLabelT);
		registerTeachPanel.add(newTeachPasswordTF);
		registerTeachPanel.add(newPasswordLabel2T);
		registerTeachPanel.add(newTeachPasswordTF2);
		registerTeachButtonsPanel.add(confirmTeachRegisterButton);
		registerTeachButtonsPanel.add(returnButton2);
		c.gridy = 0;
		teachRegisterFrame.add(teachRegisterLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.gridwidth = 1;
		c.gridy = 1;
		teachRegisterFrame.add(registerTeachPanel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.gridwidth = 3;
		c.gridy = 2;
		teachRegisterFrame.add(registerTeachButtonsPanel, c);


		mainFrame.add(tabP);                                    //size adjusting of frames
		mainFrame.pack();
		signOutFrame.pack();
		//searchFrame.pack();
		searchFrame.setSize(200, 90);
		returnFrame.setBounds(100, 100, 245, 150);

		mainFrame.setLocation(100, 100);                         //setting location for frames
		signOutFrame.setLocation(150, 200);
		searchFrame.setLocation(200, 250);
		returnFrame.setLocation(200,250);


		returnSubjectLabel.setFont(new Font("Calibri", Font.BOLD, 18));            //adjusting text (font, boundaries, size)
		returnSubjectLabel.setBounds(10, 10, 154, 23);
		returnFrame.getContentPane().add(returnSubjectLabel);
		returnSubjectTF.setBounds(10, 30, 223, 21);
		returnFrame.getContentPane().add(returnSubjectTF);
		returnSubjectTF.setColumns(10);
		confirmReturn.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		confirmReturn.setBounds(10, 105, 87, 23);
		returnFrame.getContentPane().add(confirmReturn);
		cancelReturn.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		cancelReturn.setBounds(131, 105, 87, 23);
		returnFrame.getContentPane().add(cancelReturn);
		returnNumberLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		returnNumberLabel.setBounds(10, 56, 154, 23);
		returnFrame.getContentPane().add(returnNumberLabel);
		returnNumberTF.setColumns(10);
		returnNumberTF.setBounds(10, 74, 223, 21);
		returnFrame.getContentPane().add(returnNumberTF);


		signOutButton.addActionListener(this);                     //action listeners
		searchButton.addActionListener(this);
		confirmSearchButton.addActionListener(this);
		returnButton.addActionListener(this);
		deleteButton.addActionListener(this);
		addButton.addActionListener(this);
		clearButton.addActionListener(this);
		doneButton.addActionListener(this);
		cancelButton.addActionListener(this);
		cancelSearchButton.addActionListener(this);
		confirmReturn.addActionListener(this);
		cancelReturn.addActionListener(this);
		lostButton.addActionListener(this);
		newTeacherButton.addActionListener(this);
		newStudentButton.addActionListener(this);
		deleteUserButton.addActionListener(this);
		confirmStuRegisterButton.addActionListener(this);
		returnButton1.addActionListener(this);
		confirmTeachRegisterButton.addActionListener(this);
		returnButton2.addActionListener(this);

		stuRegisterFrame.pack();                               //packing student and teacher registery frames
		teachRegisterFrame.pack();

		teachRegisterFrame.setLocation(400,400);              //setting location for these frames
		stuRegisterFrame.setLocation(400,400);

		for (int i=0;i<userInfo.size();i++)
		{
			if ((userInfo.get(i)).getCurrentStatus()==true)
			{
				currentUser = (userInfo.get(i)).getUserName();
				infoLabel.setText("     Welcome "+currentUser+" to the textbook sign out program");
				if ((userInfo.get(i)).getTeacherStatus()==true){
					infoLabel2.setText("     You are currently a teacher");                   //label changes depending if a teacher or student is logged in
					signOutButton.setEnabled(false);
					tabP.setEnabledAt(2, false);
				}
				else{
					infoLabel2.setText("     You are currently a student");
					deleteButton.setEnabled(false);
					
					tabP.setEnabledAt(3, false);
					tabP.setEnabledAt(4, false);
				}
			}
		}
		infoLabel3.setText("     Feel free to check out textbooks as you wish");

		load();
		loadReturn();
		sortuserList(0,userListModel.size()-1);
	}

	//---------------------------------------------Action Responses-------------------------------------------------------//
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == signOutButton){ //if signout button is pressed
			String item = list.getSelectedValue(); //get item and store it 
			if (item == null){ //detects if an item is selected from the list
				JOptionPane.showMessageDialog(mainFrame, "you must select an item"); //show message if no item is selected
			}else{

				searchFrame.setVisible(false); //close search frame
				signOutFrame.setVisible(true); //show signout frame

			}
		}

		if(event.getSource() == cancelButton){ //if cancel button is pressed
			signOutFrame.setVisible(false); //close signout frame
			//gradeTF.setText(""); //reset textfields
			condComboBox2.setSelectedIndex(0);
			teachTF.setText("");
		}
		if(event.getSource() == searchButton){ //if search button is pressed
			/* sort the arraylists here so we can perform binary search */
			Collections.sort(Business,business.CourseComparator);
			Collections.sort(English,english.CourseComparator);
			Collections.sort(History,history.CourseComparator);
			Collections.sort(Math,math.CourseComparator);
			Collections.sort(Science,science.CourseComparator);

			signOutFrame.setVisible(false); //close signout frame
			searchFrame.setVisible(true); //show search frame

		}
		if(event.getSource() == cancelSearchButton){ //if cancel search button is pressed
			searchFrame.setVisible(false); //search frame is closed
			searchCourseTF.setText(""); //reset textfield
		}
		if (event.getSource() == addButton){ //if add button is pressed
			try{
				int textbooknumber = Integer.parseInt(numTF.getText()); //check textbook number
				if (textbooknumber <= 0){ //if textbook number is less or equal to 0
					JOptionPane.showMessageDialog(mainFrame, "enter a valid textbook number"); //show message
				}else{ //else 
					addToDisplay((String)deptComboBox.getSelectedItem(), courseTF.getText(), (String)condComboBox1.getSelectedItem(), textbooknumber); //add to display
				}
			}catch(NumberFormatException e){ //catch number format
				JOptionPane.showMessageDialog(mainFrame, "enter a valid textbook number"); //show message
			}


		}
		if (event.getSource() == clearButton){ //if clear button is pressed
			deptComboBox.setSelectedIndex(0); //reset all textfields
			courseTF.setText(null);
			numTF.setText(null);
			condComboBox1.setSelectedIndex(0);

		}
		if (event.getSource() == returnButton){ //if return button is pressed
			//returnFrame.setVisible(true); 
			String item = SignedOutList.getSelectedValue(); //get selected item

			if (item == null){ //if no item is selected
				JOptionPane.showMessageDialog(mainFrame, "choose a textbook to return"); //show message
			}else{
				String[] selected = item.split(" "); //split the string 
				if (selected[0].equalsIgnoreCase("Math")){ //the first string contains subject
					int i = findIndex(selected[0],item); //find the item in the arraylist
					Math.get(i).setUser(""); //reset the arraylist variables
					//   Math.get(i).setID(0);
					Math.get(i).setCondition((selected[2]));
					Math.get(i).setTeacher("");
					Math.get(i).setBorrowed(false);

				}
				if (selected[0].equalsIgnoreCase("Science")){ //if department is science
					int i = findIndex(selected[0],item); //find the index in science arraylist
					Science.get(i).setUser(""); //reset the arraylist variables
					//   Science.get(i).setID(0);
					Science.get(i).setCondition((selected[2]));
					Science.get(i).setTeacher("");
					Science.get(i).setBorrowed(false);
				}
				if (selected[0].equalsIgnoreCase("History")){ //if department is history
					int i = findIndex(selected[0],item); //find the index in history arraylist
					History.get(i).setUser(""); //reset the arraylist variables
					//   History.get(i).setID(0);
					History.get(i).setCondition((selected[2]));
					History.get(i).setTeacher("");
					History.get(i).setBorrowed(false);
				}
				if (selected[0].equalsIgnoreCase("English")){ //if department is english
					int i = findIndex(selected[0],item); //find the idnex in english arraylist
					English.get(i).setUser(""); //reset the arraylist variables
					//   English.get(i).setID(0);
					English.get(i).setCondition((selected[2]));
					English.get(i).setTeacher("");
					English.get(i).setBorrowed(false);
				}
				if (selected[0].equalsIgnoreCase("Business")){ // if department is business
					int i = findIndex(selected[0],item); //find the index in business arraylist
					Business.get(i).setUser(""); //reset all variables
					//    Business.get(i).setID(0);
					Business.get(i).setCondition((selected[2]));
					Business.get(i).setTeacher("");
					Business.get(i).setBorrowed(false);
				}


				listModel.addElement(SignedOutList.getSelectedValue()); //add the item back to list
				sortList(0,listModel.size()-1); //sort list using quicksort
				SignedOutListModel.remove(SignedOutList.getSelectedIndex()); //remove the item from signout list
			}

		}
		if (event.getSource() == confirmSearchButton){ //if confirm search button is presseed
			if (searchCourseTF.getText().contains(" ")){ //check the format
				String[] s = searchCourseTF.getText().split(" "); //get the text and store it to string array
				if (s[0].equalsIgnoreCase("math") || 
						s[0].equalsIgnoreCase("english") || 
						s[0].equalsIgnoreCase("business") || 
						s[0].equalsIgnoreCase("history") || 
						s[0].equalsIgnoreCase("science")){
					showsearch(s[0], s[1]); //s[0] contains department and s[1] contains course
					searchCourseTF.setText(null); //reset textfields
					searchFrame.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(mainFrame, s[0] + " is not a valid department"); //output error message if department is wrong
				}

			}else{
				JOptionPane.showMessageDialog(mainFrame,"Wrong format");  //output error message is format is wrong
			}
		}

		if (event.getSource() == doneButton){ //if done button is pressed

			String item = list.getSelectedValue(); //get the selected item
			String[] selected = item.split(" "); //split the string


			//  int nID=Integer.parseInt(studNumTF.getText()); //store input from textfield to variables
			String nCondition=(String)condComboBox2.getSelectedItem();
			String nTeacher=teachTF.getText();
			borrowTextBook(selected[0], item, currentUser,nCondition, nTeacher);

			JOptionPane.showMessageDialog(mainFrame, "textbook signed out to " + currentUser); //show message
			//studNumTF.setText(null); //reset textfields
			//gradeTF.setText(null);
			condComboBox2.setSelectedIndex(0);
			teachTF.setText(null);

			signOutFrame.setVisible(false); //close frame

			SignedOutListModel.addElement(list.getSelectedValue()); //add element to signout list
			sortsignoutList(0,SignedOutListModel.size()-1); //sort signout list using quicksort
			listModel.remove(list.getSelectedIndex()); //remove the item from list


		}

		if (event.getSource() == deleteButton){ //if delete button is pressed

			String item = list.getSelectedValue(); //get selected item in the list
			if (item == null){ //checks if user selects an item
				JOptionPane.showMessageDialog(mainFrame, "you must choose an item");
			}else{
				String[] selected = item.split(" "); //split the item and store the strings in the array
				if (selected[0].equalsIgnoreCase("Math")){ //if it is in Math department      
					int i = findIndex(selected[0], item);   //find index
					Math.remove(i); //remove it from math arraylist 
					listModel.removeElement(list.getSelectedValue()); //remove it from list 
					JOptionPane.showMessageDialog(mainFrame, "item removed"); //show message
				}
				if (selected[0].equalsIgnoreCase("Science")){ //if it is in Science department
					int i = findIndex(selected[0], item);        //find index
					Science.remove(i); //remove
					listModel.removeElement(list.getSelectedValue()); //remove it from list
					JOptionPane.showMessageDialog(mainFrame, "item removed");             //show message
				}
				if (selected[0].equalsIgnoreCase("History")){//if it is in Science department
					int i = findIndex(selected[0], item);         //find index
					History.remove(i); //remove it from history arraylist
					listModel.removeElement(list.getSelectedValue()); //remove it from list
					JOptionPane.showMessageDialog(mainFrame, "item removed");               //show message          
				}
				if (selected[0].equalsIgnoreCase("English")){//if it is in Science department
					int i = findIndex(selected[0], item);   //find index
					English.remove(i); //remove it from english arraylist
					listModel.removeElement(list.getSelectedValue()); //remove it from list
					JOptionPane.showMessageDialog(mainFrame, "item removed"); //show message
				}
				if (selected[0].equalsIgnoreCase("Business")){//if it is in Science department
					int i = findIndex(selected[0], item); //find index

					Business.remove(i); //remove it from arraylist
					listModel.removeElement(list.getSelectedValue()); //remove it from list
					JOptionPane.showMessageDialog(mainFrame, "item removed"); //show message
				}
			}
		}

		if (event.getSource()==lostButton){ //if lost button is pressed
			String item = SignedOutList.getSelectedValue(); //get selected item in the list
			if (item == null){ //checks if user selects an item
				JOptionPane.showMessageDialog(mainFrame, "which textbook is lost?");
			}else{
				String[] selected = item.split(" "); //split the item and store the strings in the array
				if (selected[0].equalsIgnoreCase("Math")){ //if it is in Math department      
					int i = findIndex(selected[0], item);       //find index
					Math.remove(i); //remove it 
					SignedOutListModel.removeElement(SignedOutList.getSelectedValue()); //remove it from list
					JOptionPane.showMessageDialog(mainFrame, "$75 for replacement fee"); //show message
				}
				if (selected[0].equalsIgnoreCase("Science")){ //if it is in Science department
					int i = findIndex(selected[0], item);         //find index
					Science.remove(i); //remove 
					SignedOutListModel.removeElement(SignedOutList.getSelectedValue()); //remove it from list
					JOptionPane.showMessageDialog(mainFrame, "$75 for replacement fee");              //show message
				}
				if (selected[0].equalsIgnoreCase("History")){//if it is in History department
					int i = findIndex(selected[0], item);         //find index
					History.remove(i); //remove
					SignedOutListModel.removeElement(SignedOutList.getSelectedValue()); //remove it from list
					JOptionPane.showMessageDialog(mainFrame, "$75 for replacement fee");                      //show message   
				}
				if (selected[0].equalsIgnoreCase("English")){//if it is in English department
					int i = findIndex(selected[0], item);    //find index
					English.remove(i); //remove 
					SignedOutListModel.removeElement(SignedOutList.getSelectedValue()); //remove it from list 
					JOptionPane.showMessageDialog(mainFrame, "$75 for replacement fee");// show message
				}
				if (selected[0].equalsIgnoreCase("Business")){//if it is in Business department
					int i = findIndex(selected[0], item); //find index
					Business.remove(i); //remove 
					SignedOutListModel.removeElement(SignedOutList.getSelectedValue()); //remove it from list
					JOptionPane.showMessageDialog(mainFrame, "$75 for replacement fee"); //show message
				}
			}
		}


		if (event.getSource() == deleteUserButton){ //if delete user us pressed
			String user = userList.getSelectedValue(); //get selected item in the list
			if (user == null){ //if no item is selected
				JOptionPane.showMessageDialog(mainFrame, "which user to delete?"); //output message
			}else if (user.equalsIgnoreCase("admin")){ //if user is admin
				JOptionPane.showMessageDialog(mainFrame, "you cannot delete admin"); //output warning
			}else{
				for (int i=0;i<userInfo.size();i++) 
				{
					if ((userInfo.get(i)).getUserName().equals(user)) //get user
					{
						userInfo.remove(i); //remove user 
						userListModel.removeElement(userList.getSelectedValue()); //remove it from list
					}
				}
			}
		}
		if (event.getSource() == newTeacherButton){ //if new teacher is pressed
			teachRegisterFrame.setVisible(true); //if command is new teacher then pop up the frame for them to enter acc info for a new teacher
			mainFrame.setVisible(false); //set mainframe false
		}
		if(event.getSource() == confirmTeachRegisterButton){ //if confirm register is pressed  
			for (int i=0;i<userInfo.size();i++) //find info
			{
				if (newTeachUserNameTF.getText().equals((userInfo.get(i)).getUserName()))      //check if username is taken
				{
					JOptionPane.showMessageDialog(mainFrame, "Username is taken");               //promp user to enter a new username
					userNameTaken=true; //set taken = true
				}
			}
			if (newTeachUserNameTF.getText().equals("")||newTeachPasswordTF.getText().equals("")||newTeachPasswordTF.getText().equals("")){ //if any input is empty
				JOptionPane.showMessageDialog(mainFrame, "Please do not leave any fields blank"); //check if any fields left blank and prompt user to not leave anything blank
				newTeachUserNameTF.setText("");
				newTeachPasswordTF.setText(""); //reset all fields
				newTeachPasswordTF2.setText("");
			}
			else if (userNameTaken==false&&newTeachPasswordTF.getText().equals(newTeachPasswordTF2.getText())){ //if password matches
				userInfo.add(new user(newTeachUserNameTF.getText(), newTeachPasswordTF.getText(), true));                     //if passwords match add new user
				userListModel.addElement(newTeachUserNameTF.getText());                                                      //add new user to the display
				sortuserList(0,userListModel.size()-1); //sort user list
				teachRegisterFrame.setVisible(false);
				mainFrame.setVisible(true);           //close the frame for registering and pop up the main program frame
				newTeachUserNameTF.setText(""); //reset variables
				newTeachPasswordTF.setText("");
				newTeachPasswordTF2.setText("");
			}
			else if (!newTeachPasswordTF.getText().equals(newTeachPasswordTF2.getText())){ //if password doesn't match
				JOptionPane.showMessageDialog(mainFrame, "Passwords do not match");                                       //tell user if password donot match
				newTeachPasswordTF.setText(""); // reset textfield
				newTeachPasswordTF2.setText("");
			}
			userNameTaken=false; //set name taken = false
		}

		if(event.getSource() == returnButton1){ //if return button is pressed
			stuRegisterFrame.setVisible(false); //close frame
			mainFrame.setVisible(true);       //if command is return button then just close register frame display the main program frame
		}

		if (event.getSource() == newStudentButton){
			stuRegisterFrame.setVisible(true);     //if command is new student the display frame to enter info for a new student and hide main program frame
			mainFrame.setVisible(false);
		}
		if(event.getSource() == confirmStuRegisterButton){  
			for (int i=0;i<userInfo.size();i++)
			{
				if (newStuUserNameTF.getText().equals((userInfo.get(i)).getUserName()))            //check if username is taken
				{
					JOptionPane.showMessageDialog(mainFrame, "Username is taken");               //promp user to enter a new username
					userNameTaken=true;

				}
			}
			if (newStuUserNameTF.getText().equals("")||newStuPasswordTF.getText().equals("")||newStuPasswordTF.getText().equals("")){
				JOptionPane.showMessageDialog(mainFrame, "Please donot leave any fields blank");                                              //check if any fields left blank and promp user to not leave anything blank
				newStuUserNameTF.setText("");
				newStuPasswordTF.setText("");
				newStuPasswordTF2.setText("");
			}
			else if (userNameTaken==false&&newStuPasswordTF.getText().equals(newStuPasswordTF2.getText())){
				userInfo.add(new user(newStuUserNameTF.getText(), newStuPasswordTF.getText(), false));                     //if passwords match add new user
				userListModel.addElement(newStuUserNameTF.getText());                                                      //add new user to the display
				sortuserList(0,userListModel.size()-1);

				stuRegisterFrame.setVisible(false);
				mainFrame.setVisible(true);                                                                          //close the frame for registering and pop up the main program frame
				newStuUserNameTF.setText("");
				newStuPasswordTF.setText(""); //reset textfields
				newStuPasswordTF2.setText("");

			}
			else if (!newStuPasswordTF.getText().equals(newStuPasswordTF2.getText())){
				JOptionPane.showMessageDialog(mainFrame, "Passwords do not match");                                       //tell user if password donot match
				newStuUserNameTF.setText("");
				newStuPasswordTF.setText("");
				newStuPasswordTF2.setText("");
			}
			userNameTaken=false;
		}

		if(event.getSource() == returnButton2){
			teachRegisterFrame.setVisible(false);                                   //if command is return button then just close register frame display the main program frame
			mainFrame.setVisible(true);
		}
	}

	public void showsearch(String department, String course) {
		if (department.equalsIgnoreCase("math")){ //if department is math
			JOptionPane.showMessageDialog(mainFrame, "there are " + SearchMath(course) + " textbook(s) available for " + course); //show message
		} 
		if (department.equalsIgnoreCase("science")){ //if department is science
			JOptionPane.showMessageDialog(mainFrame, "there are " + SearchScience(course) + " textbook(s) available for " + course); //show message
		}
		if (department.equalsIgnoreCase("history")){ //if department is history
			JOptionPane.showMessageDialog(mainFrame, "there are " + SearchHistory(course) + " textbook(s) available for " + course);//show message
		}
		if (department.equalsIgnoreCase("english")){ //if department is english
			JOptionPane.showMessageDialog(mainFrame, "there are " + SearchEnglish(course) + " textbook(s) available for " + course);//show message
		}
		if (department.equalsIgnoreCase("business")){ //if department is business
			JOptionPane.showMessageDialog(mainFrame, "there are " + SearchBusiness(course) + " textbook(s) available for " + course);//show message
		}

	}

	/* use binary search to accumulate how many textbooks are available*/
	public int SearchScience(String search) {
		int count = 0; //accumulator
		int low =0; //low
		int high = Science.size()-1; //high
		int startindex = -1; //start index
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (Science.get(mid).getCourse().compareToIgnoreCase(search)>0 ){ //if it is greater
				high = mid -1; //move high
			}else if (Science.get(mid).getCourse().equalsIgnoreCase(search)){ //if it matches
				startindex = mid; //change the startindex
				high = mid-1;
			}else{ //if it is less
				low = mid+1; //move low
			}
		}
		int endindex = -1; //end index
		low= 0; //reset low
		high = Science.size()-1; //reset high
		while(low<=high){
			int mid = (high-low)/2 + low; //mid
			if (Science.get(mid).getCourse().compareToIgnoreCase(search)>0){ //if it is greater
				high = mid-1; //move high
			}else if (Science.get(mid).getCourse().equalsIgnoreCase(search)){ 
				endindex = mid; //end index = mid
				low = mid+1;
			}else{
				low = mid+1; //move low
			}
		}
		if (startindex != -1 && endindex != -1){
			for(int i=0; i+startindex<=endindex;i++){
				if (Science.get(i).getBorrowed()==false){ //if it is not borrowed
					count = count + 1;  //add one to count
				}
			}
		}
		return count;
	}
	/* use binary search to accumulate how many textbooks are available*/
	public int SearchMath(String search) {
		int count = 0;
		int low =0;
		int high = Math.size()-1;
		int startindex = -1;
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (Math.get(mid).getCourse().compareToIgnoreCase(search)>0 ){
				high = mid -1;
			}else if (Math.get(mid).getCourse().equalsIgnoreCase(search)){
				startindex = mid;
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		int endindex = -1;
		low= 0;
		high = Math.size()-1;
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (Math.get(mid).getCourse().compareToIgnoreCase(search)>0){
				high = mid-1;
			}else if (Math.get(mid).getCourse().equalsIgnoreCase(search)){
				endindex = mid;
				low = mid+1;
			}else{
				low = mid+1;
			}
		}
		if (startindex != -1 && endindex != -1){
			for(int i=0; i+startindex<=endindex;i++){
				if (Math.get(i).getBorrowed()==false){
					count = count + 1;
				}
			}
		}
		return count;
	}
	/* use binary search to accumulate how many textbooks are available*/
	public int SearchBusiness(String search) {
		int count = 0;
		int low =0;
		int high = Business.size()-1;
		int startindex = -1;
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (Business.get(mid).getCourse().compareToIgnoreCase(search)>0 ){
				high = mid -1;
			}else if (Business.get(mid).getCourse().equalsIgnoreCase(search)){
				startindex = mid;
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		int endindex = -1;
		low= 0;
		high = Business.size()-1;
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (Business.get(mid).getCourse().compareToIgnoreCase(search)>0){
				high = mid-1;
			}else if (Business.get(mid).getCourse().equalsIgnoreCase(search)){
				endindex = mid;
				low = mid+1;
			}else{
				low = mid+1;
			}
		}
		if (startindex != -1 && endindex != -1){
			for(int i=0; i+startindex<=endindex;i++){
				if (Business.get(i).getBorrowed()==false){
					count = count + 1;
				}
			}
		}
		return count;
	}
	/* use binary search to accumulate how many textbooks are available*/
	public int SearchHistory(String search) {
		int count = 0;
		int low =0;
		int high = History.size()-1;
		int startindex = -1;
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (History.get(mid).getCourse().compareToIgnoreCase(search)>0 ){
				high = mid -1;
			}else if (History.get(mid).getCourse().equalsIgnoreCase(search)){
				startindex = mid;
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		int endindex = -1;
		low= 0;
		high = History.size()-1;
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (History.get(mid).getCourse().compareToIgnoreCase(search)>0){
				high = mid-1;
			}else if (History.get(mid).getCourse().equalsIgnoreCase(search)){
				endindex = mid;
				low = mid+1;
			}else{
				low = mid+1;
			}
		}
		if (startindex != -1 && endindex != -1){
			for(int i=0; i+startindex<=endindex;i++){
				if (History.get(i).getBorrowed()==false){
					count = count + 1;
				}
			}
		}
		return count;
	}

	/* use binary search to accumulate how many textbooks are available*/
	public int SearchEnglish(String search){
		int count = 0;
		int low =0;
		int high = English.size()-1;
		int startindex = -1;
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (English.get(mid).getCourse().compareToIgnoreCase(search)>0 ){
				high = mid -1;
			}else if (English.get(mid).getCourse().equalsIgnoreCase(search)){
				startindex = mid;
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		int endindex = -1;
		low= 0;
		high = English.size()-1;
		while(low<=high){
			int mid = (high-low)/2 + low;
			if (English.get(mid).getCourse().compareToIgnoreCase(search)>0){
				high = mid-1;
			}else if (English.get(mid).getCourse().equalsIgnoreCase(search)){
				endindex = mid;
				low = mid+1;
			}else{
				low = mid+1;
			}
		}
		if (startindex != -1 && endindex != -1){
			for(int i=0; i+startindex<=endindex;i++){
				if (English.get(i).getBorrowed()==false){
					count = count + 1;
				}
			}
		}
		return count;
	}

	public  void addToDisplay(String department, String subject, String condition, int textbooknumber){
		if (!checkDuplicateTextbook(department,subject,textbooknumber)){ //if it is not duplicate
			addTextbook(department, subject, condition, textbooknumber); //add textbook
			listModel.addElement(department + " " + subject + " " + condition + " " + textbooknumber); //add to list
			sortList(0,listModel.size()-1);  //sort list
			JOptionPane.showMessageDialog(mainFrame, "new textbook added"); //output message
		}else {
			JOptionPane.showMessageDialog(mainFrame, "this textbook already exists in list"); //if the textbook already exists, output mesage
		}
		deptComboBox.setSelectedIndex(0);
	}

	public void borrowTextBook(String department, String item, String nUser, String nCondition, String nTeacher){
		if (department.equalsIgnoreCase("Math")){ //if it is in math department
			int i = findIndex(department,item); //find index
			Math.get(i).setUser(nUser); //set user info
			//  Math.get(i).setID(nID);
			Math.get(i).setCondition(nCondition);
			Math.get(i).setTeacher(nTeacher);
			Math.get(i).setBorrowed(true);
		}
		if (department.equalsIgnoreCase("Science")){ //if it is in science department
			int i = findIndex(department,item); //find index
			Science.get(i).setUser(nUser); //set info
			//  Science.get(i).setID(nID);
			Science.get(i).setCondition(nCondition);
			Science.get(i).setTeacher(nTeacher);
			Science.get(i).setBorrowed(true);
		}
		if (department.equalsIgnoreCase("History")){ //if it is in history department
			int i = findIndex(department,item); //find index
			History.get(i).setUser(nUser); //set info
			//  History.get(i).setID(nID);
			History.get(i).setCondition(nCondition);
			History.get(i).setTeacher(nTeacher);
			History.get(i).setBorrowed(true);
		}
		if (department.equalsIgnoreCase("English")){ //if it is in english department
			int i = findIndex(department,item); //find index
			English.get(i).setUser(nUser); //set info
			// English.get(i).setID(nID);
			English.get(i).setCondition(nCondition);
			English.get(i).setTeacher(nTeacher);
			English.get(i).setBorrowed(true);
		}
		if (department.equalsIgnoreCase("Business")){ //if it is in business department
			int i = findIndex(department,item); //find index
			Business.get(i).setUser(nUser); //set info
			// Business.get(i).setID(nID);
			Business.get(i).setCondition(nCondition);
			Business.get(i).setTeacher(nTeacher);
			Business.get(i).setBorrowed(true);
		}
	}
	/* use quick sort to sort the list*/
	public void sortsignoutList(int low, int high) {
		if (SignedOutListModel.size()>2){
			if (low>=high){
				return;
			}
			int i = low;
			int j = high;
			String pivot = SignedOutListModel.getElementAt(low + (high-low)/2);
			while(i<=j){
				while(SignedOutListModel.getElementAt(i).compareToIgnoreCase(pivot)<0){
					i++;
				}
				while(SignedOutListModel.getElementAt(j).compareToIgnoreCase(pivot)>0){
					j--;
				}
				if (i<=j){
					exchangeSignedOutList(i,j); //exchange items
					i++;
					j--;
				}
			}

			if (low < j){
				sortsignoutList(low,j); //recursion
			}
			if (i<high){
				sortsignoutList(i,high); //recursion
			}

		}
	}

	/* use quick sort to sort user list*/ 
	public void sortuserList(int low, int high){
		if (userListModel.size()>2){
			if (low>=high){
				return;
			}
			int i = low;
			int j = high;
			String pivot = userListModel.getElementAt(low + (high-low)/2);
			while(i<=j){
				while(userListModel.getElementAt(i).compareToIgnoreCase(pivot)<0){
					i++;
				}
				while(userListModel.getElementAt(j).compareToIgnoreCase(pivot)>0){
					j--;
				}
				if (i<=j){
					exchangeuserList(i,j);
					i++;
					j--;
				}
			}

			if (low < j){
				sortuserList(low,j);
			}
			if (i<high){
				sortuserList(i,high);
			}

		}
	}

	/* use quick sort to sort the list*/
	public void sortList(int low, int high){
		if (listModel.size()>2){
			if (low>=high){
				return;
			}
			int i = low;
			int j = high;
			String pivot = listModel.getElementAt(low + (high-low)/2);
			while(i<=j){
				while(listModel.getElementAt(i).compareToIgnoreCase(pivot)<0){
					i++;
				}
				while(listModel.getElementAt(j).compareToIgnoreCase(pivot)>0){
					j--;
				}
				if (i<=j){
					exchangeList(i,j);
					i++;
					j--;
				}
			}
			if (low < j){
				sortList(low,j);
			}
			if (i<high){
				sortList(i,high);
			}

		}
	}
	public void exchangeuserList(int i, int j) {
		String temp = userListModel.getElementAt(i); //put one to temp
		userListModel.set(i, userListModel.getElementAt(j)); //exchange 
		userListModel.set(j, temp); //put it back
	}

	/* exchange the items in the list*/
	public void exchangeSignedOutList(int i, int j) {
		String temp = SignedOutListModel.getElementAt(i); //put one to string
		SignedOutListModel.set(i, SignedOutListModel.getElementAt(j)); //
		SignedOutListModel.set(j, temp);
	}

	/* exchange the items in the list*/
	public void exchangeList(int i, int j) {
		String temp = listModel.getElementAt(i);
		listModel.set(i, listModel.getElementAt(j));
		listModel.set(j, temp);
	}

	public static boolean checkDuplicateTextbook(String department, String subject, int textbooknumber) {
		if (department.equalsIgnoreCase("Math")){    //if department is math
			for (int i=0; i<Math.size();i++){ //check through math arraylist
				if (subject.equalsIgnoreCase(Math.get(i).getCourse()) && textbooknumber == (Math.get(i).getNumber())){ //if textbook number matches
					return true; //return true
				}
			}
		}
		if (department.equalsIgnoreCase("Business")){ //if department is business    
			for (int i=0; i<Business.size();i++){ //search through business arraylist
				if (subject.equalsIgnoreCase(Business.get(i).getCourse()) && textbooknumber == (Business.get(i).getNumber())){ //if matches
					return true; //return true
				}
			}
		}
		if (department.equalsIgnoreCase("English")){ //if it is english department    
			for (int i=0; i<English.size();i++){ //check through english arraylist
				if (subject.equalsIgnoreCase(English.get(i).getCourse()) && textbooknumber == (English.get(i).getNumber())){ //if matches
					return true; //return true
				}
			}
		}
		if (department.equalsIgnoreCase("Science")){    //if it is science department
			for (int i=0; i<Science.size();i++){ //check through science arraylist
				if (subject.equalsIgnoreCase(Science.get(i).getCourse()) && textbooknumber == (Science.get(i).getNumber())){ //if matches
					return true; //return true
				}
			}
		}
		if (department.equalsIgnoreCase("History")){ //if it is history department    
			for (int i=0; i<History.size();i++){ //check through history arraylist
				if (subject.equalsIgnoreCase(History.get(i).getCourse()) && textbooknumber == (History.get(i).getNumber())){ //if matches
					return true; //return true
				}
			}
		}

		return false; //otherwise, return false
	}

	public static int findIndex(String search, String item){ //find index
		if (search.equalsIgnoreCase("Math")){ //if it is math
			for (int i=0; i<Math.size();i++){ //check through math arraylist
				if (item.equalsIgnoreCase(Math.get(i).getDepartment() + " " + Math.get(i).getCourse() + " " + Math.get(i).getCondition() + " " + Math.get(i).getNumber())){//get the index of the selected item in arraylist
					return i; //return index
				}
			}
		}
		if (search.equalsIgnoreCase("Business")){ //if it is business
			for (int i=0; i<Business.size();i++){ //check through business arraylist
				if (item.equalsIgnoreCase(Business.get(i).getDepartment() + " " + Business.get(i).getCourse() + " " + Business.get(i).getCondition() + " " + Business.get(i).getNumber())){//get the index of the selected item in arraylist  
					return i;//return index
				}
			}
		}
		if (search.equalsIgnoreCase("Science")){ //if it is science
			for (int i=0; i<Science.size();i++){ //check through science arraylist
				if (item.equalsIgnoreCase(Science.get(i).getDepartment() + " " + Science.get(i).getCourse() + " " + Science.get(i).getCondition() + " " + Science.get(i).getNumber())){//get the index of the selected item in arraylist
					return i; //return index
				}
			}
		}
		if (search.equalsIgnoreCase("English")){ // if it is english
			for (int i=0; i<English.size();i++){ //check through english arraylist
				if (item.equalsIgnoreCase(English.get(i).getDepartment() + " " + English.get(i).getCourse() + " " + English.get(i).getCondition() + " " + English.get(i).getNumber())){//get the index of the selected item in arraylist
					return i; //return index
				}
			}
		}
		if (search.equalsIgnoreCase("History")){ //if it is history
			for (int i=0; i<History.size();i++){ //check through history arraylist
				if (item.equalsIgnoreCase(History.get(i).getDepartment() + " " + History.get(i).getCourse() + " " + History.get(i).getCondition() + " " + History.get(i).getNumber())){//get the index of the selected item in arraylist
					return i; //return index
				}
			}
		}
		return -1; //otherwise, return -1 
	}

	public static void addTextbook(String department, String course, String condition, int textbooknumber){
		if (department.equalsIgnoreCase("Math")){ //if department is math
			Math.add(new math(textbooknumber, condition, course)); //add to math class as an object
		}else if (department.equalsIgnoreCase("Science")){ //if department is science
			Science.add(new science(textbooknumber,condition,course)); //add to science class as an object
		}else if (department.equalsIgnoreCase("Business")){ //if department is business
			Business.add(new business(textbooknumber,condition,course)); //add to business as an object
		}else if (department.equalsIgnoreCase("English")){ //if department is english
			English.add(new english(textbooknumber,condition,course)); //add to english as an object
		}else if (department.equalsIgnoreCase("History")){ //if department is history
			History.add(new history(textbooknumber, condition, course)); //add to history as an object
		} 
	}

	public void addUsers(){
		for (int i=0;i<userInfo.size();i++){
			userListModel.addElement(userInfo.get(i).getUserName());    //add users to the display
		}
	}

	public void saveUserList()
	{
		try{
			PrintWriter writer = new PrintWriter("UserList.txt");       //save user list to the textfile UserList.txt

			for (int i=0;i<userInfo.size();i++)
			{
				writer.print((userInfo.get(i)).getUserName()+" ");
				writer.print((userInfo.get(i)).getPassword()+" ");                  //outout user information
				writer.print((userInfo.get(i)).getTeacherStatus()+" ");
				writer.println((userInfo.get(i)).getCurrentStatus());
			}

			writer.close();                                                     //close output
		}
		catch(Exception e){                                                   //catch exceptions
		}
	}

	public void loadUserList(){
		File file = new File("UserList.txt");                   //load users from UserList.txt

		if(file.exists() && !file.isDirectory()) {
			try{
				Scanner scan = new Scanner(file);

				for (int i=0;i<=userInfo.size();i++)
				{
					if (scan.hasNext()==true)                      //while there are things to scan
					{
						userInfo.add(new user("","",false));
						(userInfo.get(i)).setUserName(scan.next());
						(userInfo.get(i)).setPassword(scan.next());                 //add new users base off info gathered from file
						if (scan.next().equals("true")){
							(userInfo.get(i)).setTeacherStatus(true);
						}
						else{
							(userInfo.get(i)).setTeacherStatus(false);                //set correct teacher status
						}
						if (scan.next().equals("true")){
							(userInfo.get(i)).setCurrentStatus(true);
						}
					}

				}

				scan.close();                                                     //close input
			}
			catch(Exception e){                                                 //catch exceptions
			}
		}
	}

	public static void save(){
		try {
			File myFile = new File("TextbookSaveFile.txt");
			if (myFile.createNewFile()){}
			PrintWriter writer = new PrintWriter("TextbookSaveFile.txt");
			for(int i = 0; i < Business.size(); i++){
				if(Business.get(i).getBorrowed()==false){
					writer.print(Business.get(i).getDepartment() + " " + Business.get(i).getCourse() + " " + Business.get(i).getCondition() + " " + Business.get(i).getNumber()); //save to file
					writer.println();
				}
			}
			/* write everything in english department to file */
			for(int i = 0; i < English.size(); i++){
				if(English.get(i).getBorrowed()==false){
					writer.print(English.get(i).getDepartment() + " " + English.get(i).getCourse() + " " + English.get(i).getCondition() + " " + English.get(i).getNumber() );
					writer.println();
				}
			}
			/* write everything in history department to file */
			for(int i = 0; i < History.size(); i++){
				if(History.get(i).getBorrowed()==false){
					writer.print(History.get(i).getDepartment() + " " + History.get(i).getCourse() + " " + History.get(i).getCondition() + " " + History.get(i).getNumber());
					writer.println();
				}
			}
			/* write everything in math department to file */
			for(int i = 0; i < Math.size(); i++){
				if(Math.get(i).getBorrowed()==false){
					writer.print(Math.get(i).getDepartment() + " " + Math.get(i).getCourse() + " " + Math.get(i).getCondition() + " " + Math.get(i).getNumber());
					writer.println();
				}
			}
			/* write everything in science department to file */
			for(int i = 0; i < Science.size(); i++){
				if(Science.get(i).getBorrowed()==false){
					writer.print(Science.get(i).getDepartment() + " " + Science.get(i).getCourse() + " " + Science.get(i).getCondition() + " " + Science.get(i).getNumber() );
					writer.println();
				}
			}
			writer.close(); //close writer
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public  void saveReturn(){
		try {
			File myFile = new File(currentUser+"returnList.txt");
			PrintWriter writer = new PrintWriter(currentUser+"returnList.txt");
			//write everything in business, if it is borrowed, to file
			for(int i = 0; i < Business.size(); i++){
				if (Business.get(i).getBorrowed()){
					writer.print(Business.get(i).getDepartment() + " " + 
							Business.get(i).getNumber() + " " + 
							Business.get(i).getCondition() + " " + 
							Business.get(i).getCourse() + " " + 
							Business.get(i).getUser() + " " + 
							Business.get(i).getTeacher());
					writer.println();
				}
			}
			//write everything in math, if it is borrowed, to file
			for(int i = 0; i < Math.size(); i++){
				if (Math.get(i).getBorrowed()){
					writer.print(Math.get(i).getDepartment() + " " + 
							Math.get(i).getNumber() + " " + 
							Math.get(i).getCondition() + " " + 
							Math.get(i).getCourse() + " " + 
							Math.get(i).getUser() + " " + 
							Math.get(i).getTeacher());
					writer.println();
				}
			}
			//write everything in english, if it is borrowed, to file
			for(int i = 0; i < English.size(); i++){
				if (English.get(i).getBorrowed()){
					writer.print(English.get(i).getDepartment() + " " + 
							English.get(i).getNumber() + " " + 
							English.get(i).getCondition() + " " + 
							English.get(i).getCourse() + " " + 
							English.get(i).getUser() + " " + 
							English.get(i).getTeacher());
					writer.println();
				}
			}
			//write everything in science, if it is borrowed, to file
			for(int i = 0; i < Science.size(); i++){
				if (Science.get(i).getBorrowed()){
					writer.print(Science.get(i).getDepartment() + " " + 
							Science.get(i).getNumber() + " " + 
							Science.get(i).getCondition() + " " + 
							Science.get(i).getCourse() + " " + 
							Science.get(i).getUser() + " " + 
							Science.get(i).getTeacher());
					writer.println();
				}
			}
			//write everything in history, if it is borrowed, to file
			for(int i = 0; i < History.size(); i++){
				if (History.get(i).getBorrowed()){
					writer.print(History.get(i).getDepartment() + " " + 
							History.get(i).getNumber() + " " + 
							History.get(i).getCondition() + " " + 
							History.get(i).getCourse() + " " + 
							History.get(i).getUser() + " " + 
							History.get(i).getTeacher());
					writer.println();
				}
			}

			writer.close(); //close writer
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void loadReturn() {

		try{
			File myFile = new File(currentUser+"returnList.txt");
			if (myFile.exists() && !myFile.isDirectory()){
				Scanner fileScan = new Scanner(myFile);
				while(fileScan.hasNext()==true){
					String department = fileScan.next();
					int number = fileScan.nextInt();
					String condition = fileScan.next(); //input everything from file
					String course = fileScan.next();
					String uName  = fileScan.next();
					String teacher = fileScan.next();
					addTextbook(department, course, condition, number);
					String item = (department + " " + course + " " + condition + " " + number);
					SignedOutListModel.addElement(item); //add item to signout list
					borrowTextBook(department, item, uName,condition, teacher); //set borrow
				}
			}
			sortsignoutList(0,SignedOutListModel.size()-1); //sort the list
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public  void load() {
		try{
			File myFile = new File("TextbookSaveFile.txt");
			if (myFile.exists() && !myFile.isDirectory()){
				Scanner fileScan = new Scanner(myFile);
				while(fileScan.hasNext()==true){
					String department = fileScan.next();
					String course = fileScan.next();
					String condition = fileScan.next(); //input from file
					int number = fileScan.nextInt();


					if (department.equalsIgnoreCase("math")){ //if it is math
						addTextbook(department, course, condition, number); //add to math
						listModel.addElement(department + " " + course + " " + condition + " " + number); //add item to list

					}
					if (department.equalsIgnoreCase("english")){ //if it is english
						addTextbook(department, course, condition, number); //add textbook
						listModel.addElement(department + " " + course + " " + condition + " " + number); //add item to list
					}
					if (department.equalsIgnoreCase("science")){ //if it is science
						addTextbook(department, course, condition, number); //add textbook
						listModel.addElement(department + " " + course + " " + condition + " " + number); //add item to list
					}
					if (department.equalsIgnoreCase("history")){ //if it is history
						addTextbook(department, course, condition, number); //add textbook
						listModel.addElement(department + " " + course + " " + condition + " " + number); //add item to list
					}
					if (department.equalsIgnoreCase("business")){ //if it is business
						addTextbook(department, course, condition, number); //add textbook
						listModel.addElement(department + " " + course + " " + condition + " " + number); //add item to list
					}
				}
				sortList(0,listModel.size()-1); //sort list
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}


}

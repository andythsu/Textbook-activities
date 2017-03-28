

import java.util.*;
import java.awt.*;                                                 //GUI package
import java.awt.event.*;                                           // action listener
import javax.swing.*;
import javax.imageio.*;
import javax.swing.border.*;
import java.io.*;
import java.io.File;

public class UserSignIn extends JFrame implements ActionListener{

	static ArrayList<user> userInfo = new ArrayList<user>();           //declare array list

	String userList[] = new String[]{"Teacher", "Student"};            //declare combo box
	JComboBox userCB = new JComboBox(userList);

	JFrame signInFrame = new JFrame();                              //declare jFrames
	JFrame registerFrame = new JFrame();

	JPanel infoPanel = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel combinedPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();                           //decare panels
	JPanel registerPanel = new JPanel();
	JPanel registerButtonsPanel = new JPanel();

	JLabel logoLabel = new JLabel("");                              //declare labels
	JLabel registerLabel = new JLabel("");
	JLabel userNameLabel = new JLabel("  Username: ");
	JLabel passwordLabel = new JLabel("  Password: ");
	JLabel newUserNameLabel = new JLabel(" Username:");
	JLabel newPasswordLabel = new JLabel(" Password:");
	JLabel newPasswordLabel2 = new JLabel(" Confirm Password:  ");

	JButton userSignInButton = new JButton("Log in");
	JButton registerButton = new JButton("Register");                    //declare buttons
	JButton confirmRegisterButton = new JButton("Register New User");
	JButton returnButton = new JButton("Return");

	JTextField userNameTF = new JTextField(10);
	JPasswordField passwordTF = new JPasswordField(10);
	JTextField newUserNameTF = new JTextField(10);                   //delare textfields
	JPasswordField newPasswordTF = new JPasswordField(10);
	JPasswordField newPasswordTF2 = new JPasswordField(10);

	GridLayout infoLayout = new GridLayout(2,1);
	GridLayout buttonsLayout = new GridLayout(1,4);
	GridLayout registerLayout = new GridLayout(3,2);

	static Color Gray=new Color(192,192,192);
	static Color LightSlateGray=new Color(119,136,153);                  //declaring Colours
	static Color SlateGray=new Color(112,128,144);

	static boolean userNameTaken=false;                              //declaring boolean for user name taken and user status
	static String teacherStatus;

	public UserSignIn(){    
		passwordTF.setEchoChar('*'); // mask out the password field
		newPasswordTF.setEchoChar('*');
		newPasswordTF2.setEchoChar('*');
		userInfo.add(new user("admin", "admin1", true)); //add default user

		loadUserList();

		registerFrame.setUndecorated(true);                                            //set a visually appealing border for registerFrame
		signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                   //set it so that program closes on exit
		registerFrame.getRootPane().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,SlateGray,LightSlateGray),BorderFactory.createBevelBorder(BevelBorder.LOWERED)));


		signInFrame.setResizable(false);                              //set unresizable frames
		registerFrame.setResizable(false);

		signInFrame.setVisible(true);                                //set sign in frame as visible

		signInFrame.setBackground(Color.WHITE);
		registerFrame.setBackground(Color.WHITE);                     //set background colors of frames

		infoPanel.setLayout(infoLayout);
		textPanel.setLayout(infoLayout);
		buttonsPanel.setLayout(buttonsLayout);
		registerPanel.setLayout(registerLayout);
		signInFrame.setLayout(new GridBagLayout());                  //set layouts 
		registerFrame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		infoPanel.add(userNameLabel);
		textPanel.add(userNameTF);
		infoPanel.add(passwordLabel);
		textPanel.add(passwordTF);
		combinedPanel.add(infoPanel);
		combinedPanel.add(textPanel);
		buttonsPanel.add(userCB);                            //adding gui components 
		buttonsPanel.add(userSignInButton);
		buttonsPanel.add(registerButton);
		registerPanel.add(newUserNameLabel);
		registerPanel.add(newUserNameTF);
		registerPanel.add(newPasswordLabel);
		registerPanel.add(newPasswordTF);
		registerPanel.add(newPasswordLabel2);
		registerPanel.add(newPasswordTF2);
		registerButtonsPanel.add(confirmRegisterButton);
		registerButtonsPanel.add(returnButton);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 0;
		signInFrame.add(logoLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.gridwidth = 1;
		c.gridy = 1;
		signInFrame.add(combinedPanel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridy = 2;
		signInFrame.add(buttonsPanel, c);
		c.fill = GridBagConstraints.HORIZONTAL;                   //setting parameters of the gridbag layout
		c.gridy = 0;
		registerFrame.add(registerLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;
		c.gridwidth = 1;
		c.gridy = 1;
		registerFrame.add(registerPanel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.gridwidth = 3;
		c.gridy = 2;
		registerFrame.add(registerButtonsPanel, c);

		userSignInButton.setToolTipText("Sign in to textbook tracking program");
		registerButton.setToolTipText("Register new student user");                           //setting tool tip texts
		confirmRegisterButton.setToolTipText("Confirm registering new student user");
		returnButton.setToolTipText("Return to loggin in");

		try {
			Image img = ImageIO.read(getClass().getResource("logo.png"));                    //importing the picture for GUI
			logoLabel.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		}
		try {
			Image img = ImageIO.read(getClass().getResource("register.png"));
			registerLabel.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
		}

		userSignInButton.addActionListener(this);
		registerButton.addActionListener(this);
		confirmRegisterButton.addActionListener(this);                          //adding action listeners 
		returnButton.addActionListener(this);

		signInFrame.pack();
		registerFrame.pack();                                                  //packing frames

		signInFrame.setLocation(400,400);
		registerFrame.setLocation(400,400);                                     //setting initial locaiton of frames
	}

	public void actionPerformed(ActionEvent event){
		if(event.getSource() == userSignInButton){                           //if command is to sign in
			for (int i=0;i<userInfo.size();i++)
			{
				if (((userInfo.get(i)).getTeacherStatus())==true){
					teacherStatus = "Teacher";                                         //check which teacher status is correct
				}
				else{
					teacherStatus = "Student";
				}
				if (userNameTF.getText().equals((userInfo.get(i)).getUserName())&&passwordTF.getText().equals((userInfo.get(i)).getPassword())&&userCB.getSelectedItem().equals(teacherStatus)){     //check if passwords and user name and teacher status match
					for (int j=0; j<userInfo.size(); j++){
						userInfo.get(j).setCurrentStatus(false); 
					}
					userInfo.get(i).setCurrentStatus(true);
					saveUserList();
					new TextbookSignOut();                             //launch the program is log in info is correct
					signInFrame.setVisible(false);
					break;
				}
				else if(userNameTF.getText().equals((userInfo.get(i)).getUserName())&&passwordTF.getText().equals((userInfo.get(i)).getPassword())){
					JOptionPane.showMessageDialog(signInFrame, "Entered account is not a "+userCB.getSelectedItem()+" account");         //if wrong account type notify user
					userNameTF.setText("");
					passwordTF.setText("");
					break;
				}
				else if(i==userInfo.size()-1){
					JOptionPane.showMessageDialog(signInFrame, "Username or password is incorrect");                          //if wrong user/password the notify user
					userNameTF.setText("");
					passwordTF.setText("");
				}
			}
		}
		if(event.getSource() == registerButton){
			registerFrame.setVisible(true);                                                     //display the frame for user to enter new student accounts info
			signInFrame.setVisible(false);
		}
		if(event.getSource() == confirmRegisterButton){  
			for (int i=0;i<userInfo.size();i++)
			{
				if (newUserNameTF.getText().equals((userInfo.get(i)).getUserName()))
				{
					JOptionPane.showMessageDialog(registerFrame, "Username is taken");                        //check if user name is taken and notify user
					userNameTaken=true;
				}
			}
			if (newUserNameTF.getText().equals("")||newPasswordTF.getText().equals("")||newPasswordTF.getText().equals("")){
				JOptionPane.showMessageDialog(registerFrame, "Please donot leave any fields blank");           //check if any fields were blank and notify user
				newUserNameTF.setText("");
				newPasswordTF.setText("");
				newPasswordTF2.setText("");
			}
			else if (userNameTaken==false&&newPasswordTF.getText().equals(newPasswordTF2.getText())){
				userInfo.add(new user(newUserNameTF.getText(), newPasswordTF.getText(), false));      //if all info entered correctly then create new user

				saveUserList();                                     //save new user list
				registerFrame.setVisible(false);
				signInFrame.setVisible(true);
				newUserNameTF.setText("");
				newPasswordTF.setText("");
				newPasswordTF2.setText("");
			}
			else if (!newPasswordTF.getText().equals(newPasswordTF2.getText())){
				JOptionPane.showMessageDialog(registerFrame, "Passwords do not match");                  //if new passwords entered donot match notify user
				newUserNameTF.setText("");
				newPasswordTF.setText("");
				newPasswordTF2.setText("");
			}
			userNameTaken=false;
		}
		if(event.getSource() == returnButton){
			registerFrame.setVisible(false);                                          //dispaly sign in frame and close register frame if return button is pressed
			signInFrame.setVisible(true);
		}
	}

	public static void main (String[]Args)   //main method
	{
		new UserSignIn();               //launch program
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

				scan.next();
				scan.next();
				scan.next();
				scan.next();

				for (int i=1;i<=userInfo.size();i++)
				{
					if (scan.hasNext()==true)                      //while there are things to scan
					{
						userInfo.add(new user(" "," ",false));
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
}

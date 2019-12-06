package Pages;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Systems.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtForename;
	private JTextField txtSurname;
	private JTextField txtUni;
	private JTextField txtEmail;
	private JTextField txtConfEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmField;
	User register = new User(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LABELS
		JLabel labelRegister = new JLabel("Register");
		labelRegister.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelRegister.setBounds(237, 35, 99, 51);
		contentPane.add(labelRegister);
		
		JComboBox comboBoxMr = new JComboBox();
		comboBoxMr.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Mrs", "Dr", "Prof"}));
		comboBoxMr.setMaximumRowCount(4);
		comboBoxMr.setBounds(279, 103, 91, 31);
		contentPane.add(comboBoxMr);
		
		JLabel labelTitle = new JLabel("Title :");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelTitle.setBounds(195, 103, 72, 23);
		contentPane.add(labelTitle);
		
		JLabel labelForename = new JLabel("Forename : ");
		labelForename.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelForename.setBounds(138, 151, 127, 23);
		contentPane.add(labelForename);
		
		JLabel labelSurname = new JLabel("Surname : ");
		labelSurname.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelSurname.setBounds(148, 195, 117, 23);
		contentPane.add(labelSurname);
		
		JLabel labelUni = new JLabel("University affiliation : ");
		labelUni.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelUni.setBounds(43, 237, 226, 23);
		contentPane.add(labelUni);
		
		JLabel labelEmail = new JLabel("Email  :");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelEmail.setBounds(176, 283, 91, 23);
		contentPane.add(labelEmail);
		
		JLabel labelConfirmEmail = new JLabel("Confirm Email  :");
		labelConfirmEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelConfirmEmail.setBounds(93, 324, 167, 23);
		contentPane.add(labelConfirmEmail);
		
		JLabel labelPass = new JLabel("Password :");
		labelPass.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPass.setBounds(142, 371, 119, 23);
		contentPane.add(labelPass);
		
		JLabel labelConfirmPass = new JLabel("Confirm Password :");
		labelConfirmPass.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelConfirmPass.setBounds(59, 416, 189, 23);
		contentPane.add(labelConfirmPass);
		
		//TEXTBOXES
		txtForename = new JTextField();
		txtForename.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtForename.setColumns(10);
		txtForename.setBounds(277, 147, 178, 31);
		contentPane.add(txtForename);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtSurname.setColumns(10);
		txtSurname.setBounds(277, 191, 178, 31);
		contentPane.add(txtSurname);

		txtUni = new JTextField();
		txtUni.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtUni.setColumns(10);
		txtUni.setBounds(279, 235, 271, 31);
		contentPane.add(txtUni);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtEmail.setColumns(10);
		txtEmail.setBounds(279, 279, 271, 31);
		contentPane.add(txtEmail);
		
		txtConfEmail = new JTextField();
		txtConfEmail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtConfEmail.setColumns(10);
		txtConfEmail.setBounds(279, 323, 271, 31);
		contentPane.add(txtConfEmail);
		
		JLabel lblErrors = new JLabel("");
		lblErrors.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrors.setForeground(Color.RED);
		lblErrors.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErrors.setBounds(6, 474, 588, 31);
		contentPane.add(lblErrors);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 366, 271, 41);
		contentPane.add(passwordField);
		
		passwordConfirmField = new JPasswordField();
		passwordConfirmField.setBounds(279, 418, 271, 41);
		contentPane.add(passwordConfirmField);
		
		
		//BUTTONREGISTER
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
		
		String title ;
		String value = comboBoxMr.getSelectedItem().toString();
		
		if( value == "Mr") {
			title = "Mr";
		}else if(value ==  "Mrs") {
			title = "Mrs";
		}else if (value == "Dr") {
			title = "Dr";
		}else if (value=="Prof") {
			title = "Prof";
		}
		else{
			title = "none";
			lblErrors.setText("Please select your Title"); 
		}
		
		
		String forname = txtForename.getText();
		String surname = txtSurname.getText(); 
		String university = txtUni.getText();
		String email = txtEmail.getText(); 
		String confirmEmail = txtConfEmail.getText();
		String password = passwordField.getText();; 
		String confirmPassword = passwordConfirmField.getText();
		
		//System.out.println(title);
		//Set all to false to initialise
		boolean author = false; 
		boolean reviewer = false; 
		boolean editor = false; 
		

		//change the value of the user 
		if (LogInPage.register == true) {
			author = true; 
		}else if (LogInPage.register == false) {
			editor = true; 
		} 
		
		
		
		//check all the fields have been completed
		//if all fields are not null then sign up user 
		if( isNull(forname) == true )   {
			lblErrors.setText("Please enter a valid Forname");
		}else if ( isNull(surname) == true  ) {
			lblErrors.setText("Please enter a valid Surname");
		}else if (isNull(university) == true ) {
			lblErrors.setText("Please enter a valid University");
		}else if  ( validateEmail(email)== false ) {
			lblErrors.setText("Please enter a valid Email");
		}else if (isNull(password) == true) {
			lblErrors.setText("Please enter a Password");
		}else if( isPasswordValid(password) == false) {
			lblErrors.setText( "Ensure your password has one UpperCase letter, 5-12 characters and 1 number" );
		}else if(isNull(confirmPassword)) {
			lblErrors.setText("Please confirm Password");
		}else if(email.equals(confirmEmail)==false) {
			lblErrors.setText("Please make sure both emails match");
		}else if(password.equals(confirmPassword)==false) {
			lblErrors.setText( "Please make sure both passowords match" );
		} else
			try {
				if(User.checkEmailExists(email) == true) {
					lblErrors.setText( "This email is already in use" );
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
				
		//This is the final check the login page will have to pass
		//if all the fields in the login are not null and satisfy the above 
		//then the user will be allowed to sign up as a user
		
		try {
			if( (isNull(forname) == false  && isNull(surname) ==false   && isNull(university) == false  && validateEmail(email)== true && isNull(password) == false
					&& isPasswordValid(password) == true && (isNull(confirmEmail)== false && email.equals(confirmEmail)==true) && password.equals(confirmPassword)==true) && User.checkEmailExists(email) == false
					){
				lblErrors.setForeground(Color.black);
				lblErrors.setText("Thank You For Signing Up");
			}
		} catch (SQLException e2) {
		
			e2.printStackTrace();
		}
		

		//execute the query and add data into the data base over here
		if(lblErrors.getText().equals("Thank You For Signing Up" )) {
			//create a user
			User pushData = new User(); 
			
			try {
				//push data into DB
				pushData.insertData(title, forname, surname, university, email, confirmPassword.hashCode(), reviewer, editor, author);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
		try {
			//waits a few seconds before calling the loginPage/HomePage
			  Thread.sleep(1000);
			  
			  
			  //The system rembers which register option the user picked
			  //if the user picked Submit article they are an author
			  //if they clicked add new journal then they are an editor 
			  
			  if (LogInPage.register == true) {
					 
					SubmitArticlePage s = new SubmitArticlePage();
					s.setVisible(true);
					dispose(); 
				
			}else if (LogInPage.register == false) {
					
					NewJournalPage j = new NewJournalPage();
					j.setVisible(true);
				    dispose();
					} 
					
				  
					}catch(InterruptedException ex){
					    Thread.currentThread().interrupt();
					}
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRegister.setBounds(164, 506, 127, 41);
		contentPane.add(btnRegister);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//in the event that the user decides they do not want to sign up
				//can always navigate to home page
				
				LogInPage callhome = new LogInPage(); 
				callhome.setVisible(true);
				dispose();
				
				
				
			}
		});
		btnHomePage.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnHomePage.setBounds(315, 506, 127, 41);
		contentPane.add(btnHomePage);
		
		
		
	}
	// takes in a string from the text field/area and if that box is null
			//meaning it does not contain any text then the method will return true
			public static boolean isNull(String input) {
				if(input.isEmpty() == true) {
					return true; 
				}else {
					return false;
				}
			}
			
			//Using pattern matching the method checks if there is any text before the @ symbol 
			//Checks if the string contains an @ sign and the .com 
			//email can contain numbers and characters
			public static boolean validateEmail(String email ) {
				String regex = "^(.+)@(.+)$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(email);
				return matcher.matches(); 
			}
			
			//using regular expression to match the password and see if it contains between 6 to 12 characters long
			//contains at least one digit or one character
			//contains an uppercase character
			public static boolean isPasswordValid(String password) {
				boolean check; 
				String regexP = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,12}$";
				if(password.matches(regexP)) {
					check = true;
				}else {
						check = false; 
					}			
				return check;
				
			}
}

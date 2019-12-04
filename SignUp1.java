package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class SignUP1 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUP1 frame = new SignUP1();
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
	public SignUP1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Register As A User");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Arial Narrow", Font.PLAIN, 63));
		lblSignUp.setBounds(164, 13, 534, 96);
		contentPane.add(lblSignUp);
		
		JLabel label = new JLabel("Title:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(256, 122, 56, 16);
		contentPane.add(label);
		
		JRadioButton rdbtnMr = new JRadioButton("Mr");
		rdbtnMr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMr.setBounds(307, 118, 62, 25);
		contentPane.add(rdbtnMr);
		
		JRadioButton rdbtnMiss = new JRadioButton("Miss");
		rdbtnMiss.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMiss.setBounds(373, 118, 62, 25);
		contentPane.add(rdbtnMiss);
		
		JRadioButton rdbtnMrs = new JRadioButton("Mrs");
		rdbtnMrs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMrs.setBounds(448, 119, 73, 25);
		contentPane.add(rdbtnMrs);
		
		JRadioButton rdbtnDr = new JRadioButton("Dr");
		rdbtnDr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnDr.setBounds(518, 118, 89, 25);
		contentPane.add(rdbtnDr);
		
		JLabel txtrForename = new JLabel("Forname");
		txtrForename.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrForename.setBounds(256, 173, 86, 16);
		contentPane.add(txtrForename);
		
		JTextArea fornameTextArea = new JTextArea();
		fornameTextArea.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		fornameTextArea.setBounds(341, 167, 187, 36);
		contentPane.add(fornameTextArea);
		
		JLabel  txtrSurname = new JLabel("Surname");
		txtrSurname.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrSurname.setBounds(256, 227, 86, 16);
		contentPane.add( txtrSurname);
		
		JTextArea surnameTextArea = new JTextArea();
		surnameTextArea.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		surnameTextArea.setBounds(341, 216, 187, 36);
		contentPane.add(surnameTextArea);
		
		JLabel txtrUniversity = new JLabel("University");
		txtrUniversity.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrUniversity.setBounds(256, 272, 97, 28);
		contentPane.add(txtrUniversity);
		
		JTextArea universityTextArea = new JTextArea();
		universityTextArea.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		universityTextArea.setBounds(341, 265, 187, 36);
		contentPane.add(universityTextArea);
		
		JLabel  txtrEmail = new JLabel("Email");
		txtrEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrEmail.setBounds(272, 326, 70, 28);
		contentPane.add( txtrEmail);
		
		JTextArea emailTextArea = new JTextArea();
		emailTextArea.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		emailTextArea.setBounds(341, 313, 187, 36);
		contentPane.add(emailTextArea);
		
		JLabel txtrPassword  = new JLabel("Password");
		txtrPassword .setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrPassword .setBounds(256, 367, 102, 28);
		contentPane.add(txtrPassword );
		
		JTextArea passwordTextArea = new JTextArea();
		passwordTextArea.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		final JPasswordField pfPassword = new JPasswordField(20);
		passwordTextArea.setBounds(341, 362, 187, 36);
		
		
		
		JLabel label_6 = new JLabel("Sign up as:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(237, 436, 105, 21);
		contentPane.add(label_6);
		
		JRadioButton rdbtnAuthor= new JRadioButton("Author");
		rdbtnAuthor.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		rdbtnAuthor.setBounds(332, 435, 73, 25);
		contentPane.add( rdbtnAuthor);
		
		JRadioButton rdbtnEditor = new JRadioButton("Editor");
		rdbtnEditor.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		rdbtnEditor.setBounds(412, 434, 86, 25);
		contentPane.add(rdbtnEditor);
		
		JRadioButton rdbtnReviewer = new JRadioButton("Reviewer");
		rdbtnReviewer.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		rdbtnReviewer.setBounds(504, 434, 127, 25);
		contentPane.add(rdbtnReviewer);
		
		JLabel lblErrors = new JLabel("");
		lblErrors.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrors.setForeground(Color.RED);
		lblErrors.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErrors.setBounds(227, 470, 380, 31);
		contentPane.add(lblErrors);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(341, 367, 187, 36);
		contentPane.add(passwordField);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String title ;
				
				if( rdbtnMr.isSelected()) {
					title = "Mr";
				}else if(rdbtnMiss.isSelected()) {
					title = "Miss";
				}else if (rdbtnMrs.isSelected()) {
					title = "Mrs";
				}else if (rdbtnDr.isSelected()) {
					title = "Dr";
				}
				else{
					title = "none";
					lblErrors.setText("Please select your Title"); 
				}
				
				String forname = fornameTextArea.getText();
				String surname = surnameTextArea.getText(); 
				String university = universityTextArea.getText();
				String email = emailTextArea.getText(); 
				String password = passwordField.getText();; 
				
				//Set all to false to initialise
				boolean author = false; 
				boolean reviewer = false; 
				boolean editor = false; 
				
				
				//check all the fields have been completed
				//if all fields are not null then sign up user 
				if( isNull(forname) == true )   {
					lblErrors.setText("Please enter a valid Forname");
				}else if ( isNull(surname) == true  ) {
					lblErrors.setText("Please enter a valid Surname");
				}else if (isNull(university) == true ) {
					lblErrors.setText("Please enter a valid University");
				}else if  ( validateEmail(email)== false) {
					lblErrors.setText("Please enter a valid Email");
				}else if (isNull(password) == true) {
					lblErrors.setText("Please enter a valid Password");
				}
				
				
				//Checking what type of user the person should be registered as 
				if(rdbtnReviewer.isSelected()) {
					reviewer = true; 
				}else if(rdbtnAuthor.isSelected()) {
					author = true;
				}else if (rdbtnEditor.isSelected()) {
					editor = true; 
				}else {
					lblErrors.setText("Please enter a User Type");
				}
				
				
				//This is the final check the login page will have to pass
				//if all the fields in the login are not null and satisfy the above 
				//then the user will be allowed to sign up as a user
				
				if( (rdbtnReviewer.isSelected() == true || rdbtnAuthor.isSelected() == true || rdbtnEditor.isSelected() == true )
						&&  (isNull(forname) == false  && isNull(surname) ==false   && isNull(university) == false  && validateEmail(email)== true && isNull(password) == false)
						&& ( rdbtnMr.isSelected() == true || rdbtnMiss.isSelected() == true || rdbtnMrs.isSelected() == true  || rdbtnDr.isSelected() == true  )
						
						
						) {
					lblErrors.setForeground(Color.black);
					lblErrors.setText("Thank You For Signing Up");
					try
					{
						//Wait a few seconds and then call loginpage
					    Thread.sleep(1000);
					    Login1 callLoginPage = new Login1();
					    callLoginPage.setVisible(true);;
					}
					catch(InterruptedException ex)
					{
					    Thread.currentThread().interrupt();
					}
					
				}
				
				//execute the query and add data into the data base over here
				if(lblErrors.getText().equals("Thank You For Signing Up")) {
					//push user into database 
					//take user bake to home page
				}
				
				
				
				// testing output
				/*
				System.out.println(title + " " + forname + " "+ surname + " " + university + " " + email +  " " + password); 
				System.out.println(checkNull(forname));
				System.out.println("is email valid" + validateEmail(email));
				*/
				

			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 16));
		button.setBounds(283, 532, 122, 25);
		contentPane.add(button);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login1 callHomePage = new Login1(); 
				callHomePage.setVisible(true);
			}
		});
		btnHomePage.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHomePage.setBounds(403, 532, 176, 25);
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
}

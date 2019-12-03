package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUP {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUP window = new SignUP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1054, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("SIGN UP PAGE");
		lblWelcomeToThe.setFont(new Font("Arial", Font.PLAIN, 50));
		lblWelcomeToThe.setBounds(275, 13, 413, 98);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(272, 124, 56, 16);
		frame.getContentPane().add(lblTitle);
		
		JTextArea txtrForename = new JTextArea();
		txtrForename.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrForename.setText("Forename");
		txtrForename.setBounds(357, 177, 187, 36);
		frame.getContentPane().add(txtrForename);
		
		JRadioButton rdbtnMr = new JRadioButton("Mr");
		rdbtnMr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMr.setBounds(357, 120, 62, 25);
		frame.getContentPane().add(rdbtnMr);
		
		JRadioButton rdbtnMiss = new JRadioButton("Miss");
		rdbtnMiss.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMiss.setBounds(423, 120, 62, 25);
		frame.getContentPane().add(rdbtnMiss);
		
		JRadioButton rdbtnMrs = new JRadioButton("Mrs");
		rdbtnMrs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMrs.setBounds(501, 120, 73, 25);
		frame.getContentPane().add(rdbtnMrs);
		
		JRadioButton rdbtnDr = new JRadioButton("Dr");
		rdbtnDr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnDr.setBounds(578, 120, 89, 25);
		frame.getContentPane().add(rdbtnDr);
		
		JTextArea txtrSurname = new JTextArea();
		txtrSurname.setText("Surname");
		txtrSurname.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrSurname.setBounds(357, 234, 187, 36);
		frame.getContentPane().add(txtrSurname);
		
		JTextArea txtrUniversity = new JTextArea();
		txtrUniversity.setText("University");
		txtrUniversity.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrUniversity.setBounds(357, 293, 187, 36);
		frame.getContentPane().add(txtrUniversity);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("Email");
		txtrEmail.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrEmail.setBounds(357, 352, 187, 36);
		frame.getContentPane().add(txtrEmail);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		txtrPassword.setBounds(357, 412, 187, 36);
		frame.getContentPane().add(txtrPassword);
		
		JRadioButton rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		rdbtnAuthor.setBounds(357, 478, 89, 25);
		frame.getContentPane().add(rdbtnAuthor);
		
		JRadioButton rdbtnEditor = new JRadioButton("Editor");
		rdbtnEditor.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		rdbtnEditor.setBounds(450, 478, 86, 25);
		frame.getContentPane().add(rdbtnEditor);
		
		JRadioButton rdbtnReviewer = new JRadioButton("Reviewer");
		rdbtnReviewer.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		rdbtnReviewer.setBounds(540, 478, 127, 25);
		frame.getContentPane().add( rdbtnReviewer);
		
		JLabel lblUserType = new JLabel("Sign up as:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserType.setBounds(254, 480, 105, 21);
		frame.getContentPane().add(lblUserType);
		
		
		//When the submit button is pressed on 
		//Data from the fields will be pushed into the database
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String title ; 
				if( rdbtnMr.isSelected()) {
					title = "Mr";
				}else if(rdbtnMiss.isSelected()) {
					title = "Miss";
					
				}else if (rdbtnMrs.isSelected())
				{
					title = "Mrs";
				}else {
					title = "Dr"; 
				}
				
				
				
				String forname = txtrForename.getText();
				String surname = txtrSurname.getText(); 
				String university =  txtrUniversity.getText();
				String email = txtrEmail.getText(); 
				String password = txtrPassword.getText(); 
				
				//Set all to false to initialise
				boolean author = false; 
				boolean reviewer = false; 
				boolean editor = false; 
				
				if(rdbtnReviewer.isSelected()) {
					reviewer = true; 
				}else if(rdbtnAuthor.isSelected()) {
					author = true; 
				}else {
					editor = true; 
				}
				
				// testing output 
				System.out.println(title + " " + forname + " "+ surname + " " + university + " " + email +  " " + password); 
				
				
			}
		});
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSubmit.setBounds(406, 537, 97, 25);
		frame.getContentPane().add(btnSubmit);
	}

}

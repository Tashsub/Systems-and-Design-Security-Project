package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class Login {

	private JFrame frmSystems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSystems.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSystems = new JFrame();
		frmSystems.setTitle("Systems");
		frmSystems.setBounds(100, 100, 891, 714);
		frmSystems.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSystems.getContentPane().setLayout(null);
		
		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrLogin.setText("Username");
		txtrLogin.setBounds(238, 128, 369, 77);
		frmSystems.getContentPane().add(txtrLogin);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrPassword.setText("Password");
		txtrPassword.setBounds(238, 233, 369, 77);
		frmSystems.getContentPane().add(txtrPassword);
		
		JRadioButton rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.setBounds(349, 366, 127, 25);
		frmSystems.getContentPane().add(rdbtnAuthor);
		
		JRadioButton rdbtnEditor = new JRadioButton("Editor");
		rdbtnEditor.setBounds(349, 408, 127, 25);
		frmSystems.getContentPane().add(rdbtnEditor);
		
		JRadioButton rdbtnReviewer = new JRadioButton("Reviewer");
		rdbtnReviewer.setBounds(349, 452, 127, 25);
		frmSystems.getContentPane().add(rdbtnReviewer);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(351, 534, 97, 25);
		frmSystems.getContentPane().add(btnLogin);
		
		JButton btnSignUpAs = new JButton("Sign Up As New User");
		btnSignUpAs.setBounds(277, 572, 245, 25);
		frmSystems.getContentPane().add(btnSignUpAs);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Arial", Font.PLAIN, 63));
		lblWelcome.setBounds(244, 13, 352, 118);
		frmSystems.getContentPane().add(lblWelcome);
		
		JLabel lblIfYouAre = new JLabel("Readers do not need a username and password");
		lblIfYouAre.setLabelFor(frmSystems);
		lblIfYouAre.setForeground(Color.BLACK);
		lblIfYouAre.setBackground(Color.WHITE);
		lblIfYouAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfYouAre.setToolTipText("");
		lblIfYouAre.setBounds(261, 323, 309, 34);
		frmSystems.getContentPane().add(lblIfYouAre);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Reader");
		rdbtnNewRadioButton.setBounds(349, 491, 127, 25);
		frmSystems.getContentPane().add(rdbtnNewRadioButton);
	}
}

package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login1 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
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
	public Login1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Arial Narrow", Font.PLAIN, 63));
		lblWelcome.setBounds(146, 13, 607, 96);
		contentPane.add(lblWelcome);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblUsername.setBounds(146, 122, 607, 60);
		lblUsername.setOpaque(true);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Arial Narrow", Font.PLAIN, 20));
		lblPassword.setBounds(146, 271, 607, 60);
		lblPassword.setOpaque(true);
		contentPane.add(lblPassword);
		
		JTextArea usernameTextArea = new JTextArea();
		usernameTextArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		usernameTextArea.setBackground(Color.LIGHT_GRAY);
		usernameTextArea.setForeground(Color.GRAY);
		usernameTextArea.setBounds(145, 183, 607, 55);
		contentPane.add(usernameTextArea);
		
		JLabel labelReader = new JLabel("Readers do not need a username and password");
		labelReader.setToolTipText("");
		labelReader.setHorizontalAlignment(SwingConstants.CENTER);
		labelReader.setForeground(Color.BLACK);
		labelReader.setBackground(Color.WHITE);
		labelReader.setBounds(296, 388, 309, 34);
		contentPane.add(labelReader);
		
		JRadioButton radioAuthor = new JRadioButton("Author");
		radioAuthor.setBounds(396, 431, 127, 25);
		contentPane.add(radioAuthor);
		
		JRadioButton radioEditor = new JRadioButton("Editor");
		radioEditor.setBounds(396, 467, 127, 25);
		contentPane.add(radioEditor);
		
		JRadioButton radioReviewer = new JRadioButton("Reviewer");
		radioReviewer.setBounds(396, 504, 127, 25);
		contentPane.add(radioReviewer);
		
		JRadioButton radioReader = new JRadioButton("Reader");
		radioReader.setBounds(396, 540, 127, 25);
		contentPane.add(radioReader);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setBounds(146, 591, 309, 25);
		contentPane.add(buttonLogin);
		
		JButton buttonSignUp = new JButton("Sign Up As New User");
		buttonSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonSignUp.setBounds(451, 591, 302, 25);
		contentPane.add(buttonSignUp);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(146, 330, 607, 60);
		contentPane.add(passwordField);
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}

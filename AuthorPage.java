import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AuthorPage extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthorPage frame = new AuthorPage();
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
	public AuthorPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 1500, 900);
		getContentPane().setLayout(null);
		
		//LABELS
		JLabel AuthorPage = new JLabel("Author Page");
		AuthorPage.setFont(new Font("Tahoma", Font.PLAIN, 33));
		AuthorPage.setBounds(633, 25, 202, 74);
		getContentPane().add(AuthorPage);
		
		JLabel lblShowTablesThat = new JLabel("Show articles that I am:");
		lblShowTablesThat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShowTablesThat.setBounds(38, 47, 215, 38);
		getContentPane().add(lblShowTablesThat);
		
		JLabel label = new JLabel("|");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(402, 51, 22, 33);
		getContentPane().add(label);
		
		//BUTTONS
		//btnSignOut
		JButton btnSignOut = new JButton("Log Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogInPage l = new LogInPage();
				l.setVisible(true);
			}
		});
		btnSignOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignOut.setBounds(1354, 47, 105, 43);
		getContentPane().add(btnSignOut);
		
		//btnSArticle
		JButton btnSArticle = new JButton("Submit New Article");
		btnSArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthorSubmitArticlePage s = new AuthorSubmitArticlePage();
				s.setVisible(true);
			}
		});
		btnSArticle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSArticle.setBounds(1073, 47, 238, 43);
		getContentPane().add(btnSArticle);
		
		//RadioButtons
		JRadioButton radioMainAuthor = new JRadioButton("Main Author");
		radioMainAuthor.setSelected(true);
		buttonGroup.add(radioMainAuthor);
		radioMainAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioMainAuthor.setBounds(261, 51, 142, 33);
		getContentPane().add(radioMainAuthor);
		
		JRadioButton radioAuthor = new JRadioButton("Author");
		buttonGroup.add(radioAuthor);
		radioAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioAuthor.setBounds(419, 51, 98, 33);
		getContentPane().add(radioAuthor);
		
		
	

	}
}

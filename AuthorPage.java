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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class AuthorPage extends JFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtEmail;
	private JTextField textField_1;

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
		
		//LAYERED PANE 
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 98, 1482, 755);
		getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		//PANEL MAIN AUTHOR
		JPanel panelMainAuthor = new JPanel();
		layeredPane.add(panelMainAuthor, "name_113590637770100");
		panelMainAuthor.setLayout(null);
		
		JButton btnPassRole = new JButton("Pass Role as Main Author");
		btnPassRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPassRole.setBounds(24, 51, 263, 29);
		panelMainAuthor.add(btnPassRole);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(83, 12, 204, 26);
		panelMainAuthor.add(txtEmail);
		
		JLabel labelEmail = new JLabel("email:");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelEmail.setBounds(24, 11, 60, 22);
		panelMainAuthor.add(labelEmail);
		
		JLabel labelResponse = new JLabel("response to a critisism:");
		labelResponse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelResponse.setBounds(335, 0, 219, 45);
		panelMainAuthor.add(labelResponse);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(418, 52, 116, 22);
		panelMainAuthor.add(textField_1);
		
		JLabel labelArticleID = new JLabel("Article ID");
		labelArticleID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelArticleID.setBounds(335, 53, 115, 21);
		panelMainAuthor.add(labelArticleID);
		
		JTextArea txtResponse = new JTextArea();
		txtResponse.setLineWrap(true);
		txtResponse.setBounds(546, 14, 781, 66);
		panelMainAuthor.add(txtResponse);
		
		JButton btnResponse = new JButton("Respond");
		btnResponse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnResponse.setBounds(1339, 13, 107, 25);
		panelMainAuthor.add(btnResponse);
		
		JPanel panelAuthor = new JPanel();
		layeredPane.add(panelAuthor, "name_113603667248100");
		panelAuthor.setLayout(null);
		
		JButton btnRetire = new JButton("Retire");
		btnRetire.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRetire.setBounds(38, 0, 105, 43);
		panelAuthor.add(btnRetire);
		
		//RADIOBUTTONS
		JRadioButton radioAuthor = new JRadioButton("Author");
		radioAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelAuthor);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		buttonGroup.add(radioAuthor);
		radioAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioAuthor.setBounds(419, 51, 98, 33);
		getContentPane().add(radioAuthor);
		
		
		JRadioButton radioMainAuthor = new JRadioButton("Main Author");
		radioMainAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelMainAuthor);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		radioMainAuthor.setSelected(true);
		buttonGroup.add(radioMainAuthor);
		radioMainAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioMainAuthor.setBounds(261, 51, 142, 33);
		getContentPane().add(radioMainAuthor);
		
	}
	
}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

public class ReviewerPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewerPage frame = new ReviewerPage();
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
	public ReviewerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LABELS
		JLabel lblReviewerPage = new JLabel("Reviewer Page");
		lblReviewerPage.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblReviewerPage.setBounds(632, 0, 223, 116);
		contentPane.add(lblReviewerPage);
		
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
		btnSignOut.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSignOut.setBounds(833, 41, 112, 41);
		contentPane.add(btnSignOut);
		
		JRadioButton rdbtnChampion = new JRadioButton("Champion");
		buttonGroup.add(rdbtnChampion);
		rdbtnChampion.setBounds(22, 115, 90, 25);
		contentPane.add(rdbtnChampion);
		
		JRadioButton rdbtnWeakAccept = new JRadioButton("weak accept");
		buttonGroup.add(rdbtnWeakAccept);
		rdbtnWeakAccept.setBounds(22, 145, 127, 25);
		contentPane.add(rdbtnWeakAccept);
		
		JRadioButton rdbtnWeakReject = new JRadioButton("weak reject");
		buttonGroup.add(rdbtnWeakReject);
		rdbtnWeakReject.setBounds(22, 178, 127, 25);
		contentPane.add(rdbtnWeakReject);
		
		JRadioButton rdbtnDitractor = new JRadioButton("ditractor");
		buttonGroup.add(rdbtnDitractor);
		rdbtnDitractor.setBounds(22, 208, 127, 25);
		contentPane.add(rdbtnDitractor);
		
		JRadioButton radioButton = new JRadioButton("ditractor");
		buttonGroup_1.add(radioButton);
		radioButton.setBounds(1135, 208, 127, 25);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("weak reject");
		buttonGroup_1.add(radioButton_1);
		radioButton_1.setBounds(1135, 178, 127, 25);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("weak accept");
		buttonGroup_1.add(radioButton_2);
		radioButton_2.setBounds(1135, 145, 127, 25);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Champion");
		buttonGroup_1.add(radioButton_3);
		radioButton_3.setBounds(1135, 115, 127, 25);
		contentPane.add(radioButton_3);
		
		JLabel lblFinalVerdict = new JLabel("final verdict:");
		lblFinalVerdict.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFinalVerdict.setBounds(1135, 65, 112, 41);
		contentPane.add(lblFinalVerdict);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSubmit.setBounds(1354, 145, 112, 32);
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBounds(1354, 116, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblArticleId = new JLabel("Article ID");
		lblArticleId.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblArticleId.setBounds(1263, 104, 90, 41);
		contentPane.add(lblArticleId);
		
		JLabel label = new JLabel("Article ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(122, 104, 90, 41);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(213, 116, 116, 22);
		contentPane.add(textField_1);
		
		JButton button = new JButton("submit");
		button.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button.setBounds(213, 145, 116, 32);
		contentPane.add(button);
		
		JLabel lblInitialVerdict = new JLabel("initial verdict:");
		lblInitialVerdict.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblInitialVerdict.setBounds(22, 65, 112, 41);
		contentPane.add(lblInitialVerdict);
		
		JLabel lblCritisism = new JLabel("critisism:");
		lblCritisism.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCritisism.setBounds(374, 40, 219, 45);
		contentPane.add(lblCritisism);
		
		JLabel label_2 = new JLabel("Article ID");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_2.setBounds(374, 93, 115, 21);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(457, 92, 116, 22);
		contentPane.add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(374, 137, 729, 80);
		contentPane.add(textArea);
		
		JButton button_1 = new JButton("Respond");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_1.setBounds(374, 230, 107, 25);
		contentPane.add(button_1);
		
		//BtnChangePass
		JButton btnChangePass = new JButton("Change Password");
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordPage c = new ChangePasswordPage();
				c.setVisible(true);
			}
		});
		btnChangePass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnChangePass.setBounds(957, 41, 146, 41);
		contentPane.add(btnChangePass);
	}
}

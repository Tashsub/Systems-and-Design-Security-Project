import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditorAddJournalPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtJournalIssn;
	private JTextField txtEmail;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtCounter;
	private int g;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorAddJournalPage frame = new EditorAddJournalPage();
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
	public EditorAddJournalPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 40, 1300, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelAddNewJournal = new JLabel("Add new Journal");
		labelAddNewJournal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelAddNewJournal.setBounds(205, 112, 199, 51);
		contentPane.add(labelAddNewJournal);
		
		JLabel labelTitle = new JLabel("Title : ");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelTitle.setBounds(47, 167, 61, 26);
		contentPane.add(labelTitle);
		
		JTextArea txtTitle = new JTextArea();
		txtTitle.setRows(10);
		txtTitle.setLineWrap(true);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitle.setDropMode(DropMode.INSERT);
		txtTitle.setColumns(10);
		txtTitle.setBounds(47, 206, 508, 45);
		contentPane.add(txtTitle);
		
		txtJournalIssn = new JTextField();
		txtJournalIssn.setToolTipText("");
		txtJournalIssn.setHorizontalAlignment(SwingConstants.LEFT);
		txtJournalIssn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtJournalIssn.setColumns(10);
		txtJournalIssn.setBounds(186, 278, 223, 40);
		contentPane.add(txtJournalIssn);
		
		JLabel labelJournaliSsn = new JLabel("Journal ISSN : ");
		labelJournaliSsn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelJournaliSsn.setBounds(47, 284, 142, 26);
		contentPane.add(labelJournaliSsn);
		
		JButton btnAddJournal = new JButton("ADD JOURNAL");
		btnAddJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTitle.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Title field is empty", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				else if (txtJournalIssn.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(null, "ISSN field is empty", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				//else if (here checks from database if journal ISSN can be found)(if it cannot be found) {
				//JOptionPane.showMessageDialog(null, "Journal Issn cannot be matched to an Issn that it already exists", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				else {
				dispose();
				JOptionPane.showMessageDialog(null, "Journal added!", "Added!", JOptionPane.INFORMATION_MESSAGE);
				//(here after everything is okay the article can b submitted to the database)
				}
			}
		});
		btnAddJournal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddJournal.setBounds(205, 361, 149, 45);
		contentPane.add(btnAddJournal);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(601, 157, 682, 783);
		contentPane.add(panel);
		
		JLabel labelTitle3 = new JLabel("Add Author to the Board");
		labelTitle3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelTitle3.setBounds(201, 30, 284, 51);
		panel.add(labelTitle3);
		
		JLabel labelAlreadyRegister = new JLabel("Already registered user");
		labelAlreadyRegister.setFont(new Font("Tahoma", Font.PLAIN, 23));
		labelAlreadyRegister.setBounds(214, 94, 271, 51);
		panel.add(labelAlreadyRegister);
		
		JLabel label_5 = new JLabel("Email  :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_5.setBounds(161, 169, 91, 23);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Title :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_6.setBounds(244, 360, 72, 23);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Forename : ");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_7.setBounds(187, 408, 127, 23);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Surname : ");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_8.setBounds(197, 452, 117, 23);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("University affiliation : ");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_9.setBounds(92, 494, 226, 23);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Email  :");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_10.setBounds(225, 540, 91, 23);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Confirm Email  :");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_11.setBounds(142, 581, 167, 23);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Password :");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_12.setBounds(191, 628, 119, 23);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("Confirm Password :");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_13.setBounds(108, 673, 189, 23);
		panel.add(label_13);
		
		JLabel labelTitle4 = new JLabel("Non-registered user");
		labelTitle4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		labelTitle4.setBounds(222, 285, 271, 51);
		panel.add(labelTitle4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(328, 360, 57, 31);
		panel.add(comboBox);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtEmail.setColumns(10);
		txtEmail.setBounds(264, 165, 271, 31);
		panel.add(txtEmail);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_2.setColumns(10);
		textField_2.setBounds(326, 404, 178, 31);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_3.setColumns(10);
		textField_3.setBounds(326, 448, 178, 31);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_4.setColumns(10);
		textField_4.setBounds(328, 492, 271, 31);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_5.setColumns(10);
		textField_5.setBounds(328, 536, 271, 31);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_6.setColumns(10);
		textField_6.setBounds(328, 580, 271, 31);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_7.setColumns(10);
		textField_7.setBounds(328, 624, 178, 31);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textField_8.setColumns(10);
		textField_8.setBounds(328, 669, 178, 31);
		panel.add(textField_8);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g++;
				txtCounter.setText(Integer.toString(g));
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(274, 221, 97, 31);
		panel.add(btnAdd);
		
		JButton btnAdd2 = new JButton("ADD");
		btnAdd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g++;
				txtCounter.setText(Integer.toString(g));
			}
		});
		btnAdd2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd2.setBounds(274, 739, 97, 31);
		panel.add(btnAdd2);
		
		JLabel lblBoardEditorsAdded = new JLabel("Board Editors added until now");
		lblBoardEditorsAdded.setForeground(Color.GRAY);
		lblBoardEditorsAdded.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBoardEditorsAdded.setBounds(815, 96, 333, 40);
		contentPane.add(lblBoardEditorsAdded);
		
		txtCounter = new JTextField();
		txtCounter.setText("0");
		txtCounter.setForeground(Color.GRAY);
		txtCounter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCounter.setColumns(10);
		txtCounter.setBackground(Color.WHITE);
		txtCounter.setBounds(781, 104, 32, 28);
		contentPane.add(txtCounter);
		
		JLabel labelTitle2 = new JLabel("Add Editor to the Board");
		labelTitle2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelTitle2.setBounds(788, 35, 284, 51);
		contentPane.add(labelTitle2);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(12, 35, 84, 33);
		contentPane.add(btnExit);
	}

}

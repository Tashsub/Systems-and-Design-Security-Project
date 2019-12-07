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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

public class AuthorSubmitArticlePage extends JFrame {

	private JPanel contentPane;
	private JTextField txtIssn;
	public static JTextField txtCounter;
	private JTextField txtEmail;
	private JTextField txtForename;
	private JTextField txtSurname;
	private JTextField txtUni;
	private JTextField txtEmailNon;
	private JTextField txtConfEmail;
	private JTextField txtPass;
	private JTextField txtConfPass;
	private int x;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthorSubmitArticlePage frame = new AuthorSubmitArticlePage();
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
	public AuthorSubmitArticlePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 40, 1400, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LABELS
		JLabel labelTitle2 = new JLabel("Submit Article Page");
		labelTitle2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelTitle2.setBounds(227, 30, 229, 53);
		contentPane.add(labelTitle2);
		
		JLabel labelTitle = new JLabel("Title : ");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelTitle.setBounds(24, 112, 61, 26);
		contentPane.add(labelTitle);
		
		JLabel labelAbstract = new JLabel("Abstract : ");
		labelAbstract.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelAbstract.setBounds(24, 208, 98, 26);
		contentPane.add(labelAbstract);
		
		JLabel labelISsn = new JLabel("Journal ISSN : ");
		labelISsn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelISsn.setBounds(160, 676, 142, 26);
		contentPane.add(labelISsn);
		
		JLabel label = new JLabel("Do you want to add a board of authors for the Article that you just submitted?");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(681, 30, 664, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Board Authors added until now");
		label_1.setForeground(Color.GRAY);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_1.setBounds(895, 92, 333, 40);
		contentPane.add(label_1);
		
		//txtCounter changes when an author is added to the board
		txtCounter = new JTextField();
		txtCounter.setText("0");
		txtCounter.setForeground(Color.GRAY);
		txtCounter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCounter.setColumns(10);
		txtCounter.setBackground(Color.WHITE);
		txtCounter.setBounds(861, 100, 32, 28);
		contentPane.add(txtCounter);
		
		//TEXTBOXES
		JTextArea txtTitle = new JTextArea();
		txtTitle.setRows(10);
		txtTitle.setLineWrap(true);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitle.setDropMode(DropMode.INSERT);
		txtTitle.setColumns(10);
		txtTitle.setBounds(24, 146, 631, 45);
		contentPane.add(txtTitle);
		
		JTextArea txtAbstract = new JTextArea();
		txtAbstract.setRows(10);
		txtAbstract.setLineWrap(true);
		txtAbstract.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAbstract.setDropMode(DropMode.INSERT);
		txtAbstract.setColumns(10);
		txtAbstract.setBounds(24, 247, 631, 400);
		contentPane.add(txtAbstract);
		
		txtIssn = new JTextField();
		txtIssn.setToolTipText("");
		txtIssn.setHorizontalAlignment(SwingConstants.LEFT);
		txtIssn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIssn.setColumns(10);
		txtIssn.setBounds(299, 670, 223, 40);
		contentPane.add(txtIssn);
		
		//BUTTONS
		//btnUpload PDF
		JButton btnPdf = new JButton("upload pdf");
		btnPdf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPdf.setBounds(265, 740, 113, 74);
		contentPane.add(btnPdf);
		
		//btnSubmit
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Testing
				if (txtTitle.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Title field is empty", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				else if (txtAbstract.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Abstract field is empty", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				else if (txtIssn.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Journal Issn field is empty", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				//else if (here checks from database if journal ISSN can be found)(if it cannot be found) {
					//JOptionPane.showMessageDialog(null, "Journal Issn cannot be matched to an Issn that it already exists", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				else {
					dispose();
					
					//(here after everything is okay the article can b submitted to the database)
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSubmit.setBounds(265, 827, 113, 74);
		contentPane.add(btnSubmit);
		
		//btnExit
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(24, 42, 81, 33);
		contentPane.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(700, 132, 682, 783);
		contentPane.add(panel);
		
		//LABELS FOR ADDING AUTHOR TO BOARD
		JLabel label_2 = new JLabel("Add Author to the Board");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_2.setBounds(201, 30, 284, 51);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("Already registered user");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_4.setBounds(214, 94, 271, 51);
		panel.add(label_4);
		
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
		
		JLabel label_14 = new JLabel("Non-registered user");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label_14.setBounds(222, 285, 271, 51);
		panel.add(label_14);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(328, 360, 57, 31);
		panel.add(comboBox);
		
		
		//TEXTBOXES FOR ADDING AUTHORS TO BOARD
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtEmail.setColumns(10);
		txtEmail.setBounds(264, 165, 271, 31);
		panel.add(txtEmail);
		
		txtForename = new JTextField();
		txtForename.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtForename.setColumns(10);
		txtForename.setBounds(326, 404, 178, 31);
		panel.add(txtForename);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtSurname.setColumns(10);
		txtSurname.setBounds(326, 448, 178, 31);
		panel.add(txtSurname);
		
		txtUni = new JTextField();
		txtUni.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtUni.setColumns(10);
		txtUni.setBounds(328, 492, 271, 31);
		panel.add(txtUni);
		
		txtEmailNon = new JTextField();
		txtEmailNon.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtEmailNon.setColumns(10);
		txtEmailNon.setBounds(328, 536, 271, 31);
		panel.add(txtEmailNon);
		
		txtConfEmail = new JTextField();
		txtConfEmail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtConfEmail.setColumns(10);
		txtConfEmail.setBounds(328, 580, 271, 31);
		panel.add(txtConfEmail);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtPass.setColumns(10);
		txtPass.setBounds(328, 624, 178, 31);
		panel.add(txtPass);
		
		txtConfPass = new JTextField();
		txtConfPass.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtConfPass.setColumns(10);
		txtConfPass.setBounds(328, 669, 178, 31);
		panel.add(txtConfPass);
		
		//BUTTONS FOR ADDIGN AUTHOR TO BOARD
		
		//ADD button when user already exists
		JButton btnAddEmail = new JButton("ADD");
		btnAddEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				x++;
				txtCounter.setText(Integer.toString(x));
			}
		});
		btnAddEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddEmail.setBounds(274, 221, 97, 31);
		panel.add(btnAddEmail);
		
		//ADD when you register the user now
		JButton btnAddNon = new JButton("ADD");
		btnAddNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x++;
				txtCounter.setText(Integer.toString(x));
			}
		});
		btnAddNon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddNon.setBounds(274, 739, 97, 31);
		panel.add(btnAddNon);
	}
}

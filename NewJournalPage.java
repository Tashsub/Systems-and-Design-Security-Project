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

public class NewJournalPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtIssn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewJournalPage frame = new NewJournalPage();
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
	public NewJournalPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(720, 260, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelAddNewJournal = new JLabel("Add new Journal");
		labelAddNewJournal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelAddNewJournal.setBounds(170, 33, 199, 51);
		contentPane.add(labelAddNewJournal);
		
		JLabel labelTitle = new JLabel("Title : ");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelTitle.setBounds(12, 88, 61, 26);
		contentPane.add(labelTitle);
		
		JTextArea txtTitle = new JTextArea();
		txtTitle.setRows(10);
		txtTitle.setLineWrap(true);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitle.setDropMode(DropMode.INSERT);
		txtTitle.setColumns(10);
		txtTitle.setBounds(12, 127, 508, 45);
		contentPane.add(txtTitle);
		
		JLabel labelJournalIssn = new JLabel("Journal ISSN : ");
		labelJournalIssn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelJournalIssn.setBounds(12, 205, 142, 26);
		contentPane.add(labelJournalIssn);
		
		txtIssn = new JTextField();
		txtIssn.setToolTipText("");
		txtIssn.setHorizontalAlignment(SwingConstants.LEFT);
		txtIssn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIssn.setColumns(10);
		txtIssn.setBounds(151, 199, 223, 40);
		contentPane.add(txtIssn);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEditorPage.a = 0;
				if (txtTitle.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Title field is empty", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				else if (txtIssn.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(null, "ISSN field is empty", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				//else if (here checks from database if journal ISSN can be found)(if it cannot be found) {
				//JOptionPane.showMessageDialog(null, "Journal Issn cannot be matched to an Issn that it already exists", "Problem!", JOptionPane.INFORMATION_MESSAGE);}
				else {
				dispose();
				JournalAddedPage j = new JournalAddedPage();
				j.setVisible(true);
				//(here after everything is okay the article can b submitted to the database)
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(205, 294, 97, 31);
		contentPane.add(btnAdd);
	}
}

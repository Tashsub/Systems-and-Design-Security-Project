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

public class SubmitArticlePage extends JFrame {

	private JPanel contentPane;
	private JTextField txtIssn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubmitArticlePage frame = new SubmitArticlePage();
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
	public SubmitArticlePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(630, 140, 700, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LABELS
		JLabel labelSubmitArticle = new JLabel("Submit Article Page");
		labelSubmitArticle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelSubmitArticle.setBounds(226, 30, 229, 53);
		contentPane.add(labelSubmitArticle);
		
		JLabel labelTitle = new JLabel("Title : ");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelTitle.setBounds(24, 90, 61, 26);
		contentPane.add(labelTitle);
		
		JLabel labelAbstract = new JLabel("Abstract : ");
		labelAbstract.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelAbstract.setBounds(24, 186, 98, 26);
		contentPane.add(labelAbstract);
		
		JLabel labelJournalISSN = new JLabel("Journal ISSN : ");
		labelJournalISSN.setFont(new Font("Tahoma", Font.PLAIN, 21));
		labelJournalISSN.setBounds(24, 667, 142, 26);
		contentPane.add(labelJournalISSN);
		
		//TEXTBOXES
		JTextArea txtTitle = new JTextArea();
		txtTitle.setRows(10);
		txtTitle.setLineWrap(true);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitle.setDropMode(DropMode.INSERT);
		txtTitle.setColumns(10);
		txtTitle.setBounds(24, 124, 631, 45);
		contentPane.add(txtTitle);
		
		JTextArea txtAbstract = new JTextArea();
		txtAbstract.setRows(10);
		txtAbstract.setLineWrap(true);
		txtAbstract.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAbstract.setDropMode(DropMode.INSERT);
		txtAbstract.setColumns(10);
		txtAbstract.setBounds(24, 225, 631, 400);
		contentPane.add(txtAbstract);
		
		txtIssn = new JTextField();
		txtIssn.setToolTipText("");
		txtIssn.setHorizontalAlignment(SwingConstants.LEFT);
		txtIssn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIssn.setColumns(10);
		txtIssn.setBounds(163, 661, 223, 40);
		contentPane.add(txtIssn);
		
		//BUTTONS
		
		//btnPDF
		JButton btnPDF = new JButton("upload pdf");
		btnPDF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPDF.setBounds(417, 644, 113, 74);
		contentPane.add(btnPDF);
		
		//btnSubmitArticle
		JButton btnSubmitArticle = new JButton("Submit");
		btnSubmitArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAuthorPage.i = 0 ; // resets i to 0 which is used for the counter for adding board members 
				
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
					ArticleAddedPage a = new ArticleAddedPage();
					a.setVisible(true);
					//(here after everything is okay the article can b submitted to the database)
				}
			}
		});
		btnSubmitArticle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSubmitArticle.setBounds(542, 644, 113, 74);
		contentPane.add(btnSubmitArticle);
	}
}

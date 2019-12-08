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
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class EditorPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtArticleID;
	private JTextField txtArticleIDEditor;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorPage frame = new EditorPage();
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
	public EditorPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnSignOut.setBounds(1307, 22, 108, 41);
		contentPane.add(btnSignOut);
		
		JLabel label = new JLabel("Show articles that I am:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(12, 22, 215, 38);
		contentPane.add(label);
		
		JLabel labelTitle = new JLabel("Editor Page");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 33));
		labelTitle.setBounds(607, 0, 202, 74);
		contentPane.add(labelTitle);
		
		JButton btnAddNewJournal = new JButton("Add New Journal");
		btnAddNewJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditorAddJournalPage r = new EditorAddJournalPage();
				r.setVisible(true);
			}
		});
		btnAddNewJournal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddNewJournal.setBounds(1047, 22, 238, 43);
		contentPane.add(btnAddNewJournal);
		
		JLabel label_1 = new JLabel("|");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(374, 22, 22, 33);
		contentPane.add(label_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 90, 1482, 763);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelChiefEditor = new JPanel();
		layeredPane.add(panelChiefEditor, "name_115276133281300");
		panelChiefEditor.setLayout(null);
		
		JButton btnPassRole = new JButton("Pass Role as Main Author");
		btnPassRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPassRole.setBounds(12, 53, 263, 29);
		panelChiefEditor.add(btnPassRole);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(71, 14, 204, 26);
		panelChiefEditor.add(txtEmail);
		
		JLabel labelEmail = new JLabel("email:");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		labelEmail.setBounds(12, 13, 60, 22);
		panelChiefEditor.add(labelEmail);
		
		JLabel lblFinalDes = new JLabel("Final Decision :");
		lblFinalDes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFinalDes.setBounds(363, 0, 154, 40);
		panelChiefEditor.add(lblFinalDes);
		
		txtArticleID = new JTextField();
		txtArticleID.setColumns(10);
		txtArticleID.setBounds(621, 9, 204, 26);
		panelChiefEditor.add(txtArticleID);
		
		JLabel lblArticleId = new JLabel("Article ID");
		lblArticleId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblArticleId.setBounds(519, 0, 108, 40);
		panelChiefEditor.add(lblArticleId);
		
		JButton btnPublish = new JButton("Publish");
		btnPublish.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPublish.setBounds(848, 10, 108, 29);
		panelChiefEditor.add(btnPublish);
		
		JPanel panelEditor = new JPanel();
		layeredPane.add(panelEditor, "name_115272375316100");
		panelEditor.setLayout(null);
		
		JLabel labelFinalDecision = new JLabel("Final Decision :");
		labelFinalDecision.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelFinalDecision.setBounds(362, 0, 154, 40);
		panelEditor.add(labelFinalDecision);
		
		JLabel labelArticleiD = new JLabel("Article ID");
		labelArticleiD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelArticleiD.setBounds(518, 0, 108, 40);
		panelEditor.add(labelArticleiD);
		
		txtArticleIDEditor = new JTextField();
		txtArticleIDEditor.setColumns(10);
		txtArticleIDEditor.setBounds(620, 9, 204, 26);
		panelEditor.add(txtArticleIDEditor);
		
		JButton btnPublishEditor = new JButton("Publish");
		btnPublishEditor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPublishEditor.setBounds(847, 10, 108, 29);
		panelEditor.add(btnPublishEditor);
		
		JButton btnRetire = new JButton("Retire");
		btnRetire.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnRetire.setBounds(12, 13, 108, 41);
		panelEditor.add(btnRetire);
		JRadioButton radioChiefEditor = new JRadioButton("Chief Editor");
		radioChiefEditor.setSelected(true);
		buttonGroup.add(radioChiefEditor);
		radioChiefEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelChiefEditor);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		radioChiefEditor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioChiefEditor.setBounds(235, 26, 142, 33);
		contentPane.add(radioChiefEditor);
		
		JRadioButton radioEditor = new JRadioButton("Editor");
		buttonGroup.add(radioEditor);
		radioEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelEditor);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		radioEditor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioEditor.setBounds(393, 26, 98, 33);
		contentPane.add(radioEditor);
	}

}

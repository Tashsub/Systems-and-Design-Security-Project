package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Component;

public class Print extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Print frame = new Print();
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
	public Print() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrint = new JButton("print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Title \t     JournalISSN \t Volume \t Edition \t PageNum \t ChiefEditor\n");
						//
				try {
					openConnection();
		   	        ResultSet res = stmt.executeQuery("SELECT * FROM Journal");
		 //  	      System.out.format("%50s%50s%50s%50s%100s%50s\n", "Title", "JournalISSN", "Volume", "Edition", "PageNum", "ChiefEditor");
		   	        while (res.next()) {
		   	        	String title = res.getString("title");
		   		        int journalISSN = res.getInt("journalISSN");
		   		        String volume = res.getString("volume");
		   		        String edition = res.getString("edition");
		   		        int pageNum = res.getInt("pageNum");
		   		        String chiefEditor = res.getString("chiefEditor");
		   		        textArea.append(title +"\t"+journalISSN+"\t"+volume+"\t"+edition+"\t"+pageNum+"\t"+chiefEditor+"\n"); 
		   		        
		   		  //      System.out.format("%50s%50d%50s%50s%100d%50s\n", title, journalISSN, volume, edition, pageNum, chiefEditor);
		   	        }
		   	    res.close();
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(10, 10, 85, 21);
		contentPane.add(btnPrint);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 50, 849, 609);
		contentPane.add(textArea);
	}
	
	//Database credentials
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team037";
    static final String USER = "team037";
    static final String PASS = "d84f5e63";
    static Connection conn = null;
    static Statement stmt = null;
    private JTextArea textArea;

    public static void openConnection() throws SQLException, ClassNotFoundException {
  		Class.forName("org.gjt.mm.mysql.Driver");
  		conn = DriverManager.getConnection(DB_URL, USER, PASS);
  		stmt = conn.createStatement();
  	}
}

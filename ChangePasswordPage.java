import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChangePasswordPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtOldPass;
	private JTextField txtNewPass;
	private JTextField txtConfNewPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordPage frame = new ChangePasswordPage();
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
	public ChangePasswordPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 300, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChangePassword.setBounds(140, 13, 165, 54);
		contentPane.add(lblChangePassword);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOldPassword.setBounds(152, 80, 165, 54);
		contentPane.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPassword.setBounds(152, 172, 165, 54);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmNewPassword.setBounds(110, 264, 224, 54);
		contentPane.add(lblConfirmNewPassword);
		
		txtOldPass = new JTextField();
		txtOldPass.setBounds(97, 131, 234, 34);
		contentPane.add(txtOldPass);
		txtOldPass.setColumns(10);
		
		txtNewPass = new JTextField();
		txtNewPass.setColumns(10);
		txtNewPass.setBounds(97, 220, 234, 34);
		contentPane.add(txtNewPass);
		
		txtConfNewPass = new JTextField();
		txtConfNewPass.setColumns(10);
		txtConfNewPass.setBounds(97, 312, 234, 34);
		contentPane.add(txtConfNewPass);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnChange.setBounds(168, 359, 97, 25);
		contentPane.add(btnChange);
	}

}

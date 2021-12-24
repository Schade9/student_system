package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JTextField emailtextField;
	private JPasswordField passwordField;
	private JPasswordField confirmpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setBounds(184, 12, 110, 15);
		contentPane.add(lblRegister);
		
		// username
		JLabel usernamelabel = new JLabel("Username");
		usernamelabel.setBounds(55, 38, 92, 15);
		contentPane.add(usernamelabel);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(204, 36, 114, 19);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);
		
		// email
		JLabel emaillabel = new JLabel("Email");
		emaillabel.setBounds(55, 65, 70, 15);
		contentPane.add(emaillabel);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(204, 64, 114, 17);
		contentPane.add(emailtextField);
		emailtextField.setColumns(10);
		
		// password
		JLabel passwordlabel = new JLabel("Password");
		passwordlabel.setBounds(55, 91, 70, 15);
		contentPane.add(passwordlabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 89, 114, 19);
		contentPane.add(passwordField);
		
		// confirm password
		JLabel confirmPasswordlabel = new JLabel("Confirm password");
		confirmPasswordlabel.setBounds(55, 130, 128, 15);
		contentPane.add(confirmPasswordlabel);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(201, 128, 117, 19);
		contentPane.add(confirmpasswordField);
		
		JButton registerbtn = new JButton("Register");
		registerbtn.setBackground(Color.GREEN);
		registerbtn.setBounds(201, 166, 117, 25);
		contentPane.add(registerbtn);
		
		registerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_sytem?useSSL=false","root","");
					System.out.println("Connection to db established");
					
					String username = usernametextField.getText().toString();
					String email = emailtextField.getText().toString();
					String password1 = passwordField.getText().toString();
					String password2 = confirmpasswordField.getText().toString();
					
					if (password1.equals(password2)) {
						PreparedStatement ps = con.prepareStatement("INSERT INTO teachers(username,email,password) VALUES (?,?,?)");
						
						ps.setString(1, username);
						ps.setString(2,  email);
						ps.setString(3, password2);
						
						ps.executeUpdate();
						ps.close();
						
						dispose(); // close registration page
						Login login = new Login();
						login.setVisible(true);
						
						
					} else {
						//JOptionPane.showMessageDialog(this, "Passwords do not match");
						System.out.println("Passwords do not match");
						passwordField.setText("");
						confirmpasswordField.setText("");
					}
					
					
					
					con.close();	
					
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
	}
}

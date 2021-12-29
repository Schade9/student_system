package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class StudentLogin extends JFrame {
	
	private JPanel contentPane;
	private JTextField firstnametextField;
	private JTextField passwordtextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create frame
	 */
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN AS STUDENT");
		lblLogin.setBounds(157, 12, 170, 15);
		contentPane.add(lblLogin);
		
		// username
		JLabel lblFirstname = new JLabel("First name");
		lblFirstname.setBounds(74, 52, 98, 15);
		contentPane.add(lblFirstname);
		
		firstnametextField = new JTextField();
		firstnametextField.setBounds(187, 50, 114, 19);
		contentPane.add(firstnametextField);
		firstnametextField.setColumns(10);
		
		// password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 93, 85, 15);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 91, 114, 19);
		contentPane.add(passwordField);

		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setBounds(159, 122, 85, 25);
		contentPane.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_sytem?useSSL=false","root","");
					System.out.println("Connection to db established");
					
					String first_name = firstnametextField.getText().toString();
					String password = passwordField.getText().toString();
					
					Statement stm = con.createStatement();
					String sql = "Select * from students where first_name='"+first_name+"' and registration_number='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					
					if(rs.next()) {
						// if username and password is true
						dispose(); // close login page
						StudentDashboard dash = new StudentDashboard();
						dash.setVisible(true);
					} else {
						// if username and password is false
						//JOptionPane.showMessageDialog(this, "username or password wrong..");
						System.out.println("username or password wrong");
						firstnametextField.setText("");
						passwordField.setText("");
					}
					
					con.close();	
					
				} catch(Exception d) {
					System.out.println(d.getMessage());
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(272, 122, 85, 25);
		contentPane.add(btnReset);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnametextField.setText("");
				passwordtextField.setText("");
			}
		});
		
		JButton btnLoginAsTeacher = new JButton("Login as teacher");
		btnLoginAsTeacher.setBounds(184, 162, 153, 25);
		contentPane.add(btnLoginAsTeacher);
		
		btnLoginAsTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
	}
}

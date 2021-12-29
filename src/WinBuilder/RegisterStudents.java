package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
public class RegisterStudents extends JFrame {

	private JPanel contentPane;
	private final JLabel lblRegisterStudent = new JLabel("REGISTER STUDENT");
	private JTextField firstNametextField;
	private JTextField lastNametextField;
	private JTextField regNumbertextField;
	private JTextField ageTextField;
	private JTextField classtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterStudents frame = new RegisterStudents();
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
	public RegisterStudents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		lblRegisterStudent.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRegisterStudent.setBounds(5, 5, 440, 15);
		lblRegisterStudent.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRegisterStudent);
		
		// first name
		JLabel first_name = new JLabel("First Name");
		first_name.setBounds(35, 32, 95, 15);
		contentPane.add(first_name);
		
		firstNametextField = new JTextField();
		firstNametextField.setBounds(148, 32, 114, 19);
		contentPane.add(firstNametextField);
		firstNametextField.setColumns(10);
		
		// last name
		JLabel last_name = new JLabel("Last Name");
		last_name.setBounds(35, 56, 95, 15);
		contentPane.add(last_name);
		
		lastNametextField = new JTextField();
		lastNametextField.setBounds(148, 56, 114, 19);
		contentPane.add(lastNametextField);
		lastNametextField.setColumns(10);
		
		// registration number
		JLabel reg_number = new JLabel("Reg number");
		reg_number.setBounds(35, 80, 114, 15);
		contentPane.add(reg_number);
		
		regNumbertextField = new JTextField();
		regNumbertextField.setBounds(148, 80, 114, 19);
		contentPane.add(regNumbertextField);
		regNumbertextField.setColumns(10);
		
		// gender
		JLabel gender = new JLabel("Gender");
		gender.setBounds(35, 104, 70, 15);
		contentPane.add(gender);
		
		JComboBox genderBox = new JComboBox();
		genderBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderBox.setBounds(148, 104, 114, 24);
		contentPane.add(genderBox);
		
		// age
		JLabel age = new JLabel("Age");
		age.setBounds(35, 130, 70, 15);
		contentPane.add(age);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(148, 130, 114, 19);
		contentPane.add(ageTextField);
		ageTextField.setColumns(10);
		
		// subject
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(35, 151, 70, 15);
		contentPane.add(lblSubject);
		
		JComboBox subjectBox = new JComboBox();
		subjectBox.setModel(new DefaultComboBoxModel(new String[] {"Mathematics", "Science", "SST", "English"}));
		subjectBox.setBounds(148, 150, 114, 24);
		contentPane.add(subjectBox);
		
		// class
		JLabel stclass = new JLabel("Class");
		stclass.setBounds(35, 178, 70, 15);
		contentPane.add(stclass);
		
		classtextField = new JTextField();
		classtextField.setBounds(148, 178, 114, 19);
		contentPane.add(classtextField);
		classtextField.setColumns(10);
		
		// buttons
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.setBounds(128, 202, 83, 25);
		contentPane.add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNametextField.getText().toString();
				String lastName = lastNametextField.getText().toString();
				String regNumber = regNumbertextField.getText().toString();
				String gender = String.valueOf(genderBox.getSelectedItem());
				String age = ageTextField.getText().toString();
				String subject = String.valueOf(subjectBox.getSelectedItem());
				String studentClass = classtextField.getText().toString();
				
				try {	
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_sytem?useSSL=false","root","");
					System.out.println("Connection to db established");
					
					PreparedStatement ps = con.prepareStatement("INSERT INTO students(first_name, last_name, registration_number, gender, age, subject, stclass) VALUES(?,?,?,?,?,?,?)");
					ps.setString(1, firstName);
					ps.setString(2, lastName);
					ps.setString(3, regNumber);
					ps.setString(4, gender);
					ps.setString(5, age);
					ps.setString(6, subject);
					ps.setString(7, studentClass);
					
					ps.executeUpdate();
					ps.close();
					
					dispose(); // close register Students
					RegisteredStudents regs = new RegisteredStudents();
					regs.setVisible(true);
					
				} catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(236, 202, 83, 25);
		contentPane.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});	
	}
}

package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class StudentDetails extends JFrame {

	private JPanel contentPane;
	private final JLabel lblRegisterStudent = new JLabel("REGISTER STUDENT");
	private JTextField firstNametextField;
	private JTextField lastNametextField;
	private JTextField regNumbertextField;
	private JTextField ageTextField;
	private JTextField subjecttextField;
	private JTextField classtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
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
	public StudentDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		JLabel subject = new JLabel("Subject");
		subject.setBounds(35, 154, 70, 15);
		contentPane.add(subject);
		
		subjecttextField = new JTextField();
		subjecttextField.setBounds(148, 154, 114, 19);
		contentPane.add(subjecttextField);
		subjecttextField.setColumns(10);
		
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
				String subject = subjecttextField.getText().toString();
				String studentClass = stclass.getText().toString();
				
				System.out.println("Hey you clicked submit button");
				System.out.format("%s", gender);
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

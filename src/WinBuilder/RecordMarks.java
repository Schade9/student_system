package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class RecordMarks extends JFrame {

	private JPanel contentPane;
	private JTextField regnumbertextField;
	private JTextField mathtextField;
	private JTextField sciencetextField;
	private JTextField englishtextField;
	private JTextField ssttextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordMarks frame = new RecordMarks();
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
	public RecordMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecordStudentMarks = new JLabel("RECORD STUDENT MARKS");
		lblRecordStudentMarks.setBounds(116, 12, 188, 15);
		contentPane.add(lblRecordStudentMarks);
		
		// registration number
		JLabel lblRegistrationNumber = new JLabel("Registration number");
		lblRegistrationNumber.setBounds(45, 41, 153, 15);
		contentPane.add(lblRegistrationNumber);
		
		regnumbertextField = new JTextField();
		regnumbertextField.setBounds(216, 37, 114, 19);
		contentPane.add(regnumbertextField);
		regnumbertextField.setColumns(10);
		
		// mathematics
		JLabel lblMathematics = new JLabel("Mathematics");
		lblMathematics.setBounds(45, 70, 91, 15);
		contentPane.add(lblMathematics);
		
		mathtextField = new JTextField();
		mathtextField.setBounds(216, 68, 114, 19);
		contentPane.add(mathtextField);
		mathtextField.setColumns(10);
		
		// science
		JLabel lblScience = new JLabel("Science");
		lblScience.setBounds(45, 101, 70, 15);
		contentPane.add(lblScience);
		
		sciencetextField = new JTextField();
		sciencetextField.setBounds(216, 99, 114, 19);
		contentPane.add(sciencetextField);
		sciencetextField.setColumns(10);
		
		// english
		JLabel lblEnglish = new JLabel("English");
		lblEnglish.setBounds(45, 128, 70, 15);
		contentPane.add(lblEnglish);
		
		englishtextField = new JTextField();
		englishtextField.setBounds(216, 126, 114, 19);
		contentPane.add(englishtextField);
		englishtextField.setColumns(10);
		
		// sst
		JLabel lblSst = new JLabel("SST");
		lblSst.setBounds(45, 160, 70, 15);
		contentPane.add(lblSst);
		
		ssttextField = new JTextField();
		ssttextField.setBounds(216, 158, 114, 19);
		contentPane.add(ssttextField);
		ssttextField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.setBounds(161, 189, 91, 25);
		contentPane.add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regno = regnumbertextField.getText().toString();
				String math = mathtextField.getText().toString();
				String sci = sciencetextField.getText().toString();
				String eng = englishtextField.getText().toString();
				String socialstudies = ssttextField.getText().toString();
				
				int mathematics = Integer.parseInt(math);
				int science = Integer.parseInt(sci);
				int english = Integer.parseInt(eng);
				int sst = Integer.parseInt(socialstudies);
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_sytem?useSSL=false","root","");
					String query = "UPDATE students SET Mathematics=?, Science=?, English=?, SST=? where registration_number=?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1,  mathematics);
					ps.setInt(2, science);
					ps.setInt(3, english);
					ps.setInt(4, sst);
					ps.setString(5, regno);
					
					ps.executeUpdate();
					ps.close();
					
					dispose();
					Dashboard dash = new Dashboard();
					dash.setVisible(true);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(296, 189, 91, 25);
		contentPane.add(btnReset);
	
	}
}

package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class RegisteredStudents extends JFrame {

	private JPanel contentPane;
	private final JLabel lblRegisteredStudents = new JLabel("REGISTERED STUDENTS");
	private DefaultTableModel model;
		JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteredStudents frame = new RegisteredStudents();
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
	public RegisteredStudents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblRegisteredStudents.setBounds(143, 12, 174, 33);
		contentPane.add(lblRegisteredStudents);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 52, 544, 299);
		contentPane.add(panel);
		
		try {
			Connection con = new DbConnection().getDbConnection();
			
			String sql = "SELECT * FROM students";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			String columns[] = {"First name", "Last name", "Registration number", "Gender", "Age", "Subject", "Class"};
			String data[][] = new String[8][7];
			
			int i = 0;
			while(rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String reg_number = rs.getString("registration_number");
				String gender = rs.getString("gender");
				String age = rs.getString("age");
				String subject = rs.getString("subject");
				String stclass = rs.getString("stclass");
				
				data[i][0] = first_name + "";
				data[i][1] = last_name;
				data[i][2] = reg_number + "";
				data[i][3] = gender;
				data[i][4] = age + "";
				data[i][5] = subject;
				data[i][6] = stclass + "";
				
				System.out.println("Name " + first_name);
				i++;
			}
			
			frame = new JFrame();
			model = new DefaultTableModel(data,columns);
			JTable table = new JTable (model);
			table.setShowGrid(true);
			table.setShowHorizontalLines(true);
			table.setShowVerticalLines(true);
			table.setGridColor(Color.BLACK);
			panel.add(table);
		} catch(Exception ex) {
			System.out.println((ex.getMessage()));
		}
		
	}
}

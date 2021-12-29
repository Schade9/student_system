package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashboard = new JLabel("DASHBOARD");
		lblDashboard.setBounds(176, 0, 119, 23);
		contentPane.add(lblDashboard);
		
		// register students
		JButton btnRegisterStudents = new JButton("REGISTER STUDENTS");
		btnRegisterStudents.setBounds(53, 37, 192, 25);
		contentPane.add(btnRegisterStudents);
		
		btnRegisterStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // close dashboard page
				RegisterStudents rstudent = new RegisterStudents();
				rstudent.setVisible(true);
			}
		});
		
		// record marks
		JButton btnRecordMarks = new JButton("RECORD MARKS");
		btnRecordMarks.setBounds(53, 118, 192, 25);
		contentPane.add(btnRecordMarks);
		
		btnRecordMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RecordMarks rm = new RecordMarks();
				rm.setVisible(true);
			}
		});
		
		// view registered students
		JButton btnStudents = new JButton("STUDENTS");
		btnStudents.setBounds(53, 77, 192, 25);
		contentPane.add(btnStudents);
		
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ed) {
				dispose();
				RegisteredStudents regst = new RegisteredStudents();
				regst.setVisible(true);
			}
		});
	}
}

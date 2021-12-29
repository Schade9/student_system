package WinBuilder;

import java.sql.*;
import java.util.ArrayList;

public interface StudentsMarksImpl {
	public void create() throws SQLException;
	//void retrieve() throws SQLException;
	ArrayList<StudentDetails> retrieve() throws SQLException;
	public void update() throws SQLException;
	public void delete() throws SQLException;

}

package FinalExercise;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class FinalTest
{

public static void main(String[] args)
{

Application myApplicaton = new Application();
myApplicaton.create();

}

}

class Application extends JFrame
{

//database connection
public Connection connect(String user, String password)
{
		Connection con = null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD", user, password);
	}
	catch(ClassNotFoundException e)
	{
		JOptionPane.showMessageDialog(null, e.getMessage());
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		JOptionPane.showMessageDialog(null, e.getMessage());
		e.printStackTrace();
	}
	return con;
}

public void disconnect(Connection c)
{
	try
	{
		if(c != null)
			c.close();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}

//search value entered in the text area and display it.
public void searchTable(Connection c)
{
	PreparedStatement searchCityStatement = null;
	String searchQuery = "SELECT * FROM employee WHERE CITY = ?";
	try
	{
		c.setAutoCommit(false);
		searchCityStatement = c.prepareStatement(searchQuery);
		searchCityStatement.setString(1, _inputTextBox.getText());
		ResultSet result = searchCityStatement.executeQuery();
		ResultSetMetaData md = result.getMetaData();
		@SuppressWarnings("unused")
		int row = 0;
		String records = "";
		while(result.next())
		{
			for(int i = 1; i <= md.getColumnCount(); i++)
			{
				records += result.getString(i) + "\t";
			}
			records += "\n";
			row += 1;
		}

		_displayArea.setText(records);
		c.commit();
	}
	catch (SQLException e)
	{
		JOptionPane.showMessageDialog(null, e.getMessage());
		e.printStackTrace();
	}
	
}

private class DisplayButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String user = "COMP228_m22_sl_31";
		String password = "password";
		Connection con =null;
		try
		{
			con = connect(user, password);
			if(con != null)
				searchTable(con);
		}
		finally
		{
			disconnect(con);
		}
	}
}


private static final long serialVersionUID = 1L;
private static final JPanel _panelOne = new JPanel();
private static final JPanel _panelTwo = new JPanel();
private static final JPanel _panelThree = new JPanel();
private static final JPanel _panelFour = new JPanel();
private static final JLabel _title = new JLabel("Select Epmloyees by city:");
private static final JTextField _inputTextBox = new JTextField();
private static final JButton _display = new JButton("Display");
private static final JTextArea _displayArea = new JTextArea(20,500);
private static final JScrollPane _dispScroll = new JScrollPane(_displayArea);

public void create()
{
	JFrame frame = new JFrame();
	frame.setSize(700,200);
	_displayArea.setEditable(false);
	_dispScroll.setSize(new Dimension(20,20));
	_dispScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	_panelOne.setLayout(new GridLayout(2,1));
	_panelTwo.setLayout(new GridLayout(2,2));
	_panelThree.setLayout(new FlowLayout());
	_panelFour.setLayout(new GridLayout(1,2));
	_panelTwo.add(_title);
	_panelTwo.add(_inputTextBox);
	_panelTwo.add(_panelFour);
	_panelTwo.add(_display);
	_panelOne.add(_panelTwo);
	_panelOne.add(_dispScroll);





	DisplayButtonHandler displayBtnHandler = new DisplayButtonHandler();
	_display.addActionListener(displayBtnHandler);

	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	frame.add(_panelOne);
	frame.setVisible(true);
}
}


package Java;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import Java.Jdbc;

public class Login implements ActionListener {
	JFrame frame;
	JPasswordField password;
	JLabel label, password1, l;
	JPanel panel;
	JButton button;
	JTextField username, textfield2;
	ActionEvent e;
	ImageIcon image, image1;

	JOptionPane pane;
	boolean f = true;
	Jdbc connection_string = new Jdbc();

	Login() {
		Font font = new Font(Font.SERIF, Font.BOLD, 20);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JFrame frame = new JFrame("LOGIN PAGE");
		frame.setFont(font);
		frame.setBounds(400, 97, 540, 360);
		frame.add(panel);
		frame.setResizable(false);
		image = new ImageIcon("src/images/login.jpg");

		l = new JLabel();
		l.setBounds(0, 0, 540, 360);
		l.setIcon(image);
		label = new JLabel("Username");
		label.setBounds(280, 105, 70, 20);

		panel.add(label);
		username = new JTextField();
		username.setBounds(280, 127, 193, 28);

		panel.add(username);
		password1 = new JLabel("Password");
		password1.setBounds(280, 155, 70, 20);
		panel.add(password1);
		password = new JPasswordField();
		password.setBounds(280, 180, 193, 28);
		panel.add(password);
		button = new JButton("Login");
//		button.setVisible(true);
		button.setBounds(280, 230, 90, 25);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		panel.add(button);

		button.addActionListener(this);
		l.setVisible(true);
		panel.add(l);

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setVisible(true);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	
			try {
				showdetails();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		

	}

	public void showdetails() throws Exception {
		String str = username.getText();
		String name1 = "username or password can't be empty";
		String str1 = password.getText();
		if (str.equals("") || str1.equals("")) {

			JOptionPane.showMessageDialog(null, name1, "error!", 0, null);

		} else {
			try {
				String query = String.format("select  * from login");
				System.out.println(query);
				ResultSet rs = connection_string.stmt.executeQuery(query);

				while (rs.next()) {
					if (str.equals(rs.getString(1)) && str1.equals(rs.getString(2))) {
						new HomePage();
						f = false;
					}
				}
				if (f) {
					String name = "wrong username or password";
					JOptionPane.showMessageDialog(null, name, "error!", 0, null);
				}

			} catch (Exception e1) {
				System.out.println(e1);
			}
		}

	}

	public static void main(String args[]) {
		new Login();
	}

}

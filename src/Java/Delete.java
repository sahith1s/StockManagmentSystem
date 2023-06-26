package Java;

/* delete */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Java.Jdbc;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delete implements ActionListener {
	JTextField tf1, tf2;
	JButton b1, b2;
	JFrame F;
	static String table;

	Delete(String table) {
		this.table = table;
		Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

		F = new JFrame("DELETE STOCK");
		F.setLayout(null);
		F.getContentPane().setBackground(new Color(23,113,125));
		JLabel label1 = new JLabel("Stock Identification");
		JLabel label2 = new JLabel("Stock name");

		JLabel label5 = new JLabel("DELETE STOCK");
		F.add(label1);
		F.add(label2);

		F.add(label5);
		F.setFont(f1);
		label1.setBounds(50, 50, 150, 50);
		label2.setBounds(50, 100, 150, 50);

		label5.setBounds(150, 10, 200, 50);

		// F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setBounds(510, 10, 420, 320);
		F.setVisible(true);
		tf1 = new JTextField("");
		tf2 = new JTextField("");

		F.add(tf1);
		F.add(tf2);

		tf1.setBounds(170, 60, 150, 30);
		tf2.setBounds(170, 110, 150, 30);

		b1 = new JButton("DELETE");
		b2 = new JButton("Cancel");
		F.add(b1);
		F.add(b2);

		b1.setBounds(60, 200, 100, 30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b2.setBounds(200, 200, 100, 30);

	}

	public static void main(String[] args) {
		new Delete(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if(tf1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "FIRST ENTER INTO FIELDS");

			}
			else {
			String query = "delete from " + table + " where stock#=" + tf1.getText();
			System.out.println(query);
			Jdbc obj = new Jdbc();

			try {
				int i = obj.update(query);
				if (i == 1)
					JOptionPane.showMessageDialog(null, "succesfully deleted..");
				else
					JOptionPane.showMessageDialog(null, "delete unsuccesful..");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}
		} 
	}

}
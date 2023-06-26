package Java;
/* update table*/

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.*;

public class Update implements ActionListener {
	static JTextField a;
	static JTextField b;
	static JTextField c;
	static JTextField d;
	static JLabel label1;
	JButton b1, b2;
	JFrame F;
	String table;

	Update(String table) {

		System.out.println("inside update");
		this.table = table;
		System.out.println(table);
		System.gc();
		Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

		F = new JFrame("UPDATE STOCK");
		F.setLayout(null);
		F.getContentPane().setBackground(new Color(23,113,125));
		
		JLabel label1 = new JLabel("Stock Identification");
		JLabel label2 = new JLabel("Stock name");
		JLabel label3 = new JLabel("Quantity");
		JLabel label4 = new JLabel("Date");
		JLabel label5 = new JLabel("UPDATE STOCK");
		F.add(label1);
		F.add(label2);
		F.add(label3);
		F.add(label4);
		F.add(label5);
		F.setFont(f1);
		label1.setBounds(50, 50, 150, 50);
		label2.setBounds(50, 100, 150, 50);
		label3.setBounds(50, 150, 150, 50);
		label4.setBounds(50, 200, 200, 50);
		label5.setBounds(150, 10, 200, 50);
		// F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setBounds(510, 10, 420, 420);
		F.setVisible(true);
		a = new JTextField();
		b = new JTextField();
		c = new JTextField();
		d = new JTextField();
		a.setEditable(false);
		b.setEditable(false);
		F.add(a);
		F.add(b);
		F.add(c);
		F.add(d);
		a.setBounds(170, 60, 150, 30);
		b.setBounds(170, 110, 150, 30);
		c.setBounds(170, 160, 150, 30);
		d.setBounds(170, 210, 150, 30);
		b1 = new JButton("update");

		b2 = new JButton("Cancel");
		b1.addActionListener(this);
		b2.addActionListener(this);
		F.add(b1);
		F.add(b2);

		b1.setBounds(60, 300, 100, 30);
		b2.setBounds(200, 300, 100, 30);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (a.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "FIRST ENTER INTO FIELDS");
			} else {
				Jdbc connection_string = new Jdbc();
//String query = String.format("update mobile_stock set quantity=%d,dates=\'%s\' where stock#=%d;",Integer.parseInt(c.getText()),
//				d.getText(), Integer.parseInt(a.getText()));
				String query1 = "update " + table + " set quantity=" + Integer.parseInt(c.getText()) + ",dates=\'"
						+ d.getText() + "\' where stock#=" + Integer.parseInt(a.getText());
				System.out.println(query1);

				try {
					int i = connection_string.update(query1);
					System.out.println(i);
					if (i == 1)
						JOptionPane.showMessageDialog(null, "succesfully updated..");
					else
						JOptionPane.showMessageDialog(null, "update unsuccesful..");
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
			}
			
		}

	}

	public static void main(String[] args) {
		new Update("mobile_stock");
	}

}

package Java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/*mobile */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Earphones extends MouseAdapter implements ActionListener {
	JFrame frame;
	public JTable t1;
	JButton b1, b2, b3, b4;
	JTextField tf1;
	private static DefaultTableModel model;
	static Jdbc connection_string = new Jdbc();
	private static String table = "earphone_stock";

	Earphones() {

		frame = new JFrame(" EAR PHONE STOCK ");
		frame.getContentPane().setBackground(new Color(23,90,120));
		String col[] = { "stock#", "stock_name", "quantity", "date" };
		// String rows[][]=method();
		model = new DefaultTableModel() {

			public boolean isCellEditable(int row, int col) {

				return false; 
			}
		};
		

		model.setColumnIdentifiers(col);
		try {

			ResultSet rs2 = connection_string.retrive("select * from " + table);
			while (rs2.next()) {
				String[] rows = { rs2.getInt(1) + "", rs2.getString(2), rs2.getInt(3) + "", rs2.getString(4) };
				model.addRow(rows);
			}

			t1 = new JTable(model);
			t1.setLayout(new BorderLayout());

			JScrollPane sp = new JScrollPane(t1);
			b1 = new JButton("CREATE");
			b2 = new JButton("UPDATE");
			b3 = new JButton("DELETE");
			b4 = new JButton("REFRESH");
			b1.setBounds(50, 450, 90, 30);
			b2.setBounds(120, 450, 90, 30);
			b3.setBounds(210, 450, 90, 30);
			b4.setBounds(290, 450, 90, 30);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			frame.add(sp, new BorderLayout().NORTH);

			frame.add(b1);
			frame.add(b2);
			frame.add(b3);
			frame.add(b4);
			frame.setResizable(false);
			t1.getTableHeader().setReorderingAllowed(false);// to block reordering of coloumns
			t1.addMouseListener(this);
			frame.setSize(500, 500);
			// frame.setDefaultCloseOperation(3);
			frame.setLayout(new FlowLayout());
			frame.setVisible(true);
		} catch (Exception e) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1)
			new addstock(table);
		if (e.getSource() == b2)
			new Update(table);
		if (e.getSource() == b3)
			new Delete(table);
		if (e.getSource() == b4)
			try {
				new Earphones();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	}

	public static void method() {
		try {

			ResultSet rs1 = connection_string.retrive("select * from " + table);

			rs1.last();
			String stock = String.valueOf(rs1.getInt(1));

			String stockname = rs1.getString(2);
			String quantity = String.valueOf(rs1.getInt(3));
			String date = rs1.getString(4);
			String row[] = { stock, stockname, quantity, date };

			model.addRow(row);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) throws SQLException {
		new Earphones();
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
		System.out.println(model.getValueAt(t1.getSelectedRow(), 0));
		String key = model.getValueAt(t1.getSelectedRow(), 0) + "";
		try {
			String Query = "select * from " + table + " where stock#=" + key;
			System.out.println(Query);
			ResultSet rs1 = connection_string.retrive(Query);
			// code to populate
			new Update(table);
			rs1.next();
			Update.a.setText(rs1.getInt(1) + "");
			Update.b.setText(rs1.getString(2));
			Update.c.setText(rs1.getInt(3) + "");
			Update.d.setText(rs1.getString(4));
		} catch (Exception e1) {

		}

	}

}

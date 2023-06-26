package Java;
import Java.Jdbc;
/* add stock*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class addstock implements ActionListener {
	JTextField a, b, c, d;
	JLabel label1;
	JButton b1, b2;
	public static int count = 0;
	private JFrame F;
     String table;
	addstock(String table) {
   this.table=table;
		Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
         
		JFrame F = new JFrame("ADD STOCK");
		F.setLayout(null);
		
		JLabel label1 = new JLabel("Stock Identification");
		JLabel label2 = new JLabel("Stock name");
		JLabel label3 = new JLabel("Quantity");
		JLabel label4 = new JLabel("Date");
		JLabel label5 = new JLabel("ADD STOCK");
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
		F.getContentPane().setBackground(new Color(23,113,125));
		F.setBounds(510, 10, 420, 420);
		F.setVisible(true);
		a = new JTextField();
		b = new JTextField();
		c = new JTextField();
		d = new JTextField();

		F.add(a);
		F.add(b);
		F.add(c);
		F.add(d);
		a.setBounds(170, 60, 150, 30);
		b.setBounds(170, 110, 150, 30);
		c.setBounds(170, 160, 150, 30);
		d.setBounds(170, 210, 150, 30);
		b1 = new JButton("ADD");

		b2 = new JButton("CANCEL");
		b1.addActionListener(this);
		b2.addActionListener(this);

		F.add(b1);
		F.add(b2);
		
		b1.setBounds(60, 300, 100, 30);
		b2.setBounds(200, 300, 100, 30);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (a.getText().equals("") || b.getText().equals("") || d.getText().equals("") || c.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "fields cant be empty");
		} 
		else {
		if (e.getSource() == b1) {
			add();
			count++;
			
			
		}
		if (e.getSource() == b2) F.dispose();
	}
	}

	public void add() {
	
		try {
			Jdbc connection_string = new Jdbc();
			String query="insert into "+table+" (stock#,stock_name,quantity,dates) values(?,?,?,?)";
			
			
			if (a.getText().equals("") || b.getText().equals("") || d.getText().equals("") || c.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "fields cant be empty");
			} 
			else {
				int res;
				int i = Integer.parseInt(a.getText());
				int j = Integer.parseInt(c.getText());
				String k = b.getText();
				String l = d.getText();
				
				res=connection_string.insert(query,i,k,j,l);
				
				
				
				if (res == 1) {
					JOptionPane.showMessageDialog(null, "succesfully added..");
					switch(table) {
					case "mobile_stock": Mobile.method();
					
					case "chargers_stock": Chargers.method();
					break;
					case "mobcase_stock": MobCases.method();
					break;
					case "earphone_stock": Earphones.method();
					break;
					}
					
					
				}
			}

		} catch (Exception e1) {
			//JOptionPane.showMessageDialog(null, "cannot enter duplicates stock#" );
					}

	}
	public static void main(String[] args) {
		new addstock("chargers_stock");
	}

}

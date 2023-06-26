package Java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* WELCOME PAGE*/
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Welcome1 extends JFrame implements ActionListener {
	// JFrame frame;
	JButton b1, b2, b3, b4;

	Welcome1() {

		Font f = new Font("monoscaped font", Font.BOLD, 30);
		setTitle("MOBILE STOCKS MANAGEMENT");
		JLabel name = new JLabel("WELCOME TO MSM");
		name.setForeground(Color.WHITE);
		name.setFont(f);
		name.setBounds(600, 100, 300, 500);
		name.setFont(f);
		setSize(1650, 1200);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon background_image = new ImageIcon("src/images/welcome.jpg");
		ImageIcon image1 = new ImageIcon("msm.jpg");
		setIconImage(image1.getImage());
		b1 = new JButton("login");
		b1.setBounds(350, 600, 150, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.WHITE);
		b2 = new JButton("supports");
		b2.setBounds(600, 600, 150, 30);
		b2.setBackground(Color.WHITE);
		b2.addActionListener(this);
		b3 = new JButton("about");
		b3.setBounds(850, 600, 150, 30);
		b3.setBackground(Color.WHITE);
		b3.addActionListener(this);
		b4 = new JButton("developers");
		b4.setBounds(1100, 600, 150, 30);
		b4.setBackground(Color.WHITE);
		b4.addActionListener(this);
		Border border = new LineBorder(Color.WHITE, 3);
		b1.setBorder(border);
		JPanel w = new JPanel();

		w.setBackground(new Color(0, 0, 0, 100));
		w.setBounds(600, 100, 500, 600);
		w.setBorder(border);
		add(name);
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1650, 1200, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.add(b1);
		background.add(b2);
		background.add(b3);
		background.add(b4);
		background.setBounds(0, 0, 1650, 1200);
		add(background);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Welcome1();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1)
			new Login();
		if (e.getSource() == b2)
			new Supports();
		if (e.getSource() == b3)
			new About();
		if (e.getSource() == b4)
			new Devlopers();

	}
}
package Java;
/*
 *  HOME PAGE
 * 
 * 
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class HomePage implements ActionListener {
	JFrame frame;
	JPanel panel, p;
	JButton b1, b2, b3, b4;
	ImageIcon phon, charger, earphn, mobcas, back;

	HomePage() {
		frame = new JFrame("MOBILE STOCK MANAGEMENT //...HomePage");
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(3);
		Font f = new Font("magneto", Font.BOLD, 40);
		JLabel name = new JLabel("Home page");
		name.setForeground(Color.WHITE);
		name.setFont(f);
		name.setBounds(345,60, 300, 500);
		name.setFont(f);
		frame.add(name);
		ImageIcon background_image = new ImageIcon("src/images/uuu.jpg");
		JPanel w = new JPanel();
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1000,800, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		w.setBackground(new Color(0, 0, 0, 100));
		w.setLayout(new GridLayout(2, 2, 30, 20));
		w.setBounds(325, 400, 250, 250);
		
		background.setBounds(0, 0,1000,800);
		
		b1 = new JButton();
		//b1.setBounds(0, 0, 30, 40);
		b1.setBackground(Color.white);	
		phon = new ImageIcon("src/images/mob.png");
		b1.setIcon(phon);

		b2 = new JButton();
		//b2.setBounds(90, 90, 30, 40);
		charger = new ImageIcon("src/images/charggg1.png");
		
		b2.setBackground(Color.white);
		b2.setIcon(charger);
		b3 = new JButton();
		//b3.setBounds(200, 200, 30, 40);
		earphn = new ImageIcon("src/images/earrrr5.jpg");
		b3.setIcon(earphn);
		b4 = new JButton();
		b4.setBackground(Color.white);
		//b4.setBounds(300, 300, 30, 40);
		mobcas = new ImageIcon("src/images/case1.jpg");
		b4.setIcon(mobcas);
		
		w.add(b1);
		w.add(b2);
		w.add(b3);
		w.add(b4);
		frame.add(w);
		frame.add(background);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		frame.setLayout(null);
		frame.setResizable(false);
//		l.setVisible(true);
		frame.setVisible(true);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1)
			try {
				new Mobile();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (e.getSource() == b2)
			new Chargers();
		if (e.getSource() == b3)
			new Earphones();
		if (e.getSource() == b4)
			new MobCases();

	}

	public static void main(String[] args) {
		new HomePage();
	}

}

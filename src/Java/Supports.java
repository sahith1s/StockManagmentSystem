package Java;
import java.awt.*;
import javax.swing.*;

public class Supports extends JFrame {
	Supports(){
	setTitle("MOBILE STOCK MANAGEMENT //.... Supports");
	setSize(900,600);
	ImageIcon background_image=new ImageIcon("src/images/su.jpg");
	Image img =background_image.getImage();
	Image temp_img=img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
	background_image =new ImageIcon(temp_img);
    JLabel background=new JLabel("",background_image,JLabel.CENTER);    
    JLabel label = new JLabel("My label");
    label.setText("<html>CONTACT NO:<br> +91 1234561234 </html>");
   label.setForeground(Color.WHITE);
   Font f=new Font("serif",Font.BOLD,20);
   label.setFont(f);
    label.setBounds(700,120, 600, 700);
    background.add(label);  
    add(background);
    setResizable(false);
	setVisible(true);
        }
public static void main(String args[]) {
	new Supports();
} 
}
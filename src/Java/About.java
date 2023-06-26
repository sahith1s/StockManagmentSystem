package Java;
import java.awt.*;
import javax.swing.*;

public class About extends JFrame {
About(){
	setTitle("MOBILE STOCK MANAGEMENT //.... About");
	setSize(900,600);
	ImageIcon background_image=new ImageIcon("src/images/ss.jpg");
	Image img =background_image.getImage();
	Image temp_img=img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
	background_image =new ImageIcon(temp_img);
    JLabel background=new JLabel("",background_image,JLabel.CENTER);    
    JLabel label = new JLabel("My label");
    label.setText("<html><br>About the MSM APP<br><br>All the products are categorized and maintained as bulk ..so that it enhances warehouse owner to check the stock list for availability of each category (mobile phones,mobile chargers,earphones and mobile cases).<br><br>This App manages product by adding product details like stock name ,stock ID and other details. <br><br>Features: easy to use and Transparency<br><br>This App is launched ON 28-07-2022 <br></html>");
   label.setForeground(Color.WHITE);
    label.setBounds(40,100, 800, 700);
    background.add(label);
    setResizable(false);
    add(background);
    //setLayout(new GridLayout(2, 1));
	//setBackground(Color.GREEN);
	setVisible(true);
        }
public static void main(String args[]) {
	new About();
} 
}

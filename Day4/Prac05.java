import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prac05 extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public Prac05() {
		setTitle("그래픽 이미지 확대 축소 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		private ImageIcon icon = new ImageIcon("due.png");
		private Image img = icon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 10, 10, getWidth(), getHeight(), this);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Prac05();
	}

}

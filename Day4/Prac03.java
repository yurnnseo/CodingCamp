import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prac03 extends JFrame {
	
	private MyPanel panel = new MyPanel();

	public Prac03() {
		setTitle("이미지 레이블 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		private ImageIcon icon = new ImageIcon("due.png");
		private Image img = icon.getImage(); 
		
		private int x = 0;
		private int y = 0;
				
		public MyPanel() {
			setLayout(null);
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					
					repaint();
				}
			});
			
			this.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					
					repaint();
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(img, x-30, y-30, 60, 60, this);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Prac03();
	}
}

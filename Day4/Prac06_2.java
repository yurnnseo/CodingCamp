import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prac06_2 extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public Prac06_2() {
		setTitle("그래픽 : 다각형 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		private int width = getWidth();
		private int height = getHeight();
		
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			for (int i=0; i<10; i++) {
				g.drawLine(getWidth()/2, i*20, i*20, getHeight()/2);
				g.drawLine(getWidth()/2, i*20, getWidth()-(i*20), getHeight()/2);
				g.drawLine(getWidth()-(i*20), getHeight()/2, getWidth()/2, getHeight()-(i*20));
				g.drawLine(getWidth()/2, getHeight()-(i*20), i*20, getHeight()/2);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Prac06_2();
	}

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prac06 extends JFrame {
	
	MyPanel panel = new MyPanel();
	
	public Prac06() {
		setTitle("격자 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i=0; i<50; i++) {
				int verticalX = 50*(i+1);
				int HorizonY = 50*(i+1);
				g.drawLine(verticalX, 0, verticalX, 500);
				g.drawLine(0, HorizonY, 500, HorizonY);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Prac06();
	}

}

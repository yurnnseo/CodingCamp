import java.awt.*;
import javax.swing.*;

public class P674_CheckTime extends JFrame {
	
	private MyPanel mPanel = new MyPanel();
	
	public P674_CheckTime() {
		setTitle("원 그리기");
		setContentPane(mPanel);
		setSize(200, 200);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(10, 10, 30, 30);
			g.drawOval(10, 15, 20, 10);
			
			int x[] = {10, 5, 15};
			int y[] = {10, 15, 20};
			g.setColor(Color.RED);
			g.fillPolygon(x, y, 3);
			
			g.setColor(Color.RED);
			g.fillArc(20, 20, 80, 80, 90, 120);
			g.setColor(Color.BLUE);
			g.fillArc(20, 20, 80, 80, 210, 120);
			g.setColor(Color.YELLOW);
			g.fillArc(20, 20, 80, 80, 330, 120);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new P674_CheckTime();
	}

}

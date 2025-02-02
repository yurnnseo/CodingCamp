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
		private double width = img.getWidth(this);
		private double height = img.getHeight(this);
		
		public MyPanel() {
			setFocusable(true); // 키 입력을 받을 수 있도록 설정
            requestFocus(); // 패널에 포커스 요청
            
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() == '+') {
						width *= 1.1;
						height *= 1.1;
						
						repaint();
					}
					else if (e.getKeyChar() == '-'){
						width *= 0.9;
						height *= 0.9;
						
						repaint();
					}
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 10, 10, (int)width, (int)height, this);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Prac05();
	}

}

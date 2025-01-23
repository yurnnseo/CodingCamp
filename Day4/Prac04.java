import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prac04 extends JFrame {
	
	private ImageIcon icon = new ImageIcon("due.png");
	private JLabel imageLabel = new JLabel(icon);
	private int mouseX, mouseY; // 마우스 클릭 위치 저장

	public Prac04() {
		setTitle("이미지 레이블 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(null);
		
		imageLabel.setLocation(100, 100);
		imageLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
		add(imageLabel);
		
		 // 마우스 이벤트 처리
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // 클릭된 위치의 상대 좌표 저장
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        imageLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 드래그 중 이미지 이동
                int x = imageLabel.getX() + e.getX() - mouseX;
                int y = imageLabel.getY() + e.getY() - mouseY;
                imageLabel.setLocation(x, y); // 새로운 위치 설정
            }
        });

        setVisible(true); // 프레임을 보이게 설정
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Prac04();
	}

}

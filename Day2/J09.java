import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class J09 extends JFrame {
	
	private CPanel cPanel = new CPanel();
	
	public J09() {
		setTitle("OpenChallenge 14");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.add(new NPanel(), BorderLayout.NORTH);
		c.add(cPanel, BorderLayout.CENTER);
		c.add(new SPanel(), BorderLayout.SOUTH);
		
		setSize(450, 400);
		setResizable(false);
		setVisible(true);
	}
	
	class NPanel extends JPanel {
		private JLabel titlemessage = new JLabel("Welcome, Hot Coffee!!");
		
		public NPanel() {
			setBackground(Color.MAGENTA);
			add(titlemessage);
		}
	}
	
	class SPanel extends JPanel {
		private JButton [] buttons = new JButton [4]; // 여기까지는 배열 레퍼런스만 생성. 아직 배열이 아님
		private String [] names = {"Black Coffee", "Sugar Coffee", "Dabang Coffee", "Reset"};
		
		public SPanel() {
			for (int i=0; i<buttons.length; i++) {
				buttons[i] = new JButton(names[i]); // JButton으로 된 배열 완성
				add(buttons[i]); // 버튼을 southPanel에 부착
				
				// 버튼이 클릭되면 이 함수가 실행됨. -> 버튼이 클릭되면 버튼에 맞는 행동을 취해야 함
				buttons[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// 클릭된 버튼의 문자열 정보를 알아내야함
						cPanel.operate(e.getActionCommand());            
					}
				});
			}
		}
	}
	
	class BoxLabel extends JLabel {
		private final int MAXSIZE = 10;
		private int currentSize;
		
		public BoxLabel() {
			currentSize = MAXSIZE;
		}
		
		boolean consume() {
			if (currentSize>0) {
				currentSize--;
				return true;
			}
			else return false;
		}
		
		void reset() {
			currentSize = MAXSIZE;
		}
		
		boolean isEmpty() { return currentSize == 0; }
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.LIGHT_GRAY);
			int y = this.getHeight() - (currentSize*this.getHeight()/MAXSIZE);
			g.fillRect(0, y, this.getWidth(), this.getHeight()-y);
		}
		
	}
	
	class CPanel extends JPanel {
		
		private BoxLabel [] boxes = new BoxLabel[5];
		private String [] boxNames = {"Cup", "Coffee", "Water", "Sugar", "Cream"};
		
		private final int CUP = 0;
		private final int COFFEE = 1;
		private final int WATER = 2;
		private final int SUGAR = 3;
		private final int CREAM = 4;
		
		public CPanel() {
			
			setLayout(null);
			
			for (int i=0; i<boxes.length; i++) {
				boxes[i] = new BoxLabel();
				boxes[i].setLocation(30+80*i, 10);
				boxes[i].setSize(40, 100);
				
				JLabel text = new JLabel(boxNames[i]);
				text.setLocation(30+80*i, 110);
				text.setSize(50, 30);
				
				add(boxes[i]);
				add(text);
				
			}
		}
		
		public void operate(String cmd) {
			
			// 클릭한 버튼이 "Black Coffee"이면 
			// 컵, 물, 커피가 존재하는 지 확인하고 하나씩 감소
			if(cmd.equals("Black Coffee")) { // 눌러진 버튼이 "Black Coffee" 이면
	            if(boxes[CUP].isEmpty() || boxes[COFFEE].isEmpty() || boxes[WATER].isEmpty()) {
	               error("부족한 것이 있습니다. 채워주세요."); // 경고창을 출력한다.
	               return;
	            }
	            else {
	               boxes[CUP].consume(); // 컵을 하나 줄인다.
	               boxes[COFFEE].consume(); // 커피 양을 하나 줄인다.
	               boxes[WATER].consume(); // 물 양을 하나 줄인다.
	            }
	         }
			
			
	         else if(cmd.equals("Sugar Coffee")) { // 눌러진 버튼이 "Sugar Coffee" 이면
	            if(boxes[CUP].isEmpty() || boxes[COFFEE].isEmpty() || boxes[WATER].isEmpty() ||
	                  boxes[SUGAR].isEmpty()) {
	               error("부족한 것이 있습니다. 채워주세요."); // 경고창을 출력한다.
	               return;
	            }      
	            else {
	               boxes[CUP].consume();  // 컵을 하나 줄인다.
	               boxes[COFFEE].consume(); // 커피 양을 하나 줄인다.
	               boxes[WATER].consume(); // 물 양을 하나 줄인다.
	               boxes[SUGAR].consume();   // 설탕 양을 하나 줄인다.            
	            }
	         }
			
			
	         else if(cmd.equals("Dabang Coffee")) { // 눌러진 버튼이 "Dabang Coffee" 이면
	            if(boxes[CUP].isEmpty() || boxes[COFFEE].isEmpty() || boxes[WATER].isEmpty() ||
	                  boxes[SUGAR].isEmpty() || boxes[CREAM].isEmpty()) {
	               error("부족한 것이 있습니다. 채워주세요."); // 경고창을 출력한다.
	               return;
	            }
	            else {
	               boxes[CUP].consume(); // 컵을 하나 줄인다.
	               boxes[COFFEE].consume(); // 커피 양을 하나 줄인다.
	               boxes[WATER].consume(); // 물 양을 하나 줄인다.
	               boxes[SUGAR].consume();   // 설탕 양을 하나 줄인다.   
	               boxes[CREAM].consume();   // 크림 양을 하나 줄인다.   
	            }
	         }
			
			
	         else { // // 눌러진 버튼이 "reset" 이면
	            boxes[CUP].reset(); // 컵을 초기 상태와 같이 가득 채운다.
	            boxes[COFFEE].reset(); // 커피를 초기 상태와 같이 가득 채운다.
	            boxes[WATER].reset(); // 물을 초기 상태와 같이 가득 채운다.
	            boxes[SUGAR].reset(); // 설탕을 초기 상태와 같이 가득 채운다.   
	            boxes[CREAM].reset(); // 크림을 초기 상태와 같이 가득 채운다.
	            repaint(); // boxes[]의 레이블 컴포넌트에 변화가 생겼으므로 부모에게 다시 그리도록 한다.
	            return;
	         }
			
			repaint();
			
			// 커피가 나왔음을 알려주는 메시지 창을 출력한다.
	         JOptionPane.showMessageDialog(CPanel.this, "뜨거워요, 즐거운 하루~~", "커피나왔습니다.", 
	               JOptionPane.INFORMATION_MESSAGE);
		}
		
		public void error(String msg) { // 경고창을 출력하는 메소드
	         JOptionPane.showMessageDialog(CPanel.this, msg, "커피 자판기 경고", 
	               JOptionPane.INFORMATION_MESSAGE);
	         return;
	      }
	}
	
	static public void main(String [] args) {
		new J09();
	}
}

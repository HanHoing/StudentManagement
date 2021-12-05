package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
 //로그인 프레임
public class LoginFrame extends JPanel implements MouseListener{
	 
	JFrame jp;
	
	JLabel lb1;		 //아이디 문자 라벨 
	JTextField tfId;	//아이디 텍스트필드
	JButton bt1;	//로그인 버튼
	JButton bt2;	//종료버튼 
	
	//LoginFrame 생성자 
	LoginFrame(){
		
		this.setLayout(new GridLayout(4,3,10,10));
				
		lb1=new JLabel("인증키");   //아이디 문자 라벨 
		tfId = new JTextField();  //아이디 텍스트필드
		bt1 = new JButton("입력");    	//로그인 버튼
		bt2 = new JButton("종료");    	//종료버튼 
	
		
		Font font = new Font("Serif", Font.BOLD,30);
		font = new Font("SansSerif", Font.BOLD, 30);
		
		lb1.setFont(font);
	
		
		add(lb1, CENTER_ALIGNMENT);
		add(tfId);
		add(bt1);
		add(bt2);
		bt1.setBackground(Color.PINK);
		bt2.setBackground(Color.PINK);
		
		setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		
		setSize(500,400);
		
		jp = new JFrame();
		jp.add(this);
		jp.setSize(500,400);
		jp.setTitle("인증키 입력창");
		jp.setVisible(true);
		
		bt1.addMouseListener(this);  	//로그인 버튼
		bt2.addMouseListener(this);		//종료버튼
		
		
	}
	
	

//==========================인증키가 유효한지 확인하는 메소드 ===============================
	public void loginCheck() {
		if(tfId.getText().equals("123")) {
			new MainFrame();
			jp.dispose();
		}else {
			JOptionPane.showMessageDialog(null,"인증키를 다시 확인해주세요");
		}
			
	}
		
	
//====================================이벤트 설정====================================
	@Override
	public void mouseClicked(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			switch(b.getText()) {
				case "입력":
					loginCheck();
					break;
				case "종료":
					JOptionPane.showMessageDialog(null,"종료하시겠습니까?");
					jp.dispose();
					break;
		
			}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {;}

	@Override
	public void mouseReleased(MouseEvent e) {;}

	@Override
	public void mouseEntered(MouseEvent e) {;}

	@Override
	public void mouseExited(MouseEvent e) {;}
	

	
//========================================main============================================
	public static void main(String[] args) {
		new LoginFrame();
	}

	
}
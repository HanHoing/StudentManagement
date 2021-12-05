package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import Design.RoundedButton;
 
 //새 학생 레코드 등록 INSERT 
public class CreateFrame extends JPanel implements MouseListener{
	
	JFrame f;
	
	//아이디 
	JLabel lb1;    
	JTextField tf1;
	//이름
	JLabel lb2;
	JTextField tf2;
	//나이
	JLabel lb3;
	JTextField tf3;
	//주소
	JLabel lb4;
	JTextField tf4;
	//전화번호
	JLabel lb5;
	JTextField tf5;
	//비상 연락망
	JLabel lb6;
	JTextField tf6;
	//1차
	JLabel lb7;
	JTextField tf7;
	//2차
	JLabel lb8;
	JTextField tf8;
	
	//등록버튼
	RoundedButton bt1;
	//취소버튼
	RoundedButton bt2;
	

    // EventProcess 메소드 쓰기 위한 객체
    EventProcess obj;

	public CreateFrame() {

		JPanel jp = new JPanel();
		
		jp.setLayout(new GridLayout(4,3,10,10));
		jp.add(titlePannel());
		jp.add(midPanel());
		jp.add(bottomPanel());
		jp.setSize(700,500);
		
		jp.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		
		f = new JFrame();
		
		f.setBackground(Color.GRAY);
		f.setSize(700,500);
		f.add(jp);
		f.setVisible(true);

		obj = new EventProcess(); //EventProcess 객체 생성 

		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
				
	}

	
	//========================================이벤트 설정==================================
	@Override
	public void mouseClicked(MouseEvent e) {

			JButton b = (JButton)e.getSource();
			int result=0;
			
			try {
				switch(b.getText()) {
					case "등록":
						result=obj.studentInsert(tf1.getText(),tf2.getText(),Integer.parseInt(tf3.getText()) ,tf4.getText(),tf5.getText(),tf6.getText(),Integer.parseInt(tf7.getText()),Integer.parseInt(tf8.getText()));
						System.out.println(result);
						JOptionPane.showMessageDialog(null,"등록이 완료되었습니다.");
						break;
					case "취소":
						JOptionPane.showMessageDialog(null,"취소하시겠습니까??");
						new MainFrame();
						f.dispose();
						break;
				}		
			}catch (Exception n) {
				JOptionPane.showMessageDialog(null,"입력한 정보를 다시 확인해주세요.");
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


	//첫번째 타이틀 있는 패널
	public static Panel titlePannel() {

			Panel panel = new Panel();
			panel.setSize(200,100);
			Label label = new Label();
			label.setText("학생 등록");
			
			Font font = new Font("Serif", Font.BOLD,30);
			font = new Font("SansSerif", Font.BOLD, 30);
			label.setFont(font);
			panel.add(label);
			
			return panel;
		}
	
		
		
	//두번째 버튼들  있는 패널
		public Panel midPanel() {
			
			Panel panel = new Panel();
			
			panel.setLayout(new GridLayout(4,4,30,10));
			//.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10);

			
			lb1=new JLabel("ID:");   //아이디 문자 라벨 
		
			tf1 = new JTextField();  //아이디 텍스트필드
		
			lb2=new JLabel("이름:");    	//이름 문자라벨 
		
			tf2 = new JTextField();   //이름 텍스트 필드

			lb3=new JLabel("나이:");    	//나이 문자라벨 
		
			tf3 = new JTextField();   //나이 텍스트 필드
			
			lb4=new JLabel("주소:");    	//전화번호문자라벨 
		
			tf4 = new JTextField();   //전화번호 텍스트 필드
		
			lb5=new JLabel("전화번호:");   //비상 연락망 문자 라벨 
		
			tf5 = new JTextField();  //비상 연락망 텍스트필드
		
			lb6=new JLabel("비상연락망:");    	//비상 연락망 문자라벨 
		
			tf6 = new JTextField();   //비상 연락망 텍스트 필드
		
			lb7=new JLabel("1차:");    	//1차 문자라벨 
		
			tf7 = new JTextField();   //1차 텍스트 필드
		
			lb8=new JLabel("2차:");    	//2차  문자라벨 
		
			tf8 = new JTextField();   //2차 텍스트 필드
		
		
			panel.add(lb1);
			panel.add(tf1);
			panel.add(lb2);
			panel.add(tf2);
			panel.add(lb3);
			panel.add(tf3);
			panel.add(lb4);
			panel.add(tf4);
			panel.add(lb5);
			panel.add(tf5);
			panel.add(lb6);
			panel.add(tf6);
			panel.add(lb7);
			panel.add(tf7);
			panel.add(lb8);
			panel.add(tf8);
			
			return panel;
		}
		
		
	public Panel bottomPanel() {
		
		Panel panel = new Panel();
		panel.setSize(200, 100);
		
		Label label = new Label();
		panel.add(label);
		panel.setVisible(true);
		
				
		bt1 = new RoundedButton("등록");    	//등록 완료버튼
				
		bt2 = new RoundedButton("취소");    	//취소버튼 
		
		panel.add(bt1);
	    panel.add(bt2);
	    bt1.setBackground(Color.PINK);
	    bt2.setBackground(Color.PINK);
	    return panel;
		
   }
	
	
//=============================main==============================
	public static void main(String[] args) {
		new CreateFrame();
	}


}
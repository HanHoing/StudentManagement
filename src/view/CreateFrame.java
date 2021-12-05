package view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import Design.RoundedButton;
 
 //�� �л� ���ڵ� ��� INSERT 
public class CreateFrame extends JPanel implements MouseListener{
	
	JFrame f;
	
	//���̵� 
	JLabel lb1;    
	JTextField tf1;
	//�̸�
	JLabel lb2;
	JTextField tf2;
	//����
	JLabel lb3;
	JTextField tf3;
	//�ּ�
	JLabel lb4;
	JTextField tf4;
	//��ȭ��ȣ
	JLabel lb5;
	JTextField tf5;
	//��� ������
	JLabel lb6;
	JTextField tf6;
	//1��
	JLabel lb7;
	JTextField tf7;
	//2��
	JLabel lb8;
	JTextField tf8;
	
	//��Ϲ�ư
	RoundedButton bt1;
	//��ҹ�ư
	RoundedButton bt2;
	

    // EventProcess �޼ҵ� ���� ���� ��ü
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

		obj = new EventProcess(); //EventProcess ��ü ���� 

		bt1.addMouseListener(this);
		bt2.addMouseListener(this);
				
	}

	
	//========================================�̺�Ʈ ����==================================
	@Override
	public void mouseClicked(MouseEvent e) {

			JButton b = (JButton)e.getSource();
			int result=0;
			
			try {
				switch(b.getText()) {
					case "���":
						result=obj.studentInsert(tf1.getText(),tf2.getText(),Integer.parseInt(tf3.getText()) ,tf4.getText(),tf5.getText(),tf6.getText(),Integer.parseInt(tf7.getText()),Integer.parseInt(tf8.getText()));
						System.out.println(result);
						JOptionPane.showMessageDialog(null,"����� �Ϸ�Ǿ����ϴ�.");
						break;
					case "���":
						JOptionPane.showMessageDialog(null,"����Ͻðڽ��ϱ�??");
						new MainFrame();
						f.dispose();
						break;
				}		
			}catch (Exception n) {
				JOptionPane.showMessageDialog(null,"�Է��� ������ �ٽ� Ȯ�����ּ���.");
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


	//ù��° Ÿ��Ʋ �ִ� �г�
	public static Panel titlePannel() {

			Panel panel = new Panel();
			panel.setSize(200,100);
			Label label = new Label();
			label.setText("�л� ���");
			
			Font font = new Font("Serif", Font.BOLD,30);
			font = new Font("SansSerif", Font.BOLD, 30);
			label.setFont(font);
			panel.add(label);
			
			return panel;
		}
	
		
		
	//�ι�° ��ư��  �ִ� �г�
		public Panel midPanel() {
			
			Panel panel = new Panel();
			
			panel.setLayout(new GridLayout(4,4,30,10));
			//.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10);

			
			lb1=new JLabel("ID:");   //���̵� ���� �� 
		
			tf1 = new JTextField();  //���̵� �ؽ�Ʈ�ʵ�
		
			lb2=new JLabel("�̸�:");    	//�̸� ���ڶ� 
		
			tf2 = new JTextField();   //�̸� �ؽ�Ʈ �ʵ�

			lb3=new JLabel("����:");    	//���� ���ڶ� 
		
			tf3 = new JTextField();   //���� �ؽ�Ʈ �ʵ�
			
			lb4=new JLabel("�ּ�:");    	//��ȭ��ȣ���ڶ� 
		
			tf4 = new JTextField();   //��ȭ��ȣ �ؽ�Ʈ �ʵ�
		
			lb5=new JLabel("��ȭ��ȣ:");   //��� ������ ���� �� 
		
			tf5 = new JTextField();  //��� ������ �ؽ�Ʈ�ʵ�
		
			lb6=new JLabel("��󿬶���:");    	//��� ������ ���ڶ� 
		
			tf6 = new JTextField();   //��� ������ �ؽ�Ʈ �ʵ�
		
			lb7=new JLabel("1��:");    	//1�� ���ڶ� 
		
			tf7 = new JTextField();   //1�� �ؽ�Ʈ �ʵ�
		
			lb8=new JLabel("2��:");    	//2��  ���ڶ� 
		
			tf8 = new JTextField();   //2�� �ؽ�Ʈ �ʵ�
		
		
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
		
				
		bt1 = new RoundedButton("���");    	//��� �Ϸ��ư
				
		bt2 = new RoundedButton("���");    	//��ҹ�ư 
		
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
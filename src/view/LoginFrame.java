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
 
 //�α��� ������
public class LoginFrame extends JPanel implements MouseListener{
	 
	JFrame jp;
	
	JLabel lb1;		 //���̵� ���� �� 
	JTextField tfId;	//���̵� �ؽ�Ʈ�ʵ�
	JButton bt1;	//�α��� ��ư
	JButton bt2;	//�����ư 
	
	//LoginFrame ������ 
	LoginFrame(){
		
		this.setLayout(new GridLayout(4,3,10,10));
				
		lb1=new JLabel("����Ű");   //���̵� ���� �� 
		tfId = new JTextField();  //���̵� �ؽ�Ʈ�ʵ�
		bt1 = new JButton("�Է�");    	//�α��� ��ư
		bt2 = new JButton("����");    	//�����ư 
	
		
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
		jp.setTitle("����Ű �Է�â");
		jp.setVisible(true);
		
		bt1.addMouseListener(this);  	//�α��� ��ư
		bt2.addMouseListener(this);		//�����ư
		
		
	}
	
	

//==========================����Ű�� ��ȿ���� Ȯ���ϴ� �޼ҵ� ===============================
	public void loginCheck() {
		if(tfId.getText().equals("123")) {
			new MainFrame();
			jp.dispose();
		}else {
			JOptionPane.showMessageDialog(null,"����Ű�� �ٽ� Ȯ�����ּ���");
		}
			
	}
		
	
//====================================�̺�Ʈ ����====================================
	@Override
	public void mouseClicked(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			switch(b.getText()) {
				case "�Է�":
					loginCheck();
					break;
				case "����":
					JOptionPane.showMessageDialog(null,"�����Ͻðڽ��ϱ�?");
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
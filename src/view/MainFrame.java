package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Design.YellowButton;

//Main Frame -> �л� ������ ��Ÿ���� ȭ�� 

//�����̳ʿ� ���� JFrame
public class MainFrame extends JFrame implements MouseListener{
	
	JFrame jf;	
	
	TextField search; 	 //��ġ�� 
	
	YellowButton albtn;    	//��¹�ư
	YellowButton rbtn;		//�˻� ��ư
	YellowButton ubtn;		//������ư
	YellowButton dbtn;		//������ư
	YellowButton cbtn;		//�л���� ��ư
	YellowButton endbtn;	//�����ư

	//����Ʈ�� �κ�  
    DefaultTableModel model;
	
    // EventProcess �޼ҵ� ���� ���� ��ü
    EventProcess obj;
	String[][] student_arr =null;
	
	MainFrame(){
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		jp2.setLayout(new BorderLayout());
		jp2.setLayout(new BorderLayout());
		//JPanel ���̾ƿ� ����
		jp1.add(searchLayout());	//�˻��� �Է�, ���͹�ư ���̾ƿ�  Pannel ��ü ��ȯ �޾� JFrame�� ������
		jp1.add(btnLayout());		//�˻�, ����, ���, ����, �л���� ��ư ���̾ƿ� Pannel ��ü ��ȯ �޾�  JFrame�� ������
		jp1.add(endLayout());		//������ �����ư ���̾ƿ� Pannel ��ü ��ȯ �޾�  JFrame�� ������
		jp2.add(listLayout());		//������ư, ����Ʈ â ���̾ƿ�   Pannel ��ü ��ȯ �޾� JFrame�� ������
		jp3.add(titlePanel());
		
				
		//JPanel�� ���� JFrame
		jf = new JFrame();
		
		jf.setSize(1000,800);
		jf.add(jp1,"West");
		jf.add(jp3,"North");
		jf.add(jp2,"Center");
		jf.setVisible(true);

		obj = new EventProcess(); //EventProcess ��ü ���� 

		
		//�̺�Ʈ ������ ��� 
		albtn.addMouseListener(this); //��ü��� �̺�Ʈ
		rbtn.addMouseListener(this);  //�˻�
		ubtn.addMouseListener(this);  //����
		dbtn.addMouseListener(this);  //����
		cbtn.addMouseListener(this);  //�л����
		endbtn.addMouseListener(this); //����
	}
	
	
	//GUI�� ��Ÿ���� �̺�Ʈ �޼ҵ� �κ� (����Ʈ�� ��� )
	public void printInfo() {
		
		model.setNumRows(0);
		
		for (int i = 0; i < student_arr.length; i++) {
			model.addRow(student_arr[i]);	
		}
	     
	} 
	
	//��ư Ŭ���� EventProcess�� �̺�Ʈ �޼ҵ� ����  
	//��� �̺�Ʈ �޼ҵ�� EventProcess�� ����
	@Override
	public void mouseClicked(MouseEvent e) {
		YellowButton b = (YellowButton)e.getSource();
		int result=0;
		try{	
			switch(b.getText()) {
				case "���":
					// ��ü ��� SELECT * FROM ���̺�� �̺�Ʈ �޼ҵ� ����
			      	student_arr = obj.studentSelectAll(); //EventProcess ��ü ��� �޼ҵ�
					printInfo(); // get�̿��� ����Ʈ�� ����ϴ� �κ� �ʿ� 
					break;
				case "�˻�":
					student_arr=obj.studentSearchId(search.getText());// searchbar text�˻���� �˻� SELECT * FROM ���̺��    WHERE �÷���=search.getText()�̺�Ʈ �޼ҵ� ����
					if(student_arr.length<1) JOptionPane.showMessageDialog(null,"��ġ�ϴ� �˻�� �����ϴ�.");
					printInfo() ; //  get���� �޾ƿ� �����͵� ���Ϲ޾� ����Ʈ�� ��� 
					break;
				case "����":
					new UpdateFrame();  // UpdateFrame���� �̵�
					jf.dispose();
					break;
				case "����":
					// id�Է� �� ���� DELETE FROM ���̺�� WHERE StudentId=%d, search.getText()  �̺�Ʈ �޼ҵ� ����
					result=obj.studentDelete(search.getText());
					if(result<1) 
						JOptionPane.showMessageDialog(null,"��ġ�ϴ� ID�� �����ϴ�.");
					else 
						JOptionPane.showMessageDialog(null,"ID: "+search.getText()+"�л��� ������ �����մϴ�.");
					break;
				case "�л� ���":
					new CreateFrame(); //CreateFrame���� �̵�
					jf.dispose();
					break;
				case "����":
					JOptionPane.showMessageDialog(null,"����Ű �Է�â���� �̵��մϴ�");
					new LoginFrame();
					jf.dispose();
					break;
			}
		}catch(Exception e1){

			System.out.println(e1.toString());

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


	

	//=================================�г� (��ư, ����Ʈ, �ؽ�Ʈ�ʵ� ��� )�����ϴ� �κ� ==============================
	public static Panel titlePanel() {

		Panel jp3 = new Panel();
		jp3.setSize(200,100);
		Label label = new Label();
		label.setText("�л� ����");
		
		Font font = new Font("Serif", Font.BOLD,50);
		font = new Font("SansSerif", Font.BOLD, 50);
		label.setFont(font);
		jp3.add(label);
		
		return jp3;
	}
	
	
	
	//�˻��� �Է�, ���͹�ư ���̾ƿ�  ������ (JFrame�� ���� Panel) �޼ҵ�
	public JPanel searchLayout() {
		Panel sp = new Panel();
		   
		//��ġ��
		search = new TextField(12);

		sp.add(search); //��ġ�� �߰�

		//���� ���� ���� Jpanel�� ������
		JPanel sp2 = new JPanel();
		sp2.setBorder(BorderFactory.createEmptyBorder(70 , 10 , 5 , 5));
		sp2.add(sp);
		
		return sp2;   //���� �Ϸ��� �г� ��ü ����	
	}
	
	
	
	//�˻�, ����, ���, ����, �л����  ���̾ƿ� ���� ��  (JFrame�� ���� Pannel) �޼ҵ�
	public JPanel btnLayout() {
		Panel bp = new Panel();
		bp.setLayout(new GridLayout(0,1,10,10));
		//bp.setLayout(new ); //bntLayout ���̾ƿ� ���� ���� 
		
		//AllRead, Read, Update, Delete, Create
		//���, �˻�, ����, ���� , �л����  ��ư ����
		albtn = new YellowButton("���");
		rbtn = new YellowButton("�˻�");
		ubtn = new YellowButton("����");
		dbtn = new YellowButton("����");
		cbtn = new YellowButton("�л� ���");
		
		
		bp.add(albtn);	 //��� ��ư�߰�
		bp.add(rbtn);	//�˻� ��ư�߰�
		bp.add(ubtn);	//���� ��ư�߰�
		bp.add(dbtn);	//���� ��ư�߰�
		bp.add(cbtn);	//�л� ��� ��ư�߰�
		
		//���� ���� ���� Jpannel�� ������
		JPanel bp2 = new JPanel();
		bp2.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 5 , 5));
		bp2.add(bp);
		
		return bp2;   //���� �Ϸ��� �г� ��ü ����
		
	}
	
	
	//������ �����ư ���̾ƿ� ������  (JFrame�� ���� Pannel) �޼ҵ�
	public JPanel endLayout() {
		Panel ep = new Panel();
		//ep.setLayout(new ); //endLayout ���̾ƿ� ���� ���� 
		
		//����, �����ư ����
		endbtn = new YellowButton("����");
		ep.add(endbtn);

		//���� ���� ���� Jpannel�� ������
		JPanel ep2 = new JPanel();
		ep2.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 5 , 5));
		ep2.add(ep);
	
		
		return ep2;   //���� �Ϸ��� �г� ��ü ����
	}
	
	
	
	//������ư, ����Ʈ â ���̾ƿ�  ������  (JFrame�� ���� Pannel) �޼ҵ�
	   public JPanel listLayout() {
		   	  JPanel list = new JPanel();
		      list.setLayout(new BorderLayout());
		      model=new DefaultTableModel();
		      String header[]= {"ID","�̸�","����","�ּ�","��ȭ��ȣ","��󿬶���","1��","2��"};
		      model=new DefaultTableModel(header,0);   //header�߰�, ���� 20�� ����
		      JTable table=new JTable(model);
		      table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		      table.getTableHeader().setReorderingAllowed(false);
		      JScrollPane scrolledTable=new JScrollPane(table);   //��ũ�� �� �� �ֵ��� JScrollPane ����
		      scrolledTable.setBorder(BorderFactory.createEmptyBorder(80,10,10,10));   //�ʹ� �پ��־ �����ڸ� ���(padding)
		      table.setEnabled(false);
		      table.setSize(700, 600);
		      list.add(scrolledTable);
		      list.setSize(700,600);
		      
		      
		      return list; //���� �Ϸ��� �г� ��ü ����
		      
		   }


	//==============================main====================================
	public static void main(String[] args) {
		new MainFrame();
	}
	
	
}
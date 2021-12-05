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

//Main Frame -> 학생 정보가 나타나는 화면 

//컨터이너에 붙힐 JFrame
public class MainFrame extends JFrame implements MouseListener{
	
	JFrame jf;	
	
	TextField search; 	 //서치바 
	
	YellowButton albtn;    	//출력버튼
	YellowButton rbtn;		//검색 버튼
	YellowButton ubtn;		//수정버튼
	YellowButton dbtn;		//삭제버튼
	YellowButton cbtn;		//학생등록 버튼
	YellowButton endbtn;	//종료버튼

	//리스트뷰 부분  
    DefaultTableModel model;
	
    // EventProcess 메소드 쓰기 위한 객체
    EventProcess obj;
	String[][] student_arr =null;
	
	MainFrame(){
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		jp2.setLayout(new BorderLayout());
		jp2.setLayout(new BorderLayout());
		//JPanel 레이아웃 설정
		jp1.add(searchLayout());	//검색어 입력, 엔터버튼 레이아웃  Pannel 객체 반환 받아 JFrame에 붙히기
		jp1.add(btnLayout());		//검색, 삭제, 출력, 수정, 학생등록 버튼 레이아웃 Pannel 객체 반환 받아  JFrame에 붙히기
		jp1.add(endLayout());		//사진과 종료버튼 레이아웃 Pannel 객체 반환 받아  JFrame에 붙히기
		jp2.add(listLayout());		//라디오버튼, 리스트 창 레이아웃   Pannel 객체 반환 받아 JFrame에 붙히기
		jp3.add(titlePanel());
		
				
		//JPanel을 붙힐 JFrame
		jf = new JFrame();
		
		jf.setSize(1000,800);
		jf.add(jp1,"West");
		jf.add(jp3,"North");
		jf.add(jp2,"Center");
		jf.setVisible(true);

		obj = new EventProcess(); //EventProcess 객체 생성 

		
		//이벤트 리스너 등록 
		albtn.addMouseListener(this); //전체출력 이벤트
		rbtn.addMouseListener(this);  //검색
		ubtn.addMouseListener(this);  //수정
		dbtn.addMouseListener(this);  //삭제
		cbtn.addMouseListener(this);  //학생등록
		endbtn.addMouseListener(this); //종료
	}
	
	
	//GUI에 나타나는 이벤트 메소드 부분 (리스트에 출력 )
	public void printInfo() {
		
		model.setNumRows(0);
		
		for (int i = 0; i < student_arr.length; i++) {
			model.addRow(student_arr[i]);	
		}
	     
	} 
	
	//버튼 클릭시 EventProcess의 이벤트 메소드 실행  
	//모든 이벤트 메소드는 EventProcess에 존재
	@Override
	public void mouseClicked(MouseEvent e) {
		YellowButton b = (YellowButton)e.getSource();
		int result=0;
		try{	
			switch(b.getText()) {
				case "출력":
					// 전체 출력 SELECT * FROM 테이블명 이벤트 메소드 실행
			      	student_arr = obj.studentSelectAll(); //EventProcess 전체 출력 메소드
					printInfo(); // get이용해 리스트에 출력하는 부분 필요 
					break;
				case "검색":
					student_arr=obj.studentSearchId(search.getText());// searchbar text검색어로 검색 SELECT * FROM 테이블명    WHERE 컬럼들=search.getText()이벤트 메소드 실행
					if(student_arr.length<1) JOptionPane.showMessageDialog(null,"일치하는 검색어가 없습니다.");
					printInfo() ; //  get으로 받아온 데이터들 리턴받아 리스트에 출력 
					break;
				case "수정":
					new UpdateFrame();  // UpdateFrame으로 이동
					jf.dispose();
					break;
				case "삭제":
					// id입력 후 삭제 DELETE FROM 테이블명 WHERE StudentId=%d, search.getText()  이벤트 메소드 실행
					result=obj.studentDelete(search.getText());
					if(result<1) 
						JOptionPane.showMessageDialog(null,"일치하는 ID가 없습니다.");
					else 
						JOptionPane.showMessageDialog(null,"ID: "+search.getText()+"학생의 정보를 삭제합니다.");
					break;
				case "학생 등록":
					new CreateFrame(); //CreateFrame으로 이동
					jf.dispose();
					break;
				case "종료":
					JOptionPane.showMessageDialog(null,"인증키 입력창으로 이동합니다");
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


	

	//=================================패널 (버튼, 리스트, 텍스트필드 등등 )생성하는 부분 ==============================
	public static Panel titlePanel() {

		Panel jp3 = new Panel();
		jp3.setSize(200,100);
		Label label = new Label();
		label.setText("학생 관리");
		
		Font font = new Font("Serif", Font.BOLD,50);
		font = new Font("SansSerif", Font.BOLD, 50);
		label.setFont(font);
		jp3.add(label);
		
		return jp3;
	}
	
	
	
	//검색어 입력, 엔터버튼 레이아웃  생성할 (JFrame에 붙힐 Panel) 메소드
	public JPanel searchLayout() {
		Panel sp = new Panel();
		   
		//서치바
		search = new TextField(12);

		sp.add(search); //서치바 추가

		//간격 조절 위해 Jpanel에 붙히기
		JPanel sp2 = new JPanel();
		sp2.setBorder(BorderFactory.createEmptyBorder(70 , 10 , 5 , 5));
		sp2.add(sp);
		
		return sp2;   //설정 완료한 패널 객체 리턴	
	}
	
	
	
	//검색, 삭제, 출력, 수정, 학생등록  레이아웃 생성 할  (JFrame에 붙힐 Pannel) 메소드
	public JPanel btnLayout() {
		Panel bp = new Panel();
		bp.setLayout(new GridLayout(0,1,10,10));
		//bp.setLayout(new ); //bntLayout 레이아웃 유형 설정 
		
		//AllRead, Read, Update, Delete, Create
		//출력, 검색, 수정, 삭제 , 학생등록  버튼 생성
		albtn = new YellowButton("출력");
		rbtn = new YellowButton("검색");
		ubtn = new YellowButton("수정");
		dbtn = new YellowButton("삭제");
		cbtn = new YellowButton("학생 등록");
		
		
		bp.add(albtn);	 //출력 버튼추가
		bp.add(rbtn);	//검색 버튼추가
		bp.add(ubtn);	//수정 버튼추가
		bp.add(dbtn);	//삭제 버튼추가
		bp.add(cbtn);	//학생 등록 버튼추가
		
		//간격 조절 위해 Jpannel에 붙히기
		JPanel bp2 = new JPanel();
		bp2.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 5 , 5));
		bp2.add(bp);
		
		return bp2;   //설정 완료한 패널 객체 리턴
		
	}
	
	
	//사진과 종료버튼 레이아웃 생성할  (JFrame에 붙힐 Pannel) 메소드
	public JPanel endLayout() {
		Panel ep = new Panel();
		//ep.setLayout(new ); //endLayout 레이아웃 유형 설정 
		
		//사진, 종료버튼 생성
		endbtn = new YellowButton("종료");
		ep.add(endbtn);

		//간격 조절 위해 Jpannel에 붙히기
		JPanel ep2 = new JPanel();
		ep2.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 5 , 5));
		ep2.add(ep);
	
		
		return ep2;   //설정 완료한 패널 객체 리턴
	}
	
	
	
	//라디오버튼, 리스트 창 레이아웃  생성할  (JFrame에 붙힐 Pannel) 메소드
	   public JPanel listLayout() {
		   	  JPanel list = new JPanel();
		      list.setLayout(new BorderLayout());
		      model=new DefaultTableModel();
		      String header[]= {"ID","이름","나이","주소","전화번호","비상연락망","1차","2차"};
		      model=new DefaultTableModel(header,0);   //header추가, 행은 20개 지정
		      JTable table=new JTable(model);
		      table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		      table.getTableHeader().setReorderingAllowed(false);
		      JScrollPane scrolledTable=new JScrollPane(table);   //스크롤 될 수 있도록 JScrollPane 적용
		      scrolledTable.setBorder(BorderFactory.createEmptyBorder(80,10,10,10));   //너무 붙어있어서 가장자리 띄움(padding)
		      table.setEnabled(false);
		      table.setSize(700, 600);
		      list.add(scrolledTable);
		      list.setSize(700,600);
		      
		      
		      return list; //설정 완료한 패널 객체 리턴
		      
		   }


	//==============================main====================================
	public static void main(String[] args) {
		new MainFrame();
	}
	
	
}
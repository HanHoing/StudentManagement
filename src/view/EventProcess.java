package view;

import dao.StudentDAO;
import dto.StudentDTO;



public class EventProcess{
	//주요 속성 구성 → 데이터베이스 액션 처리 전담 객체 → ScoreDAO
	private StudentDAO dao;

	//학생 정보들 출력 위한 배열
	String student_arr[][]=null;

	//생성자 
	public EventProcess(){

		dao = new StudentDAO();

	}

//===================================기능메소드====================================             
//1, 전체 출력 기능           
	public String[][] studentSelectAll(){

		try
		{

		    //dao의 connection()메소드 호출 → 데이터베이스 연결

	         dao.connection();

	         //dao.lists()호출
	         
	         //행 개수 -> list 크기 만큼 stirng배열..?
	         student_arr=new String[(dao.lists().size())][8];
	         for (int i = 0; i < student_arr.length; i++) {
	        	StudentDTO dto=dao.lists().get(i);
	        	student_arr[i][0]= dto.getSTUDENTID();
	        	student_arr[i][1]= dto.getSNAME();
	        	student_arr[i][2]= ""+dto.getAGE();
	        	student_arr[i][3]= dto.getADDRESS();
	        	student_arr[i][4]= dto.getPHONE();
	        	student_arr[i][5]= dto.getPARENTSPHONE();
	        	student_arr[i][6]= ""+dto.getVACCINEFIRST();
	        	student_arr[i][7]= ""+dto.getVACCINESECOND();
			}
	         
	         //dao의 close()메소드 호출

	         dao.close();   
        	

		}catch(Exception e){

			System.out.println(e.toString());
		}

		return student_arr;

	}
       

//2, 아이디로 검색 출력 기능                
	public String[][] studentSearchId(String studentId){
		// 호출 → 매개변수로 검색할 이름 넘겨주기
		
		try{
			
			dao.connection();

			dao.lists(studentId);
			
			student_arr=new String[(dao.lists(studentId).size())][8];

			for (int i = 0; i < student_arr.length; i++) {
			        StudentDTO dto=dao.lists(studentId).get(i);
			        student_arr[i][0]= dto.getSTUDENTID();
			        student_arr[i][1]= dto.getSNAME();
			        student_arr[i][2]= ""+dto.getAGE();
			        student_arr[i][3]= dto.getADDRESS();
			        student_arr[i][4]= dto.getPHONE();
			        student_arr[i][5]= dto.getPARENTSPHONE();
			        student_arr[i][6]= ""+dto.getVACCINEFIRST();
			        student_arr[i][7]= ""+dto.getVACCINESECOND();
			}
			
		}catch (Exception e){
			System.out.println(e.toString());
		}
		
		return student_arr; //GUI에 출력 위해 넘겨줌

	}
	
	

//3, id 기준 학생 삭제 기능      
	public int studentDelete(String studentId){
		
		int result=0;
		
		try{
			//데이터베이스 연결
			dao.connection();

			result = dao.remove(studentId);
			
			dao.close();


		} catch (Exception e){
			System.out.println(e.toString());
		}

		return result;
	}

	
	
//4, 학생 등록(입력) 기능                 
	public int studentInsert(String studentId,String sName,int age,String address,String phone,String parentsPhone,int vFirst,int vSecond){

		int result=0;
		
		try{

			dao.connection();

			StudentDTO dto = new StudentDTO();

			dto.setSTUDENTID(studentId);
			dto.setSNAME(sName);
			dto.setAGE(age);
			dto.setADDRESS(address);
			dto.setPHONE(phone);
			dto.setPARENTSPHONE(parentsPhone);
			dto.setVACCINEFIRST(vFirst);
			dto.setVACCINESECOND(vSecond);

			result=dao.add(dto);
						
			dao.close();

		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		return result;

	}


//5, 학생 정보 수정 기능
	public int studentUpdate(String studentId,String sName,int age,String address,String phone,String parentsPhone,int vFirst,int vSecond){

		int result=0; //입력한 id가 유효한지 확인
		
		try{

			dao.connection();
			
			StudentDTO dto = new StudentDTO();

			dto.setSTUDENTID(studentId);
			dto.setSNAME(sName);
			dto.setAGE(age);
			dto.setADDRESS(address);
			dto.setPHONE(phone);
			dto.setPARENTSPHONE(parentsPhone);
			dto.setVACCINEFIRST(vFirst);
			dto.setVACCINESECOND(vSecond);

			result=dao.modify(dto);

			dao.close();

			} catch (Exception e){
				System.out.println(e.toString());
			}
		
		return result;
	}


}

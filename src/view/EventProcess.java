package view;

import dao.StudentDAO;
import dto.StudentDTO;



public class EventProcess{
	//�ֿ� �Ӽ� ���� �� �����ͺ��̽� �׼� ó�� ���� ��ü �� ScoreDAO
	private StudentDAO dao;

	//�л� ������ ��� ���� �迭
	String student_arr[][]=null;

	//������ 
	public EventProcess(){

		dao = new StudentDAO();

	}

//===================================��ɸ޼ҵ�====================================             
//1, ��ü ��� ���           
	public String[][] studentSelectAll(){

		try
		{

		    //dao�� connection()�޼ҵ� ȣ�� �� �����ͺ��̽� ����

	         dao.connection();

	         //dao.lists()ȣ��
	         
	         //�� ���� -> list ũ�� ��ŭ stirng�迭..?
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
	         
	         //dao�� close()�޼ҵ� ȣ��

	         dao.close();   
        	

		}catch(Exception e){

			System.out.println(e.toString());
		}

		return student_arr;

	}
       

//2, ���̵�� �˻� ��� ���                
	public String[][] studentSearchId(String studentId){
		// ȣ�� �� �Ű������� �˻��� �̸� �Ѱ��ֱ�
		
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
		
		return student_arr; //GUI�� ��� ���� �Ѱ���

	}
	
	

//3, id ���� �л� ���� ���      
	public int studentDelete(String studentId){
		
		int result=0;
		
		try{
			//�����ͺ��̽� ����
			dao.connection();

			result = dao.remove(studentId);
			
			dao.close();


		} catch (Exception e){
			System.out.println(e.toString());
		}

		return result;
	}

	
	
//4, �л� ���(�Է�) ���                 
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


//5, �л� ���� ���� ���
	public int studentUpdate(String studentId,String sName,int age,String address,String phone,String parentsPhone,int vFirst,int vSecond){

		int result=0; //�Է��� id�� ��ȿ���� Ȯ��
		
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

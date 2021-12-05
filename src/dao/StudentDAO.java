package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import dao.DBConn;
import dto.StudentDTO;



public class StudentDAO{
	private Connection conn;

	
	//DB ���� ��� �޼ҵ�
	public Connection connection() throws ClassNotFoundException, SQLException

	{
		conn = DBConn.getConnection();
		

		return conn;		

	}


//=========================================================================================================================
//1, ��ü ����Ʈ ��� ��� �޼ҵ�
	public ArrayList<StudentDTO> lists() throws SQLException{
		ArrayList<StudentDTO> result = new ArrayList<StudentDTO>();
		
		Statement stmt = conn.createStatement();

		String sql ="SELECT * FROM STUDENTINFO ORDER BY SNAME ASC";
		ResultSet rs = stmt.executeQuery(sql);
		
		
		while(rs.next()){

			StudentDTO dto = new StudentDTO();
			
			dto.setSTUDENTID(rs.getString("STUDENTID"));
			dto.setSNAME(rs.getString("SNAME"));
			dto.setAGE(rs.getInt("AGE"));
			dto.setADDRESS(rs.getString("ADDRESS"));
			dto.setPHONE(rs.getString("PHONE"));
			dto.setPARENTSPHONE(rs.getString("PARENTSPHONE"));
			dto.setVACCINEFIRST(rs.getInt("VACCINEFIRST"));
			dto.setVACCINESECOND(rs.getInt("VACCINESECOND"));

			result.add(dto);

		}
		rs.close();

		stmt.close();

		return result;
		
	}

	

// 2, �˻� ��� �޼ҵ� ID�� �˻�
	public ArrayList<StudentDTO> lists(String searchText) throws SQLException{

		ArrayList<StudentDTO> result = new ArrayList<StudentDTO>();

		Statement stmt = conn.createStatement();		

		String sql =String.format("SELECT * FROM STUDENTINFO WHERE STUDENTID='%s' OR SNAME='%s' OR ADDRESS='%s'"
				,searchText,searchText,searchText);

		ResultSet rs = stmt.executeQuery(sql);

			
		while(rs.next())

		{

			StudentDTO dto = new StudentDTO();

			dto.setSTUDENTID(rs.getString("STUDENTID"));
			dto.setSNAME(rs.getString("SNAME"));
			dto.setAGE(rs.getInt("AGE"));
			dto.setADDRESS(rs.getString("ADDRESS"));
			dto.setPHONE(rs.getString("PHONE"));
			dto.setPARENTSPHONE(rs.getString("PARENTSPHONE"));
			dto.setVACCINEFIRST(rs.getInt("VACCINEFIRST"));
			dto.setVACCINESECOND(rs.getInt("VACCINESECOND"));
			
			result.add(dto);

		}

		rs.close();
		stmt.close();

		return result;

	}

	

//3, ������ ���� ��� �޼ҵ�
	public int modify(StudentDTO dto) throws SQLException{

		int result = 0;

		Statement stmt = conn.createStatement();

		String sql =String.format("UPDATE STUDENTINFO SET SNAME='%s',AGE=%d,ADDRESS='%s',PHONE='%s', PARENTSPHONE='%s', VACCINEFIRST=%d,VACCINESECOND=%d WHERE STUDENTID='%s'",
			dto.getSNAME(),dto.getAGE(),dto.getADDRESS(),dto.getPHONE(),dto.getPARENTSPHONE(),dto.getVACCINEFIRST(),dto.getVACCINESECOND(),dto.getSTUDENTID());

		result=stmt.executeUpdate(sql);

		stmt.close();

		
		return result;

	}

	

//4, ������ ���� ��� �޼ҵ�
	public int remove(String studentId) throws SQLException{

		int result=0;

		Statement stmt = conn.createStatement();

		String sql =String.format("DELETE FROM STUDENTINFO WHERE STUDENTID='%s'",studentId );

		result=stmt.executeUpdate(sql);
		
		stmt.close();
		
		return result;

	}

//5, ������ ���(�Է�) ��� �޼ҵ� 
	public int add(StudentDTO dto) throws SQLException{
		int result=0;
		
		Statement stmt = conn.createStatement();

		String sql =String.format("INSERT INTO STUDENTINFO(STUDENTID,SNAME,AGE,ADDRESS,PHONE,PARENTSPHONE,VACCINEFIRST,VACCINESECOND) "
				+ "VALUES('%s','%s',%d,'%s','%s','%s',%d,%d)",
				dto.getSTUDENTID(), dto.getSNAME(),dto.getAGE(),dto.getADDRESS(),dto.getPHONE(),dto.getPARENTSPHONE(), dto.getVACCINEFIRST(), dto.getVACCINESECOND() );

		result=stmt.executeUpdate(sql);
		stmt.close();
		
		return result;
	
	}


//�����ͺ��̽� ���� ���� ��� �޼ҵ�	
	public void close() throws SQLException{

		DBConn.close();

	}

	
}
	



package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn

{

	//Connection 
	private static Connection dbConn;
	

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		//연결 여부 확인
		if(dbConn==null){

			String url ="jdbc:oracle:thin:@localhost:1521:orcl";

			String user="hoing";

			String pwd="125467";


			Class.forName("oracle.jdbc.driver.OracleDriver");


			dbConn=DriverManager.getConnection(url, user, pwd);
	
		}
		
		return dbConn;
	}

	


public static Connection getConnection(String url, String user,String pwd) throws ClassNotFoundException, SQLException{
	
	if(dbConn==null)

		{

			Class.forName("oracle.jdbc.driver.OracleDriver");

			dbConn=DriverManager.getConnection(url, user, pwd);
			
		}
		return dbConn;
	}

	public static void close() throws SQLException{

		if(dbConn!=null){
			if(!dbConn.isClosed())

				dbConn.close();					
		}
		dbConn=null;

	}

}


package kr.co.sist.callable.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.vo.EmployeeVO;
import kr.co.sist.vo.ResultVO;

public class CallableStatementDAO {
//싱글턴 패턴으로 작성. ->static
	private static CallableStatementDAO csDAO;

	private CallableStatementDAO() {

	}

	public static CallableStatementDAO getInstance() {
		if (csDAO == null) {
			csDAO = new CallableStatementDAO();
		} // end if
		return csDAO;
	}// getInstance

	public ResultVO insertEmployee(EmployeeVO eVO) throws SQLException {
		ResultVO rVO = null;
		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		CallableStatement cstmt = null;

		// 1.
		try {
			// 2.
			String id = "scott";
			String pass = "tiger";
			con = dbCon.getConnection(id, pass);

			// 3.
			cstmt = con.prepareCall("{call insert_employee(?,?,?,?,?,?)}");
			// 4.바인드 변수에 값 할당
			// in
			cstmt.setInt(1, eVO.getEmpno());
			cstmt.setString(2, eVO.getEname());
			cstmt.setString(3, eVO.getJob());
			cstmt.setDouble(4, eVO.getSal());
			// out
			cstmt.registerOutParameter(5, Types.NUMERIC);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			// 5.
			cstmt.execute();

			rVO = new ResultVO(cstmt.getInt(5), cstmt.getNString(6));
		} finally {
			// 6.
			dbCon.dbClose(null, cstmt, con);
		} // end finally

		return rVO;
	}// insertEmployee
//public static void main(String[] args) throws SQLException {
//	System.out.println(CallableStatementDAO.getInstance().insertEmployee
//			(new EmployeeVO(2121, "최수연", "개발자",3100,null)));
//}
	public ResultVO updateEmployee( EmployeeVO eVO) throws SQLException{
		ResultVO rVO= null;
		DbConnection dbCon = DbConnection.getInstance();
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			
		String id ="scott";
		String pass ="tiger";
		//1.
		con = dbCon.getConnection(id, pass);
		//2.
		cstmt =con.prepareCall("{call update_employee (?,?,?,?,?)}");
		//3.
		//4.
			//in
		cstmt.setInt(1, eVO.getEmpno());
		cstmt.setString(2, eVO.getJob());
		cstmt.setDouble(3, eVO.getSal());
			//out
		cstmt.registerOutParameter(4, Types.NUMERIC);
		cstmt.registerOutParameter(5, Types.VARCHAR);
		
		cstmt.execute();
		
		rVO = new ResultVO(cstmt.getInt(4), cstmt.getString(5));
		//5.
		}finally {
			//6.
			dbCon.dbClose(null, cstmt, con);
		}
		
		
		return rVO;
	}//updateEmployee
	
	public int deleteEmployee(int empno) throws SQLException {
		int cnt =0;
		EmployeeVO eVO = null;
		//1.
		DbConnection dbCon = DbConnection.getInstance();
		Connection con =null;
		CallableStatement cstmt = null;
		
		//2.
		try {
			
		String id = "scott";
		String pass = "tiger";
		con = dbCon.getConnection(id, pass);
		//3.
		cstmt =con.prepareCall("{call delete_employee (?,?,?)}");
		//4.
		eVO= new EmployeeVO(empno, null, null, 0.0, null);
		//in parameter
		cstmt.setInt(1, eVO.getEmpno());
		//out parameter
		cstmt.registerOutParameter(2, Types.NUMERIC);
		cstmt.registerOutParameter(3, Types.VARCHAR);
		//5.
		cstmt.execute();
		cnt = cstmt.getInt(2);
		}finally {
			dbCon.dbClose(null, cstmt, con);
		}
		return cnt;
		
		//6.

	}

}// class

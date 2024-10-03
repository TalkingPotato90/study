package kr.co.sist.statement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.co.sist.vo.EmployeeVO;

public class StatementDAO {

	public int insertEmp(EmployeeVO eVO) throws SQLException {
		int cnt = 0;
		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		Connection con = null;
		Statement stmt = null;
		try {
			// 2.커넥션 얻기 : autocommit 쿼리문 하나로 트렌젝션 끝
			con = DriverManager.getConnection(url, id, pass);
			// 3.쿼리문 생성객체 얻기.
			stmt = con.createStatement();
			// 4.쿼리문 수행 후 결과 얻기
			StringBuilder insertEmployee = new StringBuilder();
			insertEmployee.append("insert into employee(empno,ename,job,sal) values (").append(eVO.getEmpno())
					.append(",'").append(eVO.getEname()).append("', '").append(eVO.getJob()).append("',")
					.append(eVO.getSal()).append(")");
			/* int i = */ stmt.executeUpdate(insertEmployee.toString());
			// insert 는 1건 추가 아니면 예외
		} finally {
			// 5.연결 끊기
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // finally
		return cnt;
	}// end insertEmp

	public int updateEmp(EmployeeVO eVO) throws SQLException {
		int cnt = 0;
		// 1. 드라이버 연결 얻기
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		Connection con = null;
		Statement stmt = null;

		try {
			// 2. 커넥션 얻기
			con = DriverManager.getConnection(url, id, pass);
			// 3 쿼리문 생성객체얻기
			stmt = con.createStatement();
			// 4. 수행 후 결과
			// 사원번호에 해당하는 레코드를 찾아서 직무와 연봉을변경.
			StringBuilder updateEmp = new StringBuilder();
			updateEmp.append("   update   employee   ").append("   set   job = '").append(eVO.getJob())
					.append("', sal=").append(eVO.getSal()).append("   where   empno = ").append(eVO.getEmpno());

			cnt = stmt.executeUpdate(updateEmp.toString());

		} finally {
			// 5. 연결 끊기
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

		return cnt;
	}// updateEmp

	public int deleteEmp(int empno) throws SQLException {
		int cnt = 0;
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url ="jdbc:oracle:thin:@localhost:1521:orcl";
		String id ="scott";
		String pass ="tiger";
		Connection con= null;
		Statement stmt = null;
		try {
			
		//2.
		con= DriverManager.getConnection(url,id,pass);
		//3.
		stmt =con.createStatement();
		//4.
		String delectstr = "delete from employee where empno = "+empno;
		cnt= stmt.executeUpdate(delectstr.toString());
		
		}finally {
			//5.
			if(con !=null) {con.close();}
			if(stmt !=null) {stmt.close();}
		}
		return cnt;
	}

	public List<EmployeeVO> selectAllEmp() throws SQLException {
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String id="scott";
		String pass="tiger";
		Connection con = null;
		Statement stmt= null;
		ResultSet rs =null;
		try {
			//2.커넥션 얻기
			con =DriverManager.getConnection(url,id,pass);
			//3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
			
			//4.쿼리문 수행 후 생성 결과 얻기
			String selectEmp = " select empno, ename, job, sal, hiredate from employee";
			rs = stmt.executeQuery(selectEmp);
			
			
			EmployeeVO eVO= null;
			
			while(rs.next()) {
				eVO = new EmployeeVO(rs.getInt("empno"), rs.getString("ename"), 
						rs.getString("job"), rs.getDouble("sal"), rs.getDate("hireDate"));
					list.add(eVO);	
			}
			
			
		}finally {
			//5. 연결 끊기
			if(rs != null) {rs.close();}
			if(stmt != null) {stmt.close();}
			if(con != null) {con.close();}
			
		}
		return list;
	}// selectAllEmp

	public EmployeeVO selectOneEmp(int empno) throws SQLException {
		EmployeeVO eVO = null;
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con =null;
		Statement stmt =null;
		ResultSet rs= null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		try {
			//2.커넥션 얻기
			con =DriverManager.getConnection(url,id,pass);
			
			//3.쿼리문 생성객체 얻기
			stmt=con.createStatement();
			//4.쿼리문 수행 후 결과 얻기
			StringBuilder selectEmp = new StringBuilder();
			selectEmp
			.append("	select	ename, job, sal, hiredate	")
			.append("	from	employee	")
			.append("	where	empno =").append(empno);
			
			rs=stmt.executeQuery(selectEmp.toString());
			String ename = "";
			String job = "";
			double sal =0.0;
			Date hiredate = null;
			//쿼리문이 실행되고, 결과가 나왔을 때 레코드포인터(cursor) 다음에 레코드가 존재하는지?
			if(rs.next()) {
				//레코드 포인터가 다음레코드로 이동하고, 현재 이동 된 위치의 컬럼 값을 얻는다.
	eVO =new EmployeeVO(empno, rs.getString("ename"),  
	rs.getString("job"), rs.getDouble("sal"), rs.getDate("hiredate"));
//	ename =
//	job =
//	sal 
//	hiredate
			}
		}finally {
			if(rs != null) {rs.close();}//rs먼저 연결 해제
			if(stmt != null) {stmt.close();}
			if(con != null) {con.close();}
		}
		
		//5.연결 끊기
		
		
		
		return eVO;
	}

}
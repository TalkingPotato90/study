package day0305.homework_ljh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day0305.homework_ljh.vo.StudentVO;
import kr.co.sist.dao.DbConnection;

public class StudentInfoDAO {
	
	private static StudentInfoDAO siDAO;
	private DbConnection dbCon = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private String id, pass;
	
	private StudentInfoDAO() {
		dbCon = DbConnection.getInstance();
		id = "scott";
		pass = "tiger";
	}
	
	public static StudentInfoDAO getInstance() {
		if(siDAO == null) {
			siDAO = new StudentInfoDAO();
		}	// end if
		return siDAO;
	}	// getInstance
	
	public void insert(StudentVO sVO) throws SQLException {
		try {
			con = dbCon.getConnection(id, pass);
			
			String insert = "insert into work_jdbc(name, img_name, age) values(?, ?, ?)";
			pstmt = con.prepareStatement(insert);
			
			pstmt.setString(1, sVO.getName());
			pstmt.setString(2, sVO.getImg_name());
			pstmt.setInt(3, sVO.getAge());
			
			pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		}	// end finally
	}	// insert

	public void update(StudentVO sVO) throws SQLException {
		try {
			con = dbCon.getConnection(id, pass);
			
			String update = "update work_jdbc set name = ?, img_name = ?, age = ? where student_num = ?";
			pstmt = con.prepareStatement(update);
			
			pstmt.setString(1, sVO.getName());
			pstmt.setString(2, sVO.getImg_name());
			pstmt.setInt(3, sVO.getAge());
			pstmt.setInt(4, sVO.getStudentNum());
			
			pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		}	// end finally
	}	// update

	public void delete(int studentNum) throws SQLException {
		try {
			con = dbCon.getConnection(id, pass);
			
			String delete = "delete from work_jdbc where student_num = ?";
			pstmt = con.prepareStatement(delete);
			
			pstmt.setInt(1, studentNum);
			
			pstmt.executeUpdate();
		} finally {
			dbCon.dbClose(null, pstmt, con);
		}	// end finally
	}	// delete
	
	public List<StudentVO> selectAll() throws SQLException {
		List<StudentVO> listSVO = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			con = dbCon.getConnection(id, pass);
			
			String select = "select rownum, name, img_name, age, input_date, student_num from work_jdbc";
			pstmt = con.prepareStatement(select);
			
			rs = pstmt.executeQuery();
			
			StudentVO sVO = null;
			while(rs.next()) {
				sVO = new StudentVO(rs.getInt("rownum"), rs.getInt("age"), rs.getString("name"), rs.getString("img_name"), rs.getDate("input_date"), rs.getInt("student_num"));
				listSVO.add(sVO);
			}	// end while
		} finally {
			dbCon.dbClose(rs, pstmt, con);
		}	// end finally
		
		return listSVO;
	}	// selectAll
	
}	// class
package kr.co.sist.prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.vo.EmployeeVO;

public class preparedStatementDAO {
    private static preparedStatementDAO psDAO;

    // 싱글턴 패턴을 적용
    private preparedStatementDAO() {

    }// 기본 생성자를 private

    public static preparedStatementDAO getInstance() {
        if (psDAO == null) {
            psDAO = new preparedStatementDAO();
        } // end if

        return psDAO;
    }// getInstance

    public void insertEmp(EmployeeVO eVO) throws SQLException {
        DbConnection dbCon = DbConnection.getInstance();
        // 1.드라이버 로딩
        Connection con = null;
        PreparedStatement pstmt = null;
        // 2.커넥션 얻기
        try {

            String id = "scott";
            String pass = "tiger";
            con = dbCon.getConnection(id, pass);

            // 2.커넥션 얻기
            // 3.쿼리문 생성객체 얻기
            String insertEmp = "insert into employee(empno,ename,job,sal)values (?,?,?,?)";
            pstmt = con.prepareStatement(insertEmp);
            // 4.바인드 변수에 값 설정
            pstmt.setInt(1, eVO.getEmpno());
            pstmt.setString(2, eVO.getEname());
            pstmt.setString(3, eVO.getJob());
            pstmt.setDouble(4, eVO.getSal());
            // 5.쿼리문 수행 후 결과 얻기(주의: Statement의 executeXXX(sql)은 절대 사용ㄴㄴ)
            pstmt.executeUpdate();

        } finally {
            // 6.연결 끊기
            dbCon.dbClose(null, pstmt, con);
        }

    }// insert Emp

    public int updateEmp(EmployeeVO eVO) throws SQLException {
        int cnt = 0;
        DbConnection dbCon = DbConnection.getInstance();
        // 1.
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // 2.
            String id = "scott";
            String pass = "tiger";
            con = dbCon.getConnection(id, pass);
            // 3. 쿼리문 생성 객체 얻기
            String updateEmp = "update employee set job=?,sal=? where empno=?";
            pstmt = con.prepareStatement(updateEmp);
            // 4. 바인드 변수에 값 설정
            pstmt.setString(1, eVO.getJob());
            pstmt.setDouble(2, eVO.getSal());
            pstmt.setInt(3, eVO.getEmpno());
            // 5.
            cnt = pstmt.executeUpdate();
        } finally {
            // 6.
            dbCon.dbClose(null, pstmt, con);
        }
        return cnt;
    }

    /**
     * 사원번호를 입력받아 해당 사원을 삭제
     *
     * @param empno
     * @return
     * @throws SQLException
     */
    public int deleteEmp(int empno) throws SQLException {
        int cnt = 0;

        DbConnection dbconnection = DbConnection.getInstance();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String id = "scott";
            String pass = "tiger";

            connection = dbconnection.getConnection(id, pass);

            String deleteEmp = "delete from employee where empno=?";
            preparedStatement = connection.prepareStatement(deleteEmp);

            preparedStatement.setInt(1, empno);

            cnt = preparedStatement.executeUpdate();
        } finally {
            dbconnection.dbClose(null, preparedStatement, connection);
        }
        return cnt;
    }

    public EmployeeVO selectOneEmp(int empno) throws SQLException {
        EmployeeVO employeeVO = null;
        DbConnection dbconnection = DbConnection.getInstance();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String id = "scott";
            String pass = "tiger";
            connection = dbconnection.getConnection(id, pass);

            StringBuilder selectOneEmp = new StringBuilder();
            selectOneEmp.append(" select ename, job, sal, hiredate, to_char(hiredate,'yyyy-mm-dd') hiredate2 ")
                    .append(" from employee ")
                    .append( " where empno=?");

            preparedStatement = connection.prepareStatement(selectOneEmp.toString());

            preparedStatement.setInt(1, empno);

            resultSet = preparedStatement.executeQuery(); // 조회된 결과를 움직일 수 있는 커서의 제어권을 받는다.
            // 쿼리문을 실행 했을 때 조회걸과가 있다면
            if (resultSet.next()){
                employeeVO = new EmployeeVO(empno,resultSet.getString("ename"),
                        resultSet.getString("job"), resultSet.getDouble("sal"),
                        resultSet.getDate("hiredate"), resultSet.getString("hiredate2"));
            }
        }finally {
            dbconnection.dbClose(resultSet,preparedStatement,connection);
        }

        return employeeVO;
    }

    public List<EmployeeVO> selectAllEmp() throws SQLException{
        List<EmployeeVO> list = new ArrayList<EmployeeVO>();

        DbConnection dbconnection = DbConnection.getInstance();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String id = "scott";
            String pass = "tiger";

            connection = dbconnection.getConnection(id,pass);

            String selectAllEmp = "select empno, ename, job, sal, to_char(hiredate, 'yyyy-mm-dd q \"분기\"') hiredate from employee";
            preparedStatement = connection.prepareStatement(selectAllEmp);

            resultSet = preparedStatement.executeQuery();

            EmployeeVO employeeVO = null;
            while (resultSet.next()){ // 조회된 레코드가 존재하면
                // VO에 검색결과를 저장하고
                employeeVO = new EmployeeVO(resultSet.getInt("empno"), resultSet.getString("ename"),
                        resultSet.getString("job"), resultSet.getDouble("sal"),
                        null,resultSet.getString("hiredate"));
                list.add(employeeVO);
            }
        }finally {
            dbconnection.dbClose(resultSet,preparedStatement,connection);
        }

        return list;
    }
}// class

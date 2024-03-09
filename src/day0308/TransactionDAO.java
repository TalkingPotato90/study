package day0308;

import kr.co.sist.dao.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {
    Connection con = null;

    public int transaction(String name, String addr) throws SQLException {
        int returnCnt = 0;

        // 1. 드라이버 로딩
        DbConnection dbCon = DbConnection.getInstance();

        // 2. 커넥션 얻기
        String id = "scott";
        String pass = "tiger";
        con = dbCon.getConnection(id, pass);
        con.setAutoCommit(false);    // autoCommit 해제

        // 3. 쿼리문 생성 객체 얻기
        String insertTransaction = "insert into test_transaction(name, addr) values(?, ?)";
        PreparedStatement pstmt = con.prepareStatement(insertTransaction);

        // 4. 바인드 변수 값 설정
        pstmt.setString(1, name);
        pstmt.setString(2, addr);

        // 5. 쿼리문 수행 후 결과 얻기
        returnCnt += pstmt.executeUpdate();

        // 3. 쿼리문 생성 객체 얻기
        String insertTransaction2 = "insert into test_transaction2(name, addr) values(?, ?)";
        PreparedStatement pstmt2 = con.prepareStatement(insertTransaction2);

        // 4. 바인드 변수 값 설정
        pstmt2.setString(1, name);
        pstmt2.setString(2, addr);

        // 5. 쿼리문 수행 후 결과 얻기
        returnCnt += pstmt2.executeUpdate();

        return returnCnt;
    }

    public void useTransaction() {
        String name = "윤웅찬";
        String addr = "수원시 영통구";
        try {
            int cnt = transaction(name, addr);
            if (cnt == 2)
                System.out.println("레코드 추가 성공");
            con.commit();
        } catch (SQLException e) {
            try {
                System.out.println("앗! 작업 취소 !!! 일관성 유지");
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                con.close(); // 연결 종료되면 정상종료라고 판단하여 예외가 발생하기 전까지는 commit이 된다
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TransactionDAO tDAO = new TransactionDAO();
        tDAO.useTransaction();
    }

}

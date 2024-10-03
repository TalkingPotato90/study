package kr.co.sist.prepared.dao;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.vo.ZipcodeVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZipcodeDAO {
    private static ZipcodeDAO zDAO;

    private ZipcodeDAO() {
    }

    public static ZipcodeDAO getInstance() {
        if (zDAO == null) {
            zDAO = new ZipcodeDAO();
        }
        return zDAO;
    }

    public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
        List<ZipcodeVO> list = new ArrayList<>();

        DbConnection dbCon = DbConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String id = "scott";
            String pass = "tiger";

            con = dbCon.getConnection(id, pass);

            StringBuilder selectZipcode = new StringBuilder();
            selectZipcode
                    .append(" select zipcode, sido, gugun, dong, nvl(bunji, ' ') bunji ")
                    .append(" from ZIPCODE ")
                    .append(" where dong like ?||'%' ");

            pstmt = con.prepareStatement(selectZipcode.toString());

            pstmt.setString(1, dong);

            rs = pstmt.executeQuery();

            ZipcodeVO zVO = null;
            while (rs.next()) {
                zVO = new ZipcodeVO(rs.getString("zipcode"),
                        rs.getString("sido"),
                        rs.getString("gugun"),
                        rs.getString("dong"),
                        rs.getString("bunji"));
                list.add(zVO);
            }

        } finally {
            dbCon.dbClose(rs, pstmt, con);
        }

        return list;
    }

//    public static void main(String[] args) {
//        ZipcodeDAO zD = ZipcodeDAO.getInstance();
//        try {
//            System.out.println(zD.selectZipcode("역삼동"));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

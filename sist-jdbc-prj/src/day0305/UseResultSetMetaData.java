package day0305;

import kr.co.sist.dao.DbConnection;

import javax.swing.*;
import java.sql.*;

/**
 * 조회하는 테이블의 Schema 정보를 얻을 때 사용하는 객체<br>
 * desc 테이블명 수준의 정보를 얻는다<br>
 * 더 자세한 정보를 얻을 때에는 DD를 사용해야 한다
 */
public class UseResultSetMetaData {
    public UseResultSetMetaData() throws SQLException {
        // EMP테이블의 MetaData를 얻기
        DbConnection dbCon = DbConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String id = "scott";
            String pass = "tiger";

            con= dbCon.getConnection(id,pass);

            // 바인드 변수는 값과 묶이는 변수로 값은 설정할 수 있지만,
            // 컬럼명이나 테이블명에는 사용할 수 없다
            String tname = "emp";
//            String selectEmp = "select * from ?"; // 바인드 변수로는 사용할 수 없다
            String selectEmp = "select * from " + tname;
            pstmt = con.prepareStatement(selectEmp);

//            pstmt.setString(1,tname);

            rs=pstmt.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();

            StringBuilder output = new StringBuilder();
            output.append("\t").append(tname).append(" 테이블의 정보\n")
                    .append("──────────┬──────────┬────────────────────\n");
            output.append("컬럼명 \t Null허용 \t 데이터형 \n").append("──────────┴──────────┴────────────────────\n");
            int size = 0;
            for (int i = 1; i < rsmd.getColumnCount()+1; i++) {
                size = rsmd.getPrecision(i);
                output.append(rsmd.getColumnName(i)).append("\t")
                        .append(rsmd.isNullable(i) == 0?"Not Null" : "").append("\t")
                        .append(rsmd.getColumnTypeName(i));
                if(size != 0) {
                        output.append("(").append(rsmd.getPrecision(i)).append(")");
                }
                output.append("\n");
            }

            JTextArea jta = new JTextArea(output.toString(), 10, 27);
            JScrollPane jsp = new JScrollPane(jta);
            JOptionPane.showMessageDialog(null, jsp);

            System.out.println("컬럼의 수 : " + rsmd.getColumnCount());
            System.out.println("컬럼명 : " + rsmd.getColumnName(2));
            System.out.println("컬럼의 데이터형 : " + rsmd.getColumnTypeName(2));
            System.out.println("컬럼의 크기 : " + rsmd.getPrecision(2));
            System.out.println("null 허용 : " + rsmd.isNullable(2));

        }finally {
            dbCon.dbClose(rs,pstmt,con);
        }
    }

    public static void main(String[] args) {
        try {
            new UseResultSetMetaData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

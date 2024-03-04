package day0304.work0304.model;

import kr.co.sist.dao.Dbconnection;
import kr.co.sist.statement.vo.EmployeeVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDAO {
    private static TableDAO tableDAO;

    private TableDAO() {
    }

    public static TableDAO getInstance(){
        if(tableDAO == null){
            tableDAO = new TableDAO();
        }
        return tableDAO;
    }

    public List<String> selectAllTab() throws SQLException {
        List<String> list = new ArrayList<>();

        Dbconnection dbconnection = Dbconnection.getInstance();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String id = "scott";
            String pass = "tiger";

            connection = dbconnection.getConnection(id,pass);

            String selectAllTab = "select * from tab";
            preparedStatement = connection.prepareStatement(selectAllTab);

            resultSet = preparedStatement.executeQuery();

            String tableName;
            while (resultSet.next()){
                tableName = resultSet.getString("tname");
                list.add(tableName);
            }
        }finally {
            dbconnection.dbClose(resultSet,preparedStatement,connection);
        }
        return list;
    }
}

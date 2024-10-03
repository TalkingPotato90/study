package day0306.work0306;

import kr.co.sist.dao.DbConnection;
import kr.co.sist.vo.CarVO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarSearchDAO {
    private static CarSearchDAO carSearchDAO;
    private static String maker;

    private CarSearchDAO(){}

    public static CarSearchDAO getInstance(){
        if (carSearchDAO == null){
            carSearchDAO = new CarSearchDAO();
        }
        return carSearchDAO;
    }

    public List<CarVO> searchCar() throws SQLException {
        List<CarVO> list = new ArrayList<>();

        DbConnection dbConnection = DbConnection.getInstance();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String id = "scott";
            String pass = "tiger";

            connection = dbConnection.getConnection(id,pass);

            String searchCar = " select car_country.country, car_maker.maker, car_model.model, car_model.car_year, car_model.car_option, car_model.price " +
                    " from car_country " +
                    " join car_maker on car_country.maker = car_maker.maker " +
                    " join car_model on car_maker.model = car_model.model " +
                    " where car_maker.maker=? " +
                    " order by car_model.hiredate desc" +
                    " fetch first 10 rows only ";

            preparedStatement = connection.prepareStatement(searchCar);
            maker = JOptionPane.showInputDialog("차량제조사");
            System.out.println(maker);
            preparedStatement.setString(1, maker);

            resultSet = preparedStatement.executeQuery();

            CarVO carVO = null;
            while(resultSet.next()){
                carVO = new CarVO(resultSet.getString("country"),
                        resultSet.getString("maker"),
                        resultSet.getString("model"),
                        resultSet.getString("car_year"),
                        resultSet.getInt("price"),
                        resultSet.getString("car_option")
                        );
                list.add(carVO);
            }
        }finally {
            dbConnection.dbClose(resultSet,preparedStatement,connection);
        }

        return list;
    }
}

package day0306.work0306;

import kr.co.sist.vo.CarVO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class CarSearch {

    public void searchCarInfo() {
        CarSearchDAO carSearchDAO = CarSearchDAO.getInstance();
        try {
            List<CarVO> carList = carSearchDAO.searchCar();
            StringBuilder output = new StringBuilder();
            if (carList.isEmpty()) {
                output.append("데이터가 없습니다. 'ㅁ'");

            } else {
                for (CarVO carVO : carList) {
                    output.append(carVO.getCountry()).append("\t")
                            .append(carVO.getMaker()).append("\t")
                            .append(carVO.getModel()).append("\t")
                            .append(carVO.getCar_year()).append("\t")
                            .append(carVO.getCar_option()).append("\t")
                            .append(carVO.getPrice()).append("\n");
                } // end for
            } // end else
            JTextArea jta = new JTextArea(output.toString(), 10, 80);
            JScrollPane jsp = new JScrollPane(jta);
            JOptionPane.showMessageDialog(null, jsp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CarSearch carSearch = new CarSearch();
        carSearch.searchCarInfo();
    }
}

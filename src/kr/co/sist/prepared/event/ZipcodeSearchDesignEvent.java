package kr.co.sist.prepared.event;

import kr.co.sist.design.ZipcodeSearchDesign;
import kr.co.sist.prepared.dao.ZipcodeDAO;
import kr.co.sist.vo.ZipcodeVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

public class ZipcodeSearchDesignEvent extends WindowAdapter implements ActionListener {
    private ZipcodeSearchDesign zsd;

    public ZipcodeSearchDesignEvent(ZipcodeSearchDesign zsd) {
        this.zsd = zsd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dong = zsd.getJtfDong().getText().trim();
        if (dong.isEmpty()) {
            JOptionPane.showMessageDialog(zsd, "동 이름은 필수 입력입니다.");
            return;
        }
        setZipcode(dong);

        zsd.getJtfDong().setText("");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        zsd.dispose();
    }

    private void setZipcode(String dong) {
        ZipcodeDAO zDAO = ZipcodeDAO.getInstance();
        try {
            // 입력된 동을 사용한 검색 결과를 받아와서
            List<ZipcodeVO> list = zDAO.selectZipcode(dong);

            // 디자인의 모델객체에 값을 설정한다.
            DefaultTableModel dtm = zsd.getDtmJtabResult();

            // 값을 설정하기 전에 모델객체 초기화
            dtm.setRowCount(0);

            String[] rowData = null;
            ZipcodeVO zVO = null;
            StringBuilder sbAddr = new StringBuilder();

            if (list.isEmpty()){
                JOptionPane.showMessageDialog
                        (zsd,dong + " 데이터가 없습니다","검색 오류",JOptionPane.ERROR_MESSAGE);
            }

            for (ZipcodeVO zipcodeVO : list) {
                zVO = zipcodeVO;
                sbAddr.append(zVO.getSido()).append(" ")
                        .append(zVO.getGugun()).append(" ")
                        .append(zVO.getDong()).append(" ")
                        .append(zVO.getBunji());
                // 행의 값을 넣을 배열을 만들고
                rowData = new String[2];
                // 우편번호
                rowData[0] = zVO.getZipcode();
                // 주소를 할당
                rowData[1] = sbAddr.toString();

                // Model객체의 행으로 등록
                dtm.addRow(rowData);

                // StringBuilder 초기화
                sbAddr.delete(0, sbAddr.length());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

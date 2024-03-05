package kr.co.sist.design;

import kr.co.sist.prepared.event.ZipcodeSearchDesignEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ZipcodeSearchDesign extends JFrame {

    private JTextField jtfDong;
    private JButton jbtnSearch;
    private JTable jtabResult;
    private DefaultTableModel dtmJtabResult;

    public ZipcodeSearchDesign(){
        super("우편번호 검색");

        Font font = new Font("맑은 고딕",Font.BOLD,14);
        jtfDong = new JTextField(10);
        jbtnSearch = new JButton("검색");
        JLabel jlblDong = new JLabel("동 이름");
        jlblDong.setFont(font);
        jtfDong.setFont(font);
        jbtnSearch.setFont(font);

        String[] columnName= {"우편번호", "주소"};
        // 행이 없고, 컬럼명만 가진 DefaultTableModel
        dtmJtabResult = new DefaultTableModel(columnName,0);
        jtabResult = new JTable(dtmJtabResult);
        JScrollPane jspJtaResult = new JScrollPane(jtabResult);
        jspJtaResult.setBorder(new TitledBorder("검색결과"));

        // JTable 컬럼의 넓이 변경
        jtabResult.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtabResult.getColumnModel().getColumn(1).setPreferredWidth(700);

        // 테이블 내용 가운데 정렬하기
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        jtabResult.getColumnModel().getColumn(0).setCellRenderer(dtcr);

        // 배치
        JPanel jpNorth = new JPanel();
        jpNorth.add(jlblDong);
        jpNorth.add(jtfDong);
        jpNorth.add(jbtnSearch);

        add("North", jpNorth);
        add("Center", jspJtaResult);

        ZipcodeSearchDesignEvent zsde = new ZipcodeSearchDesignEvent(this);
        jtfDong.addActionListener(zsde);
        jbtnSearch.addActionListener(zsde);
        addWindowListener(zsde);

        setBounds(100,100,800,600);
        setVisible(true);
    }

    public JTextField getJtfDong() {
        return jtfDong;
    }

    public JButton getJbtnSearch() {
        return jbtnSearch;
    }

    public JTable getJtabResult() {
        return jtabResult;
    }

    public DefaultTableModel getDtmJtabResult() {
        return dtmJtabResult;
    }

    public static void main(String[] args) {
        new ZipcodeSearchDesign();
    }
}

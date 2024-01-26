package day0126;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class UseJTable extends JFrame {
    public UseJTable() {
        super("MVC 패턴을 도입한 JTable");

        // 1. Model 객체 생성
        String[] columnName = {"번호","이름","나이","이메일"};
        String[][] data = {
                {"1","루피","24","test@test.com"},
                {"2","히루루크","50","hihi@test.com"},
                {"3","쵸파","13",""},
                {"4","샹디","27","cook@test.com"}
        };
        DefaultTableModel dtm = new DefaultTableModel(data, columnName);
        // 2. Model 객체와 has a 관계로 View 생성
        JTable jtable = new JTable(dtm);

        // 3. 데이터 추가 -> Model 객체를 사용
        String [] tempData = {"5","샹크스","40",""};
        dtm.addRow(tempData);

        Vector<String > vec = new Vector<String >();
        vec.add("6");
        vec.add("윤웅찬");
        vec.add("27");
        vec.add("chan@sist.co.kr");

        dtm.addRow(vec);

        JScrollPane jsp = new JScrollPane(jtable);
        jsp.setBorder(new TitledBorder("해적왕 후보자"));

        jtable.setRowHeight(25);

//        add(jtable); // 스크롤 바를 사용하지 않으면 컬럼명이 보이지 않는다
        add(jsp); // 스크롤 바를 사용하지 않으면 컬럼명이 보이지 않는다

        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UseJTable();
    }
}

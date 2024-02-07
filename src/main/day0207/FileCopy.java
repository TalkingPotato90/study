package day0207;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy extends JFrame implements ActionListener {

    private JLabel jlOutput;

    public FileCopy() {
        super("파일 복사");

        JButton jbtnCopy=new JButton("복사할 파일 선택");
        jlOutput=new JLabel("복사할 파일을 선택해주세요.");
        JPanel jpCenter=new JPanel();
        jpCenter.add(jbtnCopy);

        jlOutput.setBorder(new TitledBorder("출력"));

        add("Center",jpCenter);
        add("South",jlOutput);

        jbtnCopy.addActionListener(this);

        setBounds(100,100,300,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void fileCopy() throws IOException {
        //원본파일명 얻기
        FileDialog fdOpen=new FileDialog(this,"복사할 파일 선택", FileDialog.LOAD);
        fdOpen.setVisible(true);

        if(fdOpen.getDirectory()==null) {
            return;
        }

        File fileOrigin=new File(fdOpen.getDirectory()+fdOpen.getFile());
        if(!fileOrigin.exists()) {
            JOptionPane.showMessageDialog(this, " 파일이 존재하지 않습니다.");
            return;
        }

        //복사할 파일명을 생성 : 원본파일명_bak.확장자 => a.txt선택되면
        // => a_bak.txt로 파일명을 같은 디렉토리에 생성되도록 만들어주세요.
        StringBuilder tempFileName=new StringBuilder(fileOrigin.getAbsolutePath());
        tempFileName.insert(tempFileName.lastIndexOf("."),"_bak");

        File fileCopy=new File(tempFileName.toString());

        //스트림 연결
        //읽기
        FileInputStream fis=null;
        //쓰기
        FileOutputStream fos=null;

        try {
            fis=new FileInputStream(fileOrigin);
            fos=new FileOutputStream(fileCopy);

            //HDD의 특성을 무시한 코드 : 파일에서 읽어들여
//			int data=0;
//			while((data=fis.read())!=-1) {
//				//복사할 파일에 연결된 스트림에 쓰고
//				fos.write(data);
//			}
//			//스트림에 남아있는 내용을 목적지 파일에 분출한다.
//			fos.flush();

            //HDD의 특성을 고려한 코드 : 파일에서 읽어들여
            //1. HDD 한번에 512byte를 읽어 들여옴으로 그 값을 저장할 빈 배열을 생성
            byte[] data=new byte[512];
            //2. HDD에서 읽어들인 내용을 빈 배열에 저장하고, 크기를 변수에 저장
            int dataSize=0;
            while((dataSize=fis.read(data))!=-1) {
                //3. 배열에 값을 존재하는 크기까지만 스트림에 쓴다.
                System.out.println(dataSize);
            }
            //4. 스트림에 남은 내용을 목적지로 분출
            fos.flush();

            jlOutput.setText(fileCopy.getName()+"파일명으로 복사가 되었습니다.");

        }finally {
            //연결을 끊는다.
            if(fis!=null) {fis.close();}
            if(fos!=null) {fos.close();}

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            fileCopy();
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(this, "파일 복사 중 문제가 발생했음.");
            e1.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new FileCopy();

    }

}
package day0206.work0206;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class JavaMemoEvent extends WindowAdapter implements ActionListener {
    private JavaMemoDesign jmd;

    public JavaMemoEvent(JavaMemoDesign jmd) {
        this.jmd = jmd;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        jmd.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jmd.getJmiNew()) {
            try {
                newMemo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (ae.getSource() == jmd.getJmiOpen()) {
            try {
                openMemo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (ae.getSource() == jmd.getJmiSave()) {
            try {
                saveMemo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (ae.getSource() == jmd.getJmiNewSave()) {
            saveNewMemo();
        }
        if (ae.getSource() == jmd.getJmiClose()) {
            closeMemo();
        }
        if (ae.getSource() == jmd.getJmiFont()) {
            fontDialog();
        }
        if (ae.getSource() == jmd.getJmiHelp()) {
            helpDialog();
        }
    }

    private void newMemo() throws IOException {
        applyFont();

        if (!checkEmpty()) {
            askSave();
        } else {
            resetJTA();
            setTitleBar();
        }
    }

    private void openMemo() throws IOException {
        if (!checkEmpty()) {
            if (checkFirstOpen()) {
                askSave();
                saveNewMemo();
                openMemopad();
            } else {
                checkChange();
                askSave();
                saveMemopad();
                openMemopad();
            }
        } else openMemopad();
    }

    private void saveMemo() throws IOException {
        if (checkFirstOpen()) {
            saveNewMemo();
        } else {
            overWrite();
            saveMemopad();
        }
    }

    private void saveNewMemo() {
        FileDialog fdSave = new FileDialog(jmd, "새이름으로 저장", FileDialog.SAVE);
        fdSave.setVisible(true);

        String fullPath = fdSave.getDirectory() + fdSave.getFile();

        File newTextFile = new File(fullPath + ".txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newTextFile))) {
            String msg = jmd.getJtaNote().getText();
            bw.write(msg);
            bw.flush();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        resetJTA();
    }

    private void closeMemo() {
        saveFontInfo();
        jmd.dispose();
    }

    private void fontDialog() {
        new MemoFontEvent(new MemoFontDesign(jmd));
    }

    private void helpDialog() {
        new MemoHelpEvent(new MemoHelpDesign(jmd));
    }

    private void askSave() throws IOException {
        int flag = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?");
        switch (flag) {
            case JOptionPane.OK_OPTION:
                saveMemopad();
                resetJTA();
                setTitleBar();
                break;
            case JOptionPane.NO_OPTION:
                resetJTA();
                setTitleBar();
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
        }
    }

    private void saveMemopad(){
        overWrite();
    }

    private void resetJTA() {
        jmd.getJtaNote().setText("");
    }

    private void setTitleBar() {
        jmd.setTitle("메모장 - 새글");
    }

    private void openMemopad() {

    }

    private void checkChange() {
    }

    private void overWrite() {
    }

    private void saveFontInfo() {
    }

    private void applyFont() {
    }

    private boolean checkEmpty() {
        return jmd.getJtaNote().getText().isEmpty();
    }

    private boolean checkFirstOpen() {
        return true;
    }
}

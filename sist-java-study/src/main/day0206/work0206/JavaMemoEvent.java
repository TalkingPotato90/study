package day0206.work0206;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class JavaMemoEvent implements ActionListener {
    private final JavaMemoDesign jmd;
    private String openPath;
    private StringBuilder newMemo;

    public JavaMemoEvent(JavaMemoDesign jmd) {
        this.jmd = jmd;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JMenuItem source = (JMenuItem) ae.getSource();
        if (source == jmd.getJmiNew()) {
            newMemo();
        } else if (source == jmd.getJmiOpen()) {
            openMemo();
        } else if (source == jmd.getJmiSave()) {
            saveMemo();
        } else if (source == jmd.getJmiNewSave()) {
            saveNewMemo();
        } else if (source == jmd.getJmiClose()) {
            closeMemo();
        } else if (source == jmd.getJmiFont()) {
            fontDialog();
        } else if (source == jmd.getJmiHelp()) {
            helpDialog();
        }
    }

    private void newMemo() {
        if (!checkEmpty()) {
            try {
                askSave();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            resetJTA();
            setTitleBar();
        }
    }

    private void openMemo() {
        if (!checkEmpty()) {
            try {
                if (checkFirstOpen()) {
                    askSave();
                    saveNewMemo();
                    openMemopad();
                } else if (checkChange()) {
                    askSave();
                    openMemopad();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                openMemopad();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveMemo() {
        if (checkFirstOpen()) {
            saveNewMemo();
        } else {
            try {
                askSave();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveNewMemo() {
        FileDialog fdSave = new FileDialog(jmd, "새이름으로 저장", FileDialog.SAVE);
        fdSave.setVisible(true);
        String fullPath = fdSave.getDirectory() + fdSave.getFile();
        File newTextFile = new File(fullPath);
        if (!fullPath.endsWith(".txt")) {
            newTextFile = new File(fullPath + ".txt");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newTextFile))) {
            bw.write(jmd.getJtaNote().getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        resetJTA();
        setTitleBar();
    }

    private void closeMemo() {
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
                overWrite();
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

    private void resetJTA() {
        jmd.getJtaNote().setText("");
    }

    private void setTitleBar() {
        jmd.setTitle("메모장 - 새글");
    }

    private void openMemopad() throws IOException {
        FileDialog fdOpen = new FileDialog(jmd, "열기", FileDialog.LOAD);
        fdOpen.setVisible(true);

        openPath = fdOpen.getDirectory() + fdOpen.getFile();

        File readFile = new File(openPath);
        newMemo = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(readFile))) {
            String str;
            while ((str = br.readLine()) != null) {
                newMemo.append(str).append("\n");
            }
        }

        jmd.getJtaNote().setText(newMemo.toString());

        String fileName = readFile.getName();

        jmd.setTitle(fileName);

    }

    private boolean checkChange() {
        String presentMemo = jmd.getJtaNote().getText();
        String openedMemo = newMemo.toString();
        return !presentMemo.equals(openedMemo);
    }

    private void overWrite() throws IOException {
        if (openPath == null) {
            saveNewMemo();
            return;
        }

        File readFile = new File(openPath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(readFile))) {
            bw.write(jmd.getJtaNote().getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkEmpty() {
        return jmd.getJtaNote().getText().isEmpty();
    }

    private boolean checkFirstOpen() {
        String title = jmd.getTitle();
        return !title.endsWith(".txt");
    }

}
package day0131.work0131;


import java.awt.*;
import java.awt.event.*;

public class MemoFontEvent extends WindowAdapter implements ActionListener, MouseListener {

    private MemoFontDesign mfd;
    private Font previewFont;

    public MemoFontEvent(MemoFontDesign mfd) {
        this.mfd = mfd;
        Font currentFont = mfd.getSuperJtaNote().getFont();
        mfd.getJtfFont().setText(currentFont.getName());
        String tempStyle;
        switch (currentFont.getStyle()) {
            case Font.PLAIN:
                tempStyle = "일반";
                break;
            case Font.BOLD:
                tempStyle = "굵게";
                break;
            case Font.ITALIC:
                tempStyle = "기울임꼴";
                break;
            case Font.BOLD | Font.ITALIC:
                tempStyle = "굵은 기울임꼴";
                break;
            default:
                tempStyle = "일반";
        }
        mfd.getJtfStyle().setText(tempStyle);
        mfd.getJtfSize().setText(String.valueOf(currentFont.getSize()));

        mfd.getJlFont().setSelectedValue(currentFont.getName(), true);
        mfd.getJlStyle().setSelectedValue(tempStyle, true);
        mfd.getJlSize().setSelectedValue(String.valueOf(currentFont.getSize()), true);
    }


    @Override
    public void windowClosing(WindowEvent e) {
        mfd.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == mfd.getJbtnCheck()) {
            applyFont();
        }
        if (ae.getSource() == mfd.getJbtnCancel()) {
            closeFontDialog();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        setPreview();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void setPreview() {
        String fontName = (String) mfd.getJlFont().getSelectedValue();
        String tempStyle = (String) mfd.getJlStyle().getSelectedValue();
        String tempSize = (String) mfd.getJlSize().getSelectedValue();

        mfd.getJtfFont().setText(fontName);
        mfd.getJtfStyle().setText(tempStyle);
        mfd.getJtfSize().setText(tempSize);

        if (fontName != null && tempStyle != null && tempSize != null) {
            int fontStyle = switch (tempStyle) {
                case "일반" -> Font.PLAIN;
                case "굵게" -> Font.BOLD;
                case "기울임꼴" -> Font.ITALIC;
                case "굵은 기울임꼴" -> Font.BOLD | Font.ITALIC;
                default -> Font.PLAIN;
            };

            int fontSize = Integer.parseInt(tempSize);
            previewFont = new Font(fontName, fontStyle, fontSize);
            mfd.getJlPreview().setFont(previewFont);
        }
    }

    private void applyFont() {
        mfd.getSuperJtaNote().setFont(previewFont);
        mfd.dispose();
    }

    private void closeFontDialog() {
        mfd.dispose();
    }
}

package kr.co.sist.module.login.controller;

import kr.co.sist.module.login.vo.Login;
import kr.co.sist.util.Validation;
import kr.co.sist.view.logAnalysis.LogAnalyzerView;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * login 기능을 전담할 controller
 */
public class LoginController {
    private String id,password;
    private LoginEventController loginEventController;

    public LoginController() {
        setInputInfo();
        checkEmpty();
        loginEvent();
    }

    /**
     * id와 password를 입력받은 정보로 저장
     */
    public void setInputInfo(){
        this.id = LoginEventController.inputId;
        this.password = LoginEventController.inputPassword;
    }

    /**
     * 기능 1 : 유효성 검사<br>
     * 설명 : 아이디와 비밀번호 값이 입력되어 있는지 확인한다.
     */
    public void checkEmpty() {
        Validation validator = new Validation();

        boolean idEmpty = validator.isEmpty(id);
        boolean passwordEmpty = validator.isEmpty(password);

        if (idEmpty || passwordEmpty) {
            JOptionPane.showMessageDialog(null,"아이디와 비밀번호를 모두 입력해주세요.");
        }
    }

    /**
     * 기능 2 : 비밀번호 일치 여부 확인<br>
     * 설명1 : 입력된 아이디와 비밀번호가 vo와 일치하는지 확인한다.<br>
     * 설명2 : (입력된 아이디, 비밀번호) 비교 (목록으로 갖고 있는 데이터 리스트 userInfo)<br>
     *  userInfo Type => List<Map<String, String>>, User Type => Map<String, String>
     *
     * 결과 : 일치하는 데이터가 있으면 true 리턴, 아니면 false 리턴
     */

    public boolean confirmUserPassword(){
        //입력받은 id, password와 특정 user정보 1개를 인자로 받아서 id와 password가 일치하는지 비교하고
        //대상이 일치하면 true 리턴
        Login login = new Login();
        List<Map<String, String>> users = login.getUserInfo();
        for(Map<String, String> user : users){
            String userId = user.get("id");

            if(id.equals(userId)){
                //비밀번호 검증 로직
                String userPassword = user.get("password");

                if(password.equals(userPassword)){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 로그인 한 사용자의 권한이 관리자인지 일반인지 확인한다
     * @return 관리자이면 true
     */
    public static boolean isAdmin(){
        Login login = new Login();
        List<Map<String, String>> userInfo = login.getUserInfo();

        // 입력된 아이디와 비밀번호가 일치하는 사용자 정보를 찾음
        for (Map<String, String> user : userInfo) {
            String userId = user.get("id");
            String userPassword = user.get("password");
            String authRole = user.get("authRole");

            // 입력된 아이디와 비밀번호가 일치하는 사용자를 찾았을 때
            if (userId.equals(LoginEventController.inputId) && userPassword.equals(LoginEventController.inputPassword)) {
                return authRole.equals("ADMIN");
            }
        }
        // 입력된 아이디와 비밀번호에 해당하는 사용자 정보를 찾지 못했을 때
        return false;
    }

    /**
     * 기능 3 : 로그인 버튼 클릭 이벤트<br>
     * 설명 : 로그인 버튼 클릭 시, 로그인 정보와 일치하면 로그분석으로 이동하고<br>
     *       비밀번호가 일치하지 않으면 확인을 위한 알림창을 출력한다.
     */
    public void loginEvent() {
        if (confirmUserPassword()) {
            if (isAdmin()) {
                JOptionPane.showMessageDialog(null, id + " 관리자 권한 로그인 성공");
            } else {
                JOptionPane.showMessageDialog(null, id + " 일반 권한 로그인 성공");
            }
            SwingUtilities.invokeLater(LogAnalyzerView::new);
        } else {
            JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다. 아이디와 비밀번호를 확인하세요");
        }
    }
}

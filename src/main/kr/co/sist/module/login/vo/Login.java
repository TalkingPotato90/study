package kr.co.sist.module.login.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 로그인에 필요한 자격정보 저장
 */
public class Login {

    private String id;
    private String password;
    private String authRole; // ADMIN(관리자), NORMAL(일반)
    private List<Map<String, String>> userInfo;

    public Login() {
        userInfo = new ArrayList<>();
        setUserInfo("admin", "1234", "ADMIN");
        setUserInfo("root", "1111", "NORMAL");
        setUserInfo("administrator", "12345", "ADMIN");
    }

    /**
     * 입력받은 사용자 정보를 기반으로 맵 생성
     * @param id 아이디
     * @param password 비밀번호
     * @param authRole 권한 : NORMAL 권한은 Report 불가
     */
    public void setUserInfo(String id, String password, String authRole) {
        Map<String, String> user = new HashMap<>();
        user.put("id", id);
        user.put("password", password);
        user.put("authRole", authRole);
        userInfo.add(user);
    }

    public List<Map<String, String>> getUserInfo() {
        return userInfo;
    }
}

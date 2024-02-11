package kr.co.sist.util;

/**
 * 공통적으로 사용할 validation
 */
public class Validation {

    /**
     * Desc. : 인자로 넘어온 str에 값이 없으면 true return
     */
    public boolean isEmpty(String str){
        return str == null || str.isEmpty();
    }
}

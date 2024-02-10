package util;

public class Validation {

    /***
     * Desc. : 인자로 넘어온 str에 값이 없으면 true return
     */
    public boolean isEmpty(String str){
        boolean result = false;

        if(str == null || str.isEmpty()){
            result = true;
        }

        return result;
    }


}

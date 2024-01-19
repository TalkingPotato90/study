package day0119.work0119;

public class Work0119 {

    public String retunBackUpFileName(String fileName){
//        String result = "test_bak";
        String result = fileName.concat("_bak");
//        if(fileName.equals("temp")){
//            result = "temp_bak";
//        }
//        if(fileName.equals("test.txt")){
//            result = "test_bak.txt";
//        }else if(fileName.equals("temp.exe")){
//            result = "temp_bak.exe";
//        }
        String tempFileName;
        String tempExtensionName;
        if(fileName.contains(".")){
            tempFileName = fileName.substring(0, fileName.lastIndexOf("."));
            tempExtensionName = fileName.substring(fileName.lastIndexOf("."));
            result = tempFileName + "_bak" + tempExtensionName;
        }

        return result;
    }
    public static void main(String[] args) {

    }
}

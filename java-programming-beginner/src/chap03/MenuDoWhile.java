package chap03;

public class MenuDoWhile {
    public static void main(String[] args)
            throws java.io.IOException {
        System.out.println("-->메뉴선택의 do~while 문 실습<--\n");
        char choice;
        do {
            System.out.println("제어/반복문");
            System.out.println("1. if");
            System.out.println("2. switch");
            System.out.println("3. while");
            System.out.println("4. do-while");
            System.out.println("5. for\n");
            System.out.println("번호 선택");
            choice = (char) System.in.read();
        } while (choice < '1' || choice > '5');
        System.out.println("\n");
        switch (choice) {
            case '1':
                System.out.println("if문 : \n");
                System.out.println("if(조건문) 문장1;");
                System.out.println("else 문장2;");
                break;
            case '2':
                System.out.println("switch문 : \n");
                System.out.println("switch(조건문) {");
                System.out.println("case 상수:");
                System.out.println("문장...");
                System.out.println("break;");
                System.out.println("//...");
                System.out.println("}");
                break;
            case '3':
                System.out.println("while문 : \n");
                System.out.println("while(조건문) 문장;");
                break;
            case '4':
                System.out.println("do-while문 : \n");
                System.out.println("do {");
                System.out.println("문장들.....;");
                System.out.println("} while(조건문);");
                break;
            case '5':
                System.out.println("for문 : \n");
                System.out.println("for(초기식;조건식;반복식)");
                System.out.println("문장들......;");
                break;
        }
        System.out.println("\n");
    }
}


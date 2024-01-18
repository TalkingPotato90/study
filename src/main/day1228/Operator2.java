package day1228;

/*
산술 연산자 : +, -, *, /, %
*/
class Operator2 {
    public static void main(String[] args) {
        int i = 10;
        System.out.println(i + "를 2로 나눈 나머지 : " + (i % 2));
        // 0 또는 1 나옴
        i = 11;
        System.out.println(i + "를 2로 나눈 나머지 : " + (i % 2));
        // 0 또는 1 나옴

        int birth = 1990;
        System.out.println(birth + "를 12로 나눈 나머지 : " + (birth % 12));
        // 0-원숭이, 1-닭, 2-개, 3-돼지, 4-쥐, 5-소, 6-호랑이, 7-토끼, 8-용, 9-뱀, 10-말, 11-양
    }
}


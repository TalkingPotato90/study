package day1228;

/*
쉬프트연산자
<< : left shift - 비트를 왼쪽으로 밀고, 밀어서 빈칸을 항상 0으로 채운다
>> : right shift - 비트를 왼쪽으로 밀고, 밀어서 빈칸을
				   최상위 부호비트에 따라 양수면 0을, 음수면 1을 채운다
>>> : unsigned right shift - 비트를 오른쪽으로 밀고, 밀어서 빈칸을
							 항상 0으로 채운다.
*/
class Operator3 {
    public static void main(String[] args) {

        int i = 5;
        System.out.println(i + " << 3 = " + (i << 3));

        i = 75;
        System.out.println(i + " >> 2 = " + (i >> 2));

        i = 29;
        System.out.println(i + " >>> 1 = " + (i >>> 1));

        i = 1;
        System.out.println(i + " << 31 = " + (i << 31));
        System.out.println(i + " << 32 = " + (i << 32));
        System.out.println(i + " << 33 = " + (i << 33));

        i = -1;
        System.out.println(i + " >> 5 = " + (i >> 5));

        System.out.println(i + " >>> 1 = " + (i >>> 1));
    } // main
} // class
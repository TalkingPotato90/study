package chap03;

public class NestedWhile {
    public static void main(String[] args) {
        int value;
        int index = 1;
        System.out.println("\n\t\t\t\t구 구 단");
        System.out.println("\t\t\t\t========");
        while (index <= 9){
            int in = 2;
            System.out.println("\t");
            while (in <= 9){
                int mult = in * index;
                System.out.print(in + " X " + index + " = "+((mult >= 10)?"":" ")+mult+"  ");
                in = in+1;
            }
            index = index +1;
            System.out.println("\n");
        }
    }
}

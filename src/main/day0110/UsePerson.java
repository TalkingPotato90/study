package day0110;

/**
 * Person 클래스를 사용하기 위해서 만드는 클래스<br>
 *
 */
public class UsePerson {

    private void usePerson(){
        Person ogong = new Person(); // 사람이 태어난 것
        // -> 기본적으로 가지고 있어야 할 눈,코,입이 없다
        // -> 객체가 생성될 때 기본적으로 가지고 있어야 할 값을 설정하는 코드를 어디에선가 작성
        // -> 생성자가 필요한 이유

//        ogong.setEyes(2);
//        ogong.setNose(1);
//        ogong.setMouth(1);
        ogong.setName("손오공");

        System.out.printf("눈 %d개 코 %d개 입 %d개 이름 %s \n",
                ogong.getEyes(), ogong.getNose(), ogong.getMouth(), ogong.getName());

        //동사적인 특징 : Overloading
        System.out.println(ogong.eat());
        System.out.println(ogong.eat("돈까스",10_000));

        //////////////////////////////자신을 객체화하여 사용하는 코드 작성//////////////////////////////////////

        Person me = new Person();

//        me.setEyes(2);
//        me.setNose(1);
//        me.setMouth(1);
        me.setName("감자");

        System.out.printf("눈 %d개 코 %d개 입 %d개 이름 %s \n",
                me.getEyes(), me.getNose(), me.getMouth(), me.getName());

        //동사적인 특징 : Overloading
        System.out.println(me.eat());
        System.out.println(me.eat("김밥",3_500));

        // 천진반 객체를 생성
        Person jinban = new Person(3,1,1);
        jinban.setName("천진반");

        System.out.printf("눈 %d개 코 %d개 입 %d개 이름 %s \n",
                jinban.getEyes(), jinban.getNose(), jinban.getMouth(), jinban.getName());

        System.out.println(jinban.eat());
        System.out.println(jinban.eat("선두",0));


    }

    public static void main(String[] args) {
        UsePerson up = new UsePerson();
        up.usePerson();
    }
}

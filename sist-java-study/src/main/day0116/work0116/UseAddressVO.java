package day0116.work0116;

public class UseAddressVO {
    public static void main(String[] args) {
        AddressVO[] addressVO = inputData();

        printAddressVO(addressVO);

        int nameSoo = checkNameSoo(addressVO);
        int seoulPeople = checkSeoulPeople(addressVO);
        int ageSum = calculateAgeSum(addressVO);

        printResults(nameSoo, seoulPeople, ageSum);
    }

    private static AddressVO[] inputData() {
        AddressVO[] addressVO = new AddressVO[7];
        addressVO[0] = new AddressVO("고한별", "서울시 강남구 역삼동", 25);
        addressVO[1] = new AddressVO("김동수", "경기도 수원시 영통구 영통동", 20);
        addressVO[2] = new AddressVO("김동섭", "서울시 강남구 서초동", 28);
        addressVO[3] = new AddressVO("정명호", "마계서울시 부평구 부평동", 26);
        addressVO[4] = new AddressVO("양수민", "경기도 부천시 부천동", 25);
        addressVO[5] = new AddressVO("진수현", "서울시 동대문구 동대문동", 27);
        addressVO[6] = new AddressVO("수 연", "서울시 강남구 역삼동", 26);
        return addressVO;
    }

    private static void printAddressVO(AddressVO[] addressVO) {
        System.out.println(" 이름\t\t\t주소\t\t\t\t\t나이");
        System.out.println("--------------------------------------------");
        for (AddressVO vo : addressVO) {
            System.out.printf(printFormat(),vo.getName(),vo.getAddress(),vo.getAge());
        }
        System.out.println("--------------------------------------------");
    }

    private static int checkNameSoo(AddressVO[] addressVO) {
        int nameSoo = 0;
        for (AddressVO vo : addressVO) {
            if (vo.getName().contains("수")) {
                nameSoo++;
            }
        }
        return nameSoo;
    }

    private static int checkSeoulPeople(AddressVO[] addressVO) {
        int seoulPeople = 0;
        for (AddressVO vo : addressVO) {
            if (vo.getAddress().startsWith("서울시")) {
                seoulPeople++;
            }
        }
        return seoulPeople;
    }

    private static int calculateAgeSum(AddressVO[] addressVO) {
        int ageSum = 0;
        for (AddressVO vo : addressVO) {
            ageSum += vo.getAge();
        }
        return ageSum;
    }

    private static void printResults(int nameSoo, int seoulPeople, int ageSum) {
        System.out.println("이름에 \"수\"가 들어간 사람의 수 : " + nameSoo);
        System.out.println("서울시에 살고 있는 사람의 수 : " + seoulPeople);
        System.out.println("전체 나이의 합 : " + ageSum);
    }
    public static String printFormat() {
        return "%3s\t%-18s\t%d\n";
//        return vo.getName() + " \t" + vo.getAddress() + "\t" + vo.getAge();
    }

}

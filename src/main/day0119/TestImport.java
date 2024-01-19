package day0119;

// import java.util.*; // 특정 패키지 내의 모든 클래스를 import 할때

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
// import java.sql.Date; // ⚠ 패키지명이 다르고 이름이 같은 클래스는 둘 중 먼저 선언된 하나만 import 가능

/**
 * 다른 패키지에 존재한느 클래스를 가져다 사용할 때
 */
public class TestImport {
    Date d = new Date();
    java.sql.Date d2 = null; // util.Date가 아니라 sql.Date로 사용하고 싶다 => full path
    Date d3 = null;

    List l = new ArrayList();
    List l2 = new ArrayList();
    Map m = new HashMap();
}

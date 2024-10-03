package day0116.work0116;

import day0116.Person;

public class Potato extends Person {
    private int mineSweeperLevel;
    public Potato() {
        mineSweeperLevel = 5;
    }

    public String mineGame(){
        String result = null;
        int mine = (int)(Math.random() * 10);
        if(mine < 5){
            result = "지뢰 터짐";
            mineSweeperLevel--;
        } else {
            result = "성공";
            mineSweeperLevel++;
        }
        return result;
    }

    public int getMinesweeperLevel() {
        return mineSweeperLevel;
    }



}

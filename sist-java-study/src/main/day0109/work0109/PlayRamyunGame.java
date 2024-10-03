package day0109.work0109;

public class PlayRamyunGame {
    public static void main(String[] args) {
        RamyunGame ramyunGame = new RamyunGame(1,1,1);

        System.out.print(ramyunGame.getStartMent());

        ramyunGame.setRamyunNum(1);
        System.out.println(ramyunGame.selectRamyunMaker(ramyunGame.getRamyunNum()) + "를 선택하셨습니다.\n");

        for (int selectedIngredientNum = 1; selectedIngredientNum <= 5; selectedIngredientNum++) {
            addIngredient(ramyunGame, selectedIngredientNum);
        }

        System.out.println(ramyunGame.getSelectCookingTime());

        ramyunGame.setMinute(3);
        System.out.println(ramyunGame.cookingTime(ramyunGame.getMinute()));
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void addIngredient(RamyunGame ramyunGame, int selectedIngredientNum) {
        printMessage(ramyunGame.getSelectIngredientMent());
        ramyunGame.setIngredient(selectedIngredientNum);
        String ingredientResult = ramyunGame.addIngredient(ramyunGame.getIngredient());
        printMessage(ingredientResult + " 추가\n");
    }
}
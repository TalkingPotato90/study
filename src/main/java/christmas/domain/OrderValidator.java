package christmas.domain;

public class OrderValidator {
    public static boolean isValidOrder(String order){
        try {
            validateOnMenu(order);
            validateQuantity(order);
            validateFormat(order);
            validateDuplicateMenu(order);
            validateTotalQuantity(order);
            validateBeverageOnly(order);

            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    private static void validateOnMenu(String order){

    }

    private static void validateQuantity(String order){

    }

    private static void validateFormat(String order){

    }

    private static void validateDuplicateMenu(String order){

    }

    private static void validateTotalQuantity(String order){

    }

    private static void validateBeverageOnly(String order){

    }
}

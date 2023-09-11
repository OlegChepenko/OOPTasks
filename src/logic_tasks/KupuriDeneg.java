package logic_tasks;

public class KupuriDeneg {


    public static void validate(int sum){
        if (sum < 10) {
            throw new IllegalArgumentException("Слишком маленькая сумма");
        }
        if (sum % 1 > 0){
            throw new IllegalArgumentException("Уберите копейки");
        }
        if (sum % 10 > 0){
            throw new IllegalArgumentException("Сумма не кратна 10");
        }
    }

    private static int stoRubCount(int sum){
        return  sum / 100;

    }
    private static int fiftyRubCount(int sum){
        return sum % 100 / 50;
    }

    private static int tenRubCount(int sum){
        return sum % 100 % 50 / 10;
    }


    public static void print(int sum){
        validate(sum);
        int stoRub = stoRubCount(sum);
        int fiftyRub = fiftyRubCount(sum);
        int tenRub = tenRubCount(sum);
        System.out.println("Купюр по 100р.: " + stoRub + "Купюр по 50р.: " + fiftyRub + "Купюр по 10р.: " + tenRub);
    }

}

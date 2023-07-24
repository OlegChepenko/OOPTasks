package elevator;

public class InformativeAutomaticElevator extends AutomaticElevator {

    public InformativeAutomaticElevator(int storeys) {
        super(storeys);
    }

    protected void UpN(int n){
        if (n < 0 ){
            throw new RuntimeException("Значение не может быть отрицательным");
        }
        for (int i = 0; i < n; i++) {
            Up();
            System.out.println(getCurrentStorey());
        }

    }
    protected void DownN(int n){
        if (n < 0 ){
            throw new RuntimeException("Значение не может быть отрицательным");
        }
        for (int i = 0; i < n; i++) {
            Down();
            System.out.println(getCurrentStorey());
        }

    }
    public void MoveTo(int storey){
        System.out.println("Лифт отправляется на " + storey + " Этаж");
        if (storey < 0 ){
            throw new RuntimeException("Значение не может быть отрицательным");
        }
        int currentStorey = getCurrentStorey();
        int difference = storey - currentStorey;
        if ( difference > 0 ){
            UpN(difference);
        } else if (difference == storey ){
            System.out.println("Вы на этом этаже");
        }else if (difference < 0 ){
            DownN(difference * -1);
        }
    }

}

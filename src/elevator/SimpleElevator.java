package elevator;

public class SimpleElevator {
//количество этажей
    private int storeys;
    //этаж на котором находится лифт
    private int currentStorey;

    //количество этажей
    public SimpleElevator(int storeys) {
        if (storeys<0){
            throw new RuntimeException(" Количество этажей не может быть отрицательным! ");
        }
        this.storeys = storeys;
        currentStorey = 1;

    }
    protected void Up(){
        if (storeys == currentStorey){
            throw new RuntimeException("Самый верхний этаж достигнут");
        }
        currentStorey += 1;
    };
    protected void Down(){
        if (storeys == currentStorey){
            throw new RuntimeException("Самый нижний этаж достигнут");
        }
        currentStorey -= 1;
    }

    public int getStoreys() {
        return storeys;
    }

    public int getCurrentStorey() {
        return currentStorey;
    }
}

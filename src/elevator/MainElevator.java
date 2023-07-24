package elevator;

public class MainElevator {
    public static void main(String[] args) {
        int storeys =10;// всего этажей в здании
        int storey = 4; // на какой этаж едем

        //автоматический лифт
        AutomaticElevator automaticElevator = new AutomaticElevator(storeys);
        automaticElevator.MoveTo(storey);
        //информативный лифт
        InformativeAutomaticElevator informativeAutomaticElevator = new InformativeAutomaticElevator(storeys);
        informativeAutomaticElevator.MoveTo(storey);
        //очень информативный лифт
        VeryInformativeAutomaticElevator veryInformativeAutomaticElevator = new VeryInformativeAutomaticElevator(10);
        veryInformativeAutomaticElevator.MoveTo(storey);
    }
}

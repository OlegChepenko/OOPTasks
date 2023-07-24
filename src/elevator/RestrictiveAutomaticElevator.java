package elevator;

import java.util.ArrayList;
import java.util.List;

public class RestrictiveAutomaticElevator extends AutomaticElevator {
    private List<Integer> restrictedStoreys;

    public RestrictiveAutomaticElevator(int storeys) {
        super(storeys);
        restrictedStoreys = new ArrayList<>();
    }

    public void RestrictStorey(int storey) {
        restrictedStoreys.add(storey);
    }

    public void MoveTo(int storey) {
        if (restrictedStoreys.contains(storey)){
            throw new RuntimeException("Этаж закрыт");
        } else {
            super.MoveTo(storey);
        }
    }

}

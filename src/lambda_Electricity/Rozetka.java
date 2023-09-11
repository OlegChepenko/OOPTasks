package lambda_Electricity;

import java.util.ArrayList;
import java.util.List;

public class Rozetka {
    private List<IElectricity> electricityConsumers = new ArrayList<>();

    public void on(){
        System.out.println("Питание подали");
        for (var consumer : electricityConsumers) {
            consumer.on();
        }

    }
    public void addElectricityConsumer(IElectricity electricityConsumer){
        electricityConsumers.add(electricityConsumer);

    }

    public void removeElectricityConsumer(IElectricity electricityConsumer){
        electricityConsumers.remove(electricityConsumer);

    }


}

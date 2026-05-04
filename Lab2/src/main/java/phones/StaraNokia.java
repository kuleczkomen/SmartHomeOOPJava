package phones;

//Moze i nie umie za dużo
//Ale się stara
public class StaraNokia implements Phone, BatteryDevice {
    private int batteryPercentage = 100;

    @Override
    public void call(String number) {
        if (batteryPercentage > 5){
            System.out.println("Dzwonię z niezniszczalnej Nokii do: " + number);
            batteryPercentage -= 5;
        }
        else {
            System.out.println("Bateria jest za słaba, aby zadzwonić!");
        }
    }

    @Override
    public void sendSms(String number, String message) {
        if (batteryPercentage > 3) {
            System.out.println("Wysyłam SMS do " + number + ": " + message);
            batteryPercentage -= 3;
        } else {
            System.out.println("Bateria jest za słaba, aby wysłać SMS!");
        }
    }

    @Override
    public void chargeWithPin() {
        setBattery(batteryPercentage + 30);
    }

    @Override
    public int getBattery() {
        return batteryPercentage;
    }

    @Override
    public void setBattery(int battery) {
        batteryPercentage = battery;
    }
}
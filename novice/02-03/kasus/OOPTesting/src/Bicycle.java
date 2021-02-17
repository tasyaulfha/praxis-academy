public class Bicycle {
    public int cadence;
    public int gear;
    public int speed;


    public Bicycle(int startCadence, int startSpeed, int startGear){
        gear =startGear;
        speed =startSpeed;
        cadence =startCadence;
    }

    public void setCadence(int newValue) {
        this.cadence = newValue;
    }

    public void setGear(int newValue) {
        this.gear = newValue;
    }

    public void setSpeed(int newValue) {
        this.speed = newValue;
    }

    public int getGear() {
        return gear;
    }

    public int getCadence() {
        return cadence;
    }

    public int getSpeed() {
        return speed;
    }

    public void applyBrake(int decrement){
        speed -= decrement;
    }
    public void speedUp(int increment){
        speed += increment;
    }
}

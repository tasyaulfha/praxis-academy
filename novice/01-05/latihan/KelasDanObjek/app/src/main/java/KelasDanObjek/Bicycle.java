package KelasDanObjek;

public class Bicycle {
    private int cadence;
    private int gear;
    private int speed;

    private int id;

    private static int numberOfBicycles = 0;


    public Bicycle(int startCadence, int startSpeed, int startGear){
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;

        id = ++numberOfBicycles;
    }
    public int getId() {
        return id;
    }
    public int getCadence() {
        return cadence;
    }
    public int getGear() {
        return gear;
    }
    public int getSpeedUp(int increment) {
        return speed;
    }
    public void setGear(int newValue) {
        this.gear = newValue;
    }
    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }
    public void setCadence(int newValue) {
        this.cadence = newValue;
    }
    public void applyBrake(int decrement){
        speed -= decrement; 
    }
}
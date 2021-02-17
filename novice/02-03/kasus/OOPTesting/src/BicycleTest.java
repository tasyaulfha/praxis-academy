import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BicycleTest {

    @Test
    public void testBicycleCreation(){
    Bicycle Bike = new Bicycle(10,20,1);
    assertEquals(Bike.getGear(), 1);
    assertEquals(Bike.getSpeed(),20);
    assertEquals(Bike.getCadence(), 10);
    //testing tester
        Bike.setGear(2);
        Bike.setSpeed(30);
        Bike.setCadence(5);
        assertEquals(Bike.getGear(),2);
        assertEquals(Bike.getSpeed(),30);
        assertEquals(Bike.getCadence(),5);
        Bike.applyBrake(10);
        assertEquals(Bike.getSpeed(),20);
        Bike.speedUp(5);
        assertEquals(Bike.getSpeed(),25);
    }

}
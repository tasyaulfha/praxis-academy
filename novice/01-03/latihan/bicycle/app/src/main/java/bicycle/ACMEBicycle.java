package bicycle;

    class ACMEBicycle implements Bicycle {
        int cadance = 0;
        int speed = 0;
        int gear =1;

        void changeCadance(int newValue){
            cadance = newValue;
        }
        void changeGear(int newValue){
            gear = newValue;

        } 
        void speedUp (int increment){
            speed = speed+increment;
        }
        void applyBrakes (int decrement){
            speed = speed - decrement;
        }
        void printStates(){
            System.out.println("cadance :" + cadance + "gear :" + gear + "speed :" + speed + "gear :" + gear );
        }
    }
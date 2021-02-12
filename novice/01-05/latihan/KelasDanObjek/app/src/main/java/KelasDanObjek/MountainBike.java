package KelasDanObjek;
    public class MountainBike extends Bicycle{
        public int setHeight;

        public MountainBike(int startHeight, int startGear, int startCadence,int startSpeed){
            super(startCadence, startSpeed, startGear);
            setHeight =startHeight;
        }
        public void setHeight(int newValue){
            setHeight = newValue;
        }
    }
public class MountainBike extends Bicycle {
        
    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }   
        
    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    // Method to print bike attributes
    public void PrintBikeAttributes(){
        System.out.println("Height: " + this.seatHeight);
        System.out.println("Cadence: " + this.cadence);
        System.out.println("Speed: " + this.speed);
        System.out.println("Gear: " + this.gear);
    }

    public static void main(String args[]) {
        MountainBike mBike = new MountainBike(2, 10, 2, 1);
        System.out.println("Initial bike attributes");
        mBike.PrintBikeAttributes();
        mBike.setCadence(30);
        mBike.setGear(2);
        mBike.speedUp(10);
        System.out.println("Bike attributes after gearing up");
        mBike.PrintBikeAttributes();
        
    }   
}

class Bicycle {
        
    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;
        
    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
        
    // the Bicycle class has four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }
        
}
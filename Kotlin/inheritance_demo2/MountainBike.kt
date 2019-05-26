open class Bicycle {
    // the Bicycle class has three fields
    private var cadence: Int
    private var gear: Int
    private var speed: Int

    // the Bicycle class has one constructor
    constructor(startCadence: Int, startSpeed: Int, startGear: Int) {
        this.gear = startGear
        this.cadence = startCadence
        this.speed = startSpeed
    }

    // the Bicycle class has four methods
    fun setCadence(newValue: Int) {
        this.cadence = newValue
    }

    fun setGear(newValue: Int) {
        this.gear = newValue
    }

    fun applyBrake(decrement: Int) {
        this.speed -= decrement
    }

    fun speedUp(increment: Int) {
        this.speed += increment
    }

    fun printBicyleAttributes() {
        println("Cadence: " + this.cadence);
        println("Speed: " + this.speed);
        println("Gear: " + this.gear);
    }
}

class MountainBike : Bicycle {
    // the MountainBike subclass adds one field
    private var seatHeight: Int;

    // the MountainBike subclass has one constructor
    constructor(startHeight: Int,
                startCadence: Int,
                startSpeed: Int,
                startGear: Int) : super(startCadence, startSpeed, startGear) {
        this.seatHeight = startHeight;
    }

    // the MountainBike subclass adds one method
    fun setHeight(newValue: Int) {
        this.seatHeight = newValue;
    }

    // Method to print bike attributes
    fun PrintBikeAttributes() {
        println("Height: " + this.seatHeight);
        this.printBicyleAttributes()
    }
}

fun main(args: Array<String>)
{
    val mBike = MountainBike(2, 10, 2, 1);
    println("Initial bike attributes");
    mBike.PrintBikeAttributes();
    mBike.setCadence(30);
    mBike.setGear(2);
    mBike.speedUp(10);
    println("Bike attributes after gearing up");
    mBike.PrintBikeAttributes();

}
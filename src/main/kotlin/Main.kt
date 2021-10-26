import java.util.*

fun main(args: Array<String>) {

    val car = Vehicle( "AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle( "B222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle( "CC333CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle( "DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")

    /*val parking = Parking(mutableSetOf(car, moto, minibus, bus))

    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(moto))
    println(parking.vehicles.contains(minibus))
    println(parking.vehicles.contains(bus))

    val car2 = Vehicle( "AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_003")

    val isCar2Inserted = parking.vehicles.add(car2)

    println(isCar2Inserted)

    parking.vehicles.remove(moto)

    println(parking.vehicles.size)*/


    val myArray = arrayListOf<Vehicle>(car, minibus, moto, bus,
        Vehicle( "AA115AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA116AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA117AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA118AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA119AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA120AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA121AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA122AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA123AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA124AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA125AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA126AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA127AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA128AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA129AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA130AA", VehicleType.CAR, Calendar.getInstance()),
        Vehicle( "AA131AA", VehicleType.CAR, Calendar.getInstance())
    )

    val parking = Parking(mutableSetOf())

    myArray.forEach { vehicle ->
        if (parking.addVehicle(vehicle)){
            println("Welcome to AlkeParking!")
        }else{
            println("Sorry, the has check-in failed")
        }
    }



}


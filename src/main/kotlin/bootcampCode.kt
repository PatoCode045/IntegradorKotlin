import java.util.*
import kotlin.random.Random
import kotlin.random.nextLong

const val MINUTES_IN_MILISECONDS = 60000

data class ParkingSpace(val  vehicles: MutableSet<Vehicle>){

    val parking = Parking(vehicles)

    fun checkOutVehicle(plate: String){
        val checkingOutVehicle = parking.vehicles.find {
            it.plate == plate
        }
        checkingOutVehicle?.let {
            parking.vehicles.remove(checkingOutVehicle)
            onSuccess(calculateFee(it.type, it.parkedTime, it.discountCard?.let { true } ?: false))
        }?: onError()

    }

    private fun onSuccess(fee : Int){
        /*with(parking.parkingReport){
            Pair(first + 1, second + fee)
        }*/
        parking.parkingReport = Pair( parking.parkingReport.first+1, parking.parkingReport.second + fee )
        println("Your fee is $$fee. Come back soon.")
    }

    private fun onError(){
        println("Sorry, the check-out failed")
    }

    private fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int{

        var remainingTime = parkedTime
        //remainingTime = 198
        remainingTime = Random.nextLong(1..500L)
        println(remainingTime)

        var fee = 0

        remainingTime -= 120
        fee += type.rate

        while (remainingTime > 0){
            remainingTime -= 15
            fee += 5
        }
        if (hasDiscountCard){
            fee = (fee * 0.85).toInt()
        }
        return fee
    }

}

data class Parking(val  vehicles: MutableSet<Vehicle>){

    val maximumCapacity = 20

    var parkingReport = Pair(0, 0)

    fun addVehicle(vehicle: Vehicle) : Boolean {
        if (vehicles.size < maximumCapacity){
            return vehicles.add(vehicle)
        }
        return false
    }

    fun showParkingEarnings(){
        println("${parkingReport.first} vehicles have checked out and have earnings of $${parkingReport.second}")
    }

    fun listVehicles(){
        println("Current parking has ${vehicles.size} vehicles:")
        vehicles.forEach {
            println(it.plate)
        }
    }

}

data class Vehicle(val plate: String, val type: VehicleType, val checkInTime: Calendar, val discountCard: String? = null){

    val parkedTime : Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

    //Function states that two Vehicles are equal if their plates are equal
    override fun equals(other: Any?) : Boolean {
        if (other is Vehicle){
            return this.plate == other.plate
        }

        return super.equals(other)
    }
    //Function states that the hashCode (Used internally in search functions
    // in sets and arrays) is the hashCode of the plate
    override fun hashCode() : Int = this.plate.hashCode()

}

//2. Enum Class for Type of Vehicle
enum class VehicleType(val rate: Int){
    CAR(20), MOTORCYCLE(15), MINIBUS(25), BUS(30)
}

/*Answers
*
* 1. Since you can't have two Vehicles with the same plate in the Parking,
* Sets are the best choice for this use-case cause a Set is a group of objects without repetitions.
*
*
*/
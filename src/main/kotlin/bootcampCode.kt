import java.util.*

const val MINUTES_IN_MILISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle){

    fun checkOutVehicle(plate: String){

    }
    fun onSuccess(): Int {
        return 12
    }
    fun onError(){

    }
}

data class Parking(val  vehicles: MutableSet<Vehicle>){
    val maximumCapacity = 20

    fun addVehicle(vehicle: Vehicle) : Boolean {
        if (vehicles.size < maximumCapacity){
            return vehicles.add(vehicle)
        }
        return false
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
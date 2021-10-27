import java.util.*

fun main(args: Array<String>) {

    /*
    ● Cuando se va a ingresar un vehículo se ingresa la placa y el tipo, y se
    valida que no haya ningún otro vehículo con esa misma placa en el
    estacionamiento.*/

    val car = Vehicle( "AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle( "B222BBB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle( "CC333CC", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle( "DD444DD", VehicleType.BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")

    val car2 = Vehicle( "AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_003")

    val myArray = arrayListOf<Vehicle>(car, minibus, moto, bus, car2,
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

    val parkingSpace = ParkingSpace(mutableSetOf())

    myArray.forEach { vehicle ->
        if (parkingSpace.parking.addVehicle(vehicle)){
            println("Welcome to AlkeParking!")
        }else{
            println("Sorry, the has check-in failed")
        }
    }


    /*
    ● Cuando un vehículo va a ser retirado se cobra una tarifa determinada por
    las siguientes reglamentaciones

    Las primeras 2 horas de estacionamiento tendrán un costo fijo
    determinado por el tipo de vehículo (auto: $20, moto: $15, mini bus:
    $25, bus: $30).

    Luego de las 2 primeras horas se cobrarán $5 por cada 15 minutos o
    fracción independiente del tipo de vehículo. Por ejemplo para un auto
    se tendrían las siguientes tarifas:

    Los vehículos pueden tener (opcionalmente) una tarjeta de
    descuentos, la cual reduce la tarifa total de estacionamiento un 15%.

    Los valores de las tarifas no deben incluir centavos; en caso de
    tenerlos deben descartarse.*/

    /*
    parkingSpace.checkOutVehicle(car.plate)
    parkingSpace.checkOutVehicle(moto.plate)
    parkingSpace.checkOutVehicle(bus.plate)
    parkingSpace.checkOutVehicle(minibus.plate)

    parkingSpace.checkOutVehicle("AA131AA")
    */

    /*
    ● Por solicitud de la administración de AlkeParking, debe tenerse un registro
    del total de vehículos que se retiran del estacionamiento, junto con el total
    de las ganancias recibidas.*/

    //parkingSpace.parking.showParkingEarnings()

    /*
    ● La administración podrá solicitar en cualquier momento la lista de las
    placas de los vehículos que se encuentran en el estacionamiento.
    * */

    //parkingSpace.parking.listVehicles()

}







package com.libkotlinpractice.sealed_class.example1

sealed class Transportation {
    data class ByAir(val flightNumber: Int, val seatNumber: String, val airport: String, val seatingClass: String = "Ecomany"): Transportation()

    data class ByRoadBus(val busNumber: Int, val busRootNumber: String): Transportation()

    data class ByRoadPersonalVehicle(val vehicleNumber: Int, val VehicleType:String = "Car"): Transportation()


}

fun main() {
}

enum class TransportType{
    ByAir, ByRoadBus, ByRoadPersonalVehicle;

    fun getTransportType() = name.lowercase()
}

enum class SomeClass(someClassForEnum: SomeClassForEnum) {
    SomeClassNameA(SomeClassForEnum("Name A")),
    SomeClassNameB(SomeClassForEnum("Name B"))
}

class SomeClassForEnum(val someName: String) {

}

object TransFactory {
    fun transportType(transportType: TransportType):Transportation {
        val name = when(transportType) {
            TransportType.ByAir -> {
                //transportType.getTransportType()
                //"ByAir"
                transportType.name
            }
            TransportType.ByRoadBus -> transportType.getTransportType()
            TransportType.ByRoadPersonalVehicle -> "Hard"
            else -> {}
        }

        return Transportation.ByAir(323, "21A", "")
    }
}
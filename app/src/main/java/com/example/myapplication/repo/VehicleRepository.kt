package com.example.myapplication.repo

import com.example.myapplication.data.VehicleMaker


class VehicleRepository {

	fun syncVehicleMakers() = listOf(
				VehicleMaker("ABARTH", "ABARTH"),
				VehicleMaker("AIWAYS", "AIWAYS"),
				VehicleMaker("ALFAROMEO", "ALFAROMEO"),
				VehicleMaker("ALPINA", "ALPINA"),
				VehicleMaker("ASTONMARTI", "ASTONMARTI"),
				VehicleMaker("AUDI", "AUDI"),
				VehicleMaker("BENTLEY", "BENTLEY"),
				VehicleMaker("BMW", "BMW"),
				VehicleMaker("BUICK", "BUICK"),
				VehicleMaker("BYTON", "BYTON"),
				VehicleMaker("CADILLAC", "CADILLAC"),
				VehicleMaker("CHEVROLET", "CHEVROLET"),
				VehicleMaker("CHRYSLER", "CHRYSLER"),
				VehicleMaker("CITROEN", "CITROEN"),
				VehicleMaker("CUPRA", "CUPRA"),
				VehicleMaker("DACIA", "DACIA"),
				VehicleMaker("DAIHATSU", "DAIHATSU"),
				VehicleMaker("DODGE", "DODGE"),
				VehicleMaker("DONGFENG", "DONGFENG"),
				VehicleMaker("DS", "DS"),
				VehicleMaker("FERRARI", "FERRARI"),
				VehicleMaker("FIAT", "FIAT"),
				VehicleMaker("FORD", "FORD"),
				VehicleMaker("GENESIS", "GENESIS"),
				VehicleMaker("HONDA", "HONDA"),
				VehicleMaker("HUMMER", "HUMMER"),
				VehicleMaker("HYUNDAI", "HYUNDAI"),
				VehicleMaker("INFINITI", "INFINITI"),
				VehicleMaker("ISUZU", "ISUZU"),
				VehicleMaker("IVECO", "IVECO"),
				VehicleMaker("JAC", "JAC"),
				VehicleMaker("JAGUAR", "JAGUAR"),
				VehicleMaker("JEEP", "JEEP"),
				VehicleMaker("KIA", "KIA"),
				VehicleMaker("VAZLADA", "VAZLADA"),
				VehicleMaker("LAMBORGHIN", "LAMBORGHIN"),
				VehicleMaker("LANCIA", "LANCIA"),
				VehicleMaker("LANDROVER", "LANDROVER"),
				VehicleMaker("LEXUS", "LEXUS"),
				VehicleMaker("LINCOLN", "LINCOLN"),
				VehicleMaker("LYNKCO", "LYNKCO"),
				VehicleMaker("MASERATI", "MASERATI"),
				VehicleMaker("MAYBACH", "MAYBACH"),
				VehicleMaker("MAZDA", "MAZDA"),
				VehicleMaker("MCLAREN", "MCLAREN"),
				VehicleMaker("MERCEDES", "MERCEDES"),
				VehicleMaker("MG", "MG"),
				VehicleMaker("MINI", "MINI"),
				VehicleMaker("MITSUBISHI", "MITSUBISHI"),
				VehicleMaker("NIO", "NIO"),
				VehicleMaker("NISSAN", "NISSAN"),
				VehicleMaker("OPEL", "OPEL"),
				VehicleMaker("PEUGEOT", "PEUGEOT"),
				VehicleMaker("POLESTAR", "POLESTAR"),
				VehicleMaker("PORSCHE", "PORSCHE"),
				VehicleMaker("RENAULT", "RENAULT"),
				VehicleMaker("ROLLSROYCE", "ROLLSROYCE"),
				VehicleMaker("SAAB", "SAAB"),
				VehicleMaker("SEAT", "SEAT"),
				VehicleMaker("SKODA", "SKODA"),
				VehicleMaker("SMART", "SMART"),
				VehicleMaker("SSANGYONG", "SSANGYONG"),
				VehicleMaker("SUBARU", "SUBARU"),
				VehicleMaker("SUZUKI", "SUZUKI"),
				VehicleMaker("TESLA", "TESLA"),
				VehicleMaker("TOYOTA", "TOYOTA"),
				VehicleMaker("VW", "VW"),
				VehicleMaker("VOLVO", "VOLVO"),
	)

	suspend fun createVehicle(
		maker: String,
		model: String
	): Boolean {
		// TODO api call
		return true
	}
}
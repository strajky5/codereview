package com.example.myapplication.addVehicle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.VehicleMaker
import com.example.myapplication.data.VehicleModel
import com.example.myapplication.repo.VehicleRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddVehicleViewModel constructor(
	private val vehicleRepository: VehicleRepository
) : ViewModel() {

	private var makers: List<VehicleMaker>? = null

	private val _uiStateFlow = MutableStateFlow(UiStateFlow())
	val uiStateFlow = _uiStateFlow.asStateFlow()

	init {
		syncVehicleMakers()
	}

	private fun syncVehicleMakers() {
		makers = vehicleRepository.syncVehicleMakers()
		_uiStateFlow.update {
			it.copy(vehicleMakers = makers!!)
		}
	}

	fun searchMakers(query: String) {
		val searchedMakers: MutableList<VehicleMaker> = mutableListOf()

		if (query.isNotBlank()) {
			for (maker in makers!!) {
				if (maker.name.lowercase().contains(query.lowercase())) {
					searchedMakers.add(maker)
				}
			}
		} else {
			searchedMakers.addAll(makers!!)
		}

		_uiStateFlow.update {
			it.copy(vehicleMakers = searchedMakers)
		}
	}

	fun setSelectedMaker(maker: VehicleMaker) {
		_uiStateFlow.update {
			it.copy(selectedMaker = maker)
		}
	}

	fun createVehicle() {
		viewModelScope.launch {
			val successfull = vehicleRepository.createVehicle(
				maker = _uiStateFlow.value.selectedMaker?.name.orEmpty(),
				model = _uiStateFlow.value.selectedModel?.name.orEmpty()
			)
			if (successfull) {
				// TODO close screen
			}
		}
	}
}

data class UiStateFlow constructor(
	val vehicleMakers: List<VehicleMaker> = emptyList(),
	val selectedMaker: VehicleMaker? = null,
	val selectedModel: VehicleModel? = null
)

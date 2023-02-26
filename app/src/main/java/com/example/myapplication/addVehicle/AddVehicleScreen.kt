@file:OptIn(ExperimentalMaterialApi::class)

package com.example.myapplication.addVehicle

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.repo.VehicleRepository
import kotlinx.coroutines.launch

@Preview
@Composable
fun AddScreen(
	viewModel: AddVehicleViewModel = AddVehicleViewModel(VehicleRepository())
) {
	val fieldValue = remember { mutableStateOf("") }
	val coroutineScope = rememberCoroutineScope()
	val snackbarHostState = remember { SnackbarHostState() }
	val uiState by viewModel.uiStateFlow.collectAsState()
	val sheetState: ModalBottomSheetState = rememberModalBottomSheetState(
		initialValue = ModalBottomSheetValue.Hidden
	)

	ModalBottomSheetLayout(
		sheetState = sheetState,
		sheetContent = {
			OutlinedTextField(
				modifier = Modifier
					.padding(16.dp)
					.fillMaxWidth(),
				value = fieldValue.value,
				onValueChange = {
					fieldValue.value = it
					viewModel.searchMakers(it)
				},
				shape = RoundedCornerShape(16.dp),
				label = { Text(text = "Search maker") },
				placeholder = { Text(text = "Search maker") },
				trailingIcon = {
					IconButton(
						modifier = Modifier.padding(start = 4.dp),
						onClick = {
							viewModel.searchMakers("")
						}
					) {
						Icon(
							painter = painterResource(id = R.drawable.baseline_close_24),
							contentDescription = null
						)
					}
				},
				leadingIcon = {
					IconButton(
						modifier = Modifier.padding(start = 16.dp),
						onClick = {
							coroutineScope.launch {
								sheetState.hide()
							}
						}
					) {
						Icon(
							painter = painterResource(id = R.drawable.baseline_arrow_back_24),
							contentDescription = null
						)
					}
				},
				keyboardOptions = KeyboardOptions(
					imeAction = ImeAction.Previous,
					keyboardType = KeyboardType.Text
				)
			)

			// Show makers
			Column(
				modifier = Modifier
					.fillMaxSize()
					.verticalScroll(state = rememberScrollState())
			) {
				uiState.vehicleMakers.forEach {
					Row(
						modifier = Modifier
							.padding(24.dp)
							.fillMaxWidth()
							.clickable {
								viewModel.setSelectedMaker(it)
								coroutineScope.launch {
									sheetState.hide()
								}
							}
					) {
						Text(
							text = it.name,
							color = Color(0xFF000000)
						)
					}
				}
			}
		}
	) {
		Box(
			modifier = Modifier.fillMaxSize()
		) {

			Column(
				modifier = Modifier.padding(horizontal = 16.dp)
			) {

				Column(
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 16.dp)
						.clickable {
							coroutineScope.launch {
								sheetState.show()
							}
						}
				) {
					Text(
						text = "Maker",
						color = Color(0xFF000000)
					)
					Text(
						text = uiState.selectedMaker?.name ?: "-",
						color = Color(0xFF000000)
					)
				}

				Column(
					modifier = Modifier
						.fillMaxWidth()
						.padding(vertical = 16.dp)
						.clickable {

						}
				) {
					Text(
						text = "Model",
						color = Color(0xFF000000)
					)
					Text(
						text = uiState.selectedModel?.name ?: "-",
						color = Color(0xFF000000)
					)
				}

				Button(
					modifier = Modifier.fillMaxWidth(),
					onClick = {
						viewModel.createVehicle()
					}
				) {
					Text(text = "Save")
				}
			}

			SnackbarHost(
				hostState = snackbarHostState,
				modifier = Modifier
					.padding(16.dp)
					.wrapContentWidth(align = Alignment.Start),
				snackbar = {
					Snackbar(
						modifier = Modifier.border(
							BorderStroke(1.dp, GreyLight200),
							RoundedCornerShape(12.dp)
						),
						shape = RoundedCornerShape(12.dp)
					) {
						Text(
							text = it.visuals.message
						)
					}
				}
			)
		}
	}
}

val GreyLight200 = Color(0xFFE4E4E7)
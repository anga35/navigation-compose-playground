package com.example.bottomnavigationdemo.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun BottomNavigationHost(navController: NavHostController,parentController: NavHostController) {


    NavHost(navController = navController, startDestination = "home") {


        composable("home"){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(text = "Home screen", fontSize = 21.sp,
                modifier = Modifier.clickable { parentController.navigate("second_screen") })

            }
        }



        composable("notification") {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(text = "Notifications screen", fontSize = 21.sp)

            }

        }
        composable("settings") {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(text = "Settings screen", fontSize = 21.sp)

            }

        }


    }

}


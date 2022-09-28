package com.example.bottomnavigationdemo.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigationdemo.models.NavItem


@Composable
fun AppNavHost(navController: NavHostController){

    NavHost(navController = navController, startDestination = "first_screen"){

        composable(route = "first_screen"){
            FirstScreen(navController = navController)

        }

        composable(route = "second_screen"){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                Text(text = "Second screen")

            }

        }


    }



}

@Composable
fun FirstScreen(navController: NavHostController) {
    val childNavController = rememberNavController()
    val items = listOf(
        NavItem(
            "home",
            Icons.Default.Home, "Home"
        ),
        NavItem(
            "notification",
            Icons.Default.Notifications, "Notification"
        ),
        NavItem(
            "settings",
            Icons.Default.Settings, "Settings"
        )
    )

    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        BottomNavigation(backgroundColor = Color.DarkGray) {
            val backStackEntry by childNavController.currentBackStackEntryAsState()
            val currentDestination = backStackEntry?.destination?.route

            for(screen in items){
                val isSelected= currentDestination == screen.route
                BottomNavigationItem(selected =isSelected ,
                    onClick = {
                        childNavController.navigate(screen.route){
                            popUpTo(childNavController.graph.startDestinationId){
                                saveState=true
                            }
                            restoreState=true
                        }

                    }, selectedContentColor = Color.Green,
                    unselectedContentColor = Color.Gray,
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(imageVector = screen.icon, contentDescription = screen.name)
                            if(isSelected){
                                Text(text = screen.name)
                            }
                        }
                    })

            }

        }
    }) {
        BottomNavigationHost(navController = childNavController, parentController = navController)
    }





}

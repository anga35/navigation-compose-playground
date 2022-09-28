package com.example.bottomnavigationdemo.models

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val route: String,
    val icon:ImageVector,
    val name:String,
)

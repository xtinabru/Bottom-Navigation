package com.example.bottomnavigation.ui.appbars

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.ui.screens.FavouriteScreen
import com.example.bottomnavigation.ui.screens.InfoScreen
import com.example.bottomnavigation.ui.screens.MainScreen

@Composable
fun BottomNavigationApp() {
    val navController = rememberNavController()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Text("Testing drawer...")
            }
        }
    ) {
        // Scaffold для основного контента, верхней и нижней панели
        Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(drawerState) },
        bottomBar = { BottomBar(navController) },
        content = { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            NavHost(
                navController = navController,
                startDestination = "main"
            ) {
                composable(route = "main") {
                    MainScreen(modifier)
                }
                composable(route = "info") {
                    InfoScreen(modifier)
                }
                composable(route = "favourite") {
                    FavouriteScreen(modifier)
                }
            }
        }
    )
}
}

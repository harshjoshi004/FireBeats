package com.example.firebeats

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firebeats.ui.theme.AccountView
import com.example.firebeats.ui.theme.BrowseView
import com.example.firebeats.ui.theme.HomeView
import com.example.firebeats.ui.theme.LibraryView
import com.example.firebeats.ui.theme.SubscribeView

@Composable
fun NavigationManager(navController: NavController, viewModel: MainViewModel, padval:PaddingValues) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.DrawerScreen.Account.route,
        modifier = Modifier.padding(padval)
    ){
        composable(Screen.DrawerScreen.Subscribe.route){
            viewModel.setCurrentScreen(Screen.DrawerScreen.Subscribe)
            SubscribeView()
        }
        composable(Screen.DrawerScreen.Account.route){
            viewModel.setCurrentScreen(Screen.DrawerScreen.Account)
            AccountView()
        }
        composable(Screen.BottomScreen.Library.route){
            viewModel.setCurrentScreen(Screen.BottomScreen.Library)
            LibraryView()
        }
        composable(Screen.BottomScreen.Home.route){
            viewModel.setCurrentScreen(Screen.BottomScreen.Home)
            HomeView()
        }
        composable(Screen.BottomScreen.Browse.route){
            viewModel.setCurrentScreen(Screen.BottomScreen.Browse)
            BrowseView()
        }
    }
}
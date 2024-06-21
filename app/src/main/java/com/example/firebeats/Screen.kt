package com.example.firebeats

import androidx.annotation.DrawableRes


sealed class Screen(val title:String, val route:String) {

    sealed class DrawerScreen(val dTitle: String, val dRoute: String, @DrawableRes val icon: Int): Screen(dTitle, dRoute) {
        object Account: DrawerScreen("Account","account", R.drawable.ic_account)
        object Subscribe: DrawerScreen("Subscribe","subscribe", R.drawable.ic_subscribe)
        object AddAccount: DrawerScreen("Add Account", "add_account", R.drawable.baseline_person_add_alt_1_24)
    }

    sealed class BottomScreen(val bTitle: String, val bRoute: String, @DrawableRes val icon: Int): Screen(bTitle, bRoute) {
        object Library: BottomScreen("Library", "library", R.drawable.library_music)
        object Home: BottomScreen("Home","home", R.drawable.home_filled)
        object Browse: BottomScreen("Browse","browse", R.drawable.baseline_browse)
    }
}

val myDrawerScreens = listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscribe,
    Screen.DrawerScreen.AddAccount
)

val myBottomScreens = listOf(
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Library
)
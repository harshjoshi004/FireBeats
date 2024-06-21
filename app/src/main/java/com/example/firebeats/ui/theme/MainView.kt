package com.example.firebeats.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomSheetState
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firebeats.NavigationManager
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firebeats.MainViewModel
import com.example.firebeats.Screen
import com.example.firebeats.myBottomScreens
import com.example.firebeats.myDrawerScreens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.example.firebeats.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(navController: NavController, viewModel: MainViewModel){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    //Allow us to find out on which screen we are
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomSheetOpen = mutableStateOf(false)


    val dialogOpen = remember {
        mutableStateOf(false)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Account Options ", modifier = Modifier.padding(16.dp), color = MaterialTheme.colorScheme.primary)
                Divider()
                for(i in myDrawerScreens){
                    NavigationDrawerItem(
                        label = { Row {
                            Icon(painter = painterResource(id = i.icon), contentDescription = null)
                            Spacer(modifier = Modifier.size(8.dp))
                            Text(text = i.dTitle)
                        } },
                        selected = currentRoute == i.dRoute,
                        modifier = Modifier.padding(8.dp),
                        onClick = {
                            scope.launch { drawerState.close() }
                            if(i.dRoute == Screen.DrawerScreen.AddAccount.route){
                                dialogOpen.value = true
                            }else navController.navigate(i.dRoute)
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                MyBigTopBar(
                    title = viewModel.currentScreen.value.title,
                    scrollBehavior = scrollBehavior,
                    navFun = { navFun(scope, drawerState) },
                    actionFun = { bottomSheetOpen.value = true })
            },
            bottomBar = {
                NavigationBar {
                    for(i in myBottomScreens)
                        NavigationBarItem(
                            modifier = Modifier.padding(8.dp),
                            selected = viewModel.currentScreen.value.route == i.bRoute,
                            onClick = { navController.navigate(i.bRoute) },
                            label = { Text(text = i.bTitle)},
                            icon = { Icon(painter = painterResource(id = i.icon), contentDescription = null) }
                        )
                }
            }
        ) { innerPadding ->
            NavigationManager(navController,viewModel,innerPadding)

            AccountDialogue(dialogOpen = dialogOpen)

            if(bottomSheetOpen.value)
                ModalBottomSheet(
                    onDismissRequest = { bottomSheetOpen.value = false },
                    sheetState = sheetState
                ) {
                    Column {
                        LibraryItem(name = "Settings", drawable = R.drawable.settings_24)
                        LibraryItem(name = "Share", drawable = R.drawable.share_24)
                        LibraryItem(name = "Help", drawable = R.drawable.help_24)
                    }
                }
        }
    }
}

fun navFun(scope:CoroutineScope, drawerState: DrawerState){
    scope.launch {
        drawerState.apply {
            if (isClosed) open() else close()
        }
    }
}


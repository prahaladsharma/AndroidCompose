package com.jetnews.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.androidcomposedemo.ui.theme.AndroidComposeDemoTheme
import com.jetnews.data.AppContainer
import androidx.compose.material3.ModalNavigationDrawer
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@Composable
fun MainNewsApp(
    appContainer: AppContainer,
    widthSizeClass: WindowWidthSizeClass,
){
    AndroidComposeDemoTheme{
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            //JetNewsNavigationActions(navController)
        }

        val coroutineScope = rememberCoroutineScope()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: AppDestination.HOME_ROUTE
        val isExpandedScreen = widthSizeClass == WindowWidthSizeClass.Expanded

        /*ModalNavigationDrawer(
            drawerContent = {
                AppDrawer(
                    drawerState = sizeAwareDrawerState,
                    currentRoute = currentRoute,
                    navigateToHome = navigationActions.navigateToHome,
                    navigateToInterests = navigationActions.navigateToInterests,
                    closeDrawer = { coroutineScope.launch { sizeAwareDrawerState.close() } }
                )
            },
        )*/
    }
}
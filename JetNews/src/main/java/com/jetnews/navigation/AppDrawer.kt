package com.jetnews.navigation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidcomposedemo.ui.theme.AndroidComposeDemoTheme
import com.jetnews.R

@Composable
fun AppDrawer(
    drawerState: DrawerState,
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToInterest: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier
){
    ModalDrawerSheet(
        drawerState = drawerState,
        modifier = modifier,
    ) {
        AppLogo(
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp)
        )
        NavigationDrawerItem(
            label = { Text("Home") },
            icon = { Icon(Icons.Filled.Home, null) },
            selected = currentRoute == AppDestination.HOME_ROUTE,
            onClick = { navigateToHome(); closeDrawer },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            label = { Text("Interest") },
            icon = { Icon(Icons.AutoMirrored.Filled.List, null) },
            selected = currentRoute == AppDestination.INTERESTS_ROUTE,
            onClick = { navigateToInterest(); closeDrawer },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }

}

@Composable
private fun AppLogo(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
    ) {
        Icon(
            painterResource(R.drawable.ic_jetnews_logo),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(8.dp))
        Icon(
            painterResource(R.drawable.ic_jetnews_bookmark),
            contentDescription = "News App",
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}


@Preview("Drawer contents")
@Preview("Drawer contents (dark)", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppDrawer() {
    AndroidComposeDemoTheme {
        AppDrawer(
            drawerState = rememberDrawerState(initialValue = DrawerValue.Open),
            currentRoute = AppDestination.HOME_ROUTE,
            navigateToHome = {},
            navigateToInterest = {},
            closeDrawer = { }
        )
    }
}
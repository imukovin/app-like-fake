package com.imukstudio.applikefake.design_system.navigation_bar.compose

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.imukstudio.applikefake.design_system.theme.AppLikeFakeTheme
import com.imukstudio.applikefake.string_resources.MR
import dev.icerock.moko.resources.compose.stringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * Navigation bar widget for map screen.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomNavigationBarWidget(
    modifier: Modifier = Modifier,
) {
    BottomNavigation(
        modifier = modifier.height(56.dp),
        backgroundColor = AppLikeFakeTheme.color.constant.pureBlack,
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                   painter = painterResource("ic_menu_24.xml"),
                   contentDescription = stringResource(MR.strings.menu),
                )
            },
            label = { Text(text = stringResource(MR.strings.menu)) },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.Gray,
            alwaysShowLabel = true,
            selected = true,
            onClick = {
            },
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource("ic_location_24.xml"),
                    contentDescription = stringResource(MR.strings.map),
                )
            },
            label = { Text(text = stringResource(MR.strings.map)) },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.Gray,
            alwaysShowLabel = true,
            selected = false,
            onClick = {
            },
        )
    }
}

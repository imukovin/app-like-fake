package com.imukstudio.applikefake.design_system.navigation_bar.compose

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.imukstudio.applikefake.design_system.navigation_bar.model.BottomNavigationBarUiState
import com.imukstudio.applikefake.design_system.navigation_bar.model.NavigationPointType
import com.imukstudio.applikefake.design_system.theme.AppLikeFakeTheme
import dev.icerock.moko.resources.compose.stringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * Navigation bar widget for map screen.
 *
 * @param uiState - UI-state for the Bottom Navigation Widget.
 * @param onNavigationItemClick - click action at the Navigation Bar item.
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomNavigationBarWidget(
    modifier: Modifier = Modifier,
    uiState: BottomNavigationBarUiState,
    onNavigationItemClick: (NavigationPointType) -> Unit,
) {
    BottomNavigation(
        modifier = modifier.height(64.dp),
        backgroundColor = AppLikeFakeTheme.color.constant.pureBlack,
    ) {
        uiState.navigationPointList.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = stringResource(item.title),
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.title),
                    )
                },
                selectedContentColor = AppLikeFakeTheme.color.constant.white,
                unselectedContentColor = AppLikeFakeTheme.color.constant.gray7,
                alwaysShowLabel = true,
                selected = item.type == uiState.selectedNavigationPointType,
                onClick = {
                    onNavigationItemClick(item.type)
                },
            )
        }
    }
}

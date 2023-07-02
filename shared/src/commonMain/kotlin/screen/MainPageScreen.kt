package screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.imukstudio.applikefake.design_system.main_pager.compose.MainPagerWidget
import com.imukstudio.applikefake.design_system.navigation_bar.compose.BottomNavigationBarWidget
import com.imukstudio.applikefake.design_system.navigation_bar.model.BottomNavigationBarUiState
import com.imukstudio.applikefake.design_system.navigation_bar.model.BottomNavigationItemUiState
import com.imukstudio.applikefake.design_system.navigation_bar.model.NavigationPointType
import com.imukstudio.applikefake.design_system.theme.AppLikeFakeTheme
import com.imukstudio.applikefake.string_resources.MR
import kotlinx.collections.immutable.persistentListOf

@Composable
fun MainPageScreen(
    modifier: Modifier = Modifier,
) {
    val bottomNavigationState = remember {
        mutableStateOf(
            BottomNavigationBarUiState(
            navigationPointList = persistentListOf(
                BottomNavigationItemUiState(
                    title = MR.strings.profile,
                    icon = "ic_profile_24.xml",
                    type = NavigationPointType.PROFILE,
                ),
                BottomNavigationItemUiState(
                    title = MR.strings.people,
                    icon = "ic_two_men_24.xml",
                    type = NavigationPointType.PEOPLE,
                )
            ),
            selectedNavigationPointType = NavigationPointType.PROFILE,
        )
        )
    }

    Scaffold(
        modifier = modifier,
    ) { scaffoldPadding ->
        Column(
            modifier = modifier
                .padding(scaffoldPadding)
                .fillMaxSize(),
        ) {
            MainPagerWidget(
                modifier = Modifier
                    .weight(1f)
                    .background(AppLikeFakeTheme.color.constant.pureBlack)
                    .clip(RoundedCornerShape(24.dp)),
                bottomNavigationBarUiState = bottomNavigationState.value,
                profileContent = {
                    ProfileScreen()
                },
                peopleContent = {
                    MapScreen()
                }
            )
            BottomNavigationBarWidget(
                uiState = bottomNavigationState.value,
                onNavigationItemClick = {
                    bottomNavigationState.value = bottomNavigationState.value.copy(
                        selectedNavigationPointType = it,
                    )
                }
            )
        }
    }
}

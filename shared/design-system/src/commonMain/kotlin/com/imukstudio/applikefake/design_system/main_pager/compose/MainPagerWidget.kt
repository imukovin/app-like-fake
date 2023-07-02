package com.imukstudio.applikefake.design_system.main_pager.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.imukstudio.applikefake.design_system.navigation_bar.model.BottomNavigationBarUiState
import com.imukstudio.applikefake.design_system.navigation_bar.model.NavigationPointType

@Composable
fun MainPagerWidget(
    modifier: Modifier = Modifier,
    bottomNavigationBarUiState: BottomNavigationBarUiState,
    profileContent: @Composable () -> Unit,
    peopleContent: @Composable () -> Unit,
) {
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = bottomNavigationBarUiState.selectedNavigationPointType.ordinal
    )

    LaunchedEffect(key1 = bottomNavigationBarUiState) {
        listState.animateScrollToItem(bottomNavigationBarUiState.selectedNavigationPointType.ordinal)
    }

    LazyRow(
        modifier = modifier.fillMaxSize(),
        state = listState,
        userScrollEnabled = false,
    ) {
        items(
            count = bottomNavigationBarUiState.navigationPointList.size,
            itemContent = { item ->
                Box(
                    modifier = Modifier
                        .fillParentMaxWidth(),
                ) {
                    if (item in bottomNavigationBarUiState.navigationPointList.indices) {
                        when (item) {
                            NavigationPointType.PROFILE.ordinal -> {
                                profileContent()
                            }

                            NavigationPointType.PEOPLE.ordinal -> {
                                peopleContent()
                            }
                        }
                    }
                }
            }
        )
    }
}

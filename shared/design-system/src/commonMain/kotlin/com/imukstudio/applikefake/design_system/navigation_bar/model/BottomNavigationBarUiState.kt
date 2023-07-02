package com.imukstudio.applikefake.design_system.navigation_bar.model

import kotlinx.collections.immutable.ImmutableList

data class BottomNavigationBarUiState(
    val navigationPointList: ImmutableList<BottomNavigationItemUiState>,
    val selectedNavigationPointType: NavigationPointType,
)

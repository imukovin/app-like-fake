package com.imukstudio.applikefake.design_system.navigation_bar.model

import dev.icerock.moko.resources.StringResource

data class BottomNavigationItemUiState(
    val title: StringResource,
    val icon: String,
    val type: NavigationPointType,
)

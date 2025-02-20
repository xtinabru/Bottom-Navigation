package com.example.bottomnavigation.ui.appbars

import androidx.compose.ui.graphics.vector.ImageVector

data class TabItem (
    var label: String,
    var icon: ImageVector,
    var route: String,
)
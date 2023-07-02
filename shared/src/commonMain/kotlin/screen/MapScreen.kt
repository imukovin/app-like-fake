package screen

import MapViewWidget
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MapScreen() {
    Box(
        modifier = Modifier.background(Color.White).fillMaxHeight()
            .width(500.dp),
    ) {
        MapViewWidget()
    }
}

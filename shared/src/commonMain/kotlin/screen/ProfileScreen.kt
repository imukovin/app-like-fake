package screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.imukstudio.applikefake.design_system.theme.AppLikeFakeTheme
import com.imukstudio.applikefake.string_resources.MR
import dev.icerock.moko.resources.compose.stringResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .background(AppLikeFakeTheme.color.background.primary)
            .fillMaxSize(),
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .background(AppLikeFakeTheme.color.background.secondary)
                    .fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
                    text = stringResource(MR.strings.profile),
                    color = AppLikeFakeTheme.color.text.primary,
                    style = AppLikeFakeTheme.typography.headline1,
                )
            }


            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                backgroundColor = AppLikeFakeTheme.color.background.secondary,
            ) {
                Row(
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        painter = painterResource("ic_location_24.xml"),
                        contentDescription = null,
                    )
                    Text(
                        text = "Test Test",
                        color = AppLikeFakeTheme.color.text.primary,
                        style = AppLikeFakeTheme.typography.headline2,
                    )
                }
            }
        }
    }
}

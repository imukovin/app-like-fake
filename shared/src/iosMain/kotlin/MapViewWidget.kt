import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import cocoapods.YandexMapsMobile.YMKAnimation.Companion.animationWithType
import cocoapods.YandexMapsMobile.YMKAnimationType
import cocoapods.YandexMapsMobile.YMKCameraPosition.Companion.cameraPositionWithTarget
import cocoapods.YandexMapsMobile.YMKMapKit
import cocoapods.YandexMapsMobile.YMKMapView
import cocoapods.YandexMapsMobile.YMKPoint.Companion.pointWithLatitude
import cocoapods.YandexMapsMobile.setApiKey
import cocoapods.YandexMapsMobile.sharedInstance

@Composable
actual fun MapViewWidget() {

    YMKMapKit.setApiKey("")
    YMKMapKit.sharedInstance().onStart()

    val mapView = remember {
        mutableStateOf(YMKMapView())
    }

    UIKitView(
        modifier = Modifier.fillMaxSize(),
        factory = {
            mapView.value.mapWindow?.map?.moveWithCameraPosition(
                cameraPosition = cameraPositionWithTarget(
                    target = pointWithLatitude(
                        latitude = 54.858186,
                        longitude = 83.110136,
                    ),
                    zoom = 14f,
                    azimuth = 0f,
                    tilt = 0f,
                ),
                animationType = animationWithType(
                    type = YMKAnimationType.YMKAnimationTypeSmooth,
                    duration = 3f,
                ),
                cameraCallback = null,
            )
            mapView.value
        },
    )
}

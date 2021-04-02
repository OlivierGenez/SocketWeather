package codes.chrishorner.socketweather

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import codes.chrishorner.socketweather.styles.SocketWeatherTheme
import dev.chrisbanes.accompanist.insets.ExperimentalAnimatedInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@ExperimentalAnimatedInsets
class ComposeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // Render under the status and navigation bars.
    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
        SocketWeatherTheme {
          Box(modifier = Modifier.fillMaxSize()) {
            val locationSelection = appSingletons.locationSelectionStore.currentSelection.value
            NavGraph(currentSelection = locationSelection)
          }
        }
      }
    }
  }
}

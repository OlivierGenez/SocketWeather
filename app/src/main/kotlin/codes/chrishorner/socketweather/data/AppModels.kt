package codes.chrishorner.socketweather.data

import java.time.Instant

sealed class LocationSelection {
  object FollowMe : LocationSelection()
  data class Static(val location: Location) : LocationSelection()
  object None : LocationSelection()
}

data class Forecast(
  val updateTime: Instant,
  val location: Location,
  val iconDescriptor: String,
  val night: Boolean,
  val currentTemp: Float,
  val tempFeelsLike: Float?,
  val humidity: Int?,
  val wind: Wind,
  val highTemp: Int,
  val lowTemp: Int,
  val todayForecast: DateForecast,
  val hourlyForecasts: List<ThreeHourlyForecast>,
  val upcomingForecasts: List<DateForecast>
)

data class DeviceLocation(val latitude: Double, val longitude: Double)

enum class ForecastError { DATA, NETWORK, LOCATION, NOT_AUSTRALIA }

data class RainTimestamp(val timestamp: String, val label: String)

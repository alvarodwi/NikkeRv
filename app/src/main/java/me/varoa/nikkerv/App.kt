package me.varoa.nikkerv

import android.app.Application
import com.google.android.material.color.DynamicColors
import logcat.AndroidLogcatLogger
import logcat.LogPriority.VERBOSE
import me.varoa.nikkerv.ext.toggleAppTheme

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    // logcat I CAN HAZ LOGZ?
    AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = VERBOSE)
    DynamicColors.applyToActivitiesIfAvailable(this)
    toggleAppTheme(2)
  }
}
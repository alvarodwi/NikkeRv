package me.varoa.nikkerv

import android.app.Application
import logcat.AndroidLogcatLogger
import logcat.LogPriority.VERBOSE

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    // logcat I CAN HAZ LOGZ?
    AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = VERBOSE)
  }
}
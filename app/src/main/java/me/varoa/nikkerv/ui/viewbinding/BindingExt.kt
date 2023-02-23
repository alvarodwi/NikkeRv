package me.varoa.nikkerv.ui.viewbinding

import android.app.Activity
import android.os.Looper
import android.util.ArrayMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.viewbinding.ViewBinding
import logcat.logcat
import java.lang.reflect.Method

@MainThread
inline fun <T : ViewBinding> ViewGroup.viewBinding(
  viewBindingFactory: (LayoutInflater, ViewGroup, Boolean) -> T
) =
  viewBindingFactory.invoke(LayoutInflater.from(this.context), this, false)

@MainThread
fun <T : ViewBinding> Activity.viewBinding(bind: (View) -> T): ActivityViewBindingDelegate<T> =
  ActivityViewBindingDelegate.from(viewBindingBind = bind)

@MainThread
inline fun <reified T : ViewBinding> Activity.viewBinding(): ActivityViewBindingDelegate<T> =
  ActivityViewBindingDelegate.from(viewBindingClazz = T::class.java)

@PublishedApi
internal fun ensureMainThread() = check(Looper.getMainLooper() == Looper.myLooper()) {
  "Expected to be called on the main thread but was " + Thread.currentThread().name
}

internal object GetBindMethod {
  init {
    ensureMainThread()
  }

  private val methodSignature = View::class.java
  private val methodMap = ArrayMap<Class<out ViewBinding>, Method>()

  internal operator fun <T : ViewBinding> invoke(clazz: Class<T>): Method =
    methodMap
      .getOrPut(clazz) { clazz.getMethod("bind", methodSignature) }
      .also { logcat { "methodMap.size: ${methodMap.size}" } }
}
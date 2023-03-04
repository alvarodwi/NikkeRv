# Get rid of package names, makes file smaller
-repackageclasses

# --> Data classes
-keep class me.varoa.nikkerv.data.model.** { *; }

# --> ViewBinding
# ViewBindingDelegate uses Reflection.
-keepclassmembers class ** implements androidx.viewbinding.ViewBinding {
    public static ** bind(android.view.View);
}
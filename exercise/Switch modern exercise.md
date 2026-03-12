**Index:** [[Android UI Components Index]] | **Legacy Version:** [[Switch exercise]]
---

# Modern Switch (Material 3)

The legacy `<Switch>` or `<SwitchCompat>` components are older iterations. In modern Android development using Views, **Material Design 3 (M3)** prefers `com.google.android.material.materialswitch.MaterialSwitch`. This new component provides thicker tracks, a larger thumb, and supports applying vector icons right onto the thumb natively!

```xml
<com.google.android.material.materialswitch.MaterialSwitch
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Dark Mode"
    android:checked="true" />
```

Now create a file `exercise_switch_modern` file in layout subfolder and recreate a settings menu featuring multiple switches utilizing modern components and setting different sizes or thumb icons.

*(insert image of modern switch configurations here)*

**Index:** [[Android UI Components Index]] | **Legacy Version:** [[ProgressBar exercise]]
---

# Modern ProgressBar (Material 3)

The legacy `<ProgressBar>` used older styles. In modern Android development using Views, **Material Design 3 (M3)** introduces specific components for this: `LinearProgressIndicator` (for horizontal bars) and `CircularProgressIndicator` (for spinning wheels). These components support modern animations and gap sizes natively.

```xml
<!-- Determinate Horizontal Progress -->
<com.google.android.material.progressindicator.LinearProgressIndicator
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="100"
    android:progress="75"
    app:indicatorColor="?attr/colorPrimary"
    app:trackColor="?attr/colorSurfaceVariant"
    app:trackCornerRadius="4dp" />

<!-- Indeterminate Circular Progress -->
<com.google.android.material.progressindicator.CircularProgressIndicator
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:indeterminate="true"
    app:indicatorColor="?attr/colorSecondary" />
```

Now create a file `exercise_progressbar_modern` file in layout subfolder and recreate a loading screen that includes both a modern `LinearProgressIndicator` tracking completion and an indeterminate `CircularProgressIndicator`.

*(insert image of modern progress bar variations here)*

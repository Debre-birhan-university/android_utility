**Index:** [[Android UI Components Index]] | **Legacy Version:** [[ImageButton exercise]]
---

# Modern ImageButton (Material 3)

The legacy `<ImageButton>` used older attributes like `android:src` and hardcoded colors like `android:tint`. In modern Android development using Views, we use **Material Design 3 (M3)** with `app:srcCompat` (for vector drawable support) and dynamic theme colors `?attr/color...` for tinting. This ensures the app adapts to Dark Mode and Dynamic Color smoothly.

```xml
<ImageButton
    android:layout_width="48dp"
    android:layout_height="48dp"
    app:srcCompat="@drawable/ic_favorite"
    android:contentDescription="Favorite this item"
    android:background="?attr/selectableItemBackgroundBorderless"
    app:tint="?attr/colorError" />
```

Now create a file `exercise_imagebutton_modern` file in layout subfolder and recreate a row of social media icons or action icons using `ImageButton`s with modern M3 attributes. Make sure to apply accessible content descriptions.

*(insert image of modern image button configurations here)*

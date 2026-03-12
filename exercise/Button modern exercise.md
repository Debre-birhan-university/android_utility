**Index:** [[Android UI Components Index]] | **Legacy Version:** [[button_exercise]]
---

# Modern Button (Material 3)

The legacy `<Button>` often used older Material 2 components (`Widget.MaterialComponents.Button`). In modern Android development using Views, we use **Material Design 3 (M3)** button styles (`Widget.Material3.Button...`) which offer updated shapes, padding, and dynamic colors out of the box!

```xml
<!-- Filled button (Default) -->
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Primary Action" />

<!-- Elevated button -->
<Button
    style="@style/Widget.Material3.Button.ElevatedButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Elevated Action" />

<!-- Tonal button -->
<Button
    style="@style/Widget.Material3.Button.TonalButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Tonal Action" />

<!-- Outlined button -->
<Button
    style="@style/Widget.Material3.Button.OutlinedButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Outlined Action" />

<!-- Text button -->
<Button
    style="@style/Widget.Material3.Button.TextButton"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Text Action" />
```

Now create a file `exercise_buttons_modern` file in layout subfolder and recreate these 5 variations of Material 3 buttons in a vertical column to see their differences.

*(insert image of modern button variations here)*

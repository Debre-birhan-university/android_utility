**Index:** [[Android UI Components Index]] | **Legacy Version:** [[RadioButton exercise]]
---

# Modern RadioButton (Material 3)

The legacy `<RadioButton>` often used hardcoded color resources (`@color/...`). In modern Android development using Views, **Material Design 3 (M3)** prefers using dynamic theme attributes `?attr/color...` for tinting. This guarantees your RadioButton immediately supports Dynamic Color, Dark Mode, and Light Mode automatically!

```xml
<RadioButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Select Me"
    android:checked="true"
    android:buttonTint="?attr/colorPrimary" />
```

Now create a file `exercise_radiobutton_modern` file in layout subfolder and recreate a basic questionnaire UI using multiple RadioGroups utilizing modern theme attributes for buttonTint.

*(insert image of modern radio button configurations here)*

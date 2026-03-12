**Index:** [[Android UI Components Index]] | **Legacy Version:** [[TextView exerscse]]
---

# Modern TextView (Material 3)

The legacy `<TextView>` often used hardcoded text sizes in `sp` or direct hex colors (`#ff0000`). In modern Android development using Views, **Material Design 3 (M3)** prefers using semantic typography scales via `android:textAppearance`. This guarantees your app properly scales for accessibility settings and cleanly adapts to light and dark theme backgrounds dynamically!

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Headline Text"
    android:textAppearance="?attr/textAppearanceHeadlineMedium"
    android:textColor="?attr/colorError" />
```

> Now create a file `exercise_textview_modern` file in layout subfolder and recreate these using proper `?attr/textAppearance...` scales:
- text 1 = "Title Large"
- text 2 = "Headline Small"
- text 3 = "Body Medium terms and agreement"

*(insert image of modern text views here)*

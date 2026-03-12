**Index:** [[Android UI Components Index]] | **Legacy Version:** [[AutoCompleteTextView exercise]]
---

# Modern AutoCompleteTextView (Material 3 exposed dropdown)

The legacy `<AutoCompleteTextView>` requires a lot of custom styling for dropdown menus. In modern Android development using Views, we use **Material Design 3 (M3)** `TextInputLayout` combined with an `AutoCompleteTextView` to create an "Exposed Dropdown Menu".

This provides a beautiful floating label, native dropdown arrows, and consistent Material styling.

```xml
<com.google.android.material.textfield.TextInputLayout
    style="@style/Widget.Material3.TextInputLayout.OutlinedBox.ExposedDropdownMenu"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Select an option">

    <AutoCompleteTextView
        android:id="@+id/autoCompleteTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="none" />

</com.google.android.material.textfield.TextInputLayout>
```
*(Note: `inputType="none"` prevents the keyboard from showing if you only want it to act as a pure dropdown selection menu!)*

Now create a file `exercise_autocomplete_modern` file in layout subfolder and recreate a form that requires the user to select their Country from an exposed dropdown menu.

Try utilizing:
- `app:startIconDrawable` to add an icon inside the dropdown.
- `style="@style/Widget.Material3.TextInputLayout.FilledBox.ExposedDropdownMenu"` to see the filled variation.

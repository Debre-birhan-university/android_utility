**Index:** [[Android UI Components Index]] | **Legacy Version:** [[EditText exercise]]
---

# Modern EditText (Material 3)

The legacy `<EditText>` is no longer recommended. In modern Android development using Views, we use the **Material Design 3 (M3)** component `<com.google.android.material.textfield.TextInputLayout>` which wraps a `<com.google.android.material.textfield.TextInputEditText>`. This provides features like floating labels, error messages, and better accessibility.

```xml
<com.google.android.material.textfield.TextInputLayout
    android:id="@+id/til_email"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="@string/email"
    style="@style/Widget.Material3.TextInputLayout.OutlinedBox">

    <com.google.android.material.textfield.TextInputEditText
        android:id="@+id/et_email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textEmailAddress" />

</com.google.android.material.textfield.TextInputLayout>
```

Now create a file `exercise_edittext_modern` file in layout subfolder and recreate these modern text fields:

*(insert image of modern text input layouts here)*

what is the effect of setting
- `app:endIconMode="clear_text"` on the TextInputLayout
- `style="@style/Widget.Material3.TextInputLayout.FilledBox"`

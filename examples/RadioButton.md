# RadioButton
A `RadioButton` is a two-states button that can be either checked or unchecked. When the user sets the state to checked, it cannot be unchecked by the user pressing it again. They are usually grouped together in a `RadioGroup`.

### Example Code
```xml
<RadioGroup
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <RadioButton
        android:id="@+id/radio_option1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Option 1" />

    <RadioButton
        android:id="@+id/radio_option2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Option 2" />
</RadioGroup>
```
### Unique Attributes

- **`android:checked`**: Defines the default selected state of the radio button.
- **`android:orientation`** (on RadioGroup): Dictates if the buttons layout vertically or horizontally.

#exercise
- [[RadioButton exercise]]

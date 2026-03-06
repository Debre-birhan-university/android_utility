# Switch
A `Switch` is a two-state toggle switch widget that can select between two options (typically on/off). It is functionally similar to a [[CheckBox]] but provides a sliding animation that users are familiar with in settings menus.

### Example Code
```xml
<Switch
    android:id="@+id/switch_notifications"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Enable Notifications"
    android:checked="false" />
```

### Unique Attributes
- **`android:textOn`** / **`android:textOff`**: The text that appears on the switch itself depending on its state.
- **`android:thumb`**: The drawable to use for the thumb (the part the user interacts with).
- **`android:track`**: The drawable to use for the track (the background the thumb slides on).

#exercise
- [[Switch exercise]]

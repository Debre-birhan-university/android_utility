# Button
A `Button` is a subclass of [[TextView]], meaning it uses all the same text properties but is styled to look clickable.

### Example Code
```xml
<Button
    android:id="@+id/btn_submit"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Click Me!"
    android:backgroundTint="@color/design_default_color_primary"
    android:textAllCaps="false" />
    
```


### Attributes
> [!NOTE] 
> 🔗 Every button inherits basic generic properties (like `id`, `layout_width`, `layout_height`, `background`, `visibility`, etc.) from the base [[View]] class, and text formatting properties (like `android:text`) from the [[TextView]] class.

Specific styling often used on Buttons:
|                            |                                                                                                                         |
- **`android:textAllCaps`**: By default, Android buttons make all text CAPITAL. Set this to `false` to keep your casing.
- **`android:backgroundTint`**: Used to change the button color easily.
#exercise
- [[button_exercise]]

# ImageButton
An `ImageButton` displays a button with an image (instead of text) that can be pressed or clicked by the user. It is essentially an [[ImageView]] that brings along the default styling and behavior of a [[Button]].

### Example Code
```xml
<ImageButton
    android:id="@+id/btn_share"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/ic_share"
    android:contentDescription="Share to another app"
    android:background="?attr/selectableItemBackgroundBorderless" />
```

### Attributes
> [!NOTE] 
> 🔗 Every ImageButton inherits basic generic properties (like `id`, `layout_width`, `layout_height`, `background`, `visibility`, etc.) from the base `[[View]]` class, and image properties from the [[ImageView]] class.

Specific styling often used on ImageButtons:
- **`android:src`**: Sets a drawable as the content of this ImageButton, the image needs to be found under drawable folder
- **`android:contentDescription`**: Essential for accessibility. It describes what the button does to users who use screen readers.

#exercise
- [[ImageButton exercise]]

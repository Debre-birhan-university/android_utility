# TextView
A `TextView` is a subclass of [[View]] used to Displays text to the user and optionally allows them to edit it.
A complete text editor, however the basic class is configured to not allow editing.

### Basic Implementation
To see a TextView, you need the mandatory layout properties from [[View]] and the text content.

```xml
<TextView  
    android:id="@+id/welcome_text"
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"
    android:text="Hello Students!" />

```
### Content Options

1. **Hardcoded**: `android:text="Some Text"` (Quick but not recommended).
2. **Resources**: `android:text="@string/app_name"` (Linked to a [[Resource]] file).

Useful Attributes

| **Attribute**          | **Description**                                                                                                                                                                                                                                                                                    | **Values**                 |
| ---------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------- |
| `android:textSize`     | Size of the font . Recommended dimension type for text is "sp" for scaled-pixels (example: 15sp).<br>                                                                                                                                                                                              | Use `sp` (e.g., `16sp`)    |
| `android:textColor`    | Color of the text                                                                                                                                                                                                                                                                                  | Hex (e.g., `#FF0000`)      |
| `android:textStyle`    | Font weight.  Style (bold, italic, bolditalic) for the text. You can use or more of the following values separated by '\|'.<br>normal - 0<br>bold - 1<br>italic - 2<br>                                                                                                                            | `bold`, `italic`, `normal` |
| `android:typeface`<br> | Typeface (normal, sans, serif, monospace) for the text. You can use or more of the following values separated by '\|'.<br>normal - 0<br>sans - 1<br>serif - 2<br>monospace - 3<br>                                                                                                                 |                            |
| `android:gravity`      | Alignment inside the view                                                                                                                                                                                                                                                                          | `center`, `start`, `end`   |
| `android:lines`        | Force a specific number of lines                                                                                                                                                                                                                                                                   | Integer (e.g., `2`)        |

> [!NOTE] 
> 🔗 Every TextView inherits basic generic sizing, padding, and identification properties from the base [[View]] class.

| Attribute                  | Description                                                                                              |
| -------------------------- | -------------------------------------------------------------------------------------------------------- |
| android:text               | Text to display.                                                                                         |
| android:textAllCaps        | Present the text in ALL CAPS. Possible value either "true" or "false".                                   |
| android:textColor          | Text color. May be a color value, in the form of "#rgb", "#argb", "#rrggbb", or "#aarrggbb".             |
| android:textColorHighlight | Color of the text selection highlight.                                                                   |
| android:textColorHint      | Color of the hint text. May be a color value, in the form of "#rgb", "#argb", "#rrggbb", or "#aarrggbb". |
| android:textIsSelectable   | Indicates that content of a non-editable text can be selected. Possible value either "true" or "false".  |
#exercise
- [[TextView exerscse]]
-
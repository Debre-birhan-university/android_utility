Displays checked/unchecked states as a button. It is basically an on/off button with a light indicator.

## Attributes

|                            |                                                                                                                         |
| -------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| Attribute                  | Description                                                                                                             |
| android:disabledAlpha      | This is the alpha to apply to the indicator when disabled.                                                              |
| android:textOff            | This is the text for the button when it is not checked.                                                                 |
| android:textOn             | This is the text for the button when it is checked.                                                                     |
| android:autoText           | If set, specifies that this TextView has a textual input method and automatically corrects some common spelling errors. |
| android:drawableBottom     | This is the drawable to be drawn below the text.                                                                        |
| android:drawableRight      | This is the drawable to be drawn to the right of the text.                                                              |
| android:editable           | If set, specifies that this TextView has an input method.                                                               |
| android:text               | This is the Text to display.                                                                                            |
| android:background         | This is a drawable to use as the background.                                                                            |
| android:contentDescription | This defines text that briefly describes content of the view.                                                           |
| android:id                 | This supplies an identifier name for this view.                                                                         |
| android:onClick            | This is the name of the method in this View's context to invoke when the view is clicked.                               |
| android:visibility         | This controls the initial visibility of the view.                                                                       |
|                            |                                                                                                                         |

```xml
<ToggleButton 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="On"
android:id="@+id/toggleButton" 
android:checked="true"/> 

<ToggleButton 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:text="Off"
android:id="@+id/toggleButton2"
android:checked="true"/>
```


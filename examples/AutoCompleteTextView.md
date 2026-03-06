A view that is similar to EditText, except that it shows a list of completion suggestions automatically while the user is typing.

|                                  |                                                                                                                                |
| -------------------------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| Attribute                        | Description                                                                                                                    |
| android:completionHint           | This defines the hint displayed in the drop down menu.                                                                         |
| android:completionHintView       | This defines the hint view displayed in the drop down menu.                                                                    |
| android:completionThreshold      | This defines the number of characters that the user must type before completion suggestions are displayed in a drop down menu. |
| android:dropDownAnchor           | This is the View to anchor the auto-complete dropdown to.                                                                      |
| android:dropDownHeight           | This specifies the basic height of the dropdown.                                                                               |
| android:dropDownHorizontalOffset | The amount of pixels by which the drop-down should be offset horizontally.                                                     |
| android:dropDownSelector         | This is the selector in a drop down list.                                                                                      |
| android:dropDownVerticalOffset   | The amount of pixels by which the drop down should be offset vertically.                                                       |
| android:dropDownWidth            | This specifies the basic width of the dropdown.                                                                                |
| android:popupBackground          | This sets the background.                                                                                                      |

```xml 
<AutoCompleteTextView
android:id="@+id/autoCompleteTextView1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:ems="10" />

```
#exercise
- [[AutoCompleteTextView exercise]]

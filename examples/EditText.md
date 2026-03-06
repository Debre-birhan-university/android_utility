EditText `EditText` is where users type information. It is essentially an editable [[TextView]]. 

The predefined subclass of TextView that includes rich editing capabilities.
Attributes Inherited from `android.widget.TextView` Class 

### Example Code 
```xml 
<EditText 
android:id="@+id/et_user_name" 
android:layout_width="match_parent" 
android:layout_height="wrap_content" 
android:hint="Enter your name..." 
android:inputType="textPersonName" />
```
### Key Attributes
> [!NOTE] 
> 🔗 Every EditText inherits basic generic properties (like `id`, `layout_width`, `layout_height`, `background`, `visibility`, etc.) from the base [[View]] class, and text formatting properties (like `android:text`) from the [[TextView]] class.

Specific styling often used on EditTexts:
- **`android:hint`**: The "ghost text" that tells the user what to type. (Use [[Resource]] for this!)
- **`android:inputType`**: This is critical! It tells Android which keyboard to show.
    - `textPassword`: Hides characters.
    - `number`: Shows only the number pad.
    - `phone`: Shows the dialer pad.
#exercise
[[EditText exercise]]

# General View Properties
The `View` is the basic building block for user interface components. A View occupies a rectangular area on the screen and is responsible for drawing and event handling.

### Mandatory Attributes
Every View (and its subclasses like [[TextView]], [[ImageView]], etc.) **must** have these two attributes to exist:

* **`android:layout_width`**: Defines how wide the view is.
* **`android:layout_height`**: Defines how tall the view is.

## Common XML Attributes

Every UI component in Android (like `Button`, `TextView`, `ImageView`) inherits from `View`. This means they all share a set of universal properties that govern their size, spacing, identification, and visibility.

| Attribute | Description | Common Values |
| :--- | :--- | :--- |
| **`android:id`** | The unique identifier for this view, used to find it in Java/Kotlin (`findViewById`). | `@[+][+]id/resource_name` |
| **`android:layout_width`** | **MANDATORY**: Defines how wide the view should be. | `match_parent`, `wrap_content`, `[value]dp` |
| **`android:layout_height`** | **MANDATORY**: Defines how tall the view should be. | `match_parent`, `wrap_content`, `[value]dp` |
| **`android:background`** | A color or drawable visual placed behind the view's content. | `#Hex`, `?attr/color...`, `@drawable/...` |
| **`android:visibility`** | Controls whether the view is rendered to the screen. | `visible`, `invisible` (takes up space but unseen), `gone` (removed from layout calculation) |
| **`android:padding`** | Spacing applied **inside** the view's boundaries, pushing its internal content inward. | `[value]dp` |
| **`android:layout_margin`** | Spacing applied **outside** the view's boundaries, pushing surrounding views away. | `[value]dp` |
| **`android:onClick`** | The name of the method in the corresponding Activity/Fragment to execute when clicked (Legacy approach). | `methodName` |
| **`android:contentDescription`** | Accessibility text describing the view for screen readers (TalkBack). Mandatory for ImageViews/ImageButtons. | `@string/resource_name` |

**Common Values:**
1. `match_parent`: The view wants to be as big as its parent.
2. `wrap_content`: The view wants to be just big enough to enclose its content.
3. `dp` (e.g., `100dp`): A fixed size using density-independent pixels.

### Common Identifiers
* **`android:id`**: A unique name for the view (e.g., `@+id/my_button`) used to reference it in Java/Kotlin code.

### Spacing and Visibility
* **`android:padding`**: Space **inside** the view's borders.
* **`android:layout_margin`**: Space **outside** the view's borders.
* **`android:visibility`**: Can be `visible`, `invisible` (takes up space but hidden), or `gone` (hidden and takes no space).
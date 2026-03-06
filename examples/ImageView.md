An `ImageView` is a [[View]] used to display graphic content such as icons, photos, or illustrations.

### 1. Basic Implementation

To display an image, you must provide a source (`src`). Android looks for images in the `res/drawable` folder.
```xml
<ImageView
    android:id="@+id/iv_profile_picture"
    android:layout_width="200dp"
    android:layout_height="200dp"
    android:src="@drawable/ic_launcher_background"
    android:contentDescription="Profile Picture" />
```

### Mandatory Accessibility

- **`android:contentDescription`**: This is a text description of the image. It doesn't appear on the screen, but it is read aloud by Screen Readers (TalkBack) for visually impaired users. **Always use a [[Resource]] for this.**
### Key Attributes

|**Attribute**|**Description**|**Common Values**|
|---|---|---|
|**`android:src`**|The image file to display.|`@drawable/filename`|
|**`android:scaleType`**|How the image fits the bounds.|`centerCrop`, `fitCenter`|
|**`android:tint`**|Applies a color filter (great for icons).|`@color/primary`|
|**`android:alpha`**|Sets transparency (0.0 to 1.0).|`0.5` (50% transparent)|
 
 If your image is a different shape than your View, `scaleType` decides what happens:
- **`centerCrop`**: Resizes the image to fill the View entirely. Parts of the image might be cut off, but there will be no empty space.
- **`fitCenter`**: (Default) Shrinks or expands the image to fit inside the View. The whole image is visible, but there might be "letterboxing" (empty space) on the sides.
- **`center`**: Places the image in the middle without resizing it at all.
# ProgressBar
A `ProgressBar` is a visual indicator of progress in some operation. It can present a determinate amount of progress (like a file download) or an indeterminate amount (like a spinning wheel indicating "loading").

### Example Code
```xml
<!-- Indeterminate ProgressBar (Spinning circle) -->
<ProgressBar
    android:id="@+id/progress_circular"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:indeterminate="true" />

<!-- Determinate ProgressBar (Horizontal bar) -->
<ProgressBar
    android:id="@+id/progress_horizontal"
    style="?android:attr/progressBarStyleHorizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:max="100"
    android:progress="50" />
```

### Attributes
> [!NOTE] 
> 🔗 Every ProgressBar inherits basic generic properties (like `id`, `layout_width`, `layout_height`, `background`, `visibility`, etc.) from the base [[View]] class.

Specific attributes often used on ProgressBars:
- **`android:indeterminate`**: If set to true, the progress bar will animate continuously rather than showing a specific percentage.
- **`android:max`**: The maximum value the progress bar can achieve (usually 100).
- **`android:progress`**: The current value of the progress bar.
- **`style`**: Defines whether the progress bar is circular (default) or horizontal.

#exercise
- [[ProgressBar exercise]]

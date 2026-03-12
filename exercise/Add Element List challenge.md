**Index:** [[Android UI Components Index]]
---

# Challenge – The "Add Element" List

**Goal:** Practice the "Programmatic Pathway" (Option 2).

### XML Task
Create an empty `LinearLayout` (Vertical) with an ID `container_layout`. Add a single `Button` at the top labeled "Add Row".

### Activity Task
* Reference the `container_layout`.
* In the button's click listener, programmatically create a new `TextView`.
* Set its text to: "This is row number X" (where X increases).
* Use `container_layout.addView(newTextView)` to inject it into the UI.

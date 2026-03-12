**Index:** [[Android UI Components Index]]
---

# Lab Exercise 1 – The "Counter" App

**Goal:** Connect XML views to Activity logic using `findViewById`.

### XML Task
Create a layout with a `TextView` (displaying "0") and a `Button` (labeled "Count"). Give them unique IDs: `tv_counter` and `btn_increment`.

### Activity Task
* Get references to both views in `onCreate()`.
* Create a variable `var count = 0`.
* Set an `OnClickListener` on the button.

**Logic:** Every time the button is clicked, increment `count` and update the `TextView` text.

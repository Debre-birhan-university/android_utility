Allows to select the time of day in either 24 hour or AM/PM mode. 
The time consists of hours, minutes and clock format. 
Android provides this functionality through TimePicker class.
```xml
<TimePicker 
android:id="@+id/timePicker1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" />
```

|                                                                                  |                                                                                    |
| -------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| Attribute                                                                        | Description                                                                        |
| is24HourView()                                                                   | This method returns true if this is in 24 hour view else false                     |
| isEnabled()                                                                      | This method returns the enabled status for this view                               |
| setCurrentHour(Integer currentHour)                                              | This method sets the current hour                                                  |
| setCurrentMinute(Integer currentMinute)                                          | This method sets the current minute                                                |
| setEnabled(boolean enabled)                                                      | This method set the enabled state of this view                                     |
| setIs24HourView(Boolean is24HourView)                                            | This method set whether in 24 hour or AM/PM mode                                   |
| setOnTimeChangedListener(TimePicker.OnTimeChangedListener onTimeChangedListener) | This method Set the callback that indicates the time has been adjusted by the user |
|                                                                                  |                                                                                    |




```xml
<TimePicker 
android:id="@+id/timePicker1" 
android:layout_width="wrap_content" 
android:layout_height="wrap_content" 
android:layout_above="@+id/set_button" 
android:layout_centerHorizontal="true" 
android:layout_marginBottom="24dp" />

```


Allows to select the date consisting of day, month and year in your custom user interface.
Android provides DatePicker and DatePickerDialog components.
DatePickerDialog is a simple dialog containing DatePicker

|                                                 |                                                                                                                               |
| ----------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------- |
| Attribute                                       | Description                                                                                                                   |
| getDayOfMonth()                                 | Gets the selected day of month                                                                                                |
| getMonth()                                      | Gets the selected month                                                                                                       |
| getYear()                                       | Gets the selected year                                                                                                        |
| setMaxDate(long maxDate)                        | Sets the maximal date supported by this DatePicker in milliseconds since January 1, 1970 00:00:00 in getDefault() time zone   |
| setMinDate(long minDate)                        | Sets the minimal date supported by this NumberPicker in milliseconds since January 1, 1970 00:00:00 in getDefault() time zone |
| setSpinnersShown(boolean shown)                 | Sets whether the spinners are shown                                                                                           |
| updateDate(int year, int month, int dayOfMonth) | Updates the current date                                                                                                      |
| getCalendarView()                               | Returns calendar view                                                                                                         |
| getFirstDayOfWeek()                             | Returns first day of the week                                                                                                 |
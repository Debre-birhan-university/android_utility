  
Resources In Android, it is best practice to keep content (strings, colors, dimensions) separate from the layout XML. 
- String Resources (`strings.xml`) Instead of typing text directly into a [[TextView]], we define it here: 
```xml 
<string name="welcome_msg">Welcome to Android Lab!</string>

```

**Benefits:**

- **Translation:** Easy to support multiple languages.
- **Reusability:** Use the same string in multiple files.
- **Maintenance:** Change the text in one place, and it updates everywhere.
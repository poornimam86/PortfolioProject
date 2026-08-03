Lab 4 — Generics + File I/O
Aim
To implement a generic DataStore<T> class that can save and load Portfolio and User data as JSON using Jackson, so that application data persists across restarts, with IOException handled explicitly.
Theory
Generics allow a class or method to operate on objects of different types while preserving compile-time type safety, avoiding the need for unchecked casts. A generic DataStore<T> can therefore be reused to persist any domain type. Jackson's ObjectMapper serializes Java objects to JSON and deserializes JSON back into objects, making file-based persistence straightforward. Because file operations can fail (missing file, permissions, disk errors), each read/write is wrapped in explicit exception handling for IOException rather than being allowed to propagate silently.
Concepts Used
●	Generics
●	Type Parameters
●	File I/O (java.nio.file)
●	JSON Serialization with Jackson
●	Checked Exceptions (IOException)
Files Modified
●	DataStore.java (new)
●	Portfolio.java
●	User.java
●	Main.java
Algorithm
1.	Create a generic class DataStore<T> with save(T data, String path) and load(String path, Class<T> type) methods.
2.	Use Jackson's ObjectMapper to serialize objects to JSON files inside save().
3.	Implement load() to deserialize JSON back into an object of type T.
4.	Persist Portfolio and User objects using DataStore at appropriate points in the application.
5.	On application startup, attempt to reload previously saved Portfolio and User data.
6.	Wrap all file operations in try-catch blocks and handle IOException explicitly.
Expected Output
●	Save Portfolio to JSON
●	Save User to JSON
●	Reload Portfolio on Startup
●	Reload User on Startup
●	Handle Missing/Corrupt File Gracefully
Conclusion
Successfully implemented a generic, reusable DataStore<T> class that persists Portfolio and User objects to human-readable JSON files, allowing application state to survive restarts.

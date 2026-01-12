package com.hillel.cw_07.task;
/*
### 3. Виділити ім'я файлу та розширення

**Завдання:** Реалізуй метод:

```java
FileInfo parseFilePath(String path);
```

Приклад:

```
"/home/user/docs/report.pdf" → name: "report", ext: "pdf"
```

---
 */

public class FileService {

    public static void main(String[] args) {
        System.out.println(parseFilePath("/home/user/docs/report.pdf"));
    }

    private static FileInfo parseFilePath(String path){
        String[] str = path.split("/");
        String fileName = str[str.length - 1];
        str = fileName.split("\\.");
        return new FileInfo(path, str[0], str[1]);
    };

}

class FileInfo {

    private String basePath;
    private String name;
    private String ext;


    public FileInfo(String basePath, String name, String ext) {
        this.basePath = basePath;
        this.name = name;
        this.ext = ext;
    }

    @Override
    public String toString() {
        return String.format("%s -> name: %s, ext: %s", basePath, name, ext);
    }
}

# ТЗ: Динамическая коллекция строк на основе массива (DynamicStringArray)

## 1. Цель задания
Реализовать собственную динамическую коллекцию **строк** на основе обычного массива `String[]`, которая:
- автоматически расширяется при добавлении элементов,
- поддерживает вставку/удаление,
- корректно проверяет индексы,


Это аналог `ArrayList<String>`, но **без использования Java-коллекций**.

---

## 2. Ограничения

### Запрещено
- `ArrayList`, `List`, `Set`, `Map` и любые коллекции Java
- `Stream API`
- `Arrays.copyOf`

### Разрешено
- массив `String[]`
- `System.arraycopy(...)`
- базовые исключения Java

---

## 3. Требования к реализации

### 3.1. Класс
Создайте класс:

```java
public class DynamicStringArray {
    private String[] data;
    private int size;
}
```

### 3.2. Начальная емкость
- Используйте константу:

```java
private static final int INITIAL_CAPACITY = 10;
```

- При создании объекта массив должен иметь размер `INITIAL_CAPACITY`.

---

## 4. Публичный API (обязательно)

Реализовать следующие методы:

```java
public int size();
public boolean isEmpty();
public void add(String value);
public void add(int index, String value);
public String get(int index);
public String set(int index, String value);
public String remove(int index);
public boolean remove(String value);
public void clear();
public int indexOf(String value);
```

---

## 5. Контракты методов

### `int size()`
- Возвращает количество фактически добавленных элементов (не емкость массива).

### `boolean isEmpty()`
- Возвращает `true`, если `size == 0`.

### `void add(String value)`
- Добавляет элемент в конец.
- Если места нет — увеличивает емкость массива (см. раздел 6).

### `void add(int index, String value)`
- Вставляет элемент по индексу `index`.
- Допустимые индексы: `0..size` (включительно).
- Сдвигает элементы вправо.
- Если места нет — увеличивает емкость массива.
- Если индекс некорректный — бросает `IndexOutOfBoundsException`.

### `String get(int index)`
- Возвращает элемент по индексу.
- Допустимые индексы: `0..size-1`.
- При ошибке — `IndexOutOfBoundsException`.

### `String set(int index, String value)`
- Заменяет элемент по индексу на `value`.
- Возвращает старое значение.
- Индексы: `0..size-1`, иначе `IndexOutOfBoundsException`.

### `String remove(int index)`
- Удаляет элемент по индексу.
- Сдвигает элементы влево.
- Возвращает удалённый элемент.
- После удаления последний занятый слот должен стать `null` (чтобы избежать удержания ссылок).
- Индексы: `0..size-1`, иначе `IndexOutOfBoundsException`.

### `boolean remove(String value)`
- Удаляет **первое вхождение** `value`.
- Сравнение через `equals` (учесть `null`, если разрешаете).
- Возвращает `true`, если удаление произошло, иначе `false`.

### `void clear()`
- Очищает коллекцию: `size = 0`.
- Все элементы в массиве должны быть занулены (`null`) для освобождения ссылок.
- Массив можно оставить текущей емкости или пересоздать на `INITIAL_CAPACITY` (на выбор — описать в README).

### `int indexOf(String value)`
- Возвращает индекс первого вхождения.
- Если не найдено — возвращает `-1`.
- Сравнение через `equals` (учесть `null`, если разрешаете).

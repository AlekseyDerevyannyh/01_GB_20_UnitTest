# Курс "Unit-тесты" 
## Домашняя работа 3
* **
### Автор:
Деревянных Алексей
* **
### Примечание:

Тесты в файле **./Test/seminars/third/hw/MainHWTest.java**

* **
### Условие задачи:
#### Задание 0. (необязательное)
Попробовать самостоятельно решить задачи, которые не успели решить на семинаре.<br>
Сдавать решение не нужно.

#### Задание 1.
Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли переданное число четным или нечетным.
```java
public boolean evenOddNumber(int n) {
    if (n % 2 == 0) {
        return true;
    } else {
        return false;
    }
}
```

#### Задание 2.
Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли переданное число в интервал (25;100).
```java
public boolean numberInInterval(int n) { … }
```

#### Задание 3. (необязательное)
Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов. Для этого, вам потребуется расширить класс User новым свойством, указывающим, обладает ли пользователь админскими правами. Протестируйте данную функцию.
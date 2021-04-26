# [IO API](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/package-summary.html)

IO API предназначен для чтения данных из ресурса и записи данных в ресурс:
1. файл;
2. при работе с сетевым подключением;
3. System.err, System.in, System.out;
4. при работе с буфером.

## Для работы с IO API необходим `import  java.io.*`

## Основные классы:
1. [File](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/File.html) - класс для работы с файловой системой
2. <b>InputStream</b> и <b>OutputStream</b> работают с потоком байт
3. [InputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/InputStream.html) - описывает получение данные из различных источников
4. [OutputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/OutputStream.html) - описывает отправку данных в различные источники
5. <b>Reader</b> и <b>Writer</b> работают с потоком символов
6. [Reader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Reader.html) - описывает получение данные из различных источников
7. [Writer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Writer.html) - описывает отправку данных в различные источники

## InputStream и его наследники:
Основные методы:
1. `int read()` - читает байт из потока, возвращает целочисленное представление байта. При достижении конца потока возвращает -1
2. `int read(byte[] buffer)` - читает байты в буфер, возвращает количество прочитанных байт. При достижении конца потока возвращает -1
3. `int read(byte[] buffer, int byteOffset, int byteCount)` - читает byteCount байт в буфер, начиная со смещения byteOffset. Возвращает количество прочитанных байт или -1, если достигнут конец потока
4. `close()` - закрывает источник ввода. Следующие попытки чтения приведут к IOException
5. `int available()` - возвращает количество байт, доступные в данный момент для чтения

Наследники:
1. [FileInputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileInputStream.html) - 
   поток вывода, который содержит методы, записывающие данные в файл;
2. [ByteArrayInputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/ByteArrayInputStream.html) -
   позволяет использовать буфер в памяти как InputStream. Входным источником является массив байт.
3. [ObjectInputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/ObjectInputStream.html) -
   добавляет функциональность к другому входному потоку. Чтение ранее сериализованных данных из потока. Десериализует примитивные данные и объекты.
4. [FilterInputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FilterInputStream.html) -
   абстрактный класс, предоставляющий интерфейс для классов-декораторов, которые добавляют к существующим потокам полезные свойства.
5. [BufferedInputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedInputStream.html) -
   добавляет функциональность к другому входному потоку. Дает возможность буферизации входных данных.  
   При создании BufferedInputStream создается внутренний буферный массив. Когда байты из потока считываются или пропускаются, внутренний буфер заполняется.
6. [DataInputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/DataInputStream.html) -
   считывает из потока данные примитивных типов и строк. 
   Соответственно для каждого примитивного типа определен свой метод для считывания `XXX readXXX()`
   
## OutputStream и его наследники:
Основные методы:
1. `void write(int b)` - пишет байт в поток
2. `void write(byte[] b)` - пишет b.length байт в поток из массива b
3. `void write(byte[] b, int off, int len)` - пишет len байт в поток из массива b, начиная со смещения off
4. `void flush()` - записывает все буферизованные в поток
5. `close()` - закрывает источник. Следующие попытки записи приведут к IOException

Наследники:
1. [FileOutputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileOutputStream.html) -
   поток ввода, который содержит методы, читающие данные из файла;
2. [ByteArrayOutputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/ByteArrayOutputStream.html) -
   позволяет использовать буфер в памяти как OutputStream. Выходным источником является массив байт.
3. [ObjectOutputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/ObjectOutputStream.html) -
   используется для сериализации объектов в поток. Записывает сериализованные данные в поток.
4. [FilterOutputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FilterOutputStream.html) -
   абстрактный класс, предоставляющий интерфейс для классов-декораторов, которые добавляют к существующим потокам полезные свойства.
5. [BufferedOutputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedOutputStream.html) -
   добавляет функциональность к другому выходному потоку.  Этот буфер накапливает выводимые байты без постоянного обращения к устройству. И когда буфер заполнен, производится запись данных.
6. [DataOutputStream](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/DataOutputStream.html) -
   представляет поток вывода и предназначен для записи данных примитивных типов и строк. 
   Для записи каждого из примитивных типов предназначен свой метод `writeXXX(XXX v)`

## Reader и его наследники:
Основные методы:
1. `int read()` - читает символ из потока, возвращает целочисленное представление символа. При достижении конца потока возвращает -1
2. `int read(char[] buffer)` - читает символы в буфер, возвращает количество прочитанных символов. При достижении конца потока возвращает -1
3. `int read(char[] buffer, int offset, int length)` - читает length символов в буфер, начиная со смещения offset. Возвращает количество прочитанных символов или -1, если достигнут конец потока
4. `close()` – метод закрывает поток.

Наследники:
1. [FileReader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileReader.html) -
   используется для чтения из файла;
2. [BufferedReader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedReader.html) -
   считывает текст из символьного потока ввода, буферизируя прочитанные символы. Использование буфера призвано увеличить производительность чтения данных из потока;
3. [CharArrayReader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/CharArrayReader.html) -
   читает из символьного массива;
   
## Writer и его наследники:
1. `void write(int c)` – записывает один символ в поток
2. `void write(char[] buffer)` – записывает массив символов в поток.
3. `void write(char[] buffer, int offset, int length)` – записывает length символов в поток из массива buffer, начиная с позиции offset.
4. `void write(String string)` – записывает строку в поток.
5. `void write(String string, int offset, int length)` – записывает length символов в поток из строки, начиная с позиции offset.

Наследники:
1. [FileWriter](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/FileWriter.html) -
  используется для записи в файл;
2. [BufferedWriter](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/BufferedWriter.html) -
   записывает текст в поток, предварительно буферизируя записываемые символы, тем самым снижая количество обращений к физическому носителю для записи данных;
3. [CharArrayWriter](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/CharArrayWriter.html) -
   пишет в символьный массив;

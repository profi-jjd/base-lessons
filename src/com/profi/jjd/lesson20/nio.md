## Java NIO (New IO / Non-blocking IO)
Пакет предназначен для работы с вводом-выводом.
Основные характеристики:
1. Неблокирующий
2. Асинхронный
3. Буфер-ориентированный

Составляющие NIO пакета:
1. Классы для работы с файловой системой;
2. Каналы;
3. Буферы;
4. Селекторы.

## Классы и интерфейсы для работы с файловой системой:
1. [Path](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Path.html) - 
   объект, который описывает путь к файлу или директории
2. [Paths](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Paths.html) -
   содержит статические методы для создания объектов типа Path
3. [Files](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Files.html) -
   содержит методы для работы с файлами и директориями
   
## Каналы (Channels):
- канал может быть использован и для записи, и для чтения;
- чтение и запись может происходить асинхронно;
- каналы всегда пишут в буфер и читают из буфера;

1. [FileChannel](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/channels/FileChannel.html) - 
   для работы с файлами
2. [DatagramChannel](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/channels/DatagramChannel.html) - 
   используется в качестве канала, который может отправлять и получать пакеты по UDP протоколу
3. [SocketChannel](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/channels/SocketChannel.html) -
   для создания клиентского сокета
4. [ServerSocketChannel](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/channels/ServerSocketChannel.html) -
   для создания серверного сокета

## Буферы (Buffers):
1. [ByteBuffer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/ByteBuffer.html)
2. [CharBuffer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/CharBuffer.html)
3. [DoubleBuffer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/DoubleBuffer.html)
4. [FloatBuffer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/FloatBuffer.html)
5. [IntBuffer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/IntBuffer.html)
6. [LongBuffer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/LongBuffer.html)
6. [ShortBuffer](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/ShortBuffer.html)

Свойства буферов:
- capacity - емкость (не меняется после установки)
- position - текущая позиция в буфере (изначально 0)
- limit - до какого значения можно читать / писать данные (изначально равен capacity)

## Селекторы (Selectors):
1. селекторы позволяют одному потоку обслуживать несколько каналов
2. селектор подписывается на событие (или несколько событий) в канале (Connect / Accept / Read / Write)
3. когда в канале наступит то или иное событие, селектор будет проинформирован об этом и сможет отреагировать необходимым образом 
   (например, можно на каждое соединение с сервером можно создать отдельный канал)
   
### События на канале:
1. Connect (SelectionKey.OP_CONNECT) - событие подключения к серверу
2. Accept (SelectionKey.OP_ACCEPT) - событие подключения нового клиента
3. Read (SelectionKey.OP_READ) - пришли данные для чтения
4. Write (SelectionKey.OP_WRITE) - пришли данные для записи

# CounterDocumentAndPage

Проект по заданному пути до корневой папки,
получает суммарное количество всех документов
и суммарное количество всех страниц, заданных форматов(docx, doc, pdf), в этой папке и её подпапках.

Применил шаблон проектирования "СТРАТЕГИЯ", для того, 
чтобы было просто добавить новый формат,
с которым мы будем в дальнейшем работать.

Приложение написанно с помощью SpringBoot, maven.

Для получения количества страниц во всех файлах: "Post controller /counter/get-quantity-pages".
Для получения количества файловво всех папках: "Post controller /counter/get-quantity-documents".

В папке postman есть файл, который можно импортировать в программе Postman.

Для части кода написаны тесты с помощью SpringBootTest и JUnit.

Логирование осуществленно с помощью Log4j2.

С помощью ControllerAdvice и ExceptionHandler обработана ошибка NotFoundDirectoryException.





# YouTube Autotests

Запуск из Windows - test.cmd. После прогонов тестов откроется Аллюр отчет
Для MacOs нудно установить аллюр _brew install allure_
После этого запускается _mvn clean test_, а затем _allure serve ./target/allure-results_

Требования JDK 1.8
Не знаю почему, но с версией выше не работает, чуть позже постараюсь разобраться, скорее всего где-то конфликт версий.

Работает только в chrome на windows и macos.
Для других браузеров нужно прописывать драйвера

Проект создавал не с нуля, решил попробовать поэксперемнтировать с maven Archetype. Так удобнее создается окружение.
Убрал после этого всё лишнее и доработал некоторые моменты.

Ниже идет минимальный список тестов, которые я не успел:

**Поиск:**
1. Поиск несуществующих видео (а такие вообще есть?)
2. Поиск видео доступного только по ссылке (зарегестрированным и нет пользователем)

**Регистрация:**
1. Проверка существующих аккаунтов
2. Некорректное имя
3. Некорректная фамилия
4. Невалидный емайл
5. Слабый пароль




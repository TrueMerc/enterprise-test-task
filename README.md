# enterprise-test-task
Repository for my Jave EE based coding interview task.

# Стек технологий

- JDK 8
- Ant, Maven
- Glassfish 4.1.2
- MySQL или PostgreSQL (второе предпочтительнее)
- фронт-энд: jQuery, Bootstrap, Font Awesome

# Задание

Необходимо разработать приложение для Glassfish4, отвечающее указанным ниже требованиям.

1. Минимальный набор таблиц в БД (при желании можно расширить):
    - сотрудники (ФИО, возраст);
    - домашние адреса (адрес, район, округ);
    - режим работы (время начала рабочего дня, время окончания рабочего дня).
2. Необходимые страницы и их логика:
    - главная страница со списком сотрудников:
        - при клике на ФИО происходит переход на страницу сотрудника;
        - выбор типа сортировки сотрудника:
            - алфавитный по имени;
            - алфавитный по округу;
            - алфавитный по району;
            - по возрасту;
        - возможность фильтрации по округу и по району.
    - страница сотрудника должна выводить все известные данные о сотруднике;
    - форма ввода данных для сотрудника (можно совместить со страницей сотрудника):
        - форма не должна отправляться без введённых ФИО (валидация формы на JavaScript);
        - округ и район должны выбираться из списка;
        - данные должны сохраняться в БД;
        - после сохранения должна открываться странца сотрудника.
3. Все страницы должны быть свёрстаны и оформлены в едином стиле.
    

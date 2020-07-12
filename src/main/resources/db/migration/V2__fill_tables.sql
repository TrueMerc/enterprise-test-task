-- Тестовые значение для округов
INSERT INTO administrative_divisions (name)
    VALUES ('First administrative division'),
           ('Second administrative division');
-- Тестовые значения для районов
INSERT INTO districts (name, division_id)
    VALUES ('District One', 1),
           ('District Two', 1),
           ('District Three', 2),
           ('District Four', 2);
-- Тестовые значения для адресов проживания
INSERT INTO addresses (name, district_id)
    VALUES ('Street One, 16', 1),
           ('Street Two, 2', 1),
           ('Street Three, 4', 2),
           ('Street Four, 8', 2),
           ('Street Five, 32', 3),
           ('Street Six, 16', 3),
           ('Street Seven, 1', 4),
           ('Street Eight, 32', 4);
-- Тестовые значения для интервалов рабочего времени
INSERT INTO work_hours (start_time, end_time)
    VALUES ('08:00:00', '17:00:00'),
           ('09:00:00', '18:00:00'),
           ('10:00:00', '19:00:00');
-- Тестовые значения для работников
INSERT INTO employees (second_name, first_name, patronymic, work_hours_id, address_id, age)
    VALUES ('Ivanov', 'Ivan', 'Ivanovich', 1, 1, 25),
           ('Petrov', 'Petr', 'Petrovich', 2, 2, 34),
           ('Sidorov', 'Petr', 'Grigorievich', 3, 3, 38),
           ('Smirnov', 'Ivan', 'Ivanovich', 1, 4, 27),
           ('Kuznetsov', 'Vladimir', 'Nikolaevich', 3, 5, 35),
           ('Nikolaev', 'Ivan', 'Petrovich', 2, 6, 30),
           ('Ivanov', 'Petr', 'Vladimirovich', 2, 7, 29),
           ('Smirnov', 'Vladimir', 'Ivanovich', 3, 8, 29),
           ('Sidorov', 'Nikolay', 'Petrovich', 1, 3, 31);
-- Тестовые значения для пар "работник - адрес проживания"
-- INSERT INTO employees_addresses (employee_id, address_id)
--     VALUES (1, 1),
--            (2, 2),
--            (3, 3),
--            (4, 4),
--            (5, 5),
--            (6, 6),
--            (7, 7),
--            (8, 8),
--            (9, 3);



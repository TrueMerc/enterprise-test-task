DROP TABLE IF EXISTS employees;
CREATE TABLE employees
(
    id bigserial PRIMARY KEY,
    second_name varchar(40) NOT NULL,
    first_name varchar(40) NOT NULL,
    patronymic varchar(40) NOT NULL,
    work_hours_id bigint NOT NULL,
    age smallint NOT NULL
);
-- Таблица, содержащая административные округа.
DROP TABLE IF EXISTS administrative_divisions;
CREATE TABLE administrative_divisions
(
    id bigserial PRIMARY KEY,
    name varchar(50) NOT NULL
);
/* Таблица, содержащая список районов, при решении
 * задачи использовалось предположение, что районы
 * могут принадлежать к округам, а могут быть самостоятельными,
 * тогда в соответствующем поле для идентификатора округа возникает
 * значение null. Округа без районов быть не может.
 */
 DROP TABLE IF EXISTS districts;
 CREATE TABLE districts
 (
    id bigserial PRIMARY KEY,
    name varchar(50) NOT NULL,
    division_id bigint
 );
 -- Таблица, содержащая адреса
 DROP TABLE IF EXISTS addresses;
 CREATE TABLE addresses
 (
    id bigserial PRIMARY KEY,
    name varchar(60) NOT NULL,
    district_id bigint NOT NULL
 );
 -- Таблица, содержащая возможные интервалы рабочего времени.
 DROP TABLE IF EXISTS work_hours;
 CREATE TABLE work_hours
 (
    id bigserial PRIMARY KEY,
    start_time time NOT NULL,
    end_time time NOT NULL
 );
 -- Таблица, устанавливающая соответствие между сотрудниками и адресами
 DROP TABLE IF EXISTS employees_addresses;
 CREATE TABLE employees_addresses(
    employee_id bigint,
    address_id bigint,
    PRIMARY KEY( employee_id, address_id ),
    FOREIGN KEY (employee_id)
        REFERENCES employees (id),
    FOREIGN KEY (address_id)
        REFERENCES  addresses (id)
 );




-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into country (id, name, countryCode, population, continent) values(nextval('hibernate_sequence'), 'Austria', 'AUT', 9100000, 'Europe');
insert into country (id, name, countryCode, population, continent) values(nextval('hibernate_sequence'), 'Germany', 'GER', 84607016, 'Europe');
insert into country (id, name, countryCode, population, continent) values(nextval('hibernate_sequence'), 'India', 'IN', 1428000000, 'Europe');
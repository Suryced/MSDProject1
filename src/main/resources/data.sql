insert into EVENTS (EVENT_CODE, TITLE, DESCRIPTION)
values('ABC123','Project Event','Example Description');

insert into REGISTRATION (CUSTOMER_ID, EVENT_ID, REGISTRATION_DATE, NOTES) VALUES('1', '1', 'today', 'none');
insert into REGISTRATION (CUSTOMER_ID, EVENT_ID, REGISTRATION_DATE, NOTES) VALUES(2, 4, 'tomorrow', 'negative');
insert into REGISTRATION (CUSTOMER_ID, EVENT_ID, REGISTRATION_DATE, NOTES) VALUES(5, 1, '2004', 'nada');
insert into REGISTRATION (CUSTOMER_ID, EVENT_ID, REGISTRATION_DATE, NOTES) VALUES(3, 2, '1776', 'nope');
insert into REGISTRATION (CUSTOMER_ID, EVENT_ID, REGISTRATION_DATE, NOTES) VALUES(2, 7, 'next week monday', 'nuh uh');

insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("Bruce"         , "pass"    , "bruce@a.com"       );
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("Paul"          , "pass"    , "paul@b.com"        );
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("Rick"          , "pass"    , "rick@c.com"        );
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("Cameron"       , "123456"  , "cameron@mcnz.com"  );
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("Curtis"        , "abcdefg" , "curtis@example.com");
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("andy@gmail.com", null      , "andy"              );
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("Aaron"         , null      , "Aaron@example.com" );
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("nn"            , "rr"      , "aa"                );
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("Jake"          , "pass"    , "jblatt@wowway.com" );
insert into CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES ("Test"          , "passtest", "test@test.com"     );


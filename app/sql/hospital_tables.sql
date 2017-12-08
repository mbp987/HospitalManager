create database hospital DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
use hospital;
#drop database hospital;

CREATE TABLE specialists (
    id_spec INT(4) ZEROFILL AUTO_INCREMENT PRIMARY KEY,
    spec_name VARCHAR(15),
    spec_last VARCHAR(30),
    spec VARCHAR(20)
);

CREATE TABLE patients (
    id_patient INT(8) ZEROFILL AUTO_INCREMENT PRIMARY KEY,
    pat_name VARCHAR(15),
    pat_last VARCHAR(30)
);

CREATE TABLE schedules (
    id_spec INT(4) ZEROFILL PRIMARY KEY,
    mon_start TIME,
    mon_end TIME,
    tue_start TIME,
    tue_end TIME,
    wed_start TIME,
    wed_end TIME,
    thu_start TIME,
    thu_end TIME,
    fri_start TIME,
    fri_end TIME,
    FOREIGN KEY (id_spec)
        REFERENCES specialists (id_spec)
);

CREATE TABLE visits (
    id_visit INT(10) ZEROFILL AUTO_INCREMENT PRIMARY KEY,
    id_patient INT(8) ZEROFILL,
    id_spec INT(4) ZEROFILL,
    visit_date DATE,
    visit_start TIME,
    visit_end TIME,
    FOREIGN KEY (id_patient)
        REFERENCES patients (id_patient),
    FOREIGN KEY (id_spec)
        REFERENCES specialists (id_spec)
);

insert into specialists(id_spec, spec_name, spec_last, spec) values (1, 'Adam', 'Adamczyk', 'dermatologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (2, 'Barbara', 'Barańska', 'paediatrician');
insert into specialists(id_spec, spec_name, spec_last, spec) values (3, 'Cezary', 'Cember', 'cardiologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (4, 'Dorian', 'Dior', 'neurologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (5, 'Emma', 'Etan', 'dermatologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (6, 'Filip', 'Flis', 'oculist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (7, 'Gustaw', 'Grzegorczyk', 'orthopaedist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (8, 'Hanna', 'Holm', 'gynaecologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (9, 'Igor', 'Imo', 'paediatrician');
insert into specialists(id_spec, spec_name, spec_last, spec) values (10, 'Joanna', 'Jasińska', 'cardiologist');


insert into patients(id_patient, pat_name, pat_last) values (1, 'Mickey', 'Mouse');
insert into patients(id_patient, pat_name, pat_last) values (2, 'Donald', 'Duck');
insert into patients(id_patient, pat_name, pat_last) values (3, 'Gandalf', 'Szary');
insert into patients(id_patient, pat_name, pat_last) values (4, 'Frodo', 'Baggins');
insert into patients(id_patient, pat_name, pat_last) values (5, 'Snow', 'White');
insert into patients(id_patient, pat_name, pat_last) values (6, 'Bruce', 'Wayne');
insert into patients(id_patient, pat_name, pat_last) values (7, 'Clark', 'Kent');
insert into patients(id_patient, pat_name, pat_last) values (8, 'Papa', 'Smurf');
insert into patients(id_patient, pat_name, pat_last) values (9, 'Captain', 'America');
insert into patients(id_patient, pat_name, pat_last) values (10, 'Johnny', 'Bravo');


insert into schedules (id_spec, mon_start, mon_end) values (1, '08:00:00', '14:00:00');
insert into schedules (id_spec, mon_start, mon_end, wed_start, wed_end, thu_start, thu_end) values (2, '10:00:00', '12:00:00', '11:00:00', '18:00:00', '08:00:00', '14:00:00');
insert into schedules (id_spec, tue_start, tue_end) values (3, '09:00:00', '18:00:00');
insert into schedules (id_spec, mon_start, mon_end, tue_start, tue_end, fri_start, fri_end) values (4, '12:00:00', '17:00:00', '09:00:00', '16:00:00', '08:00:00', '12:00:00');
insert into schedules (id_spec, mon_start, mon_end, tue_start, tue_end, wed_start, wed_end, thu_start, thu_end) values (5, '08:00:00', '12:00:00', '11:00:00', '18:00:00', '08:00:00', '14:00:00', '10:00:00', '15:00:00');
insert into schedules (id_spec, fri_start, fri_end) values (6, '08:00:00', '17:00:00');
insert into schedules (id_spec, tue_start, tue_end, wed_start, wed_end, fri_start, fri_end) values (7, '09:00:00', '14:00:00', '10:00:00', '17:00:00', '11:00:00', '14:00:00');
insert into schedules (id_spec, wed_start, wed_end) values (8, '08:00:00', '13:00:00');
insert into schedules (id_spec, mon_start, mon_end, tue_start, tue_end, wed_start, wed_end, thu_start, thu_end, fri_start, fri_end) values (9, '08:00:00', '12:00:00', '09:00:00', '13:00:00', '11:00:00', '18:00:00', '08:00:00', '14:00:00', '10:00:00', '15:00:00');
insert into schedules (id_spec, mon_start, mon_end, tue_start, tue_end, thu_start, thu_end) values (10, '14:00:00', '17:00:00', '15:00:00', '18:00:00', '08:00:00', '12:00:00');


insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(1, 1, 4, '2017-12-19', '12:00:00', '13:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(2, 4, 5, '2017-12-20', '08:00:00', '09:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(3, 5, 7, '2017-12-20', '10:00:00', '11:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(4, 7, 9, '2017-12-15', '12:00:00', '13:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(5, 10, 10, '2017-12-14', '08:00:00', '09:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(6, 2, 1, '2017-12-18', '10:00:00', '11:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(7, 8, 7, '2017-12-15', '12:00:00', '13:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(8, 2, 5, '2017-12-21', '14:00:00', '15:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(9, 1, 8, '2017-12-20', '08:00:00', '09:00:00');
insert into visits (id_visit, id_patient, id_spec, visit_date, visit_start, visit_end) values(10, 3, 4, '2017-12-19', '09:00:00', '10:00:00');

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
    id_spec INT(4),
    hour_range int,
	mon varchar(30),
    tue varchar(30),
    wed varchar(30),
    thu varchar(30),
    fri varchar(30)
);

CREATE TABLE visits (
    id_visit INT(9) ZEROFILL AUTO_INCREMENT PRIMARY KEY,
    id_patient INT(8) ZEROFILL,
    id_spec INT(4) ZEROFILL,
    visit_date DATE,
    visit_term INT,
    FOREIGN KEY (id_patient)
        REFERENCES patients (id_patient),
    FOREIGN KEY (id_spec)
        REFERENCES specialists (id_spec)
);

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


insert into specialists(id_spec, spec_name, spec_last, spec) values (1, 'Adam', 'Adamczyk', 'dermatologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (2, 'Barbara', 'Baranowska', 'paediatrician');
insert into specialists(id_spec, spec_name, spec_last, spec) values (3, 'Cezary', 'Cember', 'cardiologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (4, 'Dorian', 'Dior', 'neurologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (5, 'Emma', 'Etan', 'dermatologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (6, 'Filip', 'Flis', 'oculist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (7, 'Gustaw', 'Grzegorczyk', 'orthopaedist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (8, 'Hanna', 'Holm', 'gynaecologist');
insert into specialists(id_spec, spec_name, spec_last, spec) values (9, 'Igor', 'Imo', 'paediatrician');
insert into specialists(id_spec, spec_name, spec_last, spec) values (10, 'Joanna', 'Jasny', 'cardiologist');


insert into schedules values (1,1,'free','-','-','-','-');
insert into schedules values (1,2,'free','-','-','-','-');
insert into schedules values (1,3,'free','-','-','-','-');
insert into schedules values (1,4,'free','-','-','-','-');
insert into schedules values (1,5,'free','-','-','-','-');
insert into schedules values (1,6,'free','-','-','-','-');
insert into schedules values (1,7,'-','-','-','-','-');
insert into schedules values (1,8,'-','-','-','-','-');

insert into schedules values (2,1,'-','-','-','-','free');
insert into schedules values (2,2,'-','-','free','-','free');
insert into schedules values (2,3,'free','-','free','-','free');
insert into schedules values (2,4,'free','-','free','-','free');
insert into schedules values (2,5,'free','-','free','-','free');
insert into schedules values (2,6,'-','-','free','-','free');
insert into schedules values (2,7,'-','-','free','-','-');
insert into schedules values (2,8,'-','-','free','-','-');

insert into schedules values (3,1,'-','-','-','-','-');
insert into schedules values (3,2,'-','free','-','-','-');
insert into schedules values (3,3,'-','free','-','-','-');
insert into schedules values (3,4,'-','free','-','-','free');
insert into schedules values (3,5,'-','free','-','-','free');
insert into schedules values (3,6,'-','free','-','-','free');
insert into schedules values (3,7,'-','free','-','-','-');
insert into schedules values (3,8,'-','free','-','-','-');

insert into schedules values (4,1,'-','-','-','free','-');
insert into schedules values (4,2,'-','-','-','free','-');
insert into schedules values (4,3,'-','-','-','free','-');
insert into schedules values (4,4,'-','-','-','-','free');
insert into schedules values (4,5,'-','free','-','-','free');
insert into schedules values (4,6,'-','free','-','-','free');
insert into schedules values (4,7,'-','free','-','-','-');
insert into schedules values (4,8,'-','free','-','-','-');

insert into schedules values (5,1,'-','-','-','-','free');
insert into schedules values (5,2,'-','-','-','-','free');
insert into schedules values (5,3,'free','-','free','-','free');
insert into schedules values (5,4,'free','-','free','-','free');
insert into schedules values (5,5,'free','-','free','-','-');
insert into schedules values (5,6,'free','-','free','-','-');
insert into schedules values (5,7,'-','-','free','-','-');
insert into schedules values (5,8,'-','-','free','-','-');

insert into schedules values (6,1,'-','-','-','free','-');
insert into schedules values (6,2,'-','free','-','free','-');
insert into schedules values (6,3,'-','free','-','free','free');
insert into schedules values (6,4,'-','free','free','-','free');
insert into schedules values (6,5,'-','free','free','-','free');
insert into schedules values (6,6,'-','free','free','-','free');
insert into schedules values (6,7,'-','-','free','-','-');
insert into schedules values (6,8,'-','-','free','-','-');

insert into schedules values (7,1,'-','free','-','-','-');
insert into schedules values (7,2,'-','free','-','free','-');
insert into schedules values (7,3,'-','free','-','free','-');
insert into schedules values (7,4,'-','-','-','free','free');
insert into schedules values (7,5,'-','-','-','free','free');
insert into schedules values (7,6,'-','-','-','-','free');
insert into schedules values (7,7,'-','-','-','-','-');
insert into schedules values (7,8,'-','-','-','-','-');

insert into schedules values (8,1,'-','-','-','free','-');
insert into schedules values (8,2,'free','-','-','free','-');
insert into schedules values (8,3,'free','-','-','free','-');
insert into schedules values (8,4,'free','-','free','free','-');
insert into schedules values (8,5,'free','-','free','free','-');
insert into schedules values (8,6,'free','-','free','-','-');
insert into schedules values (8,7,'-','-','free','-','-');
insert into schedules values (8,8,'-','-','free','-','-');

insert into schedules values (9,1,'-','free','-','-','-');
insert into schedules values (9,2,'-','free','-','-','-');
insert into schedules values (9,3,'-','free','-','-','-');
insert into schedules values (9,4,'-','-','-','free','free');
insert into schedules values (9,5,'-','-','-','free','free');
insert into schedules values (9,6,'-','free','-','free','free');
insert into schedules values (9,7,'-','free','-','free','-');
insert into schedules values (9,8,'-','free','-','free','-');

insert into schedules values (10,1,'-','-','-','free','-');
insert into schedules values (10,2,'free','-','-','free','-');
insert into schedules values (10,3,'free','-','-','free','free');
insert into schedules values (10,4,'free','-','-','free','free');
insert into schedules values (10,5,'free','-','-','-','free');
insert into schedules values (10,6,'free','free','-','-','free');
insert into schedules values (10,7,'-','free','-','-','free');
insert into schedules values (10,8,'-','free','-','-','-');


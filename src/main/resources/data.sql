insert into studenti(nume, prenume, email, parola) values
    ('maroiu', 'alex', 'alex@mail.com', 'pass'),
    ('maroiu','andrei', 'andrei@mail.com','pass'),
    ('micu','raluca','raluca@mail.com','try123');

insert into cursuri(cod_disciplina, nume_disciplina, an, credite) values
    (111, 'Electronica Digitala', 'II', 6),
    (112, 'Programare Orientata pe Obiect', 'II', 5),
    (113, 'Elemente de Grafica pe Calculator', 'II', 4),
    (114, 'Programarea Algoritmilor', 'II', 3),
    (115, 'Programare Logica si Functionala', 'II', 2);

insert into note(cod_disciplina, cod_student, nota, situatie, departament) values
    (111, 1, 7, 'Promovat', 'Tehnologia Informatiei'),
    (112, 1, 10, 'Promovat', 'Tehnologia Informatiei'),
    (113, 2, 4, 'Nepromovat', 'Tehnologia Informatiei'),
    (114, 2, 8, 'Promovat', 'Tehnologia Informatiei'),
    (115, 3, 10, 'Promovat', 'Tehnologia Informatiei');

insert into examene(cod_disciplina,cod_student,data,ora) values
    (114,1, '14/06/2005', '9:00'),
    (113,2, '26/06/2005', '12:00'),
    (115,3, '26/06/2005', '14:00');
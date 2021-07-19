insert into studenti(nume, prenume, email, parola) values
    ('maroiu', 'alex', 'alex@mail.com', 'pass'),
    ('maroiu','anrei', 'andrei@mail.com','pass'),
    ('micu','raluca','raluca@mail.com','try123');

insert into cursuri(cod_disciplina, nume_disciplina, an, credite) values
    (111, 'Electronica Digitala', 'II', 6),
    (112, 'Programare Orientata pe Obiect', 'II', 5),
    (113, 'Elemente de Grafica pe Calculator', 'II', 4),
    (114, 'Programarea Algoritmilor', 'II', 3),
    (115, 'Programare Logica si Functionala', 'II', 2);

insert into note(cod_disciplina, nume_disciplina, nota, situatie, departament) values
    (111, 'Electronica Digitala', 7, 'Promovat', 'Tehnologia Informatiei'),
    (112, 'Programare Orientata pe Obiect', 10, 'Promovat', 'Tehnologia Informatiei'),
    (113, 'Elemente de Grafica pe Calculator', 4, 'Nepromovat', 'Tehnologia Informatiei'),
    (114, 'Programarea Algoritmilor', 8, 'Promovat', 'Tehnologia Informatiei'),
    (115, 'Programare Logica si Functionala', 10, 'Promovat', 'Tehnologia Informatiei');
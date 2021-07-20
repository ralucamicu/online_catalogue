create table studenti(
    id integer auto_increment primary key,
    nume varchar(50),
    prenume varchar(50),
    email varchar(50),
    parola varchar(50)
);

create table cursuri(
    id integer auto_increment,
    cod_disciplina varchar(50),
    nume_disciplina varchar(50),
    an varchar(50),
    credite integer(50),
    primary key(id,cod_disciplina)
);

create table note(
    Id integer auto_increment,
    cod_disciplina integer references cursuri(cod_disciplina),
    cod_student integer references studenti(id),
    nota integer(50),
    situatie varchar(50),
    departament varchar(50),
    primary key(Id)
);

create table examene(
    id integer auto_increment,
    cod_disciplina varchar(50),
    nume_disciplina varchar(50),
    data varchar(50),
    ora varchar(50),
    primary key(cod_disciplina)
);
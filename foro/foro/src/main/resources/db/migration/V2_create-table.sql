create table respuestas(
    id bigint not null auto_increment,
    mensaje varchar(100) not null,
    topico varchar(100) not null,
    fechaCreacion varchar(100) not null,
    autor varchar(100) not null,
    solucion varchar(100) not null,

    primary key(id),
    foreign key(topico),
    foreign key(autor)
):
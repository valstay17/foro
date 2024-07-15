create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    correoElectronico varchar(100) not null,
    contrasena varchar(100) not null,
    perfiles varchar(100) not null,

    primary key(id),
    foreign key(perfiles)
):
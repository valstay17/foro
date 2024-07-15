create table topico(
  id bigint not null auto_increment,
  titulo varchar(100) not null,
  mensaje varchar(100) not null,
  fechaCreacion varchar(100) not null,
  status varchar(100) not null,
  autor varchar(100) not null,
  curso varchar(100) not null,
  respuestas varchar(100) not null,

  primary key (id),
  foreign key(autor),
  foreign key(curso),
  foreign key(respuestas)
);
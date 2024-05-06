create table cliente
(
    id             serial
        constraint cliente_pk
            primary key,
    nombres        varchar              not null,
    direccion      varchar              not null,
    telefono       varchar              not null,
    contrasena     varchar              not null,
    estado         boolean default true not null,
    genero         varchar,
    edad           integer,
    identificacion varchar,
    clienteid      bigint
        constraint cliente_pk_2
            unique,
    tipo_cliente   varchar default 'CLIENTE':: character varying not null
);



create table cuenta
(
    id      serial
        constraint cuenta_pk
            primary key,
    numero  varchar              not null
        constraint cuenta_pk_2
            unique,
    tipo    varchar              not null,
    saldo   numeric(10, 4)       not null,
    estado  boolean default true not null,
    cliente integer              not null
        constraint cuenta_cliente_id_fk
            references cliente
);



create table movimiento
(
    id               serial
        constraint movimiento_pk
            primary key,
    cuenta           varchar                 not null
        constraint movimiento_cuenta_numero_fk
            references cuenta (numero),
    saldo_inicial    numeric(10, 4)          not null,
    movimiento       numeric(10, 4),
    saldo_disponible numeric(10, 4),
    fecha            timestamp default now() not null,
    estado           boolean   default true  not null
);



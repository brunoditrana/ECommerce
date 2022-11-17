create database facturacion;

use facturacion;

select *
from cliente;

SET FOREIGN_KEY_CHECKS = 0;
drop TABLE cliente;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE cliente (
  id int NOT NULL AUTO_INCREMENT,
  dni varchar(11) NOT NULL,
  nombre varchar(100) NOT NULL,
  apellido varchar(45) NOT NULL,
  fecha_nacimiento date DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into cliente
values( 1, "40444555", "Bruno","Di Trana","1998-10-03");
insert into cliente
values( 2, "28333565", "Simon","Maio","2005-01-01");
insert into cliente
values( 3, "30987456", "Lionel","Messi","1986-06-24");
insert into cliente
values( 4, "25222789", "Zulma","Lobatto","1945-09-10");
insert into cliente
values( 5, "1000100", "Diego","Armando","1986-06-22);


select *
from venta;

insert into venta
values(1, "2022-10-10", "3750", 1 );
insert into venta
values(2, "2022-10-20", "17500", 2 );
insert into venta
values(3, "2022-10-30", "5500", 3 );
insert into venta
values(4, "2022-11-02", "1000", 4 );

 update venta
 set total='17500'
  where id='2';

select *
from producto;

SET FOREIGN_KEY_CHECKS = 0;
drop TABLE producto;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE producto (
  id int NOT NULL auto_increment,
  descripcion varchar(150) NOT NULL,
  precio_compra double NOT NULL,
  precio_venta double NOT NULL,
  stock int NOT NULL,
  fecha_alta date NOT NULL,
  PRIMARY KEY (id)
);

insert into producto
values(1, "COCA-COLA", 300.0, 375.0, 200, "2020-10-07");
insert into producto
values(2, "SPRITE", 280.0, 350.0, 100, "2020-10-07");
insert into producto
values(3, "FANTA", 220.0, 270.0, 25, "2020-11-01");
insert into producto
values(4, "PASO DE LOS TOROS", 250.0, 290.0, 12, "2020-11-21");
insert into producto
values(5, "VINO TORO", 500.0, 575.0, 12, "2020-10-07");
insert into producto
values(6, "VINO ALMA MORA", 400.0, 475.0, 35, "2022-11-11");

 update producto
 set precio_venta='350'
  where id='2';

  select *
from detalle_venta;



SET FOREIGN_KEY_CHECKS = 0;
drop TABLE detalle_venta;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE detalle_venta (
    id INT NOT NULL AUTO_INCREMENT,
    detalle_id INT NOT NULL,
    cantidad INT NOT NULL,
    sub_total DOUBLE NOT NULL,
    producto_id INT,
    CONSTRAINT fk_producto_id FOREIGN KEY (producto_id)
        REFERENCES producto (id),
    venta_id INT,
    CONSTRAINT fk_venta_id FOREIGN KEY (venta_id)
        REFERENCES venta (id),
    PRIMARY KEY (id)
);

insert into detalle_venta
values(1, 99999, 10, 3750.0, 1, 1);
insert into detalle_venta
values(2, 99998, 50, 17500.0, 2, 2);

 update detalle_venta
 set venta= "50"
  where id='2';
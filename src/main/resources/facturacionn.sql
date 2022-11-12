create database facturacion;

use facturacion;

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(11) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    fecha_nacimiento DATE,
   
);


CREATE TABLE venta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_alta DATE NOT NULL,
    total DOUBLE NOT NULL,
    cliente_id int,
     constraint fk_cliente_id foreign key(cliente_id) references cliente(id)
);

CREATE TABLE detalle_venta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    detalle_id INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DOUBLE NOT NULL,
    venta_id int,
    constraint fk_venta_id foreign key(venta_id) references venta(id),
    producto_id int,
    constraint fk_producto_id foreign key(producto_id) references producto(id)
);

CREATE TABLE producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(150) NOT NULL,
    precioCompra DOUBLE NOT NULL,
    ventaCompra DOUBLE NOT NULL,
    stock INT NOT NULL,
    fecha_alta DATE NOT NULL
);

// Cliente
INSERT INTO cliente(id,dni,nombre, apellido)
VALUES( 1, 123123, "bruno", "ditrana" );

insert into cliente
values( 4, "1212122", "Matias","Gomez","1950-10-03");

insert into cliente
values( 5, "1111111", "Lionel","Gomez","1999-6-03");

//Venta
insert into venta
values(1, "2004-10-03", "1500", 1 );

insert into venta
values(2, "2020-05-08", "7500", 3 );

//Producto
insert into producto
values(1, "Coca-cola", 300.0, 375.0, 20, "2020-10-07");

insert into producto
values(2, "Vino Toro", 500.0, 575.0, 12, "2020-10-07");
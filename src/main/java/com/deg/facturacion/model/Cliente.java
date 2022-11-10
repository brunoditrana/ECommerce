package com.deg.facturacion.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue                     //Al ID lo genera la base de datos NO aca(para eso esta linea)
    private Long id;

    //MAPEO
    @Column
    private String dni;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;


}

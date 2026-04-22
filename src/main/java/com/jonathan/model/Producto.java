package com.jonathan.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity// 1.- Le dice a Spring " crea una tabla en mysql llamada producto
@Data// 2.- Le dice a lombok  "Crea los getters y setters automaticamente

public class Producto {
    @Id // 3.- Le dice a la base  de datos este es el numero de identificacion unico
    @GeneratedValue(strategy= GenerationType.IDENTITY)// 4.,- EL ID se ira incrementado automaticamente

    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;

}


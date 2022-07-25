package com.eggsfarm.cds.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Products implements Serializable {
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducts;
    
    private String nombre;
    private String descripcion;
    private Float  compra;
    private Float  venta;
    private Integer stock;
    
}

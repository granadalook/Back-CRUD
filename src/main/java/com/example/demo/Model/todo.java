package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Crud")
@Table(name = "crud")
@Data
public class todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;
    private String nota;
    private boolean completada;

    public todo(long id, String nota, boolean completada) {
        this.id = id;
        this.nota = nota;
        this.completada = completada;
    }

}

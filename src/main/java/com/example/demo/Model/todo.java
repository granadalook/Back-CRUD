package com.example.demo.Model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "Crud")
@Table(name = "crud")
@Data
public class todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)

    private long id;
    @NotBlank(message = "La  nota es requerida")
    private String nota;
    private boolean completada;

    public todo(long id, String nota, boolean completada) {
        this.id = id;
        this.nota = nota;
        this.completada = completada;
    }
}

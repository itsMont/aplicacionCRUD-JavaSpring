package com.primerApp.aplicacionCRUD.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name="Usuarios")
@ToString @EqualsAndHashCode
public class Usuario {
    @Id //Indica clave Primaria
    @Getter @Setter @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto_Increment
    private Long id;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @Column(name = "apellido")
    private String apellido;
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "password")
    private String password;
}

package com.mycompany.odontoweb.Logica;

import com.mycompany.odontoweb.Logica.Odontologo;
import com.mycompany.odontoweb.Logica.Paciente;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-12-21T22:54:35")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, String> afeccion;
    public static volatile SingularAttribute<Turno, Odontologo> odonto;
    public static volatile SingularAttribute<Turno, String> hora_turno;
    public static volatile SingularAttribute<Turno, Paciente> pacien;
    public static volatile SingularAttribute<Turno, LocalDate> fecha_turno;
    public static volatile SingularAttribute<Turno, Integer> id_turno;

}
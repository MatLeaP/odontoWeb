package com.mycompany.odontoweb.Logica;

import com.mycompany.odontoweb.Logica.Odontologo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-01-20T21:10:25")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile ListAttribute<Horario, Odontologo> odontologos;
    public static volatile SingularAttribute<Horario, String> horarioInicio;
    public static volatile SingularAttribute<Horario, String> horarioFin;
    public static volatile SingularAttribute<Horario, Long> id;

}
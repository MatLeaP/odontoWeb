package com.mycompany.odontoweb.Logica;

import com.mycompany.odontoweb.Logica.Responsable;
import com.mycompany.odontoweb.Logica.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-11-19T23:03:06")
@StaticMetamodel(Paciente.class)
public class Paciente_ extends Persona_ {

    public static volatile SingularAttribute<Paciente, Boolean> tiene_os;
    public static volatile SingularAttribute<Paciente, Responsable> responsable;
    public static volatile SingularAttribute<Paciente, String> tipo_sangre;
    public static volatile ListAttribute<Paciente, Turno> listaTurnos;

}
package com.mycompany.odontoweb.Logica;

import com.mycompany.odontoweb.Logica.Horario;
import com.mycompany.odontoweb.Logica.Turno;
import com.mycompany.odontoweb.Logica.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-11-18T20:02:32")
@StaticMetamodel(Odontologo.class)
public class Odontologo_ extends Persona_ {

    public static volatile SingularAttribute<Odontologo, Usuario> unUsuario;
    public static volatile SingularAttribute<Odontologo, String> especialidad;
    public static volatile ListAttribute<Odontologo, Turno> listaTurnos;
    public static volatile SingularAttribute<Odontologo, Horario> unHorario;

}
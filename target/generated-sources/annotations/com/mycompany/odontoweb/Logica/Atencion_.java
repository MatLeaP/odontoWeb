package com.mycompany.odontoweb.Logica;

import com.mycompany.odontoweb.Logica.Turno;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-01-20T21:10:25")
@StaticMetamodel(Atencion.class)
public class Atencion_ { 

    public static volatile SingularAttribute<Atencion, String> descripcion;
    public static volatile SingularAttribute<Atencion, Boolean> atendido;
    public static volatile SingularAttribute<Atencion, Long> id;
    public static volatile SingularAttribute<Atencion, Turno> turno;

}
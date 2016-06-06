package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-22T18:30:44")
@StaticMetamodel(Telefone.class)
public class Telefone_ { 

    public static volatile SingularAttribute<Telefone, String> numero;
    public static volatile SingularAttribute<Telefone, String> ddd;
    public static volatile SingularAttribute<Telefone, Usuario> usuario;
    public static volatile SingularAttribute<Telefone, Integer> id;
    public static volatile SingularAttribute<Telefone, String> codigoPais;

}
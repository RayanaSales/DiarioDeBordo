package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-22T18:30:44")
@StaticMetamodel(Profissao.class)
public class Profissao_ { 

    public static volatile SingularAttribute<Profissao, Integer> experiencia_anos;
    public static volatile SingularAttribute<Profissao, String> nome;
    public static volatile SingularAttribute<Profissao, Usuario> usuario;
    public static volatile SingularAttribute<Profissao, Integer> id;
    public static volatile SingularAttribute<Profissao, String> empresa;

}
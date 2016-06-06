package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Capitulo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-22T18:30:44")
@StaticMetamodel(Arquivo.class)
public class Arquivo_ { 

    public static volatile ListAttribute<Arquivo, Capitulo> capitulos;
    public static volatile SingularAttribute<Arquivo, String> tipo;
    public static volatile SingularAttribute<Arquivo, String> conteudo;
    public static volatile SingularAttribute<Arquivo, String> descricao;

}
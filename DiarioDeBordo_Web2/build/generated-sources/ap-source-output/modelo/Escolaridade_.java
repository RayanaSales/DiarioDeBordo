package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-22T18:30:44")
@StaticMetamodel(Escolaridade.class)
public class Escolaridade_ { 

    public static volatile SingularAttribute<Escolaridade, String> nomeEscola;
    public static volatile SingularAttribute<Escolaridade, Usuario> usuario;
    public static volatile SingularAttribute<Escolaridade, Integer> id;
    public static volatile SingularAttribute<Escolaridade, String> nivelFormacao;
    public static volatile SingularAttribute<Escolaridade, Integer> tempoGastoNaFormacao;

}
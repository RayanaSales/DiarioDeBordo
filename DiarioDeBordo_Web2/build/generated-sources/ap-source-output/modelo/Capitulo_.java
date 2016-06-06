package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Arquivo;
import modelo.Localizacao;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-22T18:30:44")
@StaticMetamodel(Capitulo.class)
public class Capitulo_ { 

    public static volatile SingularAttribute<Capitulo, Localizacao> localizacao;
    public static volatile SingularAttribute<Capitulo, Usuario> usuario_id;
    public static volatile SingularAttribute<Capitulo, String> DIRETORIO_CAPITULO;
    public static volatile ListAttribute<Capitulo, Arquivo> arquivos;
    public static volatile SingularAttribute<Capitulo, Date> inicio;
    public static volatile SingularAttribute<Capitulo, String> nome;
    public static volatile SingularAttribute<Capitulo, String> fotoCapa;
    public static volatile SingularAttribute<Capitulo, Date> fim;
    public static volatile SingularAttribute<Capitulo, Integer> id;
    public static volatile SingularAttribute<Capitulo, String> descricao;

}
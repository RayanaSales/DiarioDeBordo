package bancoDeDados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoJPA
{
    public ConexaoJPA()
    {
        
    }
    public static EntityManager getEM()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DiarioDeBordo");
        return factory.createEntityManager();
    }
}

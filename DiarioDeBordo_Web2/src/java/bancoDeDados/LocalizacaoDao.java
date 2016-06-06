package bancoDeDados;

import static bancoDeDados.ConexaoJPA.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Capitulo;
import modelo.Localizacao;

public class LocalizacaoDao
{
    public boolean inserir(Localizacao localizacao)
    {
        EntityManager em = getEM();
        boolean sucesso = false;
        try
        {
            em.getTransaction().begin();
            em.persist(localizacao);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e)
        {
            throw new IllegalStateException(e);       
          
        } 
        finally
        {
            em.close();
        }
        return sucesso;
    }
    
     public List<Localizacao> listarLocais()
    {
        List<Localizacao> arquivos = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from Localizacao c");
            arquivos = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return arquivos;
    }
    
    public Localizacao buscarLocal(int id)
    {
        EntityManager em = ConexaoJPA.getEM();
        Localizacao local = (Localizacao) em.find(Localizacao.class, id);
        return local;
    }
}

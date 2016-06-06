package bancoDeDados;
import static bancoDeDados.ConexaoJPA.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Arquivo;

public class ArquivoDao
{
    public boolean inserir(Arquivo arquivo)
    {
        EntityManager em = getEM();
        boolean sucesso = false;
        try
        {
            em.getTransaction().begin();
            em.persist(arquivo);
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
    
    public boolean remover(String id)
    {
         boolean sucesso = false;
        try
        {
            EntityManager em = getEM();
            em.getTransaction().begin();
            Arquivo arquivo = (Arquivo) em.find(Arquivo.class, id); //NAO PODE BUSCAR COM O METODO, DA PAU. (ELA ACHA QUE N DEATACHOU)
            em.remove(arquivo);
            em.getTransaction().commit();
            em.close();

            sucesso = true;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return sucesso;
    }
    
    public boolean alterar(Arquivo arquivoNovo, String idArquivoAntigo) //o obj usuario ja tem que vim alterado
    { //n pode mudar a pk
       EntityManager em = ConexaoJPA.getEM();
        boolean sucesso = false;
        try
        {
            em.getTransaction().begin();
            em.merge(arquivoNovo);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e)
        {
            em.getTransaction().rollback();
        } finally
        {
            em.close();
        }
        return sucesso;
    }
    
    public List<Arquivo> listarArquivos()
    {
        List<Arquivo> arquivos = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from Arquivo c");
            arquivos = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return arquivos;
    }
    
    public Arquivo buscarArquivo(String id)
    {
        EntityManager em = ConexaoJPA.getEM();
        Arquivo arquivo = (Arquivo) em.find(Arquivo.class, id);       
        return arquivo;
    }
    
    public Arquivo buscarFotoTemporaria()
    {
        List<Arquivo> arquivos = listarArquivos();
        Arquivo arquivo = null;        
       
        for (int i = 0; i < arquivos.size(); i++)
        {            
            if(arquivos.get(i).getTipo().equals("foto null"))
            {
                arquivo = arquivos.get(i);
                break;
            }      
        } 

        return arquivo;
    }
    
    public Arquivo buscarFotoDaCapa()
    {
        List<Arquivo> arquivos = listarArquivos();
        Arquivo arquivo = null;        
       
        for (int i = 0; i < arquivos.size(); i++)
        {            
            if(arquivos.get(i).getTipo().equals("foto capa"))
            {
                arquivo = arquivos.get(i);
                break;
            }      
        } 

        return arquivo;
    }
}

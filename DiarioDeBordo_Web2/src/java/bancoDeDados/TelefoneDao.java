package bancoDeDados;

import static bancoDeDados.ConexaoJPA.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Telefone;

public class TelefoneDao
{
   public boolean inserir(Telefone telefone)
    {

        EntityManager em = getEM();
        boolean sucesso = false;
        try
        {
            em.getTransaction().begin();
            em.persist(telefone);
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
   
   public boolean remover(int id)
    {

        boolean sucesso = false;
        try
        {
            EntityManager em = getEM();
            em.getTransaction().begin();
            Telefone usuario = (Telefone) em.find(Telefone.class, id); //NAO PODE BUSCAR COM O METODO, DA PAU. (ELA ACHA QUE N DEATACHOU)
            em.remove(usuario);
            em.getTransaction().commit();
            em.close();

            sucesso = true;
        } catch (Exception e)
        {
            throw new IllegalStateException(e);
        }
        return sucesso;
    }
   
    public Telefone buscarTelefone(int id)
    {
        EntityManager em = ConexaoJPA.getEM();
        Telefone telefone = (Telefone) em.find(Telefone.class, id);       
        return telefone;
    }
  
     public List<Telefone> listarTelefones()
    {

        List<Telefone> telefone = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from Telefone c");
            telefone = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return telefone;
    }  
    
   public boolean alterar(Telefone telefoneNovo, int idTelefoneAntigo) //o obj usuario ja tem que vim alterado
    {        
        EntityManager em = ConexaoJPA.getEM();
        boolean sucesso = false;
        try
        {
            Telefone u = em.find(Telefone.class, idTelefoneAntigo);
            em.getTransaction().begin(); 
            u.setCodigoPais(telefoneNovo.getCodigoPais());
            u.setDdd(telefoneNovo.getDdd());
            u.setNumero(telefoneNovo.getNumero());
            u.setUsuario(telefoneNovo.getUsuario());
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
           // em.getTransaction().rollback();
        } finally
        {
            em.close();
        }
        return sucesso;

    }
}

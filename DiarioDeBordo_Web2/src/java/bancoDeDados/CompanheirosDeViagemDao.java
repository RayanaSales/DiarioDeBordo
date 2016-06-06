package bancoDeDados;

import static bancoDeDados.ConexaoJPA.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.CompanheirosDeViagem;

public class CompanheirosDeViagemDao
{

    public boolean inserir(CompanheirosDeViagem telefone)
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
            e.printStackTrace();
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
            CompanheirosDeViagem usuario = (CompanheirosDeViagem) em.find(CompanheirosDeViagem.class, id); //NAO PODE BUSCAR COM O METODO, DA PAU. (ELA ACHA QUE N DEATACHOU)
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

    public List<CompanheirosDeViagem> listarCompanheirosDeViagem()
    {

        List<CompanheirosDeViagem> companheirosDeViagem = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from CompanheirosDeViagem c");
            companheirosDeViagem = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return companheirosDeViagem;
    }

    public boolean alterar(CompanheirosDeViagem usuarioNovo, int idUsuarioAntigo) //o obj usuario ja tem que vim alterado
    {
        EntityManager em = ConexaoJPA.getEM();
        boolean sucesso = false;
        try
        {
            CompanheirosDeViagem u = em.find(CompanheirosDeViagem.class, idUsuarioAntigo);
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
            // em.getTransaction().rollback();
        } finally
        {
            em.close();
        }
        return sucesso;

    }
}

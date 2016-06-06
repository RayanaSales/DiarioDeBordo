package bancoDeDados;

import static bancoDeDados.ConexaoJPA.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Escolaridade;

public class EscolaridadeDao
{

    public boolean inserir(Escolaridade escolaridade)
    {
        EntityManager em = getEM();
        boolean sucesso = false;
        try
        {
            em.getTransaction().begin();
            em.persist(escolaridade);
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
            Escolaridade usuario = (Escolaridade) em.find(Escolaridade.class, id); //NAO PODE BUSCAR COM O METODO, DA PAU. (ELA ACHA QUE N DEATACHOU)
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

    public List<Escolaridade> listarEscolaridade()
    {

        List<Escolaridade> escolaridade = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from Escolaridade c");
            escolaridade = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return escolaridade;
    }

    public boolean alterar(Escolaridade usuarioNovo, int idUsuarioAntigo) //o obj usuario ja tem que vim alterado
    {
        EntityManager em = ConexaoJPA.getEM();
        boolean sucesso = false;
        try
        {
            Escolaridade u = em.find(Escolaridade.class, idUsuarioAntigo);
            em.getTransaction().begin();
            u.setNivelFormacao(usuarioNovo.getNivelFormacao());
            u.setNomeEscola(usuarioNovo.getNomeEscola());
            u.setTempoGastoNaFormacao(usuarioNovo.getTempoGastoNaFormacao());
            u.setUsuario(usuarioNovo.getUsuario());
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

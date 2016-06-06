package bancoDeDados;

import static bancoDeDados.ConexaoJPA.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.MeEncontre_OutrasRedes;

public class MeEncontre_OutrasRedesDao
{

    public boolean inserir(MeEncontre_OutrasRedes escolaridade)
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
            MeEncontre_OutrasRedes usuario = (MeEncontre_OutrasRedes) em.find(MeEncontre_OutrasRedes.class, id); //NAO PODE BUSCAR COM O METODO, DA PAU. (ELA ACHA QUE N DEATACHOU)
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
   

    public List<MeEncontre_OutrasRedes> listarMeEncontre_OutrasRedes()
    {

        List<MeEncontre_OutrasRedes> meEncontre_OutrasRedes = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from MeEncontre_OutrasRedes c");
            meEncontre_OutrasRedes = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return meEncontre_OutrasRedes;
    }

    public boolean alterar(MeEncontre_OutrasRedes usuarioNovo, int idUsuarioAntigo) //o obj usuario ja tem que vim alterado
    {
        EntityManager em = ConexaoJPA.getEM();
        boolean sucesso = false;
        try
        {
            MeEncontre_OutrasRedes u = em.find(MeEncontre_OutrasRedes.class, idUsuarioAntigo);
            em.getTransaction().begin();
            u.setFacebook(usuarioNovo.getFacebook());
            u.setTwitter(usuarioNovo.getTwitter());
            u.setInstagram(usuarioNovo.getInstagram());
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

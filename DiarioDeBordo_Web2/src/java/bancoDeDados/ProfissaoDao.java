package bancoDeDados;

import static bancoDeDados.ConexaoJPA.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Profissao;

public class ProfissaoDao
{
    public boolean inserir(Profissao escolaridade)
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
            Profissao usuario = (Profissao) em.find(Profissao.class, id); //NAO PODE BUSCAR COM O METODO, DA PAU. (ELA ACHA QUE N DEATACHOU)
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
   
   
       public List<Profissao> listarProfissao()
    {

        List<Profissao> profissao = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from Profissao c");
            profissao = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return profissao;
    }  
  
    
   public boolean alterar(Profissao usuarioNovo, int idUsuarioAntigo) //o obj usuario ja tem que vim alterado
    {        
        EntityManager em = ConexaoJPA.getEM();
        boolean sucesso = false;
        try
        {
            Profissao u = em.find(Profissao.class, idUsuarioAntigo);
            em.getTransaction().begin(); 
            u.setNome(usuarioNovo.getNome());
            u.setExperiencia(usuarioNovo.getExperiencia());
            u.setEmpresa(usuarioNovo.getEmpresa());
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

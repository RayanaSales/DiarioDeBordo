package bancoDeDados;

import static bancoDeDados.ConexaoJPA.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Usuario;

public class UsuarioDao
{
    public UsuarioDao()
    {

    }

    public boolean inserir(Usuario usuario)
    {

        EntityManager em = getEM();
        boolean sucesso = false;
        try
        {
            em.getTransaction().begin();
            em.persist(usuario);
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

    public boolean remover(String id)
    {

        boolean sucesso = false;
        try
        {
            EntityManager em = getEM();
            em.getTransaction().begin();
            Usuario usuario = (Usuario) em.find(Usuario.class, id); //NAO PODE BUSCAR COM O METODO, DA PAU. (ELA ACHA QUE N DEATACHOU)
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

    public boolean alterar(Usuario usuarioNovo, String idUsuarioAntigo) //o obj usuario ja tem que vim alterado
    {
        
        EntityManager em = ConexaoJPA.getEM();
        boolean sucesso = false;
        try
        {
            Usuario u = em.find(Usuario.class, idUsuarioAntigo);
            em.getTransaction().begin();    
            u.setEmail(usuarioNovo.getEmail());
            u.setNome(usuarioNovo.getNome());
            u.setSenha(usuarioNovo.getSenha());
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

    public List<Usuario> listarUsuarios()
    {

        List<Usuario> usuarios = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from Usuario c");
            usuarios = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario buscarUsuario(String id)
    {
        EntityManager em = ConexaoJPA.getEM();
        Usuario usuario = (Usuario) em.find(Usuario.class, id);       
        return usuario;
    }

}

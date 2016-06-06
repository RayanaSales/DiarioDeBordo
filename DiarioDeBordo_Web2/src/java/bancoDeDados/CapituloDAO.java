package bancoDeDados;

import static bancoDeDados.ConexaoJPA.getEM;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Capitulo;

public class CapituloDAO
{

    public CapituloDAO()
    {

    }

    public boolean inserir(Capitulo capitulo)
    {
        EntityManager em = getEM();
        boolean sucesso = false;
        try
        {
            em.getTransaction().begin();
            em.merge(capitulo);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
            //em.getTransaction().rollback();
            //e.printStackTrace();
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
            Capitulo capitulo = (Capitulo) em.find(Capitulo.class, id); //NAO PODE BUSCAR COM O METODO, DA PAU. (ELA ACHA QUE N DEATACHOU)
            em.remove(capitulo);
            em.getTransaction().commit();
            em.close();

            sucesso = true;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return sucesso;
    }

    public boolean alterar(Capitulo capituloNovo)
    {
        EntityManager em = ConexaoJPA.getEM();
        boolean sucesso = false;
        try
        {
            em.getTransaction().begin();
            em.merge(capituloNovo);
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

    public List<Capitulo> listarCapitulo()
    {

        List<Capitulo> capitulos = null;
        EntityManager em = ConexaoJPA.getEM();

        try
        {
            Query query = em.createQuery("Select c from Capitulo c");
            capitulos = query.getResultList();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return capitulos;
    }

    public Capitulo buscarCapitulo(int id)
    {
        EntityManager em = ConexaoJPA.getEM();
        Capitulo capitulo = (Capitulo) em.find(Capitulo.class, id);
        return capitulo;
    }

    public List<Capitulo> buscarCapitulosUsuario(String id)
    {
        List<Capitulo> capitulosTotais = listarCapitulo();
        List<Capitulo> capitulosUsuario = new ArrayList<Capitulo>();
        if (capitulosTotais != null)
        {
            for (int i = 0; i < capitulosTotais.size(); i++)
            {
                if (capitulosTotais.get(i).getUsuario_id().getEmail().equals(id))
                {
                    capitulosUsuario.add(capitulosTotais.get(i));
                }

            }
        }

        return capitulosUsuario;
    }

}

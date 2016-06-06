package mini_testes;

import bancoDeDados.CapituloDAO;
import bancoDeDados.UsuarioDao;
import modelo.Capitulo;
import modelo.Localizacao;
import modelo.Usuario;

public class TesteCapituloLocal
{
    public static void main(String[] args) throws Exception
    {
        Usuario u = new Usuario("Harry", "hp@hot.com", "123");
        UsuarioDao ud = new UsuarioDao();
        boolean inseriu = ud.inserir(u);
        
        Localizacao l = new Localizacao("Brasil", "Pe", "Recife");
        Capitulo capitulo = new Capitulo("capitulo1", "capitulo1", new java.sql.Date(1L), new java.sql.Date(1L), u, "", l);
        
        CapituloDAO cd = new CapituloDAO();
        inseriu = cd.inserir(capitulo);
        System.out.print("inseriu: " + inseriu);
    }
}

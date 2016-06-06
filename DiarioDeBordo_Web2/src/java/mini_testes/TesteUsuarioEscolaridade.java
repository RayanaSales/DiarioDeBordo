package mini_testes;

import bancoDeDados.EscolaridadeDao;
import bancoDeDados.UsuarioDao;
import modelo.Escolaridade;
import modelo.Usuario;

public class TesteUsuarioEscolaridade
{
     public static void main(String[] args)
    {        
        Usuario u = new Usuario("R", "avee2@hot.com", "123");
        UsuarioDao ud = new UsuarioDao();
        boolean inseriu = ud.inserir(u);  
        System.out.println(inseriu);         
        Escolaridade e = new Escolaridade("agnes", "nivel medio", 3, u);
        EscolaridadeDao ed = new EscolaridadeDao();
        boolean inseriu2 = ed.inserir(e);
        System.out.println(inseriu2);        
    }
}

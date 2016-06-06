package mini_testes;

import bancoDeDados.CompanheirosDeViagemDao;
import bancoDeDados.EscolaridadeDao;
import bancoDeDados.UsuarioDao;
import modelo.CompanheirosDeViagem;
import modelo.Escolaridade;
import modelo.Usuario;

public class TesteUsuarioCompanheirosDeViagem
{

    public static void main(String[] args)
    {
        Usuario u = new Usuario("Paulo", "hahdhjsa@hot.com", "123");
        UsuarioDao ud = new UsuarioDao();
        boolean inseriu = ud.inserir(u);
        System.out.println(inseriu);
//        Escolaridade e = new Escolaridade("agnes", "nivel medio", 3, u);
//        EscolaridadeDao ed = new EscolaridadeDao();
//        boolean inseriu2 = ed.inserir(e);
//        System.out.println(inseriu2);  
        CompanheirosDeViagem cv = new CompanheirosDeViagem(4, 1, 3, true, u);
        CompanheirosDeViagemDao cvd = new CompanheirosDeViagemDao();
        boolean inseriu2 = cvd.inserir(cv);
        System.out.println(inseriu2);
    }
}

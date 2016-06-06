package mini_testes;

import bancoDeDados.ProfissaoDao;
import bancoDeDados.UsuarioDao;
import modelo.Profissao;
import modelo.Usuario;

public class TesteUsuarioProfissao
{

    public static void main(String[] args)
    {
        Usuario u = new Usuario("Rayana", "rayana@hotmail.com", "123");
        UsuarioDao ud = new UsuarioDao();
        boolean inseriu = ud.inserir(u);
        System.out.println(inseriu);
        Profissao e = new Profissao("dev", "google", 20, u);
        ProfissaoDao ed = new ProfissaoDao();
        boolean inseriu2 = ed.inserir(e);
        System.out.println(inseriu2);
    }
}

package mini_testes;

import bancoDeDados.MeEncontre_OutrasRedesDao;
import bancoDeDados.ProfissaoDao;
import bancoDeDados.UsuarioDao;
import modelo.MeEncontre_OutrasRedes;
import modelo.Usuario;

public class TesteUsuarioMeEncontre
{
    public static void main(String[] args)
    {        
        Usuario u = new Usuario("Rayana", "rayana@hotmail.com", "123");
        UsuarioDao ud = new UsuarioDao();
        boolean inseriu = ud.inserir(u);  
        System.out.println(inseriu);         
        MeEncontre_OutrasRedes e = new MeEncontre_OutrasRedes("RaySalish", "ViintageMiisery", "RaySls", u);
        MeEncontre_OutrasRedesDao ed = new MeEncontre_OutrasRedesDao();
        boolean inseriu2 = ed.inserir(e);
        System.out.println(inseriu2);        
    }
}

package mini_testes;

import bancoDeDados.TelefoneDao;
import bancoDeDados.UsuarioDao;
import modelo.Telefone;
import modelo.Usuario;

public class TesteUsuarioTelefone
{   
    public static void main(String[] args) throws Exception
    {        
        Usuario u = new Usuario("Dean wr", "afsss@yah.com", "123");
        UsuarioDao ud = new UsuarioDao();
        boolean inseriu = ud.inserir(u);        
        
        Telefone t = new Telefone("55", "81", "923121212", u);    
        TelefoneDao td = new TelefoneDao();
        td.inserir(t); 
        System.out.print("Sucesso no telefone: " + inseriu);
        System.out.print("Sucesso no telefone: " + inseriu);
        System.out.print("Sucesso no telefone: " + inseriu);
        System.out.print("Sucesso no telefone: " + inseriu);
        
    }
}

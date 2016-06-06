package mini_testes;

import bancoDeDados.ArquivoDao;
import bancoDeDados.CapituloDAO;
import bancoDeDados.UsuarioDao;
import java.util.Calendar;
import modelo.Arquivo;
import modelo.Capitulo;
import modelo.Usuario;

public class TesteArquivoCapitulo
{
    public static void main(String[] args) {
        Arquivo arquivo = new Arquivo();
        Capitulo capitulo;
        UsuarioDao daoUsuario = new UsuarioDao();
        Usuario usuario = daoUsuario.buscarUsuario("nat@hotmail.com");
        capitulo = new Capitulo("capitulo1", "capitulo1", new java.sql.Date(1L),  new java.sql.Date(1L),usuario, "", null);
        arquivo = new Arquivo("arquivo3", "arquivo3", "arquivo3");
        
        ArquivoDao arquivoDao = new ArquivoDao();
        //arquivoDao.inserir(arquivo);
        
        // 0. cria arquivo
        // 1. insere arquivo no banco se ele já não estiver.
        //1.1 busca o capítulo
        // 2. adiciona o arquivo no capitulo, com o setArquivos().
        //3. adiciona o capitulo no banco, chamando o alterar.
        
        //0. Arquivo arquivo = new Arquivo("arquivo3", "arquivo3", "arquivo3");
        //1. arquivoDao.inserir(arquivo);
        //1.1. Capitulo capitulo2 = capituloDAO.buscarCapitulo(16);
        //2. capitulo2.setArquivos(arquivo);
        //3. capituloDAO.alterar(capitulo2);
        
        CapituloDAO capituloDAO = new CapituloDAO();
       // capitulo.setArquivos(arquivo);
       // capituloDAO.inserir(capitulo);
        
    /*    Capitulo capitulo2 = capituloDAO.buscarCapitulo(16);
        capitulo2.setArquivos(arquivo);
        capituloDAO.alterar(capitulo2); */
        
        
        Arquivo arquivo10 = new Arquivo("Arquivo12", "foto2", "aaaadaaah");
        arquivoDao.inserir(arquivo10);
        Capitulo capitulo4 = capituloDAO.buscarCapitulo(2);
        capitulo4.setArquivos(arquivo);
        capituloDAO.alterar(capitulo4);
        
        //System.out.println("DESCRICAO: " + capitulo2.getDescricao());
        //arquivo = capitulo2.getArquivos(0);
        //System.out.println("ARQUIVO: " + arquivo.getTipo());
        
    }
}

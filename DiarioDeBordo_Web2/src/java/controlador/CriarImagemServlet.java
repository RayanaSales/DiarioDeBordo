package controlador;

import bancoDeDados.ArquivoDao;
import bancoDeDados.CapituloDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Arquivo;
import modelo.Capitulo;

/*
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
 */
public class CriarImagemServlet extends HttpServlet
{

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;

        if (session != null)
        {
            PrintWriter out = response.getWriter();
            ArquivoDao arDao = new ArquivoDao();
            CapituloDAO capDao = new CapituloDAO();
            String nomeFoto = "";
            Arquivo arquivo = null;

            Capitulo capituloAtual = (Capitulo) session.getAttribute("capituloDaVez");

            if (request.getParameter("capaAlbum") == null)
            {
                nomeFoto = request.getParameter("nome") + ".jpg";//para eu achar a foto que vou alterar  
                arquivo = new Arquivo(request.getParameter("descricao"), "foto null", nomeFoto); //salvo o nome da foto, no conteudo, dps no armazena img, altero isso

            } else if (request.getParameter("capaAlbum").equals("capa"))
            {
                nomeFoto = "fotoCapa" + ".jpg"; //para eu achar a foto que vou alterar  
                arquivo = new Arquivo(request.getParameter("descricao"), "foto capa", nomeFoto);
            }

            boolean inseriu = arDao.inserir(arquivo);
            capituloAtual.setArquivos(arquivo);
            capDao.alterar(capituloAtual);

            rd = request.getRequestDispatcher("/WEB-INF/Inserir/inserirFoto2.jsp");
            rd.forward(request, response);
        } else
        {
            rd = request.getRequestDispatcher("/MainServlet");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}

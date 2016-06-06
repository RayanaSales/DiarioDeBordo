package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirecionador extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher rd = null;        
        String acao = request.getParameter("acao");

        if (acao.equals("cadastrar"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Cadastrar/cadastrar.jsp");
        }
        else if (acao.equals("editarDadosUsuario"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Editar/editarUsuario.jsp");
        }
        else if (acao.equals("login"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Login/login.jsp");
        }
        else if (acao.equals("editarFoto"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Editar/editarFoto.jsp");
        }  
        else if (acao.equals("editarFotoPerfil"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Editar/editarFotoPerfil.jsp");
        }  
         else if (acao.equals("inserirAudio"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Inserir/inserirAudio.jsp");
        }  
        else if (acao.equals("linhaDoTempo"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Perfil/linhaDoTempo.jsp");
        }
        else if (acao.equals("perfil"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfil.jsp");
        }
        else if (acao.equals("perfilComInformacoesDoUsuario"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfilInfoUsuario.jsp");
        } 
        else if (acao.equals("criarCapitulo"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Inserir/criarCapitulo.jsp");
        }
        else if (acao.equals("visualizarFoto"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Abrir/visualizarFoto.jsp");
        }
        else if (acao.equals("editarCapitulo"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Editar/editarCapitulo.jsp");
        }
        else if (acao.equals("criarPost"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Postagem/criarPost.jsp");
        }
        else if (acao.equals("excluirCapitulo"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Excluir/excluirCapitulo.jsp");
        }
        else if (acao.equals("inserirFoto"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Inserir/inserirFoto.jsp");
        }
        else if (acao.equals("inserirVideo"))
        {
            rd = request.getRequestDispatcher("/WEB-INF/Inserir/inserirVideo.jsp");
        }
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}

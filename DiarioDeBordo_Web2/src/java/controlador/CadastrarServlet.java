package controlador;


import bancoDeDados.UsuarioDao;
import modelo.Usuario;
import modelo.Autenticador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarServlet extends HttpServlet
{    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        GerenciadorDeDiretorios criaPasta = new GerenciadorDeDiretorios(request.getRealPath("/"));
        PrintWriter out = response.getWriter();
        
        UsuarioDao usuarioJPA = new UsuarioDao();       
        RequestDispatcher rd = null;
        String email = request.getParameter("email");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        Usuario objAuxiliarUsuario = new Usuario(nome, email, senha);        

        Autenticador autenticar = new Autenticador();
        boolean jaTemNoBanco = autenticar.autenticarCadastro(email);

        if (jaTemNoBanco == false)
        {
            usuarioJPA.inserir(objAuxiliarUsuario);
            criaPasta.criaPastaUsuario(nome); // criar a pasta do usuário
            rd = request.getRequestDispatcher("/WEB-INF/Login/login.jsp");
        }
        else rd = request.getRequestDispatcher("/WEB-INF/Cadastrar/cadastrar.jsp");
        
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}

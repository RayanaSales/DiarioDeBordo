package controlador;

import bancoDeDados.UsuarioDao;
import modelo.Usuario;
import modelo.Autenticador;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
    
    
    public LoginServlet()
    {
        super();
    }
    
    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
       HttpSession session = request.getSession(false);
       
        RequestDispatcher rd = null;
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        UsuarioDao usuarioJPA = new UsuarioDao();
        
        if(session == null) //conferindo pelo cookie, se o user ja me visitou antes (se n, mvai login normal)
        {
            Autenticador autenticar = new Autenticador();
            boolean temNoBanco = autenticar.autenticarLogin(email, senha);
            
            if(temNoBanco == true)
            {
                session = request.getSession(); //SEMPRE CRIA UMA NOVA SESSAO
                Usuario objAuxiliarUsuario = usuarioJPA.buscarUsuario(email);//pega todas as info do obj
                
                System.out.println("Nome objAuxiliarUsuario : " + objAuxiliarUsuario.getNome());
                
                session.setAttribute("usuario", objAuxiliarUsuario);     
                session.setAttribute("usuarioNome", objAuxiliarUsuario.getNome()); //eu n conseguia acessar o nome pelo atributo usuario, entao criei esse
                session.setAttribute("usuarioSenha", objAuxiliarUsuario.getSenha());
                session.setAttribute("usuarioEmail", objAuxiliarUsuario.getEmail());
                
               
                rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfil.jsp");
            }
            else if(temNoBanco == false)
            {                
                request.setAttribute("erro", "SenhaOuLoginErrado");
                request.setAttribute("email", email);

                rd = request.getRequestDispatcher("/WEB-INF/Login/login.jsp");
            }            
        }
        else
        {            
            rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfil.jsp");
        }
        rd.forward(request, response);
    }
    
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}

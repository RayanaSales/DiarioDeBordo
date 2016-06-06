package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet 
{
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession(false); //verifica se ha uma sessao ou n
        RequestDispatcher rd = null;
        
        if (session == null) //se o cara nunca me visitou antes (vejo pelo id do cookie)
        { //va fazer login
            rd = request.getRequestDispatcher("/WEB-INF/Login/login.jsp");
        }
        else
        {  //va para o home jsp
           rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfil.jsp");
        }
        rd.forward(request, response);
    }
   
    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession(false); //verifica se ha uma sessao ou n
        RequestDispatcher rd = null;
        
        if (session == null) //se o cara nunca me visitou antes (vejo pelo id do cookie)
        { //va fazer login
            rd = request.getRequestDispatcher("/WEB-INF/Login/login.jsp");
        }
        else
        {  //va para o home jsp
           rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfil.jsp");
        }
        rd.forward(request, response);
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

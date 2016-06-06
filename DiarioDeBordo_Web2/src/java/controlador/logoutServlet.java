package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutServlet extends HttpServlet
{
    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession(false);
        
        if(session != null)
        {
            session.invalidate();
           // out.println("sessão encerrada.");            
        }         
            
        rd = request.getRequestDispatcher("/MainServlet");
        rd.forward(request, response);
    }
   
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}

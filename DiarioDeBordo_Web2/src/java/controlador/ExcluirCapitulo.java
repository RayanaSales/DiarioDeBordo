package controlador;

import bancoDeDados.CapituloDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Capitulo;

public class ExcluirCapitulo extends HttpServlet
{

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession(false);

        if (session != null)
        {
            Capitulo cap = (Capitulo) session.getAttribute("capituloDaVez");
            CapituloDAO capDao = new CapituloDAO();
            
            boolean excluiu = capDao.remover(cap.getId());
            System.err.println(" EEXCUIU CAPITULO " +excluiu);           
            rd = request.getRequestDispatcher("/MainServlet");     
        } 
        else
        {
            rd = request.getRequestDispatcher("/MainServlet");
            
        }
        rd.forward(request, response);
    }
    
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}

package controlador;

import bancoDeDados.CapituloDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Capitulo;

public class AlteraCapitulo extends HttpServlet
{

    @Override
    protected synchronized  void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;

        if (session != null)
        {
            PrintWriter out = response.getWriter();
            String capituloDaVez = request.getParameter("nome");
            Capitulo teste = null;

            CapituloDAO persistencia = new CapituloDAO();
            List<Capitulo> listaDeCapitulos = persistencia.listarCapitulo();

            for (int a = 0; a < listaDeCapitulos.size(); a++)
            {
                if (listaDeCapitulos.get(a).getNome().equals(capituloDaVez))
                {
                    session.setAttribute("capituloDaVez", listaDeCapitulos.get(a));
                    out.println("entrei!");
                    out.println(session.getAttribute("capituloDaVez"));
                    teste = (Capitulo) session.getAttribute("capituloDaVez");
                    out.println("Nome : " + teste.getNome());

                }

            }            
            rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfil.jsp");
            rd.forward(request, response);
        }
        else 
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

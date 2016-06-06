package controlador;

import bancoDeDados.CapituloDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Capitulo;
import modelo.Localizacao;

public class EditarDadosCapituloServlet extends HttpServlet
{

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;

        if (session != null)
        {
            CapituloDAO cd = new CapituloDAO();

            Capitulo capAntigo = (Capitulo) session.getAttribute("capituloDaVez");

            capAntigo.setNome(request.getParameter("nome"));
            capAntigo.setDescricao(request.getParameter("descricao"));

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String inicioStr = request.getParameter("inicio");
            String fimStr = request.getParameter("fim");
            Date inicio = null, fim = null;
            try
            {
                inicio = format.parse(inicioStr);
                fim = format.parse(fimStr);
            } catch (ParseException e)
            {
                e.printStackTrace();
            }
            capAntigo.setInicio(inicio);
            capAntigo.setFim(fim);

            Localizacao l = capAntigo.getLocalizacao();
            l.setPais(request.getParameter("pais"));
            l.setEstado(request.getParameter("cidade"));
            l.setCidade(request.getParameter("cidade"));

            capAntigo.setLocalizacao(l);
            
            boolean alterou = cd.alterar(capAntigo);

            rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfil.jsp");
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

package erro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TratamentoDeErroServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        tratarErro(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        tratarErro(request, response);
    }

    private void tratarErro(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();

        out.println("<h1>Esta página não existe, foi mal</h1>");
        out.print("<img src=\"supermario2.gif\"> ");

        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        out.println("<h1>Informações sobre o erro:</h1>");

        out.println("Código do erro:" + statusCode);
        if (servletName == null)
        {
            servletName = "Unknown";
        }
        else out.println("<br>Nome do servlet que gerou o erro:" + servletName);
        
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null)
        {
            requestUri = "Unknown";
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}

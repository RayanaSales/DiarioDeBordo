package controlador;

import bancoDeDados.CapituloDAO;
import bancoDeDados.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Capitulo;
import modelo.Localizacao;
import modelo.Usuario;

public class CriarCapituloServlet extends HttpServlet
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

            String diretorioCapitulo;
            GerenciadorDeDiretorios criaPasta = new GerenciadorDeDiretorios(request.getRealPath("/"));
            Date inicio = null, fim = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);

            String inicioStr = request.getParameter("inicio");
            String fimStr = request.getParameter("fim");

        //out.print("inicioStr: " + inicioStr + " fimStr: " + fimStr);
            try
            {
                inicio = format.parse(inicioStr);
                fim = format.parse(fimStr);
            } catch (ParseException e)
            {
                e.printStackTrace();
            }

        //out.print("inicio: " + inicio + " fim: " + fim);
            String emailId = (String) session.getAttribute("usuarioEmail");

            UsuarioDao manipularUsuario = new UsuarioDao();
            Usuario usuario = manipularUsuario.buscarUsuario(emailId);

            // tem que ser antes do if, para que ele possa armazenar o diretorio desse capitulo
            diretorioCapitulo = criaPasta.criarDiretorioParaCapitulo(usuario.getNome(), request.getParameter("nome"));

            Localizacao localizacao = new Localizacao(request.getParameter("pais"), request.getParameter("estado"), request.getParameter("cidade"));
            Capitulo capitulo = new Capitulo(request.getParameter("nome"), request.getParameter("descricao"), inicio, fim, usuario, diretorioCapitulo, localizacao);
            CapituloDAO manipular = new CapituloDAO();
            boolean inseriu = manipular.inserir(capitulo);

            if (inseriu == true)
            {
                List<Capitulo> capitulos = usuario.getCapitulos();
                capitulos.add(capitulo);
                usuario.setCapitulos(capitulos);
            }

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
    }

}

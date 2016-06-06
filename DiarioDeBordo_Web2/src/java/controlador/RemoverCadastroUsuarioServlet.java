package controlador;

import bancoDeDados.CompanheirosDeViagemDao;
import bancoDeDados.EscolaridadeDao;
import bancoDeDados.MeEncontre_OutrasRedesDao;
import bancoDeDados.ProfissaoDao;
import bancoDeDados.TelefoneDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bancoDeDados.UsuarioDao;
import java.util.List;
import modelo.CompanheirosDeViagem;
import modelo.Escolaridade;
import modelo.MeEncontre_OutrasRedes;
import modelo.Profissao;
import modelo.Telefone;
import modelo.Usuario;

public class RemoverCadastroUsuarioServlet extends HttpServlet
{

    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;

        if (session != null)
        {
            boolean removeu;
            int removeuTudo = 0;
            UsuarioDao acessa = new UsuarioDao();
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            String id = (String) session.getAttribute("usuarioEmail");

            //remove telefones            
            TelefoneDao td = new TelefoneDao();
            List<Telefone> telefones = td.listarTelefones();
            if (telefones != null)
            {
                for (Telefone telefone : telefones)
                {
                    if (telefone.getUsuario().getEmail().equals(usuarioLogado.getEmail()))
                    {
                        removeu = td.remover(telefone.getId());
                        removeuTudo++;
                    }
                }
            }

            //remover escolaridade
            EscolaridadeDao ed = new EscolaridadeDao();
            List<Escolaridade> escolaridades = ed.listarEscolaridade();
            if (escolaridades != null)
            {
                for (Escolaridade escolaridade : escolaridades)
                {
                    if (escolaridade.getUsuario().getEmail().equals(usuarioLogado.getEmail()))
                    {
                        removeu = ed.remover(escolaridade.getId());
                        removeuTudo++;
                    }
                }
            }

            //remove profissao
            ProfissaoDao pd = new ProfissaoDao();
            List<Profissao> profissoes = pd.listarProfissao();
            if (profissoes != null)
            {
                for (Profissao profissao : profissoes)
                {
                    if (profissao.getUsuario().getEmail().equals(usuarioLogado.getEmail()))
                    {
                        removeu = pd.remover(profissao.getId());
                        removeuTudo++;
                    }
                }
            }

            //remove redes sociais
            MeEncontre_OutrasRedesDao med = new MeEncontre_OutrasRedesDao();
            List<MeEncontre_OutrasRedes> outrasRedes = med.listarMeEncontre_OutrasRedes();
            if (outrasRedes != null)
            {
                for (MeEncontre_OutrasRedes rede : outrasRedes)
                {
                    if (rede.getUsuario().getEmail().equals(usuarioLogado.getEmail()))
                    {
                        removeu = med.remover(rede.getId());
                        removeuTudo++;
                    }
                }
            }

            //remove companheiros    
            CompanheirosDeViagemDao cvd = new CompanheirosDeViagemDao();
            List<CompanheirosDeViagem> companheiros = cvd.listarCompanheirosDeViagem();
            if (outrasRedes != null)
            {
                for (CompanheirosDeViagem companheiro : companheiros)
                {
                    if (companheiro.getUsuario().getEmail().equals(usuarioLogado.getEmail()))
                    {
                        removeu = cvd.remover(companheiro.getId());
                        removeuTudo++;
                    }
                }
            }
            System.out.println("removeuTudo: " + removeuTudo);
            if (removeuTudo == 5)
            {
                acessa.remover(id); //finalmente remove o usuario
                logoutServlet ls = new logoutServlet(); //faz o log out
                ls.doGet(request, response);
            } else
            {
                rd = request.getRequestDispatcher("/MainServlet");
                rd.forward(request, response);
            }

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bancoDeDados.CompanheirosDeViagemDao;
import bancoDeDados.EscolaridadeDao;
import bancoDeDados.MeEncontre_OutrasRedesDao;
import bancoDeDados.ProfissaoDao;
import bancoDeDados.TelefoneDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.CompanheirosDeViagem;
import modelo.Escolaridade;
import modelo.MeEncontre_OutrasRedes;
import modelo.Profissao;
import modelo.Telefone;
import modelo.Usuario;

/**
 *
 * @author NataliaAmancio
 */
public class SetaDadosNaSessao extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Telefone telefoneAtual = null;
        Escolaridade escolaridadeAtual = null;
        Profissao profissaoAtual = null;
        //   Localizacao localizacaoAtual = null;
        CompanheirosDeViagem companheirosDeViagemAtual = null;
        MeEncontre_OutrasRedes meEncontre_outrasRedesAtual = null;

        TelefoneDao persistenciaTelefone = new TelefoneDao();
        EscolaridadeDao persistenciaEscolariadade = new EscolaridadeDao();
        ProfissaoDao persistenciaProfissao = new ProfissaoDao();
        // LocalizacaoDao persistenciaLocalizacao = new LocalizacaoDao();
        CompanheirosDeViagemDao persistenciaCompanheirosDeViagem = new CompanheirosDeViagemDao();
        MeEncontre_OutrasRedesDao persistenciaMeEncontre_OutrasRedes = new MeEncontre_OutrasRedesDao();

        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;

        if (session != null)
        {

            // TELEFONE
            Usuario usuarioAtual = (Usuario) session.getAttribute("usuario");
            List<Telefone> listaDeTelefones = persistenciaTelefone.listarTelefones();

            if (listaDeTelefones != null)
            {
                for (Telefone foneAtual : listaDeTelefones)
                {
                    if (foneAtual.getUsuario().getEmail().equals(usuarioAtual.getEmail()))
                    {
                        telefoneAtual = foneAtual;
                        session.setAttribute("telefone", foneAtual);
                    }
                }
                PrintWriter out = response.getWriter();
                //  out.println("O seu telefone é: " + telefoneAtual.getNumero());

            }

            // ESCOLARIDADE
            List<Escolaridade> listaDeEscolaridade = persistenciaEscolariadade.listarEscolaridade();

            if (listaDeEscolaridade != null)
            {
                for (Escolaridade escolaridade : listaDeEscolaridade)
                {
                    if (escolaridade.getUsuario().getEmail().equals(usuarioAtual.getEmail()))
                    {
                        escolaridadeAtual = escolaridade;
                        session.setAttribute("escolaridade", escolaridade);
                    }
                }
                // out.println("O seu escolaridade é: " + escolaridadeAtual.getNivelFormacao());
            }

            // PROFISSÃO
            List<Profissao> listaDeProfissao = persistenciaProfissao.listarProfissao();

            if (listaDeProfissao != null)
            {
                for (Profissao profissao : listaDeProfissao)
                {
                    if (profissao.getUsuario().getEmail().equals(usuarioAtual.getEmail()))
                    {
                        profissaoAtual = profissao;
                        session.setAttribute("profissao", profissao);
                    }
                }
                // out.println("O sua profissão é: " + profissaoAtual.getEmpresa());
            }

            // companheirosDeViagemAtual
            List<CompanheirosDeViagem> listaDeCompanheirosDeViagem = persistenciaCompanheirosDeViagem.listarCompanheirosDeViagem();

            if (listaDeCompanheirosDeViagem != null)
            {
                for (CompanheirosDeViagem companheirosDeViagem : listaDeCompanheirosDeViagem)
                {
                    if (companheirosDeViagem.getUsuario().getEmail().equals(usuarioAtual.getEmail()))
                    {
                        companheirosDeViagemAtual = companheirosDeViagem;
                        session.setAttribute("companheirosDeViagem", companheirosDeViagem);
                    }
                }

                // out.println("O sua Companheiros de viagem é: " + companheirosDeViagemAtual.getQtdAmigos());
            }

            List<MeEncontre_OutrasRedes> listaDeMeEncontre_OutrasRedes = persistenciaMeEncontre_OutrasRedes.listarMeEncontre_OutrasRedes();

            if (listaDeMeEncontre_OutrasRedes != null)
            {
                for (MeEncontre_OutrasRedes meEncontre_OutrasRedes : listaDeMeEncontre_OutrasRedes)
                {
                    if (meEncontre_OutrasRedes.getUsuario().getEmail().equals(usuarioAtual.getEmail()))
                    {
                        meEncontre_outrasRedesAtual = meEncontre_OutrasRedes;
                        session.setAttribute("meEncontre_OutrasRedes", meEncontre_OutrasRedes);
                    }
                }
                //  out.println("O sua Instagram é: " + meEncontre_outrasRedesAtual.getInstagram());
            }

            rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfilInfoUsuario.jsp");
            rd.forward(request, response);

        }

    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}

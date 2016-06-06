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
import modelo.Autenticador;
import modelo.Usuario;
import bancoDeDados.UsuarioDao;
import modelo.CompanheirosDeViagem;
import modelo.Escolaridade;
import modelo.MeEncontre_OutrasRedes;
import modelo.Profissao;
import modelo.Telefone;

public class AlterarDadosUsuarioServlet extends HttpServlet
{

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //alterar os dados da sessao
        //alterar no banco
        //mandar o usuario para o perfil
        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;

        if (session != null)
        {
            Autenticador autenticar = new Autenticador();
            UsuarioDao manipularUsuarioDao = new UsuarioDao();

            String idUsuarioAntesAlteracao = (String) session.getAttribute("usuarioEmail");
            boolean foiDiferente = false;

            //COMECA ALTERACOES PARA OS DADOS GERAIS
            if (autenticar.autenticarString(request.getParameter("nome")))
            {
                System.out.println("Att nome");

                if (!request.getParameter("nome").equals(session.getAttribute("usuarioNome")))
                {
                    foiDiferente = true;
                    session.setAttribute("usuarioNome", request.getParameter("nome"));
                }
            }
            if (autenticar.autenticarString(request.getParameter("senha")))
            {
                System.out.println("Att senha");

                if (!request.getParameter("senha").equals(session.getAttribute("usuarioSenha")))
                {
                    foiDiferente = true;
                    session.setAttribute("usuarioSenha", request.getParameter("senha"));
                }
            }

            if (foiDiferente == true)
            {
                System.out.print("foi diferente na alteracao.");
                Usuario usuarioAtualizado = new Usuario(request.getParameter("nome"), (String) session.getAttribute("usuarioEmail"), request.getParameter("senha"));

                System.out.print("No obj: " + usuarioAtualizado.getNome() + " " + usuarioAtualizado.getEmail() + " " + usuarioAtualizado.getSenha());
                System.out.println("Na sessao: " + session.getAttribute("usuarioNome") + " " + (String) session.getAttribute("usuarioEmail") + " " + session.getAttribute("usuarioSenha"));

                session.setAttribute("usuario", usuarioAtualizado);
            }
             //TERMINA ALTERACOES PARA OS DADOS GERAIS

            //TELEFONE
            Telefone telefoneAtual = (Telefone) session.getAttribute("telefone");
            TelefoneDao persistenciaTelefone = new TelefoneDao();

            if (telefoneAtual != null) //se n tem nada na sessao ainda
            {
                if (request.getParameter("cadastra_telefone_codigoDoPais") != null) //se o cara digitou alguma coisa
                {
                    if (!request.getParameter("cadastra_telefone_codigoDoPais").equals("")) //so pode xecar isso, se n for null, pq se n da nullpointerexception
                    {
                        if (!request.getParameter("cadastra_telefone_codigoDoPais").equals(telefoneAtual.getCodigoPais()))
                        {
                            telefoneAtual.setCodigoPais(request.getParameter("cadastra_telefone_codigoDoPais"));
                        }
                    }
                }

                if (request.getParameter("cadastra_telefone_DDD") != null)
                {
                    if (!request.getParameter("cadastra_telefone_DDD").equals(""))
                    {
                        if (!request.getParameter("cadastra_telefone_DDD").equals(telefoneAtual.getDdd()))
                        {
                            telefoneAtual.setDdd(request.getParameter("cadastra_telefone_DDD"));
                        }
                    }
                }
                if (request.getParameter("cadastra_telefone_numero") != null)
                {
                    if (!request.getParameter("cadastra_telefone_numero").equals(""))
                    {
                        if (!request.getParameter("cadastra_telefone_numero").equals(telefoneAtual.getNumero()))
                        {
                            telefoneAtual.setNumero(request.getParameter("cadastra_telefone_numero"));
                        }
                    }
                }
                persistenciaTelefone.alterar(telefoneAtual, telefoneAtual.getId());
                session.setAttribute("telefone", telefoneAtual);

            } else //crie, salve no banco, salve na sessao
            {
                if (request.getParameter("cadastra_telefone_codigoDoPais") != null || request.getParameter("cadastra_telefone_DDD") != null || request.getParameter("cadastra_telefone_numero") != null)
                {  //mas so fassa isso, se o cara tiver informado ao menos um dado
                    if (!request.getParameter("cadastra_telefone_codigoDoPais").equals("") || !request.getParameter("cadastra_telefone_DDD").equals("") || !request.getParameter("cadastra_telefone_numero").equals(""))
                    {
                        Telefone telefoneNovo = new Telefone();
                        telefoneNovo.setCodigoPais(request.getParameter("cadastra_telefone_codigoDoPais"));
                        telefoneNovo.setDdd(request.getParameter("cadastra_telefone_DDD"));
                        telefoneNovo.setNumero(request.getParameter("cadastra_telefone_numero"));
                        telefoneNovo.setUsuario((Usuario) session.getAttribute("usuario"));
                        persistenciaTelefone.inserir(telefoneNovo);
                        session.setAttribute("telefone", telefoneNovo);
                    }
                }
            }

            //ESCOLARIDADE            
            Escolaridade escolaridadeAtual = (Escolaridade) session.getAttribute("escolaridade");
            EscolaridadeDao persistenciaEscolaridade = new EscolaridadeDao();

            if (escolaridadeAtual != null)
            {
                if (request.getParameter("cadastra_escolaridade_escola") != null)//se o cara digitou algo
                {
                    if (!request.getParameter("cadastra_escolaridade_escola").equals(""))
                    {
                        if (!request.getParameter("cadastra_escolaridade_escola").equals(escolaridadeAtual.getNomeEscola()))
                        {
                            escolaridadeAtual.setNomeEscola(request.getParameter("cadastra_escolaridade_escola"));
                        }
                    }
                }
                if (request.getParameter("cadastra_escolaridade_NivelDeFormacao") != null)
                {
                    if (!request.getParameter("cadastra_escolaridade_NivelDeFormacao").equals(""))
                    {
                        if (!request.getParameter("cadastra_escolaridade_NivelDeFormacao").equals(escolaridadeAtual.getNivelFormacao()))
                        {
                            escolaridadeAtual.setNivelFormacao(request.getParameter("cadastra_escolaridade_NivelDeFormacao"));
                        }
                    }
                }
                if (request.getParameter("cadastra_escolaridade_tempoGasto") != null)
                {
                    if (!request.getParameter("cadastra_escolaridade_tempoGasto").equals(""))
                    {
                        if (Integer.parseInt(request.getParameter("cadastra_escolaridade_tempoGasto")) != escolaridadeAtual.getTempoGastoNaFormacao())
                        {
                            escolaridadeAtual.setTempoGastoNaFormacao(Integer.parseInt(request.getParameter("cadastra_escolaridade_tempoGasto")));
                        }
                    }
                }
                boolean alterou = persistenciaEscolaridade.alterar(escolaridadeAtual, escolaridadeAtual.getId());
                System.out.print("alterei o servlet: " + alterou);
                session.setAttribute("escolaridade", escolaridadeAtual);
            } else //crie, salve no banco, salve na sessao
            {
                if (request.getParameter("cadastra_escolaridade_escola") != null || request.getParameter("cadastra_escolaridade_NivelDeFormacao") != null || request.getParameter("cadastra_escolaridade_tempoGasto") != null)
                {
                    if (!request.getParameter("cadastra_escolaridade_escola").equals("") || !request.getParameter("cadastra_escolaridade_NivelDeFormacao").equals("") || !request.getParameter("cadastra_escolaridade_tempoGasto").equals(""))
                    {
                        Escolaridade escolaridade = new Escolaridade();
                        escolaridade.setNomeEscola(request.getParameter("cadastra_escolaridade_escola"));
                        escolaridade.setNivelFormacao(request.getParameter("cadastra_escolaridade_NivelDeFormacao"));
                        escolaridade.setTempoGastoNaFormacao(Integer.parseInt(request.getParameter("cadastra_escolaridade_tempoGasto")));
                        escolaridade.setUsuario((Usuario) session.getAttribute("usuario"));
                        persistenciaEscolaridade.inserir(escolaridade);
                        session.setAttribute("escolaridade", escolaridade);
                    }
                }
            }

            //PROFISSAO            
            Profissao profissaoAtual = (Profissao) session.getAttribute("profissao");
            ProfissaoDao persistenciaProfissao = new ProfissaoDao();

            if (profissaoAtual != null)
            {
                if (request.getParameter("cadastra_profissao_nome") != null)
                {
                    if (!request.getParameter("cadastra_profissao_nome").equals(""))
                    {
                        if (!request.getParameter("cadastra_profissao_nome").equals(profissaoAtual.getNome()))
                        {
                            profissaoAtual.setNome(request.getParameter("cadastra_profissao_nome"));
                        }
                    }
                }
                if (request.getParameter("cadastra_profissao_empresa") != null)
                {
                    if (!request.getParameter("cadastra_profissao_empresa").equals(""))
                    {
                        if (!request.getParameter("cadastra_profissao_empresa").equals(profissaoAtual.getEmpresa()))
                        {
                            profissaoAtual.setEmpresa(request.getParameter("cadastra_profissao_empresa"));
                        }
                    }
                }
                if (request.getParameter("cadastra_profissao_experiencia") != null)
                {
                    if (!request.getParameter("cadastra_profissao_experiencia").equals(""))
                    {
                        if (Integer.parseInt(request.getParameter("cadastra_profissao_experiencia")) != profissaoAtual.getExperiencia())
                        {
                            profissaoAtual.setExperiencia(Integer.parseInt(request.getParameter("cadastra_profissao_experiencia")));
                        }
                    }
                }
                persistenciaProfissao.alterar(profissaoAtual, profissaoAtual.getId());
                session.setAttribute("profissao", profissaoAtual);
            } else
            {
                if (request.getParameter("cadastra_profissao_nome") != null || request.getParameter("cadastra_profissao_empresa") != null || request.getParameter("cadastra_profissao_experiencia") != null)
                {
                    if (!request.getParameter("cadastra_profissao_nome").equals("") || !request.getParameter("cadastra_profissao_empresa").equals("") || !request.getParameter("cadastra_profissao_experiencia").equals(""))
                    {
                        Profissao profissao = new Profissao();
                        profissao.setNome(request.getParameter("cadastra_profissao_nome"));
                        profissao.setEmpresa(request.getParameter("cadastra_profissao_empresa"));
                        profissao.setExperiencia(Integer.parseInt(request.getParameter("cadastra_profissao_experiencia")));
                        profissao.setUsuario((Usuario) session.getAttribute("usuario"));
                        persistenciaProfissao.inserir(profissao);
                        session.setAttribute("profissao", profissao);
                    }
                }
            }

            //COMPANHEIROOS DE VIAGEM
            CompanheirosDeViagem companheirosDeViagemAtual = (CompanheirosDeViagem) session.getAttribute("companheirosDeViagem");
            CompanheirosDeViagemDao persistenciacompanheiros = new CompanheirosDeViagemDao();

            if (companheirosDeViagemAtual != null)
            {
                if (request.getParameter("cadastrar_Companheiros_qtdCriancas") != null)
                {
                    if (!request.getParameter("cadastrar_Companheiros_qtdCriancas").equals(""))
                    {
                        if (Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdCriancas")) != companheirosDeViagemAtual.getCriancas())
                        {
                            companheirosDeViagemAtual.setCriancas(Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdCriancas")));
                        }
                    }
                }
                if (request.getParameter("cadastrar_Companheiros_qtdAnimais") != null)
                {
                    if (!request.getParameter("cadastrar_Companheiros_qtdAnimais").equals(""))
                    {
                        if (Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdAnimais")) != companheirosDeViagemAtual.getQtdAnimaisDeEstimacao())
                        {
                            companheirosDeViagemAtual.setQtdAnimaisDeEstimacao(Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdAnimais")));
                        }
                    }
                }
                if (request.getParameter("cadastrar_Companheiros_qtdAmigos") != null)
                {
                    if (!request.getParameter("cadastrar_Companheiros_qtdAmigos").equals(""))
                    {
                        if (Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdAmigos")) != companheirosDeViagemAtual.getQtdAmigos())
                        {
                            companheirosDeViagemAtual.setQtdAmigos(Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdAmigos")));
                        }
                    }
                }
                if (request.getParameter("sex") != null)
                {
                    if (request.getParameter("sex").equals("sim"))
                    {
                        companheirosDeViagemAtual.setPessoaComQuemTenhoRelacionamentoSerio(true);
                    } else if (request.getParameter("sex").equals("nao"))
                    {
                        companheirosDeViagemAtual.setPessoaComQuemTenhoRelacionamentoSerio(false);
                    }
                }
                persistenciacompanheiros.alterar(companheirosDeViagemAtual, companheirosDeViagemAtual.getId());
                session.setAttribute("companheirosDeViagem", companheirosDeViagemAtual);
            } else
            {
                if (request.getParameter("cadastrar_Companheiros_qtdCriancas") != null || request.getParameter("cadastrar_Companheiros_qtdAnimais") != null || request.getParameter("cadastrar_Companheiros_qtdAmigos") != null || request.getParameter("sex") != null)
                {
                    if (!request.getParameter("cadastrar_Companheiros_qtdCriancas").equals("") || !request.getParameter("cadastrar_Companheiros_qtdAnimais").equals("") || !request.getParameter("cadastrar_Companheiros_qtdAmigos").equals(""))
                    { //so pode verificar esse, se n tiver nada null ate aq, por isso n pode botar eles n msm condicao
                        CompanheirosDeViagem companheiros = new CompanheirosDeViagem();
                        companheiros.setCriancas(Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdCriancas")));
                        companheiros.setQtdAnimaisDeEstimacao(Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdAnimais")));
                        companheiros.setQtdAmigos(Integer.parseInt(request.getParameter("cadastrar_Companheiros_qtdAmigos")));
                        if (request.getParameter("sex").equals("sim"))
                        {
                            companheiros.setPessoaComQuemTenhoRelacionamentoSerio(true);
                        } else if (request.getParameter("sex").equals("nao"))
                        {
                            companheiros.setPessoaComQuemTenhoRelacionamentoSerio(false);
                        }
                        companheiros.setUsuario((Usuario) session.getAttribute("usuario"));
                        persistenciacompanheiros.inserir(companheiros);
                        session.setAttribute("companheirosDeViagem", companheiros);
                    }
                }
            }

            //OUTRAS REDES
            MeEncontre_OutrasRedes meEncontre_OutrasRedesAtual = (MeEncontre_OutrasRedes) session.getAttribute("meEncontre_OutrasRedes");
            MeEncontre_OutrasRedesDao persistenciaMeEncontre = new MeEncontre_OutrasRedesDao();

            if (meEncontre_OutrasRedesAtual != null)
            {
                if (request.getParameter("cadastrar_RedesSociais_facebook") != null)
                {
                    if (!request.getParameter("cadastrar_RedesSociais_facebook").equals(""))
                    {
                        if (!request.getParameter("cadastrar_RedesSociais_facebook").equals(meEncontre_OutrasRedesAtual.getFacebook()))
                        {
                            meEncontre_OutrasRedesAtual.setFacebook(request.getParameter("cadastrar_RedesSociais_facebook"));
                        }
                    }
                }
                if (request.getParameter("cadastrar_RedesSociais_twitter") != null)
                {
                    if (!request.getParameter("cadastrar_RedesSociais_twitter").equals(""))
                    {
                        if (!request.getParameter("cadastrar_RedesSociais_twitter").equals(meEncontre_OutrasRedesAtual.getTwitter()))
                        {
                            meEncontre_OutrasRedesAtual.setTwitter(request.getParameter("cadastrar_RedesSociais_twitter"));
                        }
                    }
                }
                if (request.getParameter("cadastrar_RedesSociais_instagram") != null)
                {
                    if (!request.getParameter("cadastrar_RedesSociais_instagram").equals(""))
                    {
                        if (!request.getParameter("cadastrar_RedesSociais_instagram").equals(meEncontre_OutrasRedesAtual.getInstagram()))
                        {
                            meEncontre_OutrasRedesAtual.setInstagram(request.getParameter("cadastrar_RedesSociais_instagram"));
                        }
                    }
                }
                persistenciaMeEncontre.alterar(meEncontre_OutrasRedesAtual, meEncontre_OutrasRedesAtual.getId());
                session.setAttribute("meEncontre_OutrasRedes", meEncontre_OutrasRedesAtual);
            } else
            {
                if (request.getParameter("cadastrar_RedesSociais_facebook") != null || request.getParameter("cadastrar_RedesSociais_twitter") != null || request.getParameter("cadastrar_RedesSociais_instagram") != null)                      
                {
                    if (!request.getParameter("cadastrar_RedesSociais_facebook").equals("") || !request.getParameter("cadastrar_RedesSociais_twitter").equals("") || !request.getParameter("cadastrar_RedesSociais_instagram").equals(""))
                    {
                        MeEncontre_OutrasRedes meEncontre = new MeEncontre_OutrasRedes();
                        meEncontre.setFacebook(request.getParameter("cadastrar_RedesSociais_facebook"));
                        meEncontre.setTwitter(request.getParameter("cadastrar_RedesSociais_twitter"));
                        meEncontre.setInstagram(request.getParameter("cadastrar_RedesSociais_instagram"));
                        meEncontre.setUsuario((Usuario) session.getAttribute("usuario"));
                        persistenciaMeEncontre.inserir(meEncontre);
                        session.setAttribute("meEncontre_OutrasRedes", meEncontre);
                    }
                }
            }

            rd = request.getRequestDispatcher("/WEB-INF/Editar/editarFotoPerfil.jsp");
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

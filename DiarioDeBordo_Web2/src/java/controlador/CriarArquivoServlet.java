/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bancoDeDados.ArquivoDao;
import bancoDeDados.CapituloDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Arquivo;
import modelo.Capitulo;

public class CriarArquivoServlet extends HttpServlet
{

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // PrintWriter out1 = response.getWriter();
        //out1.println("Request : " + request);
        //saber de onde veio para instancia certo (usei paginaQueCria?video)
        //setar propriedade do obj 
        //salvar no banco usando o dao
        //manda usuario para o perfil
        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;
        if (session != null)
        {
            ArmazenaImagem a = new ArmazenaImagem();
            PrintWriter out = response.getWriter();
            Capitulo capituloAtual;

            String flag = "", descricao = "";
            Arquivo arquivo = null;
            boolean entrei = false;

            switch (request.getParameter("paginaQueCria"))
            {
                case "audio":
                    entrei = true;
                    descricao = "Esse é um audio";
                    arquivo = new Arquivo(request.getParameter("descricao"), "audio", request.getParameter("conteudo"));
                    break;
                case "video":
                    entrei = true;
                    descricao = "Esse é um video";
                    arquivo = new Arquivo(request.getParameter("descricao"), "video", request.getParameter("conteudo"));
                    break;
            }

            if (entrei == false)
            {

                descricao = "Esse é uma foto";
                arquivo = new Arquivo(request.getParameter("descricao"), "foto", a.nomeFoto);

            }

            // arquivo = arquivo.contruirArquivo(arquivo, descricao);        
            ArquivoDao manipular = new ArquivoDao();
            manipular.inserir(arquivo);
            capituloAtual = (Capitulo) session.getAttribute("capituloDaVez");

        // 0. cria arquivo
            // 1. insere arquivo no banco se ele já não estiver.
            //1.1 busca o capítulo
            // 2. adiciona o arquivo no capitulo, com o setArquivos().
            //3. adiciona o capitulo no banco, chamando o alterar.
            CapituloDAO capituloDAO = new CapituloDAO();
            //  Capitulo capitulo2 = capituloDAO.buscarCapitulo(capituloAtual.getId());
            capituloAtual.setArquivos(arquivo);
            capituloDAO.alterar(capituloAtual);
        //2. capitulo2.setArquivos(arquivo);
            //3. capituloDAO.alterar(capitulo2);
            
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

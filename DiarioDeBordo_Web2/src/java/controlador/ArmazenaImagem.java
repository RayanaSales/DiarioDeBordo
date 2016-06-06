package controlador;

import bancoDeDados.ArquivoDao;
import bancoDeDados.CapituloDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import modelo.Usuario;

public class ArmazenaImagem extends HttpServlet
{

    GerenciadorDeDiretorios gerDir = null;
    String nomeFoto;

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession(false);

        if (session != null)
        {
            boolean jaTemCapaMasQuerEnviarArquivoNormal = false;
            PrintWriter out1 = response.getWriter();
            gerDir = new GerenciadorDeDiretorios(request.getRealPath("/"));

            CriarArquivoServlet criaArquivo = new CriarArquivoServlet();
            TrocaFotoCapaServlet tfcs = new TrocaFotoCapaServlet();
            Capitulo cap = (Capitulo) session.getAttribute("capituloDaVez");
            String nomeUsuario = (String) session.getAttribute("usuarioNome");
           
            String diretorio = gerDir.criarDiretorioParaCapitulo(nomeUsuario, cap.getNome());

            CapituloDAO capDao = new CapituloDAO();
            ArquivoDao arqDao = new ArquivoDao();

            Arquivo arquivo = arqDao.buscarFotoDaCapa();
            if (arquivo == null) //se n tiver uma capa, entao procure por um arquivo
            {
                arquivo = arqDao.buscarFotoTemporaria();
            }
            else if(arquivo != null) //teste se ele ja tem uma capa, mas ta tentando inserir uma foto normal
            {
                arquivo = arqDao.buscarFotoTemporaria();
                if(arquivo != null) //ele ja tem uma capa, mas quer enviar uma foto normal
                {
                    jaTemCapaMasQuerEnviarArquivoNormal = true;
                }
                else //ele queria uma capa msm
                {
                    arquivo = arqDao.buscarFotoDaCapa();
                }
            }

            if (arquivo.getTipo().equals("foto capa"))
            {
                tfcs.doPost(request, response);
            } 
            else if (arquivo.getTipo().equals("foto null") || jaTemCapaMasQuerEnviarArquivoNormal == true)
            {
                arquivo = arqDao.buscarFotoTemporaria();
                try
                {
                    String nomeFoto = arquivo.getConteudo();

                    // se houver diretório...
                    if (!diretorio.equals("null"))
                    {
                        Part filePart = request.getPart("file");
                        InputStream inputStream = null;

                        if (filePart != null)
                        {

                            System.out.println(filePart.getName());
                            System.out.println(filePart.getSize());
                            System.out.println(filePart.getContentType());
                            // pega mesmo os bytes da foto e coloca no inputstream
                            inputStream = filePart.getInputStream();
                        }
                        //pega o nome do arquivo original: filePart.getSubmittedFileName()
                        File file = new File(request.getRealPath("/").replace("build\\", "") + "//" + diretorio, nomeFoto);
                        FileOutputStream out = new FileOutputStream(file);

                        // Imagens de até 2 megas !!
                        byte[] buffer = new byte[1024 * 10];
                        int nLidos;

                        while ((nLidos = inputStream.read(buffer)) >= 0)
                        {
                            out.write(buffer, 0, nLidos);
                        }

                        String conteudo = cap.getDIRETORIO_CAPITULO() + "\\" + nomeFoto;
                        arquivo.setTipo("foto");
                        arquivo.setConteudo(conteudo.replace('\\', '/'));

                        boolean apagou = arqDao.remover(nomeFoto); //n pode alterar pq a pk muda.                
                        cap.removeArquivo(nomeFoto);
                        boolean alterou = arqDao.inserir(arquivo);
                        cap.setArquivos(arquivo);
                        capDao.alterar(cap);

                        out.close();
                        response.sendRedirect("/DiarioDeBordo_Web2/perfil");

//                RequestDispatcher rd = null;
//                rd = request.getRequestDispatcher("/WEB-INF/Perfil/perfil.jsp");
//                rd.forward(request, response);
                    }
                } catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            }
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
    }
}

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

public class TrocaFotoCapaServlet extends HttpServlet
{

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;

        if (session != null)
        {
            PrintWriter out1 = response.getWriter();
            GerenciadorDeDiretorios gerDir = new GerenciadorDeDiretorios(request.getRealPath("/"));
            Capitulo capitulo = (Capitulo) session.getAttribute("capituloDaVez");
            Usuario user = (Usuario) session.getAttribute("usuario");
            CapituloDAO capDao = new CapituloDAO();
            ArquivoDao arDao = new ArquivoDao();

            Arquivo arquivo = arDao.buscarFotoDaCapa();

            String diretorio = gerDir.criarDiretorioParaCapitulo(user.getNome(), capitulo.getNome());

            try
            {
                String nomeFoto = "fotoCapa.jpg";

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

                    String conteudo = diretorio + "\\" + nomeFoto;
                    //  arquivo.setTipo("foto");              
                    arquivo.setConteudo(conteudo);

                    boolean apagou = arDao.remover(nomeFoto); //n pode alterar pq a pk muda.                
                    capitulo.removeArquivo(nomeFoto);
                    boolean alterou = arDao.inserir(arquivo);
                    capitulo.setArquivos(arquivo);

                    char[] lista = conteudo.toCharArray();

                    for (int i = 0; i < lista.length; i++)
                    {
                        if (lista[i] == '\\')
                        {
                            lista[i] = '/';
                        }
                    }

                    conteudo = "";

                    for (int i = 0; i < lista.length; i++)
                    {
                        conteudo = conteudo + lista[i];

                    }
                    capitulo.setFotoCapa(conteudo);
                    capDao.alterar(capitulo);

                    out.close();
                    response.sendRedirect("/DiarioDeBordo_Web2/perfil");
                }
            } catch (Exception e)
            {
                throw new RuntimeException(e);
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
    }// </editor-fold>

}

package controlador;

import bancoDeDados.UsuarioDao;
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
import modelo.Usuario;

public class TrocarFotoPerfilServlet extends HttpServlet
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
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            UsuarioDao userDao = new UsuarioDao();

            String diretorio = gerDir.criarDiretorioParaCapitulo(usuario.getNome(), "perfil");

            try
            {
                String nomeFoto = "perfil.jpg";

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
                    conteudo.replace("\\", "/");

                    usuario.setFotoPerfil(conteudo);
                    userDao.alterar(usuario, usuario.getEmail());

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

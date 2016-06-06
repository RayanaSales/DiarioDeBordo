package controlador;

import java.io.File;

public class GerenciadorDeDiretorios
{
    String diretorioPart1;
    String diretorioRaiz;
    
    private GerenciadorDeDiretorios()
    {
    }    
    
    public GerenciadorDeDiretorios(String diretorioRaiz)
    {
        this.diretorioRaiz =  diretorioRaiz.replace("build\\", "");        
    } 
    
    public void criaPastaUsuario(String nomeDousuario)
    {
        diretorioPart1 = criarDiretorioParaUmUsuario(nomeDousuario);
    }

    public boolean criarDiretorio(String diretorio)
    {
        boolean criado = false;

        try
        {
            if (!new File(diretorio).exists())
            {
                File dir = new File(diretorio);
                dir.mkdir();
                String dirr = dir.getAbsolutePath();
                
                System.out.println("DIRETORIO CRIADO : " + dirr);
                
                criado = true;
            }
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return criado;
    }

    public String criarDiretorioParaUmUsuario(String nomeUsuario)
    {
        String caminho = diretorioRaiz + "\\" + nomeUsuario;
        boolean criado = criarDiretorio(caminho);

        if (criado == true)
        {
            return caminho;
        } else
        {
            return "null";
        }
    }

    public String criarDiretorioParaCapitulo(String nomeUsuario, String nomeCapitulo)
    {
        String diretorioUsuario = criarDiretorioParaUmUsuario(nomeUsuario);//testa se o usuario ja tem um diretorio       
        String caminho = diretorioRaiz + "\\" + nomeUsuario + "\\" + nomeCapitulo;

        boolean criado = criarDiretorio(caminho);

        return nomeUsuario + "\\" + nomeCapitulo;
    }
}

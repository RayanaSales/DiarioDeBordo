package modelo;


import bancoDeDados.UsuarioDao;
import java.util.List;

public class Autenticador
{
    public boolean autenticarLogin(String email, String senha)
    {
        boolean jaTemNoBanco = false;
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> usuarios = usuarioDao.listarUsuarios();

        for(int i = 0; i < usuarios.size(); i++)
        {
            if (usuarios.get(i).getEmail().equalsIgnoreCase(email) && usuarios.get(i).getSenha().equalsIgnoreCase(senha))
            {
               jaTemNoBanco = true;
               break;
            } 
        }
        return jaTemNoBanco;
    }
    
    public boolean autenticarCadastro(String email)
    {
        boolean jaTemNoBanco = false;
        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> usuarios = usuarioDao.listarUsuarios();

        for(int i = 0; i < usuarios.size(); i++)
        {
            if (usuarios.get(i).getEmail().equalsIgnoreCase(email))
            {
               jaTemNoBanco = true;
                break;
            } 
        }
        return jaTemNoBanco;
    }
    
    public boolean autenticarString(String str) //eh valida se tiver letras
    {
        char[] charArray = str.toCharArray();
        boolean contemLetras = false;
        int ascii = 0;

        for (int i = 0; i < charArray.length; i++)
        {
            if (charArray[i] == '0' || charArray[i] == '1' || charArray[i] == '2' || charArray[i] == '3' || charArray[i] == '4' || charArray[i] == '5' || charArray[i] == '6' || charArray[i] == '7' || charArray[i] == '8' || charArray[i] == '9')
            {
                contemLetras = true;
                break;  
            }
            ascii = (int) charArray[i];
            //System.out.println(ascii);
            if ((ascii <= 122 && ascii >= 97) || (ascii <= 90 && ascii >= 65))
            {
                contemLetras = true;
                break;
            }          
        }
        System.out.println("Contem letras: " + contemLetras);
        return contemLetras;
    }
}

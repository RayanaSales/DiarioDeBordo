package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable
{
    @Column
    String nome;
    
    @Column
    String fotoPerfil;
    
    @Id
    String email;
    
    @Column
    String senha;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    List<Capitulo> capitulos = new ArrayList();
   
    public Usuario()
    {
        
    }
    
    public Usuario(String nome, String email, String senha)
    {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getFotoPerfil()
    {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil)
    {
        this.fotoPerfil = fotoPerfil;
    }

    public List<Capitulo> getCapitulos()
    {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos)
    {
        this.capitulos = capitulos;
    }   
    
}

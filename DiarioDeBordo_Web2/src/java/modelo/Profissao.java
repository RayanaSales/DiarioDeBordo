package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Profissao implements Serializable
{
    @Column
    String nome;
    @Column
    String empresa;
    @Column
    int experiencia_anos;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    
    @OneToOne(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name="usuario", referencedColumnName = "email") 
    Usuario usuario; //name = nomeDaTabela, referencedColumnName = nessa tabela, qual o campo?

    public Profissao()
    {
    }

    public Profissao(String nome, String empresa, int experiencia, Usuario usuario)
    {
        this.nome = nome;
        this.empresa = empresa;
        this.experiencia_anos = experiencia;
        this.usuario = usuario;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEmpresa()
    {
        return empresa;
    }

    public void setEmpresa(String empresa)
    {
        this.empresa = empresa;
    }

    public int getExperiencia()
    {
        return experiencia_anos;
    }

    public void setExperiencia(int experiencia)
    {
        this.experiencia_anos = experiencia;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }
    
    
    
    
}

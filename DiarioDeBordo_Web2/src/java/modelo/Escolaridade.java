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
public class Escolaridade implements Serializable
{
    @Column
    String nomeEscola;
    @Column
    String nivelFormacao;
    @Column
    int tempoGastoNaFormacao;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    
    @OneToOne(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name="usuario", referencedColumnName = "email") 
    Usuario usuario; //name = nomeDaTabela, referencedColumnName = nessa tabela, qual o campo?

    public Escolaridade()
    {
    }

    public Escolaridade(String nomeEscola, String nivelFormacao, int tempoGastoNaFormacao, Usuario usuario)
    {
        this.nomeEscola = nomeEscola;
        this.nivelFormacao = nivelFormacao;
        this.tempoGastoNaFormacao = tempoGastoNaFormacao;
        this.usuario = usuario;
    }

    public String getNomeEscola()
    {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola)
    {
        this.nomeEscola = nomeEscola;
    }

    public String getNivelFormacao()
    {
        return nivelFormacao;
    }

    public void setNivelFormacao(String nivelFormacao)
    {
        this.nivelFormacao = nivelFormacao;
    }

    public int getTempoGastoNaFormacao()
    {
        return tempoGastoNaFormacao;
    }

    public void setTempoGastoNaFormacao(int tempoGastoNaFormacao)
    {
        this.tempoGastoNaFormacao = tempoGastoNaFormacao;
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

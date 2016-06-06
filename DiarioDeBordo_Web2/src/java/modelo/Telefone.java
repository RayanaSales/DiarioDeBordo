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
public class Telefone implements Serializable
{
    @Column
    String codigoPais;
    @Column
    String ddd;
    @Column
    String numero;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    
    @OneToOne(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name="usuario", referencedColumnName = "email") 
    Usuario usuario; //name = nomeDaTabela, referencedColumnName = nessa tabela, qual o campo?

    public Telefone()
    {
    }

    public Telefone(String codigoPais, String ddd, String numero,Usuario u)
    {
        this.codigoPais = codigoPais;
        this.ddd = ddd;
        this.numero = numero;
        usuario = u;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public String getCodigoPais()
    {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais)
    {
        this.codigoPais = codigoPais;
    }

    public String getDdd()
    {
        return ddd;
    }

    public void setDdd(String ddd)
    {
        this.ddd = ddd;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    

}

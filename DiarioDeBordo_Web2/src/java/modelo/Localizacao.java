package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Localizacao implements Serializable
{
    @Column
    String pais;
    
    @Column
    String estado;
    
    @Column
    String cidade;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;  
   
    public Localizacao()
    {
    }
    
    public Localizacao(String pais, String estado, String cidade)
    {
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
    }

    public String getPais()
    {
        return pais;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getCidade()
    {
        return cidade;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
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

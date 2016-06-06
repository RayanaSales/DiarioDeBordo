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
public class MeEncontre_OutrasRedes implements Serializable
{
    @Column
    String facebook;
    @Column
    String twitter;
    @Column
    String instagram;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    
    @OneToOne(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name="usuario", referencedColumnName = "email") 
    Usuario usuario; //name = nomeDaTabela, referencedColumnName = nessa tabela, qual o campo?

    public MeEncontre_OutrasRedes()
    {
    }

    public MeEncontre_OutrasRedes(String facebook, String twitter, String instagram, Usuario usuario)
    {
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;       
        this.usuario = usuario;
    }

    public String getFacebook()
    {
        return facebook;
    }

    public void setFacebook(String facebook)
    {
        this.facebook = facebook;
    }

    public String getTwitter()
    {
        return twitter;
    }

    public void setTwitter(String twitter)
    {
        this.twitter = twitter;
    }

    public String getInstagram()
    {
        return instagram;
    }

    public void setInstagram(String instagram)
    {
        this.instagram = instagram;
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

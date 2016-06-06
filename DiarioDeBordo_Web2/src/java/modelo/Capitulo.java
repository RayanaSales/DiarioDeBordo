package modelo;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Capitulo implements Serializable
{ //muitos capitulo, para um usuario_id
    @Column
    String nome;
    
    @Column
    String fotoCapa;
    
    @Column
    String descricao;
    
    @Column
    String DIRETORIO_CAPITULO;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    Date inicio;
    
    @Column    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date fim;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id")
    Usuario usuario_id;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CAPITULO_ARQUIVO", joinColumns = @JoinColumn( name = "ID_CAPITULO"),
            inverseJoinColumns = @JoinColumn(name ="ID_ARQUIVO"))
    List<Arquivo> arquivos =  new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL)
    Localizacao localizacao;
    
    public Capitulo()
    {
        
    }
    
     public Capitulo(String nome, String descricao, Date inicio, Date fim, Usuario usuario, String caminho, Localizacao local)
    {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.usuario_id = usuario;
        DIRETORIO_CAPITULO = caminho;
        this.localizacao = local;
    }

    public Localizacao getLocalizacao()
    {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao)
    {
        this.localizacao = localizacao;
    }    

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Date getInicio()
    {
        return inicio;
    }

    public void setInicio(Date inicio)
    {
        this.inicio = inicio;
    }

    public Date getFim()
    {
        return fim;
    }

    public void setFim(Date fim)
    {
        this.fim = fim;
    }

    public Arquivo getArquivos(int index)
    {
        return arquivos.get(index);
    }
    
    public List<Arquivo> getLista()
    {
        return arquivos;
    }

    public Usuario getUsuario_id()
    {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id)
    {
        this.usuario_id = usuario_id;
    }
    
    

    public void setArquivos(Arquivo arquivo)
    {
        this.arquivos.add(arquivo);
    }
    
    public void removeArquivo(String id)
    {
        for(int i = 0 ; i < arquivos.size() ; i++)
        {
            if(arquivos.get(i).getConteudo().equals(id))
            {
               this.arquivos.remove(i);
               break;
            }
        }        
    }
   
     public String getDIRETORIO_CAPITULO()
    {
        return DIRETORIO_CAPITULO;
    }

    public void setDIRETORIO_CAPITULO(String DIRETORIO_CAPITULO)
    {
        this.DIRETORIO_CAPITULO = DIRETORIO_CAPITULO;
    }

    public Usuario getUsuario()
    {
        return usuario_id;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario_id = usuario;
    }

    public String getFotoCapa()
    {
        return fotoCapa;
    }

    public void setFotoCapa(String fotoCapa)
    {
        this.fotoCapa = fotoCapa;
    }

    
    
}

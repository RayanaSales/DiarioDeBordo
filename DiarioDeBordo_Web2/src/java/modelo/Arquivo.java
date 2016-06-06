package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Arquivo implements Serializable
{
    @Column
    String descricao;
    @Column
    String tipo;
    @Id
    String conteudo; //conteudo eh o id
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CAPITULO_ARQUIVO", joinColumns = @JoinColumn( name = "ID_ARQUIVO"),
            inverseJoinColumns = @JoinColumn(name ="ID_CAPITULO"))
    List<Capitulo> capitulos = new ArrayList<>();
    public Arquivo()
    {
    }

    public Arquivo(String descricao, String tipo, String conteudo)
    {
        
        this.descricao = descricao;
        this.tipo = tipo;
        this.conteudo = conteudo;
        
    }

//    public Arquivo contruirArquivo(Arquivo a, String descricao)
//    {
//        a = a.adicionarDescricao(descricao, a);
//        a = a.adicionarConteudo(a);
//        
//        return a;
//    }
//
//    public abstract Arquivo adicionarConteudo(Arquivo a);
//
//    protected Arquivo adicionarDescricao(String descricao, Arquivo a)
//    {
//        a.setDescricao(descricao);        
//        return a;
//    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getConteudo()
    {
        return conteudo;
    }

    public void setConteudo(String conteudo)
    {
        this.conteudo = conteudo;
    }

    public Capitulo getCapitulos(int index)
    {
        return capitulos.get(index);
    }

    public void setCapitulos(Capitulo capitulo)
    {
        this.capitulos.add(capitulo);
    }
    
}

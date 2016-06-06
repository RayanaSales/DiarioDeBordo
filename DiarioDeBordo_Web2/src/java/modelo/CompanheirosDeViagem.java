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
public class CompanheirosDeViagem implements Serializable
{ //n precisam estar cadastros no sistema    

    @Column
    int criancas;
    @Column
    int qtdAnimaisDeEstimacao;
    @Column
    int qtdAmigos;
    @Column
    boolean pessoaComQuemTenhoRelacionamentoSerio;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    
    @OneToOne(fetch =  FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name="usuario", referencedColumnName = "email") 
    Usuario usuario; //name = nomeDaTabela, referencedColumnName = nessa tabela, qual o campo?

    public CompanheirosDeViagem()
    {
    }

    public CompanheirosDeViagem(int criancas, int qtdAnimaisDeEstimacao, int qtdAmigos, boolean pessoaComQuemTenhoRelacionamentoSerio, Usuario u)
    {
        this.criancas = criancas;
        this.qtdAnimaisDeEstimacao = qtdAnimaisDeEstimacao;
        this.qtdAmigos = qtdAmigos;
        this.pessoaComQuemTenhoRelacionamentoSerio = pessoaComQuemTenhoRelacionamentoSerio;
        usuario = u;
    }

    public int getCriancas()
    {
        return criancas;
    }

    public void setCriancas(int criancas)
    {
        this.criancas = criancas;
    }

    public int getQtdAnimaisDeEstimacao()
    {
        return qtdAnimaisDeEstimacao;
    }

    public void setQtdAnimaisDeEstimacao(int qtdAnimaisDeEstimacao)
    {
        this.qtdAnimaisDeEstimacao = qtdAnimaisDeEstimacao;
    }

    public int getQtdAmigos()
    {
        return qtdAmigos;
    }

    public void setQtdAmigos(int qtdAmigos)
    {
        this.qtdAmigos = qtdAmigos;
    }

    public boolean isPessoaComQuemTenhoRelacionamentoSerio()
    {
        return pessoaComQuemTenhoRelacionamentoSerio;
    }

    public void setPessoaComQuemTenhoRelacionamentoSerio(boolean pessoaComQuemTenhoRelacionamentoSerio)
    {
        this.pessoaComQuemTenhoRelacionamentoSerio = pessoaComQuemTenhoRelacionamentoSerio;
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

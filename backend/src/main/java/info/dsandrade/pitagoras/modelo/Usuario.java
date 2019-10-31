package info.dsandrade.pitagoras.modelo;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nick;

    private String nome;

    @ColumnDefault("1")
    private Integer nivelSoma;
    @ColumnDefault("1")
    private Integer nivelSubtracao;
    @ColumnDefault("1")
    private Integer nivelMultiplicacao;
    @ColumnDefault("1")
    private Integer nivelDivisao;

    @ManyToOne
    private Escola escola;

    private LocalDate dataNascimento;

    @Column(columnDefinition = "long default 0")
    private Long pontos;

    public Usuario(String nick, String nome, LocalDate dataNascimento) {
        this.nick = nick;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Long getPontos() {
        return pontos;
    }

    public void setPontos(Long pontos) {
        this.pontos = pontos;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivelSoma() {
        return nivelSoma;
    }

    public void setNivelSoma(Integer nivelSoma) {
        this.nivelSoma = nivelSoma;
    }

    public Integer getNivelSubtracao() {
        return nivelSubtracao;
    }

    public void setNivelSubtracao(Integer nivelSubtracao) {
        this.nivelSubtracao = nivelSubtracao;
    }

    public Integer getNivelMultiplicacao() {
        return nivelMultiplicacao;
    }

    public void setNivelMultiplicacao(Integer nivelMultiplicacao) {
        this.nivelMultiplicacao = nivelMultiplicacao;
    }

    public Integer getNivelDivisao() {
        return nivelDivisao;
    }

    public void setNivelDivisao(Integer nivelDivisao) {
        this.nivelDivisao = nivelDivisao;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

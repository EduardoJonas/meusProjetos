package info.dsandrade.pitagoras.modelo;

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
}

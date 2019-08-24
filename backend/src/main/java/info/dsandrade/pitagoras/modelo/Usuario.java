package info.dsandrade.pitagoras.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String nick;

    private String nome;

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
}

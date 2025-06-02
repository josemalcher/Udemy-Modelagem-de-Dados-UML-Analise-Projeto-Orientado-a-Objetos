package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Avaliacao {
    private String descricao; // Ex: "Prova 1", "Trabalho Final"
    private LocalDate dataRealizacao; // Data em que a avaliação efetivamente ocorreu
    private Turma turma; // A qual turma esta avaliação se aplica

    public Avaliacao(String descricao, Turma turma) {
        this.descricao = descricao;
        this.turma = turma;
        // A dataRealizacao seria definida quando a avaliação ocorresse.
        // Por simplicidade, não vamos definir no construtor agora, mas poderia ser um parâmetro.
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public Turma getTurma() {
        return turma;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "descricao='" + descricao + '\'' +
                ", dataRealizacao=" + dataRealizacao +
                ", turma=" + turma.getNumeroTurma() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(descricao, avaliacao.descricao) && Objects.equals(turma, avaliacao.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, turma);
    }
}

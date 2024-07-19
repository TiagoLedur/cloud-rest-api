package dio.cloud_rest_api.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_tarefa")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String estado;

    public Task() {
    }
    public Task(Long id, String nome, String descricao, String estado) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estado=" + estado +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEstado() {
        return estado;
    }
}

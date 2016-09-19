package br.upis.ext.javaweb.loja.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by franciscovneto on 03/09/16.
 */

@NamedQueries({
        @NamedQuery(
                name="Cliente.porCpf",
                query="SELECT c FROM Cliente c WHERE c.cpf = :cpf")
})
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @SequenceGenerator(name="Gen.Cliente.id", sequenceName = "seq_cliente_id", initialValue = 1)
    @GeneratedValue(generator = "Gen.Cliente.id")
    @Id
    @Column(name = "NU_ID")
    long id;

    @Column(name = "ST_NOME", nullable = false, length = 200)
    String nome;

    @Column(name = "NU_CPF", unique = true, nullable = false, precision = 11)
    long cpf;

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    List<Pedidos> pedidos;

    public Cliente() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id &&
                cpf == cliente.cpf &&
                Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}

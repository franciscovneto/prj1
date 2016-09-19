package br.upis.ext.javaweb.loja.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by franciscovneto on 10/09/16.
 */
@Entity
@Table(name="TB_PEDIDO")
public class Pedidos {

    @SequenceGenerator(name="Gen.Pedido.id", sequenceName = "seq_pedido_id", initialValue = 1)
    @GeneratedValue(generator = "Gen.Pedido.id")
    @Id
    @Column(name = "NU_ID")
    long id;

    @Column(name = "NU_VALOR")
    BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    Cliente cliente;

    public Pedidos() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedidos)) return false;
        Pedidos pedidos = (Pedidos) o;
        return id == pedidos.id &&
                Objects.equals(valor, pedidos.valor) &&
                Objects.equals(cliente, pedidos.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, cliente);
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", valor=" + valor +
                ", cliente=" + cliente +
                '}';
    }
}

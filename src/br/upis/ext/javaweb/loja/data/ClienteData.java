package br.upis.ext.javaweb.loja.data;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by franciscovneto on 10/09/16.
 */
public class ClienteData {
    long id;
    long cpf;
    String nome;
    long qtdPedidos;
    BigDecimal valorPedidos;

    public ClienteData() {
    }

    public ClienteData(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.qtdPedidos = 0;
        this.valorPedidos = BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "ClienteData{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", qtdPedidos=" + qtdPedidos +
                ", valorPedidos=" + valorPedidos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteData)) return false;
        ClienteData that = (ClienteData) o;
        return cpf == that.cpf &&
                qtdPedidos == that.qtdPedidos &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(valorPedidos, that.valorPedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, qtdPedidos, valorPedidos);
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getQtdPedidos() {
        return qtdPedidos;
    }

    public void setQtdPedidos(long qtdPedidos) {
        this.qtdPedidos = qtdPedidos;
    }

    public BigDecimal getValorPedidos() {
        return valorPedidos;
    }

    public void setValorPedidos(BigDecimal valorPedidos) {
        this.valorPedidos = valorPedidos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

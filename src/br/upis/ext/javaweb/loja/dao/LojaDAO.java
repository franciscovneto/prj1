package br.upis.ext.javaweb.loja.dao;

import br.upis.ext.javaweb.loja.data.ClienteCampoEnum;
import br.upis.ext.javaweb.loja.data.ClienteData;
import br.upis.ext.javaweb.loja.model.Cliente;
import br.upis.ext.javaweb.loja.model.Pedidos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by franciscovneto on 03/09/16.
 */

@Stateless
public class LojaDAO {

    @PersistenceContext(unitName = "loja")
    EntityManager em;

    public List<ClienteData> toData(List<Cliente> clientes){
        List<ClienteData> listData = new ArrayList<ClienteData>();

        for (Cliente c: clientes) {
            listData.add(toData(c));
        }

        return listData;
    }

    public ClienteData toData(Cliente cliente){
        ClienteData data = new ClienteData();

        long qtdPedidos = 0;
        BigDecimal valorPedidos = BigDecimal.ZERO;

        for(Pedidos pedido: cliente.getPedidos()){
            qtdPedidos++;
            valorPedidos = valorPedidos.add(pedido.getValor());
        }

        data.setId(cliente.getId());
        data.setCpf(cliente.getCpf());
        data.setNome(cliente.getNome());
        data.setQtdPedidos(qtdPedidos);
        data.setValorPedidos(valorPedidos);

        return data;
    }

    public List<ClienteData> todosClientes() {

        return toData(em.createQuery("from Cliente c", Cliente.class).getResultList());
    }

    public void criaCliente(Cliente cliente) {
        em.persist(cliente);
    }

    public void deleteCliente(long id){
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
    }

    public void alteraCliente(Cliente cliente){
        Cliente row = em.find(Cliente.class, cliente);
        row.setCpf(cliente.getCpf());
        row.setNome(cliente.getNome());

        em.merge(row);
    }

    public List<ClienteData> todosClientesPaginados(int pageIndex, int pageSize, ClienteCampoEnum campoOrdem, boolean descOrdem) {
        return toData(em.createQuery("select c from Cliente c order by " + campoOrdem.getCampo() + " " + (descOrdem ? "desc" : "asc"), Cliente.class)
                .setFirstResult((pageIndex -1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList());
    }

    public long qtdCliente() {
        return em.createQuery("select count(c) from Cliente c", Long.class).getSingleResult();
    }

    public List<Pedidos> todosPedidos(){
        return em.createQuery("from Pedidos c", Pedidos.class).getResultList();
    }

    public List<ClienteData> gerarRelatorio() {
        return em.createQuery("select new " + ClienteData.class.getCanonicalName() + "(c.cpf, c.nome) " + "from Cliente c", ClienteData.class).getResultList();
    }


//    public void deleteClientePorCpf(long cpf) {
//    Cliente cliente = em.createNamedQuery("Cliente.porCpf", Cliente.class).setParameter("cpf", cpf).getSingleResult();
//        em.remove(cliente);
//    }

}
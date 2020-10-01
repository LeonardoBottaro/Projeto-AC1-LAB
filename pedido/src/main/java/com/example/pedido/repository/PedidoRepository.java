package com.example.pedido.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.pedido.model.Pedido;

import org.springframework.stereotype.Component;

@Component
public class PedidoRepository {
    private List <Pedido> pedidos;
    private int nextCode;

    @PostConstruct
    public void criarPedidos(){
        Pedido p1 = new Pedido();
        Pedido p2 = new Pedido();
        Pedido p3 = new Pedido();

        p1.setCodigo(1);
        p1.setCliente("Jose");
        p1.setData("01/10/2020");
        p1.setDescricao("Hidromel");
        p1.setValor(35.60);

        p2.setCodigo(1);
        p2.setCliente("Ana");
        p2.setData("01/10/2020");
        p2.setDescricao("Armario");
        p2.setValor(350.60);

        p3.setCodigo(1);
        p3.setCliente("Paula");
        p3.setData("25/09/2020");
        p3.setDescricao("Pisca Pisca de Natal");
        p3.setValor(35.60);

        pedidos = new ArrayList<Pedido>();
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);

        nextCode = 4;
    }

    public List<Pedido> getAllPedidos(){
        return pedidos;
    }

    public Pedido getPedidoByCodigo(int codigo){
        for(Pedido aux: pedidos){
            if(aux.getCodigo() == codigo){
                return aux;
            }
        }
        return null;
    }

    public Pedido save(Pedido pedido) {
        pedido.setCodigo(nextCode++);
        pedidos.add(pedido);
        return pedido;
    }

    public void remove(Pedido pedido){
        pedidos.remove(pedido);
    }

    public Pedido update(Pedido pedido){
        Pedido aux = getPedidoByCodigo(pedido.getCodigo());

        if(aux != null){
            aux.setCliente(pedido.getCliente());
            aux.setData(pedido.getData());
            aux.setDescricao(pedido.getDescricao());
            aux.setValor(pedido.getValor());
        }
        return aux;
    }
}

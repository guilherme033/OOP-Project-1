package com.example.poolabac1.OrderSet;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import com.example.poolabac1.Model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoSet {

private List<Pedido> pedidos;
private int nextId;

@PostConstruct

public void init() {

    Pedido p1 = new Pedido();
    p1.setID(1);
    p1.setData("01/02/2019");
    p1.setCliente("Guilherme");
    p1.setDescricao("1ª requisição");
    p1.setValor(2356.50);

    Pedido p2 = new Pedido();
    p2.setID(2);
    p2.setData("02/02/2019");
    p2.setCliente("Fabiana");
    p2.setDescricao("8ª requisição");
    p2.setValor(400.89);

    Pedido p3 = new Pedido();
    p3.setID(3);
    p3.setData("03/02/2019");
    p3.setCliente("Rodrigo");
    p3.setDescricao("3ª requisição");
    p3.setValor(3309);

    pedidos = new ArrayList<Pedido>();
    pedidos.add(p1);
    pedidos.add(p2);
    pedidos.add(p3);

    nextId = 4;
}

public List<Pedido> getAllPedidos(){
    return pedidos; 
}

public Pedido getPedidoById(int id){
    for(Pedido i : pedidos ){
        if(i.getId() == id){
            return i;
        }
    }
    return null;
}

public Pedido save(Pedido pedido){
    pedido.setID(nextId++);
    pedidos.add(pedido);
    return pedido;
}

public void remove(Pedido p){
    pedidos.remove(p);
}

public Pedido update(Pedido pedido){
    Pedido j = getPedidoById(pedido.getId());
        
        if(j != null){
            j.setValor(pedido.getValor());
            j.setDescricao(pedido.getDescricao());
            j.setCliente(pedido.getCliente());
            j.setData(pedido.getData());
         }

        return j;
    }
}

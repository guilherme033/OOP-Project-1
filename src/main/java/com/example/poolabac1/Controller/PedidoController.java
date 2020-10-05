package com.example.poolabac1.Controller;

import java.net.URI;
import java.util.List;
import com.example.poolabac1.Model.Pedido;
import com.example.poolabac1.OrderSet.PedidoSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pedidos")

public class PedidoController {

@Autowired
private PedidoSet OrderSet;

@GetMapping
public List<Pedido> getPedidos() {
    return OrderSet.getAllPedidos();
}

@GetMapping("/{id}")
public ResponseEntity<Pedido> getPedidoByCodigo(@PathVariable int id) {
Pedido p = OrderSet.getPedidoById(id);

    if(p != null) {
        return ResponseEntity.ok(p);
}

    else {
        return ResponseEntity.notFound().build();
    }
}

@PostMapping
public ResponseEntity<Void> save(@RequestBody Pedido pedido) {

    Pedido p = OrderSet.save(pedido);

    URI uri = URI.create("http://localhost:8080/pedidos/" + p.getId());

    return ResponseEntity.created(uri).build();
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> remove(@PathVariable int id){

    Pedido p = OrderSet.getPedidoById(id);
    
    if(p != null) {
        OrderSet.remove(p);
        return ResponseEntity.noContent().build();	
}

    else {
    return ResponseEntity.notFound().build();
    }
}

@PutMapping("/{id}")
public ResponseEntity<Pedido> update(@PathVariable int id, @RequestBody Pedido pedido){
    
        if(OrderSet.getPedidoById(id) != null) {
                pedido.setID(id);
                pedido = OrderSet.update(pedido);
                return ResponseEntity.ok(pedido);
}

        else {
            return ResponseEntity.notFound().build();
        }
    }  
}

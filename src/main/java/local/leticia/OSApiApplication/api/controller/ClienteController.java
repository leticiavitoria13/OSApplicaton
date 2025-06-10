/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.leticia.OSApiApplication.api.controller;

import java.util.ArrayList;
import java.util.List;
import local.leticia.OSApiApplication.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author ppjatb
 */
@RestController
public class ClienteController {
    
    List<Cliente> listaClientes;
    
    @GetMapping("/clientes")
    public List<Cliente> listas() {
        
        listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1, "Leticia", "leticia@teste.com", "11-9999-9999"));
        listaClientes.add(new Cliente(1,"Maria", "maria@teste.com", "11-88888-8888"));
        listaClientes.add(new Cliente(1, "Joao", "joao@teste.com", "11-77777-7777"));
        
        return listaClientes;
    }
}

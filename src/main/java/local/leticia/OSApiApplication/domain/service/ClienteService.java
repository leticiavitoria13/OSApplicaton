/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.leticia.OSApiApplication.domain.service;

import local.leticia.OSApiApplication.ClienteRepository;
import local.leticia.OSApiApplication.domain.exception.DomainException;
import local.leticia.OSApiApplication.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente salvar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        
        
        
        
        if (clienteExistente !=null && !clienteExistente.equals(cliente)) {
            
            throw new DomainException("Já existe um cliente cadastrado com esse email!");
            
        }
        
        return clienteRepository.save(cliente);
        
    }
    
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.leticia.OSApiApplication.api.controller;

import jakarta.validation.Valid;
import java.util.List;
import local.leticia.OSApiApplication.domain.model.OrdemServico;
import local.leticia.OSApiApplication.domain.repository.OrdemServicoRepository;
import local.leticia.OSApiApplication.domain.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {
    
    @Autowired
    private OrdemServicoService ordemServicoService;
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    @GetMapping
    public List<OrdemServico> listas(){
              
        return ordemServicoRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar (@RequestBody OrdemServico ordemServico){
        return ordemServicoService.criar(ordemServico);
    }
    
     @PutMapping("/{id}")
     public ResponseEntity<OrdemServico> atualizar (@Valid @PathVariable Long id, @RequestBody OrdemServico ordemServico){
     
     
       if (!ordemServicoRepository.existsById(id)){
           return ResponseEntity.notFound().build();
       }
          ordemServico.setId(id);
          ordemServico = ordemServicoService.salvar(ordemServico);
          return ResponseEntity.ok(ordemServico);
       
     }
     
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> excluir (@PathVariable Long id){
     
     
       if (!ordemServicoRepository.existsById(id)){
           return ResponseEntity.notFound().build();
       }
          ordemServicoService.excluir(id);
          return ResponseEntity.noContent().build();
       
     }
    
}
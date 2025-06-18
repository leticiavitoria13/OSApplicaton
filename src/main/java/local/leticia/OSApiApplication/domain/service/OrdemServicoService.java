/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.leticia.OSApiApplication.domain.service;

import java.time.LocalDateTime;
import local.leticia.OSApiApplication.domain.exception.DomainException;
import local.leticia.OSApiApplication.domain.model.OrdemServico;
import local.leticia.OSApiApplication.domain.model.StatusOrdemServico;
import local.leticia.OSApiApplication.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
 */
@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServico criar (OrdemServico ordemServico){
       ordemServico.setStatus(StatusOrdemServico.ABERTA); 
       ordemServico.setDataAbertura(LocalDateTime.now());
       
       return ordemServicoRepository.save(ordemServico);
    }
    
     public OrdemServico salvar (OrdemServico ordemServico){
      OrdemServico ordemServicoExistente = ordemServicoRepository.findById(ordemServico.getId());
       
       if (ordemServicoExistente != null && !ordemServicoExistente.equals(ordemServico)){
           throw new DomainException("Já existe uma ordem de serviço cadastrado com esse Id!");
       }
       return ordemServicoRepository.save(ordemServico);
   }
   
   public void excluir (Long id){
       ordemServicoRepository.deleteById(id);
   }
}

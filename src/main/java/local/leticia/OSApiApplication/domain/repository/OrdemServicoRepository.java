/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.leticia.OSApiApplication.domain.repository;

import java.util.List;
import local.leticia.OSApiApplication.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    
    OrdemServico findById(long id);
    
    @Override
    List<OrdemServico> findAll();
    
}
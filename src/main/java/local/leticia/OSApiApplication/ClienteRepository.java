/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.leticia.OSApiApplication;

import java.util.List;
import local.leticia.OSApiApplication.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ppjatb
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findBynome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);
}

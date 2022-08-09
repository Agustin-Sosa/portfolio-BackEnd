
package com.portfolio.Agustin.Sosa.Repository;

import org.springframework.stereotype.Repository;
import com.portfolio.Agustin.Sosa.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
        
}


package it.contrader.repository;

import it.contrader.domain.Workgroup;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Workgroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WorkgroupRepository extends JpaRepository<Workgroup, Long> {

}

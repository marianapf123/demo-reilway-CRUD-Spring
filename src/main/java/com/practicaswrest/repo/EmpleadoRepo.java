
package com.practicaswrest.repo;

import com.practicaswrest.entity.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, Integer>{
    
    @Query("SELECT e FROM Empleado e ORDER BY e.nombres")
    List<Empleado> findAllOrderByNombre();
    
    @Query(value="SELECT * FROM Empleado ORDER BY codigo", nativeQuery = true)
    List<Empleado> findAllOrderByCodigo();
    
    @Query(value="SELECT * FROM Empleado WHERE nombres LIKE %:filtro%", nativeQuery = true)
    List<Empleado> findByNombre(@Param("filtro") String filtro);
    
    @Query(value = "SELECT say_hello()", nativeQuery = true)
    String createUser();
    
}

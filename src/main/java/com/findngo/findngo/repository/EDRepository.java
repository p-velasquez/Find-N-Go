
package com.findngo.findngo.repository;


import com.findngo.findngo.models.Espaciodeportivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EDRepository extends JpaRepository<Espaciodeportivo, Long> {
    @Query(value = "Select * FROM Espaciodeportivo ed NATURAL JOIN Recinto WHERE " +
            "Recinto.nombre LIKE CONCAT('%',:query,'%')" +
            "Or ed.descripcion LIKE CONCAT('%',:query,'%')", nativeQuery = true)
    List<Espaciodeportivo> buscarED(String query);
}


package com.findngo.findngo.repository;


import com.findngo.findngo.models.Espaciodeportivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Repositorio de Espacio deportivo que extiende de JpaRepository para la implementacion de las query
 */
public interface EDRepository extends JpaRepository<Espaciodeportivo, Long> {
    /**
     * Busqueda principal
     * @param query valor a buscar
     * @return lista de encontrados
     */
    @Query(value = "Select * FROM Espaciodeportivo ed NATURAL JOIN Recinto WHERE " +
            "Recinto.nombre LIKE CONCAT('%',:query,'%')" +
            "Or ed.descripcion LIKE CONCAT('%',:query,'%')", nativeQuery = true)
    List<Espaciodeportivo> buscarED(String query);

    /**
     * Busqueda de id para mostrar datos en pantalla del espacio deportivo
     * @param query valor a buscar
     * @return lista de encontrados
     */
    @Query(value = "Select * FROM Espaciodeportivo ed WHERE ID_ED = :query", nativeQuery = true)
    List<Espaciodeportivo> buscarId(String query);
}

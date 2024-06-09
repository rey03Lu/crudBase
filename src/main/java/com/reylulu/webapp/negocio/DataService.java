package com.reylulu.webapp.negocio;

import com.reylulu.webapp.entidades.Alumno;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author reylulu
 */
@Stateless
public class DataService {
    
    @PersistenceContext(unitName = "pu")
    EntityManager entityManager;
    
    //METODO PARA LISTAR ALUMNOS
    public List<Alumno> getAlumnos(){
        //ORDENA POR ID DESDE EL MENOR HASTA EL MAYOR
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id DESC");
        List<Alumno> alumnos = query.getResultList();
        return alumnos;
    }
    // METODO PARA ALMACENAR ALUMNOS
    @Transactional //PARA QUE SEA ATOMICA
    public void saveAlumno(Alumno alumno){
        entityManager.persist(alumno);
    }
    //METODO PARA MODIFICAR ALUMNOS
    @Transactional
    public void editAlumno(Alumno alumno){
        entityManager.merge(alumno);
    }
    //METODO PARA ELIMINAR ALUMNOS, SI HAY UN ERROR HACE UN ROLLBACK
    @Transactional
    public void deleteAlumno(Alumno alumno){
        Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
        entityManager.remove(alumnoEliminar);
    }
}

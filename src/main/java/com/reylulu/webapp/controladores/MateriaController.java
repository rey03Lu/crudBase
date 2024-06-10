package com.reylulu.webapp.controladores;

import com.reylulu.webapp.entidades.Materia;
import com.reylulu.webapp.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miran
 */
@Named
@RequestScoped
public class MateriaController {
    private List<Materia> materiasList = new ArrayList<>();
    
    private Materia materia = new Materia();
    
    @EJB DataService servicio;
    
    @PostConstruct
    public void cargarMaterias(){
        materiasList = servicio.getMaterias();
    }
    
    public void guardarMateria() {
        if (materia.getId()!=null) {
            servicio.editMateria(materia);
        }else{
            servicio.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }
    
    public void llenarMateriaEditar(Materia materia){
        this.materia.setId(materia.getId());
        this.materia.setCodigo(materia.getCodigo());
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion());
    }
    
    public void eliminarMateria(Materia materia){
        servicio.deleteMateria(materia);
        cargarMaterias();
    }
    
    public List<Materia> getMateriasList(){
        return materiasList;
    }
    
    public void setMateriasList(List<Materia> materiasList){
        this.materiasList = materiasList;
    }
    
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }
}


package com.practicaswrest.controller;

import com.practicaswrest.entity.Empleado;
import com.practicaswrest.service.EmpleadoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/empleados")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoservice;
    
    @GetMapping("/all")
    public List<Empleado> listar(){
        return empleadoservice.listar();
    }
    
    @GetMapping("/{id}")
    public Optional<Empleado> getEmpleado(@PathVariable("id") int empleadoId) {
        return empleadoservice.findById(empleadoId);
    }
    
    @PostMapping("/save")
    public Empleado insertar(@RequestBody Empleado emp){
        return empleadoservice.insertar(emp);
    }
    
    @PutMapping("/update")
    public Empleado actualizar(@RequestBody Empleado emp){
        return empleadoservice.actualizar(emp);
    }
    
    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable("id") int idEmpleado){
        empleadoservice.eliminar(idEmpleado);
    }
    
    @GetMapping("/allOrderByNombre")
    public List<Empleado> findAllOrderByNombre(){
        return empleadoservice.findAllOrderByNombre();
    }
    
    
    @GetMapping("/findAllOrderByCodigo")
    public List<Empleado> findAllOrderByCodigo(){
        return empleadoservice.findAllOrderByCodigo();
    }
    
    @GetMapping("/findByNombre/{filtro}")
    public List<Empleado> findByNombre(@PathVariable("filtro") String filtro){
        return empleadoservice.findByNombre(filtro);
    }
    
    
    @GetMapping("/holaMundo")
    public String createUser() {
      return  empleadoservice.createUser();
    }
    
    @GetMapping("/hola-mundo")
    public String holaMundo(){
        return "Hola Mundo 1";
    }
}

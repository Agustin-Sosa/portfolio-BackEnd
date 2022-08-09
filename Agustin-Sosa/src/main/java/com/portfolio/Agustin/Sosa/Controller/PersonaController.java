
package com.portfolio.Agustin.Sosa.Controller;

import com.portfolio.Agustin.Sosa.Entity.Persona;
import com.portfolio.Agustin.Sosa.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);
        return "La persona fue creada con éxito";
    }
    
    @DeleteMapping("/personas/eliminar/(id)")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada con éxito";
    }
    
    @PutMapping("/personas/editar/(id)")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String newNombre,
                               @RequestParam("apellido") String newApellido,
                               @RequestParam("img") String newImg) {
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(newNombre);
        persona.setApellido(newApellido);
        persona.setImg(newImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
                               
}

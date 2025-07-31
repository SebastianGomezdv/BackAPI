package com.example.APIRegistro.controladores;

import com.example.APIRegistro.modelos.Personajes;
import com.example.APIRegistro.servicios.PersonajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personajes")
public class PersonajeControlador {

    // Llama al servicio
    @Autowired
    PersonajeServicio servicio;

    //Metodo para responder al front
    @PostMapping
    public ResponseEntity<?>responderaAlGuardar(@RequestBody Personajes datosDelFront){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(servicio.guardarPersonaje(datosDelFront));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosPersonajes() {
        try {
            List<Personajes> listaPersonajes = servicio.obtenerTodosLosPersonajes();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(listaPersonajes);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


}
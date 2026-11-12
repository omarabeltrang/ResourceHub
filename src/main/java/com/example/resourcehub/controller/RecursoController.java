package com.example.resourcehub.controller;

import com.example.resourcehub.model.Recurso;
import com.example.resourcehub.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService service;

    @GetMapping
    public List<Recurso> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Recurso buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recurso crear(@RequestBody Recurso recurso) {
        return service.crear(recurso);
    }

    @PutMapping("/{id}")
    public Recurso actualizar(@PathVariable Long id, @RequestBody Recurso recurso) {
        return service.actualizar(id, recurso);
    }

    @PatchMapping("/{id}")
    public Recurso actualizarParcial(@PathVariable Long id, @RequestBody Recurso recurso) {
        return service.actualizarParcial(id, recurso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

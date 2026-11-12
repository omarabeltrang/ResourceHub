package com.example.resourcehub.service;

import com.example.resourcehub.model.Recurso;
import com.example.resourcehub.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository repository;

    public List<Recurso> listar() {
        return repository.findAll();
    }

    public Recurso buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Recurso crear(Recurso recurso) {
        recurso.setId(null);
        return repository.save(recurso);
    }

    public Recurso actualizar(Long id, Recurso recurso) {
        buscar(id);
        recurso.setId(id);
        return repository.save(recurso);
    }

    public Recurso actualizarParcial(Long id, Recurso cambios) {
        Recurso recurso = buscar(id);

        if (cambios.getTitulo() != null) {
            recurso.setTitulo(cambios.getTitulo());
        }
        if (cambios.getUrl() != null) {
            recurso.setUrl(cambios.getUrl());
        }
        if (cambios.getTipo() != null) {
            recurso.setTipo(cambios.getTipo());
        }
        if (cambios.getCategoria() != null) {
            recurso.setCategoria(cambios.getCategoria());
        }

        return repository.save(recurso);
    }

    public void eliminar(Long id) {
        if (!repository.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

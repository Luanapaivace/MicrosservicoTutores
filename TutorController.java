package com.univet.br.tutor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univet.br.tutor.model.Tutor;
import com.univet.br.tutor.service.TutorService;

@RestController
@RequestMapping("/tutores")
@CrossOrigin(origins = "*")
public class TutorController {

    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tutor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Tutor buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Tutor cadastrar(@RequestBody Tutor tutor) {
        return service.cadastrar(tutor);
    }

    @PutMapping("/{id}")
    public Tutor atualizar(@PathVariable String id, @RequestBody Tutor tutor) {
        return service.atualizar(id, tutor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }
}

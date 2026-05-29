package com.univet.br.tutor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.univet.br.tutor.model.Tutor;
import com.univet.br.tutor.repository.TutorRepository;

@Service
public class TutorService {

    private final TutorRepository repository;

    public TutorService(TutorRepository repository) {
        this.repository = repository;
    }

    public List<Tutor> listarTodos() {
        return repository.findAll();
    }

    public Tutor buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado: " + id));
    }

    public Tutor cadastrar(Tutor tutor) {
        validarCamposObrigatorios(tutor);

        if (repository.existsByCpf(tutor.getCpf())) {
            throw new RuntimeException("Já existe um tutor cadastrado com este CPF.");
        }

        return repository.save(tutor);
    }

    public Tutor atualizar(String id, Tutor tutorAtualizado) {
        Tutor tutor = buscarPorId(id);

        validarCamposObrigatorios(tutorAtualizado);

        tutor.setNomeCompletoTutor(tutorAtualizado.getNomeCompletoTutor());
        tutor.setCpf(tutorAtualizado.getCpf());
        tutor.setTelefone(tutorAtualizado.getTelefone());
        tutor.setRua(tutorAtualizado.getRua());
        tutor.setNumero(tutorAtualizado.getNumero());
        tutor.setBairro(tutorAtualizado.getBairro());

        return repository.save(tutor);
    }

    public void deletar(String id) {
        Tutor tutor = buscarPorId(id);
        repository.delete(tutor);
    }

    private void validarCamposObrigatorios(Tutor tutor) {
        if (tutor.getNomeCompletoTutor() == null || tutor.getNomeCompletoTutor().isBlank()) {
            throw new RuntimeException("O nome do tutor é obrigatório!");
        }
        if (tutor.getCpf() == null || tutor.getCpf().isBlank()) {
            throw new RuntimeException("O CPF é obrigatório!");
        }
        if (!tutor.getCpf().matches("\\d{11}")) {
            throw new RuntimeException("CPF inválido. Informe apenas os 11 dígitos numéricos.");
        }
        if (tutor.getTelefone() == null || tutor.getTelefone().isBlank()) {
            throw new RuntimeException("O telefone é obrigatório!");
        }
        if (tutor.getRua() == null || tutor.getRua().isBlank()) {
            throw new RuntimeException("A rua é obrigatória!");
        }
        if (tutor.getNumero() == null || tutor.getNumero().isBlank()) {
            throw new RuntimeException("O número é obrigatório!");
        }
        if (tutor.getBairro() == null || tutor.getBairro().isBlank()) {
            throw new RuntimeException("O bairro é obrigatório!");
        }
    }
}

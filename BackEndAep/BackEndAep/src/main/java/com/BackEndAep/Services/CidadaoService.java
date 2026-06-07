package com.BackEndAep.Services;

import com.BackEndAep.model.Cidadao;
import com.BackEndAep.repository.CidadaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CidadaoService {

    private final CidadaoRepository repository;

    public CidadaoService(CidadaoRepository repository) {
        this.repository = repository;
    }

    public List<Cidadao> listar() {
        return repository.findAll();
    }

    public Cidadao buscar(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Cidadão não encontrado"));
    }

    public Cidadao salvar(Cidadao cidadao) {
        return repository.save(cidadao);
    }

    public Cidadao atualizar(Integer id, Cidadao dados) {
        Cidadao cidadao = buscar(id);

        cidadao.setNome(dados.getNome());

        cidadao.setCpf(dados.getCpf());

        if (dados.getSenha() != null &&
                !dados.getSenha().isBlank()) {
            cidadao.setSenha(dados.getSenha());
        }

        return repository.save(cidadao);
    }

    public void excluir(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cidadão não encontrado");
        }

        repository.deleteById(id);
    }
}

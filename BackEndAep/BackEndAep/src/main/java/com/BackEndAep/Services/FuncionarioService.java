package com.BackEndAep.Services;
import com.BackEndAep.model.Funcionario;
import com.BackEndAep.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> listar() {
        return repository.findAll();
    }

    public Funcionario buscar(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Funcionário não encontrado"));
    }

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Funcionario atualizar(Integer id, Funcionario dados) {
        Funcionario funcionario = buscar(id);

        funcionario.setNome(dados.getNome());

        funcionario.setMatricula(dados.getMatricula());

        if (dados.getSenha() != null &&
                !dados.getSenha().isBlank()) {
            funcionario.setSenha(dados.getSenha());
        }

        return repository.save(funcionario);
    }

    public void excluir(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado");
        }

        repository.deleteById(id);
    }
}
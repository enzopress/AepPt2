package com.BackEndAep.Services;

import com.BackEndAep.model.Cidadao;
import com.BackEndAep.model.Funcionario;
import com.BackEndAep.model.LoginResponse;
import com.BackEndAep.model.Usuario;
import com.BackEndAep.repository.CidadaoRepository;
import com.BackEndAep.repository.FuncionarioRepository;
import com.BackEndAep.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository repository;
    private final CidadaoRepository cidadaoRepository;
    private final FuncionarioRepository funcionarioRepository;


    public UsuarioService(
            CidadaoRepository cidadaoRepository,
            FuncionarioRepository funcionarioRepository,UsuarioRepository repository) {

        this.cidadaoRepository = cidadaoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.repository = repository;
    }
    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscar(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Integer id, Usuario dados) {
        Usuario usuario = buscar(id);

        usuario.setNome(dados.getNome());


        if (dados.getSenha() != null &&
                !dados.getSenha().isBlank()) {
            usuario.setSenha(dados.getSenha());
        }

        return repository.save(usuario);
    }

    public void excluir(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        repository.deleteById(id);
    }


    public LoginResponse loginCidadao(
            String cpf,
            String senha) {

        Cidadao cidadao = cidadaoRepository
                .findByCpf(cpf)
                .orElseThrow(() ->
                        new RuntimeException("CPF não encontrado"));

        if (!cidadao.getSenha().equals(senha)) {
            throw new RuntimeException("Senha inválida");
        }

        return new LoginResponse(
                true,
                "Login realizado com sucesso",
                cidadao.getNome(),
                "CIDADAO",
                cidadao.getCpf()
        );
    }

    public LoginResponse loginFuncionario(
            String matricula,
            String senha) {

        Funcionario funcionario = funcionarioRepository
                .findByMatricula(matricula)
                .orElseThrow(() ->
                        new RuntimeException("Matrícula não encontrada"));

        if (!funcionario.getSenha().equals(senha)) {
            throw new RuntimeException("Senha inválida");
        }

        return new LoginResponse(
                true,
                "Login realizado com sucesso",
                funcionario.getNome(),
                "FUNCIONARIO",
                funcionario.getMatricula()
        );
    }

}
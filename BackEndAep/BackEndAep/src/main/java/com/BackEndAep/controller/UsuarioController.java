package com.BackEndAep.controller;

import com.BackEndAep.Services.CidadaoService;
import com.BackEndAep.Services.FuncionarioService;
import com.BackEndAep.Services.UsuarioService;
import com.BackEndAep.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final CidadaoService cidadaoService;
    private final FuncionarioService funcionarioService;

    public UsuarioController(
            UsuarioService usuarioService,
            CidadaoService cidadaoService,
            FuncionarioService funcionarioService) {
        this.usuarioService = usuarioService;
        this.cidadaoService = cidadaoService;
        this.funcionarioService = funcionarioService;

    }
    //
    // LOGIN
    //
    @PostMapping("/login-cidadao")
    public ResponseEntity<LoginResponse> loginCidadao(
            @RequestBody LoginCidadaoRequest request) {

        return ResponseEntity.ok(
                usuarioService.loginCidadao(
                        request.getCpf(),
                        request.getSenha()));
    }

    @PostMapping("/login-funcionario")
    public ResponseEntity<LoginResponse> loginFuncionario(
            @RequestBody LoginFuncionarioRequest request) {

        return ResponseEntity.ok(
                usuarioService.loginFuncionario(
                        request.getMatricula(),
                        request.getSenha()));
    }
    // ==========================
    // USUÁRIO
    // ==========================

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    // ==========================
    // CIDADÃO
    // ==========================

    @GetMapping("/cidadaos")
    public ResponseEntity<List<Cidadao>> listarCidadaos() {
        return ResponseEntity.ok(cidadaoService.listar());
    }

    @GetMapping("/cidadaos/{id}")
    public ResponseEntity<Cidadao> buscarCidadao(@PathVariable Integer id) {
        return ResponseEntity.ok(cidadaoService.buscar(id));
    }

    @PostMapping("/cidadaos")
    public ResponseEntity<Cidadao> criarCidadao(
            @RequestBody CadastroRequest request) {

        Cidadao cidadao = new Cidadao();

        cidadao.setNome(request.getNome());
        cidadao.setCpf(request.getIdentificador());
        cidadao.setSenha(request.getSenha());

        return ResponseEntity.ok(
                cidadaoService.salvar(cidadao));
    }

    @PutMapping("/cidadaos/{id}")
    public ResponseEntity<Cidadao> atualizarCidadao(
            @PathVariable Integer id,
            @RequestBody Cidadao cidadao) {

        return ResponseEntity.ok(cidadaoService.atualizar(id, cidadao));
    }

    @DeleteMapping("/cidadaos/{id}")
    public ResponseEntity<Void> excluirCidadao(@PathVariable Integer id) {
        cidadaoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    // ==========================
    // FUNCIONÁRIO
    // ==========================

    @GetMapping("/funcionarios")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return ResponseEntity.ok(funcionarioService.listar());
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> buscarFuncionario(@PathVariable Integer id) {
        return ResponseEntity.ok(funcionarioService.buscar(id));
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<Funcionario> criarFuncionario(
            @RequestBody CadastroRequest request) {

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(request.getNome());
        funcionario.setMatricula(request.getIdentificador());
        funcionario.setSenha(request.getSenha());

        return ResponseEntity.ok(
                funcionarioService.salvar(funcionario));
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(
            @PathVariable Integer id,
            @RequestBody Funcionario funcionario) {

        return ResponseEntity.ok(
                funcionarioService.atualizar(id, funcionario));
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Void> excluirFuncionario(
            @PathVariable Integer id) {

        funcionarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

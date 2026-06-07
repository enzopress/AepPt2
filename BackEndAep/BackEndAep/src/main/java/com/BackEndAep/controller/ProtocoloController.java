package com.BackEndAep.controller;



import com.BackEndAep.Services.ProtocoloService;
import com.BackEndAep.model.Protocolo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/protocolos")
public class ProtocoloController {

    private final ProtocoloService service;

    public ProtocoloController(ProtocoloService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Protocolo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Protocolo> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Protocolo> criar(@RequestBody Protocolo protocolo) {
        System.out.println("ID recebido: " + protocolo.getNumeroProtocolo());
        return ResponseEntity.ok(service.salvar(protocolo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Protocolo> atualizar(
            @PathVariable Integer id,
            @RequestBody Protocolo protocolo) {

        return ResponseEntity.ok(service.atualizar(id, protocolo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
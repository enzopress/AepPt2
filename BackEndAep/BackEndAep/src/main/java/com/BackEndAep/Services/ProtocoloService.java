package com.BackEndAep.Services;
import com.BackEndAep.model.Protocolo;
import com.BackEndAep.repository.ProtocoloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProtocoloService {
        private final ProtocoloRepository repository;

        public ProtocoloService(ProtocoloRepository repository) {
            this.repository = repository;
        }


        public List<Protocolo> listarTodos() {
            return repository.findAll();
        }


        public Protocolo buscarPorId(Integer id) {
            return repository.findById(id)
                    .orElseThrow(() ->
                            new RuntimeException("Protocolo não encontrado: " + id));
        }


        public Protocolo salvar(Protocolo protocolo) {
            return repository.save(protocolo);
        }

        public Protocolo atualizar(Integer id, Protocolo protocolo) {

            Protocolo existente = buscarPorId(id);

            existente.setTipo(protocolo.getTipo());
            existente.setDescricao(protocolo.getDescricao());
            existente.setCep(protocolo.getCep());
            existente.setRua(protocolo.getRua());
            existente.setNumero(protocolo.getNumero());
            existente.setBairro(protocolo.getBairro());
            existente.setComplemento(protocolo.getComplemento());
            existente.setStatus(protocolo.getStatus());

            return repository.save(existente);
        }

        public void excluir(Integer id) {

            if (!repository.existsById(id)) {
                throw new RuntimeException("Protocolo não encontrado: " + id);
            }

            repository.deleteById(id);
        }

}

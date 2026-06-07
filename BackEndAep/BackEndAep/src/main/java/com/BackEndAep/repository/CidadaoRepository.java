package com.BackEndAep.repository;


import com.BackEndAep.model.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadaoRepository extends JpaRepository<Cidadao, Integer> {
    Optional<Cidadao> findByCpf(String cpf);
}

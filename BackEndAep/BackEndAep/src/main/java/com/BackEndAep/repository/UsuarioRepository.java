package com.BackEndAep.repository;

import com.BackEndAep.model.Protocolo;
import com.BackEndAep.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

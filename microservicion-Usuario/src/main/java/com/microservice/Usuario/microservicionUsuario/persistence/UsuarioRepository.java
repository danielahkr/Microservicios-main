package com.microservice.Usuario.microservicionUsuario.persistence;

import com.microservice.Usuario.microservicionUsuario.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {


}
package com.example.mobile_back_end.resource;

import ads4.fatesg.pbbellavisage.dto.LoginDto;
import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Usuario;
import ads4.fatesg.pbbellavisage.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/usuario")
public class UsuarioResource implements GenericOperations<Usuario, Integer> {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Usuario create(@Valid @RequestBody Usuario entity) {
        return usuarioService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Usuario read(@PathVariable  Integer id) {
        return usuarioService.read(id);
    }

    @GetMapping(
            value = "/email",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public boolean existsEmail(@RequestParam String email) {
        return usuarioService.existsUsuarioPorEmail(email);
    }

    @PostMapping(
            value = "/logar",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public boolean existsLogin(@RequestBody LoginDto request) {
        String email = request.getEmail();
        String senha = request.getSenha();
        return usuarioService.existsUsuario(email,senha);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )

    @Override
    public List<Usuario> readAll() {
        return usuarioService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Usuario updatePart(@PathVariable  Integer id, @Valid @RequestBody Usuario entity) {
        return usuarioService.updatePart(id,entity);
    }

    @PatchMapping(
            value = "/email",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Usuario updatePassword(@RequestBody LoginDto request) {
        String email = request.getEmail();
        String senha = request.getSenha();
        return usuarioService.updatePartPassword(email,senha);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Usuario updateAll(@PathVariable Integer id, @Valid @RequestBody Usuario entity) {
        return usuarioService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        usuarioService.delete(id);
    }
}

package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.UsuarioRepository;
import com.api.ppp.back.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer> implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return repository.findByCorreo(correo);
    }

    @Override
    public Usuario usuarioxcedula(String cedula) {
        return (Usuario) repository.findByCedula(cedula).orElse(null);
    }
}

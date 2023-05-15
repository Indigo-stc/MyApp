package com.api.ppp.fenix.fservices;

import com.api.ppp.fenix.fdaos.UsuarioFenixRepository;
import com.api.ppp.fenix.fmodels.UsuarioFenix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UsuarioFenixImpl implements UsuarioFenixService{

    @Autowired
    private UsuarioFenixRepository usuarioFenixRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioFenix> findAll() {
        return (List<UsuarioFenix>) usuarioFenixRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioFenix findByCedula(String cedula) {
        return (UsuarioFenix) usuarioFenixRepository.findByCedula(cedula).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioFenix findByCedulaEstudiante(String cedula) {
        return (UsuarioFenix) usuarioFenixRepository.findByCedulaAndTipo(cedula,1).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioFenix findByNombresAndCorreoAndTipo(String nombres, String correo, Integer tipo) {
        return (UsuarioFenix) usuarioFenixRepository.findByNombresAndCorreoAndTipo(nombres,correo,tipo).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioFenix findByNombresAndCorreoAlumnos(String nombres, String correo) {
        return (UsuarioFenix) usuarioFenixRepository.findByNombresAndCorreoAndTipo(nombres,correo,1).orElse(null);
    }



}

package com.senac.daniela.gerenciamentosalas.services;

import com.senac.daniela.gerenciamentosalas.dto.AmbienteDTO;
import com.senac.daniela.gerenciamentosalas.dto.UsuarioDTO;
import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import com.senac.daniela.gerenciamentosalas.entities.Usuario;
import com.senac.daniela.gerenciamentosalas.exceptions.AmbienteNotFoundException;
import com.senac.daniela.gerenciamentosalas.repository.AmbienteRepository;
import com.senac.daniela.gerenciamentosalas.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        modelMapper.map(usuarioDTO, usuario);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.getAllUsuarios();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.getUsuarioAtivoById(id).orElseThrow(()-> new AmbienteNotFoundException("Usuário não encontrado"));
    }

    @Transactional
    public Usuario updateUsuario(int id, UsuarioDTO usuarioDTO) {
        Usuario usuario = this.getUsuarioById(id);
        modelMapper.map(usuarioDTO, usuario);

        return usuarioRepository.save(usuario);

    }

    public void deleteUsuario(int id) {
        Usuario usuario = this.getUsuarioById(id);
        usuarioRepository.markAsDeleteUsuario(id);
    }
}

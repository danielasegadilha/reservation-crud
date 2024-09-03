package com.senac.daniela.gerenciamentosalas.services;

import com.senac.daniela.gerenciamentosalas.dto.UsuarioDTO;
import com.senac.daniela.gerenciamentosalas.entities.Usuario;
import com.senac.daniela.gerenciamentosalas.exceptions.UsuarioNotFoundException;
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
    public Usuario createUsuario(Integer criadorId, UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        Usuario responsavel = this.getUsuarioById(criadorId);
        usuario.setResponsavelId(responsavel);

        modelMapper.map(usuarioDTO, usuario);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.getAllUsuarios();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.getUsuarioAtivoById(id).orElseThrow(()-> new UsuarioNotFoundException("Usuário não encontrado"));
    }

    @Transactional
    public Usuario updateUsuario(int id, UsuarioDTO usuarioDTO) {
        Usuario usuario = this.getUsuarioById(id);
        modelMapper.map(usuarioDTO, usuario);

        return usuarioRepository.save(usuario);

    }

    public void deleteUsuario(int id) {
        this.getUsuarioById(id);
        usuarioRepository.markAsDeleteUsuario(id);
    }
}

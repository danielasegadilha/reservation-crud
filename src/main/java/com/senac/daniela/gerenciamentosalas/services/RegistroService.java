package com.senac.daniela.gerenciamentosalas.services;

import com.senac.daniela.gerenciamentosalas.dto.RegistroDTO;
import com.senac.daniela.gerenciamentosalas.entities.Registro;
import com.senac.daniela.gerenciamentosalas.entities.Usuario;
import com.senac.daniela.gerenciamentosalas.exceptions.RegistroNotFoundException;
import com.senac.daniela.gerenciamentosalas.repository.RegistroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;

    private UsuarioService usuarioService;

    private final ModelMapper modelMapper;

    public RegistroService(RegistroRepository registroRepository, UsuarioService usuarioService, ModelMapper modelMapper) {
        this.registroRepository = registroRepository;
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Registro createRegistro(RegistroDTO registroDTO) {
        Registro registro = new Registro();

        Usuario usuario = usuarioService.getUsuarioById(registroDTO.getUsuarioRetiradaId());
        registro.setUsuarioRetirada(usuario);

        modelMapper.map(registroDTO, registro);

        return registroRepository.save(registro);
    }

    public List<Registro> getAllRegistros() {
        return registroRepository.getAllRegistros();
    }

    public Registro getRegistroById(int id) {
        return registroRepository.getRegistroAtivoById(id).orElseThrow(()-> new RegistroNotFoundException("Registro não encontrado"));
    }

    @Transactional
    public Registro updateRegistro(int id, RegistroDTO registroDTO) {
        Registro registro = this.getRegistroById(id);
        modelMapper.map(registroDTO, registro);

        return registroRepository.save(registro);

    }

    public void deleteRegistro(int id) {
        this.getRegistroById(id);
        registroRepository.markAsDeleteRegistro(id);
    }
}

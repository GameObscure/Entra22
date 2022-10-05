package com.geral.empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geral.empresa.domain.Funcionario;
import com.geral.empresa.exceptions.ObjectNotFoundException;
import com.geral.empresa.repositories.FuncionarioRepository;

@Service
public class FuncServices {

    @Autowired
    private FuncionarioRepository fRepository;

    public List<Funcionario> findAll() {
        return fRepository.findAll();
    }

    public Funcionario findById(Integer id) {
        Optional<Funcionario> funcionario = fRepository.findById(id);
        return funcionario.orElseThrow(
            () -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Funcionario.class.getName())
        );
    }
    
}

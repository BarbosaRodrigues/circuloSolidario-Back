package br.edu.ifsp.circulosolidario.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.circulosolidario.model.Doador;
import br.edu.ifsp.circulosolidario.repository.DoadorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    DoadorRepository doadorRepository;

    @Override
    public UserDetails loadUserByUsername(String email){
        // Encontra um usuário no banco de dados
        Doador doador = doadorRepository.findByEmail(email).stream().findFirst().get();
        // Depois retorna um objeto UserDetailsImpl com base no usuário encontrado
        return new UserDetailsImpl(doador);        
    } 
}

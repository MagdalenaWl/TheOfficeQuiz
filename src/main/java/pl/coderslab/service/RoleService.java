package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Role;
import pl.coderslab.repository.RoleRepository;

@Service
@AllArgsConstructor
public class RoleService {
    RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findFirstByName(name);
    }
}

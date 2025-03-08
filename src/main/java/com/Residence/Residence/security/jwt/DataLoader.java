package com.Residence.Residence.security.jwt;


import com.Residence.Residence.Entities.ERole;
import com.Residence.Residence.Entities.Role;
import com.Residence.Residence.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insert roles if they don't exist
        if (roleRepository.findByName(ERole.Resident).isEmpty()) {
            roleRepository.save(new Role(ERole.Resident));
        }
        if (roleRepository.findByName(ERole.ADMIN).isEmpty()) {
            roleRepository.save(new Role(ERole.ADMIN));
        }
        if (roleRepository.findByName(ERole.Technicien).isEmpty()) {
            roleRepository.save(new Role(ERole.Technicien));
        }
    }
}
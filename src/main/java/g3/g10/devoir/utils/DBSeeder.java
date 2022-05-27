package g3.g10.devoir.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import g3.g10.devoir.models.Admin;
import g3.g10.devoir.models.Client;
import g3.g10.devoir.models.Dev;
import g3.g10.devoir.repo.UserRepo;

@Component
public class DBSeeder implements CommandLineRunner {

    @Autowired
    private UserRepo<Admin> aRepo;
    @Autowired
    private UserRepo<Dev> dRepo;
    @Autowired
    private UserRepo<Client> cRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (aRepo.findAll().isEmpty()) {
            Admin admin = new Admin();
            admin.setDisplayName("admin");
            admin.setEmail("admin@mail.com");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRole(Constants.getRole("admin"));
            aRepo.save(admin);

            Client client = new Client();
            client.setDisplayName("outhmane");
            client.setEmail("outhmane@mail.com");
            client.setPassword(passwordEncoder.encode("123456"));
            client.setRole(Constants.getRole("client"));
            cRepo.save(client);
        
            Dev dev = new Dev();
            dev.setDisplayName("imane");
            dev.setEmail("imane@mail.com");
            dev.setPassword(passwordEncoder.encode("1234567"));
            dev.setRole(Constants.getRole("dev"));
            dRepo.save(dev);
        }
    }

}


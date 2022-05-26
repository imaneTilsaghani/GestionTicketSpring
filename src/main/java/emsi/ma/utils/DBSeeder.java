package emsi.ma.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import emsi.ma.models.Admin;
import emsi.ma.models.Client;
import emsi.ma.models.Dev;
import emsi.ma.repo.UserRepo;

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
            client.setDisplayName("yahya");
            client.setEmail("yahya@mail.com");
            client.setPassword(passwordEncoder.encode("yahya"));
            client.setRole(Constants.getRole("client"));
            cRepo.save(client);
        
            Dev dev = new Dev();
            dev.setDisplayName("haddi");
            dev.setEmail("haddi@mail.com");
            dev.setPassword(passwordEncoder.encode("haddi"));
            dev.setRole(Constants.getRole("dev"));
            dRepo.save(dev);
        }
    }

}


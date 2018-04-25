package net.boddin.clouddemo;

import net.boddin.clouddemo.entity.User;
import net.boddin.clouddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ExampleDataprovider implements ApplicationRunner {

    private final UserRepository repository;

    @Autowired
    public ExampleDataprovider(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) {
        repository.save(new User("John", "Wick"));
        repository.save(new User("Mister", "Miagi"));
        repository.save(new User("Tyler", "Durden"));
        repository.save(new User("Denny", "Crane"));
        repository.save(new User("Sheldon", "Cooper"));
    }
}

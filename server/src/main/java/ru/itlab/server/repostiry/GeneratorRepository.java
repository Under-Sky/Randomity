package ru.itlab.server.repostiry;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itlab.server.model.entity.Generator;
import ru.itlab.server.model.entity.User;

import java.util.List;

@Repository
public interface GeneratorRepository extends JpaRepository<Generator, Long> {

    List<Generator> findAllByUsers(User user);
}

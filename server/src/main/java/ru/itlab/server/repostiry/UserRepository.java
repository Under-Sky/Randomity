package ru.itlab.server.repostiry;

import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itlab.server.model.entity.Generator;
import ru.itlab.server.model.entity.TechnicalInfo;
import ru.itlab.server.model.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);

    Optional<User> findByTechnicalInfo_UuidToConfirmEquals(UUID uuidToConfirm);
}

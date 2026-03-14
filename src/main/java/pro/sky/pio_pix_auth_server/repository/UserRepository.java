package pro.sky.pio_pix_auth_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.pio_pix_auth_server.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByName(String name);

}

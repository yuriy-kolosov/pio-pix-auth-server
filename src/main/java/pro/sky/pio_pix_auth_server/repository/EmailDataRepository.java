package pro.sky.pio_pix_auth_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.pio_pix_auth_server.entity.EmailDataEntity;

import java.util.Optional;

public interface EmailDataRepository extends JpaRepository<EmailDataEntity, Long> {

    Optional<EmailDataEntity> findByEmail(String email);

}

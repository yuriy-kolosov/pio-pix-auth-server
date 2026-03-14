package pro.sky.pio_pix_auth_server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pro.sky.pio_pix_auth_server.entity.EmailDataEntity;
import pro.sky.pio_pix_auth_server.entity.UserEntity;
import pro.sky.pio_pix_auth_server.repository.EmailDataRepository;
import pro.sky.pio_pix_auth_server.repository.UserRepository;

@Configuration
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final EmailDataRepository emailDataRepository;

    public CustomUserDetailsService(UserRepository userRepository, EmailDataRepository emailDataRepository) {
        this.userRepository = userRepository;
        this.emailDataRepository = emailDataRepository;
    }

    @Override
    public UserEntity loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        EmailDataEntity emailDataEntity = emailDataRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с email " + userEmail + " не найден"));
        return emailDataEntity.getUser();
    }

}

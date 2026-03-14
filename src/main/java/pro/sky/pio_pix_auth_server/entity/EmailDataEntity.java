package pro.sky.pio_pix_auth_server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "email_data")
public class EmailDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "email")
    private String email;

    public EmailDataEntity() {
    }

    public EmailDataEntity(Long id, UserEntity user, String email) {
        this.id = id;
        this.user = user;
        this.email = email;
    }

    public UserEntity getUser() {
        return user;
    }

}

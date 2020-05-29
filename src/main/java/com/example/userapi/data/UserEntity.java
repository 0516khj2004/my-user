package com.example.userapi.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class UserEntity  implements Serializable {
    @Id
    @GeneratedValue
    private  Long id;

    @Column(nullable = false , length = 50) // null 허용 X
    private String name;
    @Column(nullable = false , length = 120, unique = true) // null 허용 X
    private String email;
    @Column(nullable = false , unique = true) // null 허용 X
    private String userId;
    private LocalDateTime createdAt;
    @Column(nullable = false , unique = true) // null 허용 X
    private String encryptedPassword;

    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
    }
}

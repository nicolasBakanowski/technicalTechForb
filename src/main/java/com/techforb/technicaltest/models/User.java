package com.techforb.technicaltest.models;
import javax.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "number_document", nullable = false)
    private String numberDocument;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile_image", nullable = false)
    private String profileImage;

    @Column(name = "type_document_id", nullable = false)
    private Long typeDocumentId;

    @ManyToOne
    @JoinColumn(name = "type_document_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TypeDocument typeDocument;

     public void hashPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(this.password);
    }

}

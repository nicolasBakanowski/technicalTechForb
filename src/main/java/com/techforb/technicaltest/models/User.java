package com.techforb.technicaltest.models;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
    @NotNull(message = "El nombre no puede estar en blanco")
    @Size(max = 255, message = "El nombre no puede tener más de 255 caracteres")
    @Column(name = "name", nullable = false)
    private String name;
   
    @NotNull(message = "El apellido no puede estar en blanco")
    @Size(max = 255, message = "El apellido no puede tener más de 255 caracteres")
    @Column(name = "last_name", nullable = false)   
    private String lastName;
    
    @NotNull(message = "El número de documento no puede estar en blanco")
    @Size(max = 20, message = "El número de documento no puede tener más de 20 caracteres")
    @Column(name = "number_document", nullable = false)
    private String numberDocument;

    @NotNull(message = "La contraseña no puede estar en blanco")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Column(name = "password", nullable = false)
    private String password;
   
    @Column(name = "profile_image", nullable = true)
    private String profileImage;
     
    @NotNull(message = "El ID del tipo de documento no puede ser nulo")
    @Column(name = "type_document_id", nullable = false)
    private Long typeDocumentId;

    @ManyToOne
    @JoinColumn(name = "type_document_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TypeDocument typeDocument;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Long getTypeDocumentId() {
        return typeDocumentId;
    }

    public void setTypeDocumentId(Long typeDocumentId) {
        this.typeDocumentId = typeDocumentId;
    }

    public TypeDocument getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(TypeDocument typeDocument) {
        this.typeDocument = typeDocument;
    }

     public void hashPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(this.password);
    }

}

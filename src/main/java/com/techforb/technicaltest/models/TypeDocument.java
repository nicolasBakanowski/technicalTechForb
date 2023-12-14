package com.techforb.technicaltest.models;
import javax.persistence.*;

@Entity
@Table(name = "typedocument")
public class TypeDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;
}
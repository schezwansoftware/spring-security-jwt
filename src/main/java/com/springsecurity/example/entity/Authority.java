package com.springsecurity.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor()
@AllArgsConstructor()
@Data()
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String authority;
}

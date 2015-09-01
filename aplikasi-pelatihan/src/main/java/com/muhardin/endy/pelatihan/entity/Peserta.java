package com.muhardin.endy.pelatihan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Peserta {
    @Id
    private String id;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(nullable = false, unique = true)
    private String email;
}

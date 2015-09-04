package com.muhardin.endy.pelatihan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "materi")
public class Materi {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false, unique = true, length = 10)
    private String kode;
    
    @Column(nullable = false)
    private String nama;
    
    @JsonIgnore
    @OneToMany(
        cascade = CascadeType.ALL, 
        orphanRemoval = true,
        mappedBy = "materi"
    )
    private List<Sesi> daftarSesi = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Sesi> getDaftarSesi() {
        return daftarSesi;
    }

    public void setDaftarSesi(List<Sesi> daftarSesi) {
        this.daftarSesi = daftarSesi;
    }
    
    
}

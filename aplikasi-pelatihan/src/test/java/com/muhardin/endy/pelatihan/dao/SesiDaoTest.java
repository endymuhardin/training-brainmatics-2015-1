package com.muhardin.endy.pelatihan.dao;

import com.muhardin.endy.pelatihan.AplikasiPelatihanApplication;
import com.muhardin.endy.pelatihan.entity.Materi;
import com.muhardin.endy.pelatihan.entity.Peserta;
import com.muhardin.endy.pelatihan.entity.Sesi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AplikasiPelatihanApplication.class)
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = {"/data/peserta.sql", "/data/materi.sql", "/data/sesi.sql"}
)
public class SesiDaoTest {
    
    @Autowired
    private SesiDao sd;
    
    @Autowired
    private DataSource ds;
    
    @Test
    public void testCariByMateri(){
        Materi m = new Materi();
        m.setId("aa6");
        
        PageRequest page = new PageRequest(0, 5);
        
        Page<Sesi> hasilQuery = sd.findByMateri(m, page);
        Assert.assertEquals(2L, hasilQuery.getTotalElements());
        
        Assert.assertFalse(hasilQuery.getContent().isEmpty());
        Sesi s = hasilQuery.getContent().get(0);
        Assert.assertNotNull(s);
        Assert.assertEquals("Java Fundamental", s.getMateri().getNama());
    }
    
    @Test
    public void testCariBerdasarkanTanggalMulaiDanKodeMateri() throws Exception {
        PageRequest page = new PageRequest(0, 5);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sejak = formatter.parse("2015-01-01");
        Date sampai = formatter.parse("2015-01-03");
        
        
        Page<Sesi> hasil = sd.cariBerdasarkanTanggalMulaiDanKodeMateri(
                sejak, sampai, "JF-002", page);
        
        Assert.assertEquals(1L, hasil.getTotalElements());
        Assert.assertFalse(hasil.getContent().isEmpty());
        
        Sesi s = hasil.getContent().get(0);
        Assert.assertEquals("Java Web", s.getMateri().getNama());
    }
    
    @Test
    public void testSaveSesi() throws Exception {
        Peserta p1 = new Peserta();
        p1.setId("aa1");
        
        Peserta p2 = new Peserta();
        p2.setId("aa3");
        
        Materi m = new Materi();
        m.setId("aa8");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sejak = formatter.parse("2015-02-01");
        Date sampai = formatter.parse("2015-02-03");
        
        Sesi s = new Sesi();
        s.setMateri(m);
        s.setMulai(sejak);
        s.setSampai(sampai);
        s.getDaftarPeserta().add(p1);
        s.getDaftarPeserta().add(p2);
        
        sd.save(s);
        String idSesiBaru = s.getId();
        Assert.assertNotNull(idSesiBaru);
        System.out.println("ID Baru : "+s.getId());
        
        String sql = "select count(*) from sesi where id_materi='aa8'";
        String sqlManyToMany = "select count(*) from peserta_pelatihan "
                + "where id_sesi=?";
        
        try(Connection c = ds.getConnection()){
            // cek tabel sesi
            ResultSet rs = c.createStatement()
                    .executeQuery(sql);
            Assert.assertTrue(rs.next());
            Assert.assertEquals(1L, rs.getLong(1));
            
            // cek tabel relasi many to many dengan peserta
            PreparedStatement ps = c.prepareStatement(sqlManyToMany);
            ps.setString(1, idSesiBaru);
            ResultSet rs2 = ps.executeQuery();
            
            Assert.assertTrue(rs2.next());
            Assert.assertEquals(2L, rs2.getLong(1));
        }
    }
}

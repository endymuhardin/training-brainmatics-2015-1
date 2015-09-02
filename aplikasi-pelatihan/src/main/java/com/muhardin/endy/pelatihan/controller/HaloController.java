package com.muhardin.endy.pelatihan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaloController {
    
    @RequestMapping("/halo")
    public Map<String, Object> halo(
            @RequestParam(value="nama", required = false) String nama){
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("nama", nama);
        hasil.put("waktu", new Date());
        return hasil;
    }
}

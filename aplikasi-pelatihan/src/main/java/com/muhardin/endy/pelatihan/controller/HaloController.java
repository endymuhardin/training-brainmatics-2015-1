package com.muhardin.endy.pelatihan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HaloController {
    
    @RequestMapping("/halorest")
    @ResponseBody
    public Map<String, Object> haloRest(
            @RequestParam(value="nama", required = false) String nama){
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("nama", nama);
        hasil.put("waktu", new Date());
        return hasil;
    }
    
    @RequestMapping("/halo")
    public void haloHtml(@RequestParam(value="nama", required = false) String nama, 
            Model hasil){
        hasil.addAttribute("nama", nama);
        hasil.addAttribute("waktu", new Date());
    }
}

package com.muhardin.endy.pelatihan.controller;

import com.muhardin.endy.pelatihan.dao.PesertaDao;
import com.muhardin.endy.pelatihan.entity.Peserta;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/peserta")
public class PesertaHtmlController {

    @Autowired
    private PesertaDao pd;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/list")
    public void daftarPeserta(Model m) {
        m.addAttribute("daftarPeserta", pd.findAll());
    }

    @RequestMapping("/hapus")
    public String hapus(@RequestParam("id") String id) {
        pd.delete(id);
        return "redirect:list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String tampilkanForm(@RequestParam(value = "id", required = false) String id, 
            Model m) {
        
        // defaultnya, isi dengan object baru
        m.addAttribute("peserta", new Peserta());
        
        if(id != null && !id.isEmpty()){
            Peserta p = pd.findOne(id);
            if(p != null){
                m.addAttribute("peserta", p);
            }
        }
        return "/peserta/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String prosesForm(@Valid Peserta p, BindingResult errors, 
            MultipartFile foto) throws Exception {
        if (errors.hasErrors()) {
            return "/peserta/form";
        }
        pd.save(p);
        
        String namaFile = foto.getName();
        String jenisFile = foto.getContentType();
        String namaAsli = foto.getOriginalFilename();
        Long ukuran = foto.getSize();
        
        System.out.println("Nama file : "+namaFile);
        System.out.println("Jenis file : "+jenisFile);
        System.out.println("Nama asli : "+namaAsli);
        System.out.println("Ukuran : "+ukuran);
        
        
        File tujuan = new File("foto.png");
        foto.transferTo(tujuan);
        System.out.println("File sudah dicopy ke :"+tujuan.getAbsolutePath());
        
        return "redirect:list";
    }
}

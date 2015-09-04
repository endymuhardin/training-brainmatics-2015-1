package com.muhardin.endy.pelatihan.controller;

import com.muhardin.endy.pelatihan.dao.MateriDao;
import com.muhardin.endy.pelatihan.entity.Materi;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MateriReportController {
    
    @Autowired private MateriDao md;
    
    @RequestMapping("/materi")
    public ModelAndView generateReportMateri(ModelAndView m, 
            @RequestParam(value = "format", required = false) String format){
        Iterable<Materi> data = md.findAll();
        m.addObject("dataSource", data);
        m.addObject("tanggalUpdate", new Date());
        m.addObject("format", "pdf");
        
        if(format != null && !format.isEmpty()){
            m.addObject("format", format);
        }
        
        m.setViewName("report_materi");
        return m;
    }
}

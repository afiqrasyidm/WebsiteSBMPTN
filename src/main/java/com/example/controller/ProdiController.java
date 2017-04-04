package com.example.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.PesertaModel;
import com.example.model.ProdiModel;
import com.example.model.UnivModel;
import com.example.service.PesertaService;
import com.example.service.ProdiService;
import com.example.service.UnivService;

@Controller
public class ProdiController {
	@Autowired
	ProdiService prodiService;
	
	@Autowired
	PesertaService pesertaService;
	

	@RequestMapping(value = "/prodi", method = RequestMethod.GET)
	public String viewAllPath(Model model
			, @RequestParam(value = "kode", required = false) String kodeProdi) {
		ProdiModel prodi = prodiService.selectProdi(kodeProdi);
		
		if(prodi!=null && prodi.getPeserta().size()!=0){
		
			model.addAttribute("prodi", prodi);
			model.addAttribute("pesertaTuaUmur",pesertaService.hitungUmur((prodi.getPesertaTua())));
			model.addAttribute("pesertaMudaUmur",pesertaService.hitungUmur((prodi.getPesertaMuda())));			
			return "viewprodi";
		}
		else if(prodi!=null && prodi.getPeserta().size()==0){
			model.addAttribute("kodeProdi", kodeProdi);
			return "not-found-peserta-prodi";
			
		}
		else{
			
			model.addAttribute("kodeProdi", kodeProdi);
			return "not-found-prodi";
			
		}
		
	}

}

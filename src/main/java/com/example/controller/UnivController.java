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
import com.example.service.UnivService;

@Controller
public class UnivController {
	@Autowired
	UnivService univService;

	@RequestMapping("/univ/{kodeUniv}")
	public String viewPath(Model model, @PathVariable(value = "kodeUniv") String kodeUniv) {
		UnivModel univ = univService.selectUniv(kodeUniv);

		if (univ != null) {
			model.addAttribute("univ", univ);
			return "viewuniv";
		} else {

			model.addAttribute("kodeUniv", kodeUniv);
			return "not-found-univ";

		}
	}

	@RequestMapping("/univ")
	public String viewAllPath(Model model) {
		List<UnivModel> banyakUniv = univService.selectAllUniv();

		model.addAttribute("banyakUniv", banyakUniv);

		return "viewalluniv";
	}

	@RequestMapping("/univ/peserta/{kodeUniv}")
	public String viewAllPathPeserta(Model model, @PathVariable(value = "kodeUniv") String kodeUniv) {

		UnivModel univ = univService.selectInfoUnivSaja(kodeUniv);
		List<PesertaModel> listPeserta = univService.selectAllPesertaUniv(kodeUniv);

		if (univ != null) {
			model.addAttribute("listPeserta", listPeserta);
			
			model.addAttribute("univ",univ);
			
			return "viewunivallpeserta";
		} else {

			model.addAttribute("kodeUniv", kodeUniv);
			return "not-found-univ";
		}

	}

	@RequestMapping("/univ/prodi/add/{kodeUniv}")
	public String viewAllAddProdi(Model model, @PathVariable(value = "kodeUniv") String kodeUniv) {
		model.addAttribute("kodeUniv", kodeUniv);

		return "add-prodi";
	}

	@RequestMapping("/univ/prodi/addsukses/{kodeUniv}")
	public String tampilkanPengumuman(Model model,
			@RequestParam(value = "namaProdi", required = false) String namaProdi,
			@PathVariable(value = "kodeUniv") String kodeUniv) {
		String kodeProdiTerakhirTambah1 =univService.getKodeProdiTerakhirTambahSatu(); 
//		System.out.println(kodeUniv);
		model.addAttribute("namaProdi", namaProdi);
		univService.addProdi(kodeUniv, kodeProdiTerakhirTambah1,namaProdi);
		// System.out.println(nomorPeserta+"ok");

		return "addprodisukses";
	}

}

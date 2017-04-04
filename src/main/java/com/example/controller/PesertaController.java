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
import com.example.service.PesertaService;
@Controller
public class PesertaController {
	@Autowired
	PesertaService pesertaService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/pengumuman/submit", method = RequestMethod.POST)
	public String tampilkanPengumuman(Model model,@RequestParam(value = "nomorPeserta", required = false) String nomorPeserta) {
		
		//System.out.println(nomorPeserta+"ok");
		PesertaModel peserta = pesertaService.selectPesertaLulus(nomorPeserta);
		if(peserta==null){
			//(variabel yang digunakan html,variabel yang dilempar)
			model.addAttribute("nomorPeserta", nomorPeserta);
			return "not-found-peserta";
		
		}
		else {
			model.addAttribute("umur",pesertaService.hitungUmur(peserta));
			
			model.addAttribute("peserta", peserta);
			if(peserta.getProdi()!=null){

				System.out.println("yes");
				return "viewlolos";
			}
			else{
				System.out.println("no");
				return "viewtidaklolos";
						
				
			}
		}
	
	}
	
	/*DIgunakan untuk mengetes menggunakan JMETER
	@RequestMapping(value = "/pengumuman/submit", method = RequestMethod.GET)
	public String tampilkanPengumuman(Model model,@RequestParam(value = "nomorPeserta", required = false) String nomorPeserta) {
		
		//System.out.println(nomorPeserta+"ok");
		PesertaModel peserta = pesertaService.selectPesertaLulus(nomorPeserta);
		if(peserta==null){
			//(variabel yang digunakan html,variabel yang dilempar)
			model.addAttribute("nomorPeserta", nomorPeserta);
			return "not-found-peserta";
		
		}
		else {
			model.addAttribute("umur",pesertaService.hitungUmur(peserta));
			
			model.addAttribute("peserta", peserta);
			if(peserta.getProdi()!=null){

				System.out.println("yes");
				return "viewlolos";
			}
			else{
				System.out.println("no");
				return "viewtidaklolos";
						
				
			}
		}
	
	}
	
	*/
	
	@RequestMapping(value = "/peserta", method = RequestMethod.GET)
	public String viewAllPath(Model model
			, @RequestParam(value = "nomor", required = false) String nomor) {
		PesertaModel peserta = pesertaService.selectPeserta(nomor);
		
		if(peserta!=null){
			model.addAttribute("peserta", peserta);
			model.addAttribute("umur",pesertaService.hitungUmur(peserta));
			
			return "viewpeserta";
		}
		else{
			model.addAttribute("nomorPeserta", nomor);
					
			return "not-found-peserta";
				
		}
		
	}

}

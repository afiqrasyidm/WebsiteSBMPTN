package com.example.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PesertaMapper;
import com.example.model.PesertaModel;
import com.example.model.ProdiModel;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PesertaServiceDatabase implements PesertaService{
	
	 @Autowired
	private PesertaMapper pesertaMapper;
	 
	
	 @Override
	public PesertaModel selectPeserta(String nomorPeserta) {
		// TODO Auto-generated method stub
		 log.info ("select peserta with nomorPeserta {}", nomorPeserta);
		
		 
		   
		  PesertaModel peserta = pesertaMapper.selectPeserta(nomorPeserta);
		  
		  
		  
		
		
		  
		 return peserta;
		
		
	}
	 public PesertaModel selectPesertaLulus(String nomorPeserta) {
			// TODO Auto-generated method stub
			 log.info ("select peserta with nomorPeserta {}", nomorPeserta);
			
			 
			   
			  PesertaModel peserta = pesertaMapper.selectPesertaLulus(nomorPeserta);
			  
			  
			  
			
			
			  
			 return peserta;
			
			
		}
	public int hitungUmur(PesertaModel peserta){
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = new Date();
		   int umur = (int) ((date.getTime() - peserta.getTgl_lahir().getTime()) / (1000 * 60 * 60 * 24)/365);
		   
		   return umur;
	}
	@Override
	public ProdiModel selectProdi(String nomorProdi) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

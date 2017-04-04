package com.example.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PesertaMapper;
import com.example.dao.UnivMapper;
import com.example.model.PesertaModel;
import com.example.model.ProdiModel;
import com.example.model.UnivModel;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class UnivServiceDatabase implements UnivService{
	
	 @Autowired
	private UnivMapper univMapper;
	 
	
	 


	

	@Override
	public UnivModel selectUniv(String kodeUniv) {
		// TODO Auto-generated method stub
		
		 log.info ("select univ with kodeuniv {}", kodeUniv);
		 
		 
		return univMapper.selectUniv(kodeUniv);
	}







	@Override
	public List<UnivModel> selectAllUniv() {
		// TODO Auto-generated method stub
		return univMapper.selecAlltUniv();
	}







	@Override
	public UnivModel selectUnivWithPeserta(String kodeUniv) {
		// TODO Auto-generated method stub
		return univMapper.selectUnivWithPeserta(kodeUniv);
	}







	@Override
	public void addProdi(String kodeUniv,String kodeProdiTerakhirTambah1, String namaProdi) {

		 log.info ("insert prodi with kodeuniv {}", kodeUniv);
		 
		
		univMapper.addProdi(kodeUniv, kodeProdiTerakhirTambah1,namaProdi);
	}







	@Override
	public String getKodeProdiTerakhirTambahSatu() {
		// TODO Auto-generated method stub
		
		int kodeProdiTerakhirIntPlusSatu = Integer.parseInt(univMapper.getKodeProdiTerakhir());
		kodeProdiTerakhirIntPlusSatu++;
		
		
		
		return ""+kodeProdiTerakhirIntPlusSatu;
	}







	@Override
	public List<PesertaModel> selectAllPesertaUniv(String kode_univ) {
		// TODO Auto-generated method stub
		return univMapper.selectAllPesertaUniv(kode_univ);
	}







	@Override
	public UnivModel selectInfoUnivSaja(String kode_univ) {
		// TODO Auto-generated method stub
		return univMapper.selectInfoUnivSaja(kode_univ);
	}

}


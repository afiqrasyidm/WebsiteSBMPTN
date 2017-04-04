
package com.example.service;

import com.example.model.PesertaModel;
import com.example.model.ProdiModel;

public interface PesertaService {
	PesertaModel selectPeserta (String nomorPeserta);
	ProdiModel selectProdi (String nomorProdi);
	int hitungUmur(PesertaModel peserta);
	 public PesertaModel selectPesertaLulus(String nomorPeserta);
			
}

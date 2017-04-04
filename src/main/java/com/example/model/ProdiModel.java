package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdiModel {
	private String namaProdi;
	private String kodeProdi;
	private UnivModel univ;
	private List<PesertaModel> peserta;
	private PesertaModel pesertaTua;
	private PesertaModel pesertaMuda;
}
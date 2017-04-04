package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnivModel {
	private String kodeUniv;
	private String namaUniv;
	private String urlUniv;
	private List<ProdiModel> prodi;
}
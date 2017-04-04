package com.example.model;

import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesertaModel {
	private String nomor;
	private String nama;
	private Date tgl_lahir;
	private ProdiModel prodi;
	
	
}

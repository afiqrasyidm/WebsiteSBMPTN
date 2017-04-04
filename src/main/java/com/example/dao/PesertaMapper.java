package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.PesertaModel;
import com.example.model.ProdiModel;
import com.example.model.UnivModel;
@Mapper

public interface PesertaMapper {
	
	@Select("select nama, nomor, tgl_lahir, nama_prodi, univ.nama_univ, univ.url_univ from peserta LEFT join prodi on peserta.kode_prodi = prodi.kode_prodi LEFT JOIN univ ON univ.kode_univ =prodi.kode_univ where peserta.nomor = #{nomorPeserta}")
	@Results(value = { @Result(property = "nama", column = "nama"), 
			@Result(property = "nomor", column = "nomor"),
			@Result(property = "tgl_lahir", column = "tgl_lahir"),		
			@Result(property = "prodi.namaProdi", column = "nama_prodi"),
			@Result(property = "prodi.univ.namaUniv", column = "nama_univ"),
			@Result(property = "prodi.univ.urlUniv", column = "url_univ"),
				
	})
	
	
	PesertaModel selectPesertaLulus(@Param("nomorPeserta") String nomorPeserta);
	
	
	
	@Select("select nama, nomor, tgl_lahir from peserta where nomor= #{nomorPeserta}")
	@Results(value = { @Result(property = "nama", column = "nama"), 
			@Result(property = "nomor", column = "nomor"),
			@Result(property = "tgl_lahir", column = "tgl_lahir")				
	})
	
	
	PesertaModel selectPeserta(@Param("nomorPeserta") String nomorPeserta);
	
	
	
	/*	
	@Select("select * " + " from prodi where prodi.kode_prodi = #{kode_prodi}")
	@Results(value = { @Result(property = "namaProdi", column = "nama_prodi"),
			@Result(property = "univ", column = "kode_univ", javaType = UnivModel.class, many = @Many(select = "selectUniv"))})
	
	ProdiModel selectProdi(@Param("kode_prodi") String kode_prodi);
	
	@Select("select * " + " from univ where univ.kode_univ = #{kode_univ}")
	@Results(value = { @Result(property = "namaUniv", column = "nama_univ")})
	
	UnivModel selectUniv(@Param("kode_univ") String kode_univ);
	*/
}

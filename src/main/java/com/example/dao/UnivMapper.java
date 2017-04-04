package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
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
//yang dipakai untuk melihat univ peserta(bonus) merupakan method selectAllPesertaUniv
public interface UnivMapper {

	@Select("select * from univ where kode_univ = #{kodeUniv}")
	@Results(value = { @Result(property = "kodeUniv", column = "kode_univ"),
			@Result(property = "namaUniv", column = "nama_univ"), @Result(property = "urlUniv", column = "url_univ"),
			@Result(property = "prodi", column = "kode_univ", javaType = List.class, many = @Many(select = "selectProdi")) })
	UnivModel selectUniv(String kodeUniv);

	@Select("select * from univ where kode_univ=#{kodeUniv}")
	@Results(value = { @Result(property = "kodeUniv", column = "kode_univ"),
			@Result(property = "namaUniv", column = "nama_univ"), @Result(property = "urlUniv", column = "url_univ"),
			@Result(property = "prodi", column = "kode_univ", javaType = List.class, many = @Many(select = "selectProdiWithPeserta")) })
	UnivModel selectUnivWithPeserta(String kodeUniv);

	@Select("select nama_prodi, kode_prodi from prodi where kode_univ=#{kodeUniv}")
	@Results(value = { @Result(property = "kodeProdi", column = "kode_prodi"),
			@Result(property = "namaProdi", column = "nama_prodi")	})

	List<ProdiModel> selectProdi(@Param("kodeUniv") String kode_univ);

	
	@Select("select nama_prodi, kode_prodi from prodi where kode_univ=#{kodeUniv}")
	@Results(value = { @Result(property = "kodeProdi", column = "kode_prodi"),
			@Result(property = "namaProdi", column = "nama_prodi"),
			@Result(property = "peserta", column = "kode_prodi", javaType = List.class, many = @Many(select = "selectAllPeserta")) })

	List<ProdiModel> selectProdiWithPeserta(@Param("kodeUniv") String kode_univ);


	
	
	
	
	
	@Select("select nama, nomor, tgl_lahir, nama_prodi from peserta LEFT join prodi on peserta.kode_prodi = prodi.kode_prodi  where prodi.kode_univ = #{kodeUniv}")
	@Results(value = { @Result(property = "nama", column = "nama"), 
			@Result(property = "nomor", column = "nomor"),
			@Result(property = "tgl_lahir", column = "tgl_lahir"),		
			@Result(property = "prodi.namaProdi", column = "nama_prodi"),
				
	})
	List<PesertaModel> selectAllPesertaUniv(@Param("kodeUniv") String kode_univ);
	
	
	
	
	
	@Select("select * from univ where kode_univ=#{kodeUniv}")
	@Results(value = { @Result(property = "kodeUniv", column = "kode_univ"),
			@Result(property = "namaUniv", column = "nama_univ"), @Result(property = "urlUniv", column = "url_univ")})
	
	UnivModel selectInfoUnivSaja(@Param("kodeUniv") String kode_univ);
	
	
	
	
	@Select("select * from peserta where kode_prodi=#{kodeProdi}")
	@Results(value = { @Result(property = "nomor", column = "nomor"), @Result(property = "nama", column = "nama"),
			@Result(property = "tgl_lahir", column = "tgl_lahir") })

	List<PesertaModel> selectAllPeserta(@Param("kodeProdi") String kodeProdi);

	@Select("select * from univ")

	@Results(value = { @Result(property = "kodeUniv", column = "kode_univ"),
			@Result(property = "namaUniv", column = "nama_univ"), @Result(property = "urlUniv", column = "url_univ") })

	List<UnivModel> selecAlltUniv();

	@Insert("INSERT INTO prodi ( kode_univ, kode_prodi, nama_prodi) VALUES (#{kodeUniv}, #{kodeProdiTerakhirTambah1},#{namaProdi})")
	void addProdi(@Param("kodeUniv") String kodeUniv,
			@Param("kodeProdiTerakhirTambah1") String kodeProdiTerakhirTambah1, @Param("namaProdi") String namaProdi);

	@Select("select kode_prodi from prodi order by kode_prodi desc limit 1")

	String getKodeProdiTerakhir();

}

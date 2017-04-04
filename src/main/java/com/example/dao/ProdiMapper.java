package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Results;

import com.example.model.PesertaModel;
import com.example.model.ProdiModel;
import com.example.model.UnivModel;

@Mapper
public interface ProdiMapper {
	
	@Select("select * from prodi where kode_prodi = #{kodeProdi}")
	@Results(value = { @Result(property = "namaProdi", column = "nama_prodi"), 
			@Result(property = "kodeProdi", column = "kode_prodi"),
			@Result(property = "univ", column = "kode_univ", javaType = UnivModel.class, many = @Many(select = "selectUniv")),
			@Result(property = "peserta", column = "kode_prodi", javaType = List.class, many = @Many(select = "selectAllPeserta")) })
	
	ProdiModel selectProdi(@Param("kodeProdi") String kodeProdi);
	
	@Select("select * " + " from univ where univ.kode_univ = #{kode_univ}")
	@Results(value = { @Result(property = "namaUniv", column = "nama_univ"),
			@Result(property = "kodeUniv", column = "kode_univ"),
			@Result(property = "urlUniv", column = "url_univ")
	})
	
	UnivModel selectUniv(@Param("kode_univ") String kode_univ);
	
	
	@Select("select * from peserta where kode_prodi=#{kodeProdi}")
	@Results(value = { 
			@Result(property = "nomor", column = "nomor"),
			@Result(property = "nama", column = "nama"),
			@Result(property = "tgl_lahir", column = "tgl_lahir")
	})

	List<PesertaModel> selectAllPeserta(@Param("kodeProdi") String kodeProdi);
	
	
}

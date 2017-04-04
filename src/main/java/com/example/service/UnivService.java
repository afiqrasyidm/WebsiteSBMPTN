package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.model.PesertaModel;
import com.example.model.UnivModel;

public interface UnivService{
    UnivModel selectUniv (String kodeUniv);
    List<UnivModel>selectAllUniv();
    UnivModel selectUnivWithPeserta(String kodeUniv);
    void addProdi(String kodeUniv, String kodeProdiTerakhirTambah1,String namaProdi);
    String getKodeProdiTerakhirTambahSatu();
    
    List<PesertaModel> selectAllPesertaUniv( String kode_univ);
    UnivModel selectInfoUnivSaja(String kode_univ);

}

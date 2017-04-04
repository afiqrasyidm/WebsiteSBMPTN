package com.example.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PesertaMapper;
import com.example.dao.ProdiMapper;
import com.example.dao.UnivMapper;
import com.example.model.PesertaModel;
import com.example.model.ProdiModel;
import com.example.model.UnivModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdiServiceDatabase implements ProdiService {

	@Autowired
	private ProdiMapper prodiMapper;

	private PesertaService peserta = new PesertaServiceDatabase();

	@Override
	public ProdiModel selectProdi(String kodeProdi) {

		ProdiModel prodi = prodiMapper.selectProdi(kodeProdi);

		if (prodi != null && prodi.getPeserta().size()!=0) {

			// System.out.println(prodi.getUniv());
			// System.out.println(prodi.getPeserta());

			
			PesertaModel pesertaTua = prodi.getPeserta().get(0);
		
			for (int i = 1; i < prodi.getPeserta().size(); i++) {
				if (peserta.hitungUmur(pesertaTua) < peserta.hitungUmur((prodi.getPeserta().get(i)))) {
					pesertaTua = prodi.getPeserta().get(i);

				}
			}

			PesertaModel pesertaMuda = prodi.getPeserta().get(0);

			for (int i = 1; i < prodi.getPeserta().size(); i++) {
				if (peserta.hitungUmur(pesertaMuda) > peserta.hitungUmur((prodi.getPeserta().get(i)))) {
					pesertaMuda = prodi.getPeserta().get(i);

				}
			}

			
			prodi.setPesertaMuda(pesertaMuda);
			prodi.setPesertaTua(pesertaTua);
		}
		return prodi;
	}

}

package com.wbautista.repositorio;

import com.wbautista.modelo.Instrument;

import java.util.List;


public interface InstrumentDao {
    Instrument save(Instrument instrument);

    List<Instrument> findAll();

    void delete(Instrument instrument);

    public Instrument findOne(String id);
}

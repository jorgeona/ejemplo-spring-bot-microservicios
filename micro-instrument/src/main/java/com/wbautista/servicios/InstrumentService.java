package com.wbautista.servicios;

import com.wbautista.modelo.Instrument;

import java.util.List;


public interface InstrumentService {

    public void saveInstrument(Instrument instrument);

    public void deleteInstrument(Instrument instrument);

    public List<Instrument> findAll();

    public Instrument findOne(String id);

}

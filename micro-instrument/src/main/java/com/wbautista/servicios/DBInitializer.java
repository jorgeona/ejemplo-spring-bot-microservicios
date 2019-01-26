package com.wbautista.servicios;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wbautista.modelo.Instrument;
import com.wbautista.repositorio.InstrumentDao;

@Service

public class DBInitializer {

    private Logger logger =
            LoggerFactory.getLogger(DBInitializer.class);

    private final InstrumentDao instrumentDao;

    public DBInitializer(InstrumentDao instrumentDao) {
        this.instrumentDao = instrumentDao;
    }

    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");
        Instrument guitar = new Instrument();
        guitar.setInstrumentId("Guitar");
        instrumentDao.save(guitar);

        Instrument piano = new Instrument();
        piano.setInstrumentId("Piano");
        instrumentDao.save(piano);

        logger.info("Database initialization finished.");
    }
    
}

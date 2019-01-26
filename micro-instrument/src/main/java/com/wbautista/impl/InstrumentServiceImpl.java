package com.wbautista.impl;

import com.wbautista.modelo.Instrument;
import com.wbautista.repositorio.InstrumentDao;
import com.wbautista.servicios.InstrumentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class InstrumentServiceImpl implements InstrumentService {

    private final InstrumentDao dao;
    private final RabbitTemplate rabbitTemplate;

    public InstrumentServiceImpl(InstrumentDao dao, RabbitTemplate rabbitTemplate) {
        this.dao = dao;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveInstrument(@RequestBody Instrument instrument) {
        try {
            dao.save(instrument);
            rabbitTemplate.convertAndSend("cola", instrument.getInstrumentId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteInstrument(@RequestBody Instrument instrument) {
        dao.delete(instrument);
    }

    @Override
    @GetMapping("/")
    public List<Instrument> findAll() {
        return dao.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Instrument findOne(@PathVariable String id) {
        return findAll().stream().filter(p -> p.getInstrumentId().equals(id)).findFirst().get();
    }
}

package com.wbautista.impl;

import com.wbautista.model.Singer;
import com.wbautista.repositorio.SingerDao;
import com.wbautista.servicios.SingerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SingerServiceImpl implements SingerService {

    private final SingerDao dao;

    public SingerServiceImpl(SingerDao dao) {
        this.dao = dao;
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveSinger(@RequestBody Singer singer) {
        dao.save(singer);
    }

    @Override
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteSinger(@RequestBody Singer singer) {
        dao.delete(singer);
    }

    @Override
    @GetMapping("/")
    public List<Singer> findAll() {
        return dao.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Singer findById(@PathVariable Long id) {
        return dao.findOne(id);
    }
}

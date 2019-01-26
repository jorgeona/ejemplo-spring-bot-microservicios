package com.wbautista.repositorio;


import com.wbautista.modelo.Instrument;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import java.util.List;

/**
 * Created by iuliana.cosmina on 4/23/17.
 */
@Transactional
@Repository("instrumentDao")
public class InstrumentDaoImpl extends JdbcDaoSupport implements InstrumentDao {


    private static final Log logger = LogFactory.getLog(InstrumentDaoImpl.class);
    private SessionFactory sessionFactory;


    @Override
    public Instrument save(Instrument instrument) {
        sessionFactory.getCurrentSession().saveOrUpdate(instrument);
        logger.info("Instrument saved with id: " + instrument.getInstrumentId());
        return instrument;
    }

    @Override
    public List<Instrument> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Instrument i").list();
    }

    @Override
    public void delete(Instrument instrument) {
        sessionFactory.getCurrentSession().delete(instrument);
    }

    @Override
    public Instrument findOne(String id) {
        return (Instrument) sessionFactory.getCurrentSession().createQuery("from Instrument i where i.instrumentId=?").setParameter("id", id).list().get(0);
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
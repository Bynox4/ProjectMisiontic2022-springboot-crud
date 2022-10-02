package com.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DAO.PlazasDAO;
import com.TO.Plazas;

@Service
public class PlazasService implements IPlazasService{
    
    @Autowired
    PlazasDAO plazasDao;

    @Override
    @Transactional
    public Plazas guardar(Plazas plaza) {
        return plazasDao.save(plaza);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Plazas> listarplazas() {
        return (List<Plazas>) plazasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Plazas buscarPlazas(int plaza) {
        return plazasDao.findById(plaza).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Plazas> plazasLibrexTipo(String tipo) {
        return (List<Plazas>) plazasDao.plazasLibresxTipo(tipo);
    }

    @Override
    @Transactional
    public void eliminar(int plaza) {
        plazasDao.deleteById(plaza);
    }    
    
}

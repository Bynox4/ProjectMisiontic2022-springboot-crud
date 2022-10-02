package com.Services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.PersonasDAO;
import com.TO.Personas;

@Service
public class PersonasService implements IPersonasService {
    
    @Autowired
    PersonasDAO personasDao;

    @Override
    @Transactional
    public Personas guardar(Personas persona) {
        return personasDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(int id_personas) {
        personasDao.deleteById(id_personas);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Personas> listarpersonas() {
        return (List<Personas>) personasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Personas buscaPersonas(int id_Personas) {
        return personasDao.findById(id_Personas).orElse(null);
    }
    
}

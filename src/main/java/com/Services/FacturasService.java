package com.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.FacturasDAO;
import com.TO.Facturas;

@Service
public class FacturasService implements IFacturasService{

    @Autowired
    FacturasDAO facturasDao;

    @Override
    @Transactional
    public Facturas guardar(Facturas factura) {
        return facturasDao.save(factura);
    }

    @Override
    @Transactional
    public void eliminar(int id_facturas) {
        facturasDao.deleteById(id_facturas);
    }

    @Transactional(readOnly = true)
    public List<Facturas> listarParqueados() {
        return (List<Facturas>) facturasDao.listarParqueados();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Facturas> listarfacturas() {
        return (List<Facturas>) facturasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Facturas buscarFacturas(int id_facturas) {
        return facturasDao.findById(id_facturas).orElse(null);
    }
    
}

package com.Services;

import java.util.List;

import com.TO.Facturas;

public interface IFacturasService {
    public Facturas guardar(Facturas factura);

    public void eliminar(int id_facturas);

    public List<Facturas> listarfacturas();

    public Facturas buscarFacturas(int id_facturas);
}

package com.club.service;

import com.club.model.Socio;

import java.util.ArrayList;
import java.util.List;

public class SocioService {
    private List<Socio> socios;

    public SocioService () {
        socios = new ArrayList<>();
    }

    public void registrarSocio(Socio socio) {
        socios.add(socio);
    }

    public List<Socio>  listarSocio() {
       return socios;
    }

    public Socio buscarPorDni(String dni) {
        for(Socio socio : socios) {
            if (socio.getDni().equalsIgnoreCase(dni)) {
                return socio;
            }
        }
        return null;
    }

    public boolean cambiarEstado(int id, boolean nuevoEstado) {
        for(Socio socio : socios) {
            if (socio.getId() == id) {
                socio.setActivo(nuevoEstado);
                return true;
            }
            }
        return false;
    }
}

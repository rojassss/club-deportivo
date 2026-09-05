package com.club.service;

import com.club.model.Socio;

import java.util.ArrayList;
import java.util.List;

public class SocioService {
    private List<Socio> socios;
    private int contadorId;

    public SocioService () {
        socios = new ArrayList<>();
        this.contadorId = 1;
    }

    public boolean registrarSocio(Socio socio) {
        if (buscarPorDni(socio.getDni()) != null) {
            return false; // Retorna false si ya existe
        }
        socio.setId(contadorId++);
        socios.add(socio);
        return true; // Retorna true si se registró bien
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

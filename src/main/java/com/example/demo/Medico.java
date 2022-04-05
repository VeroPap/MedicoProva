package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medico {
    private @Id @GeneratedValue int CodMedico;
    private String NomeMedico;

    public int getCodMedico() {
        return CodMedico;
    }
    public void setCodMedico(int codMedico) {
        CodMedico = codMedico;
    }
    public String getNomeMedico() {
        return NomeMedico;
    }
    public void setNomeMedico(String nomeMedico) {
        NomeMedico = nomeMedico;
    }

    Medico(){}

    public Medico(String NomeMedico){
        super();
        this.NomeMedico = NomeMedico;
    }

}

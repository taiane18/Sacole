/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Sacole {
    private String sabor;
    private LocalDate data_validade;
    private Double preco;
    private Integer nr_serie;
    private Integer codigo;

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public LocalDate getData_validade() {
        return data_validade;
    }

    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getNr_serie() {
        return nr_serie;
    }

    public void setNr_serie(Integer nr_serie) {
        this.nr_serie = nr_serie;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Sacole{" + "sabor=" + sabor + '}';
    }

    
    
    
}

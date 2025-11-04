/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uni.api;

import java.util.List;


public interface ApiOperacionBD<T, ID> {

    public int getSerial();

    public T insertInto(T objeto, String ruta);

    public List<T> selectFrom();

    public int numRows();

    public Boolean delectFrom(ID codigo);

    public T updateSet(ID codigo, T objeto, String ruta);

    public T getOne(ID codigo);

}
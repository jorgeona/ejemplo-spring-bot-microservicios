package com.wbautista.listener;

import org.springframework.stereotype.Component;

@Component
public class InstrumentoListener {

    public void onNuevoInstrumento(String ins) {
        System.out.println("Received <" + ins + ">");
    }
}

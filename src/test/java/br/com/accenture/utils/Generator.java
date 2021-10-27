package br.com.accenture.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Generator {
    public boolean dataValidador(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);
            sdf.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public boolean dataMenorQueHoje(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dataVerificada = LocalDate.parse(data, dtf);
        LocalDate hoje = LocalDate.now();
        return dataVerificada.compareTo(hoje) <= 0;
    }

    public boolean maioridadeValidador(String data) throws ParseException {
        Calendar data_nasc = Calendar.getInstance();
        data_nasc.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(data));
        data_nasc.add(Calendar.YEAR, 18);
        Calendar data_hoje = Calendar.getInstance();
        return data_nasc.before(data_hoje);
    }

    public boolean proximoMes(String data) throws ParseException {
        Calendar data_rec = Calendar.getInstance();
        data_rec.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(data));
        data_rec.add(Calendar.MONTH, 1);
        Calendar data_hoje = Calendar.getInstance();
        return data_rec.after(data_hoje);
    }

}


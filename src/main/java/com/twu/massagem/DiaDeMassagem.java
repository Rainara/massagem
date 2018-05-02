package com.twu.massagem;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class DiaDeMassagem {


    private int id;
    private LocalDate data;
    public String tipoDeMassagem;

    public String getTipoDeMassagem() {
        return tipoDeMassagem;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean validarData(List<LocalDate> datas, int quantidade) {

        if(!datas.isEmpty() && quantidade==datas.size() && quantidade>0) {
            if(contarDatasDuplicadas(datas)==0)
                return true;
        }
            return false;
    }

    public int contarDatasDuplicadas(List<LocalDate> datas){

        List<LocalDate> distinctList = (List<LocalDate>)datas.stream().distinct().collect(Collectors.toList());
        int duplicatedItems = datas.size()-distinctList.size();

        return duplicatedItems;
    }

    public List<String> verificaTipo(int quantidade, String tipoMassagem) {

        List<String> tiposEntrada = new ArrayList<String>();

        for (int i=0;i<quantidade;i++){

            tiposEntrada.add(tipoMassagem);

        }

        return tiposEntrada;

    }

    public boolean verificaData(List<LocalDate> datas) {

        LocalDate today = LocalDate.now();

        for (LocalDate data : datas) {

            if (data.isBefore(today)) {
                return false;
            }
        }

        return true;

    }

    public DiaDeMassagem() {
    }

    public DiaDeMassagem(int id, LocalDate data, String tipoDeMassagem) {
        this.id = id;
        this.data = data;
        this.tipoDeMassagem = tipoDeMassagem;
    }

    public List<DiaDeMassagem> insereDiaDeMassagem(int quantidade, List<LocalDate> datas, String tipoDeMassagem) {

        List<DiaDeMassagem> diasDeMassagem = new ArrayList<>();

        if(validarData(datas,quantidade) && verificaData(datas)){

            for (int i=0;i<quantidade;i++){

                diasDeMassagem.add(new DiaDeMassagem(i, datas.get(i), tipoDeMassagem));

            }
        }
        return diasDeMassagem;
    }
}

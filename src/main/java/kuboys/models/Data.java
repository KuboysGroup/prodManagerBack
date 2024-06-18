package kuboys.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Data extends Number implements Comparable<Data> {

    private final int dia;
    private final int mes;
    private final int ano;

    public static final String FORMATO_BR = "dd/MM/yyyy";

    public static final Data VALOR_MIN = new Data(1, 1, 0);
    public static final Data VALOR_MAX = new Data(31, 12, 9999);
    public static final Data ZERO = new Data(0,0,0);

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data(Calendar calendar) {
        this(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }

    public static Data hoje() {
        Calendar hoje = Calendar.getInstance();
        return new Data(hoje);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public static Data parseData(String dataStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_BR);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(dataStr));
        return new Data(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
    }

    @Override
    public int compareTo(Data o) {
        if (this.ano != o.ano)
            return Integer.compare(this.ano, o.ano);
        if (this.mes != o.mes)
            return Integer.compare(this.mes, o.mes);
        return Integer.compare(this.dia, o.dia);
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public boolean isAnterior(Data data) {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(this.getAno(), this.getMes() - 1, this.getDia());
        Calendar cal2 = Calendar.getInstance();
        cal2.set(data.getAno(), data.getMes() - 1, data.getDia());

        return cal1.before(cal2);
    }

    public boolean isPosterior(Data data) {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(this.getAno(), this.getMes() - 1, this.getDia());
        Calendar cal2 = Calendar.getInstance();
        cal2.set(data.getAno(), data.getMes() - 1, data.getDia());

        return cal1.after(cal2);
    }

    public static Data gerarDataAleatoria() {
        Random random = new Random();
        int ano = random.nextInt(10000);
        int mes = random.nextInt(12) + 1;
        int dia = 1;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, ano);
        cal.set(Calendar.MONTH, mes - 1);
        int maxDia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        dia = random.nextInt(maxDia) + 1;

        return new Data(dia, mes, ano);
    }

    public boolean isValida() {
        return (this.compareTo(VALOR_MIN) >= 0) && (this.compareTo(VALOR_MAX) <= 0);
    }

}

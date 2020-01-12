package bd.com.rafi.magnitudeconverter;

import android.annotation.SuppressLint;

class PressureConverter {
    private String finalresult = null;

    @SuppressLint("DefaultLocale")
    String BarToPascal(String value, String convertFrom, String convertTo){
        double i = 0;


//        if(Double.parseDouble(value)== )
        try{
           i = Double.parseDouble(value);
        }catch (Exception e){
            e.printStackTrace();
        }
        switch (convertFrom) {
            case "Bar":
                switch (convertTo) {
                    case "Pascal":
                        finalresult = String.valueOf(i * 100000);
                        break;
                    case "KiloPascal":
                        finalresult = String.valueOf(i * 1000);
                        break;
                    case "Bar":
                        finalresult = String.valueOf(i * 1);
                        break;
                    case "PSI":
                        finalresult = String.valueOf(i * 14.503773773);
                        break;
                    case "ATM":
                        finalresult = String.format("%.12f", i * 0.9869232667);
                        break;
                }
                break;
            case "Pascal":
                switch (convertTo) {
                    case "ATM":
                        finalresult = String.format("%.12f", i * 0.0000098692);
                        break;
                    case "KiloPascal":
                        finalresult = String.format("%.12f", i * 0.001);
                        break;
                    case "Bar":
                        finalresult = String.format("%.12f", i * 0.00001);
                        break;
                    case "PSI":
                        finalresult = String.format("%.12f", i * 0.0001450377);
                        break;
                    case "pascal":
                        finalresult = String.valueOf(i * 1);
                        break;
                }
                break;
            case "KiloPascal":
                switch (convertTo) {
                    case "KiloPascal":
                        finalresult = String.valueOf(i * 1);
                        break;
                    case "Bar":
                        finalresult = String.valueOf(i * 0.01);
                        break;
                    case "PSI":
                        finalresult = String.valueOf(i * 0.1450377377);
                        break;
                    case "Pascal":
                        finalresult = String.valueOf(i * 1000);
                        break;
                    case "ATM":
                        finalresult = String.format("%.12f", i * 0.0098692327);
                        break;
                }
                break;
            case "PSI":
                switch (convertTo) {
                    case "PSI":
                        finalresult = String.valueOf(i * 1);
                        break;
                    case "Pascal":
                        finalresult = String.valueOf(i * 6894.7572932);
                        break;
                    case "KiloPascal":
                        finalresult = String.valueOf(i * 6.8947572932);
                        break;
                    case "Bar":
                        finalresult = String.valueOf(i * 0.0689475729);
                        break;
                    case "ATM":
                        finalresult = String.valueOf(i * 0.0680459639);
                        break;
                }
                break;
            case "ATM":
                switch (convertTo) {
                    case "PSI":
                        finalresult = String.valueOf(i * 14.695948775);
                        break;
                    case "Pascal":
                        finalresult = String.valueOf(i * 101325);
                        break;
                    case "KiloPascal":
                        finalresult = String.valueOf(i * 101.325);
                        break;
                    case "Bar":
                        finalresult = String.valueOf(i * 1.01325);
                        break;
                    case "ATM":
                        finalresult = String.valueOf(i * 1);
                        break;
                }
                break;
        }
        return finalresult;
    }
}

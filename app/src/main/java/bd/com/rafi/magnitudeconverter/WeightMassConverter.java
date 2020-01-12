package bd.com.rafi.magnitudeconverter;

import android.annotation.SuppressLint;
import android.util.Log;

class WeightMassConverter {



    @SuppressLint("DefaultLocale")
    String weightToMass(String value, String ConvertFrom, String ConvertTo){

         String finalresult =null;
        double i =0;

        try{
            i = Double.parseDouble(value);
        }catch (Exception e){
            e.printStackTrace();
        }

        switch (ConvertFrom) {
            case "Kilogram":
                Log.e("bb1", "nnn");
                switch (ConvertTo) {
                    case "Gram":
                        finalresult = String.valueOf(i * 1000);
                        Log.e("bb2", "nnn");
                        break;
                    case "Pound":

                        Log.e("bb4", "nnn");
                        finalresult = String.valueOf(i * 2.2046226218);
                        break;
                    case "Ton":
                        finalresult = String.valueOf(i * 0.001);
                        break;
                    case "Ounce":
                        finalresult = String.valueOf(i * 35.27396195);
                        break;

                    case "Kilogram":
                        finalresult = String.valueOf(i * 1);
                        break;
                }
                break;
            case "Pound":
                switch (ConvertTo) {
                    case "Kilogram":
                        finalresult = String.format("%.12f", i * 0.45359237);
                        break;
                    case "Gram":
                        finalresult = String.valueOf(i * 453.59237);
                        break;
                    case "Ton":
                        finalresult = String.format("%.12f", i * 0.0004535924);
                        break;
                    case "Ounce":
                        finalresult = String.valueOf(i * 16);
                        break;
                }
                break;
            case "Ounce":
                switch (ConvertTo) {
                    case "Kilogram":
                        finalresult = String.format("%.12f", i * 0.0283495231);
                        break;
                    case "Gram":
                        finalresult = String.format("%.12f", i * 28.349523125);
                        break;
                    case "Ton":
                        finalresult = String.format("%.12f", i * 0.0000283495);
                        break;
                    case "Pound":
                        finalresult = String.valueOf(i * 0.0625);
                        break;
                }
                break;
            case "Ton":
                switch (ConvertTo) {
                    case "Kilogram":
                        finalresult = String.valueOf(i * 1000);
                        break;
                    case "Gram":
                        finalresult = String.valueOf(i * 1000000);
                        break;
                    case "Pound":
                        finalresult = String.valueOf(i * 2204.6226218);
                        break;
                    case "Ounce":
                        finalresult = String.valueOf(i * 35273.96195);
                        break;
                }
                break;
            case "Gram":
                switch (ConvertTo) {
                    case "Kilogram":
                        finalresult = String.format("%.12f", i * 0.001);
                        break;
                    case "Ton":
                        finalresult = String.format("%.12f", i * 0.000001);
                        break;
                    case "Ounce":
                        finalresult = String.format("%.12f", i * 0.0352739619);
                        break;

                    case "Pound":
                        finalresult = String.format("%.12f", i * 0.00220462);
                        break;

                }
                break;
        }
        return  finalresult;
    }
}

package bd.com.rafi.magnitudeconverter;

import android.util.Log;

class NumberConversion {


    String numberSystemConversion(String value, String convertFrom, String convertTo){
        //input 5 , decimal,binary
        String finalconverted=null;
        switch (convertFrom) {
            case "Decimal":
                switch (convertTo) {
                    case "Binary": {
                        Log.e("time","error");
                        int decimal;
                        decimal = Integer.parseInt(value);
                        finalconverted = Integer.toBinaryString(decimal);
                        break;
                    }
                    case "Octal": {
                        int decimal;
                        decimal = Integer.parseInt(value);
                        finalconverted = Integer.toString(decimal, 8);
                        break;
                    }
                    case "Hexadecimal": {
                        int decimal;
                        decimal = Integer.parseInt(value);
                        finalconverted = Integer.toHexString(decimal);
                        break;
                    }

                    case "Decimal": {
                        int decimal;
                        decimal = Integer.parseInt(value);
                        finalconverted = Integer.toString(decimal);
                        break;
                    }
                }
                break;
            case "Binary":
                switch (convertTo) {
                    case "Decimal":
                            try {
                                finalconverted = String.valueOf(Integer.parseInt(value, 2));
                            }
                            catch (NumberFormatException e){
                                finalconverted="Please input binary number";
                            }
                        break;
                    case "Octal":
                        try{
                            long l = Long.parseLong(value, 2);
                            finalconverted = Long.toOctalString(l);
                        }catch (NumberFormatException e){
                            finalconverted="Please input binary number";
                        }


                        break;
                    case "Hexadecimal":
                        try{
                            int decimal = Integer.parseInt(value, 2);
                            finalconverted = Integer.toString(decimal, 16);

                        }catch (NumberFormatException e){
                            finalconverted="Please input binary number";
                        }

                        break;
                }
                break;
            case "Octal":
                switch (convertTo) {
                    case "Decimal": {
                        int decimal = Integer.parseInt(value, 8);
                        finalconverted = String.valueOf(decimal);
                        break;
                    }
                    case "Binary": {
                        int decimal = Integer.parseInt(value, 8);
                        finalconverted = Integer.toBinaryString(decimal);
                        break;
                    }
                    case "Hexadecimal": {
                        int decimal = Integer.parseInt(value, 8);
                        finalconverted = Integer.toHexString(decimal);
                        break;
                    }
                }
                break;
            case "Hexadecimal":
                switch (convertTo) {
                    case "Decimal": {


                        try{
                            int hexadecimal = Integer.parseInt(value, 16);
                            finalconverted = String.valueOf(hexadecimal);

                        }catch(NumberFormatException e){

                            finalconverted="Please input Hexadecimal number";
                        }

                        break;
                    }
                    case "Binary": {

                        try{
                            int hexadecimal = Integer.parseInt(value, 16);
                            finalconverted = Integer.toBinaryString(hexadecimal);

                        }catch (NumberFormatException e){

                            finalconverted="Please input Hexadecimal number";
                        }

                        break;
                    }
                    case "Octal": {

                        try{
                            int hexadecimal = Integer.parseInt(value, 16);
                            finalconverted = Long.toOctalString(hexadecimal);

                        }catch (NumberFormatException e){
                            finalconverted="Please input Hexadecimal number";
                        }

                        break;
                    }
                }
                break;
        }
        return finalconverted;
    }
}

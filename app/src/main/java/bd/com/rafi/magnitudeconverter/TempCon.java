package bd.com.rafi.magnitudeconverter;

class TempCon {
    private String finalresult = null;
    String tempConversion(String value, String convertFrom, String convertTo) {
        double i = 0;
        try {
            i = Double.parseDouble(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (convertFrom) {
            case "Celsius":
                switch (convertTo) {
                    case "Fahrenheit":
                        finalresult = String.valueOf((i * (9 / 5)) + 32);
                        break;
                    case "Kelvin":
                        finalresult = String.valueOf(i + 273.15);
                        break;
                    case "Celsius":
                        finalresult = String.valueOf(i *1);
                        break;
                }
                break;
            case "Fahrenheit":
                switch (convertTo){
                    case "Celsius" :
                        finalresult = String.valueOf((i - 32)*(.55555));

                        break;
                    case "Kelvin" :
                        finalresult = String.valueOf((i - 32) *  (.55555) + 273.15);
                        break;

                    case "Fahrenheit" :
                        finalresult = String.valueOf(i *1);
                        break;
                }
                break;
            case "Kelvin":
                switch (convertTo){
                    case "Celsius":
                        finalresult = String.valueOf(i - 273.15);
                        break;
                    case "Fahrenheit":
                        finalresult = String.valueOf((i - 273.15) * (9 / 5) + 32);
                        break;

                    case "Kelvin":
                        finalresult = String.valueOf(i*1);
                        break;
                }
                break;
        }
            return finalresult;
        }
    }


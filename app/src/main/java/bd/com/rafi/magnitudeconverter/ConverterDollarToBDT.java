package bd.com.rafi.magnitudeconverter;


class ConverterDollarToBDT {

    float CurrencyConverter(float Dvalue, String convertFrom, String convertTo){
        /*Log.d("convertFrom2", convertFrom);
        Log.d("convertTo2", convertTo);*/
        switch (convertFrom) {
            case "USA(Dollar)":
                switch (convertTo) {
                    case "Bangladesh(Bdt)":
                        return (float) (Dvalue * 84.71);
                    case "India(Rupee)":
                        return (float) (Dvalue * 71.72);
                    case "Uk(Pound)":
                        return (float) (Dvalue * 0.77);
                    case "UAE(Dirham)":
                        return (float) (Dvalue * 3.67);
                    case "China(Yuan)":
                        return (float) (Dvalue * 7.03);
                    case "USA(Dollar)":
                        return (float) (Dvalue * 1.0);
                }
                break;
            case "Bangladesh(Bdt)":
                switch (convertTo) {
                    case "Bangladesh(Bdt)":
                        return (float) (Dvalue * 1.0);
                    case "India(Rupee)":
                        return (float) (Dvalue * 0.85);
                    case "Uk(Pound)":
                        return (float) (Dvalue * 0.0091);
                    case "UAE(Dirham)":
                        return (float) (Dvalue * 0.043);
                    case "China(Yuan)":
                        return (float) (Dvalue * 0.083);
                    case "USA(Dollar)":
                        return (float) (Dvalue * 0.012);
                }


                break;
            case "India(Rupee)":
                switch (convertTo) {
                    case "Bangladesh(Bdt)":
                        return (float) (Dvalue * 1.18);
                    case "India(Rupee)":
                        return (float) (Dvalue * 1.0);
                    case "Uk(Pound)":
                        return (float) (Dvalue * 0.011);
                    case "UAE(Dirham)":
                        return (float) (Dvalue * 0.051);
                    case "China(Yuan)":
                        return (float) (Dvalue * 0.098);
                    case "USA(Dollar)":
                        return (float) (Dvalue * 0.012);
                }

                break;
            case "Uk(Pound)":
                switch (convertTo) {
                    case "Bangladesh(Bdt)":
                        return (float) (Dvalue * 109.43);
                    case "India(Rupee)":
                        return (float) (Dvalue * 92.66);
                    case "Uk(Pound)":
                        return (float) (Dvalue * 1.0);
                    case "UAE(Dirham)":
                        return (float) (Dvalue * 4.75);
                    case "China(Yuan)":
                        return (float) (Dvalue * 9.09);
                    case "USA(Dollar)":
                        return (float) (Dvalue * 1.29);
                }

                break;
            case "UAE(Dirham)":
                switch (convertTo) {
                    case "Bangladesh(Bdt)":
                        return (float) (Dvalue * 23.07);
                    case "India(Rupee)":
                        return (float) (Dvalue * 19.53);
                    case "Uk(Pound)":
                        return (float) (Dvalue * 0.21);
                    case "UAE(Dirham)":
                        return (float) (Dvalue * 1.0);
                    case "China(Yuan)":
                        return (float) (Dvalue * 1.91);
                    case "USA(Dollar)":
                        return (float) (Dvalue * 0.27);
                }

                break;
            case "China(Yuan)":
                //else{
                switch (convertTo) {
                    case "Bangladesh(Bdt)":
                        return (float) (Dvalue * 12.04);
                    case "India(Rupee)":
                        return (float) (Dvalue * 10.20);
                    case "Uk(Pound)":
                        return (float) (Dvalue * 0.11);
                    case "UAE(Dirham)":
                        return (float) (Dvalue * 0.52);
                    case "China(Yuan)":
                        return (float) (Dvalue * 1.0);
                    case "USA(Dollar)":
                        return (float) (Dvalue * 0.14);
                }

                break;
        }


        return 0;
    }
}

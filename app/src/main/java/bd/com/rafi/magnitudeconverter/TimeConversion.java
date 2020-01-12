package bd.com.rafi.magnitudeconverter;

class TimeConversion {
    private String finalconverted;
    String time(String value, String convertFrom, String converTo) {
        ////converted from minute
        switch (convertFrom) {
            case "Minute":
                switch (converTo) {
                    case "Second":
                        Double minute;
                        minute = Double.parseDouble(value) * 60;
                        finalconverted = String.valueOf(minute);
                        break;
                    case "Hour":
                        double hour;
                        hour = Double.parseDouble(value) * 0.0166667;
                        finalconverted = String.valueOf(hour);
                        break;
                    case "Day":

                        double day;
                        day = Double.parseDouble(value) * 0.000694444;
                        finalconverted = String.valueOf(day);
                        break;
                    case "Week":
                        double week;
                        week = Double.parseDouble(value) * 9.9206e-5;
                        finalconverted = String.valueOf(week);
                        break;
                    case "Month":
                        double month;
                        month = Double.parseDouble(value) * 2.2831e-5;
                        finalconverted = String.valueOf(month);
                        break;
                    case "Year":
                        double year;
                        year = Double.parseDouble(value) * 1.9026e-6;
                        finalconverted = String.valueOf(year);
                        break;
                    case "Minute":
                        double same;
                        same = Double.parseDouble(value) * 1;
                        finalconverted = String.valueOf(same);
                        break;
                }
                break;

            //converted from secend
            case "Second":
                switch (converTo) {
                    case "Minute":
                        double secend;
                        secend = Double.parseDouble(value) * 0.0166667;
                        finalconverted = String.valueOf(secend);
                        break;
                    case "Hour":
                        double hour;
                        hour = Double.parseDouble(value) * 0.000277778;
                        finalconverted = String.valueOf(hour);
                        break;
                    case "Day":
                        double day;
                        day = Double.parseDouble(value) * 1.1574e-5;
                        finalconverted = String.valueOf(day);
                        break;
                    case "Week":
                        double week;
                        week = Double.parseDouble(value) * 1.6534e-6;
                        finalconverted = String.valueOf(week);
                        break;
                    case "Month":
                        double month;
                        month = Double.parseDouble(value) * 3.8052e-7;
                        finalconverted = String.valueOf(month);
                        break;
                    case "Year":
                        double year;
                        year = Double.parseDouble(value) * 3.171e-8;
                        finalconverted = String.valueOf(year);
                        break;
                }
                break;
            ////converted from hour
            case "Hour":
                switch (converTo) {
                    case "Minute":
                        double minute;
                        minute = Double.parseDouble(value) * 60;
                        finalconverted = String.valueOf(minute);
                        break;
                    case "Second":
                        double secend;
                        secend = Double.parseDouble(value) * 3600;
                        finalconverted = String.valueOf(secend);
                        break;
                    case "Day":
                        double day;
                        day = Double.parseDouble(value) * 0.0416667;
                        finalconverted = String.valueOf(day);
                        break;
                    case "Week":
                        double week;
                        week = Double.parseDouble(value) * 0.00595238;
                        finalconverted = String.valueOf(week);
                        break;
                    case "Month":
                        double month;
                        month = Double.parseDouble(value) * 0.00136986;
                        finalconverted = String.valueOf(month);
                        break;
                    case "Year":
                        double year;
                        year = Double.parseDouble(value) * 0.000114155;
                        finalconverted = String.valueOf(year);
                        break;
                }
                break;
            //converted from day
            case "Day":
                switch (converTo) {
                    case "Minute":
                        double minute;
                        minute = Double.parseDouble(value) * 1440;
                        finalconverted = String.valueOf(minute);
                        break;
                    case "Second":
                        double secend;
                        secend = Double.parseDouble(value) * 86400;
                        finalconverted = String.valueOf(secend);
                        break;
                    case "Hour":
                        double hour;
                        hour = Double.parseDouble(value) * 24;
                        finalconverted = String.valueOf(hour);
                        break;
                    case "Week":
                        double week;
                        week = Double.parseDouble(value) * 0.142857;
                        finalconverted = String.valueOf(week);
                        break;
                    case "Month":
                        double month;
                        month = Double.parseDouble(value) * 0.0328767;
                        finalconverted = String.valueOf(month);
                        break;
                    case "Year":
                        double year;
                        year = Double.parseDouble(value) * 0.00273973;
                        finalconverted = String.valueOf(year);
                        break;
                }
                break;
            //converted from week
            case "Week":
                switch (converTo) {
                    case "Hour":
                        double hour;
                        hour = Double.parseDouble(value) * 168;
                        finalconverted = String.valueOf(hour);
                        break;
                    case "Minute":
                        double minute;
                        minute = Double.parseDouble(value) * 10080;
                        finalconverted = String.valueOf(minute);
                        break;
                    case "Second":
                        double secend;
                        secend = Double.parseDouble(value) * 604800;
                        finalconverted = String.valueOf(secend);
                        break;
                    case "Day":
                        double day;
                        day = Double.parseDouble(value) * 7;
                        finalconverted = String.valueOf(day);
                        break;
                    case "Month":
                        double month;
                        month = Double.parseDouble(value) * 0.230137;
                        finalconverted = String.valueOf(month);
                        break;
                    case "Year":
                        double year;
                        year = Double.parseDouble(value) * 0.0191781;
                        finalconverted = String.valueOf(year);
                        break;
                }
                break;
            //converted from month
            case "Month":
                switch (converTo) {
                    case "Hour":
                        double hour;
                        hour = Double.parseDouble(value) * 730.001;
                        finalconverted = String.valueOf(hour);
                        break;
                    case "Minute":
                        double minute;
                        minute = Double.parseDouble(value) * 43800;
                        finalconverted = String.valueOf(minute);
                        break;
                    case "Second":
                        double secend;
                        secend = Double.parseDouble(value) * 2.628e+6;
                        finalconverted = String.valueOf(secend);
                        break;
                    case "Day":
                        double day;
                        day = Double.parseDouble(value) * 30;
                        finalconverted = String.valueOf(day);
                        break;
                    case "Week":
                        double week;
                        week = Double.parseDouble(value) * 4.34524;
                        finalconverted = String.valueOf(week);
                        break;
                    case "Year":
                        double year;
                        year = Double.parseDouble(value) * 0.0833334;
                        finalconverted = String.valueOf(year);
                        break;
                }
                break;
            //converted from year
            case "Year":
                switch (converTo) {
                    case "Hour":
                        double hour;
                        hour = Double.parseDouble(value) * 8760;
                        finalconverted = String.valueOf(hour);
                        break;
                    case "Minute":
                        double minute;
                        minute = Double.parseDouble(value) * 525600;
                        finalconverted = String.valueOf(minute);
                        break;
                    case "Second":
                        double secend;
                        secend = Double.parseDouble(value) * 3.154e+7;
                        finalconverted = String.valueOf(secend);
                        break;
                    case "Month":
                        double month;
                        month = Double.parseDouble(value) * 12;
                        finalconverted = String.valueOf(month);
                        break;
                    case "Week":
                        double week;
                        week = Double.parseDouble(value) * 52.1429;
                        finalconverted = String.valueOf(week);
                        break;
                    case "Day":
                        double day;
                        day = Double.parseDouble(value) * 52.1429;
                        finalconverted = String.valueOf(day);
                        break;
                }
                break;
        }
        return finalconverted;
    }
}

package bd.com.rafi.magnitudeconverter;


class NumberToWords {

    static public class ScaleUnit {
        private int exponent;
        private String[] names;

        private ScaleUnit(int exponent, String... names) {
            this.exponent = exponent;
            this.names = names;
        }

        int getExponent() {
            return exponent;
        }

        String getName(int index) {
            return names[index];
        }
    }

    /**
     * See http://www.wordiq.com/definition/Names_of_large_numbers
     */
    static private ScaleUnit[] SCALE_UNITS = new ScaleUnit[] {
            new ScaleUnit(63, "vigintillion", "decilliard"),
            new ScaleUnit(60, "novemdecillion", "decillion"),
            new ScaleUnit(57, "octodecillion", "nonilliard"),
            new ScaleUnit(54, "septendecillion", "nonillion"),
            new ScaleUnit(51, "sexdecillion", "octilliard"),
            new ScaleUnit(48, "quindecillion", "octillion"),
            new ScaleUnit(45, "quattuordecillion", "septilliard"),
            new ScaleUnit(42, "tredecillion", "septillion"),
            new ScaleUnit(39, "duodecillion", "sextilliard"),
            new ScaleUnit(36, "undecillion", "sextillion"),
            new ScaleUnit(33, "decillion", "quintilliard"),
            new ScaleUnit(30, "nonillion", "quintillion"),
            new ScaleUnit(27, "octillion", "quadrilliard"),
            new ScaleUnit(24, "septillion", "quadrillion"),
            new ScaleUnit(21, "sextillion", "trilliard"),
            new ScaleUnit(18, "quintillion", "trillion"),
            new ScaleUnit(15, "quadrillion", "billiard"),
            new ScaleUnit(12, "trillion", "billion"),
            new ScaleUnit(9, "billion", "milliard"),
            new ScaleUnit(6, "million", "million"),
            new ScaleUnit(3, "thousand", "thousand"),
            new ScaleUnit(2, "hundred", "hundred"),
            // new ScaleUnit(1, "ten", "ten"),
            // new ScaleUnit(0, "one", "one"),
            new ScaleUnit(-1, "tenth", "tenth"),
            new ScaleUnit(-2, "hundredth", "hundredth"),
            new ScaleUnit(-3, "thousandth", "thousandth"),
            new ScaleUnit(-4, "ten-thousandth", "ten-thousandth"),
            new ScaleUnit(-5, "hundred-thousandth", "hundred-thousandth"),
            new ScaleUnit(-6, "millionth", "millionth"),
            new ScaleUnit(-7, "ten-millionth", "ten-millionth"),
            new ScaleUnit(-8, "hundred-millionth", "hundred-millionth"),
            new ScaleUnit(-9, "billionth", "milliardth"),
            new ScaleUnit(-10, "ten-billionth", "ten-milliardth"),
            new ScaleUnit(-11, "hundred-billionth", "hundred-milliardth"),
            new ScaleUnit(-12, "trillionth", "billionth"),
            new ScaleUnit(-13, "ten-trillionth", "ten-billionth"),
            new ScaleUnit(-14, "hundred-trillionth", "hundred-billionth"),
            new ScaleUnit(-15, "quadrillionth", "billiardth"),
            new ScaleUnit(-16, "ten-quadrillionth", "ten-billiardth"),
            new ScaleUnit(-17, "hundred-quadrillionth", "hundred-billiardth"),
            new ScaleUnit(-18, "quintillionth", "trillionth"),
            new ScaleUnit(-19, "ten-quintillionth", "ten-trillionth"),
            new ScaleUnit(-20, "hundred-quintillionth", "hundred-trillionth"),
            new ScaleUnit(-21, "sextillionth", "trilliardth"),
            new ScaleUnit(-22, "ten-sextillionth", "ten-trilliardth"),
            new ScaleUnit(-23, "hundred-sextillionth", "hundred-trilliardth"),
            new ScaleUnit(-24, "septillionth", "quadrillionth"),
            new ScaleUnit(-25, "ten-septillionth", "ten-quadrillionth"),
            new ScaleUnit(-26, "hundred-septillionth", "hundred-quadrillionth"), };

    public enum Scale {
        SHORT;

        public String getName(int exponent) {
            for (ScaleUnit unit : SCALE_UNITS) {
                if (unit.getExponent() == exponent) {
                    return unit.getName(this.ordinal());
                }
            }
            return "";
        }
    }

    /**
     * Change this scale to support American and modern British value (short scale) or Traditional
     * British value (long scale)
     */
    private static Scale SCALE = Scale.SHORT;

    static abstract public class AbstractProcessor {

        static final String SEPARATOR = " ";
        static final int NO_VALUE = -1;


        String getName(long value) {
            return getName(Long.toString(value));
        }



        abstract public String getName(String value);
    }

    static public class UnitProcessor extends AbstractProcessor {

        static private final String[] TOKENS = new String[] { "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

        @Override
        public String getName(String value) {
            StringBuilder buffer = new StringBuilder();

            int offset = NO_VALUE;
            int number;
            if (value.length() > 3) {
                number = Integer.valueOf(value.substring(value.length() - 3), 10);
            } else {
                number = Integer.valueOf(value, 10);
            }
            number %= 100;
            if (number < 10) {
                offset = (number % 10) - 1;
                // number /= 10;
            } else if (number < 20) {
                offset = (number % 20) - 1;
                // number /= 100;
            }

            if (offset != NO_VALUE && offset < TOKENS.length) {
                buffer.append(TOKENS[offset]);
            }

            return buffer.toString();
        }

    }

    static public class TensProcessor extends AbstractProcessor {

        static private final String[] TOKENS = new String[] { "twenty", "thirty", "fourty",
                "fifty", "sixty", "seventy", "eighty", "ninety" };

        static private final String UNION_SEPARATOR = "-";

        private UnitProcessor unitProcessor = new UnitProcessor();

        @Override
        public String getName(String value) {
            StringBuilder buffer = new StringBuilder();
            boolean tensFound = false;

            int number;
            if (value.length() > 3) {
                number = Integer.valueOf(value.substring(value.length() - 3), 10);
            } else {
                number = Integer.valueOf(value, 10);
            }
            number %= 100; // keep only two digits
            if (number >= 20) {
                buffer.append(TOKENS[(number / 10) - 2]);
                number %= 10;
                tensFound = true;
            } else {
                number %= 20;
            }

            if (number != 0) {
                if (tensFound) {
                    buffer.append(UNION_SEPARATOR);
                }
                buffer.append(unitProcessor.getName(number));
            }

            return buffer.toString();
        }
    }

    static public class HundredProcessor extends AbstractProcessor {

        private UnitProcessor unitProcessor = new UnitProcessor();
        private TensProcessor tensProcessor = new TensProcessor();

        @Override
        public String getName(String value) {
            StringBuilder buffer = new StringBuilder();

            int number;
            if ("".equals(value)) {
                number = 0;
            } else if (value.length() > 4) {
                number = Integer.valueOf(value.substring(value.length() - 4), 10);
            } else {
                number = Integer.valueOf(value, 10);
            }
            number %= 1000; // keep at least three digits

            if (number >= 100) {
                buffer.append(unitProcessor.getName(number / 100));
                buffer.append(SEPARATOR);
                int EXPONENT = 2;
                buffer.append(SCALE.getName(EXPONENT));
            }

            String tensName = tensProcessor.getName(number % 100);

            if (!"".equals(tensName) && (number >= 100)) {
                buffer.append(SEPARATOR);
            }
            buffer.append(tensName);

            return buffer.toString();
        }
    }

    static public class CompositeBigProcessor extends AbstractProcessor {

        private HundredProcessor hundredProcessor = new HundredProcessor();
        private AbstractProcessor lowProcessor;
        private int exponent;

        CompositeBigProcessor(int exponent) {
            if (exponent <= 3) {
                lowProcessor = hundredProcessor;
            } else {
                lowProcessor = new CompositeBigProcessor(exponent - 3);
            }
            this.exponent = exponent;
        }

        String getToken() {
            return SCALE.getName(getPartDivider());
        }

        AbstractProcessor getHighProcessor() {
            return hundredProcessor;
        }

        AbstractProcessor getLowProcessor() {
            return lowProcessor;
        }

        int getPartDivider() {
            return exponent;
        }

        @Override
        public String getName(String value) {
            StringBuilder buffer = new StringBuilder();

            String high, low;
            if (value.length() < getPartDivider()) {
                high = "";
                low = value;
            } else {
                int index = value.length() - getPartDivider();
                high = value.substring(0, index);
                low = value.substring(index);
            }

            String highName = getHighProcessor().getName(high);
            String lowName = getLowProcessor().getName(low);

            if (!"".equals(highName)) {
                buffer.append(highName);
                buffer.append(SEPARATOR);
                buffer.append(getToken());

                if (!"".equals(lowName)) {
                    buffer.append(SEPARATOR);
                }
            }

            if (!"".equals(lowName)) {
                buffer.append(lowName);
            }

            return buffer.toString();
        }
    }

    static public class DefaultProcessor extends AbstractProcessor {

        private AbstractProcessor processor = new CompositeBigProcessor(63);

        @Override
        public String getName(String value) {
            boolean negative = false;
            if (value.startsWith("-")) {
                negative = true;
                value = value.substring(1);
            }

            int decimals = value.indexOf(".");
            String decimalValue = null;
            if (0 <= decimals) {
                decimalValue = value.substring(decimals + 1);
                value = value.substring(0, decimals);
            }

            String name = processor.getName(value);

            if ("".equals(name)) {
                name = "zero";
            } else if (negative) {
                String MINUS = "minus";
                name = MINUS.concat(SEPARATOR).concat(name);
            }

            if (!(null == decimalValue || "".equals(decimalValue))) {

                StringBuilder zeroDecimalValue = new StringBuilder();
                for (int i = 0; i < decimalValue.length(); i++) {
                    zeroDecimalValue.append("0");
                }
                String UNION_AND = "and";
                String concat = name.concat(SEPARATOR).concat(UNION_AND).concat(SEPARATOR);
                if (decimalValue.equals(zeroDecimalValue.toString())) {
                    name = concat.concat(
                            "zero").concat(SEPARATOR).concat(
                            SCALE.getName(-decimalValue.length()));
                } else {
                    name = concat.concat(
                            processor.getName(decimalValue)).concat(SEPARATOR).concat(
                            SCALE.getName(-decimalValue.length()));
                }

            }

            return name;
        }
    }
    }

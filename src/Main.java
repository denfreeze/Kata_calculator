import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = console.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        Scanner scanner = new Scanner(input);
        String first = scanner.next();
        String operator = scanner.next();
        String second = scanner.next();
        boolean isRoman;
        int a;
        int b;


        if(RomanCalc.isRoman(first) && RomanCalc.isRoman(second)){
            a = RomanCalc.convertToArabian(first);
            b = RomanCalc.convertToArabian(second);
            isRoman = true;
        } else if(!RomanCalc.isRoman(first) && !RomanCalc.isRoman(second)) {
            a = Integer.parseInt(first);
            b = Integer.parseInt(second);
            isRoman = false;
        }
        else {
            throw new Exception("Разный формат чисел");
        }

        if(a > 10 || b > 10) {
            throw new Exception("Одно из значений больше 10");
        }
        
        if(scanner.hasNext()) {
            throw new Exception("Превышение количества входных значений");
        }

        int result;
        switch(operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception("Делить на ноль нельзя!");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Неизвестный оператор");
        }
        if(isRoman) {
            if(result <= 0) {
                throw new Exception("Результат в римских цифрах не может быть меньше или равен нулю");
            }
            return RomanCalc.convertToRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    public static class RomanCalc {
        static String [] numerals = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

        public static boolean isRoman(String res) {
            for(int i = 0; i < numerals.length; i++) {
                if(res.equals(numerals[i])) {
                    return true;
                }
            }
            return false;
        }
        public static int convertToArabian(String roman) {
            for(int i = 0; i < numerals.length; i++) {
                if(roman.equals(numerals[i])) {
                    return i;
                }
            }
            return -1;
        }

        public static String convertToRoman(int arabian) {
            return numerals[arabian];
        }
    }
}
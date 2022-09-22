public class ReverseString {
    public static void main(String[] args) {
        String test = "Geeks";
        String result = "";

        for (int i = 0; i < test.length(); i++) {
            result = test.charAt(i) + result;
        }

        System.out.println(result);
    }
}

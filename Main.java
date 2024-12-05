public class Main {
    public static void main(String[] args) {
        String word = "Cordilleras";

        for (int i = 0; i < word.length(); i++) {
            if(i ==5)
                break;
            System.out.println(word.charAt(i));
        }
    }
}
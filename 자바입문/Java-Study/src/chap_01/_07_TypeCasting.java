package chap_01;

public class _07_TypeCasting {
    public static void main(String[] args) {
        int score = 93;
        System.out.println(score);
        System.out.println((float) score);

        // 숫자를 문자열로
        String s1 = String.valueOf(93);

        // 정수를 문자열로
        s1 = Integer.toString(93);
    }
}

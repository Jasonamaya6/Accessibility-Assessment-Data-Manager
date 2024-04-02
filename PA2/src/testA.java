
public class testA {

    public static void main(String args[]) {

        int[] rat = new int[5];
        for (int i = 0; i < rat.length; i++) {
            if (i == 0 || i == 4) {
                continue;
            }
            rat[i] = 6;
            System.out.println(rat[i]);
        }

    }
}

// 1.1 - Task 02

public class Tree_02 {
    public static void main(String[] args) {
        int lines = 3;
        int stars = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = lines; j > 0; j--) {
                System.out.print(" ");
            }

            lines--;

            for (int k = 0; k < stars; k++) {
                System.out.print("*");
            }

            stars += 2;

            System.out.println();
        }
    }
}

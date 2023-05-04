package css;

public class StarMaker {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 5;

        for (int i = 1; i <= x * 2 - 1; i++) {
            if (i <= x) {
                for (int j = 1; j < i; j++) {

                    System.out.print(" ");

                }
            } else {
                for (int j = x * 2 - 1; j > i; j--) {
                    System.out.print(" ");
                }
            }
            if (i == 1 || i == x * 2 - 1) {

                for (int j = 0; j < x; j++) {
                    System.out.print("*");
                }

            } else {

                for (int j = 0; j < x; j++) {

                    if (j == 0 || j == x - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                }

            }

            if (x <= 2) {
                System.out.print(" ");

            } else {
                for (int j = 2*x-1; j > i; j--) {
                    System.out.print(" ");
                }
            }
            if (i == 1 || i == x * 2 - 1) {

                for (int j = 0; j < x; j++) {
                    System.out.print("*");
                }

            } else {

                for (int j = 0; j < x; j++) {

                    if (j == 0 || j == x - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }

                }

            }

            System.out.println();

        }

    }

}

package Arrays;

public class Ex3 {

    public static void main(String[] args) {
        int[][] intMatrix = new int[3][3];

        intMatrix[0][0] = 11;
        intMatrix[2][2] = 22;

        for (int[] i: intMatrix){
            for (int j : i){
                System.out.print(j + " " );
            }
            System.out.println();
        }
        System.out.println();

        char[][] multidimCharArray = {{'c', 'f'}, {'2'}, {'j', 'a', 'v', 'a'}};

        System.out.println(multidimCharArray);
        System.out.println();

        for(char[] row :multidimCharArray){
            for(char c : row){
                System.out.println(c);
            }
            System.out.println();
        }

        System.out.println();

        int [][] ints = new int[3][];

        ints[0] = new int[2];
        ints[0][0] = 1;
        ints[0][1] = 2;

        ints[1] = new int[]{4, 5, 67};
        ints[2] = new int[]{33, 44};
        displayArrayValues(ints);

        }
        private static void displayArrayValues(int[][] input){
            for (int[] i : input){
                for(int j : i){
                    System.out.print(j + " ");
                }
                System.out.println();
            }

        }
}


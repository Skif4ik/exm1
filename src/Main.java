import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 10;
        int[] arr1 = new int[SIZE];

        int d1 = -50, d2 = 50;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * (d2 - d1 + 1) + d1);
        }

        final String FILE_NAME = "src/array.txt";
        //File file = new File(FILE_NAME);

        System.out.println(Arrays.toString(arr1));
        //если такого файла небыло, то поток вывода его создаст
        //если такой файл был, то поток ввода перезапишет его содержимое
        //(new FileWriter(FILE_NAME, true))) при наличии true будет осуществлена дозапись в конец файла
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (int elem : arr1) {
                bw.write(elem * 2 + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr2 = new int[arr1.length];
        int index = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){

            String fileLine = br.readLine().trim();
            String[] elems = fileLine.split(" ");
            for (String elem : elems) {
                int x = Integer.parseInt(elem);
                if(x>0) {
                    arr2[index++] = x;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        arr2 = Arrays.copyOf(arr2, index);
        System.out.println(Arrays.toString(arr2));
    }
}

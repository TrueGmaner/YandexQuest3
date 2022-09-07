import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<Integer> givenArray = new ArrayList();
        for (int i = 0; i < n; i++) {
            givenArray.add(scanner.nextInt());
        }
        for (int i = 0; i <givenArray.size(); i++) {
            System.out.print(functionF(givenArray, i, k) + " ");
        }
    }

    public static int functionF(ArrayList<Integer> givenArray, int startIndex, int sizeOfSet){
        ArrayList S;
        int result;
        int min=-1;
        for (int i = 0; i < givenArray.size(); i++) {
            S = createS(i, startIndex, sizeOfSet, givenArray);
            result = dist(givenArray.get(startIndex), S);
            if ((min ==-1) || (result < min)){
                min=result;
            }
        }
        return min;
    }

    public static ArrayList<Integer> createS(int i, int startIndex, int sizeOfSet, ArrayList<Integer> givenArray){
        ArrayList S = new ArrayList();
        for (int j = 1; j <= sizeOfSet; j++) {
            if ((startIndex+i+j) % givenArray.size() != startIndex){
                S.add(givenArray.get((startIndex+i+j) % givenArray.size()));
            }
            else{
                sizeOfSet++;
                continue;
            }
        }
        return S;
    }

    public static int dist(int element, ArrayList<Integer> S){
        int result=0;
        for (int i = 0; i < S.size(); i++) {
            result=result+Math.abs(element-S.get(i));
        }
        return result;
    }
}
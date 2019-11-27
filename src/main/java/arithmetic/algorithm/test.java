package arithmetic.algorithm;

public class test {
    //TODO   这个题 不会做
    public int solution(int[] A, int X, int Y, int Z) {
        // write your code in Java SE 8
        boolean isXOccupied = false, isYOccupied, isZOccupied;

        int resultTime = 0;

        int length = A.length;

        for (int i = 0; i < length; i++) {

            int cur = A[i];
            if (!isXOccupied && cur <= X) {
                isXOccupied = true;
                X -= cur;

            }
        }
        return resultTime;

    }

    public static void main(String[] args) {

    }
}

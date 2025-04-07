package AlogoUndData.Blatt2;

public class Aufgabe5 {

    public long rekursiv(int m, int k) {
        if (k < 0 || k > m) {
            return 0;
        }
        if (k == 0 || k == m) {
            return 1;
        }
        return rekursiv(m - 1, k - 1) + rekursiv(m - 1, k);
    }

    public long iterativ(int m, int k){
        if (k < 0 || k > m) {
            return 0;
        }
        if (k == 0 || k == m) {
            return 1;
        }
        long result = 0;

        for(int i = 1; i<= k; i++){
            result += result * (m - i + 1) / i;
        }
        return result;
    }

}

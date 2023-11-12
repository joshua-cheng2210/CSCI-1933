public class Histogram {
    static int[] chart;
    static int lower;
    static int upper;
    public Histogram(int lowerbound, int upperbound){
        lower = lowerbound;
        upper = upperbound;
        chart = new int[upper + 1];
        for (int i = lower; i < chart.length; i++){
            chart[i] = 0;
        }
    }

    public boolean add(int i){
        if (i >= lower && i <= upper){
            chart[i] += 1;
            return true;
        }else { 
            return false;
        }
    }

    public String toString(){
        String string = "";
        for (int x = lower; x <= upper; x++){
            string += x;
            string += ": ";
            for (int start = 0; start < chart[x]; start++){
                string += "*";
            }
            string += "\n";
        }
        return string;
    }
}    

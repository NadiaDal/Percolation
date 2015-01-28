/**
 * Created by daln on 1/28/2015.
 */
public class Percolation {
    private boolean[] sites;
    private int N;

    public Percolation(int N) {
        sites = new boolean[N * N]; // create N-by-N grid, with all sites blocked
        this.N = N;
    }

    public static void main(String[] args) {
    }  // test client (optional)

    public void open(int i, int j) {
        checkArg(i);
        checkArg(j);
        if (isOpen(i, j)) return;
        sites[convert(i, j)] = true;// open site (row i, column j) if it is not open already{
    }


    public boolean isOpen(int i, int j) {
        checkArg(i);
        checkArg(j);
        return sites[convert(i, j)]; // is site (row i, column j) open?
    }


    public boolean isFull(int i, int j)     // is site (row i, column j) full?{
    {
        checkArg(i);
        checkArg(j);
        if(i-1 >=0 && isOpen((i-1), j)) return true;
        else if (i+1 < N &&  isOpen((i+1),j)) return true;
        else if(j-1 >=0 &&  isOpen(i, (j+1))) return true;
        else if(j+1 < N &&  isOpen(i, (j-1))) return true;
        else return false;
    }

    public boolean percolates()             // does the system percolate?
    {
        for(int j =0; j < N; j++){
            if(isFull(N-1, j)) return true;
        }
        return false;
    }

    private void checkArg(int i) {
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
    }

    private int convert(int i, int j) {
        checkArg(i);
        checkArg(j);
        return (i - 1) * N + j;
    }
}

/**
 * Created by daln on 1/28/2015.
 */
public class Percolation {
    private boolean[] sites;
    private int N;

    public Percolation(int N) {
        sites = new boolean[N * N+1]; // create N-by-N grid, with all sites blocked
        this.N = N;
    }

    public static void main(String[] args) {
//        Percolation p = new Percolation(20);
//        System.out.println(p.convert(1,1));
//        System.out.println(p.convert(1,2));
//        System.out.println(p.convert(20,20));

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
        if(i > 1 && isOpen((i-1), j)) return true;
        else if (i < N &&  isOpen((i+1),j)) return true;
        else if(j < N &&  isOpen(i, (j+1))) return true;
        else if( j > 1 &&  isOpen(i, (j-1))) return true;
        else return false;
    }

    public boolean percolates()             // does the system percolate?
    {
        for(int j = 1; j <= N; j++){
            if(isFull(N, j)) return true;
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

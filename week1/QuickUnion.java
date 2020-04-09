package week1;

import java.util.Arrays;

public class QuickUnion {

    private int[] id;

    public static void main(String[] args) {

        QuickUnion qu = new QuickUnion(10);
        try{
            qu.union(1,2);
            qu.print();
            qu.union(1,3);
            qu.print();
            qu.union(0,4);
            qu.print();
            qu.union(4,5);
            qu.print();
            System.out.println(qu.isConnected(0, 1));
            System.out.println(qu.isConnected(1, 3));

        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }

    QuickUnion(int n) {
        id = new int[n];
        for(int i=0; i<n; i++){
            id[i] = i;
        }

    }

    public int findRoot(int p){
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q){
        return findRoot(p)==findRoot(q);
    }

    public void union(int p, int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        id[pRoot] = qRoot;
    }

    public void print(){
        System.out.println(Arrays.toString(id));
    }
}
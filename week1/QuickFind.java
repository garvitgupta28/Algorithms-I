package week1;

import java.util.Arrays;

import javax.naming.directory.InvalidAttributeValueException;

public class QuickFind{

    private int[] id;


    public static void main(String[] args) {

        QuickFind qf = new QuickFind(10);
        try{
            qf.union(1,2);
            qf.union(2,3);
            qf.union(0,4);
            qf.union(4,5);
            System.out.println(qf.isConnected(0, 1));
            System.out.println(qf.isConnected(1, 3));

        }
        catch(Exception e){
            System.out.println(e);
        }
        
        qf.print();
        
    }

    QuickFind(int n){
        id = new int[n];
        for(int i=0; i<n; i++){
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) throws InvalidAttributeValueException{
        if(p < 0 || q < 0){
            throw new InvalidAttributeValueException("p,q must be non negative integers.");
        }
        return id[p] == id[q];
    }
    
    public void union(int p, int q) throws InvalidAttributeValueException{
        if(p < 0 || q < 0){
            throw new InvalidAttributeValueException("p,q must be non negative integers.");
        }
        if(id[p] == id[q]){
            return;
        }

        int pValue = id[p];
        int qValue = id[q];

        for(int i=0; i<id.length; i++){
            if(id[i] == pValue){
                id[i] = qValue;
            }
        }

    }

    public void print(){
        System.out.println(Arrays.toString(id));
    }

}
package test;



public class test {
    public static void main(String[] args) {
        long [] a=new long[100];
        a[0]=1;
        a[1]=1;
        for(int i=2;i<=50;i++){
            a[i]=a[i-1]+a[i-2];
        }
        for(int i=0;i<=50;i++){
            System.out.print(a[i]+",");
        }

    }
}

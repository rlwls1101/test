import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p_dfs와bfs {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        int arr[][] = new int [n+1][n+1];
        for(int i=0; i<m ; i++){
            int tmp= sc.nextInt();
            int tmp1=sc.nextInt();
            arr[tmp][tmp1]=1;
            arr[tmp1][tmp]=1;
        }
        boolean [] check = new boolean[n+1];
        System.out.print(s+" ");
        check[s]=true;
        dfs(arr,check,s);
        System.out.println();
        boolean [] check1 = new boolean[n+1];
        check1[s]=true;
        Queue <Integer>q = new LinkedList<Integer>();
        q.add(s);
        bfs(arr,check1,s,q);
    //start 에서 boolean 으로 정점 방문했는지 검사후 아니면 방문

    }
    static void dfs(int[][] arr, boolean[] check, int s){
        for(int i=1; i<=arr[0].length-1; i++){
            if(arr[s][i]==1&&!check[i]) {
                check[i]=true;
                System.out.print(i+" ");
                dfs(arr, check, i);
            }
        }
    }
    static void bfs(int[][]arr, boolean[] check,int s,Queue q){
        while(!q.isEmpty()){
            int tmp= (int) q.poll();
            System.out.print(tmp+" ");

            for(int i=1; i<=arr[0].length-1;i++){
                if(arr[tmp][i]==1&&!check[i]){
                    check[i]=true;
                    q.add(i);
                }
            }
        }
    }
}

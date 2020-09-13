import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int T=sc.nextInt();
            for(int t=0;t<T;t++){
                int n=sc.nextInt();
                int m=sc.nextInt();
                int k=sc.nextInt();
                List<int[]>[] arr=new List[n+1];
                for(int i=0;i<=n;i++){
                    arr[i]=new ArrayList<>();
                }
                for(int i=0;i<m;i++){
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    int money=sc.nextInt();
                    arr[a].add(new int[]{b,money});
                    arr[b].add(new int[]{a,money});
                }

                if(k<n-1){
                    System.out.println("No");
                    continue;
                }
                Queue<Integer> queue=new LinkedList<>();
                Set<Integer> set=new HashSet<>();
                queue.add(1);
                set.add(1);
                boolean flag=false;
                while(!queue.isEmpty()){
                    int num=queue.poll();
                    for(int[] city:arr[num]){
                        int b=city[0];
                        int money=city[1];
                        if(!set.contains(b)&&money<=k){
                            set.add(b);
                            queue.offer(b);
                        }
                    }

                    if(set.size()==n){
                        System.out.println("Yes");
                        flag=true;
                        break;
                    }
                }

                if(!flag){
                    System.out.println("No");
                }
            }
        }
    }
}

/*
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=Integer.parseInt(sc.nextLine());
            String line=sc.nextLine();
            StringBuilder res=new StringBuilder();
            for(int i=0;i<line.length();i+=n){
                int end=Math.min(i+n-1,line.length()-1);
                res.append(reverse(line,i,end));
            }
            System.out.println(res);
        }
    }

    private static StringBuilder reverse(String str,int begin,int end){
        StringBuilder sb=new StringBuilder();
        for(int i=end;i>=begin;i--){
            sb.append(str.charAt(i));
        }
        return sb;
    }
}
*/

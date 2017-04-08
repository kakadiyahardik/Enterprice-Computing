package Algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        
        for(int j=0;j<t;j++)
        {
            String str=sc.next().trim();
           
            boolean c[]=new boolean[26];
            int ba[]=new int[26];
            
            char st[]=str.toCharArray();
            int l=st.length;
            int f=0;
            int cnt=0;
               
            for(int i=l-1;i>0;i--)
            {
                int ch=(int)(st[i]-97);
                c[ch]=true;
                ba[ch]=i;
                if(st[i]==st[i-1])
                {
                    cnt++;
                }
                else if(st[i]>st[i-1])
                {
                    for(int k=0;k<26;k++)
                    {
                        char tm=(char)(k+97);
                        if(c[k]==true && tm>st[i-1])
                        {
                            char tmp=st[i-1];
                            st[i-1]=st[ba[k]];
                            st[ba[k]]=tmp;
                            
                            f=1;
                            Arrays.sort(st,i,l);
                            break;
                        }
                    }
                }
                
                if(cnt==l-1)
                {
                    System.out.println("no answer");
                    break;
                }
                if(f==1)
                {
                    String ne=new String(st);
                    System.out.println(ne);
                    break;
                }
            }
        }
    }
}

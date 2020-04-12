import java.util.*;


import java.io.PrintWriter;

public class OsInput
{
public static void main(String [] args) throws Exception
{
Scanner sc=new Scanner(System.in);
System.out.println ("enter no of process:");
int n= sc.nextInt();

        java.io.File file = new java.io.File("D:\\inpset4.txt");
         if(file.exists())
{
System.out.println("alraedy");
System.exit(0);
}
java.io.PrintWriter output=new java.io.PrintWriter(file);

for(int o=0;o<50;o++)
{
int [] p=new int[5];
p[0]=1;
p[1]=2;
p[2]=3;
p[3]=4;
p[4]=5;
int [] a=new int[5];
a[0]=(int)(Math.random()*10);
a[1]=(int)(Math.random()*10);
a[2]=(int)(Math.random()*10);
a[3]=(int)(Math.random()*10);
a[4]=(int)(Math.random()*10);
int [] b=new int[5];
b[0]=(int)(Math.random()*10);
b[1]=(int)(Math.random()*10);
b[2]=(int)(Math.random()*10);
b[3]=(int)(Math.random()*10);
b[4]=(int)(Math.random()*10);
for(int j=0;j<b.length;j++)
{
if(b[0]==0||b[1]==0||b[2]==0||b[3]==0||b[4]==0)


b[0]+=1;
b[1]+=1;
b[2]+=1;
b[3]+=1;
b[4]+=1;
}
//output .println(" PR "+"   "+"AT"+"   "+"BT"+"   "+"TAT"+"   "+"WT");
 for(int k=0;k<p.length;k++)
    {
    output.println(p[k] +"\t"+ a[k]+"\t"+b[k] +"\t");
} 
}   
    output.close();

}
}
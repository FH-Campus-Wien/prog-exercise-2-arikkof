package at.ac.fhcampuswien;

// import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Locale;

public class App {

    //todo Task 1
    public void largestNumber(){

        Scanner scanner = new Scanner(System.in);
        float largest=0f;
        float nextFloat;
        for(int count = 1; ; count++) {
            System.out.print("Number " + count + ": ");
            nextFloat= scanner.nextFloat();
            if(nextFloat<=0&&count==1) {System.out.println("No number entered.");break;}
            if(nextFloat>largest){largest=nextFloat;}
            if(nextFloat<=0){
                System.out.print("The largest number is ");
                System.out.printf("%.2f", largest);
                System.out.println();
                break;
            }

            //System.out.println("Current def locale: " + Locale.getDefault());

        }
    }

    //todo Task 2
    public void stairs(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = scanner.nextInt();
        int k=0;
        if(n<=0){
            System.out.println("Invalid number!");
        } else {
            for (int i=1;i<=n;i++) {

                //System.out.print(i+" ");
                for(int j=0;j<i;j++) {
                    k++;
                    System.out.print(k+" ");
                }
                System.out.println();
            }
        }
    }

    //todo Task 3
    public void printPyramid(){
        final int n;
        n=6;
        for(int i=n;i>0;i--){
            for(int j=i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int k=0;k<((n-i)*2)+1;k++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    //todo Task 4
    public void printRhombus(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("h: ");
        int n = scanner.nextInt();
        System.out.print("c: ");
        char c = scanner.next().charAt(0);
        if(n%2==0){
            System.out.println("Invalid number!");
        } else {
            for (int i = n/2; i > 0; i--) {
                for (int j = i ; j > 0; j--) {
                    System.out.print(" ");
                }
                int b = ((n/2 - i) * 2) + 1;
                for (int k = b/2; k > 0; k--) {
                        System.out.print((char) (int) (c - k));
                    }
                for (int l = 0; l < b/2+1; l++) {
                    System.out.print((char) (int) (c - l));
                }
                System.out.println();
                }
            for (int i = 1; i <= n/2+1; i++) {
                for (int j = i - 1; j > 0; j--) {
                    System.out.print(" ");
                }
                int b = ((n/2+1 - i) * 2) + 1;
                for (int k = b/2; k > 0; k--) {
                    System.out.print((char) (int) (c - k));
                }
                for (int l = 0; l < b/2+1; l++) {
                    System.out.print((char) (int) (c - l));
                }
                System.out.println();
            }
        }
    }

    //todo Task 5
    public void marks(){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.getDefault());
        float sum=0;
        int f=0;
        int count=1;
        boolean br=false;
        while(!br){
            System.out.print("Mark " + count + ": ");
            int next = scanner.nextInt();
            if(next==0){
                if(count==1){
                    System.out.printf("Average: %.2f", 0f);
                    System.out.println();
                    System.out.println("Negative marks: " + f);
                    br=true;
                } else {
                    System.out.printf("Average: %.2f", sum / (count - 1));
                    System.out.println();
                    System.out.println("Negative marks: " + f);
                    br = true;
                }
            } else if(next >= 1 && next <= 5){
                sum = sum + next;
                if(next==5){f++;}
                count++;
            }
            else {
                System.out.println("Invalid mark!");
            }
        }
        }

    //todo Task 6
    public void happyNumbers(){
        Scanner sc=new Scanner(System.in);
        System.out.print("n: ");
        int n=sc.nextInt();
        boolean happy=false;
        boolean sad=false;
        while(!happy && !sad){
            if(n==1){
                happy=true;
                System.out.println("Happy number!");
            }
            else if (n==4){
                sad=true;
                System.out.println("Sad number!");
            }
            int[] digits = gimmeDigits(n);
            int sum=0;
            for(int digit : digits){
                sum+=Math.pow(digit,2);
                n=sum;
            }
        }
    }
    public static int[] gimmeDigits(int number){
        int length=(int)(Math.log10(number)+1);
        int[] ans=new int[length];
        for(int i=length-1;i>=0;i--){
            ans[i]=number%10;
            number=(number-ans[i])/10;
        }
        return ans;
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}
	package FirstPkg;
	import java.util.ArrayList;
	import java.util.Scanner;
	public class ModularSolver {
	    public static int gcd(int a, int b) {
	        int gcd;
	        if (a == 0) 
	            gcd = b;
	         else if (b == 0) 
	            gcd = a;
	         else 
	            while (a != b) {
	                if (a > b) 
	                    a -= b;
	                 else 
	                    b -= a;
	            }
	            gcd = a;
	        return gcd;
	    }
	    public static void solver() {
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.print("Enter a value: ");
	        int a_value = scanner.nextInt();
	        System.out.print("Enter b value: ");
	        int b_value = scanner.nextInt();
	        System.out.print("Enter mod value: ");
	        int mod_value = scanner.nextInt();
	        ArrayList <Integer> answer = new ArrayList<Integer> ();
	        int sol_count = 0, initial_sol = 0;
	        int d = gcd(a_value, mod_value);
	        if (d == 1) 
	            sol_count = 1;
	         else if (d != 1 && b_value % d == 0) 
	            sol_count = d;
	         else {
	            System.out.println("Solution is not possible");
	            sol_count = 0;
	        }
	        if (sol_count >= 1) {
	            int temp = 1;
	            int i = 1;
	            while (temp != 0) {
	                temp = ((a_value * i) - b_value) % mod_value;
	                i++;
	            }
	            i--;
	            initial_sol = i;
	            System.out.println("Initial solution: " + initial_sol);
	            for (int t = 0; answer.size()<d && temp < mod_value; t++) {
	                temp = initial_sol + ((mod_value / d) * t);
	                answer.add(temp);
	            }
	            System.out.println("Solutions: " + answer);
	        }
	        scanner.close();
	    }
	    public static void main(String[] args) {
	        	solver();
	    }
}

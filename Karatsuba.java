package math;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Karatsuba {
	public static void main(String[] args) {
		String ls = System.getProperty("line.separator");
		
		Karatsuba k = new Karatsuba();
		String isBreak = "";
		while(!isBreak.equals("q")) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Input first number: ");
			int x = sc.nextInt();
			System.out.print(ls+"Input second number: ");
			int y = sc.nextInt();
			
			int result = k.multiply(x, y);
			System.out.println(ls+"Result: "+result);
			System.out.println("Press any key to start over or 'q' to exit");
			isBreak = sc.next();
		}
	}
	
	private int multiply(int x, int y) {
		if (x < 10 || y < 10) {
			return x*y;
		}
		int[] xArr = splitInTwo(x);
		int[] yArr = splitInTwo(y);
		System.out.println(Arrays.toString(xArr));
		
		int n = xArr[2];
		double p1d = Math.pow(10d, (double) n);
		double p2d = Math.pow(10d, (double) n/2);
		int p1i = (int) p1d;
		int p2i = (int) p2d;
		int s1 = multiply(xArr[0], yArr[0]);
		int s2 = multiply(xArr[1], yArr[1]);
		int s3 = multiply((xArr[0] + xArr[1]), (yArr[0] + yArr[1])) - s1 - s2;

		return (p1i*s1)+(p2i*s3)+s2;
	}
	
	private int[] splitInTwo(int number) {
		String numStr = String.valueOf(number);
		int numLength = numStr.length();
		int halfIdx = numLength / 2;
		String num1 = numStr.substring(0, halfIdx);
		String num2 = numStr.substring(halfIdx);
		int[] split = {Integer.parseInt(num1), Integer.parseInt(num2), numLength};
		return split;
	}
}
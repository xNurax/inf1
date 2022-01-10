package blatt05;

public class gitTest {
String test ="test";
String hello ="hello000000000000000000";
static int x = 1;
static int t = 3;
public static void main(String[] args) {
	
    zurBasisKausgeben(12L,4);
}
static void zurBasisKausgeben(long n ,long k) {
	if (n<= 0L){
		System.out.println();
	}
	else {
		zurBasisKausgeben(n/k,k);
		System.out.print(n%k);
	}
}
}

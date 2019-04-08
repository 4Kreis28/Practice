package practice;
//お題：FizzBuzz
//1から100までの数をプリントするプログラムを書く
//ただし3の倍数の場合は値の変わりに'Fizz'を書く
//ただし5の倍数の場合は値の変わりに'Buzz'を書く
//ただし3の倍数かつ5の倍数の場合は値の変わりに'FizzBuzz'を書く

public class FizzBuzz{
	public static void main(String[] args){
		for(int num=1;num<=100;num++){
			if(num %3 ==0 && num %5 ==0){
				System.out.print("FizzBuzz");
				if(num!=100){
					System.out.print(",");
				}
			}else if(num%5 ==0){
				System.out.print("Buzz");
				if(num!=100){
					System.out.print(",");
				}
			}else if(num%3 ==0){
				System.out.print("Fizz");
				if(num!=100){
					System.out.print(",");
				}
			}else{
				System.out.print(num);
				if(num!=100){
					System.out.print(",");
				}
			}
		}
	}
}
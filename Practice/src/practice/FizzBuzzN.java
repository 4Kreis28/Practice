package practice;
import java.util.ArrayList;
//お題：FizzBuzzのNパターン
//1から100までの数をプリントするプログラムを書く
//これとは別に値と単語のセットを順に格納するものを用意する
//例：[3,"Fizz",5,"Buzz",7,"Hoge"]
//数が数値の倍数の時は対応する単語をプリント
//複数の数値の倍数の場合は対応する単語をリストの指定順で結合してプリント
//どの数値の倍数でもない場合は数をそのままプリントすること
import java.util.Scanner;

public class FizzBuzzN{
	public static void main(String[] args){
		//値と単語のセットを作成する準備
		Scanner sc = new Scanner(System.in);
		System.out.println("FizzBuzz用の値と単語のセットを作成します");
		System.out.print("何セット作成しますか？:");
		try{
		int setLength = sc.nextInt();
		if(setLength<0){
			System.out.println("セット数は1以上を入力してください");
			return;
		}
		ArrayList<Object> numWordSet = new ArrayList<>();
		//numWordSetに数値、"単語"の順番で格納していく
		for(int cycle=1;cycle<=setLength;cycle++){
			//値を挿入
			System.out.print(cycle+"番目に指定する倍数を入力：");
			int setNum = sc.nextInt();
			//ここに数値チェックをいれること

			System.out.print(cycle+"番目の倍数で該当した場合に出力する単語を入力：");
			String setWord = sc.next();
			//数値、単語の順番で格納
			numWordSet.add(setNum);
			numWordSet.add(setWord);
		}
		for(Object o : numWordSet){//テストコード
			System.out.print(o);
		}
		System.out.println("");
		//Objectのリストにセット完了
		//ここまでで数値、単語のセットの取得は完了した
		//次に検証する数値とヒットした場合の出力単語の組を作成する
		//↑考え方を変える。出力する値に対して格納された値で順番に
		//割っていく⇒該当したセットを出力という流れを組む。
		//100までのFizzBuzz
		for(int step = 1;step<=100;step++){
			//順に割っていくので割った結果値が何になったかを格納する箱を用意
			int NowNum = step;
			//FizzBuzzルールに該当した場合の出力する単語を格納する箱を用意
			ArrayList<String> outputWordBox= new ArrayList<>();
			//以下FizzBuzzの該当する値を走査していく
			for(int cycle=1;cycle<=setLength; cycle++){
				//数値が入っているのは各セットの1つ目なので2*cycle-1番目
				int divNum =new Integer(numWordSet.get(cycle*2-2).toString()).intValue();
				//割り切れる場合(剰余が0)
				if(NowNum%divNum==0){
					//NowNumの値を更新
					NowNum /=divNum;
					//出力する単語を格納
					outputWordBox.add(numWordSet.get(2*cycle-1).toString());
				}
			}//走査終了
			//対応したstepに対して出力を行う
			if(outputWordBox.size()!=0){//outputWordBoxに単語が入っている場合
				//outputWordBox内の単語を出力
				for(String s :outputWordBox){
					System.out.print(s);
				}
			}else{//outputWordBoxに単語が入っていない場合
				//stepをそのまま出力
				System.out.print(step);
			}
			if(step!=100){
			System.out.print(",");
			}
			//ここで1~100の値1個に対する出力終了
		}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

package practice;
/*4種類のアルファベット "A,C,G,T" から成るn文字の文字列のうち、
*"AAG"という並びが含まれる文字列を全て列挙するプログラムを書きなさい。
*ただし、nは3以上の整数とし、文字列内に同じアルファベットが出現しても構わないものとし、
*出力順序は問わないものとします。
*/

//上記の問題を解く用のテストコード等
//AAGString.javaで必要なメソッド、変数を準備してこちらで実行する
import java.util.ArrayList;

public class AAGStringDo{
	public static void main(String[] args){
		//AAGの配列以外の長さn-3で作成可能な文字列を作成
		//その後作成した文字列の全ての隙間にこの文字列を挿入して出力する
		//プログラム実行時の第一引数で文字列長を決定するものとする
		AAGString aagString = new AAGString();
		ArrayList<String> resultMinusAAG = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();//AAG追加後重複有を格納
		ArrayList<String> resultUniq = new ArrayList<>();//重複排除後
		if((Integer.parseInt(args[0])-3)>0){
			//AAGを追加する前の文字列を作成
			for(int step = 0 ; step<(Integer.parseInt(args[0])-3);step++){
				resultMinusAAG = aagString.plusAGCT(resultMinusAAG);
			}
			//作成した文字列に対して各隙間に"AAG"を挿入
			for(String s:resultMinusAAG){
				for(int cnt = 0;cnt<=s.length();cnt++){
					StringBuilder output = new StringBuilder(s);
					result.add((output.insert(cnt,aagString.AAG)).toString());
				}
			}
			//重複排除
			for(String dup:result){
				if(!resultUniq.contains(dup)){
					resultUniq.add(dup);
				}
			}
			//出力
			System.out.println(resultUniq);
		}
		//文字列が"AAG"のみの場合
		if((Integer.parseInt(args[0])-3)==0){
			System.out.print("AAG");
		}
	}
}

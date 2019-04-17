package practice;
/*4種類のアルファベット "A,C,G,T" から成るn文字の文字列のうち、
*"AAG"という並びが含まれる文字列を全て列挙するプログラムを書きなさい。
*ただし、nは3以上の整数とし、文字列内に同じアルファベットが出現しても構わないものとし、
*出力順序は問わないものとします。
*/

//上の問題に取り組むQiitaで見つけた
//AAGの配列を1文字とみなし長さn-3で作成可能な文字列を作成
//その後作成した文字列の全ての隙間にこの文字列を挿入して出力する

//文字列の長さnは本プログラム実行時の引数として与えられるものとする
import java.util.ArrayList;

public class AAGString{
	String A ;
	String C ;
	String G ;
	String T ;
	ArrayList<String> ACGT = new ArrayList<>();
	String AAG ;
	//コンストラクタ
	AAGString(){
		this.A = "A";
		this.C = "C";
		this.G = "G";
		this.T = "T";
		this.ACGT.add("A");
		this.ACGT.add("C");
		this.ACGT.add("G");
		this.ACGT.add("T");
		this.AAG="AAG";
	}
	//文字列が格納されたリストを受け取り、その末尾にAGCTのどれか1つをつけて
	//リストに格納して返すメソッド
	//このメソッドを使用することで文字列の長さが1伸びる
	public ArrayList<String> plusAGCT(ArrayList<String> list){
		ArrayList<String> re = new ArrayList<String>();
		//受け取った文字列が空の場合
		if(list.size()==0){
			re.add("A");
			re.add("C");
			re.add("G");
			re.add("T");
			return re;
		}
		for(String s : list){
			for(String fourAlpha:ACGT){
				String adder = s + fourAlpha;
				re.add(adder);
			}
		}
		return re;
	}
}

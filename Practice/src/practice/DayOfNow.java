package practice;
//今月のカレンダーを出力するクラス
import java.util.Calendar;

public class DayOfNow{
	public static void main(String []args){
		String calendar ="";//カレンダー
		calendar +="日 月 火 水 木 金 土";//曜日入力
		Calendar now = Calendar.getInstance();
		int NowMonth = now.get(Calendar.MONTH);//今月
		int NowYEAR = now.get(Calendar.YEAR);//今年
		Calendar nowFirst =Calendar.getInstance();
		nowFirst.set(Calendar.DATE,1);//今月の1日
		Calendar nowLast = Calendar.getInstance();
		nowLast.set(Calendar.MONTH,(NowMonth+1));
		nowLast.set(Calendar.DATE,1);//来月の1日
		nowLast.add(Calendar.DATE,-1);//来月の1日から1日引いた=今月の末日
		Calendar DayTest = Calendar.getInstance();//曜日確認用
		//カレンダーを作っていく
		int FirstDay = nowFirst.get(Calendar.DAY_OF_WEEK);
		calendar +="\r\n";
		for(int cnt =0;cnt<(FirstDay-1);cnt++){//カレンダー日付入力処理
			calendar+="   ";
		}
		int datecnt = nowLast.get(Calendar.DATE);
		for(int cnt =0;cnt<datecnt;cnt++){
			calendar+=(cnt+1)+" ";
			if((cnt+1)<10){//1桁だと表記がずれていくので調整
				calendar+=" ";
			}
			DayTest.set(Calendar.DATE,(cnt+1));
			if(DayTest.get(Calendar.DAY_OF_WEEK)==7){//土曜日だったら次の週へ
				calendar+="\r\n";
			}
		}
		System.out.println(NowYEAR+"年"+(NowMonth+1)+"月");
		System.out.println(calendar);
	}
}
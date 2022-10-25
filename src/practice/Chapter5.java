package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class SortByDate implements Comparator<Task> {
	@Override
	public int compare(Task a, Task b) {
		return a.localDate.compareTo(b.localDate);
	}
}

public class Chapter5 {
	public static void main(String[] args) throws Exception {

		// プログラムを作成
		List<Task> taskList = new ArrayList<>();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// タスクを五個作る //〇括弧はメソッドの引数で出てくる、()はコンストラクタが動いている
		Task task1 = new Task();
		// fっていう形式で日付を指定するという事
		task1.localDate = LocalDate.parse("2021/10/21", f);
		task1.mTask = "牛乳を買う";
		taskList.add(task1);

		Task task2 = new Task();
		task2.localDate = LocalDate.parse("2021/09/15", f);
		task2.mTask = "〇〇社面談。";
		taskList.add(task2);

		Task task3 = new Task();
		task3.localDate = LocalDate.parse("2021/12/04", f);
		task3.mTask = "手帳を買う。";
		taskList.add(task3);

		Task task4 = new Task();
		task4.localDate = LocalDate.parse("2021/08/10", f);
		task4.mTask = "散髪に行く。";
		taskList.add(task4);

		Task task5 = new Task();
		task5.localDate = LocalDate.parse("2021/11/09", f);
		task5.mTask = "スクールの課題を解く。";
		taskList.add(task5);

		// 日付順に並べて表
		Collections.sort(taskList, new SortByDate());
		taskList.forEach(task -> {
			System.out.println(task.localDate + " " + task.mTask);
		});
	}

}

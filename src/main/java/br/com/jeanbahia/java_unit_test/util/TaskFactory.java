package br.com.jeanbahia.java_unit_test.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.jeanbahia.java_unit_test.model.Task;
import br.com.jeanbahia.java_unit_test.model.enums.TaskStatusEnum;

public class TaskFactory {

	private static List<Task> tasks = new ArrayList<Task>();

	public static List<Task> create() {
		tasks.add(Task.builder().title("Study Java").description("Study Java to improve your hard skills").dueDate(LocalDateTime.now().minusDays(5L)).status(TaskStatusEnum.COMPLETED).build());
		tasks.add(Task.builder().title("Practice Programming").description("Become a better professional practicing programming constantly").dueDate(LocalDateTime.now().minusDays(2L)).status(TaskStatusEnum.COMPLETED).build());
		tasks.add(Task.builder().title("Work abroad").description("Have the experience of working abroad").dueDate(LocalDateTime.now().minusMonths(10L)).status(TaskStatusEnum.PENDING).build());
		tasks.add(Task.builder().title("Finish English4Tech course").description("Complete the English course").dueDate(LocalDateTime.now().minusDays(5L)).status(TaskStatusEnum.LATE).build());
		return tasks;
	}
}

package br.com.jeanbahia.java_unit_test.model;

import java.time.LocalDateTime;

import br.com.jeanbahia.java_unit_test.model.enums.TaskStatusEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Task {

	private String title;
	
	private String description;
	
	private LocalDateTime dueDate;
	
	private TaskStatusEnum status;
}

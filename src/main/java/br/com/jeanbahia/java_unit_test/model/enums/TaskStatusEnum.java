package br.com.jeanbahia.java_unit_test.model.enums;

public enum TaskStatusEnum {

	PENDING("PENDING"),
	COMPLETED("COMPLETED"),
	LATE("LATE");

	private String status;

	private TaskStatusEnum(String status) {
		this.status = status;
	}
	
	public boolean is(TaskStatusEnum taskStatusEnum) {
		return status.equals(taskStatusEnum.status);
	}
}

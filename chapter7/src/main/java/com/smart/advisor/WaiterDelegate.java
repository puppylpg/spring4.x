package com.smart.advisor;

public class WaiterDelegate {
	private NaiveStudent naiveStudent;
	public void service(String clientName) {
		naiveStudent.examine(clientName);
		naiveStudent.play(clientName);
	}
	public void setNaiveStudent(NaiveStudent naiveStudent) {
		this.naiveStudent = naiveStudent;
	}
}

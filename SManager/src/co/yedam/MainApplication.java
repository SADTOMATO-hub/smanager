package co.yedam;

import co.yedam.control.StudentControl;

public class MainApplication/*시작점*/ {

	public static void main(String[] args) {
		//프로그램 시작.
		StudentControl scon = new StudentControl();
		scon.run();
	}

}

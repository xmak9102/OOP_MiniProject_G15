package test;

import datacontroller.DataController;

public class DataControllerTest {
	public static void main(String[] args) {
		DataController dataController = new DataController();
		dataController.generateData();
		
		dataController.print();
		
		dataController.shuffleData();
		
		dataController.print();
	}
}

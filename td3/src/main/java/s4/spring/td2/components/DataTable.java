package s4.spring.td2.components;

import java.io.IOException;

import io.github.jeemv.springboot.vuejs.components.VueComponent;

public class DataTable {
	public static void main(String[] args) throws IOException {
		VueComponent dataTable = new VueComponent("m-data-table");
		dataTable.addProp("headers", "Array", true);
		dataTable.addProp("items", "Array", true);
		dataTable.addProp("noData", "AUcun élément à afficher");
		dataTable.setDefaultTemplateFile();
		dataTable.createFile(false);
	}

}

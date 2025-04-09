module Tppoo {
	
	
	requires javafx.controls;
	requires transitive javafx.graphics;
	requires javafx.fxml;
	exports com.Objetvole;
	requires java.sql;
	
	opens com.Objetvole to javafx.fxml;
	
	
}
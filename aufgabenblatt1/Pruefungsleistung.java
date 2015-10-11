package aufgabenblatt1;

/**
 * 
 * @author marvin
 *
 */
public class Pruefungsleistung {
	
/**
 * 
 */
 private String nameDesModules;
 
 /**
  * 
  */
 private int note;
 
 /**
  * 
  * @param nameDesModules
  * @param note
  */
 public Pruefungsleistung(String nameDesModules,int note){
	 this.note = note ;
	 this.nameDesModules= nameDesModules;
 }

 /**
  * 
  * @return
  */
public String getNameDesModules() {
	return nameDesModules;
}

/**
 * 
 * @param nameDesModules
 */
public void setNameDesModules(String nameDesModules) {
	this.nameDesModules = nameDesModules;
}

/**
 * 
 * @return
 */
public int getNote() {
	return note;
}

/**
 * 
 * @param note
 */
public void setNote(int note) {
	this.note = note;
}
}

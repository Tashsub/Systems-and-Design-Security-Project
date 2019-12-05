package classes;

public class ChiefEditor{

	//instance fields
	User editor;
	boolean isChiefEditor;
	Journal journal;
	
    // constructor
    public ChiefEditor(User editor, boolean isChiefEditor, Journal journal){
    	this.editor = editor;
	    this.isChiefEditor = isChiefEditor;
	    this.journal = journal;
    }
    
    
    public void checkChiefEditor(User editor, Submission submission){
    	if (isChiefEditor)
    		System.out.println("You are the Chief Editor");
    	else
    		System.out.println("You are just a Editor");
    }
    
    public void chooseChiefEditor(User editor,/* User [editor],*/ ChiefEditor checkChiefEditor){
    	if (isChiefEditor)
    		System.out.println("You are the Chief Editor");
    	else
    		System.out.println("You are just a Editor");
    }
    
    public void retireChiefEditor(User editor) {
    	isChiefEditor = false;
    }
}

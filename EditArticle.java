package database;

public class EditArticle{

	//instance fields
	protected String article;
	protected String editedArticle;
	protected String articleID;
	protected String chiefEditor;
	protected String editor;
	
    // constructor
    public EditArticle(String article, String editedArticle, String articleID, String chiefEditor, String editor){
    this.article = article;
	this.editedArticle = editedArticle;
	this.articleID = articleID;
	this.chiefEditor = chiefEditor;
	this.editor = editor;
    }
    
    // get methods 
    public String getEditedArticle(){
    	return this.editedArticle;
    }
    
    // set methods
    public void replaceArticle(String editedArticle, String article, String articleID){
    	article = editedArticle;
    }
    
    public void registerEditors(String chiefEditor, String articleID){
    	editor = articleID;
    }
    
    public void chiefRetire(String chiefEditor, String articleID){
        if (this.chiefEditor.equals(chiefEditor))
            System.out.println("You are retired");
        else
        	System.out.println("You are not chief editor sorry");
    }
    
    public void editorRetire(String editor, String articleID){
    	if (this.editor.equals(editor))
            System.out.println("You are retired");
        else
        	System.out.println("You are not editor sorry");
    }
    
    public void passChiefRole(String chiefEditor, String articleID, String editor){
    	this.chiefEditor = editor;
    }
}

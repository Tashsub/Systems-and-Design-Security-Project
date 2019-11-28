
public class ReviewArticle{

    enum AnonymousID{
        Reviewer1,  Reviewer2, Reviewer3
    }

    enum Verdict{
       StrongAccept, WeakAccept, WeakReject, StrongReject  
    }

    //Should we declare variables as private or public
    //String AnonymousID; 
    String reviewSummary; 
    String typoErrors; 
    String criticism; 




    public static void main (String[] args){

        AnonymousID lol = AnonymousID.Reviewer1; 
        System.out.println(lol); 

    }
}

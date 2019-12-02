public class Permission extends VerdictEnum{

    //Is this based on the reviewers or editors
    //cause majority decisoon is based on the chief editor
    Verdict perm1; 
    Verdict perm2; 
    Verdict perm3;

    Rating perm_1; 
    Rating perm_2; 
    Rating perm_3; 

    /*
    public Permission(Verdict perm1, Verdict perm2, Verdict perm3){
        this.perm1 = perm1; 
        this.perm2 = perm2; 
        this.perm3 = perm3; 
    }
    */

    public Permission(Rating perm_1, Rating perm_2, Rating perm_3){
        this.perm_1 = perm_1; 
        this.perm_2 = perm_2; 
        this.perm_3 = perm_3; 
    }


    public int count( String[] array){
        //String[] arr = {"Champion"}; 
        String c = "Champion";

        int i;
        int champC = 0;  
        int detraC = 0; 
        for(i = 0; i<array.length; i++){
            if(c == array[i]){
                champC++; 
            }else{
                detraC++; 
            }
        }
    return champC;
    }

    public String[] convertToArray(){
        String arr[] = {this.perm_1.name(),this.perm_2.name(), this.perm_3.name() }; 
        return arr; 
    }

    public boolean permission(int numChampions){
        //Using the coount method above
        //if number of champions is >= 2 the accept
        //if no champions and only detractors reject 
        //if all champions accept
        //however still have to be confirmed by editor
        if (numChampions >= 2){
            return true; 
        } else{
            return false;  
        } 
    }

    public static void main(String[] args){
        //Permission lol = new Permission(Verdict.StrongAccept, Verdict.StrongAccept, Verdict.Weak); 

        //imagine the reviews from the three reviewers are as follows 
        Permission lol = new Permission(Rating.Champion, Rating.Champion, Rating.Detractor); 

        //now we count the number of Champions in the list using count method
        int numberOfChampions = lol.count(lol.convertToArray()); 
        System.out.println( "Number of champions " + numberOfChampions); 

        //Decision based on the number of champions
        //chief Editor makes final choice whether it is one of the following: StrongAccept, WeakAccept, WeakReject, StrongReject
        boolean decide = lol.permission(numberOfChampions); 
        System.out.println(decide); 

        //if true then it can either be Strong Accept or weak accept
        //if false then it can either be weakReject and Strongreject


        //Prints out reviews 
        //System.out.println(java.util.Arrays.toString(lol.convertToArray())); 
        
    }
}
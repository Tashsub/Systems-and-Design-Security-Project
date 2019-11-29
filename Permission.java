public class Permission extends VerdictEnum{

    VerdictEnum perm1; 
    VerdictEnum perm2; 
    VerdictEnum perm3; 

    public Permission(VerdictEnum perm1, VerdictEnum perm2, VerdictEnum perm3){
        this.perm1 = perm1; 
        this.perm2 = perm2; 
        this.perm3 = perm3; 
    }

    public boolean permission(){
        //count more than two trues, 
        //if more than two trues are found return true 
        //otherwise false

        //accept arrays
        Verdict accepct1[] = {Verdict.Champion}; 
        //VerdictEnum accepct2[] = {Champion, Champion, WeakAccept}; 

        //checking arrray
        VerdictEnum perm[] = {this.perm1, this.perm2, this.perm3}; 
        
       //contains at least two Champions or two weak acecepts then return true. 

        return true; 
    }

    public static void main(String[] args){
        //Persmission lol = new Permission(Champion); 

    }
}
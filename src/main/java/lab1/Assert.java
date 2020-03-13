package lab1;

public class Assert {
    public static void assertTrue(boolean cond, String normalMessage, String troubleMessage){
        if(!cond){
            throw new Error(troubleMessage);
        }
        System.out.println(normalMessage);
    }
}

public class DCLSingleton {
    private static volatile DCLSingleton singleton;

    private DCLSingleton(){}


    public static DCLSingleton getInstance(){
        if(singleton==null){
            synchronized (DCLSingleton.class){
                if(singleton == null){
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }

}

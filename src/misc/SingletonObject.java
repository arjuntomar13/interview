package misc;

public class SingletonObject {
    private static SingletonObject ref;
    private SingletonObject () //private constructor
    { }

    public  static synchronized   SingletonObject getSingletonObject()
    {
        if (ref == null)
            ref = new SingletonObject();
                return ref;
        }


    public Object clone() throws CloneNotSupportedException
    {throw new CloneNotSupportedException ();
    }   
}

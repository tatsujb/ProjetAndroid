public class Couple<T1, T2> {
    private T1 obj1;
    private T2 obj2;
    
    public Couple(T1 obj1, T2 obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    
    public T1 getFirstObject() {
        return obj1;
    }
    
    public void setFirstObject(T1 obj) {
        obj1 = obj;
    }
    
    public T2 getSecObject() {
        return obj2;
    }
    
    public void setSecObject(T2 obj) {
        obj2 = obj;
    }
}

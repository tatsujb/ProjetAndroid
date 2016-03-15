/**
 * Classe permettant de stocker deux éléments en même temps
 * de type différent (ou pas).
 *
 * @param <T1>
 *     Type du premier élément.
 * @param <T2>
 *     Type du second élément.
 */
public class Couple<T1, T2> {
    /**
     * Premier élément formant le couple.
     */
    private T1 obj1;

    /**
     * Second élément formant le couple.
     */
    private T2 obj2;

    /**
     * Constructeur avec comme paramètre les deux éléments
     * à stocker.
     *
     * @param obj1
     *      Premier élément.
     * @param obj2
     *      Second élément.
     */
    public Couple(T1 obj1, T2 obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    /**
     * Renvoie le premier élément.
     *
     * @return Le premier élément.
     */
    public T1 getFirstObject() {
        return obj1;
    }

    /**
     * Modifie le premier élément par celui passé en paramètre.
     *
     * @param obj
     *      Objet par lequel est remplacé le premier élément
     *      actuel.
     */
    public void setFirstObject(T1 obj) {
        obj1 = obj;
    }

    /**
     * Renvoie le second élément.
     *
     * @return Le second élément.
     */
    public T2 getSecObject() {
        return obj2;
    }

    /**
     * Modifie le second élément courant par celui passé en paramètre.
     *
     * @param obj
     *      Objet par lequel est remplacé le second élément courant.
     */
    public void setSecObject(T2 obj) {
        obj2 = obj;
    }
}

/**
 * class ConjuntoDeEnteros representa un conjunto de enteros y permite
 * realizar las operaciones típicas sobre ellos.
 * 
 * @author: Karan Nandpal Sainani.
 * @group: 1.18(43).
 * @since course 2017-2018.
 */

public class ConjuntoDeEnteros {
    
    // Atributos de la clase
    private int [] conjunto;
    private int numElem;
    
    // Constructor que permite crear conjuntos vacíos
    public ConjuntoDeEnteros () {
        numElem = 0;
        conjunto = new int [numElem];
        
    }
    
    // Constructor general
    public ConjuntoDeEnteros (int [] v) {
        conjunto = new int [10];
        numElem = 0;
        
        for(int i=0; i<v.length; i++) {
            añade(v[i]);
            
        }
        int [] conjuntoCopy = new int [numElem];
        
        for(int i=0; i<numElem; i++) {
            conjuntoCopy[i] = conjunto[i];
        }
        
        conjunto = new int [numElem];
        conjunto = conjuntoCopy;
        conjuntoCopy = new int[0];
        
        // esto lo hago porq quiero conservar tanto lo que hay en conjunto como en conjuntoCopy y no perder ninguno puesto a que APUNTAN aqui
        // distintas direcciones de memoria
        /*for(int i=0; i<=numElem-1; i++) {
            conjunto[i] = conjuntoCopy[i];
        }*/
        
        
    }
    
    /**
     * method cardinal que devuelve el número de elementos del conjunto.
     * 
     * @return numElem.
     */
    public int cardinal () {
        return this.numElem;
    }
    
    /**
     * method boolean comprueba si el conjunto esta vacío o no.
     * 
     * @return true si esta vació en caso contrario false.
     */
    public boolean estáVacío () {
        if (numElem == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * method añade que añade un elemento que pasa por parámetro.
     * 
     * @param elemento a introducir.
     * @return true si lo añadio y false en caso contrario.
     */
    public boolean añade (int newElem) {
        if(numElem == 10  || pertenece(newElem) == true ) {
            return false;
        }
        
        int [] conjuntoCopy = new int [numElem+1]; 
        
        for(int i=0; i<numElem; i++) {
            conjuntoCopy[i] = conjunto[i];
        }
        conjuntoCopy[numElem]=newElem;
        conjunto = conjuntoCopy;
        
        numElem++;
        
        /*
        conjunto = new int [numElem];         
        conjunto[numElem+1] = newElem;
        */
        return true;
    }
    
    
    // Esto se hace para ver el vector
    /*public String toString () {
        String x = " ";
        
        for(int i=0; i<numElem; i++) {
            x += conjunto[i] + ",";
        }
        return x;
    }*/
    
    /**
     * method pertenece que comprueba si pertenece un elemento que pasamos
     * por parámetro en el conjunto.
     * 
     * @param elemento a preguntar si está en el conjunto.
     * @return true si está y falso si no está.
     */
    public boolean pertenece (int elem) {
        if (numElem == 0) {
            return false;
        }
        for(int i=0; i<=conjunto.length-1; i++) {
            if (conjunto[i] == elem) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * method elementos que devuelve un vector de tamaño cardinal
     * con los datos almacenados en el conjunto.
     * 
     * @return un vector con los datos del conjunto.
     */
    public int [] elementos () {
        int [] vec = new int [numElem];
        
        //int [] copyVec = new int [numElem];
        for(int i=0; i<numElem; i++) {
            vec[i] = conjunto[i];
        }
        return vec;
        
    }
    
    
    /**
     * method union que realiza la operación de unión de 2 conjuntos.
     * 
     *@param un ConjuntoDeEnteros.
     *@return la unión resultante entre ambos conjuntos.
     */
    public ConjuntoDeEnteros unión (ConjuntoDeEnteros v) {
        ConjuntoDeEnteros union = new ConjuntoDeEnteros(conjunto);
        //int [] vecThis = this.elementos();
        int [] vecParam = v.elementos();
        
        for(int i=0; i<vecParam.length; i++) {
            if (this.pertenece(vecParam[i]) == false) {
                union.añade(vecParam[i]);
            }
        }
        
        return union;
        
    }
    
    /**
     * method intersección que realiza la intersección de 2 conjuntos 
     * 
     * @param un ConjuntoDeEnteros
     * @return la intersección resultante entre ambos conjuntos.
     */
    public ConjuntoDeEnteros intersección (ConjuntoDeEnteros v) {
        ConjuntoDeEnteros intersection = new ConjuntoDeEnteros();
        int [] vecParam = v.elementos();
        
        for(int i=0; i<vecParam.length; i++) {
            if (this.pertenece(vecParam[i]) == true) {
                intersection.añade(vecParam[i]);
            }
        }
        return intersection;
    }
    
    /**
     * method diferencia que realiza la diferencia de 2 conjuntos 
     * 
     * @param un ConjuntoDeEnteros
     * @return la diferencia resultante entre ambos conjuntos.
     */
    public ConjuntoDeEnteros diferencia (ConjuntoDeEnteros v) {
        ConjuntoDeEnteros diference = new ConjuntoDeEnteros();
        int [] vecParam = v.elementos();
        
        for(int i=0; i<numElem; i++) {
            if (v.pertenece(conjunto[i]) == false) {     
                diference.añade(conjunto[i]);
            }
        }
        return diference;
    }
    
    
    /**
     * method equals que comprueba si dos ConjuntoDeEnteros son iguales. 
     * 
     * @param objeto de cualquier tipo.
     * @return true si es igual y sino false.
     */
    public boolean equals (Object obj) {
        if (obj instanceof ConjuntoDeEnteros) {
            ConjuntoDeEnteros aux = (ConjuntoDeEnteros) obj;
            if (aux.cardinal() == this.numElem) {
                int [] vector = aux.elementos();
                for(int i = 0; i<numElem; i++) {
                    if(this.pertenece(vector[i]) == false) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * method contenido que comprueba si el conjunto parámetro
     * está contenido o no en el conjunto actual.
     * 
     * @param un conjunto.
     * @return verdadero o falso dependiendo si está contenido o no.
     */
    public boolean contenido (ConjuntoDeEnteros v) {
        int [] vParam = v.elementos();
        int [] vThis = this.elementos();
        
        for(int i=0; i< vParam.length; i++) {
            if (this.pertenece(vParam[i]) == false) {
                return false;
            }
        }
        return true;
    }
}
import org.junit.*;
import static org.junit.Assert.*;

public class ConjuntoTest {
    
    private ConjuntoDeEnteros a1;
    private ConjuntoDeEnteros a2;
    private ConjuntoDeEnteros a3;
    private ConjuntoDeEnteros a4;
    private ConjuntoDeEnteros a5;
    private ConjuntoDeEnteros nuevo;
    private ConjuntoDeEnteros nuevo2;
    private ConjuntoDeEnteros nuevo3;
    private ConjuntoDeEnteros nuevo4;
    private ConjuntoDeEnteros nuevo5;
    
    private int [] v1 = {};
    private int [] v2 = {1};
    private int [] v3 = {1,2,3,4,5};
    private int [] v4 = {0,1,2,3,4,5,6,7,8};
    private int [] v5 = {0,1,2,3,4,5,6,7,8,9};
    
    @Before
    public void inicializa () {
        a1 = new ConjuntoDeEnteros(v1);
        a2 = new ConjuntoDeEnteros(v2);
        a3 = new ConjuntoDeEnteros(v3);
        a4 = new ConjuntoDeEnteros(v4);
        a5 = new ConjuntoDeEnteros(v5);
    }
    
    @Test
    public void pruebaConstructor () {
        assertEquals("Fallo al crear un conjunto vacio",0, a1.cardinal());
        assertEquals("Fallo al crear un conjunto con un elemento",1, a2.cardinal());
        assertArrayEquals("Fallo al crear un conjunto con un elemento",v2, a2.elementos());
        assertEquals("Fallo al crear un conjunto con varios elementos",5, a3.cardinal());
        assertEquals("Fallo al crear un conjunto con nueve elementos",9,a4.cardinal());
        assertTrue("Fallo al crear un conjunto con nueve elementos",pruebaEquals(v4,a4.elementos()));
        assertEquals("Fallo al crear un conjunto lleno",10,a5.cardinal());
    }
    
    @Test
    public void pruebaCardinal () {
        assertEquals("fallo al probar cardinal() para conjunto vacio: ",0, a1.cardinal());
        assertEquals("fallo al probar Equals() para conjunto con un elementos: ",1, a2.cardinal());
        assertEquals("fallo al probar Equals() para conjunto con varios elementos: ",5, a3.cardinal());
        assertEquals("fallo al probar Equals() para conjunto con nueve elementos: ",9, a4.cardinal());
        assertEquals("fallo al probar Equals() para conjunto lleno: ",10, a5.cardinal());
    }
    
    @Test
    public void testEstáVacio(){
        assertTrue("Fallo al probar estáVacio() para conjunto vacio: ",a1.estáVacío());
        assertFalse("Fallo al probar estáVacio() para conjunto de un elemento: ",a2.estáVacío());
        assertFalse("Fallo al probar estáVacio() para conjunto de varios elementos: ",a3.estáVacío());
        assertFalse("Fallo al probar estáVacio() para conjunto de nueve elementos: ",a4.estáVacío());
        assertFalse("Fallo al probar estáVacio() para conjunto lleno: ",a5.estáVacío());
    }
    
    @Test
    public void testAñade(){
        int x = 6;
        int rep = 3;
        assertTrue("Fallo al probar añade() para conjunto vacio: ",a1.añade(x));
        assertTrue("Fallo al probar añade() para conjunto de un elemento: ",a2.añade(x));
        assertTrue("Fallo al probar añade() para conjunto de varios elementos: ",a3.añade(x));
        assertFalse("Fallo al probar añade() para conjunto de varios elementos, con número repetido: ",a3.añade(rep));
        assertFalse("Fallo al probar añade() para conjunto de nueve elementos, con número repetido: ",a4.añade(x));
        assertFalse("Fallo al probar añade() para conjunto lleno, con número repetido: ",a5.añade(rep));
    }
    
    
    @Test
    public void testIntersección(){
        int[] d1= {3,5};
        int[] d2= {1,3,5};
        int[] d3= {9,7};
        int[] d4= {2,4,6,8};
        nuevo= new ConjuntoDeEnteros(d1);
        nuevo2= new ConjuntoDeEnteros(d2);
        nuevo3= new ConjuntoDeEnteros(d3);
        nuevo4= new ConjuntoDeEnteros(d4);
        assertEquals("Fallo al probar Intersección() para conjunto vacio: ",a1,a1.intersección(nuevo));
        assertEquals("Fallo al probar Intersección() para conjunto con un elemento: ",a2,a2.intersección(nuevo2));
        assertEquals("Fallo al probar Intersección() para conjunto con varios elementos: ",a1,a3.intersección(nuevo3));
        assertEquals("Fallo al probar Intersección() para conjunto con nueve elementos: ",nuevo4,a4.intersección(nuevo4));
        assertEquals("Fallo al probar Intersección() para conjunto lleno: ",nuevo3,a5.intersección(nuevo3));
    }
    
    @Test
    public void testDiferencia(){
        int[] d1= {3,5};
        int[] d2= {1,3,5};
        int[] d3= {9,7};
        int[] d4= {2,4,6,8};
        int[] d5= {0,1,3,5,7};
        nuevo= new ConjuntoDeEnteros(d1);
        nuevo2= new ConjuntoDeEnteros(d2);
        nuevo3= new ConjuntoDeEnteros(d3);
        nuevo4= new ConjuntoDeEnteros(d4);
        nuevo5= new ConjuntoDeEnteros(d5);
        assertEquals("Fallo al probar Diferencia() para conjunto vacío: ",a1,a1.diferencia(nuevo));
        assertEquals("Fallo al probar Diferencia() para conjunto con un elemento: ",a1,a2.diferencia(nuevo2));
        assertEquals("Fallo al probar Diferencia() para conjunto con varios elementos: ",nuevo,nuevo2.diferencia(a2));
        assertEquals("Fallo al probar Diferencia() para conjunto con nueve elementos: ",nuevo5,a4.diferencia(nuevo4));
        assertEquals("Fallo al probar Diferencia() para conjunto lleno: ",a5,a5.diferencia(a1));
    }
    
    
    @Test
    public void pruebaPertenece(){
        assertFalse("Fallo al probar pertenece() para conjunto vacio: ",a1.pertenece(1));
        assertTrue("Fallo al probar pertenece() para conjunto un elemento: ",a2.pertenece(1));
        assertFalse("Fallo al probar pertenece() para conjunto varios elementos: ",a3.pertenece(6));
        assertTrue("Fallo al probar pertenece() para conjunto nueve elementos: ",a4.pertenece(5));
        assertTrue("Fallo al probar pertenece() para conjunto lleno: ",a5.pertenece(7));
    }
    
    @Test
    public void testEquals () {
        assertTrue("fallo al probar Equals() para conjunto vacio: ",a1.equals(a1));
        assertFalse("fallo al probar Equals() para conjunto de un elemento: ",a2.equals(a1));
        assertFalse("fallo al probar Equals() para conjunto de varios elementos: ",a3.equals(a2));
        assertFalse("fallo al probar Equals() para conjunto de nueve elementos: ",a4.equals(a3));
        assertFalse("fallo al probar Equals() para conjunto lleno: ",a5.equals(a4));
    }
    
    @Test
    public void testUnión(){
        int[] b1 = {12,9,2};
        int[] b2 = {1,2,3,4,5,9,12};
        int[] b3 = {12,9,2,1};
        int[] b4 = {0,1,2,3,4,5,6,7,8,12};
        nuevo = new ConjuntoDeEnteros(b1);
        nuevo2= new ConjuntoDeEnteros(b2);
        nuevo3 = new ConjuntoDeEnteros(b3);
        nuevo4 = new ConjuntoDeEnteros(b4);
        assertEquals("fallo al probar Unión() para conjunto lleno: ",a5,a5.unión(a1));
        assertEquals("fallo al probar Unión() para conjunto vacio: ",nuevo,a1.unión(nuevo));
        assertEquals("fallo al probar Unión() para conjunto de varios elementos ",nuevo2,a3.unión(nuevo));
        assertEquals("fallo al probar Unión() para conjunto de un elemento",nuevo3,a2.unión(nuevo));
        assertEquals("fallo al probar Unión() para conjunto de nueve elementos",nuevo4,a4.unión(nuevo));
    }
    
    @Test
    public void pruebaContenido(){
        int[] v = {1,2,3,4};
        ConjuntoDeEnteros a = new ConjuntoDeEnteros(v);
        assertTrue("Fallo al probar contenido() con conjuntos lleno y medio",a5.contenido(a));
        assertTrue("Fallo al probar contenido() con dos conjuntos medios",a3.contenido(a));
        assertFalse("Fallo al probar contenido() con conjuntos vacio y medio",a1.contenido(a));
        assertTrue("Fallo al probar contenido() con conjuntos medio y vacio",a.contenido(a1));
        assertTrue("Fallo al probar contenido() con conjuntos con un elemento y vacio",a2.contenido(a1));
        assertTrue("Fallo al probar contenido() con conjuntos con nueve elementos y medio",a4.contenido(a));
    }
    
    @Test
    public void pruebaElementos() {
        int[] a = {};
        int[] b = {0,3,5,2,7,8,9,1,6,4};
        int[] c = {1};
        int[] d = {8,5,3,1,0,4,6,2,7};
        int[] e = {5,2,4,1,3};
        ConjuntoDeEnteros uno = new ConjuntoDeEnteros(c);
        ConjuntoDeEnteros nueve = new ConjuntoDeEnteros(d);
        
        assertTrue("Fallo al probar elementos() con conjunto vacio",pruebaEquals(a,a1.elementos()));
        assertTrue("Fallo al probar elementos() con conjunto lleno",pruebaEquals(b,a5.elementos()));
        assertEquals("Fallo al probar elementos() con conjunto con un elemento",pruebaEquals(c,a2.elementos()),uno.equals(a2));
        assertEquals("Fallo al probar elementos() con conjunto con 9 elementos",pruebaEquals(d,a4.elementos()),nueve.equals(a4));
        assertTrue("Fallo al probar elementos() con conjunto con varios elementos",pruebaEquals(e,a3.elementos()));
        
    }
    
    private boolean pruebaEquals(int[] v, int[] v1){
        if(v.length != v1.length){
            return false;
        }
        if(v.length==0){
            return true;
        }
        Boolean esta = false;
        for(int i = 0 ; i < v.length ; i++){
            for(int j = 0 ; j < v1.length ; j++){
                if(v[i] == v1[j]){
                    esta = true;
                    break;
                }else{
                    esta=false;
                }
            }
            if(esta == false){
                return false;
            }
        }
        return esta;
    }
}
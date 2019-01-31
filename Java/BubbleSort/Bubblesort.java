  /*  Sortieralgortithmus */


public class Bubblesort { 

    /*   public Bubblesort(){  }  */     
    /* -->  da es sich oben um den default Konstruktor handelt, kann man ihn auch weglassen, denn der Compiler erg�nzt diese Zeile automatisch. Testweise einfach mal ddie Kommentierung entfernen.  */

    public int[] intArr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 }; 

    public int[] sort() { 
        int k; 
        for (int i = 0; i < intArr.length - 1; i++) { 
            if (intArr[i] < intArr[i + 1]) { 
                continue;            // continue setzt die Schleife fort, d.h. beginnt wieder oben.
            } 
            //Ist der 1. Wert > als der 2. Wert so werden die WErte getauscht!:
            k = intArr[i]; 
            intArr[i] = intArr[i + 1]; 
            intArr[i + 1] = k; 
            sort(); 
        } 
        return intArr; 
    } 

    public static void main(String[] args) { 
        Bubblesort bs = new Bubblesort(); 
        int[] arr = bs.sort(); 
        for (int i = 0; i < arr.length; i++) { 
            System.out.println(i + 1 + ": " + arr[i]); 
        } 
    } 
} 
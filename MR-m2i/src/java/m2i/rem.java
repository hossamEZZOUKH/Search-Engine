/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author student
 */
public class rem {
    public static boolean re(HashSet<String> hash,String nom){
       Iterator it=hash.iterator();
      
      while(it.hasNext()){
          if(it.next().equals(nom))return true;
      }
         
    
      return false;  
        
    
}}

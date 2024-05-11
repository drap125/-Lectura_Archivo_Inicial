package com.mycompany.pruebaproyecto;

import java.util.ArrayList;

public class ArbolBinario {
   public NodoArbol raiz; 
    public ArbolBinario (){
        raiz = null;
    }
   
    //Metodo para insertar un metodo en el arbol
    public void AgregarNodo(long d){
        NodoArbol nuevo = new NodoArbol(d);
        if(raiz == null){
        raiz = nuevo;
        }else{
        NodoArbol auxiliar = raiz;
        NodoArbol padre;
        
        while(true){
        padre = auxiliar;
        
        if(d <auxiliar.dato){
             auxiliar = auxiliar.HijoIzquierdo;
             if(auxiliar == null){
                    padre.HijoIzquierdo = nuevo;
                    return;
                    }
        }else{
            auxiliar = auxiliar.HijoDerecho;
                if(auxiliar == null){
                    padre.HijoDerecho = nuevo;
                    return;
                    }
                }
            }
        }
    }
    
    public boolean EstaVacio(){
        return raiz ==null;
    }
    
    public void InOrden(NodoArbol r, StringBuilder dat){
    
        if(r!=null){
            InOrden(r.HijoIzquierdo, dat);
            dat.append(r.dato).append("\n");
            InOrden(r.HijoDerecho, dat);
            
        }
    }
    
    public void PreOrden(NodoArbol r, StringBuilder dat){
         if(r!=null){
            dat.append(r.dato).append("\n");
            PreOrden(r.HijoIzquierdo, dat);
            PreOrden(r.HijoDerecho, dat);
        }
    }
    
     public void PostOrden(NodoArbol r, StringBuilder dat){
         if(r!=null){
            PostOrden(r.HijoIzquierdo, dat);
            PostOrden(r.HijoDerecho, dat);
            dat.append(r.dato).append("\n");
        }
    }
    
     //Metodo para buscar un Nodo en el Arbol
     
     public NodoArbol BuscarNodo(long d){
     NodoArbol aux = raiz;
    
     while(aux.dato != d){
         if(d<aux.dato){
             aux = aux.HijoIzquierdo;
         }else{
             aux = aux.HijoDerecho;
         }if(aux==null){
             return null;
         }
     }
        return aux;
     }
     
     //Metodo para eliminar un Nodo del Arbol
     
     public boolean EliminarNodo(long d){
         NodoArbol auxiliar = raiz;
         NodoArbol padre =raiz;
         boolean EsHijoIzq = true;
         
         while(auxiliar.dato != d){
             padre = auxiliar; 
             if(d<auxiliar.dato){
             EsHijoIzq = true;
             auxiliar = auxiliar.HijoIzquierdo;
             }else{
                 EsHijoIzq = false;
                  auxiliar = auxiliar.HijoDerecho;
             }
             if(auxiliar == null){
                 return false;
             }
         }  //fin while
         
         if(auxiliar.HijoIzquierdo   == null && auxiliar.HijoDerecho == null){
                if(auxiliar == raiz){
                    raiz = null; //El nodo a eliminar es la raiz y apuntamos a null
                }else if(EsHijoIzq){
                    padre.HijoIzquierdo = null;
                }else{
                    padre.HijoDerecho = null;
                }
         }else if(auxiliar.HijoDerecho == null){
             if(auxiliar == raiz){
                 raiz = auxiliar.HijoIzquierdo;
             }else if(EsHijoIzq){
             padre.HijoIzquierdo = auxiliar.HijoIzquierdo;
             }else{
                 padre.HijoDerecho = auxiliar.HijoIzquierdo;
             }
         }else if(auxiliar.HijoIzquierdo == null){
             if(auxiliar==raiz){
             raiz = auxiliar.HijoDerecho;
             }else if(EsHijoIzq){
                 padre.HijoIzquierdo = auxiliar.HijoDerecho;
             }else{
                 padre.HijoDerecho = auxiliar.HijoDerecho;
                 //puede que sea auxiliar.HijoIzquierdo
             }
        }else{
             NodoArbol reemplazo = ObtenerNodoReemplazoI(auxiliar);
             if(auxiliar == raiz){
             raiz = reemplazo;
             }else if(EsHijoIzq){
                 padre.HijoIzquierdo = reemplazo;
             }else{
                 padre.HijoDerecho = reemplazo;
             }
             reemplazo.HijoIzquierdo = auxiliar.HijoIzquierdo;
         }
         return true;
    }
     
     public NodoArbol ObtenerNodoReemplazoI(NodoArbol nodoreemp){
            NodoArbol reemplazopadre = nodoreemp;
            NodoArbol reemplazo = nodoreemp;
            NodoArbol auxiliar = nodoreemp.HijoDerecho;
            
            while(auxiliar != null){
            reemplazopadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.HijoIzquierdo;
            }
            
            if(reemplazo != nodoreemp.HijoDerecho){
                reemplazopadre.HijoIzquierdo = reemplazo.HijoDerecho;
                reemplazo.HijoDerecho = nodoreemp.HijoDerecho;
            }
            
            System.out.println("El Nodo remplazado es: "+ reemplazo.dato);
            return reemplazo;
     }

     
     
}

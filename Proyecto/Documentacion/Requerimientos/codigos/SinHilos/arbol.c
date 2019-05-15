/*
*****************************************************************
                            HUNTERS 
                Materia:Análisis de algoritmos
    ESCUELA SUPERIOR DE CÓMPUTO - IPN SEPTIEMBRE 2018
    BUSQUEDA CON ABB
    Compilación: gcc -o arbol arbol.c
    Ejecución: "./arbol TamProblema" Ejemplo: ./arbol 1000

*****************************************************************/

/*****************************************************
            LIBRERIAS REQUERIDAS                    */
#include <stdio.h>
#include <stdlib.h>
#include "tiempo.h"


//*******DEFINICION DE LA ESTRUCTURA NODO PARA EL ARBOL**********
/*
    Esta estructura cuenta con elementos:
    -El valor entero que guarda.
    -Dos apuntadores a NODO, que son el nodo a la izq y a la derecha.
*/
typedef struct nodo{
    int valor;
    struct nodo *izq, *der;
}nodo;
 typedef nodo *punteronodo;

/*****************************************************************
        DECLARACION DE VARIABLES GLOBALES                       */
//*****************************************************************
int* A; // ARREGLO DE N NUMEROS.
//ARREGLO DE NUMEROS A BUSCAR.
int numeros[]={322486,14700764,3128036,6337399,61396,10393545,2147445644,1295390003,450057883,187645041,1980098116,152503,5000,
1493283650,214826,1843349527,1360839354,2109248666,2147470852,0};


//********DECLARACION DE FUNCIONES ***********

/******** FUNCION "insertarArbol"***************

    Parametros: 
    -Apuntador a punteronodo o doble apuntador a nodo raiz.
    -Elemento a insertar en el arbol. Tipo entero.
    Sin retorno de algun valor.
***************************************/
void insertarArbol (punteronodo *raiz, int dato);


/******** FUNCION "busqueda"***************

    Parametros: 
    -puntero nodo: Apuntador al nodo raiz.
    -Elemento a buscar en el arbol. Tipo entero.
    Sin retorno de algun valor.
***************************************/
void busqueda (punteronodo raiz, int numero);


int main(int argc, char* argv[]){
    int n,i,j;

    n=atoi(argv[1]);//Se guarda el tamano del problema
    A = (int*)malloc(n*sizeof(int)); // Se asigna memoria para el arreglo dependiendo del tamano del problema
    
    for(i=0;i<n;i++)
    {
        scanf("%d",(A+i)); /// Se capturan los elementos en el arreglo.
    }
    
    for(j=0;j<20;j++)
    {
        //printf("*********Numero a buscar: %d **********************\n",numeros[j]);
    	//****Inicia el conteo del tiempo********
        double utime0, stime0, wtime0,utime1, stime1, wtime1;
        uswtime(&utime0, &stime0, &wtime0); 

        //********************Generacion del arbol binario*************
        punteronodo raiz;
        raiz = NULL;
        for(int i=0;i<n;i++) insertarArbol (&raiz, A[i]);

        //***********Llamada a la funcion de busqueda******************
        busqueda(raiz,numeros[j]);

        //******************************************************************    
        //Evaluar los tiempos de ejecución 
        //******************************************************************
        uswtime(&utime1, &stime1, &wtime1);
        //Cálculo del tiempo de ejecución del programa
        //printf("\n");
        printf("%.10f\n",  wtime1 - wtime0);
        //printf("user (Tiempo de procesamiento en CPU's) %.10f s\n",  utime1 - utime0);
        //printf("\n");
        //******************************************************************

    }
    return 0;
}


/*
****************DEFINICION DE FUNCIONES*************************
 
***********************Funcion "insertaArbol"************************
-Se pretende insertar el elemento "dato" en un nuevo nodo en el lugar que le corresponda.

-Si el apuntador al nodo que recibe esta vacio, se crea el nodo con el elemento (dato) del parametro y 2 nuevos apuntadores a NULL.
-Si no lo esta, compara el elemento a insertar con el elemento que se encuentra en el nodo que se paso como parametro. Si el elemento
a insertar es menor, se tralada al nodo que apunta a la izquiera llamando a recursivamente a la funcion. Si es mayor, a la derecha.

*/ 
void insertarArbol (punteronodo *raiz, int dato){
    if (*raiz == NULL){
        *raiz = malloc(sizeof(nodo));
        (*raiz)->valor = dato;
        (*raiz)->izq = NULL;
        (*raiz)->der = NULL;
    }else{
        if (dato <= (*raiz)->valor){
            insertarArbol (&(*raiz)->izq, dato);
        }else{
            insertarArbol (&(*raiz)->der, dato);
        }
    }
}
 


/*
***********************Funcion "busqueda" ************************
-Esta funcion busca algun elemento en un arbol especifico.
-Al recibir un apuntador a nodo raiz del arbol, o subarbol para las recursiones, se tienen 2 opciones:
    -Si el nodo no esta vacio, se compara el elemento a buscar con el elemento que guarda el nodo. Si es igual, se habra encontrado
    el elemento y se acaba la funcion; si no es igual, se continua la busqueda con el nodo hijo izquierdo, si es menor, o con el nodo
    hijo derecho si es mayor.
    - Si el nodo esta vacio,  se habra llegado al final del arbol y no se habra encontrado el elemento.
*/  
void busqueda (punteronodo raiz, int numero)
{
    if (raiz != NULL )
    {
        if(raiz->valor==numero)
        {
            //printf("Numero encontrado\n");
            return;
        } 
        else if(raiz->valor > numero) busqueda(raiz->izq,numero);
        else busqueda(raiz->der,numero);
    }
    else; //printf("Numero NO encontrado\n");
}
 

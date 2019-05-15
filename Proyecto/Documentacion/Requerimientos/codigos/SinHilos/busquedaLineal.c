/*
*****************************************************************
							HUNTERS 
				Materia:Análisis de algoritmos
	ESCUELA SUPERIOR DE CÓMPUTO - IPN SEPTIEMBRE 2018
	BUSQUEDA LINEAL UTILIZANDO THREADS
	Compilación: "gcc -o bLineal busquedaLineal.c"
	Ejecución: "./bLineal TamProblema" Ejemplo: ./bLineal 1000

*****************************************************************/


/*****************************************************
			LIBRERIAS REQUERIDAS					*/
#include <stdio.h>
#include <stdlib.h>
#include "tiempo.h"



/*****************************************************************
		DECLARACION DE la funcion de busqueda            
La funcion recibe:
- Referencia al arreglo en el que se buscara el numero
- El numero que se buscara
- El tamano del arreglo en el que se buscara el numero.
No devuelve algun valor.
		      */
//*****************************************************************
void busquedaLineal (int* A, int numero, int n);

int main(int argc, char* argv[]){

	int numeros[]={322486,14700764,3128036,6337399,61396,10393545,2147445644,1295390003,450057883,187645041,1980098116,152503,5000,
	1493283650,214826,1843349527,1360839354,2109248666,2147470852,0}; ///////Arreglo de numeros a buscar.
	
	int N,i;

	N=atoi(argv[1]); // Se guarda el tamano del problema.
	int* A;
	A = (int*)malloc(N*sizeof(int)); // Se asigna memoria para el arreglo dependiendo del tamano del problema

	for(i=0;i<N;i++)
	{
        scanf("%d",(A+i)); /// Se capturan los elementos en el arreglo.
    }
    
    for(i=0;i<20;i++)
    {
    	//printf("***************Numero: %d ***************\n",numeros[i] );
    	
    	//****Inicia el conteo del tiempo********
    	double utime0, stime0, wtime0,utime1, stime1, wtime1;
		uswtime(&utime0, &stime0, &wtime0);

    	//***Llamada a la funcion de busqueda********
    	busquedaLineal (A,numeros[i],N);

    	uswtime(&utime1, &stime1, &wtime1);
		//Cálculo del tiempo de ejecución del programa
		printf("%.10f\n",  wtime1 - wtime0);
		//printf("user (Tiempo de procesamiento en CPU's) %.10f s\n",  utime1 - utime0);	
	} 
	
	
	return 0;

}


/*******DEFINICION DE FUNCIONES*********************************/

/********FUNCION "busquedaLineal" *****************************************************


La busqueda recorre el arreglo recibido, con los limites de inicio y final establecidos,
comparando el elemento a buscar con cada elemento del arreglo. 

*///********************************************************************************
void busquedaLineal (int* A, int numero,int n){


	for (int i = 0; i<n;i++){
		if(A[i]==numero) {
			//printf("\nEncontrado el numero en la posicion: %d \n",i+1);
			

			return;
		}
	}
	//printf("\nNumero no encontrado\n", numero);
	return;
}
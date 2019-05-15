/*
*****************************************************************
							HUNTERS 
				Materia:Análisis de algoritmos
	ESCUELA SUPERIOR DE CÓMPUTO - IPN SEPTIEMBRE 2018
	BUSQUEDA LINEAL UTILIZANDO THREADS
	Compilación: "gcc -pthread -o bLinealThread bLinealThread.c"
	Ejecución: "./bLinealThread"

*****************************************************************/



/*****************************************************
			LIBRERIAS REQUERIDAS					*/

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include "tiempo.h"

/*****************************************************************
		DECLARACION DE VARIABLES GLOBALES                       */
//*****************************************************************
int NumThreads;			//Número de threads
int N,j;
int* A;
int numeros[]={322486,14700764,3128036,6337399,61396,10393545,2147445644,1295390003,450057883,187645041,1980098116,152503,5000,
1493283650,214826,1843349527,1360839354,2109248666,2147470852,0};

/*****************************************************************
		DECLARACION DE la funcion de busqueda            
La funcion recibe:
- Referencia al arreglo en el que se buscara el numero
- El numero que se buscara
- El indice donde inicia la busqueda
- El indice donde termina la busqueda
La funcion devuelve un numero que determinara si encontro el numero
(0 o 1).
		      */
//*****************************************************************
int busquedaLineal  (int* A, int numero,int inicio, int fin);


//********************************************************************************
/* La funcion PROCESAR recibe como parametro un apuntador a void, el cual indica
el id del hilo creado. Este id se "castea" a entero pues se considera que el id
es un numero, empezando desde 0.
Esta funcion determina el comportamiento de los hilos creados: Se calculan los limites
que tendran cada hilo a trabajar en el arreglo. 
Llama a la funcion de busquedaLineal para realizar la busqueda. Imprime el resultado
de la busqueda.

*///******************************************************************************
void* procesar(void* id)
{	
	int n_thread=(int)id;
	int inicio,fin,i,a;

	//Revisar la parte de los datos a procesar	
	inicio=(n_thread*N)/NumThreads;

	if(n_thread==NumThreads-1)	
		fin=N;
	else
		fin=((n_thread+1)*N)/NumThreads-1;

	printf("\nThread %d\tInicio %d\tTermino %d",n_thread,inicio,fin);

	if(busquedaLineal(A,numeros[j],inicio,fin)==0) printf("\nSe encontro el numero\n");
	if(n_thread!=0) pthread_exit(0); // Termina los hilos, excepto el main.
}

//*****************************************************************
//PROGRAMA PRINCIPAL 
//*****************************************************************
int main (int argc, char *argv[])
{	
	int i,k; 	//Variables auxiliares para loops

	//******************************************************************	
	
	//********************************************************************************
	//Obtener el número de threads a usar y el arreglo para la identificacion de los mismos
	//********************************************************************************
	pthread_t *thread;
	if (argc<2) 
	{
		printf("Indique el número de threads - \tEjemplo: [user@equipo]$ %s 4\n\n",argv[0]);
		exit(-1);
	}  
	NumThreads=atoi(argv[1]);
	thread = malloc(NumThreads*sizeof(pthread_t));

	//***************************************************************************************************************************
	//Saber cuál es el tamaño del problema N
	//***************************************************************************************************************************	
	//Si no se introduce correctamente N
	if (argc!=3) 
	{
		printf("\nIndique el tamaño de N - \nEjemplo: [user@equipo]$ %s %s 1000\n",argv[0],argv[1]);
		exit(-1);
	}
	N=atoi(argv[2]);
	//******************************************************************
	//Guardar los elementos en el arreglo
	//******************************************************************
	A = (int*)malloc(N*sizeof(int));
	for(i=0;i<N;i++)
	{
        scanf("%d",(A+i));
    }
	
	//***************************************************************************************************************************
	//Procesar desde cada hilo "procesar"
	//***************************************************************************************************************************

	for(j=0;j<20;j++)
	{
	//******************************************************************	
	//Iniciar el conteo del tiempo para las evaluaciones de rendimiento
	//******************************************************************		
		double utime0, stime0, wtime0,utime1, stime1, wtime1;
		uswtime(&utime0, &stime0, &wtime0);	
		
		printf("***************Numero: %d ***************\n",numeros[j] );
		
		for (i=1; i<NumThreads; i++) 
		{
			//Crear los threads que se comportaran segun la funcion procesar.

			if (pthread_create (&thread[i], NULL, procesar,(void*)i) != 0 ) 
			{
				perror("El thread no  pudo crearse");
				exit(-1);
			}
		}
		procesar(0);
		//Esperar a que terminen los threads.
		for (i=1; i<NumThreads; i++) pthread_join (thread[i], NULL);

		//******************************************************************	
		//Evaluar los tiempos de ejecución 
		//******************************************************************
		uswtime(&utime1, &stime1, &wtime1);
		//Cálculo del tiempo de ejecución del programa
		printf("\n");
		printf("real (Tiempo total)  %.10f s\n",  wtime1 - wtime0);
		printf("user (Tiempo de procesamiento en CPU's) %.10f s\n",  utime1 - utime0);
		printf("%d threads (Tiempo de procesamiento aproximado por cada thread en CPU) %.10f s\n", NumThreads,(utime1 - utime0)/NumThreads);	
		printf("\n");
		//******************************************************************
	}
	//Terminar programa normalmente	
	exit(0);	
}




/*******DEFINICION DE FUNCIONES*********************************/

/********FUNCION "busquedaLineal" *****************************************************


La busqueda recorre el arreglo recibido, con los limites de inicio y final establecidos,
comparando el elemento a buscar con cada elemento del arreglo. Si encuentra el numero,
se devolvera un cero y termina la funcion.
Si no, devolvera un 1.

*///********************************************************************************
 int busquedaLineal (int* A, int numero,int inicio, int fin)
 {
 	for(int i=inicio;i<=fin;i++){
		if(A[i]==numero) return 0;	
	}
	return 1;
 }
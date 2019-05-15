//*****************************************************************
/*
							HUNTERS 
				Materia:Análisis de algoritmos
	ESCUELA SUPERIOR DE CÓMPUTO - IPN SEPTIEMBRE 2018
	BUSQUEDA LINEAL UTILIZANDO THREADS
	Compilación: "gcc -pthread -o binaria binaria.c"
	Ejecución: "./binaria"
	*/
//Compilación: gcc -pthread -o binaria binaria.c
//Ejecucion ./binaria
//Ejecución: ./Busqueda 4 1000000 2 <10millones.txt 
// donde ./Busqueda X Y Z <10millones.txt 
// X:numero de hilos, Y:Los primeros y numeros Z:El numero a buscar
/*
Con los numeros A=[ 322486, 14700764, 3128036, 6337399, 61396,
10393545, 2147445644, 1295390003, 450057883, 187645041,
1980098116, 152503, 5000, 1493283650, 214826, 1843349527,
1360839354, 2109248666 , 2147470852 y 0].

Con tamaños de problema
Considerar para tamaño de problema “n” primeramente los primeros
100, 1000, 5000, 10000, 50000, 100000, 200000, 400000, 600000,
800000, 1000000, 2000000, 3000000, 4000000, 5000000, 6000000,
7000000, 8000000, 9000000 y 10000000 elementos del arreglo.
 */

//*****************************************************************

//*****************************************************************
//LIBRERIAS INCLUIDAS
//*****************************************************************
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include "tiempo.h"

//*****************************************************************
//VARIABLES GLOBALES
//*****************************************************************
int NumThreads;			//Número de threads
int N,j; //donde j es la variable global para el ciclo
int *A;
int numeros[]={322486,14700764,3128036,6337399,61396,10393545,2147445644,1295390003,450057883,187645041,1980098116,152503,5000,
1493283650,214826,1843349527,1360839354,2109248666,2147470852,0};

/*
int numeros=[322486,14700764,3128036,6337399,61396,
10393545,2147445644,1295390003,450057883,187645041,
1980098116,152503,5000,1493283650,214826,1843349527,
1360839354,2109248666,2147470852,0];*/

//********************************************************************************
//Realizar un procesamiento
//********************************************************************************
int BusquedaBinania(int* A, int numero, int inicio, int fin);

void* procesar(void* id)
{	
	int n_thread=(int)id;
	int inicio,fin,a;
	
	inicio=(n_thread*N)/NumThreads;
	if(n_thread==NumThreads-1)
	{
		fin=N;
	}	
	else{
		fin=((n_thread+1)*N)/NumThreads-1;
	}

	/*int posicion=BusquedaBinania(A,inicio,fin);
	if (posicion!=-1)
	{
		printf("El elemento esta en la posicion #%d, el hilo que lo encontro:%d \n", posicion, id);
	}else
	{
		printf("No se encontro el elemento del hilo: %d\n",id);
	}*/
	printf("\nHilo %d \tInicio %d\tTermino %d",n_thread,inicio,fin);

	if (BusquedaBinania(A,numeros[j],inicio,fin)==0)
	{
		printf("\n Se encontro el numero\n");
	}
	if(n_thread!=0)
	{
		pthread_exit(0);	
	}
	
}

//*****************************************************************
//PROGRAMA PRINCIPAL 
//*****************************************************************
int main (int argc, char *argv[])
{	
	int i,j,k; 	//Variables auxiliares para loops
	int tamanio;
	
	
	//********************************************************************************
	//Obtener el número de threads a usar y el arreglo para la identificacion de los mismos
	//********************************************************************************
	pthread_t *thread;
	if (argc<2) 
	{
		//printf("Indique el número de threads - \tEjemplo: [user@equipo]$ %s 4\n\n",argv[0]);
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
	/*Guardar los elementos en el arreglo*/
	//elemento=atoi(argv[3]);	
	A = (int*)malloc(N*sizeof(int));
  	for(i = 0;i<N;i++){
  		//scanf("%d",&A[i]);
  		scanf("%d",(A+i));
	}

	for(j=0;j<20;j++)
	{
	//******************************************************************	
	//Iniciar el conteo del tiempo para las evaluaciones de rendimiento
	//******************************************************************	
		double utime0, stime0, wtime0,utime1, stime1, wtime1;
		uswtime(&utime0, &stime0, &wtime0);
		printf("***************Numero: %d ***************\n",numeros[j] );

		for (i = 1; i < NumThreads; i++)
		{
			//Crear los threads que se comportaran segun la funcion procesar.
			if (pthread_create (&thread[i], NULL, procesar,(void*)i) != 0 ) 
			{
				perror("El thread no  pudo crearse");
				exit(-1);
			}
		}
		//El main ejecuta el thread 0
		procesar(0);
		//Esperar a que terminen los threads
		for (i=1; i<NumThreads; i++)
		{
			pthread_join (thread[i], NULL);	
		} 
	
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
	exit (0);	
}

/*
Funcion de bussqueda binaria que rcibe como parametros
el elemento a buscar, donde inicia y donde termina 
Realizar la busqueda.

La busqueda recorre el arreglo recibido, con los limites de inicio y final establecidos,
dividiendo entre 2 para hacer mitades y ver de que lado hará la busqueda
comparando el elemento a buscar con la parte del arreglo para encontrar el elemento. Si encuentra el numero,
se devolvera un cero y termina la funcion.
Si no, devolvera un -1.

*/

int BusquedaBinania(int *A,int elemento,int inicio,int fin)
{
	int derecha=fin;
	int izquierda=inicio;
	int centro;
	while(izquierda<=derecha)
	{
	  	centro=(derecha+izquierda)/2;
	  	if(A[centro]==elemento)
	  	{
	  		return centro;  	
	  	}else{
	  		if(elemento<A[centro])
	  		{
	  			derecha=centro-1;
	  		}else{
	  			izquierda=centro+1;	
	  		}
	  	}
	}		
  return -1;
}	

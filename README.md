
### Escuela Colombiana de Ingeniería
### Arquitecturas de Software - ARSW
## Ejercicio Introducción al paralelismo - Hilos - Caso BlackListSearch
## Laboratorio 1
## Integrantes 
* Lina Maria Buitrago Espindola
* Johan Stiven Bogota Velez 
  

**Parte I - Introducción a Hilos en Java**

En esta primera parte completamos la clase _CountThread_ para que las mismas definan el ciclo de vida de un hilo que imprimira por pantalla los números entre A y B posteriormente:

	1. Creamos  3 hilos de tipo CountThread, asignándole al primero el intervalo [0..99], al segundo [99..199], y al tercero [200..299].
	
	![image](https://user-images.githubusercontent.com/59893804/105916083-74275a00-5ffe-11eb-88dd-738c60e5e70f.png)
	
	2. Iniciamos los tres hilos con 'start()'.
	
	![image](https://user-images.githubusercontent.com/59893804/105916132-87d2c080-5ffe-11eb-8f99-1b7b0919aa37.png)
	
	3. Ejecutamos y revisamos la salida por pantalla. 
	4. Cambie el incio con 'start()' por 'run()'. Cómo cambia la salida?, por qué?.
	En primer lugar cabe aclarar que el start lanza el hilo ejecutando el método run mientras que el .run ejecuta solo el método de la clase. En la salida de .start 		logramos obtener todos los números solicitados en el hilo pero no lo obtenemos de forma secuencial y ordenada mientras que con .run si lo logramos. Con ambos métodos 		logramos el objetivo pero con .run logramos una salida más clara.
	
	* .run()
	![image](https://user-images.githubusercontent.com/59893804/105917066-e51b4180-5fff-11eb-8f1d-d07d2ed82dbb.png)

	* .start()
	![image](https://user-images.githubusercontent.com/59893804/105917201-09771e00-6000-11eb-9b1b-9f7e21928b7c.png)


**Parte II - Ejercicio Black List Search**

1. Cree una clase de tipo Thread que represente el ciclo de vida de un hilo que haga la búsqueda de un segmento del conjunto de servidores disponibles. Agregue a dicha clase un método que permita 'preguntarle' a las instancias del mismo (los hilos) cuantas ocurrencias de servidores maliciosos ha encontrado o encontró.

2. Agregue al método 'checkHost' un parámetro entero N, correspondiente al número de hilos entre los que se va a realizar la búsqueda (recuerde tener en cuenta si N es par o impar!). Modifique el código de este método para que divida el espacio de búsqueda entre las N partes indicadas, y paralelice la búsqueda a través de N hilos. Haga que dicha función espere hasta que los N hilos terminen de resolver su respectivo sub-problema, agregue las ocurrencias encontradas por cada hilo a la lista que retorna el método, y entonces calcule (sumando el total de ocurrencuas encontradas por cada hilo) si el número de ocurrencias es mayor o igual a _BLACK_LIST_ALARM_COUNT_. Si se da este caso, al final se DEBE reportar el host como confiable o no confiable, y mostrar el listado con los números de las listas negras respectivas. Para lograr este comportamiento de 'espera' revise el método [join](https://docs.oracle.com/javase/tutorial/essential/concurrency/join.html) del API de concurrencia de Java. Tenga también en cuenta:


**Parte II.I Para discutir la próxima clase (NO para implementar aún)**

La estrategia de paralelismo antes implementada es ineficiente en ciertos casos, pues la búsqueda se sigue realizando aún cuando los N hilos (en su conjunto) ya hayan encontrado el número mínimo de ocurrencias requeridas para reportar al servidor como malicioso. Cómo se podría modificar la implementación para minimizar el número de consultas en estos casos?, qué elemento nuevo traería esto al problema?

**Parte III - Evaluación de Desempeño**

A partir de lo anterior, implemente la siguiente secuencia de experimentos para realizar las validación de direcciones IP dispersas (por ejemplo 202.24.34.55), tomando los tiempos de ejecución de los mismos (asegúrese de hacerlos en la misma máquina):

Al iniciar el programa ejecute el monitor jVisualVM, y a medida que corran las pruebas, revise y anote el consumo de CPU y de memoria en cada caso.

1. Un solo hilo.

![image](https://user-images.githubusercontent.com/59893804/105909067-104c6380-5ff5-11eb-8235-b288d687e735.png)

![image](https://user-images.githubusercontent.com/59893804/105909081-16424480-5ff5-11eb-89ae-748648319d84.png)

2. Tantos hilos como núcleos de procesamiento (haga que el programa determine esto haciendo uso del [API Runtime](https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html)).

_En este caso los nucleos de procesamiento logicos fueron 8_ 

![image](https://user-images.githubusercontent.com/59893804/105909228-4ab60080-5ff5-11eb-83a7-0cf21ebad7dd.png)

![image](https://user-images.githubusercontent.com/59893804/105909243-4ee21e00-5ff5-11eb-9072-f6b4bc76e4f0.png)

![image](https://user-images.githubusercontent.com/59893804/105909253-51447800-5ff5-11eb-92e6-6375ce7f6e6c.png)


3. Tantos hilos como el doble de núcleos de procesamiento.

_Como anteriormente los nucleos de procesamiento fueron 8 en este caso serian 16_

![image](https://user-images.githubusercontent.com/59893804/105909353-71743700-5ff5-11eb-8e4f-23850e9e9f7b.png)

![image](https://user-images.githubusercontent.com/59893804/105909365-746f2780-5ff5-11eb-85f3-a759007bbdd8.png)

4. 50 hilos.

![image](https://user-images.githubusercontent.com/59893804/105909428-8bae1500-5ff5-11eb-9ceb-66253759f725.png)

![image](https://user-images.githubusercontent.com/59893804/105909435-8e106f00-5ff5-11eb-928c-5819702996f5.png)

5. 100 hilos.

![image](https://user-images.githubusercontent.com/59893804/105909477-9799d700-5ff5-11eb-8308-e8d650229d26.png)

![image](https://user-images.githubusercontent.com/59893804/105909497-9d8fb800-5ff5-11eb-830e-724046a22019.png)

Con lo anterior, y con los tiempos de ejecución dados, haga una gráfica de tiempo de solución vs. número de hilos. Analice y plantee hipótesis con su compañero para las siguientes preguntas (puede tener en cuenta lo reportado por jVisualVM):

![image](https://user-images.githubusercontent.com/59893804/105913456-db430f80-5ffa-11eb-87a3-fe9db6ee3627.png)

![image](https://user-images.githubusercontent.com/59893804/105913269-90c19300-5ffa-11eb-9d8d-a1832f131821.png)



1. Según la [ley de Amdahls](https://www.pugetsystems.com/labs/articles/Estimating-CPU-Performance-using-Amdahls-Law-619/#WhatisAmdahlsLaw?):

	![](img/ahmdahls.png), donde _S(n)_ es el mejoramiento teórico del desempeño, _P_ la fracción paralelizable del algoritmo, y _n_ el número de hilos, a mayor _n_, mayor debería ser dicha mejora. Por qué el mejor desempeño no se logra con los 500 hilos?, cómo se compara este desempeño cuando se usan 200?. 

2. Cómo se comporta la solución usando tantos hilos de procesamiento como núcleos comparado con el resultado de usar el doble de éste?.

3. De acuerdo con lo anterior, si para este problema en lugar de 100 hilos en una sola CPU se pudiera usar 1 hilo en cada una de 100 máquinas hipotéticas, la ley de Amdahls se aplicaría mejor?. Si en lugar de esto se usaran c hilos en 100/c máquinas distribuidas (siendo c es el número de núcleos de dichas máquinas), se mejoraría?. Explique su respuesta.




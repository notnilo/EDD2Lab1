public class ArbolTools{

	/* Math.random() retorna un numero en el intervalo real [0,1)
	El uno es exclusivo, suponiendo que la probabilidad que Math.random() retorne un n < 0.5 es la misma que retornar un n >= 0.5
	entonces randomBoolean() es una funcion que el 50% de las veces retorna true y 50% de las veces retorna false. Esto nos permite
	escoger con aleatoridad la ubicacion del nodo sostenibilidad.
	 */
	private static boolean randomBoolean(){
		return Math.random() < 0.5 ? true : false;
	}

	public static void assignSustainabilityLeaf(Nodo n, Texto t){
		if(isLeaf(n)){
		
			//asginamos como nodo sosteniblidad.
			Texto Texto = new Texto();
			n.setNombre("Sostenibilidad");
			n.setTrivia(t.getQuestions("triviaSostenibilidad"));
			n.setContexto("La sostenibilidad es el equilibrio entre el crecimiento humano y la conservación del planeta para las futuras generaciones");
			
		}else{
			//Escogemos una direccion al azar al recorrer el nodo cuesta abajo.
			if(randomBoolean()){
				assignSustainabilityLeaf(n.getIzq(),t);
			}else{
				assignSustainabilityLeaf(n.getDer(),t);
			}
		}
	}
	//Retorna 1 si es nodo hoja. Es nodo hoja si no tiene hijos.
	public static boolean isLeaf(Nodo n){
		return (n.getIzq() == null && n.getDer() == null) ? true : false;
	}
}

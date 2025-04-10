public class ArbolTools{

	// Math.random() return a number between [0,1)
	private static boolean randomBoolean(){
		return Math.random() < 0.5 ? true : false;
	}

	public static void assignSustainabilityLeaf(Nodo n, Texto t){
		if(isLeaf(n)){
		
			//asginamos como nodo sosteniblidad
			Texto Texto = new Texto();
			n.setNombre("Sostenibilidad");
			n.setTrivia(t.getQuestions("triviaSostenibilidad"));
			n.setContexto("La sostenibilidad es el equilibrio entre el crecimiento humano y la conservación del planeta para las futuras generaciones");
			
		}else{
			//Escogemos una direccion al azar al bajar el nodo
			if(randomBoolean()){
				assignSustainabilityLeaf(n.getIzq(),t);
			}else{
				assignSustainabilityLeaf(n.getDer(),t);
			}
		}
	}

	public static boolean isLeaf(Nodo n){
		return (n.getIzq() == null && n.getDer() == null) ? true : false;
	}

	public static void displayTreeMap(){
		
	}
	
}

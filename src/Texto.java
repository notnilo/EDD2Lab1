/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author notnilo
 */
public class Texto {

    //Texto
    private static String instrucciones = "Bienvenid@ a una aventura ecológica por el planeta tierra… (HAGAN LAS INSTRUCCIONES)";
    private static String contextoTerrestre = "Explora la diversidad de vida en la Tierra. Los ecosistemas terrestres son fundamentales para el equilibrio global, pero enfrentan amenazas como la deforestación y el cambio climático.";
    private static String contextoAcuatico = "Sumérgete en el mundo acuático, esencial para la vida en la Tierra. Los ecosistemas acuáticos, tanto de agua dulce como salada, enfrentan la contaminación y la sobrepesca.";
    private static String contextoBosque = "Los bosques son pulmones del planeta, hogar de innumerables especies y reguladores del clima. Su destrucción libera CO2 y acelera el calentamiento global.";
    private static String contextoPradera = "Las praderas, con sus vastas extensiones de pastizales, son esenciales para la agricultura y la vida silvestre. La sobreexplotación y la conversión a tierras de cultivo alteran su equilibrio.";
    private static String contextoSelvaTropical = "Las selvas tropicales albergan la mayor biodiversidad del planeta. Su deforestación no solo extingue especies, sino que también afecta ciclos de agua y clima a nivel mundial.";
    private static String contextoBosqueTemplado = "Los bosques templados, con sus estaciones marcadas, son vitales para la calidad del aire y la conservación del suelo. La contaminación y la tala indiscriminada amenazan su salud.";
    private static String contextoSabana = "Las sabanas africanas, con su rica fauna, son un ejemplo de la importancia de los grandes herbívoros para mantener el equilibrio ecológico. La caza furtiva y la pérdida de hábitat amenazan su supervivencia.";
    private static String contextoEstepa = "Las estepas, con su clima árido, son hogar de especies adaptadas a condiciones extremas. La desertificación y el sobrepastoreo amenazan su frágil equilibrio.";
    private static String contextoAguaDulce = "Los ríos y lagos son fuentes de agua potable y hábitats vitales para muchas especies. La contaminación y la extracción excesiva amenazan su disponibilidad y calidad.";
    private static String contextoAguaSalada = "Los océanos, con su inmensidad, regulan el clima y albergan una increíble diversidad de vida. La sobrepesca, la contaminación plástica y el cambio climático amenazan su salud.";
    private static String contextoRio = "Los ríos, con su flujo constante, conectan ecosistemas terrestres y marinos. La contaminación industrial y agrícola afecta su biodiversidad y salud.";
    private static String contextoLago = "Los lagos, con su agua quieta, son ecosistemas únicos y vulnerables a la contaminación y la introducción de especies invasoras.";
    private static String contextoOceano = "Los océanos, con sus corrientes y profundidades, son esenciales para la vida en la Tierra. La acidificación y el calentamiento global amenazan sus ecosistemas.";
    private static String contextoArrecife = "Los arrecifes de coral, con su vibrante vida, son ecosistemas marinos de gran importancia ecológica y económica. El blanqueamiento y la destrucción física amenazan su supervivencia.";

    //Preguntas. Estructura del arreglo: {P1, R1, P2, R2, P3, R3}
    private static String[] triviaTerrestre = {"¿Cuál de los siguientes es un ejemplo de ecosistema terrestre?\n" + "a) Océano\n" + "b) Arrecife\n" + "c) Bosque\n" + "d) Lago", "c", "¿Qué proceso vital realizan los bosques que ayuda a regular el clima global?\n" + "a) Fotosíntesis submarina\n" + "b) Filtración de agua salada\n" + "c) Generación de corrientes oceánicas\n" + "d) Absorción de CO2", "d", "¿Cuál es la mayor amenaza para los ecosistemas de pradera en muchas regiones?\n" + "a) Contaminación plástica\n" + "b) Sobrepastoreo y conversión a agricultura\n" + "c) Acidificación del océano\n" + "d) Blanqueamiento de corales", "b"};
    private static String[] triviaAcuatico = {"¿Cuál de los siguientes es un ejemplo de ecosistema acuático?\n" + "a) Bosque\n" + "b) Pradera\n" + "c) Estepa\n" + "d) Río", "d", "¿Qué contaminante es una gran amenaza para la salud de los océanos?\n" + "a) Contaminación lumínica\n" + "b) Contaminación plástica\n" + "c) Contaminación acústica\n" + "d) Contaminación visual", "b", "¿Qué causa la eutrofización en lagos y ríos?\n" + "a) Exceso de nutrientes\n" + "\n" + "b) Acidificación\n" + "\n" + "c) Blanqueamiento\n" + "\n" + "d) Compactación del suelo", "a"};
    private static String[] triviaBosque = {"¿Qué tipo de bosque se caracteriza por tener una alta biodiversidad y clima cálido y húmedo?\n" + "a) Bosque templado\n" + "b) Selva tropical\n" + "c) Estepa\n" + "d) Taiga", "b", "¿Qué factor contribuye principalmente a la pérdida de bosques templados?\n" + "a) Derretimiento de glaciares\n" + "b) Contaminación marina\n" + "c) Tala indiscriminada\n" + "d) Eutrofización", "c", "¿Cuál es una consecuencia importante de la deforestación?\n" + "a) Aumento de la biodiversidad marina\n" + "b) Disminución de la acidificación del océano\n" + "c) Liberación de CO2 y cambio climático\n" + "d) Mejora de la calidad del agua en lagos", "c"};
    private static String[] triviaPradera = {"¿Qué amenaza la biodiversidad de las sabanas africanas?\n" + "a) Sobrepesca\n" + "b) Contaminación lumínica\n" + "c) Caza furtiva\n" + "d) Acidificación del suelo", "c", "¿Cuál de los siguientes es un ejemplo de pradera?\n" + "a) Arrecife de coral\n" + "b) Río\n" + "c) Sabana\n" + "d) Lago", "c", "¿Qué proceso natural es común en las estepas y puede ser exacerbado por el sobrepastoreo?\n" + "a) Inundaciones\n" + "b) Tsunami\n" + "c) Desertificación\n" + "d) Blanqueamiento de corales", "c"};
    private static String[] triviaSelvaTropical = {"¿Cuál es la principal causa de la pérdida de biodiversidad en las selvas tropicales?\n" + "a) La contaminación del agua\n" + "b) La deforestación\n" + "c) El cambio climático\n" + "d) La sobrepesca", "b", "¿Qué porcentaje aproximado de las especies terrestres del mundo se encuentra en las selvas tropicales?\n" + "a) 10%\n" + "b) 25%\n" + "c) 50%\n" + "d) 75%", "c", "¿Qué función importante desempeñan las selvas tropicales en el ciclo del agua?\n" + "a) Regulan las precipitaciones y el flujo de ríos\n" + "b) Filtran el agua salada\n" + "c) Generan corrientes oceánicas\n" + "d) Almacenan agua subterránea", "a"};
    private static String[] triviaBosqueTemplado = {"¿Qué característica define principalmente a los bosques templados?\n" + "a) Clima cálido y húmedo constante\n" + "b) Estaciones marcadas y moderadas\n" + "c) Escasez de precipitaciones\n" + "d) Suelos permanentemente congelados", "b", "¿Qué tipo de árboles predominan en los bosques templados caducifolios?\n" + "a) Coníferas\n" + "b) Árboles de hoja ancha\n" + "c) Palmeras\n" + "d) Manglares", "b", "¿Qué beneficio principal ofrecen los bosques templados en relación con la calidad del aire?\n" + "a) Generan oxígeno marino\n" + "b) Filtran contaminantes y producen oxígeno\n" + "c) Reducen la acidez del océano\n" + "d) Regulan las mareas", "b"};
    private static String[] triviaSabana = {"¿Qué grandes animales herbívoros son característicos de las sabanas africanas?\n" + "a) Ballenas y delfines\n" + "b) Osos polares y focas\n" + "c) Cebras y jirafas\n" + "d) Pingüinos y morsas", "c", "¿Qué tipo de vegetación es predominante en las sabanas?\n" + "a) Bosques densos\n" + "b) Arrecifes de coral\n" + "c) Pastizales y árboles dispersos\n" + "d) Manglares", "c", "¿Qué fenómeno natural es importante para el mantenimiento de las sabanas?\n" + "a) Tsunami\n" + "b) Eutrofización\n" + "c) Incendios forestales controlados\n" + "d) Acidificación del suelo", "c"};
    private static String[] triviaEstepa = {"¿Qué tipo de clima caracteriza a las estepas?\n" + "a) Tropical húmedo\n" + "b) Polar\n" + "c) Árido o semiárido\n" + "d) Mediterráneo", "c", "¿Qué tipo de vegetación es común en las estepas?\n" + "a) Árboles altos y frondosos\n" + "b) Hierbas y arbustos bajos\n" + "c) Manglares\n" + "d) Algas marinas", "b", "¿Qué problema ambiental importante afecta a las estepas?\n" + "a) Blanqueamiento de corales\n" + "b) Contaminación marina\n" + "c) Desertificación\n" + "d) Acidificación del océano", "c"};
    private static String[] triviaAguaDulce = {"¿Qué amenaza la calidad del agua en los ríos?\n" + "a) Contaminación industrial y agrícola\n" + "b) Acidificación del océano\n" + "c) Derretimiento de glaciares\n" + "d) Blanqueamiento de corales", "a", "¿Qué proceso afecta negativamente a los lagos al reducir el oxígeno disuelto?\n" + "a) Acidificación\n" + "b) Eutrofización\n" + "c) Desalinización\n" + "d) Sedimentación marina", "b", "¿Cuál es un ejemplo de ecosistema de agua dulce?\n" + "a) Océano\n" + "b) Río\n" + "c) Arrecife\n" + "d) Glaciar", "b"};
    private static String[] triviaAguaSalada = {"¿Qué proceso global afecta la vida marina debido al aumento de CO2 en la atmósfera?\n" + "a) Acidificación del océano\n" + "b) Desertificación\n" + "c) Erosión del suelo\n" + "d) Deforestación", "a", "¿Cuál es un ejemplo de ecosistema de agua salada?\n" + "a) Río\n" + "b) Lago\n" + "c) Océano\n" + "d) Estuario", "c", "¿Qué amenaza la supervivencia de los arrecifes de coral?\n" + "a) Contaminación lumínica\n" + "b) Blanqueamiento\n" + "c) Contaminación acústica\n" + "d) Contaminación visual", "b"};
    private static String[] triviaRio = {"¿Qué función vital desempeñan los ríos en el ciclo del agua?\n" + "a) Transportan agua dulce hacia los océanos\n" + "b) Generan mareas\n" + "c) Filtran agua salada\n" + "d) Regulan la acidez oceánica", "a", "¿Qué tipo de contaminante es común en los ríos cercanos a áreas urbanas e industriales?\n" + "a) Contaminantes químicos y aguas residuales\n" + "b) Plásticos oceánicos\n" + "c) Cenizas volcánicas\n" + "d) Sedimentos marinos", "a", "¿Qué importancia tienen las zonas ribereñas para la biodiversidad?\n" + "a) No son importantes para la biodiversidad\n" + "b) solo benefician a especies marinas.\n" + "c) Son hábitat para diversas especies de plantas y animales\n" + "d) Solo son importantes para la fauna de las estepas.", "c"};
    private static String[] triviaLago = {"¿Qué factor puede causar la eutrofización en los lagos?\n" + "a) Acidificación del agua\n" + "b) Blanqueamiento\n" + "c) Exceso de nutrientes (nitrógeno y fósforo)\n" + "d) Incremento de la salinidad", "c", "¿Qué característica distingue a los lagos de los ríos?\n" + "a) Flujo constante de agua\n" + "b) Agua relativamente quieta\n" + "c) Alta salinidad\n" + "d) Profundidad extrema", "b", "¿Qué función ecológica cumplen los lagos?\n" + "a) son hábitats de vida silvestre y reservorios de agua dulce\n" + "b) son creadores de corrientes marinas.\n" + "c) regulan la temperatura oceanica.\n" + "d) ayudan a la polinización en la sabana.", "a"};
    private static String[] triviaOceano = {"¿Cuál es la relación entre el aumento del nivel del mar y la pérdida de ecosistemas costeros como los manglares y los humedales salinos?\n" + "a) El aumento del nivel del mar beneficia a estos ecosistemas al aumentar la biodiversidad.\n" + "b) El aumento del nivel del mar inunda y destruye estos ecosistemas, liberando carbono almacenado y reduciendo su capacidad de protección costera.\n" + "c) No existe una relación directa entre el aumento del nivel del mar y la pérdida de ecosistemas costeros.\n" + "d) Estos ecosistemas se adaptan fácilmente al aumento del nivel del mar mediante la migración hacia aguas más profundas.", "b", "¿Qué efecto tiene la acidificación del océano en los organismos marinos con conchas de carbonato de calcio?\n" + "a) Mejora el crecimiento de sus conchas\n" + "b) Disuelve sus conchas\n" + "c) Aumenta su capacidad de camuflaje\n" + "d) No tiene ningún efecto", "b", "¿Qué actividad humana es una de las principales fuentes de contaminación en los océanos?\n" + "a) La producción y el desecho inadecuado de plásticos\n" + "b) La tala de bosques tropicales\n" + "c) La minería en estepas\n" + "d) La ganadería en sabanas.", "a"};
    private static String[] triviaArrecife = {"¿Qué son los corales?\n" + "a) Rocas marinas\n" + "b) Animales marinos que forman colonias\n" + "c) Algas gigantes\n" + "d) Estructuras volcánicas submarinas", "b", "¿Qué proceso ocurre cuando los corales expulsan las algas simbióticas que les dan color?\n" + "a) Blanqueamiento de corales\n" + "b) Acidificación\n" + "c) Eutrofización\n" + "d) Sedimentación", "a", "Más allá de su valor ecológico, ¿qué importancia cultural tienen los arrecifes de coral para muchas comunidades costeras alrededor del mundo?\n" + "a) Son utilizados como sitios de extracción minera submarina.\n" + "b) Sirven como indicadores de la calidad del aire local.\n" + "c) Forman parte integral de sus tradiciones, mitologías y modos de vida ancestrales.\n" + "d) Son utilizados como campos de entrenamiento para la navegación submarina.", "c"};

    //Getters
    public static String getInstrucciones() {
        return instrucciones;
    }

    public static String getContextoTerrestre() {
        return contextoTerrestre;
    }

    public static String getContextoAcuatico() {
        return contextoAcuatico;
    }

    public static String getContextoBosque() {
        return contextoBosque;
    }

    public static String getContextoPradera() {
        return contextoPradera;
    }

    public static String getContextoSelvaTropical() {
        return contextoSelvaTropical;
    }

    public static String getContextoBosqueTemplado() {
        return contextoBosqueTemplado;
    }

    public static String getContextoSabana() {
        return contextoSabana;
    }

    public static String getContextoEstepa() {
        return contextoEstepa;
    }

    public static String getContextoAguaDulce() {
        return contextoAguaDulce;
    }

    public static String getContextoAguaSalada() {
        return contextoAguaSalada;
    }

    public static String getContextoRio() {
        return contextoRio;
    }

    public static String getContextoLago() {
        return contextoLago;
    }

    public static String getContextoOceano() {
        return contextoOceano;
    }

    public static String getContextoArrecife() {
        return contextoArrecife;
    }

    public static String[] getTriviaTerrestre() {
        return triviaTerrestre;
    }

    public static String[] getTriviaAcuatico() {
        return triviaAcuatico;
    }

    public static String[] getTriviaBosque() {
        return triviaBosque;
    }

    public static String[] getTriviaPradera() {
        return triviaPradera;
    }

    public static String[] getTriviaSelvaTropical() {
        return triviaSelvaTropical;
    }

    public static String[] getTriviaBosqueTemplado() {
        return triviaBosqueTemplado;
    }

    public static String[] getTriviaSabana() {
        return triviaSabana;
    }

    public static String[] getTriviaEstepa() {
        return triviaEstepa;
    }

    public static String[] getTriviaAguaDulce() {
        return triviaAguaDulce;
    }

    public static String[] getTriviaAguaSalada() {
        return triviaAguaSalada;
    }

    public static String[] getTriviaRio() {
        return triviaRio;
    }

    public static String[] getTriviaLago() {
        return triviaLago;
    }

    public static String[] getTriviaOceano() {
        return triviaOceano;
    }

    public static String[] getTriviaArrecife() {
        return triviaArrecife;
    }
}

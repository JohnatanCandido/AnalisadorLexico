import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

    private static final List<String> alfabeto = Arrays.asList(
            "R", "A", "N", "S", "E", "D", "U", "I", "T", "G", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "!", "@", "#", "$", "%", "(", ")", ",", ";", ".", ":", "=", "+", "-", "*", "/", "<",
            ">", "\"", "V", "B", "F", "P", "C", "O", "W", "L", "H", "M", "&", "[", "?", "{", "}", "]", "´", "~", "`",
            "^", "|", "\\", "_", "J", "K", "Q", "X", "Y", "Z", " ", "§");

    private static final List<String> estados = Arrays.asList(
            "q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9", "q10",
            "q11", "q12", "q13", "q14", "q15", "q16", "q17", "q18", "q19", "q20",
            "q21", "q22", "q23", "q24", "q25", "q26", "q27", "q28", "q29", "q30",
            "q31", "q32", "q33", "q34", "q35", "q36", "q37", "q38", "q39", "q40",
            "q41", "q42", "q43", "q44", "q45", "q46", "q47", "q48", "q49", "q50",
            "q51", "q52", "q53", "q54", "q55", "q56", "q57", "q58", "q59", "q60",
            "q61", "q62", "q63", "q64", "q65");

    public static final List<String> estadosReconhecedores = Arrays.asList("q1", "q2", "q3", "q48", "q47", "q62");
    private static String[][] matrizTransicao = new String[alfabeto.size()][estados.size()];
    public static Map<String, String> palavrasReservadas = new HashMap<>();
    public static Map<String, String> simbolosEspeciais = new HashMap<>();

    static {
        for (int i = 0; i < alfabeto.size(); i++)
            for (int j = 0; j < estados.size(); j++)
                matrizTransicao[i][j] = null;

        matrizTransicao[0][0] = "q56";  //<q0> ::= R<q56>
        matrizTransicao[0][2] = "q2";  //<q2> ::= R<q2>
        matrizTransicao[0][4] = "q46";  //<q4> ::= R<q46>
        matrizTransicao[0][5] = "q6";  //<q5> ::= R<q6>
        matrizTransicao[0][12] = "q1";  //<q12> ::= R<q1>
        matrizTransicao[0][16] = "q17";  //<q16> ::= R<q17>
        matrizTransicao[0][46] = "q46";  //<q46> ::= R<q46>
        matrizTransicao[0][49] = "q57";  //<q49> ::= R<q57>
        matrizTransicao[0][53] = "q1";  //<q53> ::= R<q1>
        matrizTransicao[0][55] = "q40";  //<q55> ::= R<q40>
        matrizTransicao[0][61] = "q31";  //<q61> ::= R<q31>
        matrizTransicao[0][63] = "q64";  //<q63> ::= R<q64>
        matrizTransicao[0][64] = "q64";  //<q64> ::= R<q64>
        matrizTransicao[1][0] = "q43";  //<q0> ::= A<q43>
        matrizTransicao[1][2] = "q2";  //<q2> ::= A<q2>
        matrizTransicao[1][4] = "q46";  //<q4> ::= A<q46>
        matrizTransicao[1][6] = "q7";  //<q6> ::= A<q7>
        matrizTransicao[1][11] = "q12";  //<q11> ::= A<q12>
        matrizTransicao[1][33] = "q10";  //<q33> ::= A<q10>
        matrizTransicao[1][46] = "q46";  //<q46> ::= A<q46>
        matrizTransicao[1][50] = "q58";  //<q50> ::= A<q58>
        matrizTransicao[1][59] = "q37";  //<q59> ::= A<q37>
        matrizTransicao[1][63] = "q64";  //<q63> ::= A<q64>
        matrizTransicao[1][64] = "q64";  //<q64> ::= A<q64>
        matrizTransicao[2][0] = "q44";  //<q0> ::= N<q44>
        matrizTransicao[2][2] = "q2";  //<q2> ::= N<q2>
        matrizTransicao[2][4] = "q46";  //<q4> ::= N<q46>
        matrizTransicao[2][8] = "q9";  //<q8> ::= N<q9>
        matrizTransicao[2][20] = "q1";  //<q20> ::= N<q1>
        matrizTransicao[2][34] = "q35";  //<q34> ::= N<q35>
        matrizTransicao[2][43] = "q21";  //<q43> ::= N<q21>
        matrizTransicao[2][46] = "q46";  //<q46> ::= N<q46>
        matrizTransicao[2][51] = "q21";  //<q51> ::= N<q21>
        matrizTransicao[2][52] = "q22";  //<q52> ::= N<q22>
        matrizTransicao[2][63] = "q64";  //<q63> ::= N<q64>
        matrizTransicao[2][64] = "q64";  //<q64> ::= N<q64>
        matrizTransicao[3][2] = "q2";  //<q2> ::= S<q2>
        matrizTransicao[3][4] = "q46";  //<q4> ::= S<q46>
        matrizTransicao[3][9] = "q10";  //<q9> ::= S<q10>
        matrizTransicao[3][28] = "q17";  //<q28> ::= S<q17>
        matrizTransicao[3][46] = "q46";  //<q46> ::= S<q46>
        matrizTransicao[3][58] = "q17";  //<q58> ::= S<q17>
        matrizTransicao[3][63] = "q64";  //<q63> ::= S<q64>
        matrizTransicao[3][64] = "q64";  //<q64> ::= S<q64>
        matrizTransicao[4][0] = "q51";  //<q0> ::= E<q51>
        matrizTransicao[4][2] = "q2";  //<q2> ::= E<q2>
        matrizTransicao[4][4] = "q46";  //<q4> ::= E<q46>
        matrizTransicao[4][13] = "q14";  //<q13> ::= E<q14>
        matrizTransicao[4][17] = "q1";  //<q17> ::= E<q1>
        matrizTransicao[4][18] = "q39";  //<q18> ::= E<q39>
        matrizTransicao[4][23] = "q24";  //<q23> ::= E<q24>
        matrizTransicao[4][25] = "q12";  //<q25> ::= E<q12>
        matrizTransicao[4][27] = "q20";  //<q27> ::= E<q20>
        matrizTransicao[4][32] = "q33";  //<q32> ::= E<q33>
        matrizTransicao[4][42] = "q38";  //<q42> ::= E<q38>
        matrizTransicao[4][46] = "q46";  //<q46> ::= E<q46>
        matrizTransicao[4][56] = "q59";  //<q56> ::= E<q59>
        matrizTransicao[4][63] = "q64";  //<q63> ::= E<q64>
        matrizTransicao[4][64] = "q64";  //<q64> ::= E<q64>
        matrizTransicao[5][0] = "q31";  //<q0> ::= D<q31>
        matrizTransicao[5][2] = "q2";  //<q2> ::= D<q2>
        matrizTransicao[5][4] = "q46";  //<q4> ::= D<q46>
        matrizTransicao[5][14] = "q15";  //<q14> ::= D<q15>
        matrizTransicao[5][21] = "q1";  //<q21> ::= D<q1>
        matrizTransicao[5][37] = "q38";  //<q37> ::= D<q38>
        matrizTransicao[5][46] = "q46";  //<q46> ::= D<q46>
        matrizTransicao[5][63] = "q64";  //<q63> ::= D<q64>
        matrizTransicao[5][64] = "q64";  //<q64> ::= D<q64>
        matrizTransicao[6][0] = "q34";  //<q0> ::= U<q34>
        matrizTransicao[6][2] = "q2";  //<q2> ::= U<q2>
        matrizTransicao[6][4] = "q46";  //<q4> ::= U<q46>
        matrizTransicao[6][15] = "q16";  //<q15> ::= U<q16>
        matrizTransicao[6][46] = "q46";  //<q46> ::= U<q46>
        matrizTransicao[6][63] = "q64";  //<q63> ::= U<q64>
        matrizTransicao[6][64] = "q64";  //<q64> ::= U<q64>
        matrizTransicao[7][0] = "q52";  //<q0> ::= I<q52>
        matrizTransicao[7][2] = "q2";  //<q2> ::= I<q2>
        matrizTransicao[7][4] = "q46";  //<q4> ::= I<q46>
        matrizTransicao[7][19] = "q20";  //<q19> ::= I<q20>
        matrizTransicao[7][24] = "q61";  //<q24> ::= I<q61>
        matrizTransicao[7][29] = "q30";  //<q29> ::= I<q30>
        matrizTransicao[7][36] = "q26";  //<q36> ::= I<q26>
        matrizTransicao[7][40] = "q41";  //<q40> ::= I<q41>
        matrizTransicao[7][46] = "q46";  //<q46> ::= I<q46>
        matrizTransicao[7][63] = "q64";  //<q63> ::= I<q64>
        matrizTransicao[7][64] = "q64";  //<q64> ::= I<q64>
        matrizTransicao[8][0] = "q54";  //<q0> ::= T<q54>
        matrizTransicao[8][2] = "q2";  //<q2> ::= T<q2>
        matrizTransicao[8][4] = "q46";  //<q4> ::= T<q46>
        matrizTransicao[8][10] = "q1";  //<q10> ::= T<q1>
        matrizTransicao[8][22] = "q23";  //<q22> ::= T<q23>
        matrizTransicao[8][35] = "q36";  //<q35> ::= T<q36>
        matrizTransicao[8][41] = "q42";  //<q41> ::= T<q42>
        matrizTransicao[8][46] = "q46";  //<q46> ::= T<q46>
        matrizTransicao[8][63] = "q64";  //<q63> ::= T<q64>
        matrizTransicao[8][64] = "q64";  //<q64> ::= T<q64>
        matrizTransicao[9][2] = "q2";  //<q2> ::= G<q2>
        matrizTransicao[9][4] = "q46";  //<q4> ::= G<q46>
        matrizTransicao[9][24] = "q25";  //<q24> ::= G<q25>
        matrizTransicao[9][39] = "q19";  //<q39> ::= G<q19>
        matrizTransicao[9][46] = "q46";  //<q46> ::= G<q46>
        matrizTransicao[9][60] = "q5";  //<q60> ::= G<q5>
        matrizTransicao[9][63] = "q64";  //<q63> ::= G<q64>
        matrizTransicao[9][64] = "q64";  //<q64> ::= G<q64>
        matrizTransicao[10][0] = "q2";  //<q0> ::= a<q2>
        matrizTransicao[10][2] = "q2";  //<q2> ::= a<q2>
        matrizTransicao[10][4] = "q46";  //<q4> ::= a<q46>
        matrizTransicao[10][46] = "q46";  //<q46> ::= a<q46>
        matrizTransicao[10][63] = "q64";  //<q63> ::= a<q64>
        matrizTransicao[10][64] = "q64";  //<q64> ::= a<q64>
        matrizTransicao[11][0] = "q2";  //<q0> ::= b<q2>
        matrizTransicao[11][2] = "q2";  //<q2> ::= b<q2>
        matrizTransicao[11][4] = "q46";  //<q4> ::= b<q46>
        matrizTransicao[11][46] = "q46";  //<q46> ::= b<q46>
        matrizTransicao[11][63] = "q64";  //<q63> ::= b<q64>
        matrizTransicao[11][64] = "q64";  //<q64> ::= b<q64>
        matrizTransicao[12][0] = "q2";  //<q0> ::= c<q2>
        matrizTransicao[12][2] = "q2";  //<q2> ::= c<q2>
        matrizTransicao[12][4] = "q46";  //<q4> ::= c<q46>
        matrizTransicao[12][46] = "q46";  //<q46> ::= c<q46>
        matrizTransicao[12][63] = "q64";  //<q63> ::= c<q64>
        matrizTransicao[12][64] = "q64";  //<q64> ::= c<q64>
        matrizTransicao[13][0] = "q2";  //<q0> ::= d<q2>
        matrizTransicao[13][2] = "q2";  //<q2> ::= d<q2>
        matrizTransicao[13][4] = "q46";  //<q4> ::= d<q46>
        matrizTransicao[13][46] = "q46";  //<q46> ::= d<q46>
        matrizTransicao[13][63] = "q64";  //<q63> ::= d<q64>
        matrizTransicao[13][64] = "q64";  //<q64> ::= d<q64>
        matrizTransicao[14][0] = "q2";  //<q0> ::= e<q2>
        matrizTransicao[14][2] = "q2";  //<q2> ::= e<q2>
        matrizTransicao[14][4] = "q46";  //<q4> ::= e<q46>
        matrizTransicao[14][46] = "q46";  //<q46> ::= e<q46>
        matrizTransicao[14][63] = "q64";  //<q63> ::= e<q64>
        matrizTransicao[14][64] = "q64";  //<q64> ::= e<q64>
        matrizTransicao[15][0] = "q2";  //<q0> ::= f<q2>
        matrizTransicao[15][2] = "q2";  //<q2> ::= f<q2>
        matrizTransicao[15][4] = "q46";  //<q4> ::= f<q46>
        matrizTransicao[15][46] = "q46";  //<q46> ::= f<q46>
        matrizTransicao[15][63] = "q64";  //<q63> ::= f<q64>
        matrizTransicao[15][64] = "q64";  //<q64> ::= f<q64>
        matrizTransicao[16][0] = "q2";  //<q0> ::= g<q2>
        matrizTransicao[16][2] = "q2";  //<q2> ::= g<q2>
        matrizTransicao[16][4] = "q46";  //<q4> ::= g<q46>
        matrizTransicao[16][46] = "q46";  //<q46> ::= g<q46>
        matrizTransicao[16][63] = "q64";  //<q63> ::= g<q64>
        matrizTransicao[16][64] = "q64";  //<q64> ::= g<q64>
        matrizTransicao[17][0] = "q2";  //<q0> ::= h<q2>
        matrizTransicao[17][2] = "q2";  //<q2> ::= h<q2>
        matrizTransicao[17][4] = "q46";  //<q4> ::= h<q46>
        matrizTransicao[17][46] = "q46";  //<q46> ::= h<q46>
        matrizTransicao[17][63] = "q64";  //<q63> ::= h<q64>
        matrizTransicao[17][64] = "q64";  //<q64> ::= h<q64>
        matrizTransicao[18][0] = "q2";  //<q0> ::= i<q2>
        matrizTransicao[18][2] = "q2";  //<q2> ::= i<q2>
        matrizTransicao[18][4] = "q46";  //<q4> ::= i<q46>
        matrizTransicao[18][46] = "q46";  //<q46> ::= i<q46>
        matrizTransicao[18][63] = "q64";  //<q63> ::= i<q64>
        matrizTransicao[18][64] = "q64";  //<q64> ::= i<q64>
        matrizTransicao[19][0] = "q2";  //<q0> ::= j<q2>
        matrizTransicao[19][2] = "q2";  //<q2> ::= j<q2>
        matrizTransicao[19][4] = "q46";  //<q4> ::= j<q46>
        matrizTransicao[19][46] = "q46";  //<q46> ::= j<q46>
        matrizTransicao[19][63] = "q64";  //<q63> ::= j<q64>
        matrizTransicao[19][64] = "q64";  //<q64> ::= j<q64>
        matrizTransicao[20][0] = "q2";  //<q0> ::= k<q2>
        matrizTransicao[20][2] = "q2";  //<q2> ::= k<q2>
        matrizTransicao[20][4] = "q46";  //<q4> ::= k<q46>
        matrizTransicao[20][46] = "q46";  //<q46> ::= k<q46>
        matrizTransicao[20][63] = "q64";  //<q63> ::= k<q64>
        matrizTransicao[20][64] = "q64";  //<q64> ::= k<q64>
        matrizTransicao[21][0] = "q2";  //<q0> ::= l<q2>
        matrizTransicao[21][2] = "q2";  //<q2> ::= l<q2>
        matrizTransicao[21][4] = "q46";  //<q4> ::= l<q46>
        matrizTransicao[21][46] = "q46";  //<q46> ::= l<q46>
        matrizTransicao[21][63] = "q64";  //<q63> ::= l<q64>
        matrizTransicao[21][64] = "q64";  //<q64> ::= l<q64>
        matrizTransicao[22][0] = "q2";  //<q0> ::= m<q2>
        matrizTransicao[22][2] = "q2";  //<q2> ::= m<q2>
        matrizTransicao[22][4] = "q46";  //<q4> ::= m<q46>
        matrizTransicao[22][46] = "q46";  //<q46> ::= m<q46>
        matrizTransicao[22][63] = "q64";  //<q63> ::= m<q64>
        matrizTransicao[22][64] = "q64";  //<q64> ::= m<q64>
        matrizTransicao[23][0] = "q2";  //<q0> ::= n<q2>
        matrizTransicao[23][2] = "q2";  //<q2> ::= n<q2>
        matrizTransicao[23][4] = "q46";  //<q4> ::= n<q46>
        matrizTransicao[23][46] = "q46";  //<q46> ::= n<q46>
        matrizTransicao[23][63] = "q64";  //<q63> ::= n<q64>
        matrizTransicao[23][64] = "q64";  //<q64> ::= n<q64>
        matrizTransicao[24][0] = "q2";  //<q0> ::= o<q2>
        matrizTransicao[24][2] = "q2";  //<q2> ::= o<q2>
        matrizTransicao[24][4] = "q46";  //<q4> ::= o<q46>
        matrizTransicao[24][46] = "q46";  //<q46> ::= o<q46>
        matrizTransicao[24][63] = "q64";  //<q63> ::= o<q64>
        matrizTransicao[24][64] = "q64";  //<q64> ::= o<q64>
        matrizTransicao[25][0] = "q2";  //<q0> ::= p<q2>
        matrizTransicao[25][2] = "q2";  //<q2> ::= p<q2>
        matrizTransicao[25][4] = "q46";  //<q4> ::= p<q46>
        matrizTransicao[25][46] = "q46";  //<q46> ::= p<q46>
        matrizTransicao[25][63] = "q64";  //<q63> ::= p<q64>
        matrizTransicao[25][64] = "q64";  //<q64> ::= p<q64>
        matrizTransicao[26][0] = "q2";  //<q0> ::= q<q2>
        matrizTransicao[26][2] = "q2";  //<q2> ::= q<q2>
        matrizTransicao[26][4] = "q46";  //<q4> ::= q<q46>
        matrizTransicao[26][46] = "q46";  //<q46> ::= q<q46>
        matrizTransicao[26][63] = "q64";  //<q63> ::= q<q64>
        matrizTransicao[26][64] = "q64";  //<q64> ::= q<q64>
        matrizTransicao[27][0] = "q2";  //<q0> ::= r<q2>
        matrizTransicao[27][2] = "q2";  //<q2> ::= r<q2>
        matrizTransicao[27][4] = "q46";  //<q4> ::= r<q46>
        matrizTransicao[27][46] = "q46";  //<q46> ::= r<q46>
        matrizTransicao[27][63] = "q64";  //<q63> ::= r<q64>
        matrizTransicao[27][64] = "q64";  //<q64> ::= r<q64>
        matrizTransicao[28][0] = "q2";  //<q0> ::= s<q2>
        matrizTransicao[28][2] = "q2";  //<q2> ::= s<q2>
        matrizTransicao[28][4] = "q46";  //<q4> ::= s<q46>
        matrizTransicao[28][46] = "q46";  //<q46> ::= s<q46>
        matrizTransicao[28][63] = "q64";  //<q63> ::= s<q64>
        matrizTransicao[28][64] = "q64";  //<q64> ::= s<q64>
        matrizTransicao[29][0] = "q2";  //<q0> ::= t<q2>
        matrizTransicao[29][2] = "q2";  //<q2> ::= t<q2>
        matrizTransicao[29][4] = "q46";  //<q4> ::= t<q46>
        matrizTransicao[29][46] = "q46";  //<q46> ::= t<q46>
        matrizTransicao[29][63] = "q64";  //<q63> ::= t<q64>
        matrizTransicao[29][64] = "q64";  //<q64> ::= t<q64>
        matrizTransicao[30][0] = "q2";  //<q0> ::= u<q2>
        matrizTransicao[30][2] = "q2";  //<q2> ::= u<q2>
        matrizTransicao[30][4] = "q46";  //<q4> ::= u<q46>
        matrizTransicao[30][46] = "q46";  //<q46> ::= u<q46>
        matrizTransicao[30][63] = "q64";  //<q63> ::= u<q64>
        matrizTransicao[30][64] = "q64";  //<q64> ::= u<q64>
        matrizTransicao[31][0] = "q2";  //<q0> ::= v<q2>
        matrizTransicao[31][2] = "q2";  //<q2> ::= v<q2>
        matrizTransicao[31][4] = "q46";  //<q4> ::= v<q46>
        matrizTransicao[31][46] = "q46";  //<q46> ::= v<q46>
        matrizTransicao[31][63] = "q64";  //<q63> ::= v<q64>
        matrizTransicao[31][64] = "q64";  //<q64> ::= v<q64>
        matrizTransicao[32][0] = "q2";  //<q0> ::= w<q2>
        matrizTransicao[32][2] = "q2";  //<q2> ::= w<q2>
        matrizTransicao[32][4] = "q46";  //<q4> ::= w<q46>
        matrizTransicao[32][46] = "q46";  //<q46> ::= w<q46>
        matrizTransicao[32][63] = "q64";  //<q63> ::= w<q64>
        matrizTransicao[32][64] = "q64";  //<q64> ::= w<q64>
        matrizTransicao[33][0] = "q2";  //<q0> ::= x<q2>
        matrizTransicao[33][2] = "q2";  //<q2> ::= x<q2>
        matrizTransicao[33][4] = "q46";  //<q4> ::= x<q46>
        matrizTransicao[33][46] = "q46";  //<q46> ::= x<q46>
        matrizTransicao[33][63] = "q64";  //<q63> ::= x<q64>
        matrizTransicao[33][64] = "q64";  //<q64> ::= x<q64>
        matrizTransicao[34][0] = "q2";  //<q0> ::= y<q2>
        matrizTransicao[34][2] = "q2";  //<q2> ::= y<q2>
        matrizTransicao[34][4] = "q46";  //<q4> ::= y<q46>
        matrizTransicao[34][46] = "q46";  //<q46> ::= y<q46>
        matrizTransicao[34][63] = "q64";  //<q63> ::= y<q64>
        matrizTransicao[34][64] = "q64";  //<q64> ::= y<q64>
        matrizTransicao[35][0] = "q2";  //<q0> ::= z<q2>
        matrizTransicao[35][2] = "q2";  //<q2> ::= z<q2>
        matrizTransicao[35][4] = "q46";  //<q4> ::= z<q46>
        matrizTransicao[35][46] = "q46";  //<q46> ::= z<q46>
        matrizTransicao[35][63] = "q64";  //<q63> ::= z<q64>
        matrizTransicao[35][64] = "q64";  //<q64> ::= z<q64>
        matrizTransicao[36][0] = "q3";  //<q0> ::= 0<q3>
        matrizTransicao[36][2] = "q2";  //<q2> ::= 0<q2>
        matrizTransicao[36][3] = "q3";  //<q3> ::= 0<q3>
        matrizTransicao[36][4] = "q46";  //<q4> ::= 0<q46>
        matrizTransicao[36][46] = "q46";  //<q46> ::= 0<q46>
        matrizTransicao[36][63] = "q64";  //<q63> ::= 0<q64>
        matrizTransicao[36][64] = "q64";  //<q64> ::= 0<q64>
        matrizTransicao[37][0] = "q3";  //<q0> ::= 1<q3>
        matrizTransicao[37][2] = "q2";  //<q2> ::= 1<q2>
        matrizTransicao[37][3] = "q3";  //<q3> ::= 1<q3>
        matrizTransicao[37][4] = "q46";  //<q4> ::= 1<q46>
        matrizTransicao[37][46] = "q46";  //<q46> ::= 1<q46>
        matrizTransicao[37][63] = "q64";  //<q63> ::= 1<q64>
        matrizTransicao[37][64] = "q64";  //<q64> ::= 1<q64>
        matrizTransicao[38][0] = "q3";  //<q0> ::= 2<q3>
        matrizTransicao[38][2] = "q2";  //<q2> ::= 2<q2>
        matrizTransicao[38][3] = "q3";  //<q3> ::= 2<q3>
        matrizTransicao[38][4] = "q46";  //<q4> ::= 2<q46>
        matrizTransicao[38][46] = "q46";  //<q46> ::= 2<q46>
        matrizTransicao[38][63] = "q64";  //<q63> ::= 2<q64>
        matrizTransicao[38][64] = "q64";  //<q64> ::= 2<q64>
        matrizTransicao[39][0] = "q3";  //<q0> ::= 3<q3>
        matrizTransicao[39][2] = "q2";  //<q2> ::= 3<q2>
        matrizTransicao[39][3] = "q3";  //<q3> ::= 3<q3>
        matrizTransicao[39][4] = "q46";  //<q4> ::= 3<q46>
        matrizTransicao[39][46] = "q46";  //<q46> ::= 3<q46>
        matrizTransicao[39][63] = "q64";  //<q63> ::= 3<q64>
        matrizTransicao[39][64] = "q64";  //<q64> ::= 3<q64>
        matrizTransicao[40][0] = "q3";  //<q0> ::= 4<q3>
        matrizTransicao[40][2] = "q2";  //<q2> ::= 4<q2>
        matrizTransicao[40][3] = "q3";  //<q3> ::= 4<q3>
        matrizTransicao[40][4] = "q46";  //<q4> ::= 4<q46>
        matrizTransicao[40][46] = "q46";  //<q46> ::= 4<q46>
        matrizTransicao[40][63] = "q64";  //<q63> ::= 4<q64>
        matrizTransicao[40][64] = "q64";  //<q64> ::= 4<q64>
        matrizTransicao[41][0] = "q3";  //<q0> ::= 5<q3>
        matrizTransicao[41][2] = "q2";  //<q2> ::= 5<q2>
        matrizTransicao[41][3] = "q3";  //<q3> ::= 5<q3>
        matrizTransicao[41][4] = "q46";  //<q4> ::= 5<q46>
        matrizTransicao[41][46] = "q46";  //<q46> ::= 5<q46>
        matrizTransicao[41][63] = "q64";  //<q63> ::= 5<q64>
        matrizTransicao[41][64] = "q64";  //<q64> ::= 5<q64>
        matrizTransicao[42][0] = "q3";  //<q0> ::= 6<q3>
        matrizTransicao[42][2] = "q2";  //<q2> ::= 6<q2>
        matrizTransicao[42][3] = "q3";  //<q3> ::= 6<q3>
        matrizTransicao[42][4] = "q46";  //<q4> ::= 6<q46>
        matrizTransicao[42][46] = "q46";  //<q46> ::= 6<q46>
        matrizTransicao[42][63] = "q64";  //<q63> ::= 6<q64>
        matrizTransicao[42][64] = "q64";  //<q64> ::= 6<q64>
        matrizTransicao[43][0] = "q3";  //<q0> ::= 7<q3>
        matrizTransicao[43][2] = "q2";  //<q2> ::= 7<q2>
        matrizTransicao[43][3] = "q3";  //<q3> ::= 7<q3>
        matrizTransicao[43][4] = "q46";  //<q4> ::= 7<q46>
        matrizTransicao[43][46] = "q46";  //<q46> ::= 7<q46>
        matrizTransicao[43][63] = "q64";  //<q63> ::= 7<q64>
        matrizTransicao[43][64] = "q64";  //<q64> ::= 7<q64>
        matrizTransicao[44][0] = "q3";  //<q0> ::= 8<q3>
        matrizTransicao[44][2] = "q2";  //<q2> ::= 8<q2>
        matrizTransicao[44][3] = "q3";  //<q3> ::= 8<q3>
        matrizTransicao[44][4] = "q46";  //<q4> ::= 8<q46>
        matrizTransicao[44][46] = "q46";  //<q46> ::= 8<q46>
        matrizTransicao[44][63] = "q64";  //<q63> ::= 8<q64>
        matrizTransicao[44][64] = "q64";  //<q64> ::= 8<q64>
        matrizTransicao[45][0] = "q3";  //<q0> ::= 9<q3>
        matrizTransicao[45][2] = "q2";  //<q2> ::= 9<q2>
        matrizTransicao[45][3] = "q3";  //<q3> ::= 9<q3>
        matrizTransicao[45][4] = "q46";  //<q4> ::= 9<q46>
        matrizTransicao[45][46] = "q46";  //<q46> ::= 9<q46>
        matrizTransicao[45][63] = "q64";  //<q63> ::= 9<q64>
        matrizTransicao[45][64] = "q64";  //<q64> ::= 9<q64>
        matrizTransicao[46][4] = "q46";  //<q4> ::= !<q46>
        matrizTransicao[46][46] = "q46";  //<q46> ::= !<q46>
        matrizTransicao[46][63] = "q64";  //<q63> ::= !<q64>
        matrizTransicao[46][64] = "q64";  //<q64> ::= !<q64>
        matrizTransicao[47][4] = "q46";  //<q4> ::= @<q46>
        matrizTransicao[47][46] = "q46";  //<q46> ::= @<q46>
        matrizTransicao[47][63] = "q64";  //<q63> ::= @<q64>
        matrizTransicao[47][64] = "q64";  //<q64> ::= @<q64>
        matrizTransicao[48][4] = "q46";  //<q4> ::= #<q46>
        matrizTransicao[48][46] = "q46";  //<q46> ::= #<q46>
        matrizTransicao[48][63] = "q64";  //<q63> ::= #<q64>
        matrizTransicao[48][64] = "q64";  //<q64> ::= #<q64>
        matrizTransicao[49][4] = "q46";  //<q4> ::= $<q46>
        matrizTransicao[49][46] = "q46";  //<q46> ::= $<q46>
        matrizTransicao[49][63] = "q64";  //<q63> ::= $<q64>
        matrizTransicao[49][64] = "q64";  //<q64> ::= $<q64>
        matrizTransicao[50][4] = "q46";  //<q4> ::= %<q46>
        matrizTransicao[50][46] = "q46";  //<q46> ::= %<q46>
        matrizTransicao[50][63] = "q64";  //<q63> ::= %<q64>
        matrizTransicao[50][64] = "q64";  //<q64> ::= %<q64>
        matrizTransicao[51][0] = "q62";  //<q0> ::= (<q62>
        matrizTransicao[51][4] = "q46";  //<q4> ::= (<q46>
        matrizTransicao[51][46] = "q46";  //<q46> ::= (<q46>
        matrizTransicao[51][63] = "q64";  //<q63> ::= (<q64>
        matrizTransicao[51][64] = "q64";  //<q64> ::= (<q64>
        matrizTransicao[52][0] = "q1";  //<q0> ::= )<q1>
        matrizTransicao[52][4] = "q46";  //<q4> ::= )<q46>
        matrizTransicao[52][46] = "q46";  //<q46> ::= )<q46>
        matrizTransicao[52][63] = "q64";  //<q63> ::= )<q64>
        matrizTransicao[52][64] = "q64";  //<q64> ::= )<q64>
        matrizTransicao[52][65] = "q1";  //<q65> ::= )<q1>
        matrizTransicao[53][0] = "q1";  //<q0> ::= ,<q1>
        matrizTransicao[53][4] = "q46";  //<q4> ::= ,<q46>
        matrizTransicao[53][46] = "q46";  //<q46> ::= ,<q46>
        matrizTransicao[53][63] = "q64";  //<q63> ::= ,<q64>
        matrizTransicao[53][64] = "q64";  //<q64> ::= ,<q64>
        matrizTransicao[54][0] = "q1";  //<q0> ::= ;<q1>
        matrizTransicao[54][4] = "q46";  //<q4> ::= ;<q46>
        matrizTransicao[54][46] = "q46";  //<q46> ::= ;<q46>
        matrizTransicao[54][63] = "q64";  //<q63> ::= ;<q64>
        matrizTransicao[54][64] = "q64";  //<q64> ::= ;<q64>
        matrizTransicao[55][0] = "q1";  //<q0> ::= .<q1>
        matrizTransicao[55][4] = "q46";  //<q4> ::= .<q46>
        matrizTransicao[55][46] = "q46";  //<q46> ::= .<q46>
        matrizTransicao[55][63] = "q64";  //<q63> ::= .<q64>
        matrizTransicao[55][64] = "q64";  //<q64> ::= .<q64>
        matrizTransicao[56][0] = "q47";  //<q0> ::= :<q47>
        matrizTransicao[56][4] = "q46";  //<q4> ::= :<q46>
        matrizTransicao[56][46] = "q46";  //<q46> ::= :<q46>
        matrizTransicao[56][63] = "q64";  //<q63> ::= :<q64>
        matrizTransicao[56][64] = "q64";  //<q64> ::= :<q64>
        matrizTransicao[57][0] = "q1";  //<q0> ::= =<q1>
        matrizTransicao[57][4] = "q46";  //<q4> ::= =<q46>
        matrizTransicao[57][46] = "q46";  //<q46> ::= =<q46>
        matrizTransicao[57][47] = "q1";  //<q47> ::= =<q1>
        matrizTransicao[57][48] = "q1";  //<q48> ::= =<q1>
        matrizTransicao[57][63] = "q64";  //<q63> ::= =<q64>
        matrizTransicao[57][64] = "q64";  //<q64> ::= =<q64>
        matrizTransicao[58][0] = "q1";  //<q0> ::= +<q1>
        matrizTransicao[58][4] = "q46";  //<q4> ::= +<q46>
        matrizTransicao[58][46] = "q46";  //<q46> ::= +<q46>
        matrizTransicao[58][63] = "q64";  //<q63> ::= +<q64>
        matrizTransicao[58][64] = "q64";  //<q64> ::= +<q64>
        matrizTransicao[59][0] = "q1";  //<q0> ::= -<q1>
        matrizTransicao[59][4] = "q46";  //<q4> ::= -<q46>
        matrizTransicao[59][46] = "q46";  //<q46> ::= -<q46>
        matrizTransicao[59][63] = "q64";  //<q63> ::= -<q64>
        matrizTransicao[59][64] = "q64";  //<q64> ::= -<q64>
        matrizTransicao[60][0] = "q1";  //<q0> ::= *<q1>
        matrizTransicao[60][4] = "q46";  //<q4> ::= *<q46>
        matrizTransicao[60][46] = "q46";  //<q46> ::= *<q46>
        matrizTransicao[60][62] = "q63";  //<q62> ::= *<q63>
        matrizTransicao[60][64] = "q65";  //<q64> ::= *<q65>
        matrizTransicao[61][0] = "q1";  //<q0> ::= /<q1>
        matrizTransicao[61][4] = "q46";  //<q4> ::= /<q46>
        matrizTransicao[61][46] = "q46";  //<q46> ::= /<q46>
        matrizTransicao[61][63] = "q64";  //<q63> ::= /<q64>
        matrizTransicao[61][64] = "q64";  //<q64> ::= /<q64>
        matrizTransicao[62][0] = "q48";  //<q0> ::= <<q48>
        matrizTransicao[62][4] = "q46";  //<q4> ::= <<q46>
        matrizTransicao[62][46] = "q46";  //<q46> ::= <<q46>
        matrizTransicao[62][63] = "q64";  //<q63> ::= <<q64>
        matrizTransicao[62][64] = "q64";  //<q64> ::= <<q64>
        matrizTransicao[63][0] = "q47";  //<q0> ::= ><q47>
        matrizTransicao[63][4] = "q46";  //<q4> ::= ><q46>
        matrizTransicao[63][46] = "q46";  //<q46> ::= ><q46>
        matrizTransicao[63][48] = "q1";  //<q48> ::= ><q1>
        matrizTransicao[63][63] = "q64";  //<q63> ::= ><q64>
        matrizTransicao[63][64] = "q64";  //<q64> ::= ><q64>
        matrizTransicao[64][0] = "q4";  //<q0> ::= "<q4>
        matrizTransicao[64][46] = "q1";  //<q46> ::= "<q1>
        matrizTransicao[65][0] = "q11";  //<q0> ::= V<q11>
        matrizTransicao[65][2] = "q2";  //<q2> ::= V<q2>
        matrizTransicao[65][4] = "q46";  //<q4> ::= V<q46>
        matrizTransicao[65][46] = "q46";  //<q46> ::= V<q46>
        matrizTransicao[65][63] = "q64";  //<q63> ::= V<q64>
        matrizTransicao[65][64] = "q64";  //<q64> ::= V<q64>
        matrizTransicao[66][0] = "q18";  //<q0> ::= B<q18>
        matrizTransicao[66][2] = "q2";  //<q2> ::= B<q2>
        matrizTransicao[66][4] = "q46";  //<q4> ::= B<q46>
        matrizTransicao[66][46] = "q46";  //<q46> ::= B<q46>
        matrizTransicao[66][63] = "q64";  //<q63> ::= B<q64>
        matrizTransicao[66][64] = "q64";  //<q64> ::= B<q64>
        matrizTransicao[67][0] = "q45";  //<q0> ::= F<q45>
        matrizTransicao[67][2] = "q2";  //<q2> ::= F<q2>
        matrizTransicao[67][4] = "q46";  //<q4> ::= F<q46>
        matrizTransicao[67][46] = "q46";  //<q46> ::= F<q46>
        matrizTransicao[67][52] = "q1";  //<q52> ::= F<q1>
        matrizTransicao[67][53] = "q1";  //<q53> ::= F<q1>
        matrizTransicao[67][63] = "q64";  //<q63> ::= F<q64>
        matrizTransicao[67][64] = "q64";  //<q64> ::= F<q64>
        matrizTransicao[68][0] = "q49";  //<q0> ::= P<q49>
        matrizTransicao[68][2] = "q2";  //<q2> ::= P<q2>
        matrizTransicao[68][4] = "q46";  //<q4> ::= P<q46>
        matrizTransicao[68][46] = "q46";  //<q46> ::= P<q46>
        matrizTransicao[68][59] = "q32";  //<q59> ::= P<q32>
        matrizTransicao[68][63] = "q64";  //<q63> ::= P<q64>
        matrizTransicao[68][64] = "q64";  //<q64> ::= P<q64>
        matrizTransicao[69][0] = "q50";  //<q0> ::= C<q50>
        matrizTransicao[69][2] = "q2";  //<q2> ::= C<q2>
        matrizTransicao[69][4] = "q46";  //<q4> ::= C<q46>
        matrizTransicao[69][46] = "q46";  //<q46> ::= C<q46>
        matrizTransicao[69][60] = "q13";  //<q60> ::= C<q13>
        matrizTransicao[69][63] = "q64";  //<q63> ::= C<q64>
        matrizTransicao[69][64] = "q64";  //<q64> ::= C<q64>
        matrizTransicao[70][0] = "q53";  //<q0> ::= O<q53>
        matrizTransicao[70][2] = "q2";  //<q2> ::= O<q2>
        matrizTransicao[70][4] = "q46";  //<q4> ::= O<q46>
        matrizTransicao[70][31] = "q1";  //<q31> ::= O<q1>
        matrizTransicao[70][44] = "q10";  //<q44> ::= O<q10>
        matrizTransicao[70][45] = "q12";  //<q45> ::= O<q12>
        matrizTransicao[70][46] = "q46";  //<q46> ::= O<q46>
        matrizTransicao[70][50] = "q8";  //<q50> ::= O<q8>
        matrizTransicao[70][54] = "q1";  //<q54> ::= O<q1>
        matrizTransicao[70][57] = "q60";  //<q57> ::= O<q60>
        matrizTransicao[70][63] = "q64";  //<q63> ::= O<q64>
        matrizTransicao[70][64] = "q64";  //<q64> ::= O<q64>
        matrizTransicao[71][0] = "q55";  //<q0> ::= W<q55>
        matrizTransicao[71][2] = "q2";  //<q2> ::= W<q2>
        matrizTransicao[71][4] = "q46";  //<q4> ::= W<q46>
        matrizTransicao[71][46] = "q46";  //<q46> ::= W<q46>
        matrizTransicao[71][63] = "q64";  //<q63> ::= W<q64>
        matrizTransicao[71][64] = "q64";  //<q64> ::= W<q64>
        matrizTransicao[72][2] = "q2";  //<q2> ::= L<q2>
        matrizTransicao[72][4] = "q46";  //<q4> ::= L<q46>
        matrizTransicao[72][26] = "q1";  //<q26> ::= L<q1>
        matrizTransicao[72][30] = "q17";  //<q30> ::= L<q17>
        matrizTransicao[72][38] = "q20";  //<q38> ::= L<q20>
        matrizTransicao[72][46] = "q46";  //<q46> ::= L<q46>
        matrizTransicao[72][51] = "q28";  //<q51> ::= L<q28>
        matrizTransicao[72][58] = "q26";  //<q58> ::= L<q26>
        matrizTransicao[72][63] = "q64";  //<q63> ::= L<q64>
        matrizTransicao[72][64] = "q64";  //<q64> ::= L<q64>
        matrizTransicao[73][2] = "q2";  //<q2> ::= H<q2>
        matrizTransicao[73][4] = "q46";  //<q4> ::= H<q46>
        matrizTransicao[73][46] = "q46";  //<q46> ::= H<q46>
        matrizTransicao[73][54] = "q27";  //<q54> ::= H<q27>
        matrizTransicao[73][55] = "q29";  //<q55> ::= H<q29>
        matrizTransicao[73][63] = "q64";  //<q63> ::= H<q64>
        matrizTransicao[73][64] = "q64";  //<q64> ::= H<q64>
        matrizTransicao[74][2] = "q2";  //<q2> ::= M<q2>
        matrizTransicao[74][4] = "q46";  //<q4> ::= M<q46>
        matrizTransicao[74][7] = "q1";  //<q7> ::= M<q1>
        matrizTransicao[74][46] = "q46";  //<q46> ::= M<q46>
        matrizTransicao[74][63] = "q64";  //<q63> ::= M<q64>
        matrizTransicao[74][64] = "q64";  //<q64> ::= M<q64>
        matrizTransicao[75][46] = "q46";  //<q46> ::= &<q46>
        matrizTransicao[75][63] = "q64";  //<q63> ::= &<q64>
        matrizTransicao[75][64] = "q64";  //<q64> ::= &<q64>
        matrizTransicao[76][4] = "q46";  //<q4> ::= [<q46>
        matrizTransicao[76][46] = "q46";  //<q46> ::= [<q46>
        matrizTransicao[76][63] = "q64";  //<q63> ::= [<q64>
        matrizTransicao[76][64] = "q64";  //<q64> ::= [<q64>
        matrizTransicao[77][4] = "q46";  //<q4> ::= ?<q46>
        matrizTransicao[77][46] = "q46";  //<q46> ::= ?<q46>
        matrizTransicao[77][63] = "q64";  //<q63> ::= ?<q64>
        matrizTransicao[77][64] = "q64";  //<q64> ::= ?<q64>
        matrizTransicao[78][4] = "q46";  //<q4> ::= {<q46>
        matrizTransicao[78][46] = "q46";  //<q46> ::= {<q46>
        matrizTransicao[78][63] = "q64";  //<q63> ::= {<q64>
        matrizTransicao[78][64] = "q64";  //<q64> ::= {<q64>
        matrizTransicao[79][4] = "q46";  //<q4> ::= }<q46>
        matrizTransicao[79][46] = "q46";  //<q46> ::= }<q46>
        matrizTransicao[79][63] = "q64";  //<q63> ::= }<q64>
        matrizTransicao[79][64] = "q64";  //<q64> ::= }<q64>
        matrizTransicao[80][4] = "q46";  //<q4> ::= ]<q46>
        matrizTransicao[80][46] = "q46";  //<q46> ::= ]<q46>
        matrizTransicao[80][63] = "q64";  //<q63> ::= ]<q64>
        matrizTransicao[80][64] = "q64";  //<q64> ::= ]<q64>
        matrizTransicao[81][4] = "q46";  //<q4> ::= ´<q46>
        matrizTransicao[81][46] = "q46";  //<q46> ::= ´<q46>
        matrizTransicao[81][63] = "q64";  //<q63> ::= ´<q64>
        matrizTransicao[81][64] = "q64";  //<q64> ::= ´<q64>
        matrizTransicao[82][4] = "q46";  //<q4> ::= ~<q46>
        matrizTransicao[82][46] = "q46";  //<q46> ::= ~<q46>
        matrizTransicao[82][63] = "q64";  //<q63> ::= ~<q64>
        matrizTransicao[82][64] = "q64";  //<q64> ::= ~<q64>
        matrizTransicao[83][4] = "q46";  //<q4> ::= `<q46>
        matrizTransicao[83][46] = "q46";  //<q46> ::= `<q46>
        matrizTransicao[83][63] = "q64";  //<q63> ::= `<q64>
        matrizTransicao[83][64] = "q64";  //<q64> ::= `<q64>
        matrizTransicao[84][4] = "q46";  //<q4> ::= ^<q46>
        matrizTransicao[84][46] = "q46";  //<q46> ::= ^<q46>
        matrizTransicao[84][63] = "q64";  //<q63> ::= ^<q64>
        matrizTransicao[84][64] = "q64";  //<q64> ::= ^<q64>
        matrizTransicao[85][46] = "q46";  //<q46> ::= |<q46>
        matrizTransicao[85][63] = "q64";  //<q63> ::= |<q64>
        matrizTransicao[85][64] = "q64";  //<q64> ::= |<q64>
        matrizTransicao[86][46] = "q46";  //<q46> ::= \<q46>
        matrizTransicao[86][63] = "q64";  //<q63> ::= \<q64>
        matrizTransicao[86][64] = "q64";  //<q64> ::= \<q64>
        matrizTransicao[87][4] = "q46";  //<q4> ::= _<q46>
        matrizTransicao[87][46] = "q46";  //<q46> ::= _<q46>
        matrizTransicao[87][63] = "q64";  //<q63> ::= _<q64>
        matrizTransicao[87][64] = "q64";  //<q64> ::= _<q64>
        matrizTransicao[88][2] = "q2";  //<q2> ::= J<q2>
        matrizTransicao[88][4] = "q46";  //<q4> ::= J<q46>
        matrizTransicao[88][46] = "q46";  //<q46> ::= J<q46>
        matrizTransicao[88][63] = "q64";  //<q63> ::= J<q64>
        matrizTransicao[88][64] = "q64";  //<q64> ::= J<q64>
        matrizTransicao[89][2] = "q2";  //<q2> ::= K<q2>
        matrizTransicao[89][4] = "q46";  //<q4> ::= K<q46>
        matrizTransicao[89][46] = "q46";  //<q46> ::= K<q46>
        matrizTransicao[89][63] = "q64";  //<q63> ::= K<q64>
        matrizTransicao[89][64] = "q64";  //<q64> ::= K<q64>
        matrizTransicao[90][2] = "q2";  //<q2> ::= Q<q2>
        matrizTransicao[90][4] = "q46";  //<q4> ::= Q<q46>
        matrizTransicao[90][46] = "q46";  //<q46> ::= Q<q46>
        matrizTransicao[90][63] = "q64";  //<q63> ::= Q<q64>
        matrizTransicao[90][64] = "q64";  //<q64> ::= Q<q64>
        matrizTransicao[91][2] = "q2";  //<q2> ::= X<q2>
        matrizTransicao[91][4] = "q46";  //<q4> ::= X<q46>
        matrizTransicao[91][46] = "q46";  //<q46> ::= X<q46>
        matrizTransicao[91][63] = "q64";  //<q63> ::= X<q64>
        matrizTransicao[91][64] = "q64";  //<q64> ::= X<q64>
        matrizTransicao[92][2] = "q2";  //<q2> ::= Y<q2>
        matrizTransicao[92][4] = "q46";  //<q4> ::= Y<q46>
        matrizTransicao[92][46] = "q46";  //<q46> ::= Y<q46>
        matrizTransicao[92][63] = "q64";  //<q63> ::= Y<q64>
        matrizTransicao[92][64] = "q64";  //<q64> ::= Y<q64>
        matrizTransicao[93][2] = "q2";  //<q2> ::= Z<q2>
        matrizTransicao[93][4] = "q46";  //<q4> ::= Z<q46>
        matrizTransicao[93][46] = "q46";  //<q46> ::= Z<q46>
        matrizTransicao[93][63] = "q64";  //<q63> ::= Z<q64>
        matrizTransicao[93][64] = "q64";  //<q64> ::= Z<q64>
        matrizTransicao[94][4] = "q46";  //<q4> ::=  <q46>
        matrizTransicao[94][46] = "q46";  //<q46> ::=  <q46>
        matrizTransicao[94][63] = "q64";  //<q63> ::=  <q64>
        matrizTransicao[94][64] = "q64";  //<q64> ::=  <q64>
        matrizTransicao[95][63] = "q64";  //<q63> ::= §<q64>
        matrizTransicao[95][64] = "q64";  //<q64> ::= §<q64>

        simbolosEspeciais.put("$", "01 - Fim arquivo");
        simbolosEspeciais.put("+", "02 - Sinal de adição");
        simbolosEspeciais.put("-" ,"03 - Sinal de subtração");
        simbolosEspeciais.put("*", "04 - Sinal de multiplicação");
        simbolosEspeciais.put("/", "05 - Sinal de divisão");
        simbolosEspeciais.put("=", "06 - Sinal de igual");
        simbolosEspeciais.put(">", "07 - Sinal de maior");
        simbolosEspeciais.put(">=", "08 - Sinal de maior ou igual");
        simbolosEspeciais.put("<", "09 - Sinal de menor");
        simbolosEspeciais.put("<=", "10 - Sinal de menor ou igual");
        simbolosEspeciais.put("<>", "11 - Sinal de diferente");
        simbolosEspeciais.put(":=", "12 - Sinal de atribuição");
        simbolosEspeciais.put(":", "13 - Dois pontos");
        simbolosEspeciais.put(";", "14 - Ponto e vírgula");
        simbolosEspeciais.put(",", "15 - Vírgula");
        simbolosEspeciais.put(".", "16 - Ponto");
        simbolosEspeciais.put("(", "17 - Abrepar");
        simbolosEspeciais.put(")", "18 - Fechapar");

        palavrasReservadas.put("¬ID¬", "19 - Identificador");
        palavrasReservadas.put("¬INTEIRO¬", "20 - Número inteiro");
        palavrasReservadas.put("¬LIT¬", "21 - Literal");
        palavrasReservadas.put("PROGRAM", "22 - Palavra reservada");
        palavrasReservadas.put("CONST", "23 - Palavra reservada");
        palavrasReservadas.put("VAR", "24 - Palavra reservada");
        palavrasReservadas.put("PROCEDURE", "25 - Palavra reservada");
        palavrasReservadas.put("BEGIN", "26 - Palavra reservada");
        palavrasReservadas.put("END", "27 - Palavra reservada");
        palavrasReservadas.put("INTEGER", "28 - Palavra reservada");
        palavrasReservadas.put("OF", "29 - Palavra reservada");
        palavrasReservadas.put("CALL", "30 - Palavra reservada");
        palavrasReservadas.put("IF", "31 - Palavra reservada");
        palavrasReservadas.put("THEN", "32 - Palavra reservada");
        palavrasReservadas.put("ELSE", "33 - Palavra reservada");
        palavrasReservadas.put("WHILE", "34 - Palavra reservada");
        palavrasReservadas.put("DO", "35 - Palavra reservada");
        palavrasReservadas.put("REPEAT", "36 - Palavra reservada");
        palavrasReservadas.put("UNTIL", "37 - Palavra reservada");
        palavrasReservadas.put("READLN", "38 - Palavra reservada");
        palavrasReservadas.put("WRITELN", "39 - Palavra reservada");
        palavrasReservadas.put("OR", "40 - Palavra reservada");
        palavrasReservadas.put("AND", "41 - Palavra reservada");
        palavrasReservadas.put("NOT", "42 - Palavra reservada");
        palavrasReservadas.put("FOR", "43 - Palavra reservada");
        palavrasReservadas.put("TO", "44 - Palavra reservada");
        palavrasReservadas.put("CASE", "45 - Palavra reservada");
    }

    public static String pegaProximoEstado(char c, String estadoAtual) throws NullPointerException {
        int entrada = alfabeto.indexOf(String.valueOf(c));
        int indexEstadoAtual = estados.indexOf(estadoAtual);

        String proximoEstado = matrizTransicao[entrada][indexEstadoAtual];

        if (proximoEstado == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return proximoEstado;
    }

    public static String pegaCodigoDescricao(String palavra) {
        String descicao = palavrasReservadas.get(palavra);
        if (descicao == null) {
            if (palavra.startsWith("\"")) {
                if (palavra.length() > 257) {
                    throw new IllegalArgumentException("Limite de caracteres em literais excedido!");
                }
                return palavrasReservadas.get("¬LIT¬");
            } else if (palavra.startsWith("(*")) {
              return "Comentário";
            } else {
                descicao = simbolosEspeciais.get(palavra);
                if (descicao != null)
                    return descicao;
                try {
                    double num = Double.valueOf(palavra);
                    if (Math.abs(num) > 32767)
                        throw new IllegalArgumentException("Valor fora da escala!");
                    else if (num % 1 != 0)
                        throw new IllegalArgumentException("Não aceita ponto decimal!");
                    return palavrasReservadas.get("¬INTEIRO¬");
                } catch (NumberFormatException e) {
                    if (palavra.length() > 30)
                        throw new IllegalArgumentException("Máximo de caracteres para identificadores excedido!");
                    return palavrasReservadas.get("¬ID¬");
                }
            }
        }
        return descicao;
    }
}

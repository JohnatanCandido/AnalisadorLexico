import java.util.*;

public class Util {

    private static final List<String> alfabeto = Arrays.asList(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "@", "#", "$",
            "%", "(", ")", ",", ";", ".", ":", "=", "+", "-", "*", "/", "<", ">", "\"", "&", "[", "?", "{", "}",
            "]", "´", "~", "`", "^", "|", "\\", "_", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " ", "§");

    private static final List<String> estados = Arrays.asList("q0", "q1", "q2", "q3", "q4", "q46", "q47", "q48", "q62", "q63", "q64", "q65");

    public static final List<String> estadosReconhecedores = Arrays.asList("q1", "q2", "q3", "q48", "q47", "q62");
    private static String[][] matrizTransicao = new String[alfabeto.size()][estados.size()];
    public static Map<String, Integer> palavrasReservadas = new HashMap<>();
    public static Map<String, Integer> simbolosEspeciais = new HashMap<>();

    static {
        for (int i = 0; i < alfabeto.size(); i++)
            for (int j = 0; j < estados.size(); j++)
                matrizTransicao[i][j] = null;

        matrizTransicao[0][0] = "q2";  //<q0> ::= a<q2>
        matrizTransicao[0][2] = "q2";  //<q2> ::= a<q2>
        matrizTransicao[0][4] = "q46";  //<q4> ::= a<q46>
        matrizTransicao[0][5] = "q46";  //<q46> ::= a<q46>
        matrizTransicao[0][9] = "q64";  //<q63> ::= a<q64>
        matrizTransicao[0][10] = "q64";  //<q64> ::= a<q64>
        matrizTransicao[1][0] = "q2";  //<q0> ::= b<q2>
        matrizTransicao[1][2] = "q2";  //<q2> ::= b<q2>
        matrizTransicao[1][4] = "q46";  //<q4> ::= b<q46>
        matrizTransicao[1][5] = "q46";  //<q46> ::= b<q46>
        matrizTransicao[1][9] = "q64";  //<q63> ::= b<q64>
        matrizTransicao[1][10] = "q64";  //<q64> ::= b<q64>
        matrizTransicao[2][0] = "q2";  //<q0> ::= c<q2>
        matrizTransicao[2][2] = "q2";  //<q2> ::= c<q2>
        matrizTransicao[2][4] = "q46";  //<q4> ::= c<q46>
        matrizTransicao[2][5] = "q46";  //<q46> ::= c<q46>
        matrizTransicao[2][9] = "q64";  //<q63> ::= c<q64>
        matrizTransicao[2][10] = "q64";  //<q64> ::= c<q64>
        matrizTransicao[3][0] = "q2";  //<q0> ::= d<q2>
        matrizTransicao[3][2] = "q2";  //<q2> ::= d<q2>
        matrizTransicao[3][4] = "q46";  //<q4> ::= d<q46>
        matrizTransicao[3][5] = "q46";  //<q46> ::= d<q46>
        matrizTransicao[3][9] = "q64";  //<q63> ::= d<q64>
        matrizTransicao[3][10] = "q64";  //<q64> ::= d<q64>
        matrizTransicao[4][0] = "q2";  //<q0> ::= e<q2>
        matrizTransicao[4][2] = "q2";  //<q2> ::= e<q2>
        matrizTransicao[4][4] = "q46";  //<q4> ::= e<q46>
        matrizTransicao[4][5] = "q46";  //<q46> ::= e<q46>
        matrizTransicao[4][9] = "q64";  //<q63> ::= e<q64>
        matrizTransicao[4][10] = "q64";  //<q64> ::= e<q64>
        matrizTransicao[5][0] = "q2";  //<q0> ::= f<q2>
        matrizTransicao[5][2] = "q2";  //<q2> ::= f<q2>
        matrizTransicao[5][4] = "q46";  //<q4> ::= f<q46>
        matrizTransicao[5][5] = "q46";  //<q46> ::= f<q46>
        matrizTransicao[5][9] = "q64";  //<q63> ::= f<q64>
        matrizTransicao[5][10] = "q64";  //<q64> ::= f<q64>
        matrizTransicao[6][0] = "q2";  //<q0> ::= g<q2>
        matrizTransicao[6][2] = "q2";  //<q2> ::= g<q2>
        matrizTransicao[6][4] = "q46";  //<q4> ::= g<q46>
        matrizTransicao[6][5] = "q46";  //<q46> ::= g<q46>
        matrizTransicao[6][9] = "q64";  //<q63> ::= g<q64>
        matrizTransicao[6][10] = "q64";  //<q64> ::= g<q64>
        matrizTransicao[7][0] = "q2";  //<q0> ::= h<q2>
        matrizTransicao[7][2] = "q2";  //<q2> ::= h<q2>
        matrizTransicao[7][4] = "q46";  //<q4> ::= h<q46>
        matrizTransicao[7][5] = "q46";  //<q46> ::= h<q46>
        matrizTransicao[7][9] = "q64";  //<q63> ::= h<q64>
        matrizTransicao[7][10] = "q64";  //<q64> ::= h<q64>
        matrizTransicao[8][0] = "q2";  //<q0> ::= i<q2>
        matrizTransicao[8][2] = "q2";  //<q2> ::= i<q2>
        matrizTransicao[8][4] = "q46";  //<q4> ::= i<q46>
        matrizTransicao[8][5] = "q46";  //<q46> ::= i<q46>
        matrizTransicao[8][9] = "q64";  //<q63> ::= i<q64>
        matrizTransicao[8][10] = "q64";  //<q64> ::= i<q64>
        matrizTransicao[9][0] = "q2";  //<q0> ::= j<q2>
        matrizTransicao[9][2] = "q2";  //<q2> ::= j<q2>
        matrizTransicao[9][4] = "q46";  //<q4> ::= j<q46>
        matrizTransicao[9][5] = "q46";  //<q46> ::= j<q46>
        matrizTransicao[9][9] = "q64";  //<q63> ::= j<q64>
        matrizTransicao[9][10] = "q64";  //<q64> ::= j<q64>
        matrizTransicao[10][0] = "q2";  //<q0> ::= k<q2>
        matrizTransicao[10][2] = "q2";  //<q2> ::= k<q2>
        matrizTransicao[10][4] = "q46";  //<q4> ::= k<q46>
        matrizTransicao[10][5] = "q46";  //<q46> ::= k<q46>
        matrizTransicao[10][9] = "q64";  //<q63> ::= k<q64>
        matrizTransicao[10][10] = "q64";  //<q64> ::= k<q64>
        matrizTransicao[11][0] = "q2";  //<q0> ::= l<q2>
        matrizTransicao[11][2] = "q2";  //<q2> ::= l<q2>
        matrizTransicao[11][4] = "q46";  //<q4> ::= l<q46>
        matrizTransicao[11][5] = "q46";  //<q46> ::= l<q46>
        matrizTransicao[11][9] = "q64";  //<q63> ::= l<q64>
        matrizTransicao[11][10] = "q64";  //<q64> ::= l<q64>
        matrizTransicao[12][0] = "q2";  //<q0> ::= m<q2>
        matrizTransicao[12][2] = "q2";  //<q2> ::= m<q2>
        matrizTransicao[12][4] = "q46";  //<q4> ::= m<q46>
        matrizTransicao[12][5] = "q46";  //<q46> ::= m<q46>
        matrizTransicao[12][9] = "q64";  //<q63> ::= m<q64>
        matrizTransicao[12][10] = "q64";  //<q64> ::= m<q64>
        matrizTransicao[13][0] = "q2";  //<q0> ::= n<q2>
        matrizTransicao[13][2] = "q2";  //<q2> ::= n<q2>
        matrizTransicao[13][4] = "q46";  //<q4> ::= n<q46>
        matrizTransicao[13][5] = "q46";  //<q46> ::= n<q46>
        matrizTransicao[13][9] = "q64";  //<q63> ::= n<q64>
        matrizTransicao[13][10] = "q64";  //<q64> ::= n<q64>
        matrizTransicao[14][0] = "q2";  //<q0> ::= o<q2>
        matrizTransicao[14][2] = "q2";  //<q2> ::= o<q2>
        matrizTransicao[14][4] = "q46";  //<q4> ::= o<q46>
        matrizTransicao[14][5] = "q46";  //<q46> ::= o<q46>
        matrizTransicao[14][9] = "q64";  //<q63> ::= o<q64>
        matrizTransicao[14][10] = "q64";  //<q64> ::= o<q64>
        matrizTransicao[15][0] = "q2";  //<q0> ::= p<q2>
        matrizTransicao[15][2] = "q2";  //<q2> ::= p<q2>
        matrizTransicao[15][4] = "q46";  //<q4> ::= p<q46>
        matrizTransicao[15][5] = "q46";  //<q46> ::= p<q46>
        matrizTransicao[15][9] = "q64";  //<q63> ::= p<q64>
        matrizTransicao[15][10] = "q64";  //<q64> ::= p<q64>
        matrizTransicao[16][0] = "q2";  //<q0> ::= q<q2>
        matrizTransicao[16][2] = "q2";  //<q2> ::= q<q2>
        matrizTransicao[16][4] = "q46";  //<q4> ::= q<q46>
        matrizTransicao[16][5] = "q46";  //<q46> ::= q<q46>
        matrizTransicao[16][9] = "q64";  //<q63> ::= q<q64>
        matrizTransicao[16][10] = "q64";  //<q64> ::= q<q64>
        matrizTransicao[17][0] = "q2";  //<q0> ::= r<q2>
        matrizTransicao[17][2] = "q2";  //<q2> ::= r<q2>
        matrizTransicao[17][4] = "q46";  //<q4> ::= r<q46>
        matrizTransicao[17][5] = "q46";  //<q46> ::= r<q46>
        matrizTransicao[17][9] = "q64";  //<q63> ::= r<q64>
        matrizTransicao[17][10] = "q64";  //<q64> ::= r<q64>
        matrizTransicao[18][0] = "q2";  //<q0> ::= s<q2>
        matrizTransicao[18][2] = "q2";  //<q2> ::= s<q2>
        matrizTransicao[18][4] = "q46";  //<q4> ::= s<q46>
        matrizTransicao[18][5] = "q46";  //<q46> ::= s<q46>
        matrizTransicao[18][9] = "q64";  //<q63> ::= s<q64>
        matrizTransicao[18][10] = "q64";  //<q64> ::= s<q64>
        matrizTransicao[19][0] = "q2";  //<q0> ::= t<q2>
        matrizTransicao[19][2] = "q2";  //<q2> ::= t<q2>
        matrizTransicao[19][4] = "q46";  //<q4> ::= t<q46>
        matrizTransicao[19][5] = "q46";  //<q46> ::= t<q46>
        matrizTransicao[19][9] = "q64";  //<q63> ::= t<q64>
        matrizTransicao[19][10] = "q64";  //<q64> ::= t<q64>
        matrizTransicao[20][0] = "q2";  //<q0> ::= u<q2>
        matrizTransicao[20][2] = "q2";  //<q2> ::= u<q2>
        matrizTransicao[20][4] = "q46";  //<q4> ::= u<q46>
        matrizTransicao[20][5] = "q46";  //<q46> ::= u<q46>
        matrizTransicao[20][9] = "q64";  //<q63> ::= u<q64>
        matrizTransicao[20][10] = "q64";  //<q64> ::= u<q64>
        matrizTransicao[21][0] = "q2";  //<q0> ::= v<q2>
        matrizTransicao[21][2] = "q2";  //<q2> ::= v<q2>
        matrizTransicao[21][4] = "q46";  //<q4> ::= v<q46>
        matrizTransicao[21][5] = "q46";  //<q46> ::= v<q46>
        matrizTransicao[21][9] = "q64";  //<q63> ::= v<q64>
        matrizTransicao[21][10] = "q64";  //<q64> ::= v<q64>
        matrizTransicao[22][0] = "q2";  //<q0> ::= w<q2>
        matrizTransicao[22][2] = "q2";  //<q2> ::= w<q2>
        matrizTransicao[22][4] = "q46";  //<q4> ::= w<q46>
        matrizTransicao[22][5] = "q46";  //<q46> ::= w<q46>
        matrizTransicao[22][9] = "q64";  //<q63> ::= w<q64>
        matrizTransicao[22][10] = "q64";  //<q64> ::= w<q64>
        matrizTransicao[23][0] = "q2";  //<q0> ::= x<q2>
        matrizTransicao[23][2] = "q2";  //<q2> ::= x<q2>
        matrizTransicao[23][4] = "q46";  //<q4> ::= x<q46>
        matrizTransicao[23][5] = "q46";  //<q46> ::= x<q46>
        matrizTransicao[23][9] = "q64";  //<q63> ::= x<q64>
        matrizTransicao[23][10] = "q64";  //<q64> ::= x<q64>
        matrizTransicao[24][0] = "q2";  //<q0> ::= y<q2>
        matrizTransicao[24][2] = "q2";  //<q2> ::= y<q2>
        matrizTransicao[24][4] = "q46";  //<q4> ::= y<q46>
        matrizTransicao[24][5] = "q46";  //<q46> ::= y<q46>
        matrizTransicao[24][9] = "q64";  //<q63> ::= y<q64>
        matrizTransicao[24][10] = "q64";  //<q64> ::= y<q64>
        matrizTransicao[25][0] = "q2";  //<q0> ::= z<q2>
        matrizTransicao[25][2] = "q2";  //<q2> ::= z<q2>
        matrizTransicao[25][4] = "q46";  //<q4> ::= z<q46>
        matrizTransicao[25][5] = "q46";  //<q46> ::= z<q46>
        matrizTransicao[25][9] = "q64";  //<q63> ::= z<q64>
        matrizTransicao[25][10] = "q64";  //<q64> ::= z<q64>
        matrizTransicao[26][0] = "q3";  //<q0> ::= 0<q3>
        matrizTransicao[26][2] = "q2";  //<q2> ::= 0<q2>
        matrizTransicao[26][3] = "q3";  //<q3> ::= 0<q3>
        matrizTransicao[26][4] = "q46";  //<q4> ::= 0<q46>
        matrizTransicao[26][5] = "q46";  //<q46> ::= 0<q46>
        matrizTransicao[26][9] = "q64";  //<q63> ::= 0<q64>
        matrizTransicao[26][10] = "q64";  //<q64> ::= 0<q64>
        matrizTransicao[27][0] = "q3";  //<q0> ::= 1<q3>
        matrizTransicao[27][2] = "q2";  //<q2> ::= 1<q2>
        matrizTransicao[27][3] = "q3";  //<q3> ::= 1<q3>
        matrizTransicao[27][4] = "q46";  //<q4> ::= 1<q46>
        matrizTransicao[27][5] = "q46";  //<q46> ::= 1<q46>
        matrizTransicao[27][9] = "q64";  //<q63> ::= 1<q64>
        matrizTransicao[27][10] = "q64";  //<q64> ::= 1<q64>
        matrizTransicao[28][0] = "q3";  //<q0> ::= 2<q3>
        matrizTransicao[28][2] = "q2";  //<q2> ::= 2<q2>
        matrizTransicao[28][3] = "q3";  //<q3> ::= 2<q3>
        matrizTransicao[28][4] = "q46";  //<q4> ::= 2<q46>
        matrizTransicao[28][5] = "q46";  //<q46> ::= 2<q46>
        matrizTransicao[28][9] = "q64";  //<q63> ::= 2<q64>
        matrizTransicao[28][10] = "q64";  //<q64> ::= 2<q64>
        matrizTransicao[29][0] = "q3";  //<q0> ::= 3<q3>
        matrizTransicao[29][2] = "q2";  //<q2> ::= 3<q2>
        matrizTransicao[29][3] = "q3";  //<q3> ::= 3<q3>
        matrizTransicao[29][4] = "q46";  //<q4> ::= 3<q46>
        matrizTransicao[29][5] = "q46";  //<q46> ::= 3<q46>
        matrizTransicao[29][9] = "q64";  //<q63> ::= 3<q64>
        matrizTransicao[29][10] = "q64";  //<q64> ::= 3<q64>
        matrizTransicao[30][0] = "q3";  //<q0> ::= 4<q3>
        matrizTransicao[30][2] = "q2";  //<q2> ::= 4<q2>
        matrizTransicao[30][3] = "q3";  //<q3> ::= 4<q3>
        matrizTransicao[30][4] = "q46";  //<q4> ::= 4<q46>
        matrizTransicao[30][5] = "q46";  //<q46> ::= 4<q46>
        matrizTransicao[30][9] = "q64";  //<q63> ::= 4<q64>
        matrizTransicao[30][10] = "q64";  //<q64> ::= 4<q64>
        matrizTransicao[31][0] = "q3";  //<q0> ::= 5<q3>
        matrizTransicao[31][2] = "q2";  //<q2> ::= 5<q2>
        matrizTransicao[31][3] = "q3";  //<q3> ::= 5<q3>
        matrizTransicao[31][4] = "q46";  //<q4> ::= 5<q46>
        matrizTransicao[31][5] = "q46";  //<q46> ::= 5<q46>
        matrizTransicao[31][9] = "q64";  //<q63> ::= 5<q64>
        matrizTransicao[31][10] = "q64";  //<q64> ::= 5<q64>
        matrizTransicao[32][0] = "q3";  //<q0> ::= 6<q3>
        matrizTransicao[32][2] = "q2";  //<q2> ::= 6<q2>
        matrizTransicao[32][3] = "q3";  //<q3> ::= 6<q3>
        matrizTransicao[32][4] = "q46";  //<q4> ::= 6<q46>
        matrizTransicao[32][5] = "q46";  //<q46> ::= 6<q46>
        matrizTransicao[32][9] = "q64";  //<q63> ::= 6<q64>
        matrizTransicao[32][10] = "q64";  //<q64> ::= 6<q64>
        matrizTransicao[33][0] = "q3";  //<q0> ::= 7<q3>
        matrizTransicao[33][2] = "q2";  //<q2> ::= 7<q2>
        matrizTransicao[33][3] = "q3";  //<q3> ::= 7<q3>
        matrizTransicao[33][4] = "q46";  //<q4> ::= 7<q46>
        matrizTransicao[33][5] = "q46";  //<q46> ::= 7<q46>
        matrizTransicao[33][9] = "q64";  //<q63> ::= 7<q64>
        matrizTransicao[33][10] = "q64";  //<q64> ::= 7<q64>
        matrizTransicao[34][0] = "q3";  //<q0> ::= 8<q3>
        matrizTransicao[34][2] = "q2";  //<q2> ::= 8<q2>
        matrizTransicao[34][3] = "q3";  //<q3> ::= 8<q3>
        matrizTransicao[34][4] = "q46";  //<q4> ::= 8<q46>
        matrizTransicao[34][5] = "q46";  //<q46> ::= 8<q46>
        matrizTransicao[34][9] = "q64";  //<q63> ::= 8<q64>
        matrizTransicao[34][10] = "q64";  //<q64> ::= 8<q64>
        matrizTransicao[35][0] = "q3";  //<q0> ::= 9<q3>
        matrizTransicao[35][2] = "q2";  //<q2> ::= 9<q2>
        matrizTransicao[35][3] = "q3";  //<q3> ::= 9<q3>
        matrizTransicao[35][4] = "q46";  //<q4> ::= 9<q46>
        matrizTransicao[35][5] = "q46";  //<q46> ::= 9<q46>
        matrizTransicao[35][9] = "q64";  //<q63> ::= 9<q64>
        matrizTransicao[35][10] = "q64";  //<q64> ::= 9<q64>
        matrizTransicao[36][4] = "q46";  //<q4> ::= !<q46>
        matrizTransicao[36][5] = "q46";  //<q46> ::= !<q46>
        matrizTransicao[36][9] = "q64";  //<q63> ::= !<q64>
        matrizTransicao[36][10] = "q64";  //<q64> ::= !<q64>
        matrizTransicao[37][4] = "q46";  //<q4> ::= @<q46>
        matrizTransicao[37][5] = "q46";  //<q46> ::= @<q46>
        matrizTransicao[37][9] = "q64";  //<q63> ::= @<q64>
        matrizTransicao[37][10] = "q64";  //<q64> ::= @<q64>
        matrizTransicao[38][4] = "q46";  //<q4> ::= #<q46>
        matrizTransicao[38][5] = "q46";  //<q46> ::= #<q46>
        matrizTransicao[38][9] = "q64";  //<q63> ::= #<q64>
        matrizTransicao[38][10] = "q64";  //<q64> ::= #<q64>
        matrizTransicao[39][4] = "q46";  //<q4> ::= $<q46>
        matrizTransicao[39][5] = "q46";  //<q46> ::= $<q46>
        matrizTransicao[39][9] = "q64";  //<q63> ::= $<q64>
        matrizTransicao[39][10] = "q64";  //<q64> ::= $<q64>
        matrizTransicao[40][4] = "q46";  //<q4> ::= %<q46>
        matrizTransicao[40][5] = "q46";  //<q46> ::= %<q46>
        matrizTransicao[40][9] = "q64";  //<q63> ::= %<q64>
        matrizTransicao[40][10] = "q64";  //<q64> ::= %<q64>
        matrizTransicao[41][0] = "q62";  //<q0> ::= (<q62>
        matrizTransicao[41][4] = "q46";  //<q4> ::= (<q46>
        matrizTransicao[41][5] = "q46";  //<q46> ::= (<q46>
        matrizTransicao[41][9] = "q64";  //<q63> ::= (<q64>
        matrizTransicao[41][10] = "q64";  //<q64> ::= (<q64>
        matrizTransicao[42][0] = "q1";  //<q0> ::= )<q1>
        matrizTransicao[42][4] = "q46";  //<q4> ::= )<q46>
        matrizTransicao[42][5] = "q46";  //<q46> ::= )<q46>
        matrizTransicao[42][9] = "q64";  //<q63> ::= )<q64>
        matrizTransicao[42][10] = "q64";  //<q64> ::= )<q64>
        matrizTransicao[42][11] = "q1";  //<q65> ::= )<q1>
        matrizTransicao[43][0] = "q1";  //<q0> ::= ,<q1>
        matrizTransicao[43][4] = "q46";  //<q4> ::= ,<q46>
        matrizTransicao[43][5] = "q46";  //<q46> ::= ,<q46>
        matrizTransicao[43][9] = "q64";  //<q63> ::= ,<q64>
        matrizTransicao[43][10] = "q64";  //<q64> ::= ,<q64>
        matrizTransicao[44][0] = "q1";  //<q0> ::= ;<q1>
        matrizTransicao[44][4] = "q46";  //<q4> ::= ;<q46>
        matrizTransicao[44][5] = "q46";  //<q46> ::= ;<q46>
        matrizTransicao[44][9] = "q64";  //<q63> ::= ;<q64>
        matrizTransicao[44][10] = "q64";  //<q64> ::= ;<q64>
        matrizTransicao[45][0] = "q1";  //<q0> ::= .<q1>
        matrizTransicao[45][4] = "q46";  //<q4> ::= .<q46>
        matrizTransicao[45][5] = "q46";  //<q46> ::= .<q46>
        matrizTransicao[45][9] = "q64";  //<q63> ::= .<q64>
        matrizTransicao[45][10] = "q64";  //<q64> ::= .<q64>
        matrizTransicao[46][0] = "q47";  //<q0> ::= :<q47>
        matrizTransicao[46][4] = "q46";  //<q4> ::= :<q46>
        matrizTransicao[46][5] = "q46";  //<q46> ::= :<q46>
        matrizTransicao[46][9] = "q64";  //<q63> ::= :<q64>
        matrizTransicao[46][10] = "q64";  //<q64> ::= :<q64>
        matrizTransicao[47][0] = "q1";  //<q0> ::= =<q1>
        matrizTransicao[47][4] = "q46";  //<q4> ::= =<q46>
        matrizTransicao[47][5] = "q46";  //<q46> ::= =<q46>
        matrizTransicao[47][6] = "q1";  //<q47> ::= =<q1>
        matrizTransicao[47][7] = "q1";  //<q48> ::= =<q1>
        matrizTransicao[47][9] = "q64";  //<q63> ::= =<q64>
        matrizTransicao[47][10] = "q64";  //<q64> ::= =<q64>
        matrizTransicao[48][0] = "q1";  //<q0> ::= +<q1>
        matrizTransicao[48][4] = "q46";  //<q4> ::= +<q46>
        matrizTransicao[48][5] = "q46";  //<q46> ::= +<q46>
        matrizTransicao[48][9] = "q64";  //<q63> ::= +<q64>
        matrizTransicao[48][10] = "q64";  //<q64> ::= +<q64>
        matrizTransicao[49][0] = "q1";  //<q0> ::= -<q1>
        matrizTransicao[49][4] = "q46";  //<q4> ::= -<q46>
        matrizTransicao[49][5] = "q46";  //<q46> ::= -<q46>
        matrizTransicao[49][9] = "q64";  //<q63> ::= -<q64>
        matrizTransicao[49][10] = "q64";  //<q64> ::= -<q64>
        matrizTransicao[50][0] = "q1";  //<q0> ::= *<q1>
        matrizTransicao[50][4] = "q46";  //<q4> ::= *<q46>
        matrizTransicao[50][5] = "q46";  //<q46> ::= *<q46>
        matrizTransicao[50][8] = "q63";  //<q62> ::= *<q63>
        matrizTransicao[50][10] = "q65";  //<q64> ::= *<q65>
        matrizTransicao[51][0] = "q1";  //<q0> ::= /<q1>
        matrizTransicao[51][4] = "q46";  //<q4> ::= /<q46>
        matrizTransicao[51][5] = "q46";  //<q46> ::= /<q46>
        matrizTransicao[51][9] = "q64";  //<q63> ::= /<q64>
        matrizTransicao[51][10] = "q64";  //<q64> ::= /<q64>
        matrizTransicao[52][0] = "q48";  //<q0> ::= <<q48>
        matrizTransicao[52][4] = "q46";  //<q4> ::= <<q46>
        matrizTransicao[52][5] = "q46";  //<q46> ::= <<q46>
        matrizTransicao[52][9] = "q64";  //<q63> ::= <<q64>
        matrizTransicao[52][10] = "q64";  //<q64> ::= <<q64>
        matrizTransicao[53][0] = "q47";  //<q0> ::= ><q47>
        matrizTransicao[53][4] = "q46";  //<q4> ::= ><q46>
        matrizTransicao[53][5] = "q46";  //<q46> ::= ><q46>
        matrizTransicao[53][7] = "q1";  //<q48> ::= ><q1>
        matrizTransicao[53][9] = "q64";  //<q63> ::= ><q64>
        matrizTransicao[53][10] = "q64";  //<q64> ::= ><q64>
        matrizTransicao[54][0] = "q4";  //<q0> ::= "<q4>
        matrizTransicao[54][5] = "q1";  //<q46> ::= "<q1>
        matrizTransicao[55][5] = "q46";  //<q46> ::= &<q46>
        matrizTransicao[55][9] = "q64";  //<q63> ::= &<q64>
        matrizTransicao[55][10] = "q64";  //<q64> ::= &<q64>
        matrizTransicao[56][4] = "q46";  //<q4> ::= [<q46>
        matrizTransicao[56][5] = "q46";  //<q46> ::= [<q46>
        matrizTransicao[56][9] = "q64";  //<q63> ::= [<q64>
        matrizTransicao[56][10] = "q64";  //<q64> ::= [<q64>
        matrizTransicao[57][4] = "q46";  //<q4> ::= ?<q46>
        matrizTransicao[57][5] = "q46";  //<q46> ::= ?<q46>
        matrizTransicao[57][9] = "q64";  //<q63> ::= ?<q64>
        matrizTransicao[57][10] = "q64";  //<q64> ::= ?<q64>
        matrizTransicao[58][4] = "q46";  //<q4> ::= {<q46>
        matrizTransicao[58][5] = "q46";  //<q46> ::= {<q46>
        matrizTransicao[58][9] = "q64";  //<q63> ::= {<q64>
        matrizTransicao[58][10] = "q64";  //<q64> ::= {<q64>
        matrizTransicao[59][4] = "q46";  //<q4> ::= }<q46>
        matrizTransicao[59][5] = "q46";  //<q46> ::= }<q46>
        matrizTransicao[59][9] = "q64";  //<q63> ::= }<q64>
        matrizTransicao[59][10] = "q64";  //<q64> ::= }<q64>
        matrizTransicao[60][4] = "q46";  //<q4> ::= ]<q46>
        matrizTransicao[60][5] = "q46";  //<q46> ::= ]<q46>
        matrizTransicao[60][9] = "q64";  //<q63> ::= ]<q64>
        matrizTransicao[60][10] = "q64";  //<q64> ::= ]<q64>
        matrizTransicao[61][4] = "q46";  //<q4> ::= ´<q46>
        matrizTransicao[61][5] = "q46";  //<q46> ::= ´<q46>
        matrizTransicao[61][9] = "q64";  //<q63> ::= ´<q64>
        matrizTransicao[61][10] = "q64";  //<q64> ::= ´<q64>
        matrizTransicao[62][4] = "q46";  //<q4> ::= ~<q46>
        matrizTransicao[62][5] = "q46";  //<q46> ::= ~<q46>
        matrizTransicao[62][9] = "q64";  //<q63> ::= ~<q64>
        matrizTransicao[62][10] = "q64";  //<q64> ::= ~<q64>
        matrizTransicao[63][4] = "q46";  //<q4> ::= `<q46>
        matrizTransicao[63][5] = "q46";  //<q46> ::= `<q46>
        matrizTransicao[63][9] = "q64";  //<q63> ::= `<q64>
        matrizTransicao[63][10] = "q64";  //<q64> ::= `<q64>
        matrizTransicao[64][4] = "q46";  //<q4> ::= ^<q46>
        matrizTransicao[64][5] = "q46";  //<q46> ::= ^<q46>
        matrizTransicao[64][9] = "q64";  //<q63> ::= ^<q64>
        matrizTransicao[64][10] = "q64";  //<q64> ::= ^<q64>
        matrizTransicao[65][5] = "q46";  //<q46> ::= |<q46>
        matrizTransicao[65][9] = "q64";  //<q63> ::= |<q64>
        matrizTransicao[65][10] = "q64";  //<q64> ::= |<q64>
        matrizTransicao[66][5] = "q46";  //<q46> ::= \<q46>
        matrizTransicao[66][9] = "q64";  //<q63> ::= \<q64>
        matrizTransicao[66][10] = "q64";  //<q64> ::= \<q64>
        matrizTransicao[67][2] = "q2";  //<q2> ::= _<q2>
        matrizTransicao[67][4] = "q46";  //<q4> ::= _<q46>
        matrizTransicao[67][5] = "q46";  //<q46> ::= _<q46>
        matrizTransicao[67][9] = "q64";  //<q63> ::= _<q64>
        matrizTransicao[67][10] = "q64";  //<q64> ::= _<q64>
        matrizTransicao[68][2] = "q2";  //<q2> ::= A<q2>
        matrizTransicao[68][4] = "q46";  //<q4> ::= A<q46>
        matrizTransicao[68][5] = "q46";  //<q46> ::= A<q46>
        matrizTransicao[68][9] = "q64";  //<q63> ::= A<q64>
        matrizTransicao[68][10] = "q64";  //<q64> ::= A<q64>
        matrizTransicao[69][2] = "q2";  //<q2> ::= B<q2>
        matrizTransicao[69][4] = "q46";  //<q4> ::= B<q46>
        matrizTransicao[69][5] = "q46";  //<q46> ::= B<q46>
        matrizTransicao[69][9] = "q64";  //<q63> ::= B<q64>
        matrizTransicao[69][10] = "q64";  //<q64> ::= B<q64>
        matrizTransicao[70][2] = "q2";  //<q2> ::= C<q2>
        matrizTransicao[70][4] = "q46";  //<q4> ::= C<q46>
        matrizTransicao[70][5] = "q46";  //<q46> ::= C<q46>
        matrizTransicao[70][9] = "q64";  //<q63> ::= C<q64>
        matrizTransicao[70][10] = "q64";  //<q64> ::= C<q64>
        matrizTransicao[71][2] = "q2";  //<q2> ::= D<q2>
        matrizTransicao[71][4] = "q46";  //<q4> ::= D<q46>
        matrizTransicao[71][5] = "q46";  //<q46> ::= D<q46>
        matrizTransicao[71][9] = "q64";  //<q63> ::= D<q64>
        matrizTransicao[71][10] = "q64";  //<q64> ::= D<q64>
        matrizTransicao[72][2] = "q2";  //<q2> ::= E<q2>
        matrizTransicao[72][4] = "q46";  //<q4> ::= E<q46>
        matrizTransicao[72][5] = "q46";  //<q46> ::= E<q46>
        matrizTransicao[72][9] = "q64";  //<q63> ::= E<q64>
        matrizTransicao[72][10] = "q64";  //<q64> ::= E<q64>
        matrizTransicao[73][2] = "q2";  //<q2> ::= F<q2>
        matrizTransicao[73][4] = "q46";  //<q4> ::= F<q46>
        matrizTransicao[73][5] = "q46";  //<q46> ::= F<q46>
        matrizTransicao[73][9] = "q64";  //<q63> ::= F<q64>
        matrizTransicao[73][10] = "q64";  //<q64> ::= F<q64>
        matrizTransicao[74][2] = "q2";  //<q2> ::= G<q2>
        matrizTransicao[74][4] = "q46";  //<q4> ::= G<q46>
        matrizTransicao[74][5] = "q46";  //<q46> ::= G<q46>
        matrizTransicao[74][9] = "q64";  //<q63> ::= G<q64>
        matrizTransicao[74][10] = "q64";  //<q64> ::= G<q64>
        matrizTransicao[75][2] = "q2";  //<q2> ::= H<q2>
        matrizTransicao[75][4] = "q46";  //<q4> ::= H<q46>
        matrizTransicao[75][5] = "q46";  //<q46> ::= H<q46>
        matrizTransicao[75][9] = "q64";  //<q63> ::= H<q64>
        matrizTransicao[75][10] = "q64";  //<q64> ::= H<q64>
        matrizTransicao[76][2] = "q2";  //<q2> ::= I<q2>
        matrizTransicao[76][4] = "q46";  //<q4> ::= I<q46>
        matrizTransicao[76][5] = "q46";  //<q46> ::= I<q46>
        matrizTransicao[76][9] = "q64";  //<q63> ::= I<q64>
        matrizTransicao[76][10] = "q64";  //<q64> ::= I<q64>
        matrizTransicao[77][2] = "q2";  //<q2> ::= J<q2>
        matrizTransicao[77][4] = "q46";  //<q4> ::= J<q46>
        matrizTransicao[77][5] = "q46";  //<q46> ::= J<q46>
        matrizTransicao[77][9] = "q64";  //<q63> ::= J<q64>
        matrizTransicao[77][10] = "q64";  //<q64> ::= J<q64>
        matrizTransicao[78][2] = "q2";  //<q2> ::= K<q2>
        matrizTransicao[78][4] = "q46";  //<q4> ::= K<q46>
        matrizTransicao[78][5] = "q46";  //<q46> ::= K<q46>
        matrizTransicao[78][9] = "q64";  //<q63> ::= K<q64>
        matrizTransicao[78][10] = "q64";  //<q64> ::= K<q64>
        matrizTransicao[79][2] = "q2";  //<q2> ::= L<q2>
        matrizTransicao[79][4] = "q46";  //<q4> ::= L<q46>
        matrizTransicao[79][5] = "q46";  //<q46> ::= L<q46>
        matrizTransicao[79][9] = "q64";  //<q63> ::= L<q64>
        matrizTransicao[79][10] = "q64";  //<q64> ::= L<q64>
        matrizTransicao[80][2] = "q2";  //<q2> ::= M<q2>
        matrizTransicao[80][4] = "q46";  //<q4> ::= M<q46>
        matrizTransicao[80][5] = "q46";  //<q46> ::= M<q46>
        matrizTransicao[80][9] = "q64";  //<q63> ::= M<q64>
        matrizTransicao[80][10] = "q64";  //<q64> ::= M<q64>
        matrizTransicao[81][2] = "q2";  //<q2> ::= N<q2>
        matrizTransicao[81][4] = "q46";  //<q4> ::= N<q46>
        matrizTransicao[81][5] = "q46";  //<q46> ::= N<q46>
        matrizTransicao[81][9] = "q64";  //<q63> ::= N<q64>
        matrizTransicao[81][10] = "q64";  //<q64> ::= N<q64>
        matrizTransicao[82][2] = "q2";  //<q2> ::= O<q2>
        matrizTransicao[82][4] = "q46";  //<q4> ::= O<q46>
        matrizTransicao[82][5] = "q46";  //<q46> ::= O<q46>
        matrizTransicao[82][9] = "q64";  //<q63> ::= O<q64>
        matrizTransicao[82][10] = "q64";  //<q64> ::= O<q64>
        matrizTransicao[83][2] = "q2";  //<q2> ::= P<q2>
        matrizTransicao[83][4] = "q46";  //<q4> ::= P<q46>
        matrizTransicao[83][5] = "q46";  //<q46> ::= P<q46>
        matrizTransicao[83][9] = "q64";  //<q63> ::= P<q64>
        matrizTransicao[83][10] = "q64";  //<q64> ::= P<q64>
        matrizTransicao[84][2] = "q2";  //<q2> ::= Q<q2>
        matrizTransicao[84][4] = "q46";  //<q4> ::= Q<q46>
        matrizTransicao[84][5] = "q46";  //<q46> ::= Q<q46>
        matrizTransicao[84][9] = "q64";  //<q63> ::= Q<q64>
        matrizTransicao[84][10] = "q64";  //<q64> ::= Q<q64>
        matrizTransicao[85][2] = "q2";  //<q2> ::= R<q2>
        matrizTransicao[85][4] = "q46";  //<q4> ::= R<q46>
        matrizTransicao[85][5] = "q46";  //<q46> ::= R<q46>
        matrizTransicao[85][9] = "q64";  //<q63> ::= R<q64>
        matrizTransicao[85][10] = "q64";  //<q64> ::= R<q64>
        matrizTransicao[86][2] = "q2";  //<q2> ::= S<q2>
        matrizTransicao[86][4] = "q46";  //<q4> ::= S<q46>
        matrizTransicao[86][5] = "q46";  //<q46> ::= S<q46>
        matrizTransicao[86][9] = "q64";  //<q63> ::= S<q64>
        matrizTransicao[86][10] = "q64";  //<q64> ::= S<q64>
        matrizTransicao[87][2] = "q2";  //<q2> ::= T<q2>
        matrizTransicao[87][4] = "q46";  //<q4> ::= T<q46>
        matrizTransicao[87][5] = "q46";  //<q46> ::= T<q46>
        matrizTransicao[87][9] = "q64";  //<q63> ::= T<q64>
        matrizTransicao[87][10] = "q64";  //<q64> ::= T<q64>
        matrizTransicao[88][2] = "q2";  //<q2> ::= U<q2>
        matrizTransicao[88][4] = "q46";  //<q4> ::= U<q46>
        matrizTransicao[88][5] = "q46";  //<q46> ::= U<q46>
        matrizTransicao[88][9] = "q64";  //<q63> ::= U<q64>
        matrizTransicao[88][10] = "q64";  //<q64> ::= U<q64>
        matrizTransicao[89][2] = "q2";  //<q2> ::= V<q2>
        matrizTransicao[89][4] = "q46";  //<q4> ::= V<q46>
        matrizTransicao[89][5] = "q46";  //<q46> ::= V<q46>
        matrizTransicao[89][9] = "q64";  //<q63> ::= V<q64>
        matrizTransicao[89][10] = "q64";  //<q64> ::= V<q64>
        matrizTransicao[90][2] = "q2";  //<q2> ::= W<q2>
        matrizTransicao[90][4] = "q46";  //<q4> ::= W<q46>
        matrizTransicao[90][5] = "q46";  //<q46> ::= W<q46>
        matrizTransicao[90][9] = "q64";  //<q63> ::= W<q64>
        matrizTransicao[90][10] = "q64";  //<q64> ::= W<q64>
        matrizTransicao[91][2] = "q2";  //<q2> ::= X<q2>
        matrizTransicao[91][4] = "q46";  //<q4> ::= X<q46>
        matrizTransicao[91][5] = "q46";  //<q46> ::= X<q46>
        matrizTransicao[91][9] = "q64";  //<q63> ::= X<q64>
        matrizTransicao[91][10] = "q64";  //<q64> ::= X<q64>
        matrizTransicao[92][2] = "q2";  //<q2> ::= Y<q2>
        matrizTransicao[92][4] = "q46";  //<q4> ::= Y<q46>
        matrizTransicao[92][5] = "q46";  //<q46> ::= Y<q46>
        matrizTransicao[92][9] = "q64";  //<q63> ::= Y<q64>
        matrizTransicao[92][10] = "q64";  //<q64> ::= Y<q64>
        matrizTransicao[93][2] = "q2";  //<q2> ::= Z<q2>
        matrizTransicao[93][4] = "q46";  //<q4> ::= Z<q46>
        matrizTransicao[93][5] = "q46";  //<q46> ::= Z<q46>
        matrizTransicao[93][9] = "q64";  //<q63> ::= Z<q64>
        matrizTransicao[93][10] = "q64";  //<q64> ::= Z<q64>
        matrizTransicao[94][4] = "q46";  //<q4> ::=  <q46>
        matrizTransicao[94][5] = "q46";  //<q46> ::=  <q46>
        matrizTransicao[94][9] = "q64";  //<q63> ::=  <q64>
        matrizTransicao[94][10] = "q64";  //<q64> ::=  <q64>
        matrizTransicao[95][9] = "q64";  //<q63> ::= §<q64>
        matrizTransicao[95][10] = "q64";  //<q64> ::= §<q64>

        simbolosEspeciais.put("$", 1); // Fim arquivo
        simbolosEspeciais.put(";", 4); // Ponto e vírgula
        simbolosEspeciais.put(".", 5); // Ponto
        simbolosEspeciais.put(",", 6); // Vírgula
        simbolosEspeciais.put("=", 8); // Sinal de igual
        simbolosEspeciais.put(":", 11); // Dois pontos
        simbolosEspeciais.put("(", 14); // Abrepar
        simbolosEspeciais.put(")", 15); // Fechapar
        simbolosEspeciais.put(":=", 18); // Sinal de atribuição
        simbolosEspeciais.put("<", 34); // Sinal de menor
        simbolosEspeciais.put(">", 35); // Sinal de maior
        simbolosEspeciais.put(">=", 36); // Sinal de maior ou igual
        simbolosEspeciais.put("<=", 37); // Sinal de menor ou igual
        simbolosEspeciais.put("<>", 38); // Sinal de diferente
        simbolosEspeciais.put("+", 39); // Sinal de adição
        simbolosEspeciais.put("-" ,40); // Sinal de subtração
        simbolosEspeciais.put("*", 42); // Sinal de multiplicação
        simbolosEspeciais.put("/", 43); // Sinal de divisão

        palavrasReservadas.put("program", 2); // Palavras reservadas
        palavrasReservadas.put("IDENTIFICADOR", 3); // Identificador
        palavrasReservadas.put("const", 7);
        palavrasReservadas.put("INTEIRO", 9); // Número inteiro
        palavrasReservadas.put("var", 10);
        palavrasReservadas.put("integer", 12);
        palavrasReservadas.put("procedure", 13);
        palavrasReservadas.put("begin", 16);
        palavrasReservadas.put("end", 17);
        palavrasReservadas.put("call", 19);
        palavrasReservadas.put("if", 20);
        palavrasReservadas.put("then", 21);
        palavrasReservadas.put("else", 22);
        palavrasReservadas.put("while", 23);
        palavrasReservadas.put("do", 24);
        palavrasReservadas.put("repeat", 25);
        palavrasReservadas.put("until", 26);
        palavrasReservadas.put("readln", 27);
        palavrasReservadas.put("writeln", 28);
        palavrasReservadas.put("LITERAL", 29); // Literal
        palavrasReservadas.put("case", 30);
        palavrasReservadas.put("of", 31);
        palavrasReservadas.put("for", 32);
        palavrasReservadas.put("to", 33);
        palavrasReservadas.put("or", 41);
        palavrasReservadas.put("and", 44);
        palavrasReservadas.put("not", 45);
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

    public static Integer pegaCodigoDescricao(String palavra) throws ErroLexico {
        Integer codigo = palavrasReservadas.get(palavra);
        if (codigo == null)
            codigo = simbolosEspeciais.get(palavra);
        if (codigo == null) {
            if (isLiteral(palavra)) {
                return palavrasReservadas.get("LITERAL");
            } else if (palavra.startsWith("(*")) { // Comentário
              return -1;
            } else if (isNumber(palavra)) {
                return palavrasReservadas.get("INTEIRO");
            } else {
                if (palavra.length() > 30)
                    throw new ErroLexico("Máximo de caracteres para identificadores excedido!");
                return palavrasReservadas.get("IDENTIFICADOR");
            }
        }
        return codigo;
    }

    private static boolean isLiteral(String palavra) throws ErroLexico {
        if (palavra.startsWith("\"") && palavra.endsWith("\"")) {
            if (palavra.length() > 257) {
                throw new ErroLexico("Limite de caracteres em literais excedido!");
            }
            return true;
        }
        return false;
    }

    private static boolean isNumber(String palavra) throws ErroLexico {
        try {
            int num = Integer.valueOf(palavra);
            if (Math.abs(num) > 32767) {
                throw new ErroLexico("Valor fora da escala!");
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String getMensagemTokensEsperados(Integer topo) {
        List<String> producoes = getProducoes(topo, true);
        StringBuilder msg = new StringBuilder();
        if (topo < ParserConstants.FIRST_NON_TERMINAL) {
            msg.append(ParserConstants.PARSER_ERROR[topo]);
            msg.append(", ");
        }
        msg.append(producoes.get(0));
        for (int i=1; i<producoes.size(); i++) {
            if (i == producoes.size() - 1) {
                msg.append(" ou ");
            } else {
                msg.append(", ");
            }
            msg.append(producoes.get(i));
        }
        return msg.toString();
    }

    private static List<Integer> expandidos = new ArrayList<>();
    private static List<String> getProducoes(Integer topo, boolean limparExpandidos) {
        if (limparExpandidos)
            expandidos.clear();
        List<String> tokens = new ArrayList<>();
        topo -= ParserConstants.FIRST_NON_TERMINAL;
        for (Integer expansao: ParserConstants.PARSER_TABLE[topo]) {
            if (expansao != -1) {
                Integer producao = ParserConstants.PRODUCTIONS[expansao][0];
                if (producao < ParserConstants.FIRST_NON_TERMINAL) {
                    if (!ParserConstants.PARSER_ERROR[producao].equals("")) {
                        tokens.add(ParserConstants.PARSER_ERROR[producao]);
                    }
                } else if (!expandidos.contains(producao)) {
                    expandidos.add(producao);
                    tokens.addAll(getProducoes(producao, false));
                }
            }
        }
        return tokens;
    }
}

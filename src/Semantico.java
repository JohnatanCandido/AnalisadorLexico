import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Semantico {

    private static TabelaSimbolos tabelaSimbolos;

    private static List<String[]> codigoInterm = new ArrayList<>();

    private static Stack<Integer> pilha_if;
    private static Stack<Integer> pilha_while;
    private static Stack<Integer> pilha_repeat;
    private static Stack<Integer> pilha_procedure;
    private static Stack<Integer> pilha_case;
    private static Stack<Integer> pilha_for;
    private static Stack<Simbolo> procedures;
    private static Stack<Simbolo> counters;

    private static Simbolo idAtual;
    private static List<Simbolo> parametros = new ArrayList<>();

    private static Integer nivelAtual = 0;
    private static Integer qtVariaveis;

    private static Simbolo.Categoria tipoIdentificador;

    private static String contexto;
    private static boolean houve_param;
    private static Integer num_param = 0;
    private static Integer num_param_efetivos = 0;
    private static Integer deslocamento = 3;


    public static void trataAcaoSemantica(Integer id, String param) throws ErroSintatico, ErroSemantico {
        switch (id) {
            case 100:
                acaoSemantica100();
                break;
            case 101:
                acaoSemantica101();
                break;
            case 102:
                acaoSemantica102();
                break;
            case 104:
                acaoSemantica104(param);
                break;
            case 105:
                acaoSemantica105(param);
                break;
            case 106:
                acaoSemantica106(new Integer(param));
                break;
            case 107:
                acaoSemantica107();
                break;
            case 108:
                acaoSemantica108(param);
                break;
            case 109:
                acaoSemantica109();
                break;
            case 110:
                acaoSemantica110();
                break;
            case 111:
                acaoSemantica111();
                break;
            case 114:
                acaoSemantica114(param);
                break;
            case 115:
                acaoSemantica115();
                break;
            case 116:
                acaoSemantica116(param);
                break;
            case 117:
                acaoSemantica117();
                break;
            case 118:
                acaoSemantica118();
                break;
            case 120:
                acaoSemantica120();
                break;
            case 121:
                acaoSemantica121();
                break;
            case 122:
                acaoSemantica122();
                break;
            case 123:
                acaoSemantica123();
                break;
            case 124:
                acaoSemantica124();
                break;
            case 125:
                acaoSemantica125();
                break;
            case 126:
                acaoSemantica126();
                break;
            case 127:
                acaoSemantica127();
                break;
            case 128:
                acaoSemantica128();
                break;
            case 129:
                acaoSemantica129(param);
                break;
            case 130:
                acaoSemantica130(param);
                break;
            case 131:
                acaoSemantica131();
                break;
            case 132:
                acaoSemantica132();
                break;
            case 133:
                acaoSemantica133();
                break;
            case 134:
                acaoSemantica134(param);
                break;
            case 135:
                acaoSemantica135();
                break;
            case 136:
                acaoSemantica136(param);
                break;
            case 137:
                acaoSemantica137(param);
                break;
            case 138:
                acaoSemantica138();
                break;
            case 139:
                acaoSemantica139();
                break;
            case 140:
                acaoSemantica140();
                break;
            case 141:
                acaoSemantica141();
                break;
            case 142:
                acaoSemantica142();
                break;
            case 143:
                acaoSemantica143();
                break;
            case 144:
                acaoSemantica144();
                break;
            case 145:
                acaoSemantica145();
                break;
            case 146:
                acaoSemantica146();
                break;
            case 147:
                acaoSemantica147();
                break;
            case 148:
                acaoSemantica148();
                break;
            case 149:
                acaoSemantica149();
                break;
            case 150:
                acaoSemantica150();
                break;
            case 151:
                acaoSemantica151();
                break;
            case 152:
                acaoSemantica152();
                break;
            case 153:
                acaoSemantica153();
                break;
            case 154:
                acaoSemantica154(param);
                break;
            case 155:
                acaoSemantica155();
                break;
            case 156:
                acaoSemantica156();
                break;
            default:
                throw new ErroSintatico("-42", "Ação semântica não encontrada");
        }
    }

    /**
     * Reconhecendo o nome do programa.
     * 
     * - Inicializa pilhas (ifs, while, repeat, procedures, case, for)
     * - Inicializa tabela de símbolos (vetor tab_hash e a própria tabela tab_simb)
     * - Inicializa área de instruções da máquina hipotética
     * - Inicializa área de literais da máquina hipotética
     * - Inicializa algumas variáveis :
     * - nível_atual:=0 ( faz o controle do nível atual),
     * - Pt_livre:=1 , (aponta para a próxima posição livre da tabela de símbolos)
     * - escopo[0]:=1 (usada juntamente com Tabela de símbolos) ,
     * Observa-se que estas três variáveis, dependendo da implementação, podem ser inicializadas na Classe TS.
     * - número de variáveis nv :=0 (número de variáveis num bloco)
     * - deslocamento=:3 ( em relação a base),
     * - Lc:=1 (aponta para a próxima instrução a ser gerada)
     * - Lit := 1 { ponteiro auxiliar para área de literais – n. de ordem}
     **/
    private static void acaoSemantica100() {
        tabelaSimbolos = new TabelaSimbolos();
        pilha_if = new Stack<>();
        pilha_while = new Stack<>();
        pilha_repeat = new Stack<>();
        pilha_procedure = new Stack<>();
        pilha_case = new Stack<>();
        pilha_for = new Stack<>();

        procedures = new Stack<>();
        counters = new Stack<>();

        Maquina.inicializaAreaIntrucoes();
        Maquina.inicializaAreaLiterais();

        qtVariaveis = 0;
    }
    
    /**
     * Final de programa
     * 
     * - Gera instrução PARA
     * - Verifica utilização de rótulos através da tabela de símbolos
     **/
    private static void acaoSemantica101() {
        codigoInterm.add(new String[] {"PARA", "-", "-"});
        for (int i = 0; i < codigoInterm.size(); i++) {
//            String texto = String.format("%2s | %5s (%2s) | %2s | %2s", i+1,  codigoInterm.get(i)[0], Util.getComandos().indexOf(codigoInterm.get(i)[0]), codigoInterm.get(i)[1], codigoInterm.get(i)[2]);
            String texto = String.format("%2s | %5s | %2s | %2s", i+1,  codigoInterm.get(i)[0], codigoInterm.get(i)[1], codigoInterm.get(i)[2]);
            System.out.println(texto);
            Maquina.incluiAreaInstrucao(codigoInterm.get(i)[0], codigoInterm.get(i)[1], codigoInterm.get(i)[2]);
        }
        Maquina.interpreta();
    }

    /**
     * Após declaração de variável
     * 
     * - Gera instrução AMEM utilizando como base o número de ações acumuladas na ação #104
     */
    private static void acaoSemantica102() {
        codigoInterm.add(new String[] {"AMEN", "-", String.valueOf(3 + qtVariaveis)});

        if (idAtual != null && idAtual.getCategoria().equals(Simbolo.Categoria.PROCEDURE)) {
            procedures.push(idAtual);
        }
    }

    /**
     * Encontrado o nome de rótulo, de variável, ou de parâmetro de procedure em declaração
     * 
     * caso tipo_identificador = RÓTULO {setado na ação #103}
     * se nome está na tabela de símbolos no escopo do nível (*usar rotina de inserção na TS*)
     * então erro
     * senão
     * - insere identificador na tabela de símbolos com os
     * atributos: categoria = rótulo, nível, endereço da instrução rotulada =0 e cabeça de lista de referências futuras = 0
     * fim se
     *
     *
     * caso tipo_identificador = VARIÁVEL {setado em #107}
     * se nome está na tabela de símbolos no escopo do nível
     * (* usar rotina de inserção*)
     * então erro
     * senão
     * - insere identificador na TS com os atributos: categoria = variável, nível, deslocamento;
     * - acumula número de variáveis (* nv:=nv +1 *)
     * fim se
     *
     *
     * caso tipo_identificador = PARÂMETRO {setado em #111}
     * se nome está na tabela de símbolos no escopo do nível
     * (* usar rotina de inserção na TS*)
     * então erro
     * senão
     * insere nome na tabela de símbolos preenchendo
     * atributos: categoria = parâmetro, nível;
     * acumula número de parâmetros (* np=np+1*)
     * fim se
     */
    private static void acaoSemantica104(String nome) throws ErroSemantico {
        if (tipoIdentificador.equals(Simbolo.Categoria.ROTULO)) {
            tabelaSimbolos.insere(nome, Simbolo.Categoria.ROTULO, nivelAtual, 0, 0);
        }

        else if (tipoIdentificador.equals(Simbolo.Categoria.VARIAVEL)) {
            tabelaSimbolos.insere(nome, Simbolo.Categoria.VARIAVEL, nivelAtual, deslocamento, 0);
            qtVariaveis++;
            deslocamento++;
        }

        else if (tipoIdentificador.equals(Simbolo.Categoria.PARAMETRO)) {
            tabelaSimbolos.insere(nome, Simbolo.Categoria.PARAMETRO, nivelAtual, 0, 0);
            parametros.add(tabelaSimbolos.buscaParametro(nome));
            num_param++;
        }
    }

    /**
     * Reconhecido nome de constante em declaração
     *
     * se nome já declarado no escopo do nível
     * então erro
     * senão
     * insere identificador na tabela de símbolos preenchendo
     * atributos : categoria = constante, nível
     * Salva endereço do identificador na TS
     * fim se
     */
    private static void acaoSemantica105(String nome) throws ErroSemantico {
        tabelaSimbolos.insere(nome, Simbolo.Categoria.CONSTANTE, nivelAtual, 0, 0);
        idAtual = tabelaSimbolos.busca(nome);
    }

    /**
     * Reconhecido valor de constante em declaração
     *
     * Preenche atributo para constante na TS (valor base 10), utilizando endereço do identificador na TS salvo em ação #105
     */
    private static void acaoSemantica106(Integer valor) {
        idAtual.setGeralA(valor);
    }

    /**
     * Antes de lista de identificadores em declaração de variáveis
     *
     * seta tipo_identificador = variável
     */
    private static void acaoSemantica107() {
        tipoIdentificador = Simbolo.Categoria.VARIAVEL;
    }

    /**
     * Após nome de procedure, em declaração
     *
     * Faz:
     * - categoria := proc
     * - inserção
     * - houve_parametros := false
     * - n_par := 0
     * - incrementa nível (Nível_atual:= nível_atual + 1)
     */
    private static void acaoSemantica108(String nome) throws ErroSemantico {
        tipoIdentificador = Simbolo.Categoria.PROCEDURE;
        tabelaSimbolos.insere(nome, Simbolo.Categoria.PROCEDURE, nivelAtual, 0, 0);
        idAtual = tabelaSimbolos.busca(nome);
        houve_param = false;
        num_param = 0;
        qtVariaveis = 0;
        deslocamento = 3;
        nivelAtual++;
    }

    /**
     * Após declaração de procedure
     *
     * se houver parâmetro então
     * atualiza numero de parâmetros na TS para a procedure em questão
     * GeralB = np
     * preenche atributos dos parâmetros (deslocamento):
     * primeiro parâmetro –> deslocamento = - (np)
     * segundo parâmetro –> deslocamento = - (np – 1)
     * -----------------------------------------------------------------
     * -----------------------------------------------------------------
     * fim se
     * gera instrução DSVS com parâmetro zero, e salva na pilha de controle de desvios de
     * procedure o endereço da instrução de desvio e o número de parâmetros.
     */
    private static void acaoSemantica109() {
        if (houve_param) {
            idAtual.setGeralB(num_param);
        }
        for (Simbolo parametro: parametros) {
            parametro.setGeralA(-num_param);
            num_param--;
        }
        parametros.clear();
        pilha_procedure.push(codigoInterm.size());
        codigoInterm.add(new String[]{"DSVS", "-", ""});
        idAtual.setGeralA(codigoInterm.size()+1);
    }

    /**
     * Fim de procedure
     * - retira da pilha de controle de procedures: número de parâmetros (np) , endereço da instrução de desvio
     * - gera instrução RETU
     * - verifica utilização de rótulos na TS
     * - completa instrução de desvio da procedure ( aponta para LC)
     * - deleta nomes do escopo do nível na TS
     * - decrementa nível (Nível_atual:= nível_atual – 1)
     */
    private static void acaoSemantica110() {
        codigoInterm.add(new String[]{"RETU", "-", procedures.pop().getGeralB().toString()});
        codigoInterm.get(pilha_procedure.pop())[2] = String.valueOf(codigoInterm.size() + 1);
        tabelaSimbolos.removerNivel(nivelAtual);
        nivelAtual--;
    }

    /**
     * Antes de parâmetros formais de procedures
     *
     * - seta tipo_identificador = parâmetro'
     * - houve parâmetro = true
     */
    private static void acaoSemantica111() {
        tipoIdentificador = Simbolo.Categoria.PARAMETRO;
        houve_param = true;
    }

    /**
     * Atribuição parte esquerda
     *
     * se nome está na tabela de símbolos então
     * se nome <> nome de variável então erro
     * senão salva atributos do nome
     * fim se
     * senão erro ("identificador não declarado")
     * fim se
     */
    private static void acaoSemantica114(String nome) throws ErroSemantico {
        idAtual = tabelaSimbolos.busca(nome);
        if (!idAtual.getCategoria().equals(Simbolo.Categoria.VARIAVEL))
            throw new ErroSemantico("Não é uma variável");
    }

    /**
     * Após expressão em atribuição
     *
     * gera instrução armazena (ARMZ) para variável da esquerda
     * (atributos salvos em #114)
     */
    private static void acaoSemantica115() {
        codigoInterm.add(new String[]{"ARMZ", String.valueOf(nivelAtual - idAtual.getNivel()), idAtual.getGeralA().toString()});
    }

    /**
     * Chamada de procedure
     *
     * se nome esta na TS e é nome de procedure
     * então salva endereço do nome
     * senão erro
     * fim se
     */
    private static void acaoSemantica116(String nome) throws ErroSemantico {
        Simbolo procedure = tabelaSimbolos.busca(nome);
        if (!procedure.getCategoria().equals(Simbolo.Categoria.PROCEDURE))
            throw new ErroSemantico(nome + " não é uma procedure!");
        idAtual = procedure;
    }

    /**
     * Após comando call
     *
     * se num. de parâmetros <> num. de parâmetros efetivos
     * então erro
     * senão gera instrução CALL, utilizando informaçoes da procedure, contidas na TS (
     * endereço na TS salvo em ação #116)
     * fim se
     */
    private static void acaoSemantica117() throws ErroSemantico {
        if (!idAtual.getGeralB().equals(num_param_efetivos))
            throw new ErroSemantico("????");
        num_param_efetivos = 0;
        codigoInterm.add(new String[]{"CALL", String.valueOf(nivelAtual - idAtual.getNivel()), idAtual.getGeralA().toString()});
    }

    /**
     * Após expressão, em comando call
     *
     * acumula número de parâmetros efetivos
     */
    private static void acaoSemantica118() {
        num_param_efetivos++;
    }

    /**
     * Após expressão num comando IF
     *
     * - gera DSVF com operando desconhecido
     * - empilha endereço da instrução (*para ser resolvido o endereço do operando futuramente *)
     */
    private static void acaoSemantica120() {
        codigoInterm.add(new String[]{"DSVF", "-", ""});
        pilha_if.push(codigoInterm.size() - 1);
    }

    /**
     * Após instrução IF
     *
     * - completa instrução DSVS gerada na ação #122
     * - operando recebe valor de LC
     */
    private static void acaoSemantica121() {
        codigoInterm.get(pilha_if.pop())[2] = String.valueOf(codigoInterm.size() + 1);
    }

    /**
     * Após domínio do THEN, antes do ELSE
     *
     * - resolve DSVF da ação #120, colocando como operando o endereço (LC + 1)
     * - gera instrução DSVS, com operando desconhecido, salvando seu endereço na pilha dos IF’s para posterior marcação
     */
    private static void acaoSemantica122() {
        codigoInterm.add(new String[]{"DSVS", "-", ""});
        codigoInterm.get(pilha_if.pop())[2] = String.valueOf(codigoInterm.size() + 1);
        pilha_if.push(codigoInterm.size() - 1);
    }

    /**
     * Comando WHILE antes da expressão
     *
     * o valor de LC é armazenado na pilha dos WHILE’s, este é o endereço de retorno do WHILE
     */
    private static void acaoSemantica123() {
        pilha_while.push(codigoInterm.size());
    }

    /**
     * Comando WHILE depois da expressão
     *
     * gera DSVF com operando desconhecido. Como o operando não é conhecido no momento,
     * o seu endereço (ou da instrução) é guardado na pilha dos WHILE’s para posterior marcação
     */
    private static void acaoSemantica124() {
        codigoInterm.add(new String[]{"DSVF", "-", ""});
        pilha_while.push(codigoInterm.size() - 1);
    }

    /**
     * Após comando WHILE
     *
     * - resolve DSVF da ação #124 colocando como operando o endereço(LC + 1)
     * - gera DSVS com operando = endereço de retorno, salvo na pilha de ação #123
     */
    private static void acaoSemantica125() {
        codigoInterm.get(pilha_while.pop())[2] = String.valueOf(codigoInterm.size() + 1);
        codigoInterm.add(new String[]{"DSVS", "-", String.valueOf(pilha_while.pop())});
    }

    /**
     * Comando REPEAT – início
     *
     * o valor de LC é armazenado numa pilha (pilha dos repeat´s) - este é o endereço de retorno.
     */
    private static void acaoSemantica126() {
        pilha_repeat.add(codigoInterm.size());
    }

    /**
     * Comando REPEAT – fim
     *
     * gera DSVF, utilizando como operando o valor de LC guardado na pilha dos repeat´s conforme ação # 126.
     */
    private static void acaoSemantica127() {
        codigoInterm.add(new String[]{"DSVF", "-", String.valueOf(pilha_repeat.pop() + 1)});
    }

    /**
     * Comando READLN início
     *
     * seta contexto = readln
     */
    private static void acaoSemantica128() {
        contexto = "readln";
    }

    /**
     * Identificador de variável
     *
     * caso contexto = readln {setado em #128}
         * se identificador é nome de variável e está na tabela de símbolos então
             *  gera LEIT
             *  gera ARMZ
             * senão erro
         * fim se
     * caso contexto = expressão {setado em #156}
     * se nome não está na tabela de símbolos
     *  então erro
     * senão se nome é de procedure ou de rótulo
     * então erro
     * senão se nome é de constante
     * então gera CRCT valor decimal
     * senão gera CRVL - , deslocamento
     * fim se
     * fim se
     * fim se
     */
    private static void acaoSemantica129(String nome) throws ErroSemantico {
        if (contexto.equals("readln")) {
            Simbolo variavel = tabelaSimbolos.busca(nome);
            if (variavel.isVariavel()) {
                codigoInterm.add(new String[]{"LEIT", "-", "-"});
                codigoInterm.add(new String[]{"ARMZ", String.valueOf(nivelAtual - variavel.getNivel()), variavel.getGeralA().toString()});
            }
        } else if (contexto.equals("expressão")) {
            Simbolo variavel = tabelaSimbolos.busca(nome);
            if (variavel.getCategoria().equals(Simbolo.Categoria.PROCEDURE) || variavel.getCategoria().equals(Simbolo.Categoria.ROTULO))
                throw new ErroSemantico("Acho que não devia ser procedure nem rotulo");
            else if (variavel.getCategoria().equals(Simbolo.Categoria.CONSTANTE))
                codigoInterm.add(new String[]{"CRCT", "-", variavel.getGeralA().toString()});
            else
                codigoInterm.add(new String[]{"CRVL", String.valueOf(nivelAtual - variavel.getNivel()), variavel.getGeralA().toString()});
        }
    }

    /**
     * WRITELN - após literal na instrução WRITELN
     *
     * - armazena cadeia literal na área de literais (pega o literal identificado pelo léxico e transposta para área de literais – área_literais)
     * - atualiza ponteiro de literal ( pont_literal – vetor que aponta para o inicio do literal respectivo na área de literais) - aponta para o inicio do proximo literal.
     * - gera IMPRLIT tendo como parâmetro o numero de ordem do literal ( literal 1, literal 2 ...)
     * - incrementa no. de ordem do literal
     *
     * Nota : a área de literais (área_literais) e o ponteiro de literais (pont_literal) são gerados na fase de compilação
     * e utilizados na fase de interpretação (execução) do programa.
     */
    private static void acaoSemantica130(String literal) {
        Maquina.incluiAreaLiterais(literal);
        codigoInterm.add(new String[]{"IMPRL", "-", Maquina.retornaPonteiroLiteral()});
    }

    /**
     * WRITELN após expressão
     *
     * gera IMPR
     */
    private static void acaoSemantica131() {
        codigoInterm.add(new String[]{"IMPR", "-", "-"});
    }

    /**
     * Após palavra reservada CASE
     *
     * Acopla mecanismo de controle de inicio de CASE junto à pilha de controle de CASE
     */
    private static void acaoSemantica132() {
//      TODO
    }

    /**
     * Após comando CASE
     *
     * - completa instruções de desvio (DSVS), relativas ao CASE em questão, com LC, utilizando endereços salvos na pilha de controle
     * - gera instrução AMEN -, -1 (limpeza)
     */
    private static void acaoSemantica133() {
        while (!pilha_case.isEmpty())
            codigoInterm.get(pilha_case.pop())[2] = String.valueOf(codigoInterm.size()+1);
        codigoInterm.add(new String[]{"AMEN", "-", "-1"});
    }

    /**
     * Ramo do CASE após inteiro, último da lista
     *
     * - gera instrução COPIA
     * - gera instrução CRCT inteiro
     * - gera instrução CMIG
     * - resolve, se houver pendência, instruções de desvio (DSVT) utilizando endereços salvos na pilha de controle, colocando como operando (LC+1)
     * - gera instrução DSVF, guardando endereço do operando ou da instrução na pilha de controle dos CASE´s.
     */
    private static void acaoSemantica134(String constante) {
        codigoInterm.add(new String[]{"COPI", "-", "-"});
        codigoInterm.add(new String[]{"CRCT", "-", constante});
        codigoInterm.add(new String[]{"CMIG", "-", "-"});
        while (!pilha_case.isEmpty()) {
            if (codigoInterm.get(pilha_case.peek())[0].equals("DSVS"))
                break;
            codigoInterm.get(pilha_case.pop())[2] = String.valueOf(codigoInterm.size() + 2);
        }
        pilha_case.add(codigoInterm.size());
        codigoInterm.add(new String[]{"DSVF", "-", "?"});
    }

    /**
     * Após comando em CASE
     *
     * - resolve ultima instrução de desvio (DSVF) gerada, utilizando endereços salvos na pilha de controle, colocando como operando (LC+1)
     * - gera instrução DSVS, guardando endereço da instrução na pilha de controle, para posterior marcação.
     */
    private static void acaoSemantica135() {
        codigoInterm.add(new String[]{"DSVS", "-", "?"});
        codigoInterm.get(pilha_case.pop())[2] = String.valueOf(codigoInterm.size()+1);
        pilha_case.add(codigoInterm.size()-1);
    }

    /**
     * Ramo do CASE: após inteiro
     *
     * - gera instrução COPIA
     * - gera instrução CRCT inteiro
     * - gera instrução CMIG
     * - gera instrução DSVT – salvando endereço da instrução na pilha de controle para posterior marcação.
     */
    private static void acaoSemantica136(String numero) {
        codigoInterm.add(new String[]{"COPI", "-", "-"});
        codigoInterm.add(new String[]{"CRCT", "-", numero});
        codigoInterm.add(new String[]{"CMIG", "-", "-"});
        pilha_case.add(codigoInterm.size());
        codigoInterm.add(new String[]{"DSVT", "-", "?"});
    }

    /**
     * Após variável controle comando FOR
     *
     * se nome esta na TS e é nome da variável então
     * salva endereço do nome em relação a TS
     * senão erro
     * fim se
     */
    private static void acaoSemantica137(String nome) throws ErroSemantico {
        idAtual = tabelaSimbolos.busca(nome);
    }

    /**
     * Após expressão valor inicial
     *
     * gera instrução ARMZ – considerando variável de controle atributos salvos em #137
     */
    private static void acaoSemantica138() {
        codigoInterm.add(new String[]{"ARMZ", String.valueOf(nivelAtual - idAtual.getNivel()), idAtual.getGeralA().toString()});
    }

    /**
     * Após expressão – valor final
     *
     * - armazena valor de LC na pilha de controle do FOR
     * - gera instrução COPIA
     * - gera instrução CRVL – atributos salvos em #137
     * - gera instrução CMAI
     * - gera instrução DSVF com parâmetro desconhecido, guardando na pilha de controle o endereço do operando (ou da instrução) para posterior marcação.
     * - armazena na pilha de controle o endereço do nome da variável de controle relativo à tabela de símbolos.
     */
    private static void acaoSemantica139() {
        pilha_for.add(codigoInterm.size());
        codigoInterm.add(new String[]{"COPI", "-", "-"});
        codigoInterm.add(new String[]{"CRVL", String.valueOf(nivelAtual - idAtual.getNivel()), idAtual.getGeralA().toString()});
        codigoInterm.add(new String[]{"CMAI", "-", "-"});
        pilha_for.add(codigoInterm.size());
        codigoInterm.add(new String[]{"DSVF", "-", "?"});
        counters.add(idAtual);
    }

    /**
     * Após comando em FOR
     *
     * - gera instrução CRVL, utilizando endereço salvo em #139( @ da TS da variável de controle na pilha de controle)
     * - gera instrução CRCT (1) base 10
     * - gera instrução soma (até aqui incrementa variável de controle)
     * - gera instrução ARMZ variável controle
     * - completa instrução DSVF, gerada na ação #139, utilizando como operando (LC+1)
     * - gera instruçao DSVS, utilizando como operando o valor de LC salvo na ação #139 (retorno)
     * - gera instrução AMEN, -1 (limpeza)
     */
    private static void acaoSemantica140() {
        Simbolo counter = counters.pop();
        codigoInterm.add(new String[]{"CRVL", String.valueOf(nivelAtual - counter.getNivel()), counter.getGeralA().toString()});
        codigoInterm.add(new String[]{"CRCT", "-", "1"});
        codigoInterm.add(new String[]{"SOMA", "-", "-"});
        codigoInterm.add(new String[]{"ARMZ", String.valueOf(nivelAtual - counter.getNivel()), counter.getGeralA().toString()});
        codigoInterm.get(pilha_for.pop())[2] = String.valueOf(codigoInterm.size() + 2);
        codigoInterm.add(new String[]{"DSVS", "-", String.valueOf(pilha_for.pop() + 1)});
        codigoInterm.add(new String[]{"AMEN", "-", "-1"});
    }

    /**
     * #141 à #146: comparações
     * - gera instrução de comparação correspondente
     */
    private static void acaoSemantica141() {
        codigoInterm.add(new String[]{"CMIG", "-", "-"});
    }

    /**
     *
     */
    private static void acaoSemantica142() {
        codigoInterm.add(new String[]{"CMME", "-", "-"});
    }

    /**
     *
     */
    private static void acaoSemantica143() {
        codigoInterm.add(new String[]{"CMMA", "-", "-"});
    }

    /**
     *
     */
    private static void acaoSemantica144() {
        codigoInterm.add(new String[]{"CMAI", "-", "-"});
    }

    /**
     *
     */
    private static void acaoSemantica145() {
        codigoInterm.add(new String[]{"CMEI", "-", "-"});
    }

    /**
     *
     */
    private static void acaoSemantica146() {
        codigoInterm.add(new String[]{"CMDF", "-", "-"});
    }

    /**
     * Expressão – operando com sinal unário
     *
     * gera INVR
     */
    private static void acaoSemantica147() {
        codigoInterm.add(new String[]{"INVR", "-", "-"});
    }

    /**
     * Expressão – soma
     *
     * gera SOMA
     */
    private static void acaoSemantica148() {
        codigoInterm.add(new String[]{"SOMA", "-", "-"});
    }

    /**
     * Expressão – subtração
     *
     * gera SUBT
     */
    private static void acaoSemantica149() {
        codigoInterm.add(new String[]{"SUBT", "-", "-"});
    }

    /**
     * Expressão – or
     *
     * gera DISJ
     */
    private static void acaoSemantica150() {
        codigoInterm.add(new String[]{"DISJ", "-", "-"});
    }

    /**
     * Expressão – multiplicação
     *
     * gera MULT
     */
    private static void acaoSemantica151() {
        codigoInterm.add(new String[]{"MULT", "-", "-"});
    }

    /**
     * Expressão – divisão
     *
     * gera DIVI
     */
    private static void acaoSemantica152() {
        codigoInterm.add(new String[]{"DIVI", "-", "-"});
    }

    /**
     * Expressão – and
     *
     * gera CONJ
     */
    private static void acaoSemantica153() {
        codigoInterm.add(new String[]{"CONJ", "-", "-"});
    }

    /**
     * Expressão – inteiro
     *
     * gera CRCT
     */
    private static void acaoSemantica154(String valor) {
        codigoInterm.add(new String[]{"CRCT", "-", valor});
    }

    /**
     * Expresso – not
     *
     * gera NEGA
     */
    private static void acaoSemantica155() {
        codigoInterm.add(new String[]{"NEGA", "-", "-"});
    }

    /**
     * Expressão – variável
     *
     * seta contexto = expressão
     */
    private static void acaoSemantica156() {
        contexto = "expressão";
    }

}

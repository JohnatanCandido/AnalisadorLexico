public interface ParserConstants
{
    int START_SYMBOL = 46;

    int FIRST_NON_TERMINAL    = 46;
    int FIRST_SEMANTIC_ACTION = 77;

    int[][] PARSER_TABLE =
    {
    /*PROGRAM*/{ -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
      /*BLOCO*/{ -1, -1, -1, -1, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        /*LID*/{ -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
   /*REPIDENT*/{ -1, -1, -1, -1, -1,  4, -1, -1, -1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
   /*DCLOCNST*/{ -1, -1, -1, -1, -1, -1,  5, -1, -1,  8, -1, -1,  8, -1, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
    /*LDCONST*/{ -1, -1,  7, -1, -1, -1, -1, -1, -1,  6, -1, -1,  6, -1, -1,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
     /*DCLVAR*/{ -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, -1, 12, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
      /*LDVAR*/{ -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
       /*TIPO*/{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
    /*DCLPROC*/{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
     /*DEFPAR*/{ -1, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
      /*CORPO*/{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
 /*REPCOMANDO*/{ -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
    /*COMANDO*/{ -1, -1, 21, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, 23, -1, 24, 29, -1, 23, 32, -1, 33, 23, 34, 38, -1, 43, -1, 49, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
 /*PARAMETROS*/{ -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, -1, 25, -1, -1, -1, -1, 25, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
     /*REPPAR*/{ -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
  /*ESLEPARTE*/{ -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, 31, -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
   /*VARIAVEL*/{ -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
/*REPVARIAVEL*/{ -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
  /*ITEMSAIDA*/{ -1, -1, 40, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, 40, -1, -1, -1, -1, 40 },
    /*REPITEM*/{ -1, -1, -1, -1, -1, 42, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
  /*CONDCASSE*/{ -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
  /*RPINTEIRO*/{ -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
   /*CONTCASE*/{ -1, -1, -1, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 47, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
  /*EXPRESSAO*/{ -1, -1, 50, -1, -1, -1, -1, -1, 50, -1, -1, -1, -1, 50, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 50, 50, -1, -1, -1, -1, 50 },
 /*REPEXPSIMP*/{ -1, -1, -1, 51, -1, 51, -1, 52, -1, -1, -1, -1, -1, -1, 51, -1, 51, -1, -1, -1, 51, 51, -1, 51, -1, 51, -1, -1, -1, -1, 51, -1, 51, 53, 54, 55, 56, 57, -1, -1, -1, -1, -1, -1, -1 },
    /*EXPSIMP*/{ -1, -1, 60, -1, -1, -1, -1, -1, 60, -1, -1, -1, -1, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, 59, -1, -1, -1, -1, 60 },
     /*REPEXP*/{ -1, -1, -1, 64, -1, 64, -1, 64, -1, -1, -1, -1, -1, -1, 64, -1, 64, -1, -1, -1, 64, 64, -1, 64, -1, 64, -1, -1, -1, -1, 64, -1, 64, 64, 64, 64, 64, 64, 61, 62, 63, -1, -1, -1, -1 },
      /*TERMO*/{ -1, -1, 65, -1, -1, -1, -1, -1, 65, -1, -1, -1, -1, 65, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 65 },
   /*REPTERMO*/{ -1, -1, -1, 66, -1, 66, -1, 66, -1, -1, -1, -1, -1, -1, 66, -1, 66, -1, -1, -1, 66, 66, -1, 66, -1, 66, -1, -1, -1, -1, 66, -1, 66, 66, 66, 66, 66, 66, 66, 66, 66, 67, 68, 69, -1 },
      /*FATOR*/{ -1, -1, 73, -1, -1, -1, -1, -1, 70, -1, -1, -1, -1, 71, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 72 }
    };

    int[][] PRODUCTIONS = 
    {
        {  2,  3,  4, 47,  5 },
        { 50, 52, 55, 57 },
        {  3, 49 },
        {  0 },
        {  6,  3, 49 },
        {  7,  3,  8,  9,  4, 51 },
        {  0 },
        {  3,  8,  9,  4, 51 },
        {  0 },
        { 10, 48, 11, 54,  4, 53 },
        {  0 },
        { 48, 11, 54,  4, 53 },
        {  0 },
        { 12 },
        { 13,  3, 56,  4, 47,  4, 55 },
        {  0 },
        {  0 },
        { 14, 48, 11, 12, 15 },
        { 16, 59, 58, 17 },
        {  0 },
        {  4, 59, 58 },
        {  3, 18, 70 },
        { 57 },
        {  0 },
        { 19,  3, 60 },
        {  0 },
        { 14, 70, 61, 15 },
        {  0 },
        {  6, 70, 61 },
        { 20, 70, 21, 59, 62 },
        {  0 },
        { 22, 59 },
        { 23, 70, 24, 59 },
        { 25, 59, 26, 70 },
        { 27, 14, 63, 64, 15 },
        {  3 },
        {  0 },
        {  6, 63, 64 },
        { 28, 14, 65, 66, 15 },
        { 29 },
        { 70 },
        {  0 },
        {  6, 65, 66 },
        { 30, 70, 31, 67, 17 },
        {  9, 68, 11, 59, 69 },
        {  6,  9, 68 },
        {  0 },
        {  0 },
        {  4, 67 },
        { 32,  3, 18, 70, 33, 70, 24, 59 },
        { 72, 71 },
        {  0 },
        {  8, 72 },
        { 34, 72 },
        { 35, 72 },
        { 36, 72 },
        { 37, 72 },
        { 38, 72 },
        { 39, 74, 73 },
        { 40, 74, 73 },
        { 74, 73 },
        { 39, 74, 73 },
        { 40, 74, 73 },
        { 41, 74, 73 },
        {  0 },
        { 76, 75 },
        {  0 },
        { 42, 76, 75 },
        { 43, 76, 75 },
        { 44, 76, 75 },
        {  9 },
        { 14, 70, 15 },
        { 45, 76 },
        { 63 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "fim de programa",
        "\"program\"",
        "um identificador",
        "\";\"",
        "\".\"",
        "\",\"",
        "\"const\"",
        "\"=\"",
        "um número",
        "\"var\"",
        "\":\"",
        "\"integer\"",
        "\"procedure\"",
        "\"(\"",
        "\")\"",
        "\"begin\"",
        "\"end\"",
        "\":=\"",
        "\"call\"",
        "\"if\"",
        "\"then\"",
        "\"else\"",
        "\"while\"",
        "\"do\"",
        "\"repeat\"",
        "\"until\"",
        "\"readln\"",
        "\"writeln\"",
        "um literal",
        "\"case\"",
        "\"of\"",
        "\"for\"",
        "\"to\"",
        "\"<\"",
        "\">\"",
        "\">=\"",
        "\"<=\"",
        "\"<>\"",
        "\"+\"",
        "\"-\"",
        "\"or\"",
        "\"*\"",
        "\"/\"",
        "\"and\"",
        "\"not\"",
        "<PROGRAMA>",
        "<BLOCO>",
        "<LID>",
        "<REPIDENT>",
        "<DCLCONST>",
        "<LDCONST>",
        "<DCLVAR>",
        "<LDVAR>",
        "<TIPO>",
        "<DCLPROC>",
        "<DEFPAR>",
        "<CORPO>",
        "<REPCOMANDO>",
        "<COMANDO>",
        "<PARAMETROS>",
        "<REPPAR>",
        "<ELSEPARTE>",
        "<VARIAVEL>",
        "<REPVARIAVEL>",
        "<ITEMSAIDA>",
        "<REPITEM>",
        "<CONDCASE>",
        "<RPINTEIRO>",
        "<CONTCASE>",
        "<EXPRESSAO>",
        "<REPEXPSIMP>",
        "<EXPSIMP>",
        "<REPEXP>",
        "<TERMO>",
        "<REPTERMO>",
        "<FATOR>"
    };
}

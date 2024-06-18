package kuboys.enums;

public enum EnumGravidadeException {
    /**
     * Apenas mostra a mensagem e o botão de fechar, sem opção de abrir detalhes
     */
    MENSAGEM,

    /**
     * Usuário vai consegui tratar
     */
    INFO,

    /**
     * Usuário comum não consegue tratar, mas outro consegue (âncora)
     */
    AVISO,

    /**
     * Usuário não consegue tratar. Tem que contatar suporte
     */
    ERRO;
}

package kuboys.exceptions;

import kuboys.enums.EnumGravidadeException;

public class GestException extends RuntimeException{
    private String mensagem;
    private EnumGravidadeException gravidade;

    /**
     * @Deprecated esse constutor só existe para permitir fazer o parse de JSON
     */
    @Deprecated
    public GestException() {
        //
    }

    public GestException(EnumGravidadeException gravidade, String mensagem) {
        this(gravidade, mensagem, mensagem);
    }

    public GestException(EnumGravidadeException gravidade, String mensagem, String mensagemSuporte) {
        this(gravidade, mensagem, mensagemSuporte, null);
    }

    public GestException(EnumGravidadeException gravidade, String mensagem, String mensagemSuporte, Throwable cause) {
        super((mensagem == null || mensagem.isEmpty() || mensagem.equals(mensagemSuporte)) ? mensagemSuporte
                : mensagem + "\nMensagem para o suporte: " + mensagemSuporte, cause);
        this.gravidade = gravidade;
        this.mensagem = mensagem;
    }

    public EnumGravidadeException getGravidade() {
        return gravidade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public GestException(EnumGravidadeException gravidade, String mensagem, Throwable cause) {
        this(gravidade, mensagem, mensagem, cause);
    }
}

package kuboys.enums;

public enum EnumStatusPedido {

    EM_ABERTO("AB", "Em aberto"),
    EM_PRODUCAO("PR", "Em produção"),
    FINALIZADO("FI", "Finalizado"),
    CANCELADO("CA", "Cancelado");

    private String codigo;
    private String descricao;

    EnumStatusPedido(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static EnumStatusPedido getPorCodigo(String codigo) {
        for (EnumStatusPedido tipo : values()) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}

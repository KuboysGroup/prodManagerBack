package kuboys.services;

import kuboys.enums.*;
import kuboys.exceptions.GestException;
import kuboys.enums.*;
import kuboys.models.*;
import kuboys.models.*;

import java.io.*;
import java.util.*;
public class PedidoService {
    public static List<Material> materialList = new ArrayList<>();
    public static List<Componente> componentsList = new ArrayList<>();
    public static List<ProdutoPedido> produtosList = new ArrayList<>();

    public static HashMap<Integer, PedidoMoldes> pedidosMoldeMap = new HashMap<>();
    public static HashMap<Integer, PedidoFerramentas> pedidosFerramentasMap = new HashMap<>();
    public static HashMap<Integer, PedidoSistemaCamaraQuente> pedidosSistemaCamaraQuenteMap = new HashMap<>();

    private static Integer id = 0;

    private static <T> void validarListaNaoVazia(List<T> lista, String mensagemErro) {
        if (lista == null || lista.isEmpty()) {
            throw new GestException(EnumGravidadeException.INFO, mensagemErro);
        }
    }

    public static List<Material> obterListaMateriais() {
        validarListaNaoVazia(materialList, "Não há registro de materiais");
        return new ArrayList<>(materialList);
    }

    public static List<Componente> obterListaComponentes() {
        validarListaNaoVazia(componentsList, "Não há registro de componentes");
        return new ArrayList<>(componentsList);
    }

    public static List<ProdutoPedido> obterListaProdutos() {
        validarListaNaoVazia(produtosList, "Não há registro de produtos");
        return new ArrayList<>(produtosList);
    }

    public static List<PedidoMoldes> obterListaPedidosMolde() {
        validarListaNaoVazia(new ArrayList<>(pedidosMoldeMap.values()), "Não há registro de pedidos");
        return new ArrayList<>(pedidosMoldeMap.values());
    }

    public static PedidoMoldes getPedidoMoldeById(Integer id) {
        return Optional.ofNullable(pedidosMoldeMap.get(id))
                .orElseThrow(() -> new GestException(EnumGravidadeException.INFO, "Id inválido"));
    }

    public static List<PedidoFerramentas> obterListaPedidosFerramentas() {
        validarListaNaoVazia(new ArrayList<>(pedidosFerramentasMap.values()), "Não há registro de pedidos");
        return new ArrayList<>(pedidosFerramentasMap.values());
    }

    public static PedidoFerramentas getPedidoFerramentasById(Integer id) {
        return Optional.ofNullable(pedidosFerramentasMap.get(id)).orElseThrow(() -> new GestException(EnumGravidadeException.INFO, "Id inválido"));
    }

    public static List<PedidoSistemaCamaraQuente> obterListaPedidosSistemaCamaraQuente() {
        validarListaNaoVazia(new ArrayList<>(pedidosSistemaCamaraQuenteMap.values()), "Não há registro de pedidos");
        return new ArrayList<>(pedidosSistemaCamaraQuenteMap.values());
    }

    public static PedidoSistemaCamaraQuente getPedidoSistemaCamaraQuenteById(Integer id) {
        return Optional.ofNullable(pedidosSistemaCamaraQuenteMap.get(id)).orElseThrow(() -> new GestException(EnumGravidadeException.INFO, "Id inválido"));
    }

    public static Integer getProximoPedidoId() {
        return ++id;
    }

    public static void alterarQuantMaterial(Boolean entrada, String nomeMaterial, Integer quant) {
        for (Material mat : materialList) {
            if (mat.getNome().equals(nomeMaterial)) {
                if (entrada) {
                    mat.setQuantEstoque(quant);
                } else {
                    if (mat.getQuantEstoque() - quant < 0) {
                        throw new GestException(EnumGravidadeException.INFO, "A quantidade de retirada é superior ao saldo do material no estoque");
                    }
                    mat.setQuantEstoque(mat.getQuantEstoque() - quant);
                }
            }
        }
    }


    public static void alterarQuantComponente(Boolean entrada, String nomeComponente, Integer quant) {
        for (Componente comp : componentsList) {
            if (comp.getNome().equals(nomeComponente)) {
                if (entrada) {
                    comp.setQuantEstoque(comp.getQuantEstoque() + quant);
                } else {
                    if (comp.getQuantEstoque() - quant < 0) {
                        throw new GestException(EnumGravidadeException.INFO, "A quantidade de retirada é superior ao saldo do componente no estoque");
                    }
                    comp.setQuantEstoque(comp.getQuantEstoque() - quant);
                }
            }
        }
    }


//    public static void adicionarProdutoPedido(Integer pedidoId, Produto produto, int quantidade) {
//        Pedido pedido = getPedidoById(pedidoId);
//        pedido.getProdutos().add(new ProdutoPedido(produto, quantidade));
//    }
//
//
//    public static void removerProdutoPedido(Integer pedidoId, String nomeProduto) {
//        Pedido pedido = getPedidoById(pedidoId);
//        pedido.getProdutos().removeIf(prod -> prod.getProduto().getNome().equals(nomeProduto));
//    }


    public static String gerarRelatorioEstoque() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Estoque:\n\nMateriais:\n");
        for (Material mat : materialList) {
            relatorio.append(mat.getNome()).append(": ").append(mat.getQuantEstoque()).append("\n");
        }
        relatorio.append("\nComponentes:\n");
        for (Componente comp : componentsList) {
            relatorio.append(comp.getNome()).append(": ").append(comp.getQuantEstoque()).append("\n");
        }
        return relatorio.toString();
    }

    public static void gerarRegistrosDeTeste() {
        System.out.println("Entrou no gerar registros teste");
        Data dataFutura = new Data(Data.hoje().getDia()+3, Data.hoje().getMes()+1, Data.hoje().getAno());

        Material material1 = new Material("Aço", 100);
        Material material2 = new Material("Alumínio", 200);
        Material material3 = new Material("Cobre", 150);
        Material material4 = new Material("Borracha", 234);
        Material material5 = new Material("Areia", 500);

        materialList.addAll(Arrays.asList(material1, material2, material3, material4, material5));

        Componente componente1 = new Componente("Parafuso", Arrays.asList(material1), 500);
        Componente componente2 = new Componente("Porca", Arrays.asList(material2), 300);
        Componente componente3 = new Componente("Arruela", Arrays.asList(material3), 400);

        componentsList.addAll(Arrays.asList(componente1, componente2, componente3));

        SistemaCamaraQuente sistema1 = new SistemaCamaraQuente("Sistema A", new Dimensoes(10.0, 5.0, 2.0), true, 12, material1, 200.0);
        SistemaCamaraQuente sistema2 = new SistemaCamaraQuente("Sistema B", new Dimensoes(12.43, 10.0, 3.0), true, 3, material2, 133.0);
        Ferramenta ferramenta1 = new Ferramenta("Ferramenta B", new Dimensoes(15.0, 7.5, 3.0), false, 43, EnumTipoFerramenta.BROCA, material2, material3, "Uso Geral");
        Ferramenta ferramenta2 = new Ferramenta("Ferramenta A", new Dimensoes(4.0, 73.5, 12.0), false, 21, EnumTipoFerramenta.CABECOTE, material4, material3, "Uso Geral");
        Molde molde1 = new Molde("Molde C", new Dimensoes(20.0, 10.0, 4.0), true, 3, EnumTipoInjecao.ALUMINIO, EnumRamoProduto.AUTOMOTIVO, Arrays.asList(componente1, componente2));

        PedidoFerramentas pedidoFerramentas1 = new PedidoFerramentas(Data.hoje(), dataFutura, EnumStatusPedido.EM_ABERTO, Arrays.asList(ferramenta1, ferramenta2));
        PedidoFerramentas pedidoFerramentas2 = new PedidoFerramentas(Data.hoje(), dataFutura, EnumStatusPedido.EM_ABERTO, Arrays.asList(ferramenta2));
        PedidoMoldes pedido2 = new PedidoMoldes(Data.hoje(), dataFutura, EnumStatusPedido.EM_ABERTO, Arrays.asList(molde1));
        PedidoSistemaCamaraQuente pedidoSistema1 = new PedidoSistemaCamaraQuente(Data.hoje(), dataFutura, EnumStatusPedido.EM_PRODUCAO, Arrays.asList(sistema1, sistema2));

        pedidosFerramentasMap.put(pedidoFerramentas1.getId(), pedidoFerramentas1);
        pedidosFerramentasMap.put(pedidoFerramentas2.getId(), pedidoFerramentas2);
        pedidosMoldeMap.put(pedido2.getId(), pedido2);
        pedidosSistemaCamaraQuenteMap.put(pedidoSistema1.getId(), pedidoSistema1);

        System.out.println("TERMINOU DE gerar registros teste");
    }

    public static String gerarTesteComRetorno(){
        String retorno = "Lista vazia, nao criou pedidos";
        gerarRegistrosDeTeste();
        List<PedidoMoldes> pedList = obterListaPedidosMolde();

        if (!pedList.isEmpty()){
            System.out.println("Lista de pedidos size: " + pedList.size());
            Pedido ped = pedList.get(0);
            retorno = "pedidos de teste foram criados com sucesso. pedido id: " + ped.getId().toString();
        }
        System.out.println("Lista de pedidos size: " + pedList.size());

        return retorno;
    }

}

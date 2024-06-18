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
    public static HashMap<Integer, Pedido> pedidosMap = new HashMap<>();
    private static Integer id = 0;

    public static void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.ser"))) {
            oos.writeObject(materialList);
            oos.writeObject(componentsList);
            oos.writeObject(produtosList);
            oos.writeObject(pedidosMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.ser"))) {
            materialList = (List<Material>) ois.readObject();
            componentsList = (List<Componente>) ois.readObject();
            produtosList = (List<ProdutoPedido>) ois.readObject();
            pedidosMap = (HashMap<Integer, Pedido>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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

    public static List<Pedido> obterListaPedidos() {
        validarListaNaoVazia(new ArrayList<>(pedidosMap.values()), "Não há registro de pedidos");
        return new ArrayList<>(pedidosMap.values());
    }

    public static Pedido getPedidoById(Integer id) {
        return Optional.ofNullable(pedidosMap.get(id))
                .orElseThrow(() -> new GestException(EnumGravidadeException.INFO, "Id inválido"));
    }


    public static Integer getProximoPedidoId() {
        return ++id;
    }

    public static void alterarQuantMaterial(Boolean entrada, String nomeMaterial, Integer quant) {
        for (Material mat : materialList) {
            if (mat.getNome().equals(nomeMaterial)) {
                if (entrada) {
                    mat.setQuantEstoque(mat.getQuantEstoque() + quant);
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


    public static void adicionarProdutoPedido(Integer pedidoId, Produto produto, int quantidade) {
        Pedido pedido = getPedidoById(pedidoId);
        pedido.getProdutos().add(new ProdutoPedido(produto, quantidade));
    }


    public static void removerProdutoPedido(Integer pedidoId, String nomeProduto) {
        Pedido pedido = getPedidoById(pedidoId);
        pedido.getProdutos().removeIf(prod -> prod.getProduto().getNome().equals(nomeProduto));
    }


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
        Data dataFutura = new Data(Data.hoje().getDia()+3, Data.hoje().getMes()+1, Data.hoje().getAno());

        Material material1 = new Material("Aço", 100);
        Material material2 = new Material("Alumínio", 200);
        Material material3 = new Material("Cobre", 150);

        materialList.addAll(Arrays.asList(material1, material2, material3));

        Componente componente1 = new Componente("Parafuso", Arrays.asList(material1), 500);
        Componente componente2 = new Componente("Porca", Arrays.asList(material2), 300);
        Componente componente3 = new Componente("Arruela", Arrays.asList(material3), 400);

        componentsList.addAll(Arrays.asList(componente1, componente2, componente3));

        SistemaCamaraQuente produto1 = new SistemaCamaraQuente("Sistema A", new Dimensoes(10.0, 5.0, 2.0), true, material1, 200.0);
        Ferramenta produto2 = new Ferramenta("Ferramenta B", new Dimensoes(15.0, 7.5, 3.0), false, EnumTipoFerramenta.BROCA, material2, material3, "Uso Geral");
        Molde produto3 = new Molde("Molde C", new Dimensoes(20.0, 10.0, 4.0), true, EnumTipoInjecao.ALUMINIO, EnumRamoProduto.AUTOMOTIVO, Arrays.asList(componente1, componente2));

        produtosList.addAll(Arrays.asList(
                new ProdutoPedido(produto1, 10),
                new ProdutoPedido(produto2, 5),
                new ProdutoPedido(produto3, 2)
        ));

        Pedido pedido1 = new Pedido(Arrays.asList(
                new ProdutoPedido(produto1, 10),
                new ProdutoPedido(produto2, 5)
        ), Data.hoje(), dataFutura, EnumStatusPedido.EM_ABERTO);

        Pedido pedido2 = new Pedido(Arrays.asList(
                new ProdutoPedido(produto3, 2)
        ), Data.hoje(), dataFutura, EnumStatusPedido.EM_ABERTO);

        pedidosMap.put(pedido1.getId(), pedido1);
        pedidosMap.put(pedido2.getId(), pedido2);
    }
}

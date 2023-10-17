import java.util.Scanner;

public class RelatorioTransporte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] produtos = {"Celular", "Geladeira", "Air Fryer", "Cadeira", "Luminária", "Lavadora de roupa", "PlayStation 5", "Nintendo Switch"};
        double[] pesos = {0.7, 50.0, 3.5, 5.0, 0.8, 15.0, 3.9, 0.3};

        String[] modalidades = {"Aéreo", "Rodoviário", "Marítimo"};
        double[] custoKmPorPeso = {0.2, 0.1, 0.05};

        int numTransportes = 0;
        double custoTotal = 0;
        double pesoTotal = 0;
        double custoMedioKm = 0;

        System.out.println("Insira os dados de transporte (nome do produto, quantidade, modalidade):");
        while (true) {
            System.out.print("Nome do produto (ou 'fim' para encerrar): ");
            String produto = scanner.nextLine().toUpperCase(); // Converter para maiúsculas

            if (produto.equalsIgnoreCase("FIM")) {
                break;
            }

            int indexProduto = -1;
            for (int i = 0; i < produtos.length; i++) {
                if (produtos[i].equalsIgnoreCase(produto)) {
                    indexProduto = i;
                    break;
                }
            }

            if (indexProduto == -1) {
                System.out.println("Produto não encontrado na lista. Verifique a ortografia.");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            int indexModalidade = -1;
            System.out.print("Modalidade (Aéreo, Rodoviário, Marítimo): ");
            String modalidade = scanner.nextLine();
            for (int i = 0; i < modalidades.length; i++) {
                if (modalidades[i].equalsIgnoreCase(modalidade)) {
                    indexModalidade = i;
                    break;
                }
            }

            if (indexModalidade == -1) {
                System.out.println("Modalidade inválida. Use Aéreo, Rodoviário ou Marítimo.");
                continue;
            }

            double pesoProduto = pesos[indexProduto];
            double pesoTotalTransportado = pesoProduto * quantidade;
            
            double custoTransporte = custoKmPorPeso[indexModalidade] * pesoTotalTransportado;
            custoTotal += custoTransporte;
            pesoTotal += pesoTotalTransportado;
            numTransportes++;

            System.out.println("Custo do transporte: R$" + custoTransporte + "\n");
        }

        if (pesoTotal > 0) {
            custoMedioKm = custoTotal / pesoTotal;
        }
        
        System.out.println("\nRelatório de Transporte:");
        System.out.println("Custo total de transporte: R$" + custoTotal);
        System.out.println("Custo médio por km: R$" + custoMedioKm);
        System.out.println("Número total de transportes: " + numTransportes);
        System.out.println("Peso total transportado: " + pesoTotal + " kg");
    }
}

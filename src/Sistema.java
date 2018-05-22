
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fsens
 */
public class Sistema {

    String[] nomes = new String[100];
    String[] cnpjs = new String[100];
    String[] ramos = new String[100];
    int[] quantidadeFuncionarios = new int[100];
    String[] inscricoesEstadual = new String[100];
    double[] faturamentos = new double[100];
    double[] lucros = new double[100];
    double[] despesas = new double[100];
    boolean[] ativos = new boolean[100];
    int ultimo = 0;

    public void cadastrarEmpresa() {
        solicitarInformacoes(ultimo);
        ultimo++;
    }

    public void listarEmpresas() {
        String texto = "";
        if (ultimo > 0) {
            for (int posicao = 0; posicao < ultimo; posicao++) {
                texto += nomes[posicao] + "\n";
            }
        } else {
            texto = "Nenhuma empresa está cadastrada!";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    

    public void editarEmpresa() {
        
        Object[] nomesEmpresas = new Object[ultimo];
        for (int i = 0; i < ultimo; i++) {
            nomesEmpresas[i] = nomes[i];
        }

        int posicao = JOptionPane.showOptionDialog(null,
                ultimo > 0 ? "Selecione a empresa para editar"
                        : "Nenhuma empresa cadastrada",
                "Aviso",
                0, JOptionPane.QUESTION_MESSAGE, null, nomesEmpresas, "");
        if (posicao != JOptionPane.CLOSED_OPTION) {
            solicitarInformacoes(posicao);
            
        }
    }



    private void solicitarInformacoes(int posicao) {
        nomes[posicao] = (JOptionPane.showInputDialog("Digite o nome da sua empresa",
                nomes[posicao] != null ? nomes[posicao] : ""));

        while (nomes[posicao].trim().equals("") 
                || nomes[posicao].trim().length() < 4) {
            JOptionPane.showMessageDialog(null,
            "O nome deve conter no mínimo 4 caracteres");
            nomes[posicao] = JOptionPane.showInputDialog(
            "Digite o nome da sua empresa novamente",
            nomes[posicao] != null ? nomes[posicao] : "");

        }

        ramos[posicao] = JOptionPane.showInputDialog(null, "Selecione o tipo da sua empresa", "GeraEmpresa", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"TI", "Comércio", "Financeiro", "Hospitalar"},
                ramos[posicao] != null ? ramos[posicao] : "TI").toString();
        cnpjs[posicao] = (JOptionPane.showInputDialog("Digite o seu CNPJ",
                cnpjs[posicao] != null ? cnpjs[posicao] : ""));

        lucros[posicao] = Double.parseDouble(
                JOptionPane.showInputDialog("Digite o seu lucro",
                        lucros[posicao] != 0 ? lucros[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );

        despesas[posicao] = Double.parseDouble(JOptionPane.showInputDialog("Digite a sua despesa",
                despesas[posicao] != 0 ? despesas[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );
        faturamentos[posicao] = Double.parseDouble(JOptionPane.showInputDialog("Digite o seu faturamento",
                faturamentos[posicao] != 0 ? faturamentos[posicao] : 0)
                .replace(" ", "").replace("R$", "")
                .replace(".", "").replace(",", ".")
        );
        inscricoesEstadual[posicao] = JOptionPane.showInputDialog("Digite a sua IE",
                inscricoesEstadual[posicao] != null ? inscricoesEstadual[posicao] : "");
    }
}

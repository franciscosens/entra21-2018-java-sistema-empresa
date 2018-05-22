
import javax.swing.JOptionPane;

/**
 *
 * @author fsens
 */
public class Menu {

    private Sistema sistema = new Sistema();

    private int apresentarMenu() {
        int menu = JOptionPane.showOptionDialog(null, "MENU DO SISTEMA", "GeraEmpresa", 0, 0,
                null, new Object[]{
                    "Listar", "Cadastrar", "Editar", "Sair"
                }, "Listar"
        );
        return menu;
    }

    public void gerirMenu() {
        int menu = apresentarMenu();
        while (menu != 3) {
            switch (menu) {
                case 0: sistema.listarEmpresas(); break;
                case 1: sistema.cadastrarEmpresa(); break;
                case 2: sistema.editarEmpresa(); break;
            }
            menu = apresentarMenu();
        }
    }

}

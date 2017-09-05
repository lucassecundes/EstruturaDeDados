package AulaExercicios;


public class Fila {

    public tipoNo cabeca;

    Fila() {
        System.out.println("Criando fila...(construtor fila)");
    }

    public void insereFinal(int info) {
        if (cabeca == null) {
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(null);
        } else {
            tipoNo aux, novo;

            //Caixa Nova
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(null);

            //Indo ate o ultimo			
            aux = cabeca;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            //Ajustando o apontador do ultimo
            aux.setProx(novo);
        }

        System.out.println("Elemento " + info + " inserido com sucesso! ");
    }

    public void removeInicio() {
        if (cabeca != null) {
            int valor = cabeca.getInfo();
            System.out.println("Elemento " + valor + " removido com sucesso! ");
            cabeca = cabeca.getProx();
        }
    }

    public void insereInicio(int info) {
        if (cabeca == null) {
            cabeca = new tipoNo();
            cabeca.setInfo(info);
            cabeca.setProx(null);
        } else {
            tipoNo novo;
            novo = new tipoNo();
            novo.setInfo(info);
            novo.setProx(cabeca);
            cabeca = novo;
        }
        System.out.println("Elemento " + info + "inserido");
    }

    public void removeFinal() {

    }
    public void removenesimo(int n){
        
            //se o cabeca ta nulo
        if(cabeca == null){
            System.out.println("Lista vazia");
        }else {
            //remocao do primeiro
            int valor;
            if(n==1){
                valor = cabeca.getInfo();
                cabeca = cabeca.getProx();
                System.out.println("Valor "+valor+" Removido ");
            }else {
                //remocao do segundo
                int pos=1;
                tipoNo aux;
                aux = cabeca;
                
                while(aux.getProx()!=null && pos != n-1){
                    aux= aux.getProx();
                    pos++;
                }
                //remocao do terceiro
                if(aux.getProx()!=null){
                valor = aux.getProx().getInfo();
                aux.setProx(aux.getProx().getProx());
                System.out.println("Valor "+valor+" Removido ");
            }else{
                    System.out.println("Posicao inexistente");
                }
           }
        }
        
    }
    public void imprime() {
        tipoNo aux = cabeca;
        System.out.println("Impressao: ");
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println("");
    }

    public void menu() {
        int valor, opcao = 0, n;
        System.out.print("\n------------ Menu ------------\n");
        while (opcao != -1) {
            opcao = Input.readInt("\nDigite a opcao: \n(1) Insere Inicio \n(2) Insere Fim \n(3) Remove Inicio \n(4) Remove Fim \n(5) Imprime\n(6) Remove n-esimo\n(-1) Sair \nOpcao: ");
            switch (opcao) {

                case 1: //insereInicio
                    valor = Input.readInt("Valor: ");
                    insereInicio(valor);
                    break;

                case 2: //insereFinal
                    valor = Input.readInt("Valor: ");
                    insereFinal(valor);
                    break;

                case 3: //removeInicio
                    removeInicio();
                    break;

                case 4: //removeFinal
                    removeFinal();
                    break;

                case 5: //imprime
                    imprime();
                    break;
               
                case 6:
                    n = Input.readInt("Digite o n-esimo: ");
                    removenesimo(n);
                    break;
                    
                case -1: //sair
                    System.out.println("Saindo!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;

            }

        }
    }

    public static void main(String args[]) {
        System.out.println("\n************ Lista Encadeada Din�mica ************\n");
        Fila F = new Fila();
        F.menu();
        System.out.println("\n************ Fim programa ************\n");
    }
}

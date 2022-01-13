package PackageClasses;

public class Estudante extends Pessoa{
    private float nota;
    private Pagamento mensalidade = Pagamento.PENDENTE;

    public Estudante(String nome, String endereco, int idade, float nota){
        super(nome, idade, endereco);
        setNota(nota);
    }

    public void setNota(float nota){
        this.nota = nota;
    }

    public float getNota(){
        return nota;
    }

    public String getMensalidade(){
        return mensalidade.toString();
    }

    public int pagarMensalidade(double valor){
        if(valor >= 200){
            mensalidade = Pagamento.PAGO;
            return 1;
        }
        return 0;
    }
}
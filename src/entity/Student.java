package entity;

public class Student extends Person{
    private float nota;
    private Payment mensalidade = Payment.PENDENTE;

    public Student(String nome, String endereco, int idade, float nota){
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
            mensalidade = Payment.PAGO;
            return 1;
        }
        return 0;
    }
}
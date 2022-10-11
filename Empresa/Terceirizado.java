public class Terceirizado extends Empregado {
    private Double despesaAdicional;

    public Terceirizado(String nome, Integer horas,
            Double valorPorHora, Double despesaAdicional) {
        setHoras(horas);
        setNome(nome);
        setValorPorHora(valorPorHora);
        this.despesaAdicional = despesaAdicional;
    }

    public Double getDespesaAdicional() {
        return despesaAdicional;
    }

    public void setDespesaAdicional(Double despesaAdicional) {
        this.despesaAdicional = despesaAdicional;
    }

    @Override
    public Double pagamento() {
        return (despesaAdicional*1.1) + super.pagamento();
    }

    @Override
    public String toString() {
        return super.toString() + ", Despesa adicional: " + despesaAdicional;
    }
}
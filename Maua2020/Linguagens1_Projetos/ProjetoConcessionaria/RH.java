public class RH {
    private static double totalDeVendas;
    public static void rodarRh(){
        Gerente g1, g2;
        Vendedor v1, v2;
        totalDeVendas = 1000;
        g1 = new Gerente(1000);
        v1 = new Vendedor(1000, g1);
        exibirSalarioFinal(totalDeVendas, g1);
        exibirSalarioFinal(totalDeVendas, v1);
        if(g1.darAumento(v1, 0.1))
            System.out.println("Aumento Deu Certo!");
        exibirSalarioFinal(totalDeVendas, v1);
    }
    public static void exibirSalarioFinal(double totalDeVendas, Funcionario funcionario){
        System.out.println("Salário final: "+funcionario.getSalarioFinal(totalDeVendas));
    }
    /**
     * @return the totalDeVendas
     */
    public static double getTotalDeVendas() {
        return totalDeVendas;
    }
}
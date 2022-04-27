package cn.zxc.demo18Graph;

public class EquationPossible {

    public static void main(String[] args) {
        EquationPossible eq = new EquationPossible();
        System.out.println(eq.equationsPossible(new String[]{"c==c","b==d","x!=z"}));
    }

    boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for(String equation : equations) {
            if(equation.charAt(1) == '=') {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for(String equation : equations) {
            if(equation.charAt(1) == '!') {
                if(uf.connect(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }
}

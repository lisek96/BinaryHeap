public class TreeNode {
    String label;
    String code = "";

    TreeNode(String label){
        this.label=label;
        code = "";
    }

    TreeNode(String label, String code){
        this.label=label;
        this.code=code;
    }

    public String toString(){
        return label;
    }


}

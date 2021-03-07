public class BH_Node {
    int index;
    int value;
    String label;
    BH_Node(String label, int value, int index){
        this.value=value;
        this.label=label;
        this.index=index;
    }
    public String toString(){
        return label + " " + value;
    }
}

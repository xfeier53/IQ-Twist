package comp1110.ass2;

// I use this to do some experiments
// Will delete it later
public class test {
    public static void main(String[] args) {
        Node[][] nodes = new Node[4][8];
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                nodes[i][j] = new Node(0, null, null);
            }
        }
        System.out.println(nodes[0][1]);
    }
}

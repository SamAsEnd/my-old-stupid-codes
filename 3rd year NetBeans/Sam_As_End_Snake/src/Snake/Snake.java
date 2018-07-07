package Snake;
import javax.swing.JFrame;
public class Snake extends JFrame{
    private final int OFFSET = 30;
    public Snake() {
        InitUI();
    }

    public void InitUI() {
        Board board = new Board();
        add(board);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2 * OFFSET);
        setLocationRelativeTo(null);
        setTitle("Sokoban");
    }

    public static void main(String[] args) {
        Snake snake = new Snake();
        snake.setVisible(true);
    }
}

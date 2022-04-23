import java.util.Arrays;
import java.util.Objects;

public class Maze {
    private final String [][] maze = {
            {"-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", " ", " ", " ", "-", "-", " ", "-", "-"},
            {"-", "A", "-", " ", "-", "-", " ", "-", "-"},
            {"-", "-", "-", " ", "-", " ", " ", " ", "-"},
            {"-", " ", " ", " ", " ", " ", "-", " ", "-"},
            {"-", " ", "-", " ", "-", "-", "-", " ", "-"},
            {"-", "-", "-", " ", "-", "-", "-", " ", "-"},
            {"-", "-", "-", "-", "-", " ", " ", " ", "-"},
            {"-", "-", "-", "-", "-", " ", "-", "-", "-"},
            {"-", "-", "-", " ", " ", " ", " ", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", " ", "-", "-"},
            {"-", "-", "-", "B", "-", " ", " ", " ", "-"},
            {"-", "-", " ", " ", " ", " ", "-", " ", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-"},
    };

    ArrayStack lastPos = new ArrayStack(1,0);
    ArrayStack line = new ArrayStack(1,0);
    ArrayStack column = new ArrayStack(1,0);






    public void andaPeloLabirinto() {

        setpointA();

        while (!findpointB()) {
            tailTrack();
            System.out.println("\n");
            System.out.println("Y: " + line);
            System.out.println("X: " + column);
            System.out.println("\n");
            printMaze();


            if ((maze[line.lastPos() - 1][column.lastPos()] == " ") || (maze[line.lastPos() - 1][column.lastPos()] == "B")) {
                var posicao = maze[line.lastPos() - 1][column.lastPos()];
                line.push(line.lastPos() - 1);
                lastPos.push(0);

            }


            else if ((maze[line.lastPos()][column.lastPos() - 1] == " ") || (maze[line.lastPos()][column.lastPos() - 1] == "B")) {
                var posicao = maze[line.lastPos()][column.lastPos() - 1];
                column.push(column.lastPos() - 1);
                lastPos.push(3);
            }


            else if ((maze[line.lastPos() + 1][column.lastPos()] == " ") || (maze[line.lastPos() + 1][column.lastPos()] == "B")) {
                var posicao = maze[line.lastPos() + 1][column.lastPos()];
                line.push(line.lastPos() + 1);
                lastPos.push(2);
            }


            else if ((maze[line.lastPos()][column.lastPos() + 1] == " ") || (maze[line.lastPos()][column.lastPos() + 1] == "B")) {
                var posicao = maze[line.lastPos()][column.lastPos() + 1];
                column.push(column.lastPos() + 1);
                lastPos.push(1);

            }


            else {
                switch (lastPos.lastPos()) {

                    case 0:
                        line.pop();
                        lastPos.pop();
                        break;

                    case 1:
                        lastPos.pop();
                        column.pop();
                        break;

                    case 2:
                        lastPos.pop();
                        line.pop();
                        break;

                    case 3:
                        column.pop();
                        lastPos.pop();
                        break;
                }
            }
        }
    }





    public boolean findpointB() {
        if (Objects.equals(maze[line.lastPos()][column.lastPos()], "B")) {
            System.out.println("\nMaze can be solved\n");
            return true;
        }
        else if (line.isEmpty() || column.isEmpty()) {
            System.out.println("\nMaze can't be solved\n");
            return true;
        }
        return false;
    }





    public void setpointA() {

        line.push(1);
        column.push(1);
        lastPos.push(0);

        System.out.println("\nStart\n");

    }





    public void tailTrack() {
        maze[line.lastPos()][column.lastPos()] = "#";
    }





    public void printMaze() {
        for (String[] strings : maze) {

            String MyString = Arrays.toString(strings);
            MyString = MyString.replace(",", " ");
            System.out.println(MyString);
        }
    }
}

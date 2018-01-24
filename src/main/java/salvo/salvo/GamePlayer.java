package salvo.salvo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private int state;

    public static final int notStarted = 0;
    public static final int isStarted = 1;
    public static final int isFinished = 2;

    public Date startTime;
    public Date endTime;

    public String stateText;

    public GamePlayer() { }

    public void updateGameCurrentState()
    {
        if (this.endTime != null && this.startTime != null) {
            this.state = 2;
            this.stateText = "Game Has Finished";


            System.out.println("Game Has Finished");
            System.out.println(this.startTime.toString());
            System.out.println(this.endTime.toString());

        } else if (this.startTime != null) {
            this.state = 1;
            this.stateText = "Game Has Started";

            System.out.println("Game Has Started");
            System.out.println(this.startTime.toString());

        } else {
            this.state = 0;
            this.stateText = "Game Has Not Started";

            System.out.println("Game Has Not Started");
        }
    }

    public void startGame() {
        Date currentTime = new Date();
        this.startTime = currentTime;
    }

    public void shiftGame(int milSec) {
        this.endTime = Date.from(this.startTime.toInstant().plusSeconds(milSec));
    }

    public void endGame() {
        Date currentTime = new Date();
        this.endTime = currentTime;
    }
    /*
    private void
        list.add(dateTime);
        elif (this.state = 2)
        list.add("");
        ;
    }

    public <KEY, Date, Date> List<KEY, Date, Date> getList()
    {
        Object o = getObj(state);
        if ( ! (o instanceof List) ) throw new RuntimeException("Not a list value");
        List l = (List)o;
        if ( l.size() > 0 && !elementClass.isAssignableFrom( l.get(0) ) ) throw new RuntimeException("List element not valid type");

        return (List<E>)l;
    }

    public Date   {
        return this.dateTime;
    }
    */
}

package temp;

public abstract class AbstractCommandFactory<D> {
    abstract D CreateCommand(CommandArgs<D> args);
}

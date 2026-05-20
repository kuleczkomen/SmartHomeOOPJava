package command;

public class CommandRunner {

    private ICommand lastCommand;

    public void executeCommand(ICommand command) {
        command.execute();
        this.lastCommand = command;
    }

    public void undoLastAction() {
        if (lastCommand != null) {
            lastCommand.undo();
            lastCommand = null;
        } else {
            System.out.println("Brak akcji do cofnięcia lub już cofnięto!");
        }
    }

}

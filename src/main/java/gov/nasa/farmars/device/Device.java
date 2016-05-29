package gov.nasa.farmars.device;

import java.util.Stack;

import gov.nasa.farmars.command.Command;

public class Device {

    private String id;
    private DeviceType type;
    private DeviceState state;

    private Stack<Command> commands;

    public Device(String id, DeviceType type) {
        this.id = id;
        this.type = type;
        this.state = DeviceState.OFF;
        this.commands = new Stack<Command>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public DeviceState getState() {
        return state;
    }

    public void setState(DeviceState state) {
        this.state = state;
    }

    public void addCommand(Command command) {
        commands.push(command);
    }

    public Command getNextCommand() {
        if (commands.empty())
            return null;

        return commands.pop();
    }

}

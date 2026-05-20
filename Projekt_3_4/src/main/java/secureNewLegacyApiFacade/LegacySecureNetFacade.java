package secureNewLegacyApiFacade;

import secureNetLegacyApi.*;

public class LegacySecureNetFacade implements ISecuritySystem {

    private String ipAddress = "192.168.1.100";
    private int port = 9090;

    private String username = "admin";
    private String pin = "1234";

    private void run(byte b1, byte b2) {

        ConnectionNode connectionNode = new ConnectionNode(ipAddress, port);
        SessionToken token = null;

        try {
            connectionNode.handshake();

            String hash = CryptoHelper.hash(username, pin);
            AuthTokenGenerator authTokenGenerator = new AuthTokenGenerator();
            token = authTokenGenerator.generateToken(hash);

            EventBusController controller = new EventBusController(connectionNode);
            controller.registerSession(token);
            controller.subscribeToChannel(4);

            PacketBuilder builder = new PacketBuilder();

            builder.appendByte(b1);
            builder.appendByte(b2);

            byte[] packet = builder.getCompiledPacket();

            LegacyCommand command = new LegacyCommand(packet);

            controller.dispatch(command);
        } finally {
            connectionNode.closeConnection();
            token.invalidateToken();
        }
    }

    @Override
    public void armAlarm() {
        run((byte) 0x01, (byte) 0xFF);
    }

    @Override
    public void checkSmokeSensor() {
        run((byte) 0x02, (byte) 0x00);
    }
}

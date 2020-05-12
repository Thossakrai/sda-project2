package Server;

public class ServerFactory implements IServerFactory {
    private AuctionServer server = null;

    @Override
    public void create() {
        server = (AuctionServer) AuctionServer.getAuctionServer();
    }

    @Override
    public AuctionServer getInstance() {
        return server;
    }
}

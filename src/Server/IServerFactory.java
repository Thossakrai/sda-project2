package Server;

public interface IServerFactory extends IAuctionServer {
    void create();
    AuctionServer getInstance();
}

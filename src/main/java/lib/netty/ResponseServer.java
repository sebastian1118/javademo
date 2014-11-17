package lib.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.HashMap;

/**
 * Discards any incoming data.
 */
public class ResponseServer {

	public static HashMap<String, Channel> map = new HashMap<>();

	private int port;

	public ResponseServer(int port) {

		this.port = port;
	}

	public void run() throws InterruptedException {

		EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap(); // (2)
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class) // (3)
					.childHandler(new ChannelInitializer<SocketChannel>() { // (4)

						@Override
						public void initChannel(SocketChannel ch) throws Exception {

							ch.pipeline().addLast(new ResponseServerHandler());
						}
					})
					.option(ChannelOption.SO_BACKLOG, 128)          // (5)
					.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

			// Bind and start to accept incoming connections.
			ChannelFuture f = b.bind(port).sync(); // (7)

			// Wait until the server socket is closed.
			// In this example, this does not happen, but you can do that to gracefully
			// shut down your server.
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {

//		new Thread(() -> {
//			try {
//				new ResponseServer(10000).run();
//			} catch(InterruptedException ignored) {
//			}
//		}).start();

		new Thread(() -> {
			try {
				new CommandServer(10001).run();
			} catch(InterruptedException ignored) {
			}
		}).start();

	}
}

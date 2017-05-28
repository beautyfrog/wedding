package summerlee.wedding.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

/**
 * 推送连接配置
 * 
 * @file SocketConfigurator
 * @author libin
 * @Create 2017-03-02
 */

public class WeddingSocketConfigurator extends Configurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, 
			HandshakeRequest request, HandshakeResponse response) {
		super.modifyHandshake(sec, request, response);
		// 设置与HttpSession 
		sec.getUserProperties().put(HttpSession.class.getName(), request.getHttpSession());
	}
}
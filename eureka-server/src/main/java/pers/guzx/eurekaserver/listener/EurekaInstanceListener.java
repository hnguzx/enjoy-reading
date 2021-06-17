package pers.guzx.eurekaserver.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/1 11:10
 * @describe
 */
@Slf4j
@Component
public class EurekaInstanceListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.info(event.getServerId() + "\t" + event.getAppName() + "：服务下线");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info(instanceInfo.getAppName() + "：服务注册");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.info(event.getServerId() + "\t" + event.getAppName() + "：服务续约");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("Eureka注册中心启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("Eureka Server启动");
    }
}

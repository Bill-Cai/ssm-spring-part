package org.example.ioc_01;

/**
 * @since: 2025/4/25 16:38
 * @author: qm
 * @description:
 */
public class DefaultServiceLocator {
    private static ClientServiceImpl clientService = new ClientServiceImpl();

    public ClientServiceImpl createClientServiceInstance() {
        return clientService;
    }
}

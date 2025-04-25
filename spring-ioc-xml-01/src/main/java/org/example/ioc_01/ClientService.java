package org.example.ioc_01;

/**
 * @since: 2025/4/25 16:02
 * @author: qm
 * @description:
 */
public class ClientService {
    private static ClientService clientService = new ClientService();

    private ClientService() {
    }

    public static ClientService createInstance() {
        return clientService;
    }
}
